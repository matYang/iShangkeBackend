package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.AccountHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.WithdrawEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AccountManager;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.converter.AccountConverter;
import com.ishangke.edunav.manager.converter.AccountHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;

@Component
public class AccountManagerImpl implements AccountManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountManagerImpl.class);

    @Autowired
    private AccountEntityExtMapper accountMapper;
    @Autowired
    private AccountHistoryEntityExtMapper accountHistoryMapper;
    @Autowired
    private WithdrawEntityExtMapper withdrawMapper;
    @Autowired
    private AuthManager authManager;

    @Override
    //TODO left for harry
    public AccountBo exchangeCash(AccountBo accountBo, UserBo userBo, Double amount, String payee_Id, String payee_Name, int type) {
        // Check whether parameters are null
        if (userBo == null) {
            throw new ManagerException("User Exchange Cash Failed: UserBo is null");
        }
        if (accountBo == null) {
            throw new ManagerException("User Exchange Cash Failed: AccountBo is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        AccountEntityExt accountEntity = AccountConverter.fromBo(accountBo);

        // Check the Account's id
        if (accountEntity.getId() == null || accountEntity.getId() == 0) {
            throw new ManagerException("User Exchange Cash Failed: 账户id为null或0");
        }
        // Check the User's id
        if (userEntity.getId() == null || userEntity.getId() == 0) {
            throw new ManagerException("User Exchange Cash Failed: 用户id为null或0");
        }
        // Check whether the Account belongs to the User
        if (!accountEntity.getId().equals(userEntity.getId())) {
            throw new ManagerException("User Exchange Cash Failed: 该账户不属于此用户");
        }
        try {
            //TODO withdraw stands for 取款方式, not dynamically added here
            //TODO to get the withdraw id, might need to change interface to pass a withdrawBo
            
            // Create AccountHistory
            AccountHistoryEntityExt accountHistory = new AccountHistoryEntityExt();
            accountHistory.setCharge(amount);
            accountHistory.setUserId(userEntity.getId());
            //accountHistory.setWithdrawId(withdraw.getId());
            accountHistory.setCreateTime(DateUtility.getCurTimeInstance());
            //accountHistory.setType(withdraw.getType());
            accountHistory.setDeleted(0);

            int accountHistoryResult = 0;
            accountHistoryResult = accountHistoryMapper.add(accountHistory);

            if (accountHistoryResult > 0) {
                // Update Account
                try {
                    AccountEntityExt oldAccount = accountMapper.getById(accountEntity.getId());
                    oldAccount.setBalance(oldAccount.getBalance() - amount);
                    oldAccount.setLastModifyTime(DateUtility.getCurTimeInstance());
                    accountMapper.update(oldAccount);
                    return AccountConverter.toBo(oldAccount);
                } catch (Throwable t) {
                    throw new ManagerException("User Exchange Cash Failed: Get accountEntity and Update the balance of it Failed", t);
                }
            } else {
                throw new ManagerException("User Exchange Cash Failed: Add accountHistory Failed");
            }

        } catch (Throwable t) {
            throw new ManagerException("User Exchange Cash Failed", t);
        }

    }

    @Override
    public List<AccountBo> query(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        AccountEntityExt accountEntity = accountBo == null ? null : AccountConverter.fromBo(accountBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        //admin and system admins can query user's accounts
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[AccountManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        }
        else {
            //otherwise user can only query their own, thus making an UserId necessary
            if (accountEntity == null || accountEntity.getId() == null || !accountEntity.getId().equals(userEntity.getId())) {
                throw new AuthenticationException("User querying someone else's account");
            }
        }

        List<AccountEntityExt> results = null;
        try {
            results = accountMapper.list(accountEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("Account query failed for user: " + userEntity.getId(), t);
        }
        
        if (results == null) {
            return new ArrayList<AccountBo>();
        }
        List<AccountBo> convertedResults = new ArrayList<AccountBo>();
        for (AccountEntityExt result : results) {
            convertedResults.add(AccountConverter.toBo(result));
        }
        return convertedResults;

    }

    @Override
    public List<AccountHistoryBo> queryHistory(AccountHistoryBo accountHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        AccountHistoryEntityExt accountHistoryEntity = accountHistoryBo == null ? null : AccountHistoryConverter.fromBo(accountHistoryBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        //admin and system admins can query user's accountHistorys
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[AccountHistoryManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        }
        else {
            //otherwise user can only query their own, thus making an UserId necessary
            if (accountHistoryEntity == null || accountHistoryEntity.getUserId() == null || !accountHistoryEntity.getUserId().equals(userEntity.getId())) {
                throw new AuthenticationException("User querying someone else's accountHistory");
            }
        }
        
        List<AccountHistoryEntityExt> results = null;
        try {
            results = accountHistoryMapper.list(accountHistoryEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("Account queryHistory failed for user: " + userEntity.getId(), t);
        }
        
        if (results == null) {
            return new ArrayList<AccountHistoryBo>();
        }
        List<AccountHistoryBo> convertedResults = new ArrayList<AccountHistoryBo>();
        for (AccountHistoryEntityExt result : results) {
            convertedResults.add(AccountHistoryConverter.toBo(result));
        }
        return convertedResults;
    }
    
}
