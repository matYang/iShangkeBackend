package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;

public class BookingHistoryConverter {
    public static BookingHistoryBo toBo(BookingHistoryEntityExt e) {
        BookingHistoryBo bookingHistoryBo = new BookingHistoryBo();
        if (e.getBookingId() != null) {
            bookingHistoryBo.setBookingId(e.getBookingId());
        }
        if (e.getBookingIdSet() != null) {
            bookingHistoryBo.setBookingIdSet(e.getBookingIdSet());
        }
        if (e.getEnabled() != null) {
            bookingHistoryBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            bookingHistoryBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            bookingHistoryBo.setIdSet(e.getIdSet());
        }
        if (e.getNormal() != null) {
            bookingHistoryBo.setNormal(e.getNormal());
        } else {
            bookingHistoryBo.setNormal(Constant.DEFAULTNULL);
        }
        if (e.getNormalSet() != null) {
            bookingHistoryBo.setNormalSet(e.getNormalSet());
        }
        if (e.getOptName() != null) {
            bookingHistoryBo.setOptName(e.getOptName());
        } else {
            bookingHistoryBo.setOptName(Constant.DEFAULTNULL);
        }
        if (e.getOptNameSet() != null) {
            bookingHistoryBo.setOptNameSet(e.getOptNameSet());
        }
        if (e.getPostStatus() != null) {
            bookingHistoryBo.setPostStatus(e.getPostStatus());
        } else {
            bookingHistoryBo.setPostStatus(Constant.DEFAULTNULL);
        }
        if (e.getPostStatusSet() != null) {
            bookingHistoryBo.setPostStatusSet(e.getPostStatusSet());
        }
        if (e.getPreStatus() != null) {
            bookingHistoryBo.setPreStatus(e.getPreStatus());
        } else {
            bookingHistoryBo.setPreStatus(Constant.DEFAULTNULL);
        }
        if (e.getPreStatusSet() != null) {
            bookingHistoryBo.setPreStatusSet(e.getPreStatusSet());
        }
        if (e.getRemark() != null) {
            bookingHistoryBo.setRemark(e.getRemark());
        }
        if (e.getUserId() != null) {
            bookingHistoryBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            bookingHistoryBo.setUserIdSet(e.getUserIdSet());
        }
        bookingHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime()
                .getTimeInMillis());
        bookingHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        bookingHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e
                .getCreateTimeStart().getTimeInMillis());
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
        if (bo.getNormal() != Constant.DEFAULTNULL) {
            bookingHistoryEntityExt.setNormal(bo.getNormal());
        }
        bookingHistoryEntityExt.setNormalSet(bo.getNormalSet());
        if (bo.getOptName() != Constant.DEFAULTNULL) {
            bookingHistoryEntityExt.setOptName(bo.getOptName());
        }
        bookingHistoryEntityExt.setOptNameSet(bo.getOptNameSet());
        if (bo.getPostStatus() != Constant.DEFAULTNULL) {
            bookingHistoryEntityExt.setPostStatus(bo.getPostStatus());
        }
        bookingHistoryEntityExt.setPostStatusSet(bo.getPostStatusSet());
        if (bo.getPreStatus() != Constant.DEFAULTNULL) {
            bookingHistoryEntityExt.setPreStatus(bo.getPreStatus());
        }
        bookingHistoryEntityExt.setPreStatusSet(bo.getPreStatusSet());
        bookingHistoryEntityExt.setRemark(bo.getRemark());
        bookingHistoryEntityExt.setUserId(bo.getUserId());
        bookingHistoryEntityExt.setUserIdSet(bo.getUserIdSet());
        return bookingHistoryEntityExt;
    }
}
