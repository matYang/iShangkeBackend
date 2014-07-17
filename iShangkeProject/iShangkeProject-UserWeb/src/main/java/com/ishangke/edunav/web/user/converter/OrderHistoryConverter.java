package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.web.user.model.OrderHistoryVo;

public class OrderHistoryConverter {
    public static OrderHistoryBo fromModel(OrderHistoryVo e) {
        OrderHistoryBo orderHistoryBo = new OrderHistoryBo();
        return orderHistoryBo;
    }

    public static OrderHistoryVo toModel(OrderHistoryBo bo) {
        OrderHistoryVo orderHistoryVo = new OrderHistoryVo();
        return orderHistoryVo;
    }
}
