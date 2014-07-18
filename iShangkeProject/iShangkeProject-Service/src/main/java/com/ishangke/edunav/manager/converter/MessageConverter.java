package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.dataaccess.model.MessageEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class MessageConverter {
    public static MessageBo toBo(MessageEntityExt e) {
        MessageBo messageBo = new MessageBo();
        messageBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        messageBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        messageBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        messageBo.setId(e.getId());
        messageBo.setIdSet(e.getIdSet());
        messageBo.setMessageText(e.getMessageText());
        messageBo.setUserFromId(e.getUserFromId());
        messageBo.setUserToId(e.getUserToId());
        return messageBo;
    }

    public static MessageEntityExt fromBo(MessageBo bo) {
        MessageEntityExt messageEntityExt = new MessageEntityExt();
        messageEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        messageEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        messageEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        messageEntityExt.setId(bo.getId());
        messageEntityExt.setIdSet(bo.getIdSet());
        messageEntityExt.setMessageText(bo.getMessageText());
        messageEntityExt.setUserFromId(bo.getUserFromId());
        messageEntityExt.setUserToId(bo.getUserToId());
        return messageEntityExt;
    }
}
