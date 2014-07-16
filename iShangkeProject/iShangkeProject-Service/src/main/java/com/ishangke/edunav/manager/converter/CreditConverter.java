package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

public class CreditConverter {
    public static CreditBo toBo(CreditEntityExt e) {
        return new CreditBo();
    }

    public static CreditEntityExt fromBo(CreditBo bo) {
        return new CreditEntityExt();
    }
}
