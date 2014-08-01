package com.ishangke.edunav.web.common;

public class OrderByVo {
    private String columnKey;
    private String order;

    public OrderByVo() {
        //spring mvc帮助我们自动封装GET请求中的参数的时候需要用到默认的构造函数，否则无法进行init
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
