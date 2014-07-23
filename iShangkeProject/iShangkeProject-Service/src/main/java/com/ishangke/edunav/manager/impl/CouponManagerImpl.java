package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.converter.CouponConverter;
import com.ishangke.edunav.manager.converter.CouponHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class CouponManagerImpl implements CouponManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CouponManagerImpl.class);

    @Autowired
    private CouponEntityExtMapper couponMapper;
    @Autowired
    private CouponHistoryEntityExtMapper couponHistoryMapper;
    @Autowired
    private AuthManager authManager;

    @Override
    public CouponBo createCoupon(CouponBo couponBo, UserBo userBo) {
        // Check Null
        if (couponBo == null) {
            throw new ManagerException("Coupon Create Failed: couponBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Coupon Create Failed: userBo is null");
        }

        // Convert
        CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            int couponResult = 0;
            couponEntity.setUserId(userEntity.getId());

            // Create Coupon
            couponResult = couponMapper.add(couponEntity);

            if (couponResult > 0) {
                // Create CouponHistory
                CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
                couponHistoryEntityExt.setCharge(couponEntity.getTotal() - couponEntity.getBalance());
                couponHistoryEntityExt.setCouponId(couponEntity.getId());
                couponHistoryEntityExt.setDeleted(0);
                couponHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                couponHistoryEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());

                int couponHistoryResult = 0;
                // Create CouponHistory
                couponHistoryResult = couponHistoryMapper.add(couponHistoryEntityExt);

                if (couponHistoryResult > 0) {
                    return CouponConverter.toBo(couponEntity);
                } else {
                    throw new ManagerException("Coupon Create Failed: add CouponHistory Failed");
                }

            } else {
                throw new ManagerException("Coupon Create Failed: add Coupon Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("Coupon Create Failed", t);
        }
    }

    @Override
    public List<CouponBo> query(CouponBo couponBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (couponBo == null) {
            throw new ManagerException("Coupon Query Failed: couponBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Coupon Query Failed: userBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        List<CouponEntityExt> couponList = null;
        List<CouponBo> resultList = null;

        try {
            couponList = couponMapper.list(couponEntity, pageEntity);
            for (CouponEntityExt couponPo : couponList) {
                if (couponPo.getUserId() != userEntity.getId()) {
                    throw new ManagerException("Coupon Query Failed: 用户id和优惠券用户id不匹配");
                }
                resultList.add(CouponConverter.toBo(couponPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Coupon Query Failed", t);
        }
    }

    @Override
    public List<CouponHistoryBo> queryHistory(CouponHistoryBo couponHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (couponHistoryBo == null) {
            throw new ManagerException("CouponHistory Query Failed: couponHistoryBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CouponHistory Query Failed: userBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CouponHistoryEntityExt couponHistoryEntity = CouponHistoryConverter.fromBo(couponHistoryBo);
        List<CouponHistoryEntityExt> couponHistoryList = null;
        List<CouponHistoryBo> resultList = null;

        try {
            couponHistoryList = couponHistoryMapper.list(couponHistoryEntity, pageEntity);
            for (CouponHistoryEntityExt couponHistoryPo : couponHistoryList) {
                resultList.add(CouponHistoryConverter.toBo(couponHistoryPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("CouponHistory Query Failed", t);
        }
    }

    @Override
    public List<CouponBo> listCouponByUserId(int userId) {
        List<CouponEntityExt> couponList = null;
        List<CouponBo> resultList = null;

        try {
            couponList = couponMapper.listCouponByUserId(userId);
            for (CouponEntityExt couponPo : couponList) {
                resultList.add(CouponConverter.toBo(couponPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Coupon listByUserId Failed", t);
        }
    }

}
