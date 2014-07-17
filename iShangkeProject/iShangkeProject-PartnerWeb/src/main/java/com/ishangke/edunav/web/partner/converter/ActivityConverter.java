package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;

public class ActivityConverter {
    public static ActivityBo toBo(ActivityEntityExt e) {
        ActivityBo activityBo = new ActivityBo();
        return activityBo;
    }

    public static ActivityEntityExt fromBo(ActivityBo bo) {
        ActivityEntityExt activityEntityExt = new ActivityEntityExt();
        return activityEntityExt;
    }
}
