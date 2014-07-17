package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.web.user.model.CourseTeacherVo;

public class CourseTeacherConverter {
    public static CourseTeacherBo fromModel(CourseTeacherVo e) {
        CourseTeacherBo courseTeacherBo = new CourseTeacherBo();
        return courseTeacherBo;
    }

    public static CourseTeacherVo toModel(CourseTeacherBo bo) {
        CourseTeacherVo courseTeacherVo = new CourseTeacherVo();
        return courseTeacherVo;
    }
}
