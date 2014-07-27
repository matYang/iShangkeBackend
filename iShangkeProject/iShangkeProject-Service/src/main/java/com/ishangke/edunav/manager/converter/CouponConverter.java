package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

public class CouponConverter {
    public static CouponBo toBo(CouponEntityExt e) {
        if (e == null) {
            return null;
        }
        CouponBo couponBo = new CouponBo();
        if (e.getBalance() != null) {
            couponBo.setBalance(e.getBalance());
        } else {
            couponBo.setBalance(Constant.DEFAULTNULL);
        }
        if (e.getBalanceEnd() != null) {
            couponBo.setBalanceEnd(e.getBalanceEnd());
        } else {
            couponBo.setBalanceEnd(Constant.DEFAULTNULL);
        }
        if (e.getBalanceStart() != null) {
            couponBo.setBalanceStart(e.getBalanceStart());
        } else {
            couponBo.setBalanceStart(Constant.DEFAULTNULL);
        }
        if (e.getCode() != null) {
            couponBo.setCode(e.getCode());
        }
        if (e.getEnabled() != null) {
            couponBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            couponBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            couponBo.setIdSet(e.getIdSet());
        }
        if (e.getOrigin() != null) {
            couponBo.setOrigin(e.getOrigin());
        } else {
            couponBo.setOrigin(Constant.DEFAULTNULL);
        }
        if (e.getOriginSet() != null) {
            couponBo.setOriginSet(e.getOriginSet());
        }
        if (e.getRemark() != null) {
            couponBo.setRemark(e.getRemark());
        }
        if (e.getTotal() != null) {
            couponBo.setTotal(e.getTotal());
        } else {
            couponBo.setTotal(Constant.DEFAULTNULL);
        }
        if (e.getTotalEnd() != null) {
            couponBo.setTotalEnd(e.getTotalEnd());
        } else {
            couponBo.setTotalEnd(Constant.DEFAULTNULL);
        }
        if (e.getTotalStart() != null) {
            couponBo.setTotalStart(e.getTotalStart());
        } else {
            couponBo.setTotalStart(Constant.DEFAULTNULL);
        }
        if (e.getUserId() != null) {
            couponBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            couponBo.setUserIdSet(e.getUserIdSet());
        }
        couponBo.setExpiryTime(e.getExpiryTime() == null ? Constant.DEFAULTNULL : e.getExpiryTime().getTimeInMillis());
        couponBo.setExpiryTimeEnd(e.getExpiryTimeEnd() == null ? Constant.DEFAULTNULL : e.getExpiryTimeEnd()
                .getTimeInMillis());
        couponBo.setExpiryTimeStart(e.getExpiryTimeStart() == null ? Constant.DEFAULTNULL : e.getExpiryTimeStart()
                .getTimeInMillis());
        couponBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        couponBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        couponBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        couponBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        couponBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        couponBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return couponBo;
    }

    public static CouponEntityExt fromBo(CouponBo bo) {
        if (bo == null) {
            return null;
        }
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        if (bo.getBalance() != Constant.DEFAULTNULL) {
            couponEntityExt.setBalance(bo.getBalance());
        }
        if (bo.getBalanceEnd() != Constant.DEFAULTNULL) {
            couponEntityExt.setBalanceEnd(bo.getBalanceEnd());
        }
        if (bo.getBalanceStart() != Constant.DEFAULTNULL) {
            couponEntityExt.setBalanceStart(bo.getBalanceStart());
        }
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
        if (bo.getOrigin() != Constant.DEFAULTNULL) {
            couponEntityExt.setOrigin(bo.getOrigin());
        }
        couponEntityExt.setOriginSet(bo.getOriginSet());
        couponEntityExt.setRemark(bo.getRemark());
        if (bo.getTotal() != Constant.DEFAULTNULL) {
            couponEntityExt.setTotal(bo.getTotal());
        }
        if (bo.getTotalEnd() != Constant.DEFAULTNULL) {
            couponEntityExt.setTotalEnd(bo.getTotalEnd());
        }
        if (bo.getTotalStart() != Constant.DEFAULTNULL) {
            couponEntityExt.setTotalStart(bo.getTotalStart());
        }
        couponEntityExt.setUserId(bo.getUserId());
        couponEntityExt.setUserIdSet(bo.getUserIdSet());
        return couponEntityExt;
    }
}
