include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/message.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service MessageService{
	
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
    common.ResponseBo sendMessage(1: message.MessageBo messageBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    common.ResponseBo receiveMessage(1: message.MessageBo messageBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    common.ResponseBo deleteMessage(1: message.MessageBo messageBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    common.ResponseBo query(1: message.MessageBo messageBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	

}