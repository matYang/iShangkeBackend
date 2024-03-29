package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.DefaultValue;
import com.ishangke.edunav.common.enums.CouponEnums;
import com.ishangke.edunav.common.enums.CouponHistoryEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
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
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.manager.exception.notfound.CouponNotFoundException;

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
        if (couponBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // admin and system admins can create user's coupons
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CouponManagerImpl]system admin || admin [%s] call createCoupon at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only modify their own, thus making an UserId
            // necessary
            if (couponEntity == null || IdChecker.notEqual(couponEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("User creating someone else's coupon");
            }
        }

        couponEntity.setCreateTime(DateUtility.getCurTimeInstance());
        couponEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        couponEntity.setEnabled(0);
        couponEntity.setDeleted(0);
        int couponResult = 0;
        try {
            // Create Coupon
            couponResult = couponMapper.add(couponEntity);
        } catch (Throwable t) {
            throw new ManagerException("Coupon create failed for user: " + userEntity.getId(), t);
        }
        if (couponResult <= 0) {
            throw new ManagerException("Coupon Create Failed: add Coupon Failed");
        }
        
        CouponHistoryEntityExt couponHistoryEntity = new CouponHistoryEntityExt();
        couponHistoryEntity.setCouponId(couponEntity.getId());
        couponHistoryEntity.setCharge(couponEntity.getBalance());
        couponHistoryEntity.setOperation(CouponHistoryEnums.Operation.INC.code);
        couponHistoryEntity.setCreateTime(DateUtility.getCurTimeInstance());
        couponHistoryEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        couponHistoryEntity.setDeleted(0);
        int couponHistoryResult;
        try {
            couponHistoryResult = couponHistoryMapper.add(couponHistoryEntity);
        } catch (Throwable t) {
            throw new ManagerException("Coupon Create Failed: add CouponHistory Failed for user: " + userEntity.getId(), t);
        }
        if (couponHistoryResult <= 0) {
            throw new ManagerException("Coupon Create Failed: add CouponHistory Failed");
        }
        
        return CouponConverter.toBo(couponMapper.getById(couponEntity.getId()));
    }

    @Override
    public CouponBo activateCoupon(CouponBo couponBo, UserBo userBo) {
        // Check Null
        if (couponBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(couponEntity.getId())) {
            throw new ManagerException("Coupon activation must specify id");
        }
        CouponEntityExt previousCoupon = couponMapper.getById(couponEntity.getId());
        if (previousCoupon == null) {
            throw new CouponNotFoundException("Coupon to activate is not found with id:" + couponEntity.getId());
        }

        // admin and system admins can update user's coupons
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CouponManagerImpl]system admin || admin [%s] call activateCoupon at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only modify their own, thus making an UserId
            // necessary
            if (IdChecker.notEqual(previousCoupon.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("User activating someone else's coupon");
            }
        }

        if (previousCoupon.getExpiryTime().before(DateUtility.getCurTime())) {
            // update the coupon to be expired, and return
            previousCoupon.setStatus(CouponEnums.Status.EXPIRED.code);
            previousCoupon.setLastModifyTime(DateUtility.getCurTimeInstance());

            try {
                // update Coupon
                couponMapper.update(previousCoupon);
            } catch (Throwable t) {
                throw new ManagerException("Coupon activate failed for user: " + previousCoupon.getId(), t);
            }

            throw new ManagerException("Coupon has already expired");
        } else {
            previousCoupon.setStatus(CouponEnums.Status.USABLE.code);
            previousCoupon.setLastModifyTime(DateUtility.getCurTimeInstance());

            try {
                // update Coupon
                couponMapper.update(previousCoupon);
            } catch (Throwable t) {
                throw new ManagerException("Coupon activate failed for user: " + previousCoupon.getId(), t);
            }
        }

        return CouponConverter.toBo(couponMapper.getById(previousCoupon.getId()));
    }

    @Override
    public CouponBo updateCoupon(CouponBo couponBo, UserBo userBo) {
        // Check Null
        if (couponBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(couponEntity.getId())) {
            throw new ManagerException("Coupon update must specify id");
        }
        CouponEntityExt previousCoupon = couponMapper.getById(couponEntity.getId());
        if (previousCoupon == null) {
            throw new CouponNotFoundException("Previous coupon is not found");
        }

        // admin and system admins can update user's coupons
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CouponManagerImpl]system admin || admin [%s] call updateCoupon at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only modify their own, thus making an UserId
            // necessary
            if (IdChecker.notEqual(previousCoupon.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("User updating someone else's coupon");
            }
        }

        // Create CouponHistory
        double balanceDiff = previousCoupon.getBalance() - couponEntity.getBalance();
        int operation = CouponHistoryEnums.Operation.DEC.code;
        if (balanceDiff < -DefaultValue.DOUBLEPRCISIONOFFSET) {
            balanceDiff = -balanceDiff;
            operation = CouponHistoryEnums.Operation.INC.code;
        }
        CouponHistoryEntityExt couponHistoryEntity = new CouponHistoryEntityExt();
        couponHistoryEntity.setCouponId(couponEntity.getId());
        couponHistoryEntity.setCharge(balanceDiff);
        couponHistoryEntity.setOperation(operation);
        couponHistoryEntity.setCreateTime(DateUtility.getCurTimeInstance());
        couponHistoryEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        couponHistoryEntity.setDeleted(0);

        couponEntity.setUserId(null);
        couponEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        couponEntity.setCreateTime(null);
        couponEntity.setEnabled(null);
        
        int couponHistoryResult = 0;
        try {
            // update Coupon
            couponMapper.update(couponEntity);
            couponHistoryResult = couponHistoryMapper.add(couponHistoryEntity);
        } catch (Throwable t) {
            throw new ManagerException("Coupon update failed for user: " + userEntity.getId(), t);
        }
        if (couponHistoryResult <= 0) {
            throw new ManagerException("Coupon Create Failed: add CouponHistory Failed");
        }

        return CouponConverter.toBo(couponMapper.getById(couponEntity.getId()));
    }
    

    @Override
    public List<CouponBo> updateCouponList(List<CouponBo> couponBoList, UserBo userBo) {
        for (CouponBo couponBo : couponBoList) {
            updateCoupon(couponBo, userBo);
        }
        return couponBoList;
    }

    @Override
    public List<CouponBo> query(CouponBo couponBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        CouponEntityExt couponEntity = couponBo == null ? null : CouponConverter.fromBo(couponBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // admin and system admins can query user's coupons
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CouponManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only query their own, thus making an UserId
            // necessary
            if (couponEntity == null || IdChecker.notEqual(couponEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("User querying someone else's coupon");
            }
        }

        // Convert
        List<CouponEntityExt> results = null;
        try {
            results = couponMapper.list(couponEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("Coupon query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<CouponBo>();
        }
        ArrayList<CouponBo> convertedResults = new ArrayList<CouponBo>();
        for (CouponEntityExt couponPo : results) {
            convertedResults.add(CouponConverter.toBo(couponPo));
        }
        return convertedResults;
    }

    @Override
    // note, for a normal user query history can only query the coupon history
    // of a single coupon, specified by the coupon id field in coupon history
    public List<CouponHistoryBo> queryHistory(CouponHistoryBo couponHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        CouponHistoryEntityExt couponHistoryEntity = couponHistoryBo == null ? null : CouponHistoryConverter.fromBo(couponHistoryBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // admin and system admins can query user's coupons
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CouponManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            // for a user, he/she can only query coupon history of a coupon that
            // belongs to he/she
            // this means that a couponId is absolutely necessary
            if (couponHistoryEntity == null || IdChecker.isNull(couponHistoryEntity.getCouponId())) {
                throw new ManagerException("User query coupon history did not specify couponId");
            }
            CouponEntityExt correspondingCoupon = null;
            try {
                correspondingCoupon = couponMapper.getById(couponHistoryEntity.getCouponId());
            } catch (Throwable t) {
                throw new ManagerException("Corresponding coupon not found when querying coupon history with coupnId: " + couponHistoryEntity.getCouponId());
            }
            // otherwise user can only query their own, thus making an UserId
            // necessary
            if (correspondingCoupon == null || IdChecker.notEqual(correspondingCoupon.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("User querying someone else's coupon history");
            }
        }

        // Convert
        List<CouponHistoryEntityExt> results = null;
        try {
            results = couponHistoryMapper.list(couponHistoryEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("CouponHistory query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<CouponHistoryBo>();
        }
        List<CouponHistoryBo> convertedResults = new ArrayList<CouponHistoryBo>();
        for (CouponHistoryEntityExt result : results) {
            convertedResults.add(CouponHistoryConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public int queryTotal(CouponBo couponBo, UserBo userBo) {
        return couponMapper.getListCount(CouponConverter.fromBo(couponBo));
    }

    @Override
    public int queryHistoryTotal(CouponHistoryBo couponHistoryBo, UserBo userBo) {
        return couponHistoryMapper.getListCount(CouponHistoryConverter.fromBo(couponHistoryBo));
    }

    @Override
    public CouponBo queryById(int id, UserBo userBo) {
        if (id <= 0 || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        CouponEntityExt couponEntity = couponMapper.getById(id);
        if (couponEntity == null) {
            throw new CouponNotFoundException("Coupn does not exist");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CouponManagerImpl]system admin || admin [%s] call queryById at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only query their own
            if (IdChecker.notEqual(couponEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("User querying someone else's coupon");
            }
        }

        return CouponConverter.toBo(couponEntity);
    }

}
