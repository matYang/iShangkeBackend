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
import com.ishangke.edunav.commoncontract.model.UserBo;
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
    public UserBo registerUser(UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return userManager.registerUser(userBo);
        } catch (ManagerException e) {
            // 这里的LOG作为系统内部的log 需要比较详细的解释
            LOGGER.info(e.getMessage(), e);

            // 这里的异常是用来返回给thrift service的调用端 用errorCode和key来表示 是为了方便管理
            // 更为以后国际化做铺垫
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.USER_REGISTER_ERROR);
            exception.setMessageKey(ManagerErrorCode.USER_REGISTER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public UserBo login(LoginBo loginBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo createUser(UserBo targetUser, PartnerBo partnerBo, UserBo currentUser) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo deleteUser(UserBo targetUser, UserBo currentUser) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo updateUser(UserBo targetUser, UserBo currentUser) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserBo> queryUserInfo(UserBo queryUser, UserBo currentUser) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserBo> queryUser(UserBo queryUser, PartnerBo partnerBo, UserBo currentUser, PaginationBo pagnationBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserBo> querySession(UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo disposeSession(UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo openCellSession(SessionBo sessionBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo verifyCellSession(SessionBo sessionBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo openForgetPasswordSession(SessionBo sessionBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo verifyForgetPasswordSession(SessionBo sessionBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo openChangePasswordSession(SessionBo sessionBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo verifyChangePasswordSession(SessionBo sessionBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

}
