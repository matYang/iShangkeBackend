package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.TeacherPageViewBo;
import com.ishangke.edunav.web.converter.TeacherConverter;
import com.ishangke.edunav.web.model.TeacherVo;
import com.ishangke.edunav.web.model.pageview.TeacherPageViewVo;

public class TeacherPageViewConverter {
    public static TeacherPageViewVo toModel(TeacherPageViewBo bo) {
        TeacherPageViewVo vo = new TeacherPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<TeacherVo> result = new ArrayList<>();
            for (TeacherBo b : bo.getData()) {
                result.add(TeacherConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
