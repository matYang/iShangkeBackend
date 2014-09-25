package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingPageViewBo;
import com.ishangke.edunav.web.converter.GroupBuyBookingConverter;
import com.ishangke.edunav.web.model.GroupBuyBookingVo;
import com.ishangke.edunav.web.model.pageview.GroupBuyBookingPageViewVo;

public class GroupBuyBookingPageViewConverter {
    public static GroupBuyBookingPageViewVo toModel(GroupBuyBookingPageViewBo bo) {
        GroupBuyBookingPageViewVo vo = new GroupBuyBookingPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<GroupBuyBookingVo> result = new ArrayList<>();
            for (GroupBuyBookingBo b : bo.getData()) {
                result.add(GroupBuyBookingConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
