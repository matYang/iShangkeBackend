package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.dataaccess.model.MessageEntityExt;

public class MessageConverter {
    public static MessageBo toBo(MessageEntityExt e) {
        MessageBo messageBo = new MessageBo();
        messageBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        messageBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        messageBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        messageBo.setReadTime(e.getReadTime() == null ? Constant.DEFAULTNULL : e.getReadTime().getTimeInMillis());
        messageBo.setReadTimeEnd(e.getReadTimeEnd() == null ? Constant.DEFAULTNULL : e.getReadTimeEnd().getTimeInMillis());
        messageBo.setReadTimeStart(e.getReadTimeStart() == null ? Constant.DEFAULTNULL : e.getReadTimeStart().getTimeInMillis());
        messageBo.setId(e.getId());
        messageBo.setIdSet(e.getIdSet());
        messageBo.setMessageText(e.getMessageText());
        messageBo.setUserFromId(e.getUserFromId());
        messageBo.setUserToId(e.getUserToId());
        messageBo.setStatus(e.getStatus());
        messageBo.setUserFromIdSet(e.getUserFromIdSet());
        messageBo.setUserToIdSet(e.getUserToIdSet());
        messageBo.setStatusSet(e.getStatusSet());
        return messageBo;
    }

    public static MessageEntityExt fromBo(MessageBo bo) {
        MessageEntityExt messageEntityExt = new MessageEntityExt();
        messageEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        messageEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        messageEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        messageEntityExt.setReadTime(DateUtility.getTimeFromLong(bo.getReadTime()));
        messageEntityExt.setReadTimeEnd(DateUtility.getTimeFromLong(bo.getReadTimeEnd()));
        messageEntityExt.setReadTimeStart(DateUtility.getTimeFromLong(bo.getReadTimeStart()));
        messageEntityExt.setId(bo.getId());
        messageEntityExt.setIdSet(bo.getIdSet());
        messageEntityExt.setMessageText(bo.getMessageText());
        messageEntityExt.setUserFromId(bo.getUserFromId());
        messageEntityExt.setUserToId(bo.getUserToId());
        messageEntityExt.setStatus(bo.getStatus());
        messageEntityExt.setUserFromIdSet(bo.getUserFromIdSet());
        messageEntityExt.setUserToIdSet(bo.getUserToIdSet());
        messageEntityExt.setStatusSet(bo.getStatusSet());
        return messageEntityExt;
    }
}
