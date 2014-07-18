package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class CreditConverter {
    public static CreditBo toBo(CreditEntityExt e) {
        CreditBo creditBo = new CreditBo();
        creditBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        creditBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        creditBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        creditBo.setCredit(e.getCredit());
        creditBo.setCreditEnd(e.getCreditEnd());
        creditBo.setCreditStart(e.getCreditStart());
        creditBo.setEnabled(e.getEnabled());
        creditBo.setId(e.getId());
        creditBo.setIdSet(e.getIdSet());
        creditBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        creditBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        creditBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
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
