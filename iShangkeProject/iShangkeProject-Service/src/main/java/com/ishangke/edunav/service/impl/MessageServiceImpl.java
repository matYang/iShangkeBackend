package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.MessageService;
import com.ishangke.edunav.manager.MessageManager;

public class MessageServiceImpl implements MessageService.Iface{
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
    
    @Autowired
    private MessageManager messageManager;

    @Override
    public MessageBo sendMessage(MessageBo messageBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MessageBo receiveMessage(MessageBo messageBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MessageBo deleteMessage(MessageBo messageBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<MessageBo> query(MessageBo messageBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }
    

}
