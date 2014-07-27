package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

public class CouponHistoryConverter {
    public static CouponHistoryBo toBo(CouponHistoryEntityExt e) {
        if (e == null) {
            return null;
        }
        CouponHistoryBo couponHistoryBo = new CouponHistoryBo();
        if (e.getCharge() != null) {
            couponHistoryBo.setCharge(e.getCharge());
        } else {
            couponHistoryBo.setCharge(Constant.DEFAULTNULL);
        }
        if (e.getChargeEnd() != null) {
            couponHistoryBo.setChargeEnd(e.getChargeEnd());
        } else {
            couponHistoryBo.setChargeEnd(Constant.DEFAULTNULL);
        }
        if (e.getChargeStart() != null) {
            couponHistoryBo.setChargeStart(e.getChargeStart());
        } else {
            couponHistoryBo.setChargeStart(Constant.DEFAULTNULL);
        }
        if (e.getCouponId() != null) {
            couponHistoryBo.setCouponId(e.getCouponId());
        }
        if (e.getCouponIdSet() != null) {
            couponHistoryBo.setCouponIdSet(e.getCouponIdSet());
        }
        if (e.getId() != null) {
            couponHistoryBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            couponHistoryBo.setIdSet(e.getIdSet());
        }
        couponHistoryBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        couponHistoryBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        couponHistoryBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        couponHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime()
                .getTimeInMillis());
        couponHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        couponHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e
                .getCreateTimeStart().getTimeInMillis());
        return couponHistoryBo;
    }

    public static CouponHistoryEntityExt fromBo(CouponHistoryBo bo) {
        if (bo == null) {
            return null;
        }
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        if (bo.getCharge() != Constant.DEFAULTNULL) {
            couponHistoryEntityExt.setCharge(bo.getCharge());
        }
        if (bo.getChargeEnd() != Constant.DEFAULTNULL) {
            couponHistoryEntityExt.setChargeEnd(bo.getChargeEnd());
        }
        if (bo.getChargeStart() != Constant.DEFAULTNULL) {
            couponHistoryEntityExt.setChargeStart(bo.getChargeStart());
        }
        couponHistoryEntityExt.setCouponId(bo.getCouponId());
        couponHistoryEntityExt.setCouponIdSet(bo.getCouponIdSet());
        couponHistoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        couponHistoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        couponHistoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        couponHistoryEntityExt.setId(bo.getId());
        couponHistoryEntityExt.setIdSet(bo.getIdSet());
        couponHistoryEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        couponHistoryEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        couponHistoryEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        return couponHistoryEntityExt;
    }
}
