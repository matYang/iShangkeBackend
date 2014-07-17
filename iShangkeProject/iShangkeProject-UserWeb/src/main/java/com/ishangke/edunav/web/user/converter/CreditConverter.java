package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

public class CreditConverter {
    public static CreditBo toBo(CreditEntityExt e) {
        CreditBo creditBo = new CreditBo();
        return creditBo;
    }

    public static CreditEntityExt fromBo(CreditBo bo) {
        CreditEntityExt creditEntityExt = new CreditEntityExt();
        return creditEntityExt;
    }
}
