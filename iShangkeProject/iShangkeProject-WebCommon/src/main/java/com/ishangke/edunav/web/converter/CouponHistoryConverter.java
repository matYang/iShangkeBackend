package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
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
        if (vo.getCreateTime() != null) {
            couponHistoryBo.setCreateTime(vo.getCreateTime());
        } else {
            couponHistoryBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            couponHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            couponHistoryBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            couponHistoryBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            couponHistoryBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            couponHistoryBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            couponHistoryBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            couponHistoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            couponHistoryBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            couponHistoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            couponHistoryBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }

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
//        couponHistoryVo.setCouponIdSet(bo.getCouponIdSet());
        couponHistoryVo.setCreateTime(bo.getCreateTime());
//        couponHistoryVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        couponHistoryVo.setCreateTimeStart(bo.getCreateTimeStart());
        couponHistoryVo.setId(bo.getId());
//        couponHistoryVo.setIdSet(bo.getIdSet());
        couponHistoryVo.setLastModifyTime(bo.getLastModifyTime());
//        couponHistoryVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        couponHistoryVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());

        if (Constant.DEFAULTNULL != bo.getOperation()) {
            couponHistoryVo.setOperation(bo.getOperation());
        }
//        couponHistoryVo.setOperationSet(bo.getOperationSet());

        return couponHistoryVo;
    }
}
