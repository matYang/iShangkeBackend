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

public class WithdrawServiceImpl implements WithdrawService.Iface{
    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawServiceImpl.class);
    
    @Autowired
    private WithdrawManager withdrawManager;

    @Override
    public WithdrawBo createWithdraw(WithdrawBo withdrawBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WithdrawBo updateWithdraw(WithdrawBo withdrawBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WithdrawBo deleteWithdraw(WithdrawBo withdrawBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<WithdrawBo> query(WithdrawBo withdrawBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

}
