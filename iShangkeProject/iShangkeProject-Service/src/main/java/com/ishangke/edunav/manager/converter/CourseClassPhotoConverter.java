package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;

public class CourseClassPhotoConverter {
    public static CourseClassPhotoBo toBo(CourseClassPhotoEntityExt e) {
        return new CourseClassPhotoBo();
    }

    public static CourseClassPhotoEntityExt fromBo(CourseClassPhotoBo bo) {
        return new CourseClassPhotoEntityExt();
    }
}
