package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.OrderPageViewBo;
import com.ishangke.edunav.web.converter.OrderConverter;
import com.ishangke.edunav.web.model.OrderVo;
import com.ishangke.edunav.web.model.pageview.OrderPageViewVo;

public class OrderPageViewConverter {
    public static OrderPageViewVo toModel(OrderPageViewBo bo) {
        OrderPageViewVo vo = new OrderPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<OrderVo> result = new ArrayList<>();
            for (OrderBo b : bo.getData()) {
                result.add(OrderConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
