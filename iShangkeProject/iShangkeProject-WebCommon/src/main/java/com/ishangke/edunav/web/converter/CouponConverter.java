package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
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
        if (vo.getCreateTime() != null) {
            couponBo.setCreateTime(vo.getCreateTime());
        } else {
            couponBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            couponBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            couponBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            couponBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            couponBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getExpiryTime() != null) {
            couponBo.setExpiryTime(vo.getExpiryTime());
        } else {
            couponBo.setExpiryTime(Constant.DEFAULTNULL);
        }
        if (vo.getExpiryTimeEnd() != null) {
            couponBo.setExpiryTimeEnd(vo.getExpiryTimeEnd());
        } else {
            couponBo.setExpiryTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getExpiryTimeStart() != null) {
            couponBo.setExpiryTimeStart(vo.getExpiryTimeStart());
        } else {
            couponBo.setExpiryTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            couponBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            couponBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            couponBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            couponBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            couponBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            couponBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }

        if (vo.getStatus() != null) {
            couponBo.setStatus(vo.getStatus());
        } else {
            couponBo.setStatus(Constant.DEFAULTNULL);
        }

        if (vo.getStatusSet() != null) {
            couponBo.setStatusSet(vo.getStatusSet());
        }

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
        couponVo.setCreateTime(bo.getCreateTime());
//        couponVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        couponVo.setCreateTimeStart(bo.getCreateTimeStart());
        couponVo.setEnabled(bo.getEnabled());
        couponVo.setExpiryTime(bo.getExpiryTime());
//        couponVo.setExpiryTimeEnd(bo.getExpiryTimeEnd());
//        couponVo.setExpiryTimeStart(bo.getExpiryTimeStart());
        couponVo.setId(bo.getId());
        couponVo.setIdSet(bo.getIdSet());
        couponVo.setLastModifyTime(bo.getLastModifyTime());
//        couponVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        couponVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
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
//        couponVo.setUserIdSet(bo.getUserIdSet());

        if (Constant.DEFAULTNULL != bo.getStatus()) {
            couponVo.setStatus(bo.getStatus());
        }
//        couponVo.setStatusSet(bo.getStatusSet());

        return couponVo;
    }
}
