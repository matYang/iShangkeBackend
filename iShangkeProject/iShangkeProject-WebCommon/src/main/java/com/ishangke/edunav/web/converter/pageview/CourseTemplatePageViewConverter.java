package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplatePageViewBo;
import com.ishangke.edunav.web.converter.CourseTemplateConverter;
import com.ishangke.edunav.web.model.CourseTemplateVo;
import com.ishangke.edunav.web.model.pageview.CourseTemplatePageViewVo;

public class CourseTemplatePageViewConverter {
    public static CourseTemplatePageViewVo toModel(CourseTemplatePageViewBo bo) {
        CourseTemplatePageViewVo vo = new CourseTemplatePageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CourseTemplateVo> result = new ArrayList<>();
            for (CourseTemplateBo b : bo.getData()) {
                result.add(CourseTemplateConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
