package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.commoncontract.model.OrderHistoryPageViewBo;
import com.ishangke.edunav.web.converter.OrderHistoryConverter;
import com.ishangke.edunav.web.model.OrderHistoryVo;
import com.ishangke.edunav.web.model.pageview.OrderHistoryPageViewVo;

public class OrderHistoryPageViewConverter {
    public static OrderHistoryPageViewVo toModel(OrderHistoryPageViewBo bo) {
        OrderHistoryPageViewVo vo = new OrderHistoryPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<OrderHistoryVo> result = new ArrayList<>();
            for (OrderHistoryBo b : bo.getData()) {
                result.add(OrderHistoryConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
