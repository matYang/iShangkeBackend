package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.web.model.CreditHistoryVo;

public class CreditHistoryConverter {
    public static CreditHistoryBo fromModel(CreditHistoryVo vo) {
        CreditHistoryBo creditHistoryBo = new CreditHistoryBo();
        creditHistoryBo.setCharge(vo.getCharge());
        creditHistoryBo.setChargeEnd(vo.getChargeEnd());
        creditHistoryBo.setChargeStart(vo.getChargeStart());
        creditHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        creditHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        creditHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        creditHistoryBo.setId(vo.getId());
        creditHistoryBo.setIdSet(vo.getIdSet());
        creditHistoryBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        creditHistoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        creditHistoryBo.setUserId(vo.getUserId());
        creditHistoryBo.setUserIdSet(vo.getUserIdSet());
        return creditHistoryBo;
    }

    public static CreditHistoryVo toModel(CreditHistoryBo bo) {
        CreditHistoryVo creditHistoryVo = new CreditHistoryVo();
        creditHistoryVo.setCharge(bo.getCharge());
        creditHistoryVo.setChargeEnd(bo.getChargeEnd());
        creditHistoryVo.setChargeStart(bo.getChargeStart());
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
