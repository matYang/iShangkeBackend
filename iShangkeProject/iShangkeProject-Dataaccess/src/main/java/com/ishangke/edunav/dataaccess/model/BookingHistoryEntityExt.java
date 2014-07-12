package com.ishangke.edunav.dataaccess.model;

import com.ishangke.edunav.dataaccess.model.gen.BookingHistoryEntity;
import java.util.Date;

public class BookingHistoryEntityExt extends BookingHistoryEntity {

	private Integer idStart;
    private Integer idEnd;

    private Integer bookingIdStart;
    private Integer bookingIdEnd;
    private Integer userIdStart;
    private Integer useridEnd;

    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
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
        return useridEnd;
    }
    public void setUseridEnd(Integer useridEnd) {
        this.useridEnd = useridEnd;
    }
    public Date getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }
    public void setLastModifyTimeStart(Date lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }
    public Date getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }
    public void setLastModifyTimeEnd(Date lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
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
    
}
