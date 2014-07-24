package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

public class BookingConverter {
    public static BookingBo toBo(BookingEntityExt e) {
        BookingBo bookingBo = new BookingBo();
        bookingBo.setCashbackAmount(e.getCashbackAmount());
        bookingBo.setCashbackAmountEnd(e.getCashbackAmountEnd());
        bookingBo.setCashbackAmountStart(e.getCashbackAmountStart());
        bookingBo.setCashbackDate(e.getCashbackDate() == null ? Constant.DEFAULTNULL : e.getCashbackDate().getTimeInMillis());
        bookingBo.setCashbackDateEnd(e.getCashbackDateEnd() == null ? Constant.DEFAULTNULL : e.getCashbackDateEnd().getTimeInMillis());
        bookingBo.setCashbackDateStart(e.getCashbackDateStart() == null ? Constant.DEFAULTNULL : e.getCashbackDateStart().getTimeInMillis());
        bookingBo.setCourseId(e.getCourseId());
        bookingBo.setCourseIdSet(e.getCourseIdSet());
        bookingBo.setCourseTemplateId(e.getCourseTemplateId());
        bookingBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        bookingBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        bookingBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        bookingBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        bookingBo.setEmail(e.getEmail());
        bookingBo.setEnabled(e.getEnabled());
        bookingBo.setId(e.getId());
        bookingBo.setIdSet(e.getIdSet());
        bookingBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        bookingBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        bookingBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        bookingBo.setName(e.getName());
        bookingBo.setNoRefundDate(e.getNoRefundDate() == null ? Constant.DEFAULTNULL : e.getNoRefundDate().getTimeInMillis());
        bookingBo.setNoRefundDateEnd(e.getNoRefundDateEnd() == null ? Constant.DEFAULTNULL : e.getNoRefundDateEnd().getTimeInMillis());
        bookingBo.setNoRefundDateStart(e.getNoRefundDateStart() == null ? Constant.DEFAULTNULL : e.getNoRefundDateStart().getTimeInMillis());
        bookingBo.setNote(e.getNote());
        bookingBo.setPhone(e.getPhone());
        bookingBo.setReference(e.getReference());
        bookingBo.setScheduledTime(e.getScheduledTime() == null ? Constant.DEFAULTNULL : e.getScheduledTime().getTimeInMillis());
        bookingBo.setScheduledTimeEnd(e.getScheduledTimeEnd() == null ? Constant.DEFAULTNULL : e.getScheduledTimeEnd().getTimeInMillis());
        bookingBo.setScheduledTimeStart(e.getScheduledTimeStart() == null ? Constant.DEFAULTNULL : e.getScheduledTimeStart().getTimeInMillis());
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
