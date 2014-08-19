package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.web.model.MessageVo;

public class MessageConverter {
    public static MessageBo fromModel(MessageVo vo) {
        if (vo == null) {
            return null;
        }
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
        } else {
            messageBo.setStatus(Constant.DEFAULTNULL);
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
        if (vo.getCreateTime() != null) {
            messageBo.setCreateTime(vo.getCreateTime());
        } else {
            messageBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            messageBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            messageBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            messageBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            messageBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getReadTime() != null) {
            messageBo.setReadTime(vo.getReadTime());
        } else {
            messageBo.setReadTime(Constant.DEFAULTNULL);
        }
        if (vo.getReadTimeEnd() != null) {
            messageBo.setReadTimeEnd(vo.getReadTimeEnd());
        } else {
            messageBo.setReadTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getReadTimeStart() != null) {
            messageBo.setReadTimeStart(vo.getReadTimeStart());
        } else {
            messageBo.setReadTimeStart(Constant.DEFAULTNULL);
        }
        return messageBo;
    }

    public static MessageVo toModel(MessageBo bo) {

        if (bo == null) {
            return null;
        }
        MessageVo messageVo = new MessageVo();
        messageVo.setCreateTime(bo.getCreateTime());
        messageVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        messageVo.setCreateTimeStart(bo.getCreateTimeStart());
        messageVo.setReadTime(bo.getReadTime());
//        messageVo.setReadTimeEnd(bo.getReadTimeEnd());
//        messageVo.setReadTimeStart(bo.getReadTimeStart());
        messageVo.setId(bo.getId());
//        messageVo.setIdSet(bo.getIdSet());
        messageVo.setMessageText(bo.getMessageText());
        messageVo.setUserFromId(bo.getUserFromId());
        messageVo.setUserToId(bo.getUserToId());
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            messageVo.setStatus(bo.getStatus());
        }
//        messageVo.setUserFromIdSet(bo.getUserFromIdSet());
//        messageVo.setUserToIdSet(bo.getUserToIdSet());
//        messageVo.setStatusSet(bo.getStatusSet());
        return messageVo;
    }
}
