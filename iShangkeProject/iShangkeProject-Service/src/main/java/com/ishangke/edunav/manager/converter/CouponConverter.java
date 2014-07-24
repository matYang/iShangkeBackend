package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

public class CouponConverter {
    public static CouponBo toBo(CouponEntityExt e) {
        CouponBo couponBo = new CouponBo();
        couponBo.setBalance(e.getBalance());
        couponBo.setBalanceEnd(e.getBalanceEnd());
        couponBo.setBalanceStart(e.getBalanceStart());
        couponBo.setCode(e.getCode());
        couponBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        couponBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        couponBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        couponBo.setEnabled(e.getEnabled());
        couponBo.setExpiryTime(e.getExpiryTime() == null ? Constant.DEFAULTNULL : e.getExpiryTime().getTimeInMillis());
        couponBo.setExpiryTimeEnd(e.getExpiryTimeEnd() == null ? Constant.DEFAULTNULL : e.getExpiryTimeEnd().getTimeInMillis());
        couponBo.setExpiryTimeStart(e.getExpiryTimeStart() == null ? Constant.DEFAULTNULL : e.getExpiryTimeStart().getTimeInMillis());
        couponBo.setId(e.getId());
        couponBo.setIdSet(e.getIdSet());
        couponBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        couponBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        couponBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
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
        couponEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
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
