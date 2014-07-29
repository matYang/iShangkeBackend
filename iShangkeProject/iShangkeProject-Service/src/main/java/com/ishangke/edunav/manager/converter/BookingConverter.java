package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

public class BookingConverter {
    public static BookingBo toBo(BookingEntityExt e) {
        if (e == null) {
            return null;
        }
        BookingBo bookingBo = new BookingBo();
        if (e.getCashbackAmount() != null) {
            bookingBo.setCashbackAmount(e.getCashbackAmount());
        } else {
            bookingBo.setCashbackAmount(Constant.DEFAULTNULL);
        }
        if (e.getCashbackAmountEnd() != null) {
            bookingBo.setCashbackAmountEnd(e.getCashbackAmountEnd());
        } else {
            bookingBo.setCashbackAmountEnd(Constant.DEFAULTNULL);
        }
        if (e.getCashbackAmountStart() != null) {
            bookingBo.setCashbackAmountStart(e.getCashbackAmountStart());
        } else {
            bookingBo.setCashbackAmountStart(Constant.DEFAULTNULL);
        }
        if (e.getCourseId() != null) {
            bookingBo.setCourseId(e.getCourseId());
        }
        if (e.getCourseIdSet() != null) {
            bookingBo.setCourseIdSet(e.getCourseIdSet());
        }
        if (e.getCourseTemplateId() != null) {
            bookingBo.setCourseTemplateId(e.getCourseTemplateId());
        }
        if (e.getCourseTemplateIdSet() != null) {
            bookingBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        }
        if (e.getEmail() != null) {
            bookingBo.setEmail(e.getEmail());
        }
        if (e.getEnabled() != null) {
            bookingBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            bookingBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            bookingBo.setIdSet(e.getIdSet());
        }
        if (e.getName() != null) {
            bookingBo.setName(e.getName());
        }
        if (e.getNote() != null) {
            bookingBo.setNote(e.getNote());
        }
        if (e.getPhone() != null) {
            bookingBo.setPhone(e.getPhone());
        }
        if (e.getReference() != null) {
            bookingBo.setReference(e.getReference());
        }
        if (e.getStatus() != null) {
            bookingBo.setStatus(e.getStatus());
        } else {
            bookingBo.setStatus(Constant.DEFAULTNULL);
        }
        if (e.getStatusSet() != null) {
            bookingBo.setStatusSet(e.getStatusSet());
        }
        if (e.getPrice() != null) {
            bookingBo.setPrice(e.getPrice());
        } else {
            bookingBo.setPrice(Constant.DEFAULTNULL);
        }
        if (e.getPriceEnd() != null) {
            bookingBo.setPriceEnd(e.getPriceEnd());
        } else {
            bookingBo.setPriceEnd(Constant.DEFAULTNULL);
        }
        if (e.getPriceStart() != null) {
            bookingBo.setPriceStart(e.getPriceStart());
        } else {
            bookingBo.setPriceStart(Constant.DEFAULTNULL);
        }

        if (e.getType() != null) {
            bookingBo.setType(e.getType());
        } else {
            bookingBo.setType(Constant.DEFAULTNULL);
        }
        if (e.getTypeSet() != null) {
            bookingBo.setTypeSet(e.getTypeSet());
        }
        if (e.getUserId() != null) {
            bookingBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            bookingBo.setUserIdSet(e.getUserIdSet());
        }
        bookingBo.setCashbackDate(e.getCashbackDate() == null ? Constant.DEFAULTNULL : e.getCashbackDate()
                .getTimeInMillis());
        bookingBo.setCashbackDateEnd(e.getCashbackDateEnd() == null ? Constant.DEFAULTNULL : e.getCashbackDateEnd()
                .getTimeInMillis());
        bookingBo.setCashbackDateStart(e.getCashbackDateStart() == null ? Constant.DEFAULTNULL : e
                .getCashbackDateStart().getTimeInMillis());
        bookingBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        bookingBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        bookingBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        bookingBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        bookingBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        bookingBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        bookingBo.setNoRefundDate(e.getNoRefundDate() == null ? Constant.DEFAULTNULL : e.getNoRefundDate()
                .getTimeInMillis());
        bookingBo.setNoRefundDateEnd(e.getNoRefundDateEnd() == null ? Constant.DEFAULTNULL : e.getNoRefundDateEnd()
                .getTimeInMillis());
        bookingBo.setNoRefundDateStart(e.getNoRefundDateStart() == null ? Constant.DEFAULTNULL : e
                .getNoRefundDateStart().getTimeInMillis());
        bookingBo.setScheduledTime(e.getScheduledTime() == null ? Constant.DEFAULTNULL : e.getScheduledTime()
                .getTimeInMillis());
        bookingBo.setScheduledTimeEnd(e.getScheduledTimeEnd() == null ? Constant.DEFAULTNULL : e.getScheduledTimeEnd()
                .getTimeInMillis());
        bookingBo.setScheduledTimeStart(e.getScheduledTimeStart() == null ? Constant.DEFAULTNULL : e
                .getScheduledTimeStart().getTimeInMillis());
        if (e.getPartnerId() != null) {
            bookingBo.setPartnerId(e.getPartnerId());
        }
        if (e.getPartnerIdSet() != null) {
            bookingBo.setPartnerIdSet(e.getPartnerIdSet());
        }
        return bookingBo;
    }

    public static BookingEntityExt fromBo(BookingBo bo) {
        if (bo == null) {
            return null;
        }
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        if (bo.getCashbackAmount() != Constant.DEFAULTNULL) {
            bookingEntityExt.setCashbackAmount(bo.getCashbackAmount());
        }
        if (bo.getCashbackAmountEnd() != Constant.DEFAULTNULL) {
            bookingEntityExt.setCashbackAmountEnd(bo.getCashbackAmountEnd());
        }
        if (bo.getCashbackAmountStart() != Constant.DEFAULTNULL) {
            bookingEntityExt.setCashbackAmountStart(bo.getCashbackAmountStart());
        }
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
        if (bo.getStatus() != Constant.DEFAULTNULL) {
            bookingEntityExt.setStatus(bo.getStatus());
        }
        bookingEntityExt.setStatusSet(bo.getStatusSet());
        if (bo.getType() != Constant.DEFAULTNULL) {
            bookingEntityExt.setType(bo.getType());
        }
        if (bo.getPrice() != Constant.DEFAULTNULL) {
            bookingEntityExt.setPrice(bo.getPrice());
        }
        if (bo.getPriceEnd() != Constant.DEFAULTNULL) {
            bookingEntityExt.setPriceEnd(bo.getPriceEnd());
        }
        if (bo.getPriceStart() != Constant.DEFAULTNULL) {
            bookingEntityExt.setPriceStart(bo.getPriceStart());
        }
        bookingEntityExt.setTypeSet(bo.getTypeSet());
        bookingEntityExt.setUserId(bo.getUserId());
        bookingEntityExt.setUserIdSet(bo.getUserIdSet());
        bookingEntityExt.setPartnerId(bo.getPartnerId());
        bookingEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
        return bookingEntityExt;
    }
}
