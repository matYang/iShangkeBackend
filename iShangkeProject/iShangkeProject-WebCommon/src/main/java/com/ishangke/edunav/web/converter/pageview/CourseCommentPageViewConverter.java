package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentPageViewBo;
import com.ishangke.edunav.web.converter.CourseCommentConverter;
import com.ishangke.edunav.web.model.CourseCommentVo;
import com.ishangke.edunav.web.model.pageview.CourseCommentPageViewVo;

public class CourseCommentPageViewConverter {
    public static CourseCommentPageViewVo toModel(CourseCommentPageViewBo bo) {
        CourseCommentPageViewVo vo = new CourseCommentPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CourseCommentVo> result = new ArrayList<>();
            for (CourseCommentBo b : bo.getData()) {
                result.add(CourseCommentConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
