package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.web.common.DateUtility;
import com.ishangke.edunav.web.model.WithdrawVo;

public class WithdrawConverter {
    public static WithdrawBo fromModel(WithdrawVo vo) {
        WithdrawBo withdrawBo = new WithdrawBo();
        withdrawBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        withdrawBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        withdrawBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        withdrawBo.setEnabled(vo.getEnabled());
        withdrawBo.setId(vo.getId());
        withdrawBo.setIdSet(vo.getIdSet());
        withdrawBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        withdrawBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        withdrawBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        withdrawBo.setPayeeId(vo.getPayeeId());
        withdrawBo.setPeyeeName(vo.getPeyeeName());
        withdrawBo.setType(vo.getType());
        withdrawBo.setUserId(vo.getUserId());
        withdrawBo.setUserIdSet(vo.getUserIdSet());
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
