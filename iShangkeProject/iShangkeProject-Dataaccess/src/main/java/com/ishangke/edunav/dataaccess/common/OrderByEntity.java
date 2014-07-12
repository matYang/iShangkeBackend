package com.ishangke.edunav.dataaccess.common;

public class OrderByEntity {
    private String columnKey;
    private String order;

    public OrderByEntity(String columnKey, String order) {
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
