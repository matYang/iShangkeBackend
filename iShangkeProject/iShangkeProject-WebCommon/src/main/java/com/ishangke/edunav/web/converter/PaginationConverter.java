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
        Integer count = vo.getCount();
        if (count == null) {
            // To the last one
            count = Constant.DEFAULTNULL;
        }

        Integer start = vo.getStart();
        if (start == null) {
            // Should start from the first column
            start = Constant.DEFAULTNULL;
        }

        List<OrderByVo> orderByVos = vo.getOrderByEntities();
        if (vo.getColumnKey() != null && vo.getOrder() != null) {
            orderByVos.add(new OrderByVo(vo.getColumnKey(), vo.getOrder()));
        }

        List<OrderByBo> orderByBos = new ArrayList<>();

        for (OrderByVo orderByVo : orderByVos) {
            OrderByBo orderByBo = new OrderByBo(orderByVo.getColumnKey(), orderByVo.getOrder());
            orderByBos.add(orderByBo);
        }

        PaginationBo pageBo = new PaginationBo();
        pageBo.setSize(count);
        pageBo.setOffset(start);
        pageBo.setOrderByEntities(orderByBos);

        return pageBo;
    }
}
