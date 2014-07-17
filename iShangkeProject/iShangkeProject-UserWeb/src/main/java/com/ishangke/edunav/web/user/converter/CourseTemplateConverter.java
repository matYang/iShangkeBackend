package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.web.user.model.CourseTemplateVo;

public class CourseTemplateConverter {
    public static CourseTemplateBo fromModel(CourseTemplateVo e) {
        CourseTemplateBo courseTemplateBo = new CourseTemplateBo();
        return courseTemplateBo;
    }

    public static CourseTemplateVo toModel(CourseTemplateBo bo) {
        CourseTemplateVo courseTemplateVo = new CourseTemplateVo();
        return courseTemplateVo;
    }
}
