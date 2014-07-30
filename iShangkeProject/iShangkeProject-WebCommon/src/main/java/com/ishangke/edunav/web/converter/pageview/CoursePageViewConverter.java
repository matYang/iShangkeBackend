package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CoursePageViewBo;
import com.ishangke.edunav.web.converter.CourseConverter;
import com.ishangke.edunav.web.model.CourseVo;
import com.ishangke.edunav.web.model.pageview.CoursePageViewVo;

public class CoursePageViewConverter {
    public static CoursePageViewVo toModel(CoursePageViewBo bo) {
        CoursePageViewVo vo = new CoursePageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CourseVo> result = new ArrayList<>();
            for (CourseBo b : bo.getData()) {
                result.add(CourseConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
