package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.dataaccess.model.OrderEntityExt;

public class OrderConverter {
    public static OrderBo toBo(OrderEntityExt e) {
        return new OrderBo();
    }

    public static OrderEntityExt fromBo(OrderBo bo) {
        return new OrderEntityExt();
    }
}
