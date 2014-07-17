package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

public class CreditHistoryConverter {
    public static CreditHistoryBo toBo(CreditHistoryEntityExt e) {
        CreditHistoryBo CreditHistoryBo = new CreditHistoryBo();
        return CreditHistoryBo;
    }

    public static CreditHistoryEntityExt fromBo(CreditHistoryBo bo) {
        CreditHistoryEntityExt CreditHistoryEntityExt = new CreditHistoryEntityExt();
        return CreditHistoryEntityExt;
    }
}
