package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
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
        if (vo.getCreateTime() != null) {
            accountBo.setCreateTime(vo.getCreateTime());
        } else {
            accountBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            accountBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            accountBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            accountBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            accountBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            accountBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            accountBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            accountBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            accountBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            accountBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            accountBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
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
        accountVo.setEnabled(bo.getEnabled());
        accountVo.setId(bo.getId());
//        accountVo.setIdSet(bo.getIdSet());
        accountVo.setCreateTime(bo.getCreateTime());
//        accountVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        accountVo.setCreateTimeStart(bo.getCreateTimeStart());
        accountVo.setLastModifyTime(bo.getLastModifyTime());
//        accountVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        accountVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        accountVo.setRealName(bo.getRealName());
        accountVo.setAccountNumber(bo.getAccountNumber());
        return accountVo;
    }
}
