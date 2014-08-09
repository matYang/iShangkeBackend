package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.commoncontract.model.CourseTeacherPageViewBo;
import com.ishangke.edunav.web.converter.CourseTeacherConverter;
import com.ishangke.edunav.web.model.CourseTeacherVo;
import com.ishangke.edunav.web.model.pageview.CourseTeacherPageViewVo;

public class CourseTeacherPageViewConverter {
    public static CourseTeacherPageViewVo toModel(CourseTeacherPageViewBo bo) {
        CourseTeacherPageViewVo vo = new CourseTeacherPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CourseTeacherVo> result = new ArrayList<>();
            for (CourseTeacherBo b : bo.getData()) {
                result.add(CourseTeacherConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
