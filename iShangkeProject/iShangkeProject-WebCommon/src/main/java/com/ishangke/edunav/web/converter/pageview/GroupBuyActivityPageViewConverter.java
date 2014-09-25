package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityPageViewBo;
import com.ishangke.edunav.web.converter.GroupBuyActivityConverter;
import com.ishangke.edunav.web.model.GroupBuyActivityVo;
import com.ishangke.edunav.web.model.pageview.GroupBuyActivityPageViewVo;

public class GroupBuyActivityPageViewConverter {
    public static GroupBuyActivityPageViewVo toModel(GroupBuyActivityPageViewBo bo) {
        GroupBuyActivityPageViewVo vo = new GroupBuyActivityPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<GroupBuyActivityVo> result = new ArrayList<>();
            for (GroupBuyActivityBo b : bo.getData()) {
                result.add(GroupBuyActivityConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
