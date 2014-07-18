package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.UserManager;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class UserManagerImpl implements UserManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    private UserEntityExtMapper userMapper;

    @Override
    public UserBo registerUser(UserBo userBo) {
        // 参数验证
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 判断是否存在手机号码一样的USER
        UserEntityExt entityInDb = new UserEntityExt();
        entityInDb.setPhone(userBo.getPhone());

        List<UserEntityExt> entityList = userMapper.list(entityInDb, null);
        if (entityList.size() != 0) {
            throw new ManagerException(userBo.getPhone() + " is already in db");
        }

        // 插入新的USER
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        int result = 0;
        try {
            result = userMapper.add(userEntity);
        } catch (Throwable t) {
            throw new ManagerException("Register user with phone number: " + userBo.getPhone() + " failed", t);
        }

        if (result > 0) {
            return UserConverter.toBo(userEntity);
        } else {
            throw new ManagerException("Register user with phone number: " + userBo.getPhone() + " failed");
        }
    }

    @Override
    public UserBo openCellSession(SessionBo sessionBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo verifyCellSession(SessionBo sessionBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo openForgetPasswordSession(SessionBo sessionBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo verifyForgetPasswordSession(SessionBo sessionBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo openChangePasswordSession(SessionBo sessionBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo verifyChangePasswordSession(SessionBo sessionBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo loginByPhone(LoginBo loginBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo loginByReference(LoginBo loginBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo createUser(UserBo targetUser, PartnerBo partnerBo, UserBo currentUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo deleteUser(UserBo targetUser, UserBo currentUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo updateUser(UserBo targetUser, UserBo currentUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserBo> queryUserInfo(UserBo queryUser, UserBo currentUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserBo> queryUser(UserBo queryUser, PartnerBo partnerBo, UserBo currentUser, PaginationBo pagnationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserBo> querySession(UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo disposeSession(UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
