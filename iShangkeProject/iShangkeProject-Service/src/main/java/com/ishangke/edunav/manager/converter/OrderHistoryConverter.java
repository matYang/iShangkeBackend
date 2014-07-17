package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.dataaccess.model.OrderHistoryEntityExt;

public class OrderHistoryConverter {
    public static OrderHistoryBo toBo(OrderHistoryEntityExt e) {
        OrderHistoryBo orderHistoryBo = new OrderHistoryBo();
        return orderHistoryBo;
    }

    public static OrderHistoryEntityExt fromBo(OrderHistoryBo bo) {
        OrderHistoryEntityExt orderHistoryEntityExt = new OrderHistoryEntityExt();
        return orderHistoryEntityExt;
    }
}
