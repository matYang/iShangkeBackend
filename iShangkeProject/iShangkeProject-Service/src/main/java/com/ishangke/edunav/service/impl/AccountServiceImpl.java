package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.AccountService;
import com.ishangke.edunav.manager.AccountManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class AccountServiceImpl implements AccountService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountManager accountManager;

    @Override
    public AccountBo exchangeCash(AccountBo accountBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return accountManager.exchangeCash(accountBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACCOUNT_EXCHANGECASH_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUNT_EXCHANGECASH_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<AccountBo> query(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        try {
            return accountManager.query(accountBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACCOUNT_QUERY_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUNT_QUERY_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<AccountBo> queryHistory(AccountHistoryBo accountHistoryBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        try {
            return accountManager.queryHistory(accountHistoryBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACCOUNT_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUNT_QUERYHISTORY_ERROR_KEY);
            throw exception;
        }
    }

}
