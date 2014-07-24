package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.web.model.AccountHistoryVo;

public class AccountHistoryConverter {
    public static AccountHistoryBo fromModel(AccountHistoryVo vo) {
        AccountHistoryBo accountHistoryBo = new AccountHistoryBo();
        accountHistoryBo.setCharge(vo.getCharge());
        accountHistoryBo.setChargeEnd(vo.getChargeEnd());
        accountHistoryBo.setChargeStart(vo.getChargeStart());
        accountHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        accountHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        accountHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        accountHistoryBo.setId(vo.getId());
        accountHistoryBo.setIdSet(vo.getIdSet());
        accountHistoryBo.setRemark(vo.getRemark());
        accountHistoryBo.setType(vo.getType());
        accountHistoryBo.setTypeSet(vo.getTypeSet());
        accountHistoryBo.setUserId(vo.getUserId());
        accountHistoryBo.setUserIdSet(vo.getUserIdSet());
        accountHistoryBo.setWithdrawId(vo.getWithdrawId());
        accountHistoryBo.setWithdrawIdSet(vo.getWithdrawIdSet());
        return accountHistoryBo;
    }

    public static AccountHistoryVo toModel(AccountHistoryBo bo) {
        AccountHistoryVo accountHistoryVo = new AccountHistoryVo();
        accountHistoryVo.setCharge(bo.getCharge());
        accountHistoryVo.setChargeEnd(bo.getChargeEnd());
        accountHistoryVo.setChargeStart(bo.getChargeStart());
        accountHistoryVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        accountHistoryVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        accountHistoryVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        accountHistoryVo.setId(bo.getId());
        accountHistoryVo.setIdSet(bo.getIdSet());
        accountHistoryVo.setRemark(bo.getRemark());
        accountHistoryVo.setType(bo.getType());
        accountHistoryVo.setTypeSet(bo.getTypeSet());
        accountHistoryVo.setUserId(bo.getUserId());
        accountHistoryVo.setUserIdSet(bo.getUserIdSet());
        accountHistoryVo.setWithdrawId(bo.getWithdrawId());
        accountHistoryVo.setWithdrawIdSet(bo.getWithdrawIdSet());
        return accountHistoryVo;
    }
}
