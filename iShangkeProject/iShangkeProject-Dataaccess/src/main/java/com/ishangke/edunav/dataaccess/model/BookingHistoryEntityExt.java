package com.ishangke.edunav.dataaccess.model;

import com.ishangke.edunav.dataaccess.model.gen.BookingHistoryEntity;
import java.util.Date;
import java.util.Set;

public class BookingHistoryEntityExt extends BookingHistoryEntity {

	private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;

    private Integer bookingIdStart;
    private Integer bookingIdEnd;
    private Set<Integer> bookingIdSet;
    private Integer userIdStart;
    private Integer userIdEnd;
    private Set<Integer> userIdSet;

    private Date createTimeStart;
    private Date createTimeEnd;
    
    
    public Integer getIdStart() {
        return idStart;
    }
    public void setIdStart(Integer idStart) {
        this.idStart = idStart;
    }
    public Integer getIdEnd() {
        return idEnd;
    }
    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
    }
    public Integer getBookingIdStart() {
        return bookingIdStart;
    }
    public void setBookingIdStart(Integer bookingIdStart) {
        this.bookingIdStart = bookingIdStart;
    }
    public Integer getBookingIdEnd() {
        return bookingIdEnd;
    }
    public void setBookingIdEnd(Integer bookingIdEnd) {
        this.bookingIdEnd = bookingIdEnd;
    }
    public Integer getUserIdStart() {
        return userIdStart;
    }
    public void setUserIdStart(Integer userIdStart) {
        this.userIdStart = userIdStart;
    }
    public Integer getUseridEnd() {
        return userIdEnd;
    }
    public void setUseridEnd(Integer userIdEnd) {
        this.userIdEnd = userIdEnd;
    }
    public Date getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
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
    public Integer getUserIdEnd() {
        return userIdEnd;
    }
    public void setUserIdEnd(Integer userIdEnd) {
        this.userIdEnd = userIdEnd;
    }
    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }
    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }
    
}
