package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateClassPhotoBo;
import com.ishangke.edunav.web.user.model.CourseTemplateClassPhotoVo;

public class CourseTemplateClassPhotoConverter {
    public static CourseTemplateClassPhotoBo fromModel(CourseTemplateClassPhotoVo e) {
        CourseTemplateClassPhotoBo courseTemplateClassPhotoBo = new CourseTemplateClassPhofromModel();
        return courseTemplateClassPhotoBo;
    }

    public static CourseTemplateClassPhotoVo toModel(CourseTemplateClassPhotoBo bo) {
        CourseTemplateClassPhotoVo courseTemplateClassPhotoVo = new CourseTemplateClassPhotoVo();
        return courseTemplateClassPhotoVo;
    }
}
