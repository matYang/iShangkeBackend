package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;

public class WithdrawConverter {
    public static WithdrawBo toBo(WithdrawEntityExt e) {
        if (e == null) {
            return null;
        }
        WithdrawBo withdrawBo = new WithdrawBo();
        if (e.getEnabled() != null) {
            withdrawBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            withdrawBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            withdrawBo.setIdSet(e.getIdSet());
        }
        if (e.getPayeeId() != null) {
            withdrawBo.setPayeeId(e.getPayeeId());
        }
        if (e.getPeyeeName() != null) {
            withdrawBo.setPeyeeName(e.getPeyeeName());
        }
        if (e.getType() != null) {
            withdrawBo.setType(e.getType());
        } else {
            withdrawBo.setType(Constant.DEFAULTNULL);
        }
        if (e.getUserId() != null) {
            withdrawBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            withdrawBo.setUserIdSet(e.getUserIdSet());
        }
        withdrawBo
                .setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        withdrawBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        withdrawBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        withdrawBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        withdrawBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        withdrawBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return withdrawBo;
    }

    public static WithdrawEntityExt fromBo(WithdrawBo bo) {
        if (bo == null) {
            return null;
        }
        WithdrawEntityExt withdrawEntityExt = new WithdrawEntityExt();
        withdrawEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        withdrawEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        withdrawEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        withdrawEntityExt.setEnabled(bo.getEnabled());
        withdrawEntityExt.setId(bo.getId());
        withdrawEntityExt.setIdSet(bo.getIdSet());
        withdrawEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        withdrawEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        withdrawEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        withdrawEntityExt.setPayeeId(bo.getPayeeId());
        withdrawEntityExt.setPeyeeName(bo.getPeyeeName());
        if (bo.getType() != Constant.DEFAULTNULL) {
            withdrawEntityExt.setType(bo.getType());
        }
        withdrawEntityExt.setUserId(bo.getUserId());
        withdrawEntityExt.setUserIdSet(bo.getUserIdSet());
        return withdrawEntityExt;
    }
}
