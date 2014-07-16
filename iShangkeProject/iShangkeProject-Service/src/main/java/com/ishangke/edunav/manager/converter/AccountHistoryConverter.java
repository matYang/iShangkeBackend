package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;

public class AccountHistoryConverter {
    public static AccountHistoryBo toBo(AccountHistoryEntityExt e) {
        return new AccountHistoryBo();
    }

    public static AccountHistoryEntityExt fromBo(AccountHistoryBo bo) {
        return new AccountHistoryEntityExt();
    }
}
