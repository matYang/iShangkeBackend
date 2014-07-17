package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.web.user.model.AccountHistoryVo;

public class AccountHistoryConverter {
    public static AccountHistoryBo fromModel(AccountHistoryVo e) {
        AccountHistoryBo accountHistoryBo = new AccountHistoryBo();
        return accountHistoryBo;
    }

    public static AccountHistoryVo toModel(AccountHistoryBo bo) {
        AccountHistoryVo accountHistoryVo = new AccountHistoryVo();
        return accountHistoryVo;
    }
}
