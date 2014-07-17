package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CreditService;
import com.ishangke.edunav.manager.CreditManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CreditServiceImpl implements CreditService.Iface{
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditServiceImpl.class);
    
    @Autowired
    private CreditManager creditManager;
    

    @Override
    public CreditBo exchangeCoupon(CreditBo creditBo, CouponBo couponBo, UserBo userBo) throws BusinessExceptionBo, TException {
//        try {
//            return creditManager.exchangeCoupon(creditBo, couponBo, userBo);
//        } catch (ManagerException e) {
//            LOGGER.info(e.getMessage(), e);
//            BusinessExceptionBo exception = new BusinessExceptionBo();
//            exception.setErrorCode(ManagerErrorCode);
//            exception.setMessageKey(ManagerErrorCode.COUPON_CREATE_ERROR_KEY);
//            throw exception;
//        }
        return null;
    }

    @Override
    public CreditBo exchangeAccount(CreditBo creditBo, AccountBo accountBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CreditBo> query(CreditBo creditBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CreditBo> queryHistory(CreditHistoryBo creditHistoryBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
}
