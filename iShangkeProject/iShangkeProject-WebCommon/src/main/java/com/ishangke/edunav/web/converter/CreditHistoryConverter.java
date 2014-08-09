package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.web.model.CreditHistoryVo;

public class CreditHistoryConverter {
    public static CreditHistoryBo fromModel(CreditHistoryVo vo) {
        if (vo == null) {
            return null;
        }
        CreditHistoryBo creditHistoryBo = new CreditHistoryBo();
        if (vo.getCharge() != null) {
            creditHistoryBo.setCharge(vo.getCharge());
        } else {
            creditHistoryBo.setCharge(Constant.DEFAULTNULL);
        }

        if (vo.getChargeEnd() != null) {
            creditHistoryBo.setChargeEnd(vo.getChargeEnd());
        } else {
            creditHistoryBo.setChargeEnd(Constant.DEFAULTNULL);
        }

        if (vo.getChargeStart() != null) {
            creditHistoryBo.setChargeStart(vo.getChargeStart());
        } else {
            creditHistoryBo.setChargeStart(Constant.DEFAULTNULL);
        }

        if (vo.getId() != null) {
            creditHistoryBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            creditHistoryBo.setIdSet(vo.getIdSet());
        }
        if (vo.getUserId() != null) {
            creditHistoryBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            creditHistoryBo.setUserIdSet(vo.getUserIdSet());
        }
        if (vo.getCreateTime() != null) {
            creditHistoryBo.setCreateTime(vo.getCreateTime());
        } else {
            creditHistoryBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            creditHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            creditHistoryBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            creditHistoryBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            creditHistoryBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            creditHistoryBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            creditHistoryBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            creditHistoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            creditHistoryBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            creditHistoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            creditHistoryBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }

        if (vo.getOperation() != null) {
            creditHistoryBo.setOperation(vo.getOperation());
        } else {
            creditHistoryBo.setOperation(Constant.DEFAULTNULL);
        }
        if (vo.getOperationSet() != null) {
            creditHistoryBo.setOperationSet(vo.getOperationSet());
        }

        return creditHistoryBo;
    }

    public static CreditHistoryVo toModel(CreditHistoryBo bo) {

        if (bo == null) {
            return null;
        }
        CreditHistoryVo creditHistoryVo = new CreditHistoryVo();
        if (Constant.DEFAULTNULL != bo.getCharge()) {
            creditHistoryVo.setCharge(bo.getCharge());
        }
        if (Constant.DEFAULTNULL != bo.getChargeEnd()) {
            creditHistoryVo.setChargeEnd(bo.getChargeEnd());
        }
        if (Constant.DEFAULTNULL != bo.getChargeStart()) {
            creditHistoryVo.setChargeStart(bo.getChargeStart());
        }
        creditHistoryVo.setCreateTime(bo.getCreateTime());
        creditHistoryVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        creditHistoryVo.setCreateTimeStart(bo.getCreateTimeStart());
        creditHistoryVo.setId(bo.getId());
        creditHistoryVo.setIdSet(bo.getIdSet());
        creditHistoryVo.setLastModifyTime(bo.getLastModifyTime());
        creditHistoryVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        creditHistoryVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        creditHistoryVo.setUserId(bo.getUserId());
        creditHistoryVo.setUserIdSet(bo.getUserIdSet());

        if (Constant.DEFAULTNULL != bo.getOperation()) {
            creditHistoryVo.setOperation(bo.getOperation());
        }
        creditHistoryVo.setOperationSet(bo.getOperationSet());

        return creditHistoryVo;
    }
}
