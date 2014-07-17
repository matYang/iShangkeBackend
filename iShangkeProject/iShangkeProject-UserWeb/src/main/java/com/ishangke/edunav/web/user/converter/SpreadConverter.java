package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.web.user.model.SpreadVo;

public class SpreadConverter {
    public static SpreadBo fromModel(SpreadVo e) {
        SpreadBo spreadBo =new SpreadBo();
        return spreadBo;
    }

    public static SpreadVo toModel(SpreadBo bo) {
        SpreadVo spreadVo =new SpreadVo();
        return spreadVo;
    }
}
