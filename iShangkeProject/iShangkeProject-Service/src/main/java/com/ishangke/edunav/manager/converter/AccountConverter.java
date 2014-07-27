package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;

public class AccountConverter {
    public static AccountBo toBo(AccountEntityExt e) {
        if (e == null) {
            return null;
        }
        AccountBo accountBo = new AccountBo();
        if (e.getBalance() != null) {
            accountBo.setBalance(e.getBalance());
        } else {
            accountBo.setBalance(Constant.DEFAULTNULL);
        }
        if (e.getBalanceEnd() != null) {
            accountBo.setBalanceEnd(e.getBalanceEnd());
        } else {
            accountBo.setBalanceEnd(Constant.DEFAULTNULL);
        }
        if (e.getBalanceStart() != null) {
            accountBo.setBalanceStart(e.getBalanceStart());
        } else {
            accountBo.setBalanceStart(Constant.DEFAULTNULL);
        }
        if (e.getEnabled() != null) {
            accountBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            accountBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            accountBo.setIdSet(e.getIdSet());
        }
        if (e.getRealName() != null) {
            accountBo.setRealName(e.getRealName());
        }
        if (e.getAccountNumber() != null) {
            accountBo.setAccountNumber(e.getAccountNumber());
        }
        accountBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        accountBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        accountBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        accountBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        accountBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        accountBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return accountBo;
    }

    public static AccountEntityExt fromBo(AccountBo bo) {
        if (bo == null) {
            return null;
        }
        AccountEntityExt accountEntityExt = new AccountEntityExt();
        if (bo.getBalance() != Constant.DEFAULTNULL) {
            accountEntityExt.setBalance(bo.getBalance());
        }
        if (bo.getBalanceEnd() != Constant.DEFAULTNULL) {
            accountEntityExt.setBalanceEnd(bo.getBalanceEnd());
        }
        if (bo.getBalanceStart() != Constant.DEFAULTNULL) {
            accountEntityExt.setBalanceStart(bo.getBalanceStart());
        }
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
        accountEntityExt.setAccountNumber(bo.getAccountNumber());
        return accountEntityExt;
    }
}
