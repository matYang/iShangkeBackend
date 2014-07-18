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
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class MessageServiceImpl implements MessageService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageManager messageManager;

    @Override
    public MessageBo sendMessage(MessageBo messageBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return messageManager.sendMessage(messageBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.MESSAGE_SEND_ERROR);
            exception.setMessageKey(ManagerErrorCode.MESSAGE_SEND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public MessageBo receiveMessage(MessageBo messageBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return messageManager.receiveMessage(messageBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.MESSAGE_RECEIVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.MESSAGE_RECEIVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public MessageBo deleteMessage(MessageBo messageBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return messageManager.deleteMessage(messageBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.MESSAGE_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.MESSAGE_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<MessageBo> query(MessageBo messageBo, UserBo userBo, PaginationBo paginationBo)
            throws BusinessExceptionBo, TException {
        try {
            return messageManager.query(messageBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.MESSAGE_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.MESSAGE_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
