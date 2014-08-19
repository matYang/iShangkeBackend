package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.web.model.WithdrawVo;

public class WithdrawConverter {
    public static WithdrawBo fromModel(WithdrawVo vo) {
        if (vo == null) {
            return null;
        }
        WithdrawBo withdrawBo = new WithdrawBo();
        if (vo.getEnabled() != null) {
            withdrawBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            withdrawBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            withdrawBo.setIdSet(vo.getIdSet());
        }
        if (vo.getPayeeId() != null) {
            withdrawBo.setPayeeId(vo.getPayeeId());
        }
        if (vo.getPayeeName() != null) {
            withdrawBo.setPayeeName(vo.getPayeeName());
        }
        if (vo.getType() != null) {
            withdrawBo.setType(vo.getType());
        } else {
            withdrawBo.setType(Constant.DEFAULTNULL);
        }
        if (vo.getUserId() != null) {
            withdrawBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            withdrawBo.setUserIdSet(vo.getUserIdSet());
        }
        if (vo.getCreateTime() != null) {
            withdrawBo.setCreateTime(vo.getCreateTime());
        } else {
            withdrawBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            withdrawBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            withdrawBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            withdrawBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            withdrawBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            withdrawBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            withdrawBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            withdrawBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            withdrawBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            withdrawBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            withdrawBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return withdrawBo;
    }

    public static WithdrawVo toModel(WithdrawBo bo) {
        if (bo == null) {
            return null;
        }
        WithdrawVo withdrawVo = new WithdrawVo();
        withdrawVo.setCreateTime(bo.getCreateTime());
//        withdrawVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        withdrawVo.setCreateTimeStart(bo.getCreateTimeStart());
        withdrawVo.setEnabled(bo.getEnabled());
        withdrawVo.setId(bo.getId());
        withdrawVo.setIdSet(bo.getIdSet());
        withdrawVo.setLastModifyTime(bo.getLastModifyTime());
//        withdrawVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        withdrawVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        withdrawVo.setPayeeId(bo.getPayeeId());
        withdrawVo.setPayeeName(bo.getPayeeName());
        if (Constant.DEFAULTNULL != bo.getType()) {
            withdrawVo.setType(bo.getType());
        }
        withdrawVo.setUserId(bo.getUserId());
//        withdrawVo.setUserIdSet(bo.getUserIdSet());
        return withdrawVo;
    }
}
