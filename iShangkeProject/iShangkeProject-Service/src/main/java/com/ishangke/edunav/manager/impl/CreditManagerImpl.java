package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CreditEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CreditHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CreditManager;
import com.ishangke.edunav.manager.converter.CouponConverter;
import com.ishangke.edunav.manager.converter.CreditConverter;
import com.ishangke.edunav.manager.converter.CreditHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
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
    @Autowired
    private AuthManager authManager;

    @Override
    public CreditBo modifyCredit(CreditBo creditBo, UserBo userBo) {
        if (creditBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        CreditEntityExt creditEntity = CreditConverter.fromBo(creditBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // Check Ids
        if (creditEntity.getId() == null || creditEntity.getId() == 0) {
            throw new ManagerException("积分id为null或0");
        }

        // Check whether this credit belongs to the user
        if (creditEntity.getId() != userEntity.getId()) {
            throw new ManagerException("此积分不是该用户的");
        }

        try {
            creditMapper.update(creditEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Credit Modify Failed for user: " + userEntity.getId(), t);
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
        CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);

        // Check Ids
        if (creditEntity.getId() == null || creditEntity.getId() == 0) {
            throw new ManagerException("积分id为null或0");
        }
        if (couponEntity.getId() == null || couponEntity.getId() == 0) {
            throw new ManagerException("优惠劵id为null或0");
        }

        // Check whether this credit or coupon belongs to the user
        if (creditEntity.getId() != userEntity.getId()) {
            throw new ManagerException("此积分不是该用户的");
        }
        if (couponEntity.getUserId() != userEntity.getId()) {
            throw new ManagerException("此优惠劵不是该用户的");
        }

        try {
            creditMapper.update(creditEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Credit ExchangeCoupon Failed for user: " + userEntity.getId(), t);
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
            if (result.getId() != userEntity.getId()) {
                throw new ManagerException("该积分不属于此用户");
            }
            convertedResults.add(CreditConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public List<CreditHistoryBo> queryHistory(CreditHistoryBo creditHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        CreditHistoryEntityExt creditHistoryEntity = creditHistoryBo == null ? null : CreditHistoryConverter.fromBo(creditHistoryBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        List<CreditHistoryEntityExt> results = null;
        try {
            results = creditHistoryMapper.list(creditHistoryEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("CreditHistory query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<CreditHistoryBo>();
        }
        List<CreditHistoryBo> convertedResults = new ArrayList<CreditHistoryBo>();
        for (CreditHistoryEntityExt result : results) {
            if (result.getId() != userEntity.getId()) {
                throw new ManagerException("该积分历史不属于此用户");
            }
            convertedResults.add(CreditHistoryConverter.toBo(result));
        }
        return convertedResults;
    }

}
