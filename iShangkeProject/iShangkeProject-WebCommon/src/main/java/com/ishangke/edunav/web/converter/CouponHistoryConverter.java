package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.web.model.CouponHistoryVo;
import com.ishangke.edunav.web.common.DateUtility;

public class CouponHistoryConverter {
    public static CouponHistoryBo fromModel(CouponHistoryVo vo) {
        CouponHistoryBo couponHistoryBo = new CouponHistoryBo();
        couponHistoryBo.setCharge(vo.getCharge());
        couponHistoryBo.setChargeEnd(vo.getChargeEnd());
        couponHistoryBo.setChargeStart(vo.getChargeStart());
        couponHistoryBo.setCouponId(vo.getCouponId());
        couponHistoryBo.setCouponIdSet(vo.getCouponIdSet());
        couponHistoryBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        couponHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        couponHistoryBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        couponHistoryBo.setId(vo.getId());
        couponHistoryBo.setIdSet(vo.getIdSet());
        couponHistoryBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        couponHistoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        couponHistoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        return couponHistoryBo;
    }

    public static CouponHistoryVo toModel(CouponHistoryBo bo) {
        CouponHistoryVo couponHistoryVo = new CouponHistoryVo();
        couponHistoryVo.setCharge(bo.getCharge());
        couponHistoryVo.setChargeEnd(bo.getChargeEnd());
        couponHistoryVo.setChargeStart(bo.getChargeStart());
        couponHistoryVo.setCouponId(bo.getCouponId());
        couponHistoryVo.setCouponIdSet(bo.getCouponIdSet());
        couponHistoryVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        couponHistoryVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        couponHistoryVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        couponHistoryVo.setId(bo.getId());
        couponHistoryVo.setIdSet(bo.getIdSet());
        couponHistoryVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        couponHistoryVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        couponHistoryVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        return couponHistoryVo;
    }
}
