package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.web.common.ActionVo;
import com.ishangke.edunav.web.model.BookingVo;

public class BookingConverter {
    public static BookingBo fromModel(BookingVo vo) {
        if (vo == null) {
            return null;
        }
        BookingBo bookingBo = new BookingBo();
        if (vo.getCashbackAmount() != null) {
            bookingBo.setCashbackAmount(vo.getCashbackAmount());
        } else {
            bookingBo.setCashbackAmount(Constant.DEFAULTNULL);
        }

        if (vo.getCashbackAmountEnd() != null) {
            bookingBo.setCashbackAmountEnd(vo.getCashbackAmountEnd());
        } else {
            bookingBo.setCashbackAmountEnd(Constant.DEFAULTNULL);
        }

        if (vo.getCashbackAmountStart() != null) {
            bookingBo.setCashbackAmountStart(vo.getCashbackAmountStart());
        } else {
            bookingBo.setCashbackAmountStart(Constant.DEFAULTNULL);
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
        } else {
            bookingBo.setStatus(Constant.DEFAULTNULL);
        }
        if (vo.getStatusSet() != null) {
            bookingBo.setStatusSet(vo.getStatusSet());
        }
        if (vo.getPrice() != null) {
            bookingBo.setPrice(vo.getPrice());
        } else {
            bookingBo.setPrice(Constant.DEFAULTNULL);
        }

        if (vo.getPriceEnd() != null) {
            bookingBo.setPriceEnd(vo.getPriceEnd());
        } else {
            bookingBo.setPriceEnd(Constant.DEFAULTNULL);
        }

        if (vo.getPriceStart() != null) {
            bookingBo.setPriceStart(vo.getPriceStart());
        } else {
            bookingBo.setPriceStart(Constant.DEFAULTNULL);
        }

        if (vo.getType() != null) {
            bookingBo.setType(vo.getType());
        } else {
            bookingBo.setType(Constant.DEFAULTNULL);
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
        if (vo.getCashbackDate() != null) {
            bookingBo.setCashbackDate(vo.getCashbackDate());
        } else {
            bookingBo.setCashbackDate(Constant.DEFAULTNULL);
        }
        if (vo.getCashbackDateEnd() != null) {
            bookingBo.setCashbackDateEnd(vo.getCashbackDateEnd());
        } else {
            bookingBo.setCashbackDateEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCashbackDateStart() != null) {
            bookingBo.setCashbackDateStart(vo.getCashbackDateStart());
        } else {
            bookingBo.setCashbackDateStart(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTime() != null) {
            bookingBo.setCreateTime(vo.getCreateTime());
        } else {
            bookingBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            bookingBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            bookingBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            bookingBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            bookingBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            bookingBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            bookingBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            bookingBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            bookingBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            bookingBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            bookingBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getNoRefundDate() != null) {
            bookingBo.setNoRefundDate(vo.getNoRefundDate());
        } else {
            bookingBo.setNoRefundDate(Constant.DEFAULTNULL);
        }
        if (vo.getNoRefundDateEnd() != null) {
            bookingBo.setNoRefundDateEnd(vo.getNoRefundDateEnd());
        } else {
            bookingBo.setNoRefundDateEnd(Constant.DEFAULTNULL);
        }
        if (vo.getNoRefundDateStart() != null) {
            bookingBo.setNoRefundDateStart(vo.getNoRefundDateStart());
        } else {
            bookingBo.setNoRefundDateStart(Constant.DEFAULTNULL);
        }
        if (vo.getScheduledTime() != null) {
            bookingBo.setScheduledTime(vo.getScheduledTime());
        } else {
            bookingBo.setScheduledTime(Constant.DEFAULTNULL);
        }
        if (vo.getScheduledTimeEnd() != null) {
            bookingBo.setScheduledTimeEnd(vo.getScheduledTimeEnd());
        } else {
            bookingBo.setScheduledTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getScheduledTimeStart() != null) {
            bookingBo.setScheduledTimeStart(vo.getScheduledTimeStart());
        } else {
            bookingBo.setScheduledTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getActionList() != null) {
            List<ActionBo> list = new ArrayList<>();
            for (ActionVo a : vo.getActionList()) {
                list.add(ActionConverter.fromModel(a));
            }
            bookingBo.setActionList(list);
        }
        if (vo.getPartnerId() != null) {
            bookingBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            bookingBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        return bookingBo;
    }

    public static BookingVo toModel(BookingBo bo) {
        if (bo == null) {
            return null;
        }
        BookingVo bookingVo = new BookingVo();
        if (Constant.DEFAULTNULL != bo.getCashbackAmount()) {
            bookingVo.setCashbackAmount(bo.getCashbackAmount());
        }
        if (Constant.DEFAULTNULL != bo.getCashbackAmountEnd()) {
            bookingVo.setCashbackAmountEnd(bo.getCashbackAmountEnd());
        }
        if (Constant.DEFAULTNULL != bo.getCashbackAmountStart()) {
            bookingVo.setCashbackAmountStart(bo.getCashbackAmountStart());
        }
        if (bo.getCashbackDate() != Constant.DEFAULTNULL) {
            bookingVo.setCashbackDate(bo.getCashbackDate());
        }
        // bookingVo.setCashbackDateEnd(bo.getCashbackDateEnd());
        // bookingVo.setCashbackDateStart(bo.getCashbackDateStart());
        bookingVo.setCourseId(bo.getCourseId());
        // bookingVo.setCourseIdSet(bo.getCourseIdSet());
        bookingVo.setCourseTemplateId(bo.getCourseTemplateId());
        // bookingVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        bookingVo.setCreateTime(bo.getCreateTime());
        // bookingVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        // bookingVo.setCreateTimeStart(bo.getCreateTimeStart());
        bookingVo.setEmail(bo.getEmail());
        bookingVo.setEnabled(bo.getEnabled());
        bookingVo.setId(bo.getId());
        // bookingVo.setIdSet(bo.getIdSet());
        bookingVo.setLastModifyTime(bo.getLastModifyTime());
        // bookingVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        // bookingVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        bookingVo.setName(bo.getName());
        bookingVo.setNoRefundDate(bo.getNoRefundDate());
        // bookingVo.setNoRefundDateEnd(bo.getNoRefundDateEnd());
        // bookingVo.setNoRefundDateStart(bo.getNoRefundDateStart());
        bookingVo.setNote(bo.getNote());
        bookingVo.setPhone(bo.getPhone());
        // 用来生成更漂亮的订单号
        bookingVo.setReference(Constant.ORDERPREFIX + bo.getCreateTime() + "-" + bo.getId());
        if (bo.getScheduledTime() != Constant.DEFAULTNULL) {
            bookingVo.setScheduledTime(bo.getScheduledTime());
        }
        // bookingVo.setScheduledTimeEnd(bo.getScheduledTimeEnd());
        // bookingVo.setScheduledTimeStart(bo.getScheduledTimeStart());
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            bookingVo.setStatus(bo.getStatus());
        }
        // bookingVo.setStatusSet(bo.getStatusSet());
        if (Constant.DEFAULTNULL != bo.getType()) {
            bookingVo.setType(bo.getType());
        }
        if (Constant.DEFAULTNULL != bo.getPrice()) {
            bookingVo.setPrice(bo.getPrice());
        }
        if (Constant.DEFAULTNULL != bo.getPriceEnd()) {
            bookingVo.setPriceEnd(bo.getPriceEnd());
        }
        if (Constant.DEFAULTNULL != bo.getPriceStart()) {
            bookingVo.setPriceStart(bo.getPriceStart());
        }
        // bookingVo.setTypeSet(bo.getTypeSet());
        bookingVo.setUserId(bo.getUserId());
        // bookingVo.setUserIdSet(bo.getUserIdSet());
        if (bo.getActionList() != null) {
            List<ActionVo> list = new ArrayList<>();
            for (ActionBo a : bo.getActionList()) {
                list.add(ActionConverter.toModel(a));
            }
            bookingVo.setActionList(list);
        }
        bookingVo.setPartnerId(bo.getPartnerId());
        // bookingVo.setPartnerIdSet(bo.getPartnerIdSet());
        if (bo.getCourse() != null) {
            bookingVo.setCourse(CourseConverter.toModel(bo.getCourse()));
        }
        return bookingVo;
    }
}
