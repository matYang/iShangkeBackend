package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.web.model.BookingHistoryVo;

public class BookingHistoryConverter {
    public static BookingHistoryBo fromModel(BookingHistoryVo vo) {
        if (vo == null) {
            return null;
        }
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
        } else {
            bookingHistoryBo.setNormal(Constant.DEFAULTNULL);
        }

        if (vo.getNormalSet() != null) {
            bookingHistoryBo.setNormalSet(vo.getNormalSet());
        }
        if (vo.getOptName() != null) {
            bookingHistoryBo.setOptName(vo.getOptName());
        } else {
            bookingHistoryBo.setOptName(Constant.DEFAULTNULL);
        }

        if (vo.getOptNameSet() != null) {
            bookingHistoryBo.setOptNameSet(vo.getOptNameSet());
        }
        if (vo.getPostStatus() != null) {
            bookingHistoryBo.setPostStatus(vo.getPostStatus());
        } else {
            bookingHistoryBo.setPostStatus(Constant.DEFAULTNULL);
        }

        if (vo.getPostStatusSet() != null) {
            bookingHistoryBo.setPostStatusSet(vo.getPostStatusSet());
        }
        if (vo.getPreStatus() != null) {
            bookingHistoryBo.setPreStatus(vo.getPreStatus());
        } else {
            bookingHistoryBo.setPreStatus(Constant.DEFAULTNULL);
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
        if (vo.getCreateTime() != null) {
            bookingHistoryBo.setCreateTime(vo.getCreateTime());
        } else {
            bookingHistoryBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            bookingHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            bookingHistoryBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            bookingHistoryBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            bookingHistoryBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getPartnerId() != null) {
            bookingHistoryBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            bookingHistoryBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        return bookingHistoryBo;
    }

    public static BookingHistoryVo toModel(BookingHistoryBo bo) {
        if (bo == null) {
            return null;
        }
        BookingHistoryVo bookingHistoryVo = new BookingHistoryVo();
        bookingHistoryVo.setBookingId(bo.getBookingId());
//        bookingHistoryVo.setBookingIdSet(bo.getBookingIdSet());
        bookingHistoryVo.setCreateTime(bo.getCreateTime());
//        bookingHistoryVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        bookingHistoryVo.setCreateTimeStart(bo.getCreateTimeStart());
        bookingHistoryVo.setEnabled(bo.getEnabled());
        bookingHistoryVo.setId(bo.getId());
//        bookingHistoryVo.setIdSet(bo.getIdSet());
        if (Constant.DEFAULTNULL != bo.getNormal()) {
            bookingHistoryVo.setNormal(bo.getNormal());
        }
//        bookingHistoryVo.setNormalSet(bo.getNormalSet());
        if (Constant.DEFAULTNULL != bo.getOptName()) {
            bookingHistoryVo.setOptName(bo.getOptName());
        }
//        bookingHistoryVo.setOptNameSet(bo.getOptNameSet());
        if (Constant.DEFAULTNULL != bo.getPostStatus()) {
            bookingHistoryVo.setPostStatus(bo.getPostStatus());
        }
//        bookingHistoryVo.setPostStatusSet(bo.getPostStatusSet());
        if (Constant.DEFAULTNULL != bo.getPreStatus()) {
            bookingHistoryVo.setPreStatus(bo.getPreStatus());
        }
//        bookingHistoryVo.setPreStatusSet(bo.getPreStatusSet());
        bookingHistoryVo.setRemark(bo.getRemark());
        bookingHistoryVo.setUserId(bo.getUserId());
//        bookingHistoryVo.setUserIdSet(bo.getUserIdSet());
        bookingHistoryVo.setPartnerId(bo.getPartnerId());
//        bookingHistoryVo.setPartnerIdSet(bo.getPartnerIdSet());
        return bookingHistoryVo;
    }
}
