package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CourseTemplateTeacherBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateTeacherPageViewBo;
import com.ishangke.edunav.web.converter.CourseTemplateTeacherConverter;
import com.ishangke.edunav.web.model.CourseTemplateTeacherVo;
import com.ishangke.edunav.web.model.pageview.CourseTemplateTeacherPageViewVo;

public class CourseTemplateTeacherPageViewConverter {
    public static CourseTemplateTeacherPageViewVo toModel(CourseTemplateTeacherPageViewBo bo) {
        CourseTemplateTeacherPageViewVo vo = new CourseTemplateTeacherPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CourseTemplateTeacherVo> result = new ArrayList<>();
            for (CourseTemplateTeacherBo b : bo.getData()) {
                result.add(CourseTemplateTeacherConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
