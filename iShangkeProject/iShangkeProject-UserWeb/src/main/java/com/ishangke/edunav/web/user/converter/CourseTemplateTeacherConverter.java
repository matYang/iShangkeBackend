package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateTeacherBo;
import com.ishangke.edunav.web.user.model.CourseTemplateTeacherVo;

public class CourseTemplateTeacherConverter {
    public static CourseTemplateTeacherBo fromModel(CourseTemplateTeacherVo e) {
        CourseTemplateTeacherBo courseTemplateTeacherBo = new CourseTemplateTeacherBo();
        return courseTemplateTeacherBo;
    }

    public static CourseTemplateTeacherVo toModel(CourseTemplateTeacherBo bo) {
        CourseTemplateTeacherVo courseTemplateTeacherVo = new CourseTemplateTeacherVo();
        return courseTemplateTeacherVo;
    }
}
