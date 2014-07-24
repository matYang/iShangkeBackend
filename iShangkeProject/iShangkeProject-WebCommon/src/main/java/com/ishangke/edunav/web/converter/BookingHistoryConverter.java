package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.web.model.BookingHistoryVo;

public class BookingHistoryConverter {
    public static BookingHistoryBo fromModel(BookingHistoryVo vo) {
        BookingHistoryBo bookingHistoryBo = new BookingHistoryBo();
        if (vo.getBookingId() != null) {
            bookingHistoryBo.setBookingId(vo.getBookingId());
        }
        if (vo.getBookingIdSet() != null) {
            bookingHistoryBo.setBookingIdSet(vo.getBookingIdSet());
        }
        if (vo.getEnabled() != null) {
            bookingHistoryBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            bookingHistoryBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            bookingHistoryBo.setIdSet(vo.getIdSet());
        }
        if (vo.getNormal() != null) {
            bookingHistoryBo.setNormal(vo.getNormal());
        }
        if (vo.getNormalSet() != null) {
            bookingHistoryBo.setNormalSet(vo.getNormalSet());
        }
        if (vo.getOptName() != null) {
            bookingHistoryBo.setOptName(vo.getOptName());
        }
        if (vo.getOptNameSet() != null) {
            bookingHistoryBo.setOptNameSet(vo.getOptNameSet());
        }
        if (vo.getPostStatus() != null) {
            bookingHistoryBo.setPostStatus(vo.getPostStatus());
        }
        if (vo.getPostStatusSet() != null) {
            bookingHistoryBo.setPostStatusSet(vo.getPostStatusSet());
        }
        if (vo.getPreStatus() != null) {
            bookingHistoryBo.setPreStatus(vo.getPreStatus());
        }
        if (vo.getPreStatusSet() != null) {
            bookingHistoryBo.setPreStatusSet(vo.getPreStatusSet());
        }
        if (vo.getRemark() != null) {
            bookingHistoryBo.setRemark(vo.getRemark());
        }
        if (vo.getUserId() != null) {
            bookingHistoryBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            bookingHistoryBo.setUserIdSet(vo.getUserIdSet());
        }
        bookingHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        bookingHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        bookingHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
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
