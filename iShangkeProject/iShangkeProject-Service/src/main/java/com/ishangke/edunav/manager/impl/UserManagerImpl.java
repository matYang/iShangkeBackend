package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.constant.DefaultValue;
import com.ishangke.edunav.common.enums.CouponEnums;
import com.ishangke.edunav.common.enums.LoginEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.common.utilities.LoginDeterminer;
import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CreditEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.PartnerEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserGroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.UserManager;
import com.ishangke.edunav.manager.async.dispatcher.SMSDispatcher;
import com.ishangke.edunav.manager.common.PasswordCrypto;
import com.ishangke.edunav.manager.converter.CouponConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.manager.exception.notfound.UserNotFoundException;

@Component
public class UserManagerImpl implements UserManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    private UserEntityExtMapper userMapper;

    @Autowired
    private AuthManager authManager;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private UserGroupEntityExtMapper userGroupMapper;

    @Autowired
    private AccountEntityExtMapper accountMapper;

    @Autowired
    private CreditEntityExtMapper creditMapper;

    @Autowired
    private CouponEntityExtMapper couponMapper;

    @Autowired
    private CouponHistoryEntityExtMapper couponHistoryMapper;

    @Autowired
    private PartnerEntityExtMapper partnerMapper;

    @Autowired
    private CouponManager couponManager;

    private UserBo initializeNormalUser(UserBo userBo, int groupId, String uniqueIdentifier, boolean notify) {
        // 参数验证
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 插入新的USER
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        userEntity.setCreateTime(DateUtility.getCurTimeInstance());
        userEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        userEntity.setLastLoginTime(DateUtility.getCurTimeInstance());
        userEntity.setEnabled(0);
        userEntity.setDeleted(0);
        try {
            // hash the password
            userEntity.setPassword(PasswordCrypto.createHash(userEntity.getPassword()));
            int result = userMapper.add(userEntity);
            if (result <= 0) {
                throw new ManagerException("对不起，用户创建失败，请稍后再试");
            }

            UserGroupEntityExt userGroupEntity = new UserGroupEntityExt();
            userGroupEntity.setUserId(userEntity.getId());
            userGroupEntity.setGroupId(groupId);
            userGroupEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            userGroupEntity.setDeleted(0);
            result = userGroupMapper.add(userGroupEntity);
            if (result <= 0) {
                throw new ManagerException("对不起，连接用户分组失败，请稍后再试");
            }

            AccountEntityExt accountEntity = new AccountEntityExt();
            accountEntity.setId(userEntity.getId());
            accountEntity.setBalance(0.0d);
            accountEntity.setRealName(userEntity.getName());
            accountEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            accountEntity.setCreateTime(DateUtility.getCurTimeInstance());
            accountEntity.setEnabled(0);
            accountEntity.setDeleted(0);
            result = accountMapper.add(accountEntity);
            if (result <= 0) {
                throw new ManagerException("对不起，用户账户创建失败，请稍后再试");
            }

            CreditEntityExt creditEntity = new CreditEntityExt();
            creditEntity.setId(userEntity.getId());
            creditEntity.setCredit(0.0d);
            creditEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            creditEntity.setCreateTime(DateUtility.getCurTimeInstance());
            creditEntity.setEnabled(0);
            creditEntity.setDeleted(0);
            result = creditMapper.add(creditEntity);
            if (result <= 0) {
                throw new ManagerException("对不起，用户积分账户创建失败，请稍后再试");
            }

            CouponEntityExt couponEntity = new CouponEntityExt();
            couponEntity.setBalance(DefaultValue.COUPONREGISTRATIONVALUE);
            couponEntity.setTotal(DefaultValue.COUPONREGISTRATIONVALUE);
            couponEntity.setOrigin(CouponEnums.Origin.REGISTRATION.code);
            couponEntity.setStatus(CouponEnums.Status.USABLE.code);
            Calendar expiry = DateUtility.getCurTimeInstance();
            expiry.add(Calendar.YEAR, 1);
            couponEntity.setExpiryTime(expiry);
            couponEntity.setRemark("");
            couponEntity.setUserId(userEntity.getId());
            couponEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            couponEntity.setCreateTime(DateUtility.getCurTimeInstance());
            couponEntity.setEnabled(0);
            couponEntity.setDeleted(0);
            couponManager.createCoupon(CouponConverter.toBo(couponEntity), UserConverter.toBo(userEntity));

            String appliedInvitationCode = userEntity.getAppliedInvitationCode();
            UserEntityExt inviterEntity = null;
            if (appliedInvitationCode != null && appliedInvitationCode.length() > 0) {
                // use used an invitation code
                UserEntityExt inviterSearch = new UserEntityExt();
                inviterSearch.setInvitationCode(appliedInvitationCode);
                inviterEntity = userMapper.getByInvitationCode(inviterSearch);
                if (inviterEntity == null || IdChecker.isNull(inviterEntity.getId())) {
                    throw new ManagerException("对不起，无法找到用户名为" + appliedInvitationCode + "的用户");
                }

                CouponEntityExt curUserCouponEntity = new CouponEntityExt();
                curUserCouponEntity.setBalance(DefaultValue.COUPONINVITATIONVALUE);
                curUserCouponEntity.setTotal(DefaultValue.COUPONINVITATIONVALUE);
                curUserCouponEntity.setOrigin(CouponEnums.Origin.INVITATION.code);
                curUserCouponEntity.setStatus(CouponEnums.Status.INACTIVE.code);
                curUserCouponEntity.setExpiryTime(expiry);
                curUserCouponEntity.setRemark("");
                curUserCouponEntity.setUserId(userEntity.getId());
                curUserCouponEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
                curUserCouponEntity.setCreateTime(DateUtility.getCurTimeInstance());
                curUserCouponEntity.setEnabled(0);
                curUserCouponEntity.setDeleted(0);
                couponManager.createCoupon(CouponConverter.toBo(curUserCouponEntity), UserConverter.toBo(userEntity));

                CouponEntityExt inviterCouponEntity = new CouponEntityExt();
                inviterCouponEntity.setBalance(DefaultValue.COUPONINVITATIONVALUE);
                inviterCouponEntity.setTotal(DefaultValue.COUPONINVITATIONVALUE);
                inviterCouponEntity.setOrigin(CouponEnums.Origin.INVITATION.code);
                inviterCouponEntity.setStatus(CouponEnums.Status.INACTIVE.code);
                inviterCouponEntity.setExpiryTime(expiry);
                inviterCouponEntity.setRemark("");
                inviterCouponEntity.setUserId(inviterEntity.getId());
                inviterCouponEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
                inviterCouponEntity.setCreateTime(DateUtility.getCurTimeInstance());
                inviterCouponEntity.setEnabled(0);
                inviterCouponEntity.setDeleted(0);
                couponManager.createCoupon(CouponConverter.toBo(inviterCouponEntity), UserConverter.toBo(inviterEntity));
            }

            // lastly, read out the user...too many changes unable to maintain
            // local copy
            userEntity = userMapper.getById(userEntity.getId());
            if (userEntity == null) {
                throw new UserNotFoundException("对不起，新用户获取失败，请稍后再试");
            }

            UserEntityExt returnEntity = userMapper.getById(userEntity.getId());
            if (notify) {
                SMSDispatcher.sendUserRegistraterSMS(userEntity.getPhone(), DefaultValue.COUPONREGISTRATIONVALUE);
                if (inviterEntity != null) {
                    SMSDispatcher.sendInviteeSMS(userEntity.getPhone(), DefaultValue.COUPONINVITATIONVALUE);
                    SMSDispatcher.sendInviterSMS(inviterEntity.getPhone(), DefaultValue.COUPONINVITATIONVALUE);
                }
            }
            return UserConverter.toBo(returnEntity);
        } catch (Throwable t) {
            if (t instanceof ManagerException) {
                throw t;
            }
            throw new ManagerException("对不起，用户创建失败，请稍后再试", t);
        }

    }

    @Override
    public UserBo registerUser(UserBo userBo, SessionBo sessionBo) {
        // 参数验证
        if (userBo == null || sessionBo == null) {
            throw new ManagerException("无效请求参数");
        }

        boolean isValid = authManager.validateCellVerificationSession(sessionBo.getAccountIdentifier(), sessionBo.getAuthCode());
        if (!isValid) {
            throw new ManagerException("对不起，您的手机号码与验证码不匹配");
        }
        if (userBo.getPhone() == null) {
            throw new ManagerException("请您填写手机号码");
        }
        if (userBo.getInvitationCode() == null) {
            throw new ManagerException("请您填写用户名");
        }
        if (userBo.getPassword() == null) {
            throw new ManagerException("请您填写密码");
        }

        // 判断是否存在手机号码一样的USER
        UserEntityExt entityPhoneInDb = new UserEntityExt();
        entityPhoneInDb.setPhone(userBo.getPhone());
        entityPhoneInDb = userMapper.getByPhone(entityPhoneInDb);
        if (entityPhoneInDb != null && IdChecker.notNull(entityPhoneInDb.getId())) {
            throw new ManagerException("对不起，手机号码" + userBo.getPhone() + "已经被注册");
        }
        
        // 判断InvitationCode是否已经存在
        UserEntityExt entityInvitationCodeInDb = new UserEntityExt();
        entityInvitationCodeInDb.setInvitationCode(userBo.getInvitationCode());
        entityInvitationCodeInDb = userMapper.getByInvitationCode(entityInvitationCodeInDb);
        if (entityInvitationCodeInDb != null && IdChecker.notNull(entityInvitationCodeInDb.getId())) {
            throw new ManagerException("对不起，用户名" + userBo.getInvitationCode() + "已经被注册");
        }
        
        
        if (userBo.getReference() != null) {
            UserEntityExt entityReferenceInDb = new UserEntityExt();
            entityReferenceInDb.setReference(userBo.getReference());
            entityReferenceInDb = userMapper.getByReference(entityReferenceInDb);
            if (entityReferenceInDb != null && IdChecker.notNull(entityReferenceInDb.getId())) {
                throw new ManagerException("对不起，识别号" + userBo.getReference() + "已经被注册");
            }
        }

        UserBo resultUser = initializeNormalUser(userBo, Constant.GROUPUSER, userBo.getPhone(), true);
        authManager.closeCellVerificationSession(sessionBo.getAccountIdentifier());
        String authCode = authManager.openAuthSession(resultUser.getId());
        resultUser.setAuthCode(authCode);
        return resultUser;
    }

    @Override
    public UserBo createUser(UserBo targetUser, UserBo currentUser) {
        // Check Null
        if (targetUser == null || currentUser == null) {
            throw new ManagerException("无效请求参数");
        }

        if (authManager.isAdmin(currentUser.getId()) || authManager.isSystemAdmin(currentUser.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call createUser at " + new Date(), currentUser.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权创建新用户");
        }
        if (targetUser.getPhone() == null && targetUser.getInvitationCode() == null && targetUser.getReference() == null) {
            throw new ManagerException("创建用户时至少填写标注手机号码，用户名或识别号");
        }
        if (targetUser.getPassword() == null) {
            throw new ManagerException("创建用户时必须填写密码");
        }

        if (targetUser.getPhone() != null) {
            UserEntityExt entityPhoneInDb = new UserEntityExt();
            entityPhoneInDb.setPhone(targetUser.getPhone());
            entityPhoneInDb = userMapper.getByPhone(entityPhoneInDb);
            if (entityPhoneInDb != null && IdChecker.notNull(entityPhoneInDb.getId())) {
                throw new ManagerException("对不起，手机号码" + targetUser.getPhone() + "已经被注册");
            }
        }
        if (targetUser.getInvitationCode() != null) {
            UserEntityExt entityInvitationCodeInDb = new UserEntityExt();
            entityInvitationCodeInDb.setInvitationCode(targetUser.getInvitationCode());
            entityInvitationCodeInDb = userMapper.getByInvitationCode(entityInvitationCodeInDb);
            if (entityInvitationCodeInDb != null && IdChecker.notNull(entityInvitationCodeInDb.getId())) {
                throw new ManagerException("对不起，用户名" + targetUser.getInvitationCode() + "已经被注册");
            }
        }
        if (targetUser.getReference() != null) {
            UserEntityExt entityReferenceInDb = new UserEntityExt();
            entityReferenceInDb.setReference(targetUser.getReference());
            entityReferenceInDb = userMapper.getByReference(entityReferenceInDb);
            if (entityReferenceInDb != null && IdChecker.notNull(entityReferenceInDb.getId())) {
                throw new ManagerException("对不起，识别号" + targetUser.getReference() + "已经被注册");
            }
        }

        // act like a normal registration
        return initializeNormalUser(targetUser, Constant.GROUPUSER, targetUser.getPhone(), false);
    }

    @Override
    public UserBo createPartnerUser(UserBo targetUser, PartnerBo partner, int roleId, UserBo currentUser) {
        if (targetUser == null || partner == null || currentUser == null) {
            throw new ManagerException("无效请求参数");
        }

        // Check Null
        if (authManager.isAdmin(currentUser.getId()) || authManager.isSystemAdmin(currentUser.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call createUser at " + new Date(), currentUser.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权创建合作机构用户");
        }
        
        if (IdChecker.isNull(partner.getId())) {
            throw new AuthenticationException("请您填写合作机构ID");
        }
        if (targetUser.getReference() == null) {
            throw new ManagerException("请您填写用户识别号");
        }
        if (targetUser.getPassword() == null) {
            throw new ManagerException("请您填写密码");
        }

        if (targetUser.getPhone() != null) {
            UserEntityExt entityPhoneInDb = new UserEntityExt();
            entityPhoneInDb.setPhone(targetUser.getPhone());
            entityPhoneInDb = userMapper.getByPhone(entityPhoneInDb);
            if (entityPhoneInDb != null && IdChecker.notNull(entityPhoneInDb.getId())) {
                throw new ManagerException("对不起，手机号码" + targetUser.getPhone() + "已经被注册");
            }
        }
        if (targetUser.getInvitationCode() != null) {
            UserEntityExt entityInvitationCodeInDb = new UserEntityExt();
            entityInvitationCodeInDb.setInvitationCode(targetUser.getInvitationCode());
            entityInvitationCodeInDb = userMapper.getByInvitationCode(entityInvitationCodeInDb);
            if (entityInvitationCodeInDb != null && IdChecker.notNull(entityInvitationCodeInDb.getId())) {
                throw new ManagerException("对不起，用户名" + targetUser.getInvitationCode() + "已经被注册");
            }
        }
        if (targetUser.getReference() != null) {
            UserEntityExt entityReferenceInDb = new UserEntityExt();
            entityReferenceInDb.setReference(targetUser.getReference());
            entityReferenceInDb = userMapper.getByReference(entityReferenceInDb);
            if (entityReferenceInDb != null && IdChecker.notNull(entityReferenceInDb.getId())) {
                throw new ManagerException("对不起，识别号" + targetUser.getReference() + "已经被注册");
            }
        }

        UserBo response = null;
        try {
            GroupEntityExt group = new GroupEntityExt();
            group.setRoleId(roleId);
            group.setPartnerId(partner.getId());
            List<GroupEntityExt> listGroups = groupMapper.list(group, null);
            if (listGroups == null || listGroups.size() <= 0) {
                throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
            }
            response = initializeNormalUser(targetUser, listGroups.get(0).getId(), targetUser.getReference(), false);
        } catch (Throwable t) {
            if (t instanceof ManagerException) {
                throw t;
            }
            throw new ManagerException("对不起，创建用户分组失败，请稍后再试", t);
        }

        // act like a normal registration
        return response;
    }

    @Override
    public SessionBo openCellSession(UserBo userBo) {
        if (userBo == null || userBo.getPhone() == null || userBo.getPhone().length() == 0) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt searchEntity = new UserEntityExt();
        searchEntity.setPhone(userBo.getPhone());

        UserEntityExt result = null;
        try {
            result = userMapper.getByPhone(searchEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，手机号码" + userBo.getPhone() + "查询失败，请稍后再试", t);
        }

        if (result != null && IdChecker.notNull(result.getId())) {
            throw new ManagerException("对不起，手机号码" + userBo.getPhone() + "已经被注册");
        }

        String authCode = authManager.openCellVerificationSession(userBo.getPhone());
        SessionBo sessionBo = new SessionBo();
        sessionBo.setAccountIdentifier(userBo.getPhone());
        sessionBo.setAuthCode(authCode);

        SMSDispatcher.sendUserCellVerificationSMS(userBo.getPhone(), authCode);
        return sessionBo;
    }

    @Override
    public SessionBo openForgetPasswordSession(UserBo userBo) {
        if (userBo == null || userBo.getPhone() == null || userBo.getPhone().length() == 0) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt searchEntity = new UserEntityExt();
        searchEntity.setPhone(userBo.getPhone());
        UserEntityExt result = null;
        try {
            result = userMapper.getByPhone(searchEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，手机号码" + userBo.getPhone() + "查询失败，请稍后再试", t);
        }

        if (result == null || IdChecker.isNull(result.getId())) {
            throw new ManagerException("对不起，手机号码" + userBo.getPhone() + "尚未被注册");
        }

        UserEntityExt curUser = result;
        String authCode = authManager.openForgetPasswordSession(curUser.getId());
        SessionBo sessionBo = new SessionBo();
        sessionBo.setId(curUser.getId());
        sessionBo.setAccountIdentifier(curUser.getPhone());
        sessionBo.setAuthCode(authCode);

        SMSDispatcher.sendUserForgetPasswordSMS(userBo.getPhone(), authCode);
        return sessionBo;
    }

    @Override
    public SessionBo recoverPassword(PasswordBo passwordBo) {
        if (passwordBo == null || passwordBo.getAccountIdentifier() == null || passwordBo.getAuthCode() == null || passwordBo.getNewPassword() == null) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt searchEntity = new UserEntityExt();
        UserEntityExt curUser = null;

        LoginEnums.IdentifierType identifierType = LoginDeterminer.exam(passwordBo.getAccountIdentifier());
        if (identifierType == LoginEnums.IdentifierType.PHONE) {
            searchEntity.setPhone(passwordBo.getAccountIdentifier());
            curUser = userMapper.getByPhone(searchEntity);
            if (curUser == null) {
                throw new UserNotFoundException("对不起，手机号码" + passwordBo.getAccountIdentifier() + "尚未被注册");
            }
        } else if (identifierType == LoginEnums.IdentifierType.INVITATIONCODE) {
            searchEntity.setInvitationCode(passwordBo.getAccountIdentifier());
            curUser = userMapper.getByInvitationCode(searchEntity);
            if (curUser == null) {
                throw new UserNotFoundException("对不起，用户名" + passwordBo.getAccountIdentifier()+ "尚未被注册");
            }
        } else if (identifierType == LoginEnums.IdentifierType.EMAIL) {
            throw new ManagerException("邮箱找回密码功能尚未开启，请使用 手机号或者用户名 登陆");
        } else {
            throw new ManagerException("无法识别账号类型，请遵照 手机号码/用户名/邮箱 格式");
        }

        boolean isValid = authManager.validateForgetPasswordSession(curUser.getId(), passwordBo.getAuthCode());
        if (!isValid) {
            throw new ManagerException("验证码不匹配，请重新输入");
        }

        curUser.setPassword(PasswordCrypto.createHash(passwordBo.getNewPassword()));
        curUser.setLastModifyTime(DateUtility.getCurTimeInstance());
        try {
            userMapper.update(curUser);
        } catch (Throwable t) {
            throw new ManagerException("对不起，密码找回失败，请稍后再试", t);
        }

        // close the forget password session
        authManager.closeForgetPasswordSession(curUser.getId());
        // log all clients out for security
        authManager.closeAllAuthSession(curUser.getId());
        // clear AC so that user may login again, should he/she has to
        authManager.success(curUser.getPhone());

        // log user in with a brand new session
        // return sessionBo here so cookie can be set with new authCode
        String authCode = authManager.openAuthSession(curUser.getId());
        SessionBo sessionBo = new SessionBo();
        sessionBo.setId(curUser.getId());
        sessionBo.setAccountIdentifier(curUser.getPhone());
        sessionBo.setAuthCode(authCode);
        return sessionBo;

    }

    @Override
    public SessionBo changePassword(PasswordBo passwordBo) {
        if (passwordBo == null || IdChecker.isNull(passwordBo.getId()) || passwordBo.getNewPassword() == null || passwordBo.getOldPassword() == null) {
            throw new ManagerException("无效请求参数");
        }
        //public function, no permission check
        
        UserEntityExt curUser = null;
        try {
            curUser = userMapper.getById(passwordBo.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，用户获取失败，请稍后再试", t);
        }
        if (curUser == null || IdChecker.isNull(curUser.getId())) {
            throw new UserNotFoundException("对不起，无法找到ID为" + passwordBo.getId() + "的用户");
        }
        if (!PasswordCrypto.validatePassword(passwordBo.getOldPassword(), curUser.getPassword())) {
            throw new AuthenticationException("旧密码不匹配，请重新输入");
        }

        curUser.setPassword(PasswordCrypto.createHash(passwordBo.getNewPassword()));
        curUser.setLastModifyTime(DateUtility.getCurTimeInstance());
        try {
            userMapper.update(curUser);
        } catch (Throwable t) {
            throw new ManagerException("对不起，密码修改失败，请稍后再试", t);
        }

        // log all clients out for security
        authManager.closeAllAuthSession(curUser.getId());

        // log user in with a brand new session
        // return sessionBo here so cookie can be set with new authCode
        String authCode = authManager.openAuthSession(curUser.getId());
        SessionBo sessionBo = new SessionBo();
        sessionBo.setId(curUser.getId());
        sessionBo.setAccountIdentifier(curUser.getPhone());
        sessionBo.setAuthCode(authCode);
        return sessionBo;
    }

    @Override
    public UserBo authenticate(SessionBo sessionBo) {
        if (sessionBo == null || sessionBo.getAuthCode() == null) {
            throw new ManagerException("无效请求参数");
        }

        boolean isValid = authManager.validateAuthSession(sessionBo.getId(), sessionBo.getAuthCode());
        UserEntityExt response = new UserEntityExt();
        if (!isValid) {
            response.setId(-1);
            return UserConverter.toBo(response);
        }

        try {
            response = userMapper.getSimpleById(sessionBo.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，用户获取失败，请稍后再试", t);
        }
        if (response == null || IdChecker.isNull(response.getId())) {
            throw new UserNotFoundException("对不起，无法找到对应用户");
        }

        return UserConverter.toBo(response);
    }

    @Override
    public void disposeSession(SessionBo sessionBo) {
        if (sessionBo == null || IdChecker.isNull(sessionBo.getId()) || sessionBo.getAuthCode() == null || sessionBo.getAuthCode().length() == 0) {
            throw new ManagerException("无效请求参数");
        }
        
        try {
            authManager.closeAuthSession(sessionBo.getId(), sessionBo.getAuthCode());
        } catch (Throwable t) {
            throw new ManagerException("对不起，登出失败，请稍后再试", t);
        }
        
    }

    @Override
    public SessionBo loginByUser(LoginBo loginBo) {
        if (loginBo == null || loginBo.getAccountIdentifier() == null || loginBo.getPassword() == null) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt curUser = null;
        String authCode = null;
        try {
            if (!authManager.isAbleToLogin(loginBo.getAccountIdentifier())) {
                throw new ManagerException("对不起，您登录过于频繁，请等候一分钟");
            }

            UserEntityExt search = new UserEntityExt();
            LoginEnums.IdentifierType loginType = LoginDeterminer.exam(loginBo.getAccountIdentifier());
            if (loginType == LoginEnums.IdentifierType.PHONE) {
                search.setPhone(loginBo.getAccountIdentifier());
                curUser = userMapper.getByPhone(search);
                if (curUser == null) {
                    throw new UserNotFoundException("对不起，手机号码" + loginBo.getAccountIdentifier() + "尚未被注册");
                }
            } else if (loginType == LoginEnums.IdentifierType.INVITATIONCODE) {
                search.setInvitationCode(loginBo.getAccountIdentifier());
                curUser = userMapper.getByInvitationCode(search);
                if (curUser == null) {
                    throw new UserNotFoundException("对不起，用户名" + loginBo.getAccountIdentifier() + "尚未被注册");
                }
            } else if (loginType == LoginEnums.IdentifierType.EMAIL) {
                throw new ManagerException("邮箱登陆功能尚未开启，请使用 手机号或者用户名 登陆");
            } else {
                throw new ManagerException("无法识别账号类型，请遵照 手机号码/用户名/邮箱 格式");
            }

            if (!PasswordCrypto.validatePassword(loginBo.getPassword(), curUser.getPassword())) {
                throw new AuthenticationException("账号与密码不匹配");
            }

            curUser.setLastLoginTime(DateUtility.getCurTimeInstance());
            userMapper.update(curUser);
            authCode = authManager.openAuthSession(curUser.getId());

        } catch (Throwable t) {
            authManager.fail(loginBo.getAccountIdentifier());
            if (t instanceof ManagerException) {
                throw t;
            }
            throw new ManagerException("对不起，登录失败，请稍后再试", t);
        }

        authManager.success(loginBo.getAccountIdentifier());

        SessionBo sessionBo = new SessionBo();
        sessionBo.setId(curUser.getId());
        sessionBo.setAccountIdentifier(loginBo.getAccountIdentifier());
        sessionBo.setAuthCode(authCode);
        return sessionBo;
    }

    @Override
    // reference is reference only
    public SessionBo loginByReference(LoginBo loginBo) {
        if (loginBo == null || loginBo.getAccountIdentifier() == null || loginBo.getPassword() == null) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt curUser = null;
        String authCode = null;
        try {
            if (!authManager.isAbleToLogin(loginBo.getAccountIdentifier())) {
                throw new ManagerException("对不起，您登录过于频繁，请等候一分钟");
            }

            UserEntityExt search = new UserEntityExt();
            search.setReference(loginBo.getAccountIdentifier());

            curUser = userMapper.getByReference(search);
            if (curUser == null) {
                throw new UserNotFoundException("对不起，识别号" + loginBo.getAccountIdentifier() + "尚未被注册");
            }

            if (!PasswordCrypto.validatePassword(loginBo.getPassword(), curUser.getPassword())) {
                throw new AuthenticationException("账号与密码不匹配");
            }

            curUser.setLastLoginTime(DateUtility.getCurTimeInstance());
            userMapper.update(curUser);
            authCode = authManager.openAuthSession(curUser.getId());

        } catch (Throwable t) {
            authManager.fail(loginBo.getAccountIdentifier());
            if (t instanceof ManagerException) {
                throw t;
            }
            throw new ManagerException("对不起，登录失败，请稍后再试", t);
        }

        authManager.success(loginBo.getAccountIdentifier());

        SessionBo sessionBo = new SessionBo();
        sessionBo.setId(curUser.getId());
        sessionBo.setAccountIdentifier(loginBo.getAccountIdentifier());
        sessionBo.setAuthCode(authCode);
        return sessionBo;
    }

    @Override
    public UserBo deleteUser(UserBo targetUser, UserBo currentUser) {
        // Check Null
        if (targetUser == null || currentUser == null) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt targetUserEntity = UserConverter.fromBo(targetUser);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);

        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call deleteUser at " + new Date(), currentUserEntity.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权删除用户");
        }
        
        if (IdChecker.isNull(targetUserEntity.getId())) {
            throw new ManagerException("对不起，删除用户时必须标注用户ID");
        }
        try {
            targetUserEntity.setDeleted(1);
            userMapper.deleteById(targetUserEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，用户删除失败，请稍后再试", t);
        }

        return UserConverter.toBo(targetUserEntity);
    }

    @Override
    public UserBo updateUser(UserBo targetUser, UserBo currentUser) {
        // Check Null
        if (targetUser == null || currentUser == null) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt targetUserEntity = UserConverter.fromBo(targetUser);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);

        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call updateUser at " + new Date(), currentUserEntity.getName()));
        } else {
            //this include both partner user and normal user
            if (targetUserEntity == null || IdChecker.notEqual(targetUserEntity.getId(), currentUserEntity.getId())) {
                throw new AuthenticationException("对不起，您无权更改其他用户");
            }
        }

        if (IdChecker.isNull(targetUserEntity.getId())) {
            throw new ManagerException("对不起，更改用户时必须标注用户ID");
        }
        
        //lets just say there are things that are not meant to be changed
        targetUserEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        targetUserEntity.setPhone(null);
        targetUserEntity.setInvitationCode(null);
        targetUserEntity.setAppliedInvitationCode(null);
        targetUserEntity.setReference(null);
        targetUserEntity.setCreateTime(null);
        targetUserEntity.setDeleted(null);
        try {
            userMapper.update(targetUserEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，用户更改失败，请稍后再试", t);
        }

        return UserConverter.toBo(userMapper.getById(targetUserEntity.getId()));
    }

    @Override
    //by id
    public UserBo queryUserInfo(UserBo queryUser, UserBo currentUser) {
        // Check Null
        if (queryUser == null || currentUser == null) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt queryUserEntity = UserConverter.fromBo(queryUser);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);

        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call queryUserInfo at " + new Date(), currentUserEntity.getName()));
        } else {
            //this include both partner user and normal user
            if (queryUserEntity == null || IdChecker.notEqual(queryUserEntity.getId(), currentUserEntity.getId())) {
                throw new AuthenticationException("对不起，您无权查询其他用户");
            }
        }

        UserEntityExt result = null;
        try {
            result = userMapper.getById(queryUserEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，用户获取失败，请稍后再试", t);
        }

        if (result == null) {
            throw new UserNotFoundException("对不起，无法找到ID为" + currentUserEntity.getId() + "的用户");
        }

        return UserConverter.toBo(result);
    }

    @Override
    public List<UserBo> queryUser(UserBo queryUser, UserBo currentUser, PaginationBo paginationBo) {
        if (currentUser == null) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt queryUserEntity = queryUser == null ? null : UserConverter.fromBo(queryUser);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);

        // only admins are allowed here
        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call queryUser at " + new Date(), currentUserEntity.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权查询其他用户");
        }

        List<UserEntityExt> results = null;
        try {
            results = userMapper.list(queryUserEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，用户查询失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<UserBo>();
        }
        List<UserBo> convertedResults = new ArrayList<UserBo>();
        for (UserEntityExt userPo : results) {
            convertedResults.add(UserConverter.toBo(userPo));
        }
        return convertedResults;
    }

    @Override
    public int queryUserTotal(UserBo queryUser) {
        return userMapper.getListCount(UserConverter.fromBo(queryUser));
    }
    
    @Override
    public int queryUserByPartnerIdAndRoleIdTotal(int partnerId, int roleId) {
        return userMapper.getCountByPartnerIdAndRoleId(partnerId, roleId);
    }
    
    @Override
    public int getPartnerIdByUserId(int userId) {
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userId);
        if (groupList == null) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        for (GroupEntityExt g : groupList) {
            return g.getPartnerId();
        }
        return Constant.DEFAULTNULL;
    }

    @Override
    public List<UserBo> queryUserByPartnerIdAndRoleId(int partnerId, int roleId, UserBo currentUser, PaginationBo paginationBo) {
        if (currentUser == null) {
            throw new ManagerException("无效请求参数");
        }

        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);

        // only admins are allowed here
        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call queryUserByPartnerIdAndRoleId at " + new Date(), currentUserEntity.getName()));
        } else {
            throw new AuthenticationException("Non-admin user querying someone else's user");
        }

        List<UserEntityExt> results = null;
        try {
            results = userMapper.listByPartnerIdAndRoleId(partnerId, roleId, page);
        } catch (Throwable t) {
            throw new ManagerException("User query failed for user: " + currentUserEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<UserBo>();
        }
        List<UserBo> convertedResults = new ArrayList<UserBo>();
        for (UserEntityExt userPo : results) {
            convertedResults.add(UserConverter.toBo(userPo));
        }
        return convertedResults;
    }
}
