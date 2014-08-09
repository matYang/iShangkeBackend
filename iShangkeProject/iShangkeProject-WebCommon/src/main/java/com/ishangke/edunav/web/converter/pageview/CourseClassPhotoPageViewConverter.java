package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CourseClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseClassPhotoPageViewBo;
import com.ishangke.edunav.web.converter.CourseClassPhotoConverter;
import com.ishangke.edunav.web.model.CourseClassPhotoVo;
import com.ishangke.edunav.web.model.pageview.CourseClassPhotoPageViewVo;

public class CourseClassPhotoPageViewConverter {
    public static CourseClassPhotoPageViewVo toModel(CourseClassPhotoPageViewBo bo) {
        CourseClassPhotoPageViewVo vo = new CourseClassPhotoPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CourseClassPhotoVo> result = new ArrayList<>();
            for (CourseClassPhotoBo b : bo.getData()) {
                result.add(CourseClassPhotoConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
