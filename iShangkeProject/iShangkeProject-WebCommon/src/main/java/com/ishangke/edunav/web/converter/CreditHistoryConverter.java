package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
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
        creditHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        creditHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        creditHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getCreateTimeStart().getTimeInMillis());
        creditHistoryBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTime().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
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
        creditHistoryVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        creditHistoryVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        creditHistoryVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        creditHistoryVo.setId(bo.getId());
        creditHistoryVo.setIdSet(bo.getIdSet());
        creditHistoryVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        creditHistoryVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        creditHistoryVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        creditHistoryVo.setUserId(bo.getUserId());
        creditHistoryVo.setUserIdSet(bo.getUserIdSet());
        return creditHistoryVo;
    }
}
