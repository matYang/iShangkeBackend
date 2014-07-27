package com.ishangke.edunav.manager.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.OrderByBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;

public class PaginationConverter {

    public static PaginationEntity fromBo(PaginationBo paginationBo) {
        if (paginationBo == null) {
            return null;
        }
        Integer size = paginationBo.getSize();
        if (size == Constant.DEFAULTNULL) {
            // To the last one
            size = null;
        }

        Integer offset = paginationBo.getOffset();
        if (offset == Constant.DEFAULTNULL) {
            // Should start from the first column
            offset = null;
        }

        List<OrderByBo> orderByBos = paginationBo.getOrderByEntities();

        List<OrderByEntity> orderByEntities = new ArrayList<>();

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
