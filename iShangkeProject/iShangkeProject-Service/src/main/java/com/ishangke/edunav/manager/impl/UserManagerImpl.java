package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.UserManager;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.manager.exception.notfound.UserNotFoundException;

@Component
public class UserManagerImpl implements UserManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    private UserEntityExtMapper userMapper;
    
    @Autowired
    private AuthManager authManager;


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
        if (entityList != null && entityList.size() != 0) {
            throw new ManagerException(userBo.getPhone() + " is already in db");
        }

        // 插入新的USER
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        try {
            int result = userMapper.add(userEntity);
         
            if (result <= 0) {
                throw new ManagerException("Register user with phone number: " + userBo.getPhone() + " failed");
            }
            
        } catch (Throwable t) {
            throw new ManagerException("Register user with phone number: " + userBo.getPhone() + " failed", t);
        }
        
        return UserConverter.toBo(userEntity);
    }

    @Override
    public SessionBo openCellSession(UserBo userBo) {
        if (userBo == null || userBo.getPhone() == null || userBo.getPhone().length() == 0) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt searchEntity = new UserEntityExt();
        searchEntity.setPhone(userBo.getPhone());
        
        List<UserEntityExt> result = null;
        try {
            result = userMapper.list(searchEntity, null);
        } catch (Throwable t) {
            throw new ManagerException("OpenCellSession with phone number: " + userBo.getPhone() + " failed", t);
        }
        
        if (result != null && result.size() >= 0) {
            throw new ManagerException("Account already registered");
        }
        
        UserEntityExt curUser = result.get(0);
        String authCode = authManager.openCellVerificationSession(userBo.getPhone());
        SessionBo sessionBo = new SessionBo();
        sessionBo.setId(curUser.getId());
        sessionBo.setAccountIdentifier(curUser.getPhone());
        sessionBo.setAuthCode(authCode);
        return sessionBo;
    }

    @Override
    public SessionBo openForgetPasswordSession(UserBo userBo) {
        if (userBo == null || userBo.getPhone() == null || userBo.getPhone().length() == 0) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt searchEntity = new UserEntityExt();
        searchEntity.setPhone(userBo.getPhone());
        List<UserEntityExt> result = null;
        try {
            result = userMapper.list(searchEntity, null);
        } catch (Throwable t) {
            throw new ManagerException("OpenForgetPasswordSession with phone number: " + userBo.getPhone() + " failed", t);
        }
        
        if (result == null || result.size() == 0) {
            throw new ManagerException("Account is not registered");
        }
        
        UserEntityExt curUser = result.get(0);
        String authCode = authManager.openForgetPasswordSession(curUser.getId());
        SessionBo sessionBo = new SessionBo();
        sessionBo.setId(curUser.getId());
        sessionBo.setAccountIdentifier(curUser.getPhone());
        sessionBo.setAuthCode(authCode);
        return sessionBo;
    }
    

    @Override
    public UserBo recoverPassword(PasswordBo passwordBo) {
        if (passwordBo == null ||  passwordBo.getAccountIdentifier() == null || passwordBo.getAuthCode() == null || passwordBo.getNewPassword() == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt searchEntity = new UserEntityExt();
        searchEntity.setPhone(passwordBo.getAccountIdentifier());
        List<UserEntityExt> result = null;
        try {
            result = userMapper.list(searchEntity, null);
        } catch (Throwable t) {
            throw new ManagerException("RecoverPassword with phone number: " + passwordBo.getAccountIdentifier()  + " failed", t);
        }
        
        if (result == null || result.size() == 0) {
            throw new ManagerException("Account is not registered");
        }
        
        UserEntityExt curUser = result.get(0);
        boolean isValid = authManager.validateForgetPasswordSession(curUser.getId(), passwordBo.getAuthCode());
        
        if (!isValid) {
            throw new ManagerException("Authcode does not match");
        }
        
        curUser.setPassword(passwordBo.getNewPassword());
        try {
            userMapper.update(curUser);
        } catch (Throwable t) {
            throw new ManagerException("RecoverPassword failed for user: " + curUser.getId(), t);
        }
        
        return UserConverter.toBo(curUser);
    }

    @Override
    public UserBo changePassword(PasswordBo passwordBo) {
        if (passwordBo == null ||  passwordBo.getId() <= 0 || passwordBo.getNewPassword() == null || passwordBo.getOldPassword() == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt curUser = null;
        try {
            curUser = userMapper.getById(passwordBo.getId());
        } catch (Throwable t) {
            throw new ManagerException("ChangePassword getById failed for user: " + passwordBo.getId(), t);
        }
        if (curUser == null || curUser.getId() <= 0) {
            throw new UserNotFoundException("ChangePassword failed for user: " + passwordBo.getId());
        }
        if (!curUser.getPassword().equals(passwordBo.getOldPassword())) {
            throw new AuthenticationException("Password not Match");
        }
        
        curUser.setPassword(passwordBo.getNewPassword());
        try {
            userMapper.update(curUser);
        } catch (Throwable t) {
            throw new ManagerException("ChangePassword failed for user: " + curUser.getId(), t);
        }
        
        return UserConverter.toBo(curUser);
    }


    @Override
    public UserBo authenticate(SessionBo sessionBo) {
        if (sessionBo == null || sessionBo.getId() <= 0 || sessionBo.getAuthCode() == null || sessionBo.getAuthCode().length() == 0) {
            throw new ManagerException("Invalid parameter");
        }
        
        boolean isValid = authManager.validateAuthSession(sessionBo.getId(), sessionBo.getAuthCode());
        UserEntityExt response = new UserEntityExt();
        if (!isValid) {
            response.setId(-1);
            return UserConverter.toBo(response);
        }
        
        try {
            response = userMapper.getById(sessionBo.getId());
        } catch (Throwable t) {
            throw new ManagerException("Authentication failed for user: " + sessionBo.getId(), t);
        }
        if (response == null) {
            throw new UserNotFoundException("Authentication failed for user: " + sessionBo.getId());
        }
        
        return UserConverter.toBo(response);
    }

    @Override
    public void disposeSession(SessionBo sessionBo) {
        if (sessionBo == null || sessionBo.getId() <= 0 || sessionBo.getAuthCode() == null || sessionBo.getAuthCode().length() == 0) {
            throw new ManagerException("Invalid parameter");
        }
        
        authManager.closeAuthSession(sessionBo.getId(), sessionBo.getAuthCode());
    }

    @Override
    public UserBo loginByPhone(LoginBo loginBo) {
        if (loginBo == null || loginBo.getAccountIdentifier() == null || loginBo.getPassword() == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt curUser = null;
        try {
            UserEntityExt search = new UserEntityExt();
            search.setPhone(loginBo.getAccountIdentifier());
            
            List<UserEntityExt> results = userMapper.list(search, null);
            if (results == null || results.size() == 0) {
                throw new UserNotFoundException("LoginByPhone failed for user: " + loginBo.getAccountIdentifier());
            }
            
            curUser = results.get(0);
            if (!curUser.getPassword().equals(loginBo.getPassword())) {
                throw new AuthenticationException("Phone or password not match");
            }
            
            curUser.setLastLoginTime(DateUtility.getCurTimeInstance());
            userMapper.update(curUser);
            
        } catch (Throwable t) {
            throw new ManagerException("LoginByPhone failed for user: " + loginBo.getAccountIdentifier(), t);
        }
        
        return UserConverter.toBo(curUser);
    }

    @Override
    public UserBo loginByReference(LoginBo loginBo) {
        if (loginBo == null || loginBo.getAccountIdentifier() == null || loginBo.getPassword() == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt curUser = null;
        try {
            UserEntityExt search = new UserEntityExt();
            search.setReference(loginBo.getAccountIdentifier());
            
            List<UserEntityExt> results = userMapper.list(search, null);
            if (results == null || results.size() == 0) {
                throw new UserNotFoundException("LoginByReference failed for user: " + loginBo.getAccountIdentifier());
            }
            
            curUser = results.get(0);
            if (!curUser.getPassword().equals(loginBo.getPassword())) {
                throw new AuthenticationException("Reference or password not match");
            }
            
            curUser.setLastLoginTime(DateUtility.getCurTimeInstance());
            userMapper.update(curUser);
            
        } catch (Throwable t) {
            throw new ManagerException("LoginByReference failed for user: " + loginBo.getAccountIdentifier(), t);
        }
        
        return UserConverter.toBo(curUser);
    }

    @Override
    public UserBo createUser(UserBo targetUser, UserBo currentUser) {
        // Check Null
        if (targetUser == null || currentUser == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 判断是否存在手机号码一样的USER
        UserEntityExt entityInDb = new UserEntityExt();
        entityInDb.setPhone(targetUser.getPhone());

        List<UserEntityExt> entityList = userMapper.list(entityInDb, null);
        if (entityList != null && entityList.size() != 0) {
            throw new ManagerException(targetUser.getPhone() + " is already in db");
        }

        // 插入新的USER
        UserEntityExt targetUserEntity = UserConverter.fromBo(targetUser);
        UserEntityExt currentUserEntity  = UserConverter.fromBo(currentUser);
        
        //only admins are allowed here
        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call createUser at " + new Date(), currentUserEntity.getName()));
        }
        else {
            throw new AuthenticationException("Non-admin user creating user");
        }
        
        int result = 0;
        try {
            result = userMapper.add(targetUserEntity);
        } catch (Throwable t) {
            throw new ManagerException("Create user with phone number: " + targetUserEntity.getPhone() + " failed for user: " + currentUserEntity.getId(), t);
        }

        if (result > 0) {
            return UserConverter.toBo(targetUserEntity);
        } else {
            throw new ManagerException("Register user with phone number: " + targetUserEntity.getPhone() + " failed for user: " + currentUserEntity.getId());
        }
    }
    
    @Override
    public UserBo createPartnerUser(UserBo targetUser, PartnerBo partner, UserBo currentUser) {
        // Check Null
        if (targetUser == null || currentUser == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 判断是否存在手机号码一样的USER
        UserEntityExt entityInDb = new UserEntityExt();
        entityInDb.setPhone(targetUser.getPhone());

        List<UserEntityExt> entityList = userMapper.list(entityInDb, null);
        if (entityList != null && entityList.size() != 0) {
            throw new ManagerException(targetUser.getPhone() + " is already in db");
        }

        // 插入新的USER
        UserEntityExt targetUserEntity = UserConverter.fromBo(targetUser);
        UserEntityExt currentUserEntity  = UserConverter.fromBo(currentUser);
        
        //only admins are allowed here
        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call createPartnerUser at " + new Date(), currentUserEntity.getName()));
        }
        else {
            throw new AuthenticationException("Non-admin user creating partner user");
        }
        
        int result = 0;
        try {
            result = userMapper.add(targetUserEntity);
        } catch (Throwable t) {
            throw new ManagerException("Create partner user failed for user: " + currentUserEntity.getId(), t);
        }

        if (result > 0) {
            return UserConverter.toBo(targetUserEntity);
        } else {
            throw new ManagerException("Register partner user failed for user: " + currentUserEntity.getId());
        }
    }

    @Override
    public UserBo deleteUser(UserBo targetUser, UserBo currentUser) {
        // Check Null
        if (targetUser == null || currentUser == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt targetUserEntity = UserConverter.fromBo(targetUser);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);
        
        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call deleteUser at " + new Date(), currentUserEntity.getName()));
        }
        else {
            throw new AuthenticationException("Non-admin user trying deleting someone else's user");
        }
        
        try {
            targetUserEntity.setDeleted(1);
            userMapper.deleteById(targetUserEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("User deletion failed for user: " + currentUserEntity.getId(), t);
        }
        
        return UserConverter.toBo(targetUserEntity);
    }

    @Override
    public UserBo updateUser(UserBo targetUser, UserBo currentUser) {
        // Check Null
        if (targetUser == null || currentUser == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt targetUserEntity = UserConverter.fromBo(targetUser);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);
        
        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call updateUser at " + new Date(), currentUserEntity.getName()));
        }
        else {
            if (targetUserEntity == null || targetUserEntity.getId() == null || !targetUserEntity.getId().equals(currentUserEntity.getId())) {
                throw new AuthenticationException("User updating someone else's user");
            }
        }
        
        try {
            userMapper.update(targetUserEntity);
        } catch (Throwable t) {
            throw new ManagerException("User update failed for user: " + currentUserEntity.getId(), t);
        }
        
        return UserConverter.toBo(targetUserEntity);
    }

    @Override
    public UserBo queryUserInfo(UserBo queryUser, UserBo currentUser) {
        // Check Null
        if (queryUser == null || currentUser == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt queryUserEntity = UserConverter.fromBo(queryUser);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);
        
        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call queryUserInfo at " + new Date(), currentUserEntity.getName()));
        }
        else {
            if (queryUserEntity == null || queryUserEntity.getId() == null || !queryUserEntity.getId().equals(currentUserEntity.getId())) {
                throw new AuthenticationException("User queryingInfo someone else's user");
            }
        }
        
        UserEntityExt result = null;
        try {
            result = userMapper.getById(queryUserEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("Contact query failed for user: " + currentUserEntity.getId(), t);
        }
        
        if (result == null) {
            throw new UserNotFoundException("QueryUserInfo failed for user: " + currentUserEntity.getId());
        }
        
        return UserConverter.toBo(result);
    }

    @Override
    public List<UserBo> queryUser(UserBo queryUser, UserBo currentUser, PaginationBo paginationBo) {
        if (currentUser == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        UserEntityExt queryUserEntity = queryUser == null ? null : UserConverter.fromBo(queryUser);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt currentUserEntity = UserConverter.fromBo(currentUser);
        
        //only admins are allowed here
        if (authManager.isAdmin(currentUserEntity.getId()) || authManager.isSystemAdmin(currentUserEntity.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call queryUser at " + new Date(), currentUserEntity.getName()));
        }
        else {
            throw new AuthenticationException("Non-admin user querying someone else's user");
        }
        
        
        List<UserEntityExt> results = null;
        try {
            results = userMapper.list(queryUserEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("User query failed for user: " + currentUserEntity.getId(), t);
        }
        
        if (results == null) {
            return new ArrayList<UserBo>();
        }
        List<UserBo> convertedResults = new ArrayList<UserBo>();
        for (UserEntityExt userPo : results) {
            convertedResults.add(UserConverter.toBo(userPo));
        }
        return convertedResults;
    }
    

}
