package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;

public class CourseCommentConverter {
    public static CourseCommentBo toBo(CourseCommentEntityExt e) {
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        return courseCommentBo;
    }

    public static CourseCommentEntityExt fromBo(CourseCommentBo bo) {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        return courseCommentEntityExt;
    }
}
