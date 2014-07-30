package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.commoncontract.model.ActivityPageViewBo;
import com.ishangke.edunav.web.converter.ActivityConverter;
import com.ishangke.edunav.web.model.ActivityVo;
import com.ishangke.edunav.web.model.pageview.ActivityPageViewVo;

public class ActivityPageViewConverter {
    public static ActivityPageViewVo toModel(ActivityPageViewBo bo) {
        ActivityPageViewVo vo = new ActivityPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<ActivityVo> result = new ArrayList<>();
            for (ActivityBo b : bo.getData()) {
                result.add(ActivityConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
