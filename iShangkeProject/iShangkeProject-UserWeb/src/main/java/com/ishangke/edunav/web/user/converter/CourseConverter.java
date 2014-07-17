package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.web.user.model.CourseVo;

public class CourseConverter {
    public static CourseBo fromModel(CourseVo e) {
        CourseBo courseBo = new CourseBo();
        return courseBo;
    }

    public static CourseVo toModel(CourseBo bo) {
        CourseVo courseVo = new CourseVo();
        return courseVo;
    }
}
