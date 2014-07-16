package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;

public class CourseTemplateConverter {
    public static CourseTemplateBo toBo(CourseTemplateEntityExt e) {
        return new CourseTemplateBo();
    }

    public static CourseTemplateEntityExt fromBo(CourseTemplateBo bo) {
        return new CourseTemplateEntityExt();
    }
}
