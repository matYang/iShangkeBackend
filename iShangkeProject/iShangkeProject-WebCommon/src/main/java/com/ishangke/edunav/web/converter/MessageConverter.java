package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.web.model.MessageVo;
import com.ishangke.edunav.web.common.DateUtility;

public class MessageConverter {
    public static MessageBo fromModel(MessageVo vo) {
        MessageBo messageBo = new MessageBo();
        messageBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        messageBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        messageBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        messageBo.setReadTime(vo.getReadTime().getTimeInMillis());
        messageBo.setReadTimeEnd(vo.getReadTimeEnd().getTimeInMillis());
        messageBo.setReadTimeStart(vo.getReadTimeStart().getTimeInMillis());
        messageBo.setId(vo.getId());
        messageBo.setIdSet(vo.getIdSet());
        messageBo.setMessageText(vo.getMessageText());
        messageBo.setUserFromId(vo.getUserFromId());
        messageBo.setUserToId(vo.getUserToId());
        messageBo.setStatus(vo.getStatus());
        messageBo.setUserFromIdSet(vo.getUserFromIdSet());
        messageBo.setUserToIdSet(vo.getUserToIdSet());
        messageBo.setStatusSet(vo.getStatusSet());
        return messageBo;
    }

    public static MessageVo toModel(MessageBo bo) {
        MessageVo messageVo = new MessageVo();
        messageVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        messageVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        messageVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        messageVo.setReadTime(DateUtility.getTimeFromLong(bo.getReadTime()));
        messageVo.setReadTimeEnd(DateUtility.getTimeFromLong(bo.getReadTimeEnd()));
        messageVo.setReadTimeStart(DateUtility.getTimeFromLong(bo.getReadTimeStart()));
        messageVo.setId(bo.getId());
        messageVo.setIdSet(bo.getIdSet());
        messageVo.setMessageText(bo.getMessageText());
        messageVo.setUserFromId(bo.getUserFromId());
        messageVo.setUserToId(bo.getUserToId());
        messageVo.setStatus(bo.getStatus());
        messageVo.setUserFromIdSet(bo.getUserFromIdSet());
        messageVo.setUserToIdSet(bo.getUserToIdSet());
        messageVo.setStatusSet(bo.getStatusSet());
        return messageVo;
    }
}
