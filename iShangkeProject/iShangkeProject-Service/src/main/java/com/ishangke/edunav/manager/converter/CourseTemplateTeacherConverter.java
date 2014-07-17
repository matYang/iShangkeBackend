package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateTeacherBo;
import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

public class CourseTemplateTeacherConverter {
    public static CourseTemplateTeacherBo toBo(CourseTemplateTeacherEntityExt e) {
        CourseTemplateTeacherBo courseTemplateTeacherBo = new CourseTemplateTeacherBo();
        return courseTemplateTeacherBo;
    }

    public static CourseTemplateTeacherEntityExt fromBo(CourseTemplateTeacherBo bo) {
        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
        return courseTemplateTeacherEntityExt;
    }
}
