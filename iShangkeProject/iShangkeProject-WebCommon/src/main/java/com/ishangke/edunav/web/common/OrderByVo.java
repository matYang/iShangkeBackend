package com.ishangke.edunav.web.common;

public class OrderByVo {
    private String columnKey;
    private String order;

    public OrderByVo() {
        
    }
    
    public OrderByVo(String columnKey, String order) {
        super();
        this.columnKey = columnKey;
        this.order = order;
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
}
