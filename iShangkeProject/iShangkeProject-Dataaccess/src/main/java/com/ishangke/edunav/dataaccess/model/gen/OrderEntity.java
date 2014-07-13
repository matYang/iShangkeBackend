package com.ishangke.edunav.dataaccess.model.gen;

import java.util.Date;

public class OrderEntity {
    private Integer id;

    private Integer bookingId;

    private Date createTime;

    private String type;

    private Double price;

    private String runingNumber;

    private String status;

    private Integer enabled;

    private Integer deleded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRuningNumber() {
        return runingNumber;
    }

    public void setRuningNumber(String runingNumber) {
        this.runingNumber = runingNumber == null ? null : runingNumber.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getDeleded() {
        return deleded;
    }

    public void setDeleded(Integer deleded) {
        this.deleded = deleded;
    }
}