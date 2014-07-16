package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;

public class ActivityConverter {
    public static ActivityBo toBo(ActivityEntityExt e) {
        return new ActivityBo();
    }

    public static ActivityEntityExt fromBo(ActivityBo bo) {
        return new ActivityEntityExt();
    }
}
