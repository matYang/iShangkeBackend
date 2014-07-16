package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

public class CourseTeacherConverter {
    public static CourseTeacherBo toBo(CourseTeacherEntityExt e) {
        return new CourseTeacherBo();
    }

    public static CourseTeacherEntityExt fromBo(CourseTeacherBo bo) {
        return new CourseTeacherEntityExt();
    }
}
