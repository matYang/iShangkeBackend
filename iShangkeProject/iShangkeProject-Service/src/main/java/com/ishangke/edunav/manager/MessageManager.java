package com.ishangke.edunav.manager;

import java.util.List;

public interface MessageManager {

    /**
     * 发送消息。<br>
     * 用户可以发送消息
     * 
     * @param messageBo
     *            需要创建的消息
     * @param userBo
     *            发起创建的用户信息
     * 
     * @return 发送完成的消息
     * 
     * 
     * @param messageBo
     * @param userBo
     */
    public com.ishangke.edunav.commoncontract.model.MessageBo sendMessage(com.ishangke.edunav.commoncontract.model.MessageBo messageBo, com.ishangke.edunav.commoncontract.model.UserBo userBo)
            throws com.ishangke.edunav.commoncontract.model.BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 读取消息。<br>
     * 用户可以读取消息
     * 
     * @param messageBo
     *            需要读取的消息
     * @param userBo
     *            发起读取的用户信息
     * 
     * @return 读取完成的消息
     * 
     * 
     * @param messageBo
     * @param userBo
     */
    public com.ishangke.edunav.commoncontract.model.MessageBo receiveMessage(com.ishangke.edunav.commoncontract.model.MessageBo messageBo, com.ishangke.edunav.commoncontract.model.UserBo userBo)
            throws com.ishangke.edunav.commoncontract.model.BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 删除消息。<br>
     * 用户可以删除消息
     * 
     * @param messageBo
     *            需要删除的消息
     * @param userBo
     *            发起删除的用户信息
     * 
     * @return
     * 
     * 
     * @param messageBo
     * @param userBo
     */
    public com.ishangke.edunav.commoncontract.model.MessageBo deleteMessage(com.ishangke.edunav.commoncontract.model.MessageBo messageBo, com.ishangke.edunav.commoncontract.model.UserBo userBo)
            throws com.ishangke.edunav.commoncontract.model.BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 查询消息。<br>
     * 用户可以查询消息
     * 
     * @param messageBo
     *            需要查询的消息
     * @param userBo
     *            发起查询的用户信息
     * @param paginationBo
     *            分页信息
     * 
     * @return Message 列表
     * 
     * 
     * @param messageBo
     * @param userBo
     * @param paginationBo
     */
    public List<com.ishangke.edunav.commoncontract.model.MessageBo> query(com.ishangke.edunav.commoncontract.model.MessageBo messageBo, com.ishangke.edunav.commoncontract.model.UserBo userBo,
            com.ishangke.edunav.commoncontract.model.PaginationBo paginationBo) throws com.ishangke.edunav.commoncontract.model.BusinessExceptionBo, org.apache.thrift.TException;

}
