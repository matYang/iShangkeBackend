package com.ishangke.edunav.web.common;

import java.util.ArrayList;
import java.util.List;

public class PaginationVo {
    private Integer count;
    private Integer start;
    private String columnKey;
    private String order;
    private List<OrderByVo> orderByEntities = new ArrayList<>();
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }
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
    public List<OrderByVo> getOrderByEntities() {
        return orderByEntities;
    }
    public void setOrderByEntities(List<OrderByVo> orderByEntities) {
        this.orderByEntities = orderByEntities;
    }
}
