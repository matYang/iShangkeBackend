package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.commoncontract.model.GroupPageViewBo;
import com.ishangke.edunav.web.converter.GroupConverter;
import com.ishangke.edunav.web.model.GroupVo;
import com.ishangke.edunav.web.model.pageview.GroupPageViewVo;

public class GroupPageViewConverter {
    public static GroupPageViewVo toModel(GroupPageViewBo bo) {
        GroupPageViewVo vo = new GroupPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<GroupVo> result = new ArrayList<>();
            for (GroupBo b : bo.getData()) {
                result.add(GroupConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
