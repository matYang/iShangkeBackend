package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.web.common.DateUtility;
import com.ishangke.edunav.web.model.AccountVo;

public class AccountConverter {
    public static AccountBo fromModel(AccountVo vo) {
        AccountBo accountBo = new AccountBo();
        accountBo.setBalance(vo.getBalance());
        accountBo.setBalanceEnd(vo.getBalanceEnd());
        accountBo.setBalanceStart(vo.getBalanceStart());
        accountBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        accountBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        accountBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        accountBo.setEnabled(vo.getEnabled());
        accountBo.setId(vo.getId());
        accountBo.setIdSet(vo.getIdSet());
        accountBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        accountBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        accountBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        accountBo.setRealName(vo.getRealName());
        return accountBo;
    }

    public static AccountVo toModel(AccountBo bo) {
        AccountVo accountVo = new AccountVo();
        accountVo.setBalance(bo.getBalance());
        accountVo.setBalanceEnd(bo.getBalanceEnd());
        accountVo.setBalanceStart(bo.getBalanceStart());
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
        return accountVo;
    }
}
