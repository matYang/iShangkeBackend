package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.web.model.AccountHistoryVo;

public class AccountHistoryConverter {
    public static AccountHistoryBo fromModel(AccountHistoryVo vo) {
        AccountHistoryBo accountHistoryBo = new AccountHistoryBo();
        if (vo.getCharge() != null) {
            accountHistoryBo.setCharge(vo.getCharge());
        }
        if (vo.getChargeEnd() != null) {
            accountHistoryBo.setChargeEnd(vo.getChargeEnd());
        }
        if (vo.getChargeStart() != null) {
            accountHistoryBo.setChargeStart(vo.getChargeStart());
        }
        if (vo.getId() != null) {
            accountHistoryBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            accountHistoryBo.setIdSet(vo.getIdSet());
        }
        if (vo.getRemark() != null) {
            accountHistoryBo.setRemark(vo.getRemark());
        }
        if (vo.getType() != null) {
            accountHistoryBo.setType(vo.getType());
        } else {
            accountHistoryBo.setType(Constant.DEFAULTNULL);
        }
        if (vo.getTypeSet() != null) {
            accountHistoryBo.setTypeSet(vo.getTypeSet());
        }
        if (vo.getUserId() != null) {
            accountHistoryBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            accountHistoryBo.setUserIdSet(vo.getUserIdSet());
        }
        if (vo.getWithdrawId() != null) {
            accountHistoryBo.setWithdrawId(vo.getWithdrawId());
        }
        if (vo.getWithdrawIdSet() != null) {
            accountHistoryBo.setWithdrawIdSet(vo.getWithdrawIdSet());
        }
        accountHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        accountHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        accountHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
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
        if (Constant.DEFAULTNULL != bo.getType()) {
            accountHistoryVo.setType(bo.getType());
        }
        accountHistoryVo.setTypeSet(bo.getTypeSet());
        accountHistoryVo.setUserId(bo.getUserId());
        accountHistoryVo.setUserIdSet(bo.getUserIdSet());
        accountHistoryVo.setWithdrawId(bo.getWithdrawId());
        accountHistoryVo.setWithdrawIdSet(bo.getWithdrawIdSet());
        return accountHistoryVo;
    }
}
