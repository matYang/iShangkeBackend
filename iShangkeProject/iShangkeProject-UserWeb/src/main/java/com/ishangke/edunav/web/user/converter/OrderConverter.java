package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.web.user.model.OrderVo;

public class OrderConverter {
    public static OrderBo fromModel(OrderVo e) {
        OrderBo orderBo =new OrderBo();
        return orderBo;
    }

    public static OrderVo toModel(OrderBo bo) {
        OrderVo orderVo = new OrderVo();
        return orderVo;
    }
}
