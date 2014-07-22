package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.commoncontract.service.WithdrawService;
import com.ishangke.edunav.manager.WithdrawManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class WithdrawServiceImpl implements WithdrawService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawServiceImpl.class);

    @Autowired
    private WithdrawManager withdrawManager;

    @Override
    public WithdrawBo createWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return withdrawManager.createWithdraw(withdrawBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public WithdrawBo updateWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return withdrawManager.updateWithdraw(withdrawBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public WithdrawBo deleteWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return withdrawManager.deleteWithdraw(withdrawBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<WithdrawBo> query(WithdrawBo withdrawBo, UserBo userBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return withdrawManager.query(withdrawBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
