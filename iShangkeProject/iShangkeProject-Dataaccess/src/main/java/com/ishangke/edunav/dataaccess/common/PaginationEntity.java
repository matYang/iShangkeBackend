package com.ishangke.edunav.dataaccess.common;

import java.util.ArrayList;
import java.util.List;

public class PaginationEntity {
    private int size;
    private int offset;
    private List<OrderByEntity> orderByEntities = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
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