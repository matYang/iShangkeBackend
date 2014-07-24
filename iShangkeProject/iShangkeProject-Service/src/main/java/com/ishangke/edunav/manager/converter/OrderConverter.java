package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.dataaccess.model.OrderEntityExt;

public class OrderConverter {
    public static OrderBo toBo(OrderEntityExt e) {
        OrderBo orderBo = new OrderBo();
        orderBo.setBookingId(e.getBookingId());
        orderBo.setBookingIdSet(e.getBookingIdSet());
        orderBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        orderBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        orderBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        orderBo.setEnabled(e.getEnabled());
        orderBo.setId(e.getId());
        orderBo.setIdSet(e.getIdSet());
        orderBo.setPrice(e.getPrice());
        orderBo.setPriceEnd(e.getPriceEnd());
        orderBo.setPriceStart(e.getPriceStart());
        orderBo.setRuningNumber(e.getRuningNumber());
        orderBo.setStatus(e.getStatus());
        orderBo.setStatusSet(e.getStatusSet());
        orderBo.setType(e.getType());
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
        orderEntityExt.setStatus(bo.getStatus());
        orderEntityExt.setStatusSet(bo.getStatusSet());
        orderEntityExt.setType(bo.getType());
        return orderEntityExt;
    }
}
