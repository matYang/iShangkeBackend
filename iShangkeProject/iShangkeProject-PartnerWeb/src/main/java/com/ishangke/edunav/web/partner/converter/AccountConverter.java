package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;

public class AccountConverter {
    public static AccountBo toBo(AccountEntityExt e) {
        AccountBo accountBo = new AccountBo();
        return accountBo;
    }

    public static AccountEntityExt fromBo(AccountBo bo) {
        AccountEntityExt accountEntityExt = new AccountEntityExt();
        return accountEntityExt;
    }
}
