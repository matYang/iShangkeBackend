package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.converter.CouponConverter;
import com.ishangke.edunav.manager.converter.CouponHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CouponManagerImpl implements CouponManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponManagerImpl.class);

    @Autowired
    private CouponEntityExtMapper couponEntityExtMapper;
    @Autowired
    private CouponHistoryEntityExtMapper couponHistoryEntityExtMapper;

    @Override
    public CouponBo createCoupon(CouponBo couponBo, UserBo userBo) {
        // Check Null
        if (couponBo == null) {
            throw new ManagerException("couponBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            int result = 0;
            couponEntity.setUserId(userEntity.getId());
            result = couponEntityExtMapper.add(couponEntity);
            if (result > 0) {
                // add to History
                CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
                couponHistoryEntityExt.setCharge(couponEntity.getTotal() - couponEntity.getBalance());
                couponHistoryEntityExt.setCouponId(couponEntity.getId());
                couponHistoryEntityExt.setDeleted(0);
                couponHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                couponHistoryEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
                couponHistoryEntityExtMapper.add(couponHistoryEntityExt);
                // add Coupon to Databases
                return CouponConverter.toBo(couponEntity);
            } else {
                throw new ManagerException("Coupon Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("Coupon Create Failed");
        }
    }

    @Override
    public List<CouponBo> query(CouponBo couponBo, UserBo userBo, PaginationBo paginationBo) {
        // Check Null
        if (couponBo == null) {
            throw new ManagerException("couponBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        PaginationEntity pageEntity = PaginationConverter.fromBo(paginationBo);
        List<CouponEntityExt> couponList = null;
        List<CouponBo> resultList = null;

        try {
            // TODO权限
            couponList = couponEntityExtMapper.list(couponEntity, pageEntity);
            for (CouponEntityExt couponPo : couponList) {
                resultList.add(CouponConverter.toBo(couponPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Coupon Query Failed");
        }
    }

    @Override
    public List<CouponHistoryBo> queryHistory(CouponHistoryBo couponHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        // Check Null
        if (couponHistoryBo == null) {
            throw new ManagerException("couponHistoryBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CouponHistoryEntityExt couponHistoryEntity = CouponHistoryConverter.fromBo(couponHistoryBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        PaginationEntity pageEntity = PaginationConverter.fromBo(paginationBo);
        List<CouponHistoryEntityExt> couponHistoryList = null;
        List<CouponHistoryBo> resultList = null;

        try {
            // TODO权限
            couponHistoryList = couponHistoryEntityExtMapper.list(couponHistoryEntity, pageEntity);
            for (CouponHistoryEntityExt couponHistoryPo : couponHistoryList) {
                CouponEntityExt couponPo = couponEntityExtMapper.getById(couponHistoryPo.getCouponId());
                if (couponPo.getUserId() != userEntity.getId()) {
                    throw new ManagerException("此用户: " + userEntity.getId() + " 无法查看该优惠劵: " + couponPo.getId());
                }
                resultList.add(CouponHistoryConverter.toBo(couponHistoryPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("CouponHistory Query Failed");
        }
    }

}
