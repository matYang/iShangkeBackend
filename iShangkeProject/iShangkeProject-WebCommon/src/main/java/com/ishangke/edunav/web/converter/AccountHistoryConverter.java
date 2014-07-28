package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.web.model.AccountHistoryVo;

public class AccountHistoryConverter {
    public static AccountHistoryBo fromModel(AccountHistoryVo vo) {
        if (vo == null) {
            return null;
        }
        AccountHistoryBo accountHistoryBo = new AccountHistoryBo();
        if (vo.getCharge() != null) {
            accountHistoryBo.setCharge(vo.getCharge());
        } else {
            accountHistoryBo.setCharge(Constant.DEFAULTNULL);
        }
        if (vo.getChargeEnd() != null) {
            accountHistoryBo.setChargeEnd(vo.getChargeEnd());
        } else {
            accountHistoryBo.setChargeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getChargeStart() != null) {
            accountHistoryBo.setChargeStart(vo.getChargeStart());
        } else {
            accountHistoryBo.setChargeStart(Constant.DEFAULTNULL);
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
        accountHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        accountHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        accountHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getCreateTimeStart().getTimeInMillis());
        return accountHistoryBo;
    }

    public static AccountHistoryVo toModel(AccountHistoryBo bo) {
        if (bo == null) {
            return null;
        }
        AccountHistoryVo accountHistoryVo = new AccountHistoryVo();
        if (Constant.DEFAULTNULL != bo.getCharge()) {
            accountHistoryVo.setCharge(bo.getCharge());
        }
        if (Constant.DEFAULTNULL != bo.getChargeEnd()) {
            accountHistoryVo.setChargeEnd(bo.getChargeEnd());
        }
        if (Constant.DEFAULTNULL != bo.getChargeStart()) {
            accountHistoryVo.setChargeStart(bo.getChargeStart());
        }
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
