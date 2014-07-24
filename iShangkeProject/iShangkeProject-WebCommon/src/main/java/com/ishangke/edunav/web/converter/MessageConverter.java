package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.web.model.MessageVo;

public class MessageConverter {
    public static MessageBo fromModel(MessageVo vo) {
        MessageBo messageBo = new MessageBo();
        if (vo.getId() != null) {
            messageBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            messageBo.setIdSet(vo.getIdSet());
        }
        if (vo.getMessageText() != null) {
            messageBo.setMessageText(vo.getMessageText());
        }
        if (vo.getUserFromId() != null) {
            messageBo.setUserFromId(vo.getUserFromId());
        }
        if (vo.getUserToId() != null) {
            messageBo.setUserToId(vo.getUserToId());
        }
        if (vo.getStatus() != null) {
            messageBo.setStatus(vo.getStatus());
        }
        if (vo.getUserFromIdSet() != null) {
            messageBo.setUserFromIdSet(vo.getUserFromIdSet());
        }
        if (vo.getUserToIdSet() != null) {
            messageBo.setUserToIdSet(vo.getUserToIdSet());
        }
        if (vo.getStatusSet() != null) {
            messageBo.setStatusSet(vo.getStatusSet());
        }
        messageBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        messageBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        messageBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        messageBo.setReadTime(vo.getReadTime() == null ? Constant.DEFAULTNULL : vo.getReadTime().getTimeInMillis());
        messageBo.setReadTimeEnd(vo.getReadTimeEnd() == null ? Constant.DEFAULTNULL : vo.getReadTimeEnd().getTimeInMillis());
        messageBo.setReadTimeStart(vo.getReadTimeStart() == null ? Constant.DEFAULTNULL : vo.getReadTimeStart().getTimeInMillis());
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
