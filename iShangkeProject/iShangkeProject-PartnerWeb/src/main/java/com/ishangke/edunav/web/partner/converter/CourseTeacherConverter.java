package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

public class CourseTeacherConverter {
    public static CourseTeacherBo toBo(CourseTeacherEntityExt e) {
        CourseTeacherBo courseTeacherBo = new CourseTeacherBo();
        return courseTeacherBo;
    }

    public static CourseTeacherEntityExt fromBo(CourseTeacherBo bo) {
        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
        return courseTeacherEntityExt;
    }
}
