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
import com.ishangke.edunav.commoncontract.model.MessagePageViewBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.SpreadPageViewBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.UserPageViewBo;
import com.ishangke.edunav.commoncontract.service.UserService;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.MessageManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.SpreadManager;
import com.ishangke.edunav.manager.UserManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;

@Component
public class UserServiceImpl implements UserService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManager;
    @Autowired
    private MessageManager messageManager;
    @Autowired
    private SpreadManager spreadManager;
    @Autowired
    private PermissionManager permissionManager;
    @Autowired
    private AuthManager authManager;

    /**********************************************************
     * 
     * 关于用户账号的 User
     * 
     **********************************************************/

    @Override
    public UserBo registerUser(UserBo userBo, SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return userManager.registerUser(userBo, sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_REGISTER_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_REGISTER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SessionBo loginByUser(LoginBo loginBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.loginByUser(loginBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_LOGINBYPHONE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_LOGINBYPHONE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SessionBo loginByReference(LoginBo loginBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.loginByReference(loginBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_LOGINBYREFERENCE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_LOGINBYREFERENCE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo createUser(UserBo targetUser, UserBo currentUser, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", currentUser.getId(), permissionTag,
                        "createUser"));
                throw new NoPermissionException();
            }

            return userManager.createUser(targetUser, currentUser);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_CREATE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_CREATE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo createPartnerUser(UserBo targetUser, PartnerBo partner, UserBo currentUser, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", currentUser.getId(), permissionTag,
                        "createUser"));
                throw new NoPermissionException();
            }

            return userManager.createPartnerUser(targetUser, partner, currentUser);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_CREATE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_CREATE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo deleteUser(UserBo targetUser, UserBo currentUser, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", currentUser.getId(), permissionTag,
                        "deleteUser"));
                throw new NoPermissionException();
            }
            return userManager.deleteUser(targetUser, currentUser);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_DELETEUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_DELETEUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo updateUser(UserBo targetUser, UserBo currentUser, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", currentUser.getId(), permissionTag,
                        "updateUser"));
                throw new NoPermissionException();
            }
            return userManager.updateUser(targetUser, currentUser);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_UPDATEUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_UPDATEUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo queryUserInfo(UserBo queryUser, UserBo currentUser, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", currentUser.getId(), permissionTag,
                        "queryUserInfo"));
                throw new NoPermissionException();
            }
            return userManager.queryUserInfo(queryUser, currentUser);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_QUERYUSERINFO);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_QUERYUSERINFO_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_QUERYINFO_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_QUERYINFO_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserPageViewBo queryUser(UserBo queryUser, UserBo currentUser, PaginationBo pagnationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(currentUser.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", currentUser.getId(), permissionTag,
                        "queryUser"));
                throw new NoPermissionException();
            }
            List<UserBo> data = userManager.queryUser(queryUser, currentUser, pagnationBo);
            UserPageViewBo pageView = new UserPageViewBo();
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_QUERYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_QUERYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo authenticate(SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.authenticate(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_REGISTER_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_REGISTER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public void disposeSession(SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            userManager.disposeSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_DISPOSESESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_DISPOSESESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SessionBo openCellSession(UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // 不需要进行权限控制
            return userManager.openCellSession(userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_OPENCELLSESSION);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_OPENCELLSESSION_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_OPENCELLSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_OPENCELLSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SessionBo openForgetPasswordSession(UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            // 不需要你进行权限控制，因为忘记密码的时候根本金牛不能登录
            return userManager.openForgetPasswordSession(userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_OPENFORGETPASSWORDSESSION);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_OPENFORGETPASSWORDSESSION_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_OPENFORGETPASSWORDSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_OPENFORGETPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SessionBo recoverPassword(PasswordBo passwordBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.recoverPassword(passwordBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_RECORVERPASSWORD_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_RECORVERPASSWORD_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SessionBo changePassword(PasswordBo passwordBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(passwordBo.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", passwordBo.getId(), permissionTag,
                        "changePassword"));
                throw new NoPermissionException();
            }
            return userManager.changePassword(passwordBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_CHANGEPASSWORD);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_CHANGEPASSWORD_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.USER_CHANGEPASSWORD_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_CHANGEPASSWORD_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于用户之间传信的 Message
     * 
     **********************************************************/
    @Override
    public MessageBo sendMessage(MessageBo messageBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "sendMessage"));
                throw new NoPermissionException();
            }
            return messageManager.sendMessage(messageBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_SENDMESSAGE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_SENDMESSAGE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.MESSAGE_SEND_ERROR);
            exception.setMessageKey(ManagerErrorCode.MESSAGE_SEND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public MessageBo receiveMessage(MessageBo messageBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "sendMessage"));
                throw new NoPermissionException();
            }
            return messageManager.receiveMessage(messageBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_RECEIVEMESSAGE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_RECEIVEMESSAGE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.MESSAGE_RECEIVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.MESSAGE_RECEIVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public MessageBo deleteMessage(MessageBo messageBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "sendMessage"));
                throw new NoPermissionException();
            }
            return messageManager.deleteMessage(messageBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_DELETEMESSAGE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_DELETEMESSAGE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.MESSAGE_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.MESSAGE_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public MessagePageViewBo queryMessage(MessageBo messageBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "sendMessage"));
                throw new NoPermissionException();
            }
            List<MessageBo> data = messageManager.query(messageBo, userBo, paginationBo);
            MessagePageViewBo pageView = new MessagePageViewBo();
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_QUERYMESSAGE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_QUERYMESSAGE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.MESSAGE_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.MESSAGE_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于宣传的 Spread
     * 
     **********************************************************/
    @Override
    public SpreadBo generateCode(UserBo userBo, PartnerBo partnerBo, CourseBo courseBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "generateCode"));
                throw new NoPermissionException();
            }
            return spreadManager.generateCode(userBo, partnerBo, courseBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_GENERATECODE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_GENERATECODE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.SPREAD_GENERATECODE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_GENERATECODE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadPageViewBo querySpread(SpreadBo spreadBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "querySpread"));
                throw new NoPermissionException();
            }
            List<SpreadBo> data = spreadManager.query(spreadBo, userBo, paginationBo);
            SpreadPageViewBo pageView = new SpreadPageViewBo();
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_QUERYSPREAD);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_QUERYSPREAD_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.SPREAD_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo createSpread(SpreadBo spreadBo, PartnerBo partnerBo, CourseBo courseBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "createSpread"));
                throw new NoPermissionException();
            }
            return spreadManager.createSpread(spreadBo, partnerBo, courseBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_CREATESPREAD);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_CREATESPREAD_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.SPREAD_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo approveSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "approveSpread"));
                throw new NoPermissionException();
            }
            return spreadManager.approveSpread(spreadBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_APPROVESPREAD);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_APPROVESPREAD_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.SPREAD_APPROVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_APPROVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo rejectSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "rejectSpread"));
                throw new NoPermissionException();
            }
            return spreadManager.rejectSpread(spreadBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_REJECTSPREAD);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_REJECTSPREAD_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.SPREAD_REJECT_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_REJECT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo cancelSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "cancelSpread"));
                throw new NoPermissionException();
            }
            return spreadManager.cancelSpread(spreadBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_CANCELSPREAD);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_CANCELSPREAD_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.SPREAD_CANCEL_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_CANCEL_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo deleteSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "deleteSpread"));
                throw new NoPermissionException();
            }
            return spreadManager.deleteSpread(spreadBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_USER_DELETESPREAD);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_USER_DELETESPREAD_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.SPREAD_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_DELETE_ERROR_KEY);
            throw exception;
        }
    }

}
