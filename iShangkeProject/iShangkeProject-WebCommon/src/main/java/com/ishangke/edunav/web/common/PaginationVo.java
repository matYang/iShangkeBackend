package com.ishangke.edunav.web.common;

import java.util.ArrayList;
import java.util.List;

public class PaginationVo {
    private Integer size;
    private Integer offset;
    private List<OrderByVo> orderByEntities = new ArrayList<>();

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
