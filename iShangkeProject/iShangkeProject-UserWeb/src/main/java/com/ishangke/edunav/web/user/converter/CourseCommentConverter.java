package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.web.user.model.CourseCommentVo;

public class CourseCommentConverter {
    public static CourseCommentBo fromModel(CourseCommentVo e) {
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        return courseCommentBo;
    }

    public static CourseCommentVo toModel(CourseCommentBo bo) {
        CourseCommentVo courseCommentVo = new CourseCommentVo();
        return courseCommentVo;
    }
}
