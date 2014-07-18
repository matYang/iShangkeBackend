package com.ishangke.edunav.manager.converter;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.OrderByBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;

public class PaginationConverter {

    public static PaginationEntity fromBo(PaginationBo paginationBo) {
        int size = paginationBo.getSize();
        if (size < 0) {
            // To the last one
            size = -1;
        }

        int offset = paginationBo.getOffset();
        if (offset < 0) {
            // Should start from the first column
            offset = 0;
        }

        List<OrderByBo> orderByBos = paginationBo.getOrderByEntities();

        List<OrderByEntity> orderByEntities = null;

        for (OrderByBo orderBybo : orderByBos) {
            OrderByEntity orderByEntity = new OrderByEntity(orderBybo.getColumnKey(), orderBybo.getOrder());
            orderByEntities.add(orderByEntity);
        }

        PaginationEntity pageEntity = new PaginationEntity();
        pageEntity.setSize(size);
        pageEntity.setOffset(offset);
        pageEntity.setOrderByEntities(orderByEntities);

        return pageEntity;
    }
}
