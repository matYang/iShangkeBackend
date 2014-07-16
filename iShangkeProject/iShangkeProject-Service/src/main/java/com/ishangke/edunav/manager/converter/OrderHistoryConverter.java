package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.dataaccess.model.OrderHistoryEntityExt;

public class OrderHistoryConverter {
    public static OrderHistoryBo toBo(OrderHistoryEntityExt e) {
        return new OrderHistoryBo();
    }

    public static OrderHistoryEntityExt fromBo(OrderHistoryBo bo) {
        return new OrderHistoryEntityExt();
    }
}
