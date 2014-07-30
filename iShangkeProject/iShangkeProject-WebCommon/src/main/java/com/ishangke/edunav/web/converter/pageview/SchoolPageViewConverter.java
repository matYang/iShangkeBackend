package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.commoncontract.model.SchoolPageViewBo;
import com.ishangke.edunav.web.converter.SchoolConverter;
import com.ishangke.edunav.web.model.SchoolVo;
import com.ishangke.edunav.web.model.pageview.SchoolPageViewVo;

public class SchoolPageViewConverter {
    public static SchoolPageViewVo toModel(SchoolPageViewBo bo) {
        SchoolPageViewVo vo = new SchoolPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<SchoolVo> result = new ArrayList<>();
            for (SchoolBo b : bo.getData()) {
                result.add(SchoolConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
