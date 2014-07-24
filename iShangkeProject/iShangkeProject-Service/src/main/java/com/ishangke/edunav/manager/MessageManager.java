package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

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
    MessageBo sendMessage(MessageBo messageBo, UserBo userBo);

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
    MessageBo receiveMessage(MessageBo messageBo, UserBo userBo);

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
    MessageBo deleteMessage(MessageBo messageBo, UserBo userBo);

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
    List<MessageBo> query(MessageBo messageBo, UserBo userBo, PaginationBo paginationBo);

}
