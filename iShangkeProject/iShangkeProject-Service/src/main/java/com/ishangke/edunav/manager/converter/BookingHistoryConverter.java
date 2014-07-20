package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class BookingHistoryConverter {
    public static BookingHistoryBo toBo(BookingHistoryEntityExt e) {
        BookingHistoryBo bookingHistoryBo = new BookingHistoryBo();
        bookingHistoryBo.setBookingId(e.getBookingId());
        bookingHistoryBo.setBookingIdSet(e.getBookingIdSet());
        bookingHistoryBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        bookingHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        bookingHistoryBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        bookingHistoryBo.setEnabled(e.getEnabled());
        bookingHistoryBo.setId(e.getId());
        bookingHistoryBo.setIdSet(e.getIdSet());
        bookingHistoryBo.setNormal(e.getNormal());
        bookingHistoryBo.setNormalSet(e.getNormalSet());
        bookingHistoryBo.setOptName(e.getOptName());
        bookingHistoryBo.setOptNameSet(e.getOptNameSet());
        bookingHistoryBo.setPostStatus(e.getPostStatus());
        bookingHistoryBo.setPostStatusSet(e.getPostStatusSet());
        bookingHistoryBo.setPreStatus(e.getPreStatus());
        bookingHistoryBo.setPreStatusSet(e.getPreStatusSet());
        bookingHistoryBo.setRemark(e.getRemark());
        bookingHistoryBo.setUserId(e.getUserId());
        bookingHistoryBo.setUserIdSet(e.getUserIdSet());
        return bookingHistoryBo;
    }

    public static BookingHistoryEntityExt fromBo(BookingHistoryBo bo) {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        bookingHistoryEntityExt.setBookingId(bo.getBookingId());
        bookingHistoryEntityExt.setBookingIdSet(bo.getBookingIdSet());
        bookingHistoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        bookingHistoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        bookingHistoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        bookingHistoryEntityExt.setEnabled(bo.getEnabled());
        bookingHistoryEntityExt.setId(bo.getId());
        bookingHistoryEntityExt.setIdSet(bo.getIdSet());
        bookingHistoryEntityExt.setNormal(bo.getNormal());
        bookingHistoryEntityExt.setNormalSet(bo.getNormalSet());
        bookingHistoryEntityExt.setOptName(bo.getOptName());
        bookingHistoryEntityExt.setOptNameSet(bo.getOptNameSet());
        bookingHistoryEntityExt.setPostStatus(bo.getPostStatus());
        bookingHistoryEntityExt.setPostStatusSet(bo.getPostStatusSet());
        bookingHistoryEntityExt.setPreStatus(bo.getPreStatus());
        bookingHistoryEntityExt.setPreStatusSet(bo.getPreStatusSet());
        bookingHistoryEntityExt.setRemark(bo.getRemark());
        bookingHistoryEntityExt.setUserId(bo.getUserId());
        bookingHistoryEntityExt.setUserIdSet(bo.getUserIdSet());
        return bookingHistoryEntityExt;
    }
}
