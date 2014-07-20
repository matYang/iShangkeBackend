package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.web.user.model.BookingVo;
import com.ishangke.edunav.web.user.common.DateUtility;

public class BookingConverter {
    public static BookingBo fromModel(BookingVo vo) {
        BookingBo bookingBo = new BookingBo();
        bookingBo.setCashbackAmount(vo.getCashbackAmount());
        bookingBo.setCashbackAmountEnd(vo.getCashbackAmountEnd());
        bookingBo.setCashbackAmountStart(vo.getCashbackAmountStart());
        bookingBo.setCashbackDate(vo.getCashbackDate().getTimeInMillis());
        bookingBo.setCashbackDateEnd(vo.getCashbackDateEnd().getTimeInMillis());
        bookingBo.setCashbackDateStart(vo.getCashbackDateStart().getTimeInMillis());
        bookingBo.setCourseId(vo.getCourseId());
        bookingBo.setCourseIdSet(vo.getCourseIdSet());
        bookingBo.setCourseTemplateId(vo.getCourseTemplateId());
        bookingBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        bookingBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        bookingBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        bookingBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        bookingBo.setEmail(vo.getEmail());
        bookingBo.setEnabled(vo.getEnabled());
        bookingBo.setId(vo.getId());
        bookingBo.setIdSet(vo.getIdSet());
        bookingBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        bookingBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        bookingBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        bookingBo.setName(vo.getName());
        bookingBo.setNoRefundDate(vo.getNoRefundDate().getTimeInMillis());
        bookingBo.setNoRefundDateEnd(vo.getNoRefundDateEnd().getTimeInMillis());
        bookingBo.setNoRefundDateStart(vo.getNoRefundDateStart().getTimeInMillis());
        bookingBo.setNote(vo.getNote());
        bookingBo.setPhone(vo.getPhone());
        bookingBo.setReference(vo.getReference());
        bookingBo.setScheduledTime(vo.getScheduledTime().getTimeInMillis());
        bookingBo.setScheduledTimeEnd(vo.getScheduledTimeEnd().getTimeInMillis());
        bookingBo.setScheduledTimeStart(vo.getScheduledTimeStart().getTimeInMillis());
        bookingBo.setStatus(vo.getStatus());
        bookingBo.setStatusSet(vo.getStatusSet());
        bookingBo.setType(vo.getType());
        bookingBo.setTypeSet(vo.getTypeSet());
        bookingBo.setUserId(vo.getUserId());
        bookingBo.setUserIdSet(vo.getUserIdSet());
        return bookingBo;
    }

    public static BookingVo toModel(BookingBo bo) {
        BookingVo bookingVo = new BookingVo();
        bookingVo.setCashbackAmount(bo.getCashbackAmount());
        bookingVo.setCashbackAmountEnd(bo.getCashbackAmountEnd());
        bookingVo.setCashbackAmountStart(bo.getCashbackAmountStart());
        bookingVo.setCashbackDate(DateUtility.getTimeFromLong(bo.getCashbackDate()));
        bookingVo.setCashbackDateEnd(DateUtility.getTimeFromLong(bo.getCashbackDateEnd()));
        bookingVo.setCashbackDateStart(DateUtility.getTimeFromLong(bo.getCashbackDateStart()));
        bookingVo.setCourseId(bo.getCourseId());
        bookingVo.setCourseIdSet(bo.getCourseIdSet());
        bookingVo.setCourseTemplateId(bo.getCourseTemplateId());
        bookingVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        bookingVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        bookingVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        bookingVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        bookingVo.setEmail(bo.getEmail());
        bookingVo.setEnabled(bo.getEnabled());
        bookingVo.setId(bo.getId());
        bookingVo.setIdSet(bo.getIdSet());
        bookingVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        bookingVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        bookingVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        bookingVo.setName(bo.getName());
        bookingVo.setNoRefundDate(DateUtility.getTimeFromLong(bo.getNoRefundDate()));
        bookingVo.setNoRefundDateEnd(DateUtility.getTimeFromLong(bo.getNoRefundDateEnd()));
        bookingVo.setNoRefundDateStart(DateUtility.getTimeFromLong(bo.getNoRefundDateStart()));
        bookingVo.setNote(bo.getNote());
        bookingVo.setPhone(bo.getPhone());
        bookingVo.setReference(bo.getReference());
        bookingVo.setScheduledTime(DateUtility.getTimeFromLong(bo.getScheduledTime()));
        bookingVo.setScheduledTimeEnd(DateUtility.getTimeFromLong(bo.getScheduledTimeEnd()));
        bookingVo.setScheduledTimeStart(DateUtility.getTimeFromLong(bo.getScheduledTimeStart()));
        bookingVo.setStatus(bo.getStatus());
        bookingVo.setStatusSet(bo.getStatusSet());
        bookingVo.setType(bo.getType());
        bookingVo.setTypeSet(bo.getTypeSet());
        bookingVo.setUserId(bo.getUserId());
        bookingVo.setUserIdSet(bo.getUserIdSet());
        return bookingVo;
    }
}
