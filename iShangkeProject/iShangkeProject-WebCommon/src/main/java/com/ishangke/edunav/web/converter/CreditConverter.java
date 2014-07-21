package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.web.model.CreditVo;
import com.ishangke.edunav.web.common.DateUtility;

public class CreditConverter {
    public static CreditBo fromModel(CreditVo vo) {
        CreditBo creditBo = new CreditBo();
        creditBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        creditBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        creditBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        creditBo.setCredit(vo.getCredit());
        creditBo.setCreditEnd(vo.getCreditEnd());
        creditBo.setCreditStart(vo.getCreditStart());
        creditBo.setEnabled(vo.getEnabled());
        creditBo.setId(vo.getId());
        creditBo.setIdSet(vo.getIdSet());
        creditBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        creditBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        creditBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        return creditBo;
    }

    public static CreditVo toModel(CreditBo bo) {
        CreditVo creditVo = new CreditVo();
        creditVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        creditVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        creditVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        creditVo.setCredit(bo.getCredit());
        creditVo.setCreditEnd(bo.getCreditEnd());
        creditVo.setCreditStart(bo.getCreditStart());
        creditVo.setEnabled(bo.getEnabled());
        creditVo.setId(bo.getId());
        creditVo.setIdSet(bo.getIdSet());
        creditVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        creditVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        creditVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        return creditVo;
    }
}
