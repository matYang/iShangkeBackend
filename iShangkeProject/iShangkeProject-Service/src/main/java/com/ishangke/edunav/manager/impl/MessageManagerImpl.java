package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.MessageEntityExtMapper;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.MessageManager;

@Component
public class MessageManagerImpl implements MessageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManagerImpl.class);

    @Autowired
    private MessageEntityExtMapper messageMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public MessageBo sendMessage(MessageBo messageBo, UserBo userBo) {
        return null;
    }

    @Override
    public MessageBo receiveMessage(MessageBo messageBo, UserBo userBo) {
        return null;
    }

    @Override
    public MessageBo deleteMessage(MessageBo messageBo, UserBo userBo) {
        return null;
    }

    @Override
    public List<MessageBo> query(MessageBo messageBo, UserBo userBo, PaginationBo paginationBo) {
        return null;
    }



}
