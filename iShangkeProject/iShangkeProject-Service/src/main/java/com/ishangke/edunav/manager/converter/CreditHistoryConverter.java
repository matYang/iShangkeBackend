package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class CreditHistoryConverter {
    public static CreditHistoryBo toBo(CreditHistoryEntityExt e) {
        CreditHistoryBo creditHistoryBo = new CreditHistoryBo();
        creditHistoryBo.setCharge(e.getCharge());
        creditHistoryBo.setChargeEnd(e.getChargeEnd());
        creditHistoryBo.setChargeStart(e.getChargeStart());
        creditHistoryBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        creditHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        creditHistoryBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        creditHistoryBo.setId(e.getId());
        creditHistoryBo.setIdSet(e.getIdSet());
        creditHistoryBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
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
