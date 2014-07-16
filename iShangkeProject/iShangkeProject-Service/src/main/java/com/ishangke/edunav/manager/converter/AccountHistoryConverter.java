package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;

public class AccountHistoryConverter {
    public static AccountHistoryBo toBo(AccountHistoryEntityExt e) {
        AccountHistoryBo accountHistoryBo = new AccountHistoryBo();
        return accountHistoryBo;
    }

    public static AccountHistoryEntityExt fromBo(AccountHistoryBo bo) {
        AccountHistoryEntityExt accountHistoryEntityExt = new AccountHistoryEntityExt();
        return accountHistoryEntityExt;
    }
}
