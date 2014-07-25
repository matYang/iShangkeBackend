package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.web.common.ActionVo;
import com.ishangke.edunav.web.model.BookingVo;

public class BookingConverter {
    public static BookingBo fromModel(BookingVo vo) {
        BookingBo bookingBo = new BookingBo();
        if (vo.getCashbackAmount() != null) {
            bookingBo.setCashbackAmount(vo.getCashbackAmount());
        }
        if (vo.getCashbackAmountEnd() != null) {
            bookingBo.setCashbackAmountEnd(vo.getCashbackAmountEnd());
        }
        if (vo.getCashbackAmountStart() != null) {
            bookingBo.setCashbackAmountStart(vo.getCashbackAmountStart());
        }
        if (vo.getCourseId() != null) {
            bookingBo.setCourseId(vo.getCourseId());
        }
        if (vo.getCourseIdSet() != null) {
            bookingBo.setCourseIdSet(vo.getCourseIdSet());
        }
        if (vo.getCourseTemplateId() != null) {
            bookingBo.setCourseTemplateId(vo.getCourseTemplateId());
        }
        if (vo.getCourseTemplateIdSet() != null) {
            bookingBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        }
        if (vo.getEmail() != null) {
            bookingBo.setEmail(vo.getEmail());
        }
        if (vo.getEnabled() != null) {
            bookingBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            bookingBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            bookingBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            bookingBo.setName(vo.getName());
        }
        if (vo.getNote() != null) {
            bookingBo.setNote(vo.getNote());
        }
        if (vo.getPhone() != null) {
            bookingBo.setPhone(vo.getPhone());
        }
        if (vo.getReference() != null) {
            bookingBo.setReference(vo.getReference());
        }
        if (vo.getStatus() != null) {
            bookingBo.setStatus(vo.getStatus());
        }
        if (vo.getStatusSet() != null) {
            bookingBo.setStatusSet(vo.getStatusSet());
        }
        if (vo.getType() != null) {
            bookingBo.setType(vo.getType());
        }
        if (vo.getTypeSet() != null) {
            bookingBo.setTypeSet(vo.getTypeSet());
        }
        if (vo.getUserId() != null) {
            bookingBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            bookingBo.setUserIdSet(vo.getUserIdSet());
        }
        bookingBo.setCashbackDate(vo.getCashbackDate() == null ? Constant.DEFAULTNULL : vo.getCashbackDate().getTimeInMillis());
        bookingBo.setCashbackDateEnd(vo.getCashbackDateEnd() == null ? Constant.DEFAULTNULL : vo.getCashbackDateEnd().getTimeInMillis());
        bookingBo.setCashbackDateStart(vo.getCashbackDateStart() == null ? Constant.DEFAULTNULL : vo.getCashbackDateStart().getTimeInMillis());
        bookingBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        bookingBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        bookingBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        bookingBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        bookingBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        bookingBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        bookingBo.setNoRefundDate(vo.getNoRefundDate() == null ? Constant.DEFAULTNULL : vo.getNoRefundDate().getTimeInMillis());
        bookingBo.setNoRefundDateEnd(vo.getNoRefundDateEnd() == null ? Constant.DEFAULTNULL : vo.getNoRefundDateEnd().getTimeInMillis());
        bookingBo.setNoRefundDateStart(vo.getNoRefundDateStart() == null ? Constant.DEFAULTNULL : vo.getNoRefundDateStart().getTimeInMillis());
        bookingBo.setScheduledTime(vo.getScheduledTime() == null ? Constant.DEFAULTNULL : vo.getScheduledTime().getTimeInMillis());
        bookingBo.setScheduledTimeEnd(vo.getScheduledTimeEnd() == null ? Constant.DEFAULTNULL : vo.getScheduledTimeEnd().getTimeInMillis());
        bookingBo.setScheduledTimeStart(vo.getScheduledTimeStart() == null ? Constant.DEFAULTNULL : vo.getScheduledTimeStart().getTimeInMillis());
        if (vo.getActionList() != null) {
            List<ActionBo> list = new ArrayList<>();
            for (ActionVo a : vo.getActionList()) {
                list.add(ActionConverter.fromModel(a));
            }
            bookingBo.setActionList(list);
        }
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
        if (bo.getActionList() != null) {
            List<ActionVo> list = new ArrayList<>();
            for (ActionBo a : bo.getActionList()) {
                list.add(ActionConverter.toModel(a));
            }
            bookingVo.setActionList(list);
        }
        return bookingVo;
    }
}
