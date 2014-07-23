package com.ishangke.edunav.manager.impl;

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
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;
import com.ishangke.edunav.manager.AccountManager;
import com.ishangke.edunav.manager.converter.AccountConverter;
import com.ishangke.edunav.manager.converter.AccountHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class AccountManagerImpl implements AccountManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountManagerImpl.class);

    @Autowired
    private AccountEntityExtMapper accountMapper;
    @Autowired
    private AccountHistoryEntityExtMapper accountHistoryMapper;
    @Autowired
    private WithdrawEntityExtMapper withdrawMapper;

    @Override
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
        if (accountEntity.getId() != userEntity.getId()) {
            throw new ManagerException("User Exchange Cash Failed: 该账户不属于此用户");
        }
        try {
            // Create Withdraw
            WithdrawEntityExt withdraw = new WithdrawEntityExt();
            withdraw.setCreateTime(DateUtility.getCurTimeInstance());
            withdraw.setLastModifyTime(DateUtility.getCurTimeInstance());
            withdraw.setEnabled(1);
            withdraw.setDeleted(0);
            withdraw.setUserId(userEntity.getId());
            withdraw.setPayeeId(payee_Id);
            withdraw.setPeyeeName(payee_Name);
            withdraw.setType(type);

            int withdrawResult = 0;
            withdrawResult = withdrawMapper.add(withdraw);

            if (withdrawResult > 0) {
                // Create AccountHistory
                AccountHistoryEntityExt accountHistory = new AccountHistoryEntityExt();
                accountHistory.setCharge(amount);
                accountHistory.setUserId(userEntity.getId());
                accountHistory.setWithdrawId(withdraw.getId());
                accountHistory.setCreateTime(DateUtility.getCurTimeInstance());
                accountHistory.setType(withdraw.getType());
                accountHistory.setDeleted(0);

                int accountHistoryResult = 0;
                accountHistoryResult = accountHistoryMapper.add(accountHistory);

                if (accountHistoryResult > 0) {
                    // Update Account
                    try {
                        AccountEntityExt oldAccount = accountMapper.getById(accountEntity.getId());
                        oldAccount.setBalance(oldAccount.getBalance() - amount);
                        accountMapper.update(oldAccount);
                        return AccountConverter.toBo(oldAccount);
                    } catch (Throwable t) {
                        throw new ManagerException("User Exchange Cash Failed: Get accountEntity and Update the balance of it Failed", t);
                    }
                } else {
                    throw new ManagerException("User Exchange Cash Failed: Add accountHistory Failed");
                }
            } else {
                throw new ManagerException("User Exchange Cash Failed: Add withdraw Failed");
            }

        } catch (Throwable t) {
            throw new ManagerException("User Exchange Cash Failed", t);
        }

    }

    @Override
    public List<AccountBo> query(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check whether parameters are null
        if (userBo == null) {
            throw new ManagerException("Account Query Failed: UserBo is null");
        }
        if (accountBo == null) {
            throw new ManagerException("Account Query Failed: AccountBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        List<AccountBo> resultList = null;
        List<AccountEntityExt> accountList = null;

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        AccountEntityExt accountEntity = AccountConverter.fromBo(accountBo);

        // Check User's id
        if (userEntity.getId() == null || userEntity.getId() == 0) {
            throw new ManagerException("Account Query Failed: 此用户id为null或0");
        }

        try {
            accountList = accountMapper.list(accountEntity, pageEntity);
            for (AccountEntityExt accountPo : accountList) {
                // Check whether the account belongs to the user
                if (accountPo.getId() != userEntity.getId()) {
                    throw new ManagerException("Account Query Failed: 此账户不属于该用户");
                }
                resultList.add(AccountConverter.toBo(accountPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Account Query Failed", t);
        }

    }

    @Override
    public List<AccountHistoryBo> queryHistory(AccountHistoryBo accountHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check whether parameters are null
        if (userBo == null) {
            throw new ManagerException("AccountHistory Query Failed: UserBo is null");
        }
        if (accountHistoryBo == null) {
            throw new ManagerException("AccountHistory Query Failed: AccountHistoryBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        AccountHistoryEntityExt accountHistoryEntity = AccountHistoryConverter.fromBo(accountHistoryBo);

        List<AccountHistoryEntityExt> accountHistoryList = null;
        List<AccountHistoryBo> resultList = null;

        // Check the User's id
        if (userEntity.getId() == null || userEntity.getId() == 0) {
            throw new ManagerException("AccountHistory Query Failed: 此用户id为null或0");
        }

        // 用户只能看到自己的账户历史
        if (accountHistoryBo.getUserId() != userBo.getId()) {
            throw new ManagerException("AccountHistory Query Failed: 此账户历史信息不属于该用户");
        }

        try {
            accountHistoryList = accountHistoryMapper.list(accountHistoryEntity, pageEntity);
            for (AccountHistoryEntityExt accountHistoryPo : accountHistoryList) {
                resultList.add(AccountHistoryConverter.toBo(accountHistoryPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("AccountHistory Query Failed", t);
        }

    }
}
