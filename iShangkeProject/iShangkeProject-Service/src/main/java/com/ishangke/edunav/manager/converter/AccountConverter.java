package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;

public class AccountConverter {
    public static AccountBo toBo(AccountEntityExt e) {
        return new AccountBo();
    }

    public static AccountEntityExt fromBo(AccountBo bo) {
        return new AccountEntityExt();
    }
}
