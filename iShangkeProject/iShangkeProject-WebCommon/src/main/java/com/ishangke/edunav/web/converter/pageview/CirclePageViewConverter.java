package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.CirclePageViewBo;
import com.ishangke.edunav.web.converter.CircleConverter;
import com.ishangke.edunav.web.model.CircleVo;
import com.ishangke.edunav.web.model.pageview.CirclePageViewVo;

public class CirclePageViewConverter {
    public static CirclePageViewVo toModel(CirclePageViewBo bo) {
        CirclePageViewVo vo = new CirclePageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CircleVo> result = new ArrayList<>();
            for (CircleBo b : bo.getData()) {
                result.add(CircleConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
