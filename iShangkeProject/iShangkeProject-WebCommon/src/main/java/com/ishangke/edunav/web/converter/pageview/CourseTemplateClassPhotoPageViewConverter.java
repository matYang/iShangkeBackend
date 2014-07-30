package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CourseTemplateClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateClassPhotoPageViewBo;
import com.ishangke.edunav.web.converter.CourseTemplateClassPhotoConverter;
import com.ishangke.edunav.web.model.CourseTemplateClassPhotoVo;
import com.ishangke.edunav.web.model.pageview.CourseTemplateClassPhotoPageViewVo;

public class CourseTemplateClassPhotoPageViewConverter {
    public static CourseTemplateClassPhotoPageViewVo toModel(CourseTemplateClassPhotoPageViewBo bo) {
        CourseTemplateClassPhotoPageViewVo vo = new CourseTemplateClassPhotoPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CourseTemplateClassPhotoVo> result = new ArrayList<>();
            for (CourseTemplateClassPhotoBo b : bo.getData()) {
                result.add(CourseTemplateClassPhotoConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
