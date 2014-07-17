package com.ishangke.edunav.web.admin.converter;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

public class CourseConverter {
    public static CourseBo toBo(CourseEntityExt e) {
        CourseBo courseBo = new CourseBo();
        return courseBo;
    }

    public static CourseEntityExt fromBo(CourseBo bo) {
        CourseEntityExt courseEntityExt = new CourseEntityExt();
        return courseEntityExt;
    }
}
