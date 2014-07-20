package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.web.user.model.CouponVo;
import com.ishangke.edunav.web.user.common.DateUtility;

public class CouponConverter {
    public static CouponBo fromModel(CouponVo vo) {
        CouponBo couponBo = new CouponBo();
        couponBo.setBalance(vo.getBalance());
        couponBo.setBalanceEnd(vo.getBalanceEnd());
        couponBo.setBalanceStart(vo.getBalanceStart());
        couponBo.setCode(vo.getCode());
        couponBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        couponBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        couponBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        couponBo.setEnabled(vo.getEnabled());
        couponBo.setExpiryTime(vo.getExpiryTime().getTimeInMillis());
        couponBo.setExpiryTimeEnd(vo.getExpiryTimeEnd().getTimeInMillis());
        couponBo.setExpiryTimeStart(vo.getExpiryTimeStart().getTimeInMillis());
        couponBo.setId(vo.getId());
        couponBo.setIdSet(vo.getIdSet());
        couponBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        couponBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        couponBo.setExpiryTimeStart(vo.getExpiryTimeStart().getTimeInMillis());
        couponBo.setOrigin(vo.getOrigin());
        couponBo.setOriginSet(vo.getOriginSet());
        couponBo.setRemark(vo.getRemark());
        couponBo.setTotal(vo.getTotal());
        couponBo.setTotalEnd(vo.getTotalEnd());
        couponBo.setTotalStart(vo.getTotalStart());
        couponBo.setUserId(vo.getUserId());
        couponBo.setUserIdSet(vo.getUserIdSet());
        return couponBo;
    }

    public static CouponVo toModel(CouponBo bo) {
        CouponVo couponVo = new CouponVo();
        couponVo.setBalance(bo.getBalance());
        couponVo.setBalanceEnd(bo.getBalanceEnd());
        couponVo.setBalanceStart(bo.getBalanceStart());
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
        couponVo.setExpiryTimeStart(DateUtility.getTimeFromLong(bo.getExpiryTimeStart()));
        couponVo.setOrigin(bo.getOrigin());
        couponVo.setOriginSet(bo.getOriginSet());
        couponVo.setRemark(bo.getRemark());
        couponVo.setTotal(bo.getTotal());
        couponVo.setTotalEnd(bo.getTotalEnd());
        couponVo.setTotalStart(bo.getTotalStart());
        couponVo.setUserId(bo.getUserId());
        couponVo.setUserIdSet(bo.getUserIdSet());
        return couponVo;
    }
}
