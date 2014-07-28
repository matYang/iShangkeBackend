package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.web.model.OrderVo;

public class OrderConverter {
    public static OrderBo fromModel(OrderVo vo) {
        if (vo == null) {
            return null;
        }
        OrderBo orderBo = new OrderBo();
        if (vo.getBookingId() != null) {
            orderBo.setBookingId(vo.getBookingId());
        }
        if (vo.getBookingIdSet() != null) {
            orderBo.setBookingIdSet(vo.getBookingIdSet());
        }
        if (vo.getEnabled() != null) {
            orderBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            orderBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            orderBo.setIdSet(vo.getIdSet());
        }
        if (vo.getPrice() != null) {
            orderBo.setPrice(vo.getPrice());
        } else {
            orderBo.setPrice(Constant.DEFAULTNULL);
        }

        if (vo.getPriceEnd() != null) {
            orderBo.setPriceEnd(vo.getPriceEnd());
        } else {
            orderBo.setPriceEnd(Constant.DEFAULTNULL);
        }

        if (vo.getPriceStart() != null) {
            orderBo.setPriceStart(vo.getPriceStart());
        } else {
            orderBo.setPriceStart(Constant.DEFAULTNULL);
        }

        if (vo.getRuningNumber() != null) {
            orderBo.setRuningNumber(vo.getRuningNumber());
        }
        if (vo.getStatus() != null) {
            orderBo.setStatus(vo.getStatus());
        } else {
            orderBo.setStatus(Constant.DEFAULTNULL);
        }
        if (vo.getStatusSet() != null) {
            orderBo.setStatusSet(vo.getStatusSet());
        }
        if (vo.getType() != null) {
            orderBo.setType(vo.getType());
        }
        if (vo.getReference() != null) {
            orderBo.setReference(vo.getReference());
        }
        if (vo.getSign() != null) {
            orderBo.setSign(vo.getSign());
        }
        orderBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        orderBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        orderBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart()
                .getTimeInMillis());
        orderBo.setConfirmedTime(vo.getConfirmedTime() == null ? Constant.DEFAULTNULL : vo.getConfirmedTime()
                .getTimeInMillis());
        orderBo.setConfirmedTimeEnd(vo.getConfirmedTimeEnd() == null ? Constant.DEFAULTNULL : vo.getConfirmedTimeEnd()
                .getTimeInMillis());
        orderBo.setConfirmedTimeStart(vo.getConfirmedTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getConfirmedTimeStart().getTimeInMillis());
        return orderBo;
    }

    public static OrderVo toModel(OrderBo bo) {

        if (bo == null) {
            return null;
        }
        OrderVo orderVo = new OrderVo();
        orderVo.setBookingId(bo.getBookingId());
        orderVo.setBookingIdSet(bo.getBookingIdSet());
        orderVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        orderVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        orderVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        orderVo.setEnabled(bo.getEnabled());
        orderVo.setId(bo.getId());
        orderVo.setIdSet(bo.getIdSet());
        if (Constant.DEFAULTNULL != bo.getPrice()) {
            orderVo.setPrice(bo.getPrice());
        }
        if (Constant.DEFAULTNULL != bo.getPriceEnd()) {
            orderVo.setPriceEnd(bo.getPriceEnd());
        }
        if (Constant.DEFAULTNULL != bo.getPriceStart()) {
            orderVo.setPriceStart(bo.getPriceStart());
        }
        orderVo.setRuningNumber(bo.getRuningNumber());
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            orderVo.setStatus(bo.getStatus());
        }
        orderVo.setStatusSet(bo.getStatusSet());
        orderVo.setType(bo.getType());
        orderVo.setReference(bo.getReference());
        orderVo.setSign(bo.getSign());
        orderVo.setConfirmedTime(DateUtility.getTimeFromLong(bo.getConfirmedTime()));
        orderVo.setConfirmedTimeEnd(DateUtility.getTimeFromLong(bo.getConfirmedTimeEnd()));
        orderVo.setConfirmedTimeStart(DateUtility.getTimeFromLong(bo.getConfirmedTimeStart()));
        return orderVo;
    }
}
