package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;

public class SpreadConverter {
    public static SpreadBo toBo(SpreadEntityExt e) {
        SpreadBo spreadBo =new SpreadBo();
        return spreadBo;
    }

    public static SpreadEntityExt fromBo(SpreadBo bo) {
        SpreadEntityExt spreadEntityExt =new SpreadEntityExt();
        return spreadEntityExt;
    }
}
