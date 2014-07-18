package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CreditEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CreditHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.CreditManager;
import com.ishangke.edunav.manager.converter.CreditConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CreditManagerImpl implements CreditManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditManagerImpl.class);

    @Autowired
    private CreditEntityExtMapper creditMapper;
    @Autowired
    private CouponEntityExtMapper couponMapper;
    @Autowired
    private UserEntityExtMapper userMapper;
    @Autowired
    private AccountEntityExtMapper accountMapper;
    @Autowired
    private CreditHistoryEntityExtMapper creditHistoryMapper;

    @Override
    public CreditBo modifyCredit(CreditBo creditBo, UserBo userBo) {
        if (creditBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        CreditEntityExt creditEntity = CreditConverter.fromBo(creditBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            creditMapper.update(creditEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Credit update failed for user: " + userEntity.getId(), t);
        }

        return CreditConverter.toBo(creditEntity);
    }

    @Override
    public CreditBo exchangeCoupon(CreditBo creditBo, CouponBo couponBo, UserBo userBo) {
        if (creditBo == null || couponBo != null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        CreditEntityExt creditEntity = CreditConverter.fromBo(creditBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            creditMapper.update(creditEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Credit update failed for user: " + userEntity.getId(), t);
        }

        return CreditConverter.toBo(creditEntity);
    }

    @Override
    public CreditBo exchangeAccount(CreditBo creditBo, AccountBo accountBo, UserBo userBo) {
        if (creditBo == null || accountBo != null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        CreditEntityExt creditEntity = CreditConverter.fromBo(creditBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            creditMapper.update(creditEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Credit update failed for user: " + userEntity.getId(), t);
        }

        return CreditConverter.toBo(creditEntity);
    }

    @Override
    public List<CreditBo> query(CreditBo creditBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        CreditEntityExt creditEntity = creditBo == null ? null : CreditConverter.fromBo(creditBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        List<CreditEntityExt> results = null;
        try {
            results = creditMapper.list(creditEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Credit query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<CreditBo>();
        }
        List<CreditBo> convertedResults = new ArrayList<CreditBo>();
        for (CreditEntityExt result : results) {
            convertedResults.add(CreditConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public List<CreditHistoryBo> queryHistory(CreditHistoryBo creditHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
