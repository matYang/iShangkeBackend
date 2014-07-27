package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.OrderByBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.web.common.OrderByVo;
import com.ishangke.edunav.web.common.PaginationVo;

public class PaginationConverter {
    public static PaginationBo toBo(PaginationVo vo) {
        if (vo == null) {
            return null;
        }
        Integer size = vo.getSize();
        if (size == null) {
            // To the last one
            size = Constant.DEFAULTNULL;
        }

        Integer offset = vo.getOffset();
        if (offset == null) {
            // Should start from the first column
            offset = Constant.DEFAULTNULL;
        }

        List<OrderByVo> orderByVos = vo.getOrderByEntities();

        List<OrderByBo> orderByBos = new ArrayList<>();

        for (OrderByBo orderBybo : orderByBos) {
            OrderByBo orderByBo = new OrderByBo(orderBybo.getColumnKey(), orderBybo.getOrder());
            orderByBos.add(orderByBo);
        }

        PaginationBo pageBo = new PaginationBo();
        pageBo.setSize(size);
        pageBo.setOffset(offset);
        pageBo.setOrderByEntities(orderByBos);

        return pageBo;
    }
}
