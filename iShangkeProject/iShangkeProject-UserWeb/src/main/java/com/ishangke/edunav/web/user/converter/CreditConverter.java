package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.web.user.model.CreditVo;

public class CreditConverter {
    public static CreditBo fromModel(CreditVo e) {
        CreditBo creditBo = new CreditBo();
        return creditBo;
    }

    public static CreditVo toModel(CreditBo bo) {
        CreditVo creditVo = new CreditVo();
        return creditVo;
    }
}
