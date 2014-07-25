package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.web.common.DateUtility;
import com.ishangke.edunav.web.model.WithdrawVo;

public class WithdrawConverter {
    public static WithdrawBo fromModel(WithdrawVo vo) {
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
        if (vo.getPeyeeName() != null) {
            withdrawBo.setPeyeeName(vo.getPeyeeName());
        }
        if (vo.getType() != null) {
            withdrawBo.setType(vo.getType());
        }
        if (vo.getUserId() != null) {
            withdrawBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            withdrawBo.setUserIdSet(vo.getUserIdSet());
        }
        withdrawBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        withdrawBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        withdrawBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        withdrawBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        withdrawBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        withdrawBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return withdrawBo;
    }

    public static WithdrawVo toModel(WithdrawBo bo) {
        WithdrawVo withdrawVo =new WithdrawVo();
        withdrawVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        withdrawVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        withdrawVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        withdrawVo.setEnabled(bo.getEnabled());
        withdrawVo.setId(bo.getId());
        withdrawVo.setIdSet(bo.getIdSet());
        withdrawVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        withdrawVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        withdrawVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        withdrawVo.setPayeeId(bo.getPayeeId());
        withdrawVo.setPeyeeName(bo.getPeyeeName());
        withdrawVo.setType(bo.getType());
        withdrawVo.setUserId(bo.getUserId());
        withdrawVo.setUserIdSet(bo.getUserIdSet());
        return withdrawVo;
    }
}
