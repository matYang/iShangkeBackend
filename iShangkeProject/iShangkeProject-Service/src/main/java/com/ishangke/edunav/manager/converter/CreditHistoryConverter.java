package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

public class CreditHistoryConverter {
    public static CreditHistoryBo toBo(CreditHistoryEntityExt e) {
        CreditHistoryBo creditHistoryBo = new CreditHistoryBo();
        creditHistoryBo.setCharge(e.getCharge());
        creditHistoryBo.setChargeEnd(e.getChargeEnd());
        creditHistoryBo.setChargeStart(e.getChargeStart());
        creditHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        creditHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        creditHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        creditHistoryBo.setId(e.getId());
        creditHistoryBo.setIdSet(e.getIdSet());
        creditHistoryBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        creditHistoryBo.setUserId(e.getUserId());
        creditHistoryBo.setUserIdSet(e.getUserIdSet());
        return creditHistoryBo;
    }

    public static CreditHistoryEntityExt fromBo(CreditHistoryBo bo) {
        CreditHistoryEntityExt creditHistoryEntityExt = new CreditHistoryEntityExt();
        creditHistoryEntityExt.setCharge(bo.getCharge());
        creditHistoryEntityExt.setChargeEnd(bo.getChargeEnd());
        creditHistoryEntityExt.setChargeStart(bo.getChargeStart());
        creditHistoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        creditHistoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        creditHistoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        creditHistoryEntityExt.setId(bo.getId());
        creditHistoryEntityExt.setIdSet(bo.getIdSet());
        creditHistoryEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        creditHistoryEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        creditHistoryEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        creditHistoryEntityExt.setUserId(bo.getUserId());
        creditHistoryEntityExt.setUserIdSet(bo.getUserIdSet());
        return creditHistoryEntityExt;
    }
}
