package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;

public class CourseTemplateConverter {
    public static CourseTemplateBo toBo(CourseTemplateEntityExt e) {
        CourseTemplateBo courseTemplateBo = new CourseTemplateBo();
        return courseTemplateBo;
    }

    public static CourseTemplateEntityExt fromBo(CourseTemplateBo bo) {
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
        return courseTemplateEntityExt;
    }
}
