package com.ishangke.edunav.dataaccess.model;

import com.ishangke.edunav.dataaccess.model.gen.BookingHistoryEntity;
import java.util.Calendar;
import java.util.Set;

public class BookingHistoryEntityExt extends BookingHistoryEntity {
    private Set<Integer> idSet;
    private Set<Integer> bookingIdSet;
    private Set<Integer> userIdSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;

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

    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }

    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }

}
