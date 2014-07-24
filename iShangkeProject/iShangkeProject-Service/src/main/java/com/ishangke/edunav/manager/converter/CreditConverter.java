package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

public class CreditConverter {
    public static CreditBo toBo(CreditEntityExt e) {
        CreditBo creditBo = new CreditBo();
        if (e.getCredit() != null) {
            creditBo.setCredit(e.getCredit());
        }
        if (e.getCreditEnd() != null) {
            creditBo.setCreditEnd(e.getCreditEnd());
        }
        if (e.getCreditStart() != null) {
            creditBo.setCreditStart(e.getCreditStart());
        }
        if (e.getEnabled() != null) {
            creditBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            creditBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            creditBo.setIdSet(e.getIdSet());
        }
        creditBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        creditBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        creditBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        creditBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        creditBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        creditBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        return creditBo;
    }

    public static CreditEntityExt fromBo(CreditBo bo) {
        CreditEntityExt creditEntityExt = new CreditEntityExt();
        creditEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        creditEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        creditEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        creditEntityExt.setCredit(bo.getCredit());
        creditEntityExt.setCreditEnd(bo.getCreditEnd());
        creditEntityExt.setCreditStart(bo.getCreditStart());
        creditEntityExt.setEnabled(bo.getEnabled());
        creditEntityExt.setId(bo.getId());
        creditEntityExt.setIdSet(bo.getIdSet());
        creditEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        creditEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        creditEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        return creditEntityExt;
    }
}
