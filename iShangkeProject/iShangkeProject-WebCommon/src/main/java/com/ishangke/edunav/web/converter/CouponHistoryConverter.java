package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.web.model.CouponHistoryVo;

public class CouponHistoryConverter {
    public static CouponHistoryBo fromModel(CouponHistoryVo vo) {
        if (vo == null) {
            return null;
        }
        CouponHistoryBo couponHistoryBo = new CouponHistoryBo();
        if (vo.getCharge() != null) {
            couponHistoryBo.setCharge(vo.getCharge());
        } else {
            couponHistoryBo.setCharge(Constant.DEFAULTNULL);
        }
        if (vo.getChargeEnd() != null) {
            couponHistoryBo.setChargeEnd(vo.getChargeEnd());
        } else {
            couponHistoryBo.setChargeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getChargeStart() != null) {
            couponHistoryBo.setChargeStart(vo.getChargeStart());
        } else {
            couponHistoryBo.setChargeStart(Constant.DEFAULTNULL);
        }
        if (vo.getCouponId() != null) {
            couponHistoryBo.setCouponId(vo.getCouponId());
        }
        if (vo.getCouponIdSet() != null) {
            couponHistoryBo.setCouponIdSet(vo.getCouponIdSet());
        }
        if (vo.getId() != null) {
            couponHistoryBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            couponHistoryBo.setIdSet(vo.getIdSet());
        }
        couponHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        couponHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        couponHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getCreateTimeStart().getTimeInMillis());
        couponHistoryBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTime().getTimeInMillis());
        couponHistoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        couponHistoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        
        if (vo.getOperation() != null) {
            couponHistoryBo.setOperation(vo.getOperation());
        } else {
            couponHistoryBo.setOperation(Constant.DEFAULTNULL);
        }
        if (vo.getOperationSet() != null) {
            couponHistoryBo.setOperationSet(vo.getOperationSet());
        }
        
        return couponHistoryBo;
    }

    public static CouponHistoryVo toModel(CouponHistoryBo bo) {
        if (bo == null) {
            return null;
        }
        CouponHistoryVo couponHistoryVo = new CouponHistoryVo();
        if (Constant.DEFAULTNULL != bo.getCharge()) {
            couponHistoryVo.setCharge(bo.getCharge());
        }
        if (Constant.DEFAULTNULL != bo.getChargeEnd()) {
            couponHistoryVo.setChargeEnd(bo.getChargeEnd());
        }
        if (Constant.DEFAULTNULL != bo.getChargeStart()) {
            couponHistoryVo.setChargeStart(bo.getChargeStart());
        }
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
        
        if (Constant.DEFAULTNULL != bo.getOperation()) {
            couponHistoryVo.setOperation(bo.getOperation());
        }
        couponHistoryVo.setOperationSet(bo.getOperationSet());
        
        return couponHistoryVo;
    }
}
