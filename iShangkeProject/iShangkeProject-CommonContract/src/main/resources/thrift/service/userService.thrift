include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/partner.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service UserService {
    /**
     *  本方法为普通用户提供注册的功能。<br>
     *  用户可以通过此方法进行注册。
     *  @param  userBo    用户注册信息
     *  @return 用户实体 UserBo
     */
    user.UserBo registerUser(1: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为普通用户提供手机验证。<br>
     *  用户可以通过此方法向用户发送验证短信。
     *  @param  sessionBo          用户信息
     *  @return 用户实体          UserBo
     */
    user.UserBo openCellSession(1: user.SessionBo sessionBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法验证用户手机验证码。<br>
     *  用户可以通过此方法验证手机,如果通过则关闭session
     *  @param  sessionBo        用户信息
     *  @return 用户实体          UserBo
     */
    user.UserBo verifyCellSession(1: user.SessionBo sessionBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为普通用户提供忘记密码时手机验证。<br>
     *  用户可以通过此方法向用户发送验证短信。
     *  @param  sessionBo        用户信息
     *  @return 用户实体          UserBo
     */
    user.UserBo openForgetPasswordSession(1: user.SessionBo sessionBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法验证用户手机验证忘记密码的验证码。<br>
     *  用户可以通过此方法验证忘记密码,如果通过则关闭session
     *  @param  sessionBo        用户信息
     *  @return 用户实体          UserBo
     */
    user.UserBo verifyForgetPasswordSession(1: user.SessionBo sessionBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为普通用户提供修改密码时手机验证。<br>
     *  用户可以通过此方法向用户发送验证短信。
     *  @param  sessionBo        用户信息
     *  @return 用户实体          UserBo
     */
    user.UserBo openChangePasswordSession(1: user.SessionBo sessionBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法验证用户手机验证修改密码的验证码。<br>
     *  用户可以通过此方法验证修改密码,如果通过则关闭session
     *  @param  sessionBo        用户信息
     *  @return 用户实体          UserBo
     */
    user.UserBo verifyChangePasswordSession(1: user.SessionBo sessionBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)


    /**
     *  本方法为所有用户提供使用手机号码是登录的功能。<br>
     *  所有有记录的用户都可以包括普通用户，合作商管理员，ishangke管理员。
     *
     *  @param  loginBo       用户登录信息
     *
     *  @return 用户实体 UserBo
     *
     */
    user.UserBo loginByPhone(1: user.LoginBo loginBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为所有用户提供使用识别号登录的功能。<br>
     *  所有有记录的用户都可以包括普通用户，合作商管理员，ishangke管理员。
     *
     *  @param  loginBo       用户登录信息
     *
     *  @return 用户实体 UserBo
     *
     */
    user.UserBo loginByReference(1: user.LoginBo loginBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)


    /**
     *  本方法为ishangke管理员创建新用户<br>
     *  ishangke管理员可以创建合作商管理员，普通用户
     *
     *  @param  targetUser    需要被创建的用户信息
     *  @param  partnerBo     合作商信息
     *  @param  currentUser   调用方法的用户的信息
     *
     *  @return 用户实体 UserBo 
     *
     */
    user.UserBo createUser(1: user.UserBo targetUser, 2: partner.PartnerBo partnerBo, 3: user.UserBo currentUser) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为ishangke管理员删除用户<br>
     *  ishangke管理员可以删除合作商管理员，普通用户
     *
     *  @param  targetUser    需要被删除的用户信息
     *  @param  currentUser   调用方法的用户的信息
     *
     *  @return 删除结果 
     *
     */
    user.UserBo deleteUser(1: user.UserBo targetUser, 2: user.UserBo currentUser) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为修改用户信息的功能<br>
     *  ishangke管理员可以修改合作商管理员，普通用户的信息。任意用户可以修改自身的用户信息
     *
     *  @param  targetUser    需要被修改的用户信息
     *  @param  currentUser   调用方法的用户的信息
     *
     *  @return 用户实体 UserBo 
     *
     */
    user.UserBo updateUser(1: user.UserBo targetUser, 2: user.UserBo currentUser) throws (1: fault.BusinessExceptionBo businessExceptionBo)

     /**
     *  本方法为查看用户信息的功能<br>
     *  ishangke管理员可以查看合作商管理员，普通用户的信息。任意用户可以查看自身的用户信息
     *
     *  @param  queryUser     需要被查询的用户信息
     *  @param  currentUser   调用方法的用户的信息
     *
     *  @return 用户实体 UserBo 
     *
     */
    list<user.UserBo> queryUserInfo(1: user.UserBo queryUser, 2: user.UserBo currentUser) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询用户信息的功能<br>
     *  ishangke管理员可以按条件搜索合作商管理员、普通用户的信息。
     *
     *  @param  queryUser     需要检索和过滤的用户信息
     *  @param  partnerBo     合作商的用户的信息
     *  @param  currentUser   调用方法的用户的信息
     *  @param  paginationBo  分页信息
     *
     *  @return 用户实体 UserBo 列表
     *
     */
    list<user.UserBo> queryUser(1: user.UserBo queryUser, 2: partner.PartnerBo partnerBo, 3: user.UserBo currentUser, 4: common.PaginationBo pagnationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询用户session信息的功能<br>
     *
     *  @param  userBo        需要被查询session的用户信息
     *
     *  @return 用户session相关信息
     *
     */
    list<user.UserBo> querySession(1: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)


    /**
     *  本方法为销毁用户session信息的功能<br>
     *
     *  @param  userBo        需要被销毁session的用户信息
     *
     *  @return 
     *
     */
    user.UserBo disposeSession(1: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}

