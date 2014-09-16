package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.PurposeCourseBo;
import com.ishangke.edunav.commoncontract.model.PurposeCoursePageViewBo;
import com.ishangke.edunav.web.converter.PurposeCourseConverter;
import com.ishangke.edunav.web.model.PurposeCourseVo;
import com.ishangke.edunav.web.model.pageview.PurposeCoursePageViewVo;

public class PurposeCoursePageViewConverter {
    public static PurposeCoursePageViewVo toModel(PurposeCoursePageViewBo bo) {
        PurposeCoursePageViewVo vo = new PurposeCoursePageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<PurposeCourseVo> result = new ArrayList<>();
            for (PurposeCourseBo b : bo.getData()) {
                result.add(PurposeCourseConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
