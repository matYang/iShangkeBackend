package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.dataaccess.model.OrderEntityExt;

public class OrderConverter {
    public static OrderBo toBo(OrderEntityExt e) {
        OrderBo orderBo = new OrderBo();
        if (e.getBookingId() != null) {
            orderBo.setBookingId(e.getBookingId());
        }
        if (e.getBookingIdSet() != null) {
            orderBo.setBookingIdSet(e.getBookingIdSet());
        }
        if (e.getEnabled() != null) {
            orderBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            orderBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            orderBo.setIdSet(e.getIdSet());
        }
        if (e.getPrice() != null) {
            orderBo.setPrice(e.getPrice());
        }
        if (e.getPriceEnd() != null) {
            orderBo.setPriceEnd(e.getPriceEnd());
        }
        if (e.getPriceStart() != null) {
            orderBo.setPriceStart(e.getPriceStart());
        }
        if (e.getRuningNumber() != null) {
            orderBo.setRuningNumber(e.getRuningNumber());
        }
        if (e.getStatus() != null) {
            orderBo.setStatus(e.getStatus());
        } else {
            orderBo.setStatus(Constant.DEFAULTNULL);
        }
        if (e.getStatusSet() != null) {
            orderBo.setStatusSet(e.getStatusSet());
        }
        if (e.getType() != null) {
            orderBo.setType(e.getType());
        }
        if (e.getReference() != null) {
            orderBo.setReference(e.getReference());
        }
        if (e.getSign() != null) {
            orderBo.setSign(e.getSign());
        }
        orderBo.setConfirmedTime(e.getConfirmedTime() == null ? Constant.DEFAULTNULL : e.getConfirmedTime()
                .getTimeInMillis());
        orderBo.setConfirmedTimeEnd(e.getConfirmedTimeEnd() == null ? Constant.DEFAULTNULL : e.getConfirmedTimeEnd()
                .getTimeInMillis());
        orderBo.setConfirmedTimeStart(e.getConfirmedTimeStart() == null ? Constant.DEFAULTNULL : e
                .getConfirmedTimeStart().getTimeInMillis());
        orderBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        orderBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        orderBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());

        return orderBo;
    }

    public static OrderEntityExt fromBo(OrderBo bo) {
        OrderEntityExt orderEntityExt = new OrderEntityExt();
        orderEntityExt.setBookingId(bo.getBookingId());
        orderEntityExt.setBookingIdSet(bo.getBookingIdSet());
        orderEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        orderEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        orderEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        orderEntityExt.setEnabled(bo.getEnabled());
        orderEntityExt.setId(bo.getId());
        orderEntityExt.setIdSet(bo.getIdSet());
        orderEntityExt.setPrice(bo.getPrice());
        orderEntityExt.setPriceEnd(bo.getPriceEnd());
        orderEntityExt.setPriceStart(bo.getPriceStart());
        orderEntityExt.setRuningNumber(bo.getRuningNumber());
        if (bo.getStatus() != Constant.DEFAULTNULL) {
            orderEntityExt.setStatus(bo.getStatus());
        }
        orderEntityExt.setStatusSet(bo.getStatusSet());
        orderEntityExt.setType(bo.getType());
        orderEntityExt.setReference(bo.getReference());
        orderEntityExt.setSign(bo.getSign());
        orderEntityExt.setConfirmedTime(DateUtility.getTimeFromLong(bo.getConfirmedTime()));
        orderEntityExt.setConfirmedTimeEnd(DateUtility.getTimeFromLong(bo.getConfirmedTimeEnd()));
        orderEntityExt.setConfirmedTimeStart(DateUtility.getTimeFromLong(bo.getConfirmedTimeStart()));
        return orderEntityExt;
    }
}
