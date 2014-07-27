package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.web.model.AccountVo;

public class AccountConverter {
    public static AccountBo fromModel(AccountVo vo) {
        if (vo == null) {
            return null;
        }
        AccountBo accountBo = new AccountBo();
        if (vo.getBalance() != null) {
            accountBo.setBalance(vo.getBalance());
        } else {
            accountBo.setBalance(Constant.DEFAULTNULL);
        }
        if (vo.getBalanceEnd() != null) {
            accountBo.setBalanceEnd(vo.getBalanceEnd());
        } else {
            accountBo.setBalanceEnd(Constant.DEFAULTNULL);
        }
        if (vo.getBalanceStart() != null) {
            accountBo.setBalanceStart(vo.getBalanceStart());
        } else {
            accountBo.setBalanceStart(Constant.DEFAULTNULL);
        }
        if (vo.getEnabled() != null) {
            accountBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            accountBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            accountBo.setIdSet(vo.getIdSet());
        }
        if (vo.getRealName() != null) {
            accountBo.setRealName(vo.getRealName());
        }
        if (vo.getAccountNumber() != null) {
            accountBo.setAccountNumber(vo.getAccountNumber());
        }
        accountBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        accountBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        accountBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart()
                .getTimeInMillis());
        accountBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime()
                .getTimeInMillis());
        accountBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        accountBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        return accountBo;
    }

    public static AccountVo toModel(AccountBo bo) {
        if (bo == null) {
            return null;
        }
        AccountVo accountVo = new AccountVo();
        if (Constant.DEFAULTNULL != bo.getBalance()) {
            accountVo.setBalance(bo.getBalance());
        }
        if (Constant.DEFAULTNULL != bo.getBalanceEnd()) {
            accountVo.setBalanceEnd(bo.getBalanceEnd());
        }
        if (Constant.DEFAULTNULL != bo.getBalanceStart()) {
            accountVo.setBalanceStart(bo.getBalanceStart());
        }
        accountVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        accountVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        accountVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        accountVo.setEnabled(bo.getEnabled());
        accountVo.setId(bo.getId());
        accountVo.setIdSet(bo.getIdSet());
        accountVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        accountVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        accountVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        accountVo.setRealName(bo.getRealName());
        accountVo.setAccountNumber(bo.getAccountNumber());
        return accountVo;
    }
}
