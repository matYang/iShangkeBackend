package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.web.model.CouponVo;

public class CouponConverter {
    public static CouponBo fromModel(CouponVo vo) {
        if (vo == null) {
            return null;
        }
        CouponBo couponBo = new CouponBo();
        if (vo.getBalance() != null) {
            couponBo.setBalance(vo.getBalance());
        } else {
            couponBo.setBalance(Constant.DEFAULTNULL);
        }
        if (vo.getBalanceEnd() != null) {
            couponBo.setBalanceEnd(vo.getBalanceEnd());
        } else {
            couponBo.setBalanceEnd(Constant.DEFAULTNULL);
        }
        if (vo.getBalanceStart() != null) {
            couponBo.setBalanceStart(vo.getBalanceStart());
        } else {
            couponBo.setBalanceStart(Constant.DEFAULTNULL);
        }
        if (vo.getCode() != null) {
            couponBo.setCode(vo.getCode());
        }
        if (vo.getEnabled() != null) {
            couponBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            couponBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            couponBo.setIdSet(vo.getIdSet());
        }
        if (vo.getOrigin() != null) {
            couponBo.setOrigin(vo.getOrigin());
        } else {
            couponBo.setOrigin(Constant.DEFAULTNULL);
        }

        if (vo.getOriginSet() != null) {
            couponBo.setOriginSet(vo.getOriginSet());
        }
        if (vo.getRemark() != null) {
            couponBo.setRemark(vo.getRemark());
        }
        if (vo.getTotal() != null) {
            couponBo.setTotal(vo.getTotal());
        } else {
            couponBo.setTotal(Constant.DEFAULTNULL);
        }
        if (vo.getTotalEnd() != null) {
            couponBo.setTotalEnd(vo.getTotalEnd());
        } else {
            couponBo.setTotalEnd(Constant.DEFAULTNULL);
        }
        if (vo.getTotalStart() != null) {
            couponBo.setTotalStart(vo.getTotalStart());
        } else {
            couponBo.setTotalStart(Constant.DEFAULTNULL);
        }
        if (vo.getUserId() != null) {
            couponBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            couponBo.setUserIdSet(vo.getUserIdSet());
        }
        couponBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        couponBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        couponBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart()
                .getTimeInMillis());
        couponBo.setExpiryTime(vo.getExpiryTime() == null ? Constant.DEFAULTNULL : vo.getExpiryTime().getTimeInMillis());
        couponBo.setExpiryTimeEnd(vo.getExpiryTimeEnd() == null ? Constant.DEFAULTNULL : vo.getExpiryTimeEnd()
                .getTimeInMillis());
        couponBo.setExpiryTimeStart(vo.getExpiryTimeStart() == null ? Constant.DEFAULTNULL : vo.getExpiryTimeStart()
                .getTimeInMillis());
        couponBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime()
                .getTimeInMillis());
        couponBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        couponBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        return couponBo;
    }

    public static CouponVo toModel(CouponBo bo) {
        if (bo == null) {
            return null;
        }
        CouponVo couponVo = new CouponVo();
        if (Constant.DEFAULTNULL != bo.getBalance()) {
            couponVo.setBalance(bo.getBalance());
        }
        if (Constant.DEFAULTNULL != bo.getBalanceEnd()) {
            couponVo.setBalanceEnd(bo.getBalanceEnd());
        }
        if (Constant.DEFAULTNULL != bo.getBalanceStart()) {
            couponVo.setBalanceStart(bo.getBalanceStart());
        }
        couponVo.setCode(bo.getCode());
        couponVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        couponVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        couponVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        couponVo.setEnabled(bo.getEnabled());
        couponVo.setExpiryTime(DateUtility.getTimeFromLong(bo.getExpiryTime()));
        couponVo.setExpiryTimeEnd(DateUtility.getTimeFromLong(bo.getExpiryTimeEnd()));
        couponVo.setExpiryTimeStart(DateUtility.getTimeFromLong(bo.getExpiryTimeStart()));
        couponVo.setId(bo.getId());
        couponVo.setIdSet(bo.getIdSet());
        couponVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        couponVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        couponVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        if (Constant.DEFAULTNULL != bo.getOrigin()) {
            couponVo.setOrigin(bo.getOrigin());
        }
        couponVo.setOriginSet(bo.getOriginSet());
        couponVo.setRemark(bo.getRemark());
        if (Constant.DEFAULTNULL != bo.getTotal()) {
            couponVo.setTotal(bo.getTotal());
        }
        if (Constant.DEFAULTNULL != bo.getTotalEnd()) {
            couponVo.setTotalEnd(bo.getTotalEnd());
        }
        if (Constant.DEFAULTNULL != bo.getTotalStart()) {
            couponVo.setTotalStart(bo.getTotalStart());
        }
        couponVo.setUserId(bo.getUserId());
        couponVo.setUserIdSet(bo.getUserIdSet());
        return couponVo;
    }
}
