package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.web.user.model.ActivityVo;

public class ActivityConverter {
    public static ActivityBo fromModel(ActivityVo e) {
        ActivityBo activityBo = new ActivityBo();
        return activityBo;
    }

    public static ActivityVo toModel(ActivityBo bo) {
        ActivityVo activityVo = new ActivityVo();
        return activityVo;
    }
}
