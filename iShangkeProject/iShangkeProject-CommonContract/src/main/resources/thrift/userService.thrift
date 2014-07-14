include "fault.thrift"
include "common.thrift"
include "user.thrift"
include "partner.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service UserService {
    /**
     *  本方法为普通用户提供注册的功能。<br>
     *  用户可以通过此方法进行注册。
     *  @param  userBo    用户注册信息
     *  @return 用户实体 UserBo
     */
    common.ResponseBo registerUser(1: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为所有用户提供登录的功能。<br>
     *  所有有记录的用户都可以包括普通用户，合作商管理员，ishangke管理员。
     *
     *  @param  loginBo       用户登录信息
     *
     *  @return 用户实体 UserBo
     *
     */
    common.ResponseBo login(1: user.LoginBo loginBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    common.ResponseBo createUser(1: user.UserBo targetUser, 2: common.PaginationBo paginationBo, 3: user.UserBo currentUser) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    common.ResponseBo deleteUser(1: user.UserBo targetUser, 2: user.UserBo currentUser) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    common.ResponseBo updateUser(1: user.UserBo targetUser, 2: user.UserBo currentUser) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    common.ResponseBo queryUserInfo(1: user.UserBo queryUser, 2: user.UserBo currentUser) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    common.ResponseBo queryUser(1: user.UserBo queryUser, 2: partner.PartnerBo partnerBo, 3: user.UserBo currentUser, 4: common.PaginationBo pagnationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询用户session信息的功能<br>
     *
     *  @param  userBo        需要被查询session的用户信息
     *
     *  @return 用户session相关信息
     *
     */
    common.ResponseBo querySession(1: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)


    /**
     *  本方法为销毁用户session信息的功能<br>
     *
     *  @param  userBo        需要被销毁session的用户信息
     *
     *  @return 
     *
     */
    common.ResponseBo disposeSession(1: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}

