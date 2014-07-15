package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
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

        // 判断是否存在登录名一样的USER
        // TODO getUserByName
        UserEntityExt entityInDb = new UserEntityExt();
        entityInDb.setName(userBo.getName());
        if (entityInDb != null) {
            throw new ManagerException("User xxx has already in db");
        }

        // 插入新的USER
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        int result = 0;
        try {
            result = userMapper.add(userEntity);
        } catch (Throwable t) {
            throw new ManagerException("Register user xxx failed", t);
        }

        if (result > 0) {
            return UserConverter.toBo(userEntity);
        } else {
            throw new ManagerException("Register user xxx failed");
        }
    }

    @Override
    public UserBo login(LoginBo loginBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo createUser(UserBo targetUser, PartnerBo partenrBo, UserBo currentUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int deleteUser(UserBo targetUser, UserBo currentUser) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUser(UserBo targetUser, UserBo currentUser) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public UserBo queryUserInfo(UserBo queryUser, UserBo currentUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserBo> queryUser(UserBo queryUser, PartnerBo partnerBo, UserBo currentUser, PaginationBo pagnationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserBo querySession(UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int disposeSession(UserBo userBo) {
        // TODO Auto-generated method stub
        return 0;
    }

}
