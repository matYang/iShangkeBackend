package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.web.user.model.AccountVo;

public class AccountConverter {
    public static AccountBo fromModel(AccountVo e) {
        AccountBo accountBo = new AccountBo();
        return accountBo;
    }

    public static AccountVo toModel(AccountBo bo) {
        AccountVo accountVo = new AccountVo();
        return accountVo;
    }
}
