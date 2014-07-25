package com.ishangke.edunav.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;

import net.spy.memcached.CASMutation;
import net.spy.memcached.CASMutator;
import net.spy.memcached.transcoders.SerializingTranscoder;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.mapper.RoleEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.common.SessionConfig.ACConfig;
import com.ishangke.edunav.manager.common.SessionConfig.ACConfigObj;
import com.ishangke.edunav.manager.common.SessionConfig.AuthConfig;
import com.ishangke.edunav.manager.common.SessionConfig.AuthConfigObj;
import com.ishangke.edunav.manager.common.SessionConfig.CellVerificationConfig;
import com.ishangke.edunav.manager.common.SessionConfig.CellVerificationConfigObj;
import com.ishangke.edunav.manager.common.SessionConfig.ForgetPasswordConfig;
import com.ishangke.edunav.manager.common.SessionConfig.ForgetPasswordConfigObj;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class AuthManagerImpl implements AuthManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthManagerImpl.class);

    @Autowired
    private CacheManager cache;
    
    
    @Autowired
    private RoleEntityExtMapper roleMapper;

    /**
     * 判断用户账号是否因为登陆失败次数过多被上锁
     */
    @Override
    public boolean isAbleToLogin(String identifier) {
        try {
            ACConfigObj acRecord = (ACConfigObj) cache.get(ACConfig.PREFIX + identifier);
            if (acRecord != null) {
                if (DateUtility.getCurTime() - acRecord.timeStamp > ACConfig.LOCKTHRESHOLD) {
                    // 自从第一次失败以来的时间超过了上锁时间
                    return true;
                } else {
                    // 依然在上锁时间中，但是失败次数小于上锁次数
                    if (acRecord.count < ACConfig.LOCKCOUNT) {
                        return true;
                    }
                    // 依然在上锁时间中，并且失败次数达到上锁次数，禁止登陆
                    else {
                        return false;
                    }
                }
            } else {
                // 没有找到失败记录
                return true;
            }
        } catch (ManagerException e) {
            LOGGER.debug("IsAbleToLogin", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("IsAbleToLogin", t);
            throw new ManagerException("IsAbleToLogin");
        }
    }

    /**
     * 记录用户登陆失败 异步向memcached添加失败记录，返回Future<Boolean>，允许调用者使用Future同步等待添加结果
     */
    @Override
    public Future<Boolean> fail(String identifier) {
        try {
            ACConfigObj acRecord = (ACConfigObj) cache.get(ACConfig.PREFIX + identifier);
            if (acRecord != null) {
                // 其从前面第一次失败已经个超过了上锁时间，重新开始累计失败次数
                if (DateUtility.getCurTime() - acRecord.timeStamp > ACConfig.LOCKTHRESHOLD) {
                    acRecord.count = 1;
                    acRecord.timeStamp = DateUtility.getCurTime();
                }
                // 依旧在上一次的失败累计中，累加失败次数
                else {
                    acRecord.count++;
                }

            } else {
                // 未找到失败记录，开始新的失败记录
                acRecord = new ACConfigObj();
                acRecord.count = 1;
                acRecord.timeStamp = DateUtility.getCurTime();
            }

            // 过期时间设置为0, 存于memcached不过期，不依赖memcached自动过期机制，避免OCS短时间缓存不过期的不稳定问题
            return cache.set(ACConfig.PREFIX + identifier, 0, acRecord);
        } catch (ManagerException e) {
            LOGGER.debug("Fail", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("Fail", t);
            throw new ManagerException("Fail");
        }
    }

    /**
     * 登陆成功，清空用户登陆失败记录
     * 异步向memcached清空失败记录，返回Future<Boolean>，允许调用者使用Future同步等待删除结果
     */
    @Override
    public Future<Boolean> success(String identifier) {
        try {
            return cache.del(ACConfig.PREFIX + identifier);
        } catch (ManagerException e) {
            LOGGER.debug("Success", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("Success", t);
            throw new ManagerException("Success");
        }
    }

    /**
     * Session处理处于特殊情况，需要使用CAS，由于： 1： Memcached
     * 不像Redis一样支持模糊键查找以及List，Set等数据结构，此外一次只能读取一个键值对，一次读取多个极为不可靠 2：
     * 用户需要可以多客户端每客户端多地登陆，修改密码之后又需要全部登出 3： 每次需要全部登出就改变用户在memcached中的对应的键可行但是麻烦很大
     * 4： 因此选择将一个用户的所有Session信息以一个list结构存入一个键值对中 5：
     * 这样一个键值对就包含了所有Session信息，增大了Data Race的可能性，而Session信息出问题了可能比较麻烦，因此需要做线程安全防护
     * 6： 线程安全防护在这里只有两种做法，1： 锁记录 2：使用底层CAS 7:
     * 在Memcached中实现锁记录比较难，而且影响效率，因此选择采用Memcached自己支持并且无锁高效的CAS做法
     * 利用Memecached的Compare-and-Swap功能进行无锁线程安全操作
     */
    @Override
    public boolean validateAuthSession(int identifier, final String authCode) {
        final long curTime = DateUtility.getCurTime();
        try {
            String key = AuthConfig.PREFIX + identifier;

            // 新建用以完成CAS操作的mutator
            CASMutation<Object> mutation = new CASMutation<Object>() {
                // 以下方法将仅会在原有键值对存在的情况下被调用，完成CAS,若键值对不存在则直接使用初始值，详见cas源代码
                @Override
                public List<AuthConfigObj> getNewValue(Object current) {
                    // 自定义Transcoder<T>过于麻烦并且不安全，因此采用默认Transcoder，但是只支持Object类，需要cast
                    @SuppressWarnings("unchecked")
                    List<AuthConfigObj> temp = (List<AuthConfigObj>) (current);
                    // 使用ArrayList使得access time变为O(1)，不使用LinkedList
                    List<AuthConfigObj> list = new ArrayList<AuthConfigObj>(temp);

                    // 按照authcode检索对应Session记录，注意这里的假设为authcode唯一，考虑到authCode重复的可能性为
                    // 0 <-> 1/36^15 并且副作用不大，故未做额外单独性保证
                    // loop中涉及到删除，故从末尾开始
                    for (int i = list.size() - 1; i >= 0; i--) {
                        AuthConfigObj curObj = list.get(i);
                        if ((curTime - curObj.timeStamp) > AuthConfig.EXPIRETHRESHOLD) {
                            // 如果已经超过了过期时间，则自动从列表中删除
                            list.remove(i);
                        } else {
                            if (curObj.authCode.equals(authCode)) {
                                if ((curTime - curObj.timeStamp) > AuthConfig.UPDATETHRESHOLD) {
                                    // 如果超过了更新时间却依旧在列表中，则更新Session的更新时间
                                    list.get(i).timeStamp = curTime;
                                }
                            }
                        }
                    }
                    // 返回更改完毕最新的list
                    return list;
                }
            };

            CASMutator<Object> mutator = new CASMutator<Object>(cache.getClient(), new SerializingTranscoder());
            // 初始值设为null，mutator只会修改原来已经存在的内容并返回最新值
            @SuppressWarnings("unchecked")
            List<AuthConfigObj> casResults = (List<AuthConfigObj>) mutator.cas(key, null, 0, mutation);
            
            /**
             * 当键值对不存在并且没有标明初始值的时候，返回null
             */
            if (casResults == null) {
                return false;
            }
            boolean found = false;
            for (AuthConfigObj singleResult : casResults) {
                if (singleResult.authCode.equals(authCode)) {
                    found = true;
                }
            }
            return found;
        } catch (ManagerException e) {
            LOGGER.debug("ValidateAuthSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("ValidateAuthSession", t);
            throw new ManagerException("ValidateAuthSession");
        }
    }

    /**
     * 开启一个用户Session
     */
    @Override
    public String openAuthSession(int identifier) {
        try {
            final String key = AuthConfig.PREFIX + identifier;
            final String authCode = RandomStringUtils.randomAlphanumeric(AuthConfig.AUTHCODELENGTH);
            final long curTime = DateUtility.getCurTime();

            // 新建用以完成CAS操作的mutator
            CASMutation<Object> mutation = new CASMutation<Object>() {
                @Override
                public List<AuthConfigObj> getNewValue(Object current) {
                    @SuppressWarnings("unchecked")
                    List<AuthConfigObj> temp = (List<AuthConfigObj>) (current);
                    // 使用ArrayList使得access time变为O(1)，不使用LinkedList
                    List<AuthConfigObj> list = new ArrayList<AuthConfigObj>(temp);
                    
                    // Memcached键值对中，值最大容量为1MB，因此必须限制用户Session数量
                    // 一旦超过AUTOCLEAR上限，意味着出现了不该出现的问题导致session数量超标达到预设临界值
                    // 为了防止数据损坏，采取极端措施，按照timestamp逐一逐出Session缓存,留下最近使用的十个
                    // (timestamp从大到小排列)
                    if (list.size() > AuthConfig.AUTOCLEARRECORDS) {
                        Collections.sort(list, new Comparator<AuthConfigObj>() {
                            @Override
                            public int compare(AuthConfigObj o1, AuthConfigObj o2) {
                                long diff = o1.timeStamp - o2.timeStamp;
                                if (diff == 0) {
                                    return 0;
                                }
                                // diff > 0 表示o1 > o2
                                // 表示o1比o2更近被使用，将o1排在o2前，因此return -1， vise vica
                                return diff > 0 ? -1 : 1;
                            }
                        });
                        //只取前 $MAXRECORDS 条记录，这些记录是最新被使用的 (timestamp最大的)
                        list = list.subList(0, AuthConfig.MAXRECORDS);
                    }

                    // Session数量超过正常上限之后将以LRU的方式将最远使用过的Session逐出缓存 (time
                    // stamp最小的session)
                    // 注意，这里被逐出的Session记录可能已过期或者没有过期
                    if (list.size() > AuthConfig.MAXRECORDS) {
                        long trackingTimeStamp = curTime;
                        int trackingIndex = 0;
                        for (int i = list.size() - 1; i >= 0; i--) {
                            if (list.get(i).timeStamp < trackingTimeStamp) {
                                trackingTimeStamp = list.get(i).timeStamp;
                                trackingIndex = i;
                            }
                        }
                        list.remove(trackingIndex);
                    }

                    // 插入最新的Session记录
                    AuthConfigObj newObj = new AuthConfigObj();
                    newObj.authCode = authCode;
                    newObj.timeStamp = curTime;
                    newObj.client = AuthConfig.CLIENT_WEB;
                    list.add(newObj);

                    // 返回更改完毕最新的list
                    return list;
                }
            };

            CASMutator<Object> mutator = new CASMutator<Object>(cache.getClient(), new SerializingTranscoder());
            // 创建新建Session情况提供给CAS用以Session记录尚未存在的情况
            AuthConfigObj initObj = new AuthConfigObj();
            initObj.authCode = authCode;
            initObj.timeStamp = curTime;
            initObj.client = AuthConfig.CLIENT_WEB;
            List<AuthConfigObj> initialValue = Collections.singletonList(initObj);

            // 开始同步的CAS
            mutator.cas(key, initialValue, 0, mutation);

            return authCode;
        } catch (ManagerException e) {
            LOGGER.debug("OpenAuthSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("OpenAuthSession", t);
            throw new ManagerException("OpenAuthSession");
        }
    }

    /**
     * 删除用户某个authCode对应的Session
     */
    @Override
    public void closeAuthSession(int identifier, final String authCode) {
        try {
            final String key = AuthConfig.PREFIX + identifier;

            // 新建用以完成CAS操作的mutator
            CASMutation<Object> mutation = new CASMutation<Object>() {
                @Override
                public List<AuthConfigObj> getNewValue(Object current) {
                    @SuppressWarnings("unchecked")
                    List<AuthConfigObj> temp = (List<AuthConfigObj>) (current);
                    // 使用ArrayList使得access time变为O(1)，不使用LinkedList
                    List<AuthConfigObj> list = new ArrayList<AuthConfigObj>(temp);

                    // 依旧假设authcode的唯一性，则一个authCode将会对应一个session，逐出该session
                    // 保证当前session被逐出缓存，逐出所有authcode相等的情况，从尾部开始
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (list.get(i).equals(authCode)) {
                            list.remove(i);
                        }
                    }
                    // 返回更改完毕最新的list
                    return list;
                }
            };

            CASMutator<Object> mutator = new CASMutator<Object>(cache.getClient(), new SerializingTranscoder());

            // 开始同步的CAS
            mutator.cas(key, null, 0, mutation);
        } catch (ManagerException e) {
            LOGGER.debug("CloseAuthSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("CloseAuthSession", t);
            throw new ManagerException("CloseAuthSession");
        }
    }

    /**
     * 删除所有Session，等同于将用户从所有已登录平台上登出，适用于忘记密码，更改密码等情况
     */
    @Override
    public Future<Boolean> closeAllAuthSession(final int identifier) {
        try {
            return cache.del(AuthConfig.PREFIX + identifier);
        } catch (ManagerException e) {
            LOGGER.debug("CloseAllAuthSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("CloseAllAuthSession", t);
            throw new ManagerException("CloseAllAuthSession");
        }
    }

    /**
     * 验证用户的手机验证码
     */
    @Override
    public boolean validateCellVerificationSession(String cell, String authCode) {
        try {
            String key = CellVerificationConfig.PREFIX + cell;
            CellVerificationConfigObj cvRecord = (CellVerificationConfigObj) cache.get(key);

            if (cvRecord == null) {
                return false;
            } else {

                if (!cvRecord.authCode.equalsIgnoreCase(authCode)) {
                    return false;
                }
                if ((DateUtility.getCurTime() - cvRecord.timeStamp) > CellVerificationConfig.EXPIRETHRESHOLD) {
                    cache.del(key);
                    return false;
                }
                return true;
            }
        } catch (ManagerException e) {
            LOGGER.debug("ValidateCellVerificationSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("ValidateCellVerificationSession", t);
            throw new ManagerException("ValidateCellVerificationSession");
        }
    }

    /**
     * 生成并记录手机验证码
     */
    @Override
    public String openCellVerificationSession(String cell) {
        try {
            String key = CellVerificationConfig.PREFIX + cell;
            CellVerificationConfigObj cvRecord = (CellVerificationConfigObj) cache.get(key);
            if (cvRecord != null) {
                // 找到之前的发送信息，查看是否可以重新发送
                if ((DateUtility.getCurTime() - cvRecord.timeStamp) <= CellVerificationConfig.RESENDTHRESHOLD) {
                    throw new ManagerException("连续请求过快");
                }
            }
            cvRecord = new CellVerificationConfigObj();
            cvRecord.authCode = RandomStringUtils.randomAlphanumeric(CellVerificationConfig.AUTHCODELENGTH);
            cvRecord.timeStamp = DateUtility.getCurTime();

            // 过期时间设置为0, 存于memcached不过期，不依赖memcached自动过期机制，避免OCS短时间缓存不过期的不稳定问题
            cache.set(key, 0, cvRecord).get();
            return cvRecord.authCode;
        } catch (ManagerException e) {
            LOGGER.debug("OpenCellVerificationSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("OpenCellVerificationSession", t);
            throw new ManagerException("OpenCellVerificationSession");
        }
    }

    @Override
    public Future<Boolean> closeCellVerificationSession(String identifier) {
        try {
            return cache.del(CellVerificationConfig.PREFIX + identifier);
        } catch (ManagerException e) {
            LOGGER.debug("CloseCellVerificationSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("CloseCellVerificationSession", t);
            throw new ManagerException("CloseCellVerificationSession");
        }
    }

    /**
     * 验证忘记密码验证码
     */
    @Override
    public boolean validateForgetPasswordSession(int identifier, String authCode) {
        try {
            String key = ForgetPasswordConfig.PREFIX + identifier;
            ForgetPasswordConfigObj fpRecord = (ForgetPasswordConfigObj) cache.get(key);

            if (fpRecord == null) {
                return false;
            } else {

                if (!fpRecord.authCode.equalsIgnoreCase(authCode)) {
                    return false;
                }
                if ((DateUtility.getCurTime() - fpRecord.timeStamp) > ForgetPasswordConfig.EXPIRETHRESHOLD) {
                    cache.del(key);
                    return false;
                }
                return true;
            }
        } catch (ManagerException e) {
            LOGGER.debug("ValidateForgetPasswordSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("ValidateForgetPasswordSession", t);
            throw new ManagerException("ValidateForgetPasswordSession");
        }
    }

    /**
     * 生成并记录忘记密码验证码
     */
    @Override
    public String openForgetPasswordSession(int identifier) {
        try {
            String key = ForgetPasswordConfig.PREFIX + identifier;
            ForgetPasswordConfigObj fpRecord = (ForgetPasswordConfigObj) cache.get(key);
            if (fpRecord != null) {
                // 找到之前的发送信息，查看是否可以重新发送
                if ((DateUtility.getCurTime() - fpRecord.timeStamp) <= ForgetPasswordConfig.RESENDTHRESHOLD) {
                    throw new ManagerException("连续请求过快");
                }
            }
            fpRecord = new ForgetPasswordConfigObj();
            fpRecord.authCode = RandomStringUtils.randomAlphanumeric(ForgetPasswordConfig.AUTHCODELENGTH);
            fpRecord.timeStamp = DateUtility.getCurTime();

            // 过期时间设置为0, 存于memcached不过期，不依赖memcached自动过期机制，避免OCS短时间不稳定的问题
            cache.set(key, 0, fpRecord).get();
            return fpRecord.authCode;
        } catch (ManagerException e) {
            LOGGER.debug("OpenForgetPasswordSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("OpenForgetPasswordSession", t);
            throw new ManagerException("OpenForgetPasswordSession");
        }
    }

    @Override
    public Future<Boolean> closeForgetPasswordSession(int  identifier) {
        try {
            return cache.del(ForgetPasswordConfig.PREFIX + identifier);
        } catch (ManagerException e) {
            LOGGER.debug("CloseForgetPasswordSession", e);
            throw e;
        } catch (Throwable t) {
            LOGGER.debug("CloseForgetPasswordSession", t);
            throw new ManagerException("CloseForgetPasswordSession");
        }
    }

    @Override
    public boolean isSystemAdmin(int userId) {
        return Constant.ROLESYSTEMADMIN.equals(getRole(userId));
    }
    
    @Override
    public boolean isAdmin(int userId) {
        return Constant.ROLEADMIN.equals(getRole(userId));
    }

    @Override
    public String getRole(int userId) {
        String role = (String)cache.get(Constant.ROLEPREFIX + userId);
        if (role != null) {
            return role;
        } else {
            List<RoleEntityExt> roleList = roleMapper.listRolesByUserId(userId);
            if (roleList == null || roleList.size() == 0) {
                LOGGER.warn(String.format("[AuthManager] user [id = %d] cannot find role!", userId));
                return null;
            }
            String roleName = roleList.get(0).getName();
            cache.set(Constant.ROLEPREFIX + userId, Constant.STATUSTRANSFORMEXPIRETIME, roleName);
            LOGGER.info(String.format("[AuthManagerImpl] add role into memcached [user id: %d] [role name: %s]", userId, roleName));
            return roleName;
        }
    }

}
