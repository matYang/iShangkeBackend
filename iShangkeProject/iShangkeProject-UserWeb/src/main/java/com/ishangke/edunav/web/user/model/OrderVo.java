package com.ishangke.edunav.web.user.model;

import java.util.Calendar;
import java.util.Set;

public class OrderVo {
    private Integer id;

    private Integer bookingId;

    private Calendar createTime;

    private String type;

    private Double price;

    private String runingNumber;

    private Integer status;

    private Integer enabled;
    private Set<Integer> idSet;
    private Set<Integer> bookingIdSet;
    private Set<Integer> statusSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Double priceStart;
    private Double priceEnd;
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
    public Calendar getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
        this.runingNumber = runingNumber;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getEnabled() {
        return enabled;
    }
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Set<Integer> getBookingIdSet() {
        return bookingIdSet;
    }
    public void setBookingIdSet(Set<Integer> bookingIdSet) {
        this.bookingIdSet = bookingIdSet;
    }
    public Set<Integer> getStatusSet() {
        return statusSet;
    }
    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }
    public Calendar getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(Calendar createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public Calendar getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(Calendar createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    public Double getPriceStart() {
        return priceStart;
    }
    public void setPriceStart(Double priceStart) {
        this.priceStart = priceStart;
    }
    public Double getPriceEnd() {
        return priceEnd;
    }
    public void setPriceEnd(Double priceEnd) {
        this.priceEnd = priceEnd;
    }
    
}
