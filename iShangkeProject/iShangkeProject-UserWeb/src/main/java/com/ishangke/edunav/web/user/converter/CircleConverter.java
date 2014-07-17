package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.web.user.model.CircleVo;

public class CircleConverter {
    public static CircleBo fromModel(CircleVo e) {
        CircleBo circleBo = new CircleBo();
        return circleBo;
    }

    public static CircleVo toModel(CircleBo bo) {
        CircleVo circleVo = new CircleVo();
        return circleVo;
    }
}
