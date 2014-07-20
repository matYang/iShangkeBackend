package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class AccountConverter {
    public static AccountBo toBo(AccountEntityExt e) {
        AccountBo accountBo = new AccountBo();
        accountBo.setBalance(e.getBalance());
        accountBo.setBalanceEnd(e.getBalanceEnd());
        accountBo.setBalanceStart(e.getBalanceStart());
        accountBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        accountBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        accountBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        accountBo.setEnabled(e.getEnabled());
        accountBo.setId(e.getId());
        accountBo.setIdSet(e.getIdSet());
        accountBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        accountBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        accountBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        accountBo.setRealName(e.getRealName());
        return accountBo;
    }

    public static AccountEntityExt fromBo(AccountBo bo) {
        AccountEntityExt accountEntityExt = new AccountEntityExt();
        accountEntityExt.setBalance(bo.getBalance());
        accountEntityExt.setBalanceEnd(bo.getBalanceEnd());
        accountEntityExt.setBalanceStart(bo.getBalanceStart());
        accountEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        accountEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        accountEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        accountEntityExt.setEnabled(bo.getEnabled());
        accountEntityExt.setId(bo.getId());
        accountEntityExt.setIdSet(bo.getIdSet());
        accountEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        accountEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        accountEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        accountEntityExt.setRealName(bo.getRealName());        
        return accountEntityExt;
    }
}
