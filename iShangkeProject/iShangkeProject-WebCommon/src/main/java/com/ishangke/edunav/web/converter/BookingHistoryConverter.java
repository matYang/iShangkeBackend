package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.web.model.BookingHistoryVo;
import com.ishangke.edunav.web.common.DateUtility;

public class BookingHistoryConverter {
    public static BookingHistoryBo fromModel(BookingHistoryVo vo) {
        BookingHistoryBo bookingHistoryBo = new BookingHistoryBo();
        bookingHistoryBo.setBookingId(vo.getBookingId());
        bookingHistoryBo.setBookingIdSet(vo.getBookingIdSet());
        bookingHistoryBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        bookingHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        bookingHistoryBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        bookingHistoryBo.setEnabled(vo.getEnabled());
        bookingHistoryBo.setId(vo.getId());
        bookingHistoryBo.setIdSet(vo.getIdSet());
        bookingHistoryBo.setNormal(vo.getNormal());
        bookingHistoryBo.setNormalSet(vo.getNormalSet());
        bookingHistoryBo.setOptName(vo.getOptName());
        bookingHistoryBo.setOptNameSet(vo.getOptNameSet());
        bookingHistoryBo.setPostStatus(vo.getPostStatus());
        bookingHistoryBo.setPostStatusSet(vo.getPostStatusSet());
        bookingHistoryBo.setPreStatus(vo.getPreStatus());
        bookingHistoryBo.setPreStatusSet(vo.getPreStatusSet());
        bookingHistoryBo.setRemark(vo.getRemark());
        bookingHistoryBo.setUserId(vo.getUserId());
        bookingHistoryBo.setUserIdSet(vo.getUserIdSet());
        return bookingHistoryBo;
    }

    public static BookingHistoryVo toModel(BookingHistoryBo bo) {
        BookingHistoryVo bookingHistoryVo = new BookingHistoryVo();
        bookingHistoryVo.setBookingId(bo.getBookingId());
        bookingHistoryVo.setBookingIdSet(bo.getBookingIdSet());
        bookingHistoryVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        bookingHistoryVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        bookingHistoryVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        bookingHistoryVo.setEnabled(bo.getEnabled());
        bookingHistoryVo.setId(bo.getId());
        bookingHistoryVo.setIdSet(bo.getIdSet());
        bookingHistoryVo.setNormal(bo.getNormal());
        bookingHistoryVo.setNormalSet(bo.getNormalSet());
        bookingHistoryVo.setOptName(bo.getOptName());
        bookingHistoryVo.setOptNameSet(bo.getOptNameSet());
        bookingHistoryVo.setPostStatus(bo.getPostStatus());
        bookingHistoryVo.setPostStatusSet(bo.getPostStatusSet());
        bookingHistoryVo.setPreStatus(bo.getPreStatus());
        bookingHistoryVo.setPreStatusSet(bo.getPreStatusSet());
        bookingHistoryVo.setRemark(bo.getRemark());
        bookingHistoryVo.setUserId(bo.getUserId());
        bookingHistoryVo.setUserIdSet(bo.getUserIdSet());
        return bookingHistoryVo;
    }
}
