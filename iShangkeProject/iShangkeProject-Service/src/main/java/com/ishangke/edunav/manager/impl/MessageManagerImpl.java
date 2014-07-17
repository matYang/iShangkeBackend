package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.MessageManager;

public class MessageManagerImpl implements MessageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManagerImpl.class);

    @Override
    public MessageBo sendMessage(MessageBo messageBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MessageBo receiveMessage(MessageBo messageBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MessageBo deleteMessage(MessageBo messageBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MessageBo> query(MessageBo messageBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
