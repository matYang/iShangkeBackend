include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/partner.thrift"
include "model/message.thrift"
include "model/partner.thrift"
include "model/course.thrift"
include "model/spread.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service UserService {

    /**********************************************************
    *
    *   关于用户账号的 User
    *
    **********************************************************/

    /**
     *  本方法为普通用户提供自动识别的功能。<br>
     *  API端读取用户前端存储的session string，调用该方法自动获得当前用户信息
     *  @param  sessionString 
     *  @return 用户实体 UserBo
     */
    user.UserBo authenticate(1: user.SessionBo sessionBo, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为销毁用户session信息的功能<br>
     *
     *  @param  userBo        需要被销毁session的用户信息
     *
     *  @return 
     *
     */
    void disposeSession(1: user.SessionBo sessionBo, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为普通用户提供手机验证。<br>
     *  用户可以通过此方法向用户发送验证短信。
     *  @param  sessionBo          用户信息
     *  @return 用户实体          UserBo
     */
    user.SessionBo openCellSession(1: user.UserBo userBo, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为普通用户提供忘记密码时手机验证。<br>
     *  用户可以通过此方法向用户发送验证短信。
     *  @param  sessionBo        用户信息
     *  @return 用户实体          UserBo
     */
    user.SessionBo openForgetPasswordSession(1: user.UserBo userBo, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法找回用户密码。<br>
     */
    user.UserBo recoverPassword(1: user.PasswordBo passwordBo, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

	/**
     *  本方法更改用户密码。<br>
     */
    user.UserBo changePassword(1: user.PasswordBo passwordBo, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	


    /**
     *  本方法为所有用户提供使用手机号码是登录的功能。<br>
     *  所有有记录的用户都可以包括普通用户，合作商管理员，ishangke管理员。
     *
     *  @param  loginBo       用户登录信息
     *
     *  @return SessionBo
     *
     */
    user.SessionBo loginByPhone(1: user.LoginBo loginBo, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为所有用户提供使用识别号登录的功能。<br>
     *  所有有记录的用户都可以包括普通用户，合作商管理员，ishangke管理员。
     *
     *  @param  loginBo       用户登录信息
     *
     *  @return SessionBo
     *
     */
    user.SessionBo loginByReference(1: user.LoginBo loginBo, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
	/**
     *  本方法为普通用户提供注册的功能。<br>
     *  用户可以通过此方法进行注册。
     *  @param  userBo    用户注册信息
     *  @return 用户实体 UserBo
     */
    user.UserBo registerUser(1: user.UserBo userBo, 2: user.SessionBo sessionBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    user.UserBo createPartnerUser(1: user.UserBo targetUser, 2: partner.PartnerBo partnerBo, 3: user.UserBo currentUser, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
     
    user.UserBo createUser(1: user.UserBo targetUser, 2: user.UserBo currentUser, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    user.UserBo deleteUser(1: user.UserBo targetUser, 2: user.UserBo currentUser, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    user.UserBo updateUser(1: user.UserBo targetUser, 2: user.UserBo currentUser, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    user.UserBo queryUserInfo(1: user.UserBo queryUser, 2: user.UserBo currentUser, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    user.UserPageViewBo queryUser(1: user.UserBo queryUser, 2: user.UserBo currentUser, 3: common.PaginationBo pagnationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)




    /**********************************************************
    *
    *   关于用户之间传信的 Message
    *
    **********************************************************/

    /**
     *  发送消息。<br>
     *  用户可以发送消息
     *
     *  @param  messageBo          需要创建的消息
     *  @param  userBo             发起创建的用户信息
     *
     *  @return 发送完成的消息
     *
     */
    message.MessageBo sendMessage(1: message.MessageBo messageBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  读取消息。<br>
     *  用户可以读取消息
     *
     *  @param  messageBo          需要读取的消息
     *  @param  userBo             发起读取的用户信息
     *
     *  @return 读取完成的消息
     *
     */
    message.MessageBo receiveMessage(1: message.MessageBo messageBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  删除消息。<br>
     *  用户可以删除消息
     *
     *  @param  messageBo          需要删除的消息
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 
     *
     */
    message.MessageBo deleteMessage(1: message.MessageBo messageBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询消息。<br>
     *  用户可以查询消息
     *
     *  @param  messageBo          需要查询的消息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return  Message 列表
     *
     */
    message.MessagePageViewBo queryMessage(1: message.MessageBo messageBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)







    /**********************************************************
    *
    *   关于宣传的 Spread
    *
    **********************************************************/

    /**
     *  生成识别码。<br>
     *  每条推广信息都需要独立的识别码
     *
     *  @param  userBo          发布推广信息的用户
     *  @param  partnerBo       用户推广的机构信息
     *  @param  courseBo        用户推广的课程信息
     *  @param  iShangkeBo      用户推广的爱上课信息
     *
     *  @return 创建完毕的识别码
     *
     */ 
    spread.SpreadBo generateCode(1: user.UserBo userBo, 2: partner.PartnerBo partnerBo, 3: course.CourseBo courseBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询推广信息。<br>
     *  管理员可以查询推广信息
     *
     *  @param  spreadBo           需要查询的推广信息
     *  @param  userBo             推广相关的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return 推广信息实体 SpreadBo 列表
     *
     */ 
    spread.SpreadPageViewBo querySpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  创建推广信息。<br>
     *  用户可以创建推广信息，以供管理员审查
     *
     *  @param  spreadBo        需要创建的推广信息
     *  @param  partnerBo       用户推广的机构信息
     *  @param  courseBo        用户推广的课程信息
     *  @param  iShangkeBo      用户推广的爱上课信息
     *  @param  userBo          发布推广信息的用户
     *
     *  @return 创建完毕的推广信息
     *
     */ 
    spread.SpreadBo createSpread(1: spread.SpreadBo spreadBo, 2: partner.PartnerBo partnerBo, 3: course.CourseBo courseBo, 4: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  认可推广信息。<br>
     *  管理员可以审核认可用户发布的推广信息
     *
     *  @param  spreadBo           待认可的推广信息
     *  @param  userBo             发起认可的管理员信息
     *
     *  @return 认可之后的推广信息
     *
     */
    spread.SpreadBo approveSpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  拒绝推广信息。<br>
     *  管理员可以审核拒绝用户发布的推广信息
     *
     *  @param  spreadBo           待拒绝的推广信息
     *  @param  userBo             发起拒绝的管理员信息
     *
     *  @return 拒绝之后的推广信息
     *
     */
    spread.SpreadBo rejectSpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  取消推广信息。<br>
     *  用户可以取消待审核的推广信息
     *
     *  @param  spreadBo           待取消的推广信息
     *  @param  userBo             发起取消的用户信息
     *
     *  @return 取消之后的推广信息
     *
     */
    spread.SpreadBo cancelSpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  删除推广信息。<br>
     *  用户可以删除推广信息记录
     *
     *  @param  spreadBo           待删除的推广信息
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 删除之后的推广信息
     *
     */
    spread.SpreadBo deleteSpread(1: spread.SpreadBo spreadBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}

