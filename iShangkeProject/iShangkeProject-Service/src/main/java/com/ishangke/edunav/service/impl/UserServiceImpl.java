package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.UserService;
import com.ishangke.edunav.manager.UserManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class UserServiceImpl implements UserService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManager;

    @Override
    public UserBo authenticate(String sessionString, String permissionTag) throws BusinessExceptionBo, TException {
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
    public UserBo registerUser(UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.registerUser(userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_REGISTER_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_REGISTER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo loginByPhone(LoginBo loginBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.loginByPhone(loginBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_LOGINBYPHONE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_LOGINBYPHONE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo loginByReference(LoginBo loginBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.loginByReference(loginBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_LOGINBYREFERENCE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_LOGINBYREFERENCE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo createUser(UserBo targetUser, PartnerBo partnerBo, UserBo currentUser, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return userManager.createUser(targetUser, partnerBo, currentUser);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo deleteUser(UserBo targetUser, UserBo currentUser, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.deleteUser(targetUser, currentUser);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo updateUser(UserBo targetUser, UserBo currentUser, String permissionTag) throws BusinessExceptionBo, TException {
        try {
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
    public List<UserBo> queryUserInfo(UserBo queryUser, UserBo currentUser, String permissionTag) throws BusinessExceptionBo, TException {
        try {
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
    public List<UserBo> queryUser(UserBo queryUser, PartnerBo partnerBo, UserBo currentUser, PaginationBo pagnationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return userManager.queryUser(queryUser, partnerBo, currentUser, pagnationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<UserBo> querySession(UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.querySession(userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_QUERYSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_QUERYSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo disposeSession(UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.disposeSession(userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_DISPOSESESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_DISPOSESESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo openCellSession(SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.openCellSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_OPENCELLSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_OPENCELLSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo verifyCellSession(SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.verifyCellSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_VERIFYCELLSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_VERIFYCELLSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo openForgetPasswordSession(SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.openForgetPasswordSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_OPENFORGETPASSWORDSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_OPENFORGETPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo verifyForgetPasswordSession(SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.verifyForgetPasswordSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_VERIFYFORGETPASSWORDSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_VERIFYFORGETPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo openChangePasswordSession(SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.openChangePasswordSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_OPENCHANGEPASSWORDSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_OPENCHANGEPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo verifyChangePasswordSession(SessionBo sessionBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return userManager.verifyChangePasswordSession(sessionBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_VERIFYCHANGEPASSWORDSESSION_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_VERIFYCHANGEPASSWORDSESSION_ERROR_KEY);
            throw exception;
        }
    }

}
