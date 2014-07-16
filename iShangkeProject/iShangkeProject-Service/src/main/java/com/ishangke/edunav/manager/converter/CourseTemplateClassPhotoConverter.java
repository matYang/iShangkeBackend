package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;

public class CourseTemplateClassPhotoConverter {
    public static CourseTemplateClassPhotoBo toBo(CourseTemplateClassPhotoEntityExt e) {
        CourseTemplateClassPhotoBo courseTemplateClassPhotoBo = new CourseTemplateClassPhotoBo();
        return courseTemplateClassPhotoBo;
    }

    public static CourseTemplateClassPhotoEntityExt fromBo(CourseTemplateClassPhotoBo bo) {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        return courseTemplateClassPhotoEntityExt;
    }
}
