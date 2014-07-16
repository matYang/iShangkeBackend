include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/contact.thrift"


namespace java com.ishangke.edunav.commoncontract.service

service ContactService{


	/**
     *  创建常用联系人信息。<br>
     *  用户可以创建常用联系人信息
     *
     *  @param  contactBo          需要创建的常用联系人信息
     *  @param  userBo             发起创建的用户信息
     *
     *  @return 创建完成的常用联系人信息
     *
     */
    common.ResponseBo createContact(1: contact.ContactBo contactBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  更新常用联系人信息。<br>
     *  用户可以更新常用联系人信息
     *
     *  @param  contactBo          需要更新的常用联系人信息
     *  @param  userBo             发起更新的用户信息
     *
     *  @return 更新完成的常用联系人信息
     *
     */
    common.ResponseBo updateContact(1: contact.ContactBo contactBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  删除常用联系人信息。<br>
     *  用户可以删除常用联系人信息
     *
     *  @param  contactBo          需要删除的常用联系人信息
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 
     *
     */
    common.ResponseBo deleteContact(1: contact.ContactBo contactBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询常用联系人信息。<br>
     *  用户可以查询常用联系人信息
     *
     *  @param  contactBo          需要查询的常用联系人信息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return  Contact 列表
     *
     */
    common.ResponseBo query(1: contact.ContactBo contactBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
	
}