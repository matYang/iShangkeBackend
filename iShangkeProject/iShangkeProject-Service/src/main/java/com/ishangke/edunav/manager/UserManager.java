package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface UserManager {

    /**
     * 本方法为普通用户提供注册的功能。<br>
     * 用户可以通过此方法进行注册。
     * 
     * @param userBo
     *            用户注册信息
     * @return 用户实体 UserBo
     * 
     * @param userBo
     */
    public UserBo registerUser(UserBo userBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为普通用户提供手机验证。<br>
     * 用户可以通过此方法向用户发送验证短信。
     * 
     * @param sessionBo
     *            用户信息
     * @return 用户实体 UserBo
     * 
     * @param sessionBo
     */
    public UserBo openCellSession(SessionBo sessionBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法验证用户手机验证码。<br>
     * 用户可以通过此方法验证手机,如果通过则关闭session
     * 
     * @param sessionBo
     *            用户信息
     * @return 用户实体 UserBo
     * 
     * @param sessionBo
     */
    public UserBo verifyCellSession(SessionBo sessionBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为普通用户提供忘记密码时手机验证。<br>
     * 用户可以通过此方法向用户发送验证短信。
     * 
     * @param sessionBo
     *            用户信息
     * @return 用户实体 UserBo
     * 
     * @param sessionBo
     */
    public UserBo openForgetPasswordSession(SessionBo sessionBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法验证用户手机验证忘记密码的验证码。<br>
     * 用户可以通过此方法验证忘记密码,如果通过则关闭session
     * 
     * @param sessionBo
     *            用户信息
     * @return 用户实体 UserBo
     * 
     * @param sessionBo
     */
    public UserBo verifyForgetPasswordSession(SessionBo sessionBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为普通用户提供修改密码时手机验证。<br>
     * 用户可以通过此方法向用户发送验证短信。
     * 
     * @param sessionBo
     *            用户信息
     * @return 用户实体 UserBo
     * 
     * @param sessionBo
     */
    public UserBo openChangePasswordSession(SessionBo sessionBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法验证用户手机验证修改密码的验证码。<br>
     * 用户可以通过此方法验证修改密码,如果通过则关闭session
     * 
     * @param sessionBo
     *            用户信息
     * @return 用户实体 UserBo
     * 
     * @param sessionBo
     */
    public UserBo verifyChangePasswordSession(SessionBo sessionBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为所有用户提供登录的功能。<br>
     * 所有有记录的用户都可以包括普通用户，合作商管理员，ishangke管理员。
     * 
     * @param loginBo
     *            用户登录信息
     * 
     * @return 用户实体 UserBo
     * 
     * 
     * @param loginBo
     */
    public UserBo login(LoginBo loginBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为ishangke管理员创建新用户<br>
     * ishangke管理员可以创建合作商管理员，普通用户
     * 
     * @param targetUser
     *            需要被创建的用户信息
     * @param partnerBo
     *            合作商信息
     * @param currentUser
     *            调用方法的用户的信息
     * 
     * @return 用户实体 UserBo
     * 
     * 
     * @param targetUser
     * @param partnerBo
     * @param currentUser
     */
    public UserBo createUser(UserBo targetUser, PartnerBo partnerBo, UserBo currentUser) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为ishangke管理员删除用户<br>
     * ishangke管理员可以删除合作商管理员，普通用户
     * 
     * @param targetUser
     *            需要被删除的用户信息
     * @param currentUser
     *            调用方法的用户的信息
     * 
     * @return 删除结果
     * 
     * 
     * @param targetUser
     * @param currentUser
     */
    public UserBo deleteUser(UserBo targetUser, UserBo currentUser) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为修改用户信息的功能<br>
     * ishangke管理员可以修改合作商管理员，普通用户的信息。任意用户可以修改自身的用户信息
     * 
     * @param targetUser
     *            需要被修改的用户信息
     * @param currentUser
     *            调用方法的用户的信息
     * 
     * @return 用户实体 UserBo
     * 
     * 
     * @param targetUser
     * @param currentUser
     */
    public UserBo updateUser(UserBo targetUser, UserBo currentUser) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为查看用户信息的功能<br>
     * ishangke管理员可以查看合作商管理员，普通用户的信息。任意用户可以查看自身的用户信息
     * 
     * @param queryUser
     *            需要被查询的用户信息
     * @param currentUser
     *            调用方法的用户的信息
     * 
     * @return 用户实体 UserBo
     * 
     * 
     * @param queryUser
     * @param currentUser
     */
    public List<UserBo> queryUserInfo(UserBo queryUser, UserBo currentUser) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为查询用户信息的功能<br>
     * ishangke管理员可以按条件搜索合作商管理员、普通用户的信息。
     * 
     * @param queryUser
     *            需要检索和过滤的用户信息
     * @param partnerBo
     *            合作商的用户的信息
     * @param currentUser
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 用户实体 UserBo 列表
     * 
     * 
     * @param queryUser
     * @param partnerBo
     * @param currentUser
     * @param pagnationBo
     */
    public List<UserBo> queryUser(UserBo queryUser, PartnerBo partnerBo, UserBo currentUser, PaginationBo pagnationBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为查询用户session信息的功能<br>
     * 
     * @param userBo
     *            需要被查询session的用户信息
     * 
     * @return 用户session相关信息s
     * 
     * 
     * @param userBo
     */
    public List<UserBo> querySession(UserBo userBo) throws BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 本方法为销毁用户session信息的功能<br>
     * 
     * @param userBo
     *            需要被销毁session的用户信息
     * 
     * @return
     * 
     * 
     * @param userBo
     */
    public UserBo disposeSession(UserBo userBo) throws BusinessExceptionBo, org.apache.thrift.TException;

}
