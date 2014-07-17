package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CourseClassPhotoBo;
import com.ishangke.edunav.web.user.model.CourseClassPhotoVo;

public class CourseClassPhotoConverter {
    public static CourseClassPhotoBo fromModel(CourseClassPhotoVo e) {
        CourseClassPhotoBo courseClassPhotoBo = new CourseClassPhofromModel();
        return courseClassPhotoBo;
    }

    public static CourseClassPhotoVo toModel(CourseClassPhotoBo bo) {
        CourseClassPhotoVo courseClassPhotoVo = new CourseClassPhotoVo();
        return courseClassPhotoVo;
    }
}
