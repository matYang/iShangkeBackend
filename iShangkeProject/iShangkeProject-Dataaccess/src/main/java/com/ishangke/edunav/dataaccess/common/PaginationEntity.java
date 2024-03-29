package com.ishangke.edunav.dataaccess.common;

import java.util.ArrayList;
import java.util.List;

public class PaginationEntity {
    private Integer size;
    private Integer offset;
    private List<OrderByEntity> orderByEntities = new ArrayList<>();

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void addOrderByEntity(OrderByEntity orderByEntity) {
        this.orderByEntities.add(orderByEntity);
    }

    public List<OrderByEntity> getOrderByEntities() {
        return orderByEntities;
    }

    public void setOrderByEntities(List<OrderByEntity> orderByEntities) {
        this.orderByEntities = orderByEntities;
    }
}