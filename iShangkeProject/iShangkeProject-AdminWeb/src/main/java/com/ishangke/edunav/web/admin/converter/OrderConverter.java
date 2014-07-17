package com.ishangke.edunav.web.admin.converter;

import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.dataaccess.model.OrderEntityExt;

public class OrderConverter {
    public static OrderBo toBo(OrderEntityExt e) {
        OrderBo orderBo =new OrderBo();
        return orderBo;
    }

    public static OrderEntityExt fromBo(OrderBo bo) {
        OrderEntityExt orderEntityExt = new OrderEntityExt();
        return orderEntityExt;
    }
}
