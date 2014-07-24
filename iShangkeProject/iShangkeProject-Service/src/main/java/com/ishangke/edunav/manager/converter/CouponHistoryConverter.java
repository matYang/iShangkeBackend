package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

public class CouponHistoryConverter {
    public static CouponHistoryBo toBo(CouponHistoryEntityExt e) {
        CouponHistoryBo couponHistoryBo = new CouponHistoryBo();
        couponHistoryBo.setCharge(e.getCharge());
        couponHistoryBo.setChargeEnd(e.getChargeEnd());
        couponHistoryBo.setChargeStart(e.getChargeStart());
        couponHistoryBo.setCouponId(e.getCouponId());
        couponHistoryBo.setCouponIdSet(e.getCouponIdSet());
        couponHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        couponHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        couponHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        couponHistoryBo.setId(e.getId());
        couponHistoryBo.setIdSet(e.getIdSet());
        couponHistoryBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        couponHistoryBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        couponHistoryBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        return couponHistoryBo;
    }

    public static CouponHistoryEntityExt fromBo(CouponHistoryBo bo) {
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        couponHistoryEntityExt.setCharge(bo.getCharge());
        couponHistoryEntityExt.setChargeEnd(bo.getChargeEnd());
        couponHistoryEntityExt.setChargeStart(bo.getChargeStart());
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
