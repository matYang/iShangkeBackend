package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class CouponConverter {
    public static CouponBo toBo(CouponEntityExt e) {
        CouponBo couponBo = new CouponBo();
        couponBo.setBalance(e.getBalance());
        couponBo.setBalanceEnd(e.getBalanceEnd());
        couponBo.setBalanceStart(e.getBalanceStart());
        couponBo.setCode(e.getCode());
        couponBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        couponBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        couponBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        couponBo.setEnabled(e.getEnabled());
        couponBo.setExpiryTime(e.getExpiryTime().getTimeInMillis());
        couponBo.setExpiryTimeEnd(e.getExpiryTimeEnd().getTimeInMillis());
        couponBo.setExpiryTimeStart(e.getExpiryTimeStart().getTimeInMillis());
        couponBo.setId(e.getId());
        couponBo.setIdSet(e.getIdSet());
        couponBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        couponBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        couponBo.setExpiryTimeStart(e.getExpiryTimeStart().getTimeInMillis());
        couponBo.setOrigin(e.getOrigin());
        couponBo.setOriginSet(e.getOriginSet());
        couponBo.setRemark(e.getRemark());
        couponBo.setTotal(e.getTotal());
        couponBo.setTotalEnd(e.getTotalEnd());
        couponBo.setTotalStart(e.getTotalStart());
        couponBo.setUserId(e.getUserId());
        couponBo.setUserIdSet(e.getUserIdSet());
        return couponBo;
    }

    public static CouponEntityExt fromBo(CouponBo bo) {
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        couponEntityExt.setBalance(bo.getBalance());
        couponEntityExt.setBalanceEnd(bo.getBalanceEnd());
        couponEntityExt.setBalanceStart(bo.getBalanceStart());
        couponEntityExt.setCode(bo.getCode());
        couponEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        couponEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        couponEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        couponEntityExt.setEnabled(bo.getEnabled());
        couponEntityExt.setExpiryTime(DateUtility.getTimeFromLong(bo.getExpiryTime()));
        couponEntityExt.setExpiryTimeEnd(DateUtility.getTimeFromLong(bo.getExpiryTimeEnd()));
        couponEntityExt.setExpiryTimeStart(DateUtility.getTimeFromLong(bo.getExpiryTimeStart()));
        couponEntityExt.setId(bo.getId());
        couponEntityExt.setIdSet(bo.getIdSet());
        couponEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        couponEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        couponEntityExt.setExpiryTimeStart(DateUtility.getTimeFromLong(bo.getExpiryTimeStart()));
        couponEntityExt.setOrigin(bo.getOrigin());
        couponEntityExt.setOriginSet(bo.getOriginSet());
        couponEntityExt.setRemark(bo.getRemark());
        couponEntityExt.setTotal(bo.getTotal());
        couponEntityExt.setTotalEnd(bo.getTotalEnd());
        couponEntityExt.setTotalStart(bo.getTotalStart());
        couponEntityExt.setUserId(bo.getUserId());
        couponEntityExt.setUserIdSet(bo.getUserIdSet());
        return couponEntityExt;
    }
}
