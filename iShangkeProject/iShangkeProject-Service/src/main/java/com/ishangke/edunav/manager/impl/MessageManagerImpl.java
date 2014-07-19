package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.common.enums.MessageEnums;
import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.MessageEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.MessageEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.MessageManager;
import com.ishangke.edunav.manager.converter.MessageConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class MessageManagerImpl implements MessageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManagerImpl.class);

    @Autowired
    private MessageEntityExtMapper messageMapper;

    @Override
    public MessageBo sendMessage(MessageBo messageBo, UserBo userBo) {
        if (messageBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 插入新的message记录
        MessageEntityExt messageEntity = MessageConverter.fromBo(messageBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        int result = 0;
        try {
            messageEntity.setStatus(MessageEnums.Status.UNREAD.code);
            result = messageMapper.add(messageEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Message creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            messageEntity.setId(result);
            return MessageConverter.toBo(messageEntity);
        } else {
            throw new ManagerException("Message creation failed for user: " + userEntity.getId());
        }
    }

    @Override
    public MessageBo receiveMessage(MessageBo messageBo, UserBo userBo) {
        if (messageBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        MessageEntityExt messageEntity = MessageConverter.fromBo(messageBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        // only if a message is in naive state can it be approved
        if (messageEntity.getStatus() == MessageEnums.Status.UNREAD.code) {
            messageEntity.setStatus(MessageEnums.Status.READ.code);
        } else {
            throw new ManagerException("Message approval failed for user: " + userEntity.getId());
        }

        try {
            messageMapper.update(messageEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Message approval failed for user: " + userEntity.getId(), t);
        }

        return MessageConverter.toBo(messageEntity);
    }

    @Override
    public MessageBo deleteMessage(MessageBo messageBo, UserBo userBo) {
        if (messageBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        MessageEntityExt messageEntity = MessageConverter.fromBo(messageBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            messageEntity.setDeleted(1);
            messageMapper.deleteById(messageEntity.getId());
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Message deletion failed for user: " + userEntity.getId(), t);
        }

        return MessageConverter.toBo(messageEntity);
    }

    @Override
    public List<MessageBo> query(MessageBo messageBo, UserBo userBo, PaginationBo paginationBo) {

        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        MessageEntityExt messageEntity = messageBo == null ? null : MessageConverter.fromBo(messageBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        List<MessageEntityExt> results = null;
        try {
            results = messageMapper.list(messageEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Message query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<MessageBo>();
        }
        List<MessageBo> convertedResults = new ArrayList<MessageBo>();
        for (MessageEntityExt result : results) {
            convertedResults.add(MessageConverter.toBo(result));
        }
        return convertedResults;
    }

}
