package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.MajorBo;
import com.ishangke.edunav.commoncontract.model.MajorPageViewBo;
import com.ishangke.edunav.web.converter.MajorConverter;
import com.ishangke.edunav.web.model.MajorVo;
import com.ishangke.edunav.web.model.pageview.MajorPageViewVo;

public class MajorPageViewConverter {
    public static MajorPageViewVo toModel(MajorPageViewBo bo) {
        MajorPageViewVo vo = new MajorPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<MajorVo> result = new ArrayList<>();
            for (MajorBo b : bo.getData()) {
                result.add(MajorConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
