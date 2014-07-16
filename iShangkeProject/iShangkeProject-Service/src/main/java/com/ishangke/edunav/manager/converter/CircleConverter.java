package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

public class CircleConverter {
    public static CircleBo toBo(CircleEntityExt e) {
        CircleBo circleBo = new CircleBo();
        return circleBo;
    }

    public static CircleEntityExt fromBo(CircleBo bo) {
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        return circleEntityExt;
    }
}
