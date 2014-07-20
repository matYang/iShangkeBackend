package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class BookingConverter {
    public static BookingBo toBo(BookingEntityExt e) {
        BookingBo bookingBo = new BookingBo();
        bookingBo.setCashbackAmount(e.getCashbackAmount());
        bookingBo.setCashbackAmountEnd(e.getCashbackAmountEnd());
        bookingBo.setCashbackAmountStart(e.getCashbackAmountStart());
        bookingBo.setCashbackDate(e.getCashbackDate().getTimeInMillis());
        bookingBo.setCashbackDateEnd(e.getCashbackDateEnd().getTimeInMillis());
        bookingBo.setCashbackDateStart(e.getCashbackDateStart().getTimeInMillis());
        bookingBo.setCourseId(e.getCourseId());
        bookingBo.setCourseIdSet(e.getCourseIdSet());
        bookingBo.setCourseTemplateId(e.getCourseTemplateId());
        bookingBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        bookingBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        bookingBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        bookingBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        bookingBo.setEmail(e.getEmail());
        bookingBo.setEnabled(e.getEnabled());
        bookingBo.setId(e.getId());
        bookingBo.setIdSet(e.getIdSet());
        bookingBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        bookingBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        bookingBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        bookingBo.setName(e.getName());
        bookingBo.setNoRefundDate(e.getNoRefundDate().getTimeInMillis());
        bookingBo.setNoRefundDateEnd(e.getNoRefundDateEnd().getTimeInMillis());
        bookingBo.setNoRefundDateStart(e.getNoRefundDateStart().getTimeInMillis());
        bookingBo.setNote(e.getNote());
        bookingBo.setPhone(e.getPhone());
        bookingBo.setReference(e.getReference());
        bookingBo.setScheduledTime(e.getScheduledTime().getTimeInMillis());
        bookingBo.setScheduledTimeEnd(e.getScheduledTimeEnd().getTimeInMillis());
        bookingBo.setScheduledTimeStart(e.getScheduledTimeStart().getTimeInMillis());
        bookingBo.setStatus(e.getStatus());
        bookingBo.setStatusSet(e.getStatusSet());
        bookingBo.setType(e.getType());
        bookingBo.setTypeSet(e.getTypeSet());
        bookingBo.setUserId(e.getUserId());
        bookingBo.setUserIdSet(e.getUserIdSet());
        return bookingBo;
    }

    public static BookingEntityExt fromBo(BookingBo bo) {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        bookingEntityExt.setCashbackAmount(bo.getCashbackAmount());
        bookingEntityExt.setCashbackAmountEnd(bo.getCashbackAmountEnd());
        bookingEntityExt.setCashbackAmountStart(bo.getCashbackAmountStart());
        bookingEntityExt.setCashbackDate(DateUtility.getTimeFromLong(bo.getCashbackDate()));
        bookingEntityExt.setCashbackDateEnd(DateUtility.getTimeFromLong(bo.getCashbackDateEnd()));
        bookingEntityExt.setCashbackDateStart(DateUtility.getTimeFromLong(bo.getCashbackDateStart()));
        bookingEntityExt.setCourseId(bo.getCourseId());
        bookingEntityExt.setCourseIdSet(bo.getCourseIdSet());
        bookingEntityExt.setCourseTemplateId(bo.getCourseTemplateId());
        bookingEntityExt.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        bookingEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        bookingEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        bookingEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        bookingEntityExt.setEmail(bo.getEmail());
        bookingEntityExt.setEnabled(bo.getEnabled());
        bookingEntityExt.setId(bo.getId());
        bookingEntityExt.setIdSet(bo.getIdSet());
        bookingEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        bookingEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        bookingEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        bookingEntityExt.setName(bo.getName());
        bookingEntityExt.setNoRefundDate(DateUtility.getTimeFromLong(bo.getNoRefundDate()));
        bookingEntityExt.setNoRefundDateEnd(DateUtility.getTimeFromLong(bo.getNoRefundDateEnd()));
        bookingEntityExt.setNoRefundDateStart(DateUtility.getTimeFromLong(bo.getNoRefundDateStart()));
        bookingEntityExt.setNote(bo.getNote());
        bookingEntityExt.setPhone(bo.getPhone());
        bookingEntityExt.setReference(bo.getReference());
        bookingEntityExt.setScheduledTime(DateUtility.getTimeFromLong(bo.getScheduledTime()));
        bookingEntityExt.setScheduledTimeEnd(DateUtility.getTimeFromLong(bo.getScheduledTimeEnd()));
        bookingEntityExt.setScheduledTimeStart(DateUtility.getTimeFromLong(bo.getScheduledTimeStart()));
        bookingEntityExt.setStatus(bo.getStatus());
        bookingEntityExt.setStatusSet(bo.getStatusSet());
        bookingEntityExt.setType(bo.getType());
        bookingEntityExt.setTypeSet(bo.getTypeSet());
        bookingEntityExt.setUserId(bo.getUserId());
        bookingEntityExt.setUserIdSet(bo.getUserIdSet());
        return bookingEntityExt;
    }
}
