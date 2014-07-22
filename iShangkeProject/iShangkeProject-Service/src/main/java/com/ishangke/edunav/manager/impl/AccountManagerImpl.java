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
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.AccountHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.AccountManager;
import com.ishangke.edunav.manager.converter.AccountConverter;
import com.ishangke.edunav.manager.converter.AccountHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.notfound.AccountNotFoundException;
import com.ishangke.edunav.manager.exception.notfound.UserNotFoundException;

@Component
public class AccountManagerImpl implements AccountManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountManagerImpl.class);

    @Autowired
    private AccountEntityExtMapper accountMapper;
    @Autowired
    private UserEntityExtMapper userMapper;
    @Autowired
    private AccountHistoryEntityExtMapper accountHistoryMapper;

    @Override
    public AccountBo exchangeCash(AccountBo accountBo, UserBo userBo) {
        // Check whether parameters are null
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (accountBo == null) {
            throw new ManagerException("AccountBo is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        UserEntityExt userResult = null;
        AccountEntityExt accountEntity = AccountConverter.fromBo(accountBo);
        AccountEntityExt accountResult = null;

        try {
            // Check whether the User Exists
            userResult = userMapper.getById(userEntity.getId());
            if (userResult == null) {
                throw new UserNotFoundException("该用户不存在");
            }

            // Check whether the Account Exists
            accountResult = accountMapper.getById(accountEntity.getId());
            if (accountResult == null) {
                throw new AccountNotFoundException("该账户不存在");
            }

            // Check whether the Account belongs to the User
            if (accountResult.getId() != userResult.getId()) {
                throw new ManagerException("User Exchange Cash failed: 该账户不属于此用户");
            }
            // TODO How do I know how much are you gonna exchange ?

        } catch (Throwable t) {
            throw new ManagerException("User Exchange Cash failed", t);
        }

        return null;
    }

    @Override
    public List<AccountBo> query(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check whether parameters are null
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (accountBo == null) {
            throw new ManagerException("AccountBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        List<AccountBo> resultList = null;
        List<AccountEntityExt> accountList = null;
        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        AccountEntityExt accountEntity = AccountConverter.fromBo(accountBo);

        try {
            // TODO 权限问题
            accountList = accountMapper.list(accountEntity, pageEntity);
            for (AccountEntityExt accountPo : accountList) {
                resultList.add(AccountConverter.toBo(accountPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Account Query failed", t);
        }

    }

    @Override
    public List<AccountHistoryBo> queryHistory(AccountHistoryBo accountHistoryBo, UserBo userBo,
            PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check whether parameters are null
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (accountHistoryBo == null) {
            throw new ManagerException("AccountHistoryBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        AccountHistoryEntityExt accountHistoryEntity = AccountHistoryConverter.fromBo(accountHistoryBo);

        // TODO 权限
        List<AccountHistoryEntityExt> accountHistoryList = null;
        List<AccountHistoryBo> resultList = null;
        try {
            accountHistoryList = accountHistoryMapper.list(accountHistoryEntity, pageEntity);
            for (AccountHistoryEntityExt accountHistoryPo : accountHistoryList) {
                resultList.add(AccountHistoryConverter.toBo(accountHistoryPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("AccountHistory Query failed", t);
        }

    }
}
