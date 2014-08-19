package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
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
        if (vo.getCreateTime() != null) {
            creditBo.setCreateTime(vo.getCreateTime());
        } else {
            creditBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            creditBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            creditBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            creditBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            creditBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            creditBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            creditBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            creditBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            creditBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            creditBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            creditBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return creditBo;
    }

    public static CreditVo toModel(CreditBo bo) {

        if (bo == null) {
            return null;
        }
        CreditVo creditVo = new CreditVo();
        creditVo.setCreateTime(bo.getCreateTime());
//        creditVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        creditVo.setCreateTimeStart(bo.getCreateTimeStart());
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
//        creditVo.setIdSet(bo.getIdSet());
        creditVo.setLastModifyTime(bo.getLastModifyTime());
//        creditVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        creditVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        return creditVo;
    }
}
