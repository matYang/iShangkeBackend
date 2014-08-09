package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.SpreadPageViewBo;
import com.ishangke.edunav.web.converter.SpreadConverter;
import com.ishangke.edunav.web.model.SpreadVo;
import com.ishangke.edunav.web.model.pageview.SpreadPageViewVo;

public class SpreadPageViewConverter {
    public static SpreadPageViewVo toModel(SpreadPageViewBo bo) {
        SpreadPageViewVo vo = new SpreadPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<SpreadVo> result = new ArrayList<>();
            for (SpreadBo b : bo.getData()) {
                result.add(SpreadConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
