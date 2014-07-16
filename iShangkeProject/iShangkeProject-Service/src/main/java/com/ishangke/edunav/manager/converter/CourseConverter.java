package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

public class CourseConverter {
    public static CourseBo toBo(CourseEntityExt e) {
        return new CourseBo();
    }

    public static CourseEntityExt fromBo(CourseBo bo) {
        return new CourseEntityExt();
    }
}
