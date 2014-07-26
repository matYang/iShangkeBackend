package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CreditEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.PartnerEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserGroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserLocationEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;
import com.ishangke.edunav.dataaccess.model.UserLocationEntityExt;
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
    
    @Autowired
    private GroupEntityExtMapper groupMapper;
    
    @Autowired
    private UserGroupEntityExtMapper userGroupMapper;
    
    @Autowired 
    private AccountEntityExtMapper accountMapper;
    
    @Autowired
    private CreditEntityExtMapper creditMapper;
    
    @Autowired
    private CouponEntityExtMapper couponMapper;
    
    @Autowired
    private CouponHistoryEntityExtMapper couponHistoryMapper;
    @Autowired
    
    private PartnerEntityExtMapper partnerMapper;
    
    @Autowired
    private UserLocationEntityExtMapper userLocationMapper;
    
    private String getReference() {
        //TODO this is just a placeholder of reference factory, used to pass compilation
        return null;
    }
    
    
    private UserBo initializeNormalUser(UserBo userBo, int groupId, String uniqueIdentifier) {
        // 参数验证
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 插入新的USER
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        try {
            int result = userMapper.add(userEntity);
            if (result <= 0) {
                throw new ManagerException("InitializeNormalUser::addUser user with unique identifier: " + uniqueIdentifier + " failed");
            }
            
            UserGroupEntityExt userGroupEntity = new UserGroupEntityExt();
            userGroupEntity.setUserId(userEntity.getId());
            userGroupEntity.setGroupId(groupId);
            userGroupEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            userGroupEntity.setDeleted(0);
            result = userGroupMapper.add(userGroupEntity);
            if (result <= 0) {
                throw new ManagerException("InitializeNormalUser::addUserGroup user with unique identifier: " + uniqueIdentifier  + " failed");
            }
            
            AccountEntityExt accountEntity = new AccountEntityExt();
            accountEntity.setId(userEntity.getId());
            accountEntity.setBalance(0.0);
            accountEntity.setRealName(userEntity.getName());
            accountEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            accountEntity.setCreateTime(DateUtility.getCurTimeInstance());
            accountEntity.setEnabled(0);
            accountEntity.setDeleted(0);
            accountEntity.setAccountNumber(getReference());
            result = accountMapper.add(accountEntity);
            if (result <= 0) {
                throw new ManagerException("InitializeNormalUser::addAccount user with unique identifier: " + uniqueIdentifier  + " failed");
            }
            
            CreditEntityExt creditEntity = new CreditEntityExt();
            creditEntity.setId(userEntity.getId());
            creditEntity.setCredit(0.0);
            creditEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            creditEntity.setCreateTime(DateUtility.getCurTimeInstance());
            creditEntity.setEnabled(0);
            creditEntity.setDeleted(0);
            result = creditMapper.add(creditEntity);
            if (result <= 0) {
                throw new ManagerException("InitializeNormalUser::addCredit user with unique identifier: " + uniqueIdentifier  + " failed");
            }
            
            UserLocationEntityExt userLocationEntity = new UserLocationEntityExt();
            userLocationEntity.setUserId(userEntity.getId());
            userLocationEntity.setLocationId(userBo.getLocationId());
            userLocationEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            userLocationEntity.setDeleted(0);
            result = userLocationMapper.add(userLocationEntity);
            if (result <= 0) {
                throw new ManagerException("InitializeNormalUser::addUserLocation with unique identifier: " + uniqueIdentifier + " failed");
            }
            
            
            CouponEntityExt couponEntity = new CouponEntityExt();
            couponEntity.setCode(getReference());
            //TODO constants and enums
            couponEntity.setBalance(50.0);
            couponEntity.setBalance(50.0);
            couponEntity.setOrigin(0);
            Calendar expiry = DateUtility.getCurTimeInstance();
            expiry.add(Calendar.YEAR, 1);
            couponEntity.setExpiryTime(expiry);
            couponEntity.setRemark("");
            couponEntity.setUserId(userEntity.getId());
            couponEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            couponEntity.setCreateTime(DateUtility.getCurTimeInstance());
            couponEntity.setEnabled(0);
            couponEntity.setDeleted(0);
            result = couponMapper.add(couponEntity);
            if (result <= 0) {
                throw new ManagerException("InitializeNormalUser::addCoupon with unique identifier: " + uniqueIdentifier + " failed");
            }
            
            String appliedInvitationCode = userEntity.getAppliedInvitationCode();
            if (appliedInvitationCode != null && appliedInvitationCode.length() > 0) {
                //use used an invitation code
                UserEntityExt inviterSearch = new UserEntityExt();
                inviterSearch.setInvitationCode(appliedInvitationCode);
                List<UserEntityExt> inviterSearchResult = userMapper.list(inviterSearch, null);
                if (inviterSearchResult == null || inviterSearchResult.size() == 0) {
                    throw new ManagerException("InitializeNormalUser::inviter not found with invitation code: " + appliedInvitationCode + " for unique identifier: " + uniqueIdentifier );
                }
                UserEntityExt inviterEntity = inviterSearchResult.get(0);
                
                
                CouponEntityExt curUserCouponEntity = new CouponEntityExt();
                curUserCouponEntity.setCode(getReference());
                curUserCouponEntity.setBalance(20.0);
                curUserCouponEntity.setBalance(20.0);
                curUserCouponEntity.setOrigin(0);
                curUserCouponEntity.setExpiryTime(expiry);
                curUserCouponEntity.setRemark("");
                curUserCouponEntity.setUserId(userEntity.getId());
                curUserCouponEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
                curUserCouponEntity.setCreateTime(DateUtility.getCurTimeInstance());
                curUserCouponEntity.setEnabled(0);
                curUserCouponEntity.setDeleted(0);
                result = couponMapper.add(curUserCouponEntity);
                if (result <= 0) {
                    throw new ManagerException("InitializeNormalUser::addCoupon to invitee with unique identifier: " + uniqueIdentifier  + " failed");
                }
                
                CouponEntityExt inviterCouponEntity = new CouponEntityExt();
                inviterCouponEntity.setCode(getReference());
                inviterCouponEntity.setBalance(20.0);
                inviterCouponEntity.setBalance(20.0);
                inviterCouponEntity.setOrigin(0);
                inviterCouponEntity.setExpiryTime(expiry);
                inviterCouponEntity.setRemark("");
                inviterCouponEntity.setUserId(inviterEntity.getId());
                inviterCouponEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
                inviterCouponEntity.setCreateTime(DateUtility.getCurTimeInstance());
                inviterCouponEntity.setEnabled(0);
                inviterCouponEntity.setDeleted(0);
                result = couponMapper.add(inviterCouponEntity);
                if (result <= 0) {
                    throw new ManagerException("InitializeNormalUser::addCoupon to inviter with unique identifier: " + uniqueIdentifier  + " failed");
                }
            }
            
            //lastly, read out the user...too many changes unable to maintain local copy
            userEntity = userMapper.getById(userEntity.getId());
            if (userEntity == null) {
                throw new UserNotFoundException("InitializeNormalUser::lastFetch with unique identifier: " + uniqueIdentifier  + " failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("InitializeNormalUser user with unique identifier: " + uniqueIdentifier  + " failed", t);
        }
        
        return UserConverter.toBo(userEntity);
    }


    @Override
    public UserBo registerUser(UserBo userBo, SessionBo sessionBo) {
        // 参数验证
        if (userBo == null || sessionBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        boolean isValid = authManager.validateCellVerificationSession(sessionBo.getAccountIdentifier(), sessionBo.getAuthCode());
        if (isValid) {
            throw new ManagerException("Register user with phone number: " + userBo.getPhone() + " failed because authCode: " + sessionBo.getAuthCode() + "does not match");
        }
        
        // 判断是否存在手机号码一样的USER
        UserEntityExt entityInDb = new UserEntityExt();
        entityInDb.setPhone(userBo.getPhone());

        List<UserEntityExt> entityList = userMapper.list(entityInDb, null);
        if (entityList != null && entityList.size() != 0) {
            throw new ManagerException(userBo.getPhone() + " is already in db");
        }
        
        return initializeNormalUser(userBo, Constant.GROUPUSER, userBo.getPhone());
    }

    @Override
    public UserBo createUser(UserBo targetUser, UserBo currentUser) {
        // Check Null
        if (targetUser == null || currentUser == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        if (authManager.isAdmin(currentUser.getId()) || authManager.isSystemAdmin(currentUser.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call createUser at " + new Date(), currentUser.getName()));
        }
        else {
            throw new AuthenticationException("Non-admin user trying createUser");
        }
        
        // 判断是否存在手机号码一样的USER
        UserEntityExt entityInDb = new UserEntityExt();
        entityInDb.setPhone(targetUser.getPhone());

        List<UserEntityExt> entityList = userMapper.list(entityInDb, null);
        if (entityList != null && entityList.size() != 0) {
            throw new ManagerException(targetUser.getPhone() + " is already in db");
        }
        
        //act like a normal registration
        return initializeNormalUser(targetUser, Constant.GROUPUSER, targetUser.getPhone());
    }
    
    @Override
    public UserBo createPartnerUser(UserBo targetUser, PartnerBo partner, UserBo currentUser) {
        if (targetUser == null || partner == null  || currentUser == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        // Check Null
        if (authManager.isAdmin(currentUser.getId()) || authManager.isSystemAdmin(currentUser.getId())) {
            LOGGER.warn(String.format("[UserManagerImpl]system admin || admin [%s] call createUser at " + new Date(), currentUser.getName()));
        }
        else {
            throw new AuthenticationException("Non-admin user trying createPartnerUser");
        }
        if (partner.getId() <= 0) {
            throw new AuthenticationException("Partner Id not specified at createPartneruser");
        }
        
        UserBo response = null;
        try {
            GroupEntityExt group = new GroupEntityExt();
            group.setName(partner.getWholeName() + Constant.GROUPPADMINSUFIX);
            group.setRoleId(Constant.ROLEPARTNERADMINID);
            group.setPartnerId(partner.getId());
            group.setLastModifyTime(DateUtility.getCurTimeInstance());
            group.setCreateTime(DateUtility.getCurTimeInstance());
            group.setEnabled(0);
            group.setDeleted(0);
            int result = groupMapper.add(group);
            if (result <= 0) {
                throw new ManagerException("CreatePartnerUser::addGroup failed");
            }
            
            response = initializeNormalUser(targetUser, group.getId(), targetUser.getReference());
        } catch (Throwable t) {
            throw new ManagerException("CreatePartnerUser failed", t);
        }
        
        //act like a normal registration
        return response; 
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
