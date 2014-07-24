package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.UserService;
import com.ishangke.edunav.manager.MessageManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.SpreadManager;
import com.ishangke.edunav.manager.UserManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;

@Component
public class UserServiceImpl implements UserService.Iface {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManager;
    @Autowired
    private MessageManager messageManager;
    @Autowired
    private SpreadManager spreadManager;
    @Autowired
    private PermissionManager permissionManager;

    /**********************************************************
     * 
     * 关于用户账号的 User
     * 
     **********************************************************/
    @Override
    public UserBo authenticate(String sessionString, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return userManager.authenticate(sessionString);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_REGISTER_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_REGISTER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo registerUser(UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        userBo.getId(), permissionTag, "registerUser"));
                throw new NoPermissionException();
            }
            return userManager.registerUser(userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.PERMISSION_USER_REISTERUSER);
            exception
                    .setMessageKey(ManagerErrorCode.PERMISSION_USER_REISTERUSER_KEY);
            throw exception;
        }catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_REGISTER_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_REGISTER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo loginByPhone(LoginBo loginBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return userManager.loginByPhone(loginBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_LOGINBYPHONE_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_LOGINBYPHONE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo loginByReference(LoginBo loginBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return userManager.loginByReference(loginBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.USER_LOGINBYREFERENCE_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_LOGINBYREFERENCE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo createUser(UserBo targetUser, PartnerBo partnerBo,
            UserBo currentUser, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        currentUser.getId(), permissionTag, "createUser"));
                throw new NoPermissionException();
            }

            return userManager.createUser(targetUser, partnerBo, currentUser);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_CREATE);
            exception
                    .setMessageKey(ManagerErrorCode.PERMISSION_USER_CREATE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo deleteUser(UserBo targetUser, UserBo currentUser,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        currentUser.getId(), permissionTag, "deleteUser"));
                throw new NoPermissionException();
            }
            return userManager.deleteUser(targetUser, currentUser);
        }catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_DELETEUSER);
            exception
                    .setMessageKey(ManagerErrorCode.PERMISSION_USER_DELETEUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo updateUser(UserBo targetUser, UserBo currentUser,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        currentUser.getId(), permissionTag, "updateUser"));
                throw new NoPermissionException();
            }
            return userManager.updateUser(targetUser, currentUser);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<UserBo> queryUserInfo(UserBo queryUser, UserBo currentUser,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        currentUser.getId(), permissionTag, "queryUserInfo"));
                throw new NoPermissionException();
            }
            return userManager.queryUserInfo(queryUser, currentUser);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_QUERYINFO_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_QUERYINFO_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<UserBo> queryUser(UserBo queryUser, PartnerBo partnerBo,
            UserBo currentUser, PaginationBo pagnationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        currentUser.getId(), permissionTag, "queryUser"));
                throw new NoPermissionException();
            }
            return userManager.queryUser(queryUser, partnerBo, currentUser,
                    pagnationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<UserBo> querySession(UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return userManager.querySession(userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_QUERYSESSION_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_QUERYSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo disposeSession(UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return userManager.disposeSession(userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_DISPOSESESSION_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_DISPOSESESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo openCellSession(SessionBo sessionBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return userManager.openCellSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_OPENCELLSESSION_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_OPENCELLSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo verifyCellSession(SessionBo sessionBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return userManager.verifyCellSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.USER_VERIFYCELLSESSION_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_VERIFYCELLSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo openForgetPasswordSession(SessionBo sessionBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.openForgetPasswordSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.USER_OPENFORGETPASSWORDSESSION_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_OPENFORGETPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo verifyForgetPasswordSession(SessionBo sessionBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.verifyForgetPasswordSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.USER_VERIFYFORGETPASSWORDSESSION_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_VERIFYFORGETPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo openChangePasswordSession(SessionBo sessionBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.openChangePasswordSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.USER_OPENCHANGEPASSWORDSESSION_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_OPENCHANGEPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo verifyChangePasswordSession(SessionBo sessionBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.verifyChangePasswordSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.USER_VERIFYCHANGEPASSWORDSESSION_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.USER_VERIFYCHANGEPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于用户之间传信的 Message
     * 
     **********************************************************/
    @Override
    public MessageBo sendMessage(MessageBo messageBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
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
    public MessageBo receiveMessage(MessageBo messageBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
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
    public MessageBo deleteMessage(MessageBo messageBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
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
    public List<MessageBo> queryMessage(MessageBo messageBo, UserBo userBo,
            PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return messageManager.query(messageBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.MESSAGE_NOTFOUND_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.MESSAGE_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于宣传的 Spread
     * 
     **********************************************************/
    @Override
    public SpreadBo generateCode(UserBo userBo, PartnerBo partnerBo,
            CourseBo courseBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return spreadManager.generateCode(userBo, partnerBo, courseBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_GENERATECODE_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.SPREAD_GENERATECODE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<SpreadBo> querySpread(SpreadBo spreadBo, UserBo userBo,
            PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return spreadManager.query(spreadBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo createSpread(SpreadBo spreadBo, PartnerBo partnerBo,
            CourseBo courseBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return spreadManager.createSpread(spreadBo, partnerBo, courseBo,
                    userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo approveSpread(SpreadBo spreadBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return spreadManager.approveSpread(spreadBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_APPROVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_APPROVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo rejectSpread(SpreadBo spreadBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return spreadManager.rejectSpread(spreadBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_REJECT_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_REJECT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo cancelSpread(SpreadBo spreadBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return spreadManager.cancelSpread(spreadBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_CANCEL_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_CANCEL_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo deleteSpread(SpreadBo spreadBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return spreadManager.deleteSpread(spreadBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_DELETE_ERROR_KEY);
            throw exception;
        }
    }

}
