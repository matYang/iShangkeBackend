package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.web.user.model.OrderVo;
import com.ishangke.edunav.web.user.common.DateUtility;

public class OrderConverter {
    public static OrderBo fromModel(OrderVo vo) {
        OrderBo orderBo = new OrderBo();
        orderBo.setBookingId(vo.getBookingId());
        orderBo.setBookingIdSet(vo.getBookingIdSet());
        orderBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        orderBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        orderBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        orderBo.setEnabled(vo.getEnabled());
        orderBo.setId(vo.getId());
        orderBo.setIdSet(vo.getIdSet());
        orderBo.setPrice(vo.getPrice());
        orderBo.setPriceEnd(vo.getPriceEnd());
        orderBo.setPriceStart(vo.getPriceStart());
        orderBo.setRuningNumber(vo.getRuningNumber());
        orderBo.setStatus(vo.getStatus());
        orderBo.setStatusSet(vo.getStatusSet());
        orderBo.setType(vo.getType());
        return orderBo;
    }

    public static OrderVo toModel(OrderBo bo) {
        OrderVo orderVo = new OrderVo();
        orderVo.setBookingId(bo.getBookingId());
        orderVo.setBookingIdSet(bo.getBookingIdSet());
        orderVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        orderVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        orderVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        orderVo.setEnabled(bo.getEnabled());
        orderVo.setId(bo.getId());
        orderVo.setIdSet(bo.getIdSet());
        orderVo.setPrice(bo.getPrice());
        orderVo.setPriceEnd(bo.getPriceEnd());
        orderVo.setPriceStart(bo.getPriceStart());
        orderVo.setRuningNumber(bo.getRuningNumber());
        orderVo.setStatus(bo.getStatus());
        orderVo.setStatusSet(bo.getStatusSet());
        orderVo.setType(bo.getType());
        return orderVo;
    }
}
