package com.ishangke.edunav.web.common;

import java.util.ArrayList;
import java.util.List;

public class PaginationVo {
    private Integer size;
    private Integer offset;
    private String columnKey;
    private String order;
    private List<OrderByVo> orderByEntities = new ArrayList<>();

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

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

    public void addOrderByEntity(OrderByVo orderByEntity) {
        this.orderByEntities.add(orderByEntity);
    }

    public List<OrderByVo> getOrderByEntities() {
        return orderByEntities;
    }

    public void setOrderByEntities(List<OrderByVo> orderByEntities) {
        this.orderByEntities = orderByEntities;
    }
}
