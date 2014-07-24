package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;

public class AccountHistoryConverter {
    public static AccountHistoryBo toBo(AccountHistoryEntityExt e) {
        AccountHistoryBo accountHistoryBo = new AccountHistoryBo();
        if (e.getCharge() != null) {
            accountHistoryBo.setCharge(e.getCharge());
        }
        if (e.getChargeEnd() != null) {
            accountHistoryBo.setChargeEnd(e.getChargeEnd());
        }
        if (e.getChargeStart() != null) {
            accountHistoryBo.setChargeStart(e.getChargeStart());
        }
        if (e.getId() != null) {
            accountHistoryBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            accountHistoryBo.setIdSet(e.getIdSet());
        }
        if (e.getRemark() != null) {
            accountHistoryBo.setRemark(e.getRemark());
        }
        if (e.getType() != null) {
            accountHistoryBo.setType(e.getType());
        }
        if (e.getTypeSet() != null) {
            accountHistoryBo.setTypeSet(e.getTypeSet());
        }
        if (e.getUserId() != null) {
            accountHistoryBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            accountHistoryBo.setUserIdSet(e.getUserIdSet());
        }
        if (e.getWithdrawId() != null) {
            accountHistoryBo.setWithdrawId(e.getWithdrawId());
        }
        if (e.getWithdrawIdSet() != null) {
            accountHistoryBo.setWithdrawIdSet(e.getWithdrawIdSet());
        }
        accountHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        accountHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        accountHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        return accountHistoryBo;
    }

    public static AccountHistoryEntityExt fromBo(AccountHistoryBo bo) {
        AccountHistoryEntityExt accountHistoryEntityExt = new AccountHistoryEntityExt();
        accountHistoryEntityExt.setCharge(bo.getCharge());
        accountHistoryEntityExt.setChargeEnd(bo.getChargeEnd());
        accountHistoryEntityExt.setChargeStart(bo.getChargeStart());
        accountHistoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        accountHistoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        accountHistoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        accountHistoryEntityExt.setId(bo.getId());
        accountHistoryEntityExt.setIdSet(bo.getIdSet());
        accountHistoryEntityExt.setRemark(bo.getRemark());
        accountHistoryEntityExt.setType(bo.getType());
        accountHistoryEntityExt.setTypeSet(bo.getTypeSet());
        accountHistoryEntityExt.setUserId(bo.getUserId());
        accountHistoryEntityExt.setUserIdSet(bo.getUserIdSet());
        accountHistoryEntityExt.setWithdrawId(bo.getWithdrawId());
        accountHistoryEntityExt.setWithdrawIdSet(bo.getWithdrawIdSet());
        return accountHistoryEntityExt;
    }
}
