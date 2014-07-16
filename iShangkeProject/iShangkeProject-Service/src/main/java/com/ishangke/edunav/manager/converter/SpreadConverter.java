package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;

public class SpreadConverter {
    public static SpreadBo toBo(SpreadEntityExt e) {
        return new SpreadBo();
    }

    public static SpreadEntityExt fromBo(SpreadBo bo) {
        return new SpreadEntityExt();
    }
}
