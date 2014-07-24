package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;

public class AccountHistoryConverter {
    public static AccountHistoryBo toBo(AccountHistoryEntityExt e) {
        AccountHistoryBo accountHistoryBo = new AccountHistoryBo();
        accountHistoryBo.setCharge(e.getCharge());
        accountHistoryBo.setChargeEnd(e.getChargeEnd());
        accountHistoryBo.setChargeStart(e.getChargeStart());
        accountHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        accountHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        accountHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        accountHistoryBo.setId(e.getId());
        accountHistoryBo.setIdSet(e.getIdSet());
        accountHistoryBo.setRemark(e.getRemark());
        accountHistoryBo.setType(e.getType());
        accountHistoryBo.setTypeSet(e.getTypeSet());
        accountHistoryBo.setUserId(e.getUserId());
        accountHistoryBo.setUserIdSet(e.getUserIdSet());
        accountHistoryBo.setWithdrawId(e.getWithdrawId());
        accountHistoryBo.setWithdrawIdSet(e.getWithdrawIdSet());
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
