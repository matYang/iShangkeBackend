package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class WithdrawConverter {
    public static WithdrawBo toBo(WithdrawEntityExt e) {
        WithdrawBo withdrawBo = new WithdrawBo();
        withdrawBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        withdrawBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        withdrawBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        withdrawBo.setEnabled(e.getEnabled());
        withdrawBo.setId(e.getId());
        withdrawBo.setIdSet(e.getIdSet());
        withdrawBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        withdrawBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        withdrawBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        withdrawBo.setPayeeId(e.getPayeeId());
        withdrawBo.setPeyeeName(e.getPeyeeName());
        withdrawBo.setType(e.getType());
        withdrawBo.setUserId(e.getUserId());
        withdrawBo.setUserIdSet(e.getUserIdSet());
        return withdrawBo;
    }

    public static WithdrawEntityExt fromBo(WithdrawBo bo) {
        WithdrawEntityExt withdrawEntityExt =new WithdrawEntityExt();
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
        withdrawEntityExt.setType(bo.getType());
        withdrawEntityExt.setUserId(bo.getUserId());
        withdrawEntityExt.setUserIdSet(bo.getUserIdSet());
        return withdrawEntityExt;
    }
}
