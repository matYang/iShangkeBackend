package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

public class CreditHistoryConverter {
    public static CreditHistoryBo toBo(CreditHistoryEntityExt e) {
        CreditHistoryBo creditHistoryBo = new CreditHistoryBo();
        if (e.getCharge() != null) {
            creditHistoryBo.setCharge(e.getCharge());
        }
        if (e.getChargeEnd() != null) {
            creditHistoryBo.setChargeEnd(e.getChargeEnd());
        }
        if (e.getChargeStart() != null) {
            creditHistoryBo.setChargeStart(e.getChargeStart());
        }
        if (e.getId() != null) {
            creditHistoryBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            creditHistoryBo.setIdSet(e.getIdSet());
        }
        if (e.getUserId() != null) {
            creditHistoryBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            creditHistoryBo.setUserIdSet(e.getUserIdSet());
        }
        creditHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        creditHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        creditHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        creditHistoryBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
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
