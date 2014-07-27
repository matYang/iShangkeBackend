package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.web.model.CreditVo;

public class CreditConverter {
    public static CreditBo fromModel(CreditVo vo) {
        if (vo == null) {
            return null;
        }
        CreditBo creditBo = new CreditBo();
        if (vo.getCredit() != null) {
            creditBo.setCredit(vo.getCredit());
        } else {
            creditBo.setCredit(Constant.DEFAULTNULL);
        }
        if (vo.getCreditEnd() != null) {
            creditBo.setCreditEnd(vo.getCreditEnd());
        } else {
            creditBo.setCreditEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreditStart() != null) {
            creditBo.setCreditStart(vo.getCreditStart());
        } else {
            creditBo.setCreditStart(Constant.DEFAULTNULL);
        }
        if (vo.getEnabled() != null) {
            creditBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            creditBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            creditBo.setIdSet(vo.getIdSet());
        }
        creditBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        creditBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        creditBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart()
                .getTimeInMillis());
        creditBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime()
                .getTimeInMillis());
        creditBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        creditBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        return creditBo;
    }

    public static CreditVo toModel(CreditBo bo) {

        if (bo == null) {
            return null;
        }
        CreditVo creditVo = new CreditVo();
        creditVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        creditVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        creditVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        if (Constant.DEFAULTNULL != bo.getCredit()) {
            creditVo.setCredit(bo.getCredit());
        }
        if (Constant.DEFAULTNULL != bo.getCreditEnd()) {
            creditVo.setCreditEnd(bo.getCreditEnd());
        }
        if (Constant.DEFAULTNULL != bo.getCreditStart()) {
            creditVo.setCreditStart(bo.getCreditStart());
        }
        creditVo.setEnabled(bo.getEnabled());
        creditVo.setId(bo.getId());
        creditVo.setIdSet(bo.getIdSet());
        creditVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        creditVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        creditVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        return creditVo;
    }
}
