package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.commoncontract.model.CoursePromotionPageViewBo;
import com.ishangke.edunav.web.converter.CoursePromotionConverter;
import com.ishangke.edunav.web.model.CoursePromotionVo;
import com.ishangke.edunav.web.model.pageview.CoursePromotionPageViewVo;

public class CoursePromotionPageViewConverter {
    public static CoursePromotionPageViewVo toModel(CoursePromotionPageViewBo bo) {
        CoursePromotionPageViewVo vo = new CoursePromotionPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CoursePromotionVo> result = new ArrayList<>();
            for (CoursePromotionBo b : bo.getData()) {
                result.add(CoursePromotionConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
