package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.dataaccess.model.OrderHistoryEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class OrderHistoryConverter {
    public static OrderHistoryBo toBo(OrderHistoryEntityExt e) {
        OrderHistoryBo orderHistoryBo = new OrderHistoryBo();
        orderHistoryBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        orderHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        orderHistoryBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        orderHistoryBo.setEnabled(e.getEnabled());
        orderHistoryBo.setId(e.getId());
        orderHistoryBo.setIdSet(e.getIdSet());
        orderHistoryBo.setNormal(e.getNormal());
        orderHistoryBo.setNormalSet(e.getNormalSet());
        orderHistoryBo.setOptName(e.getOptName());
        orderHistoryBo.setOptNameSet(e.getOptNameSet());
        orderHistoryBo.setOrderId(e.getOrderId());
        orderHistoryBo.setOrderIdSet(e.getOrderIdSet());
        orderHistoryBo.setPostStatus(e.getPostStatus());
        orderHistoryBo.setPostStatusSet(e.getPostStatusSet());
        orderHistoryBo.setPreStatus(e.getPreStatus());
        orderHistoryBo.setPreStatusSet(e.getPreStatusSet());
        orderHistoryBo.setRemark(e.getRemark());
        orderHistoryBo.setUserId(e.getUserId());
        orderHistoryBo.setUserIdSet(e.getUserIdSet());
        return orderHistoryBo;
    }

    public static OrderHistoryEntityExt fromBo(OrderHistoryBo bo) {
        OrderHistoryEntityExt orderHistoryEntityExt = new OrderHistoryEntityExt();
        orderHistoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        orderHistoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        orderHistoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        orderHistoryEntityExt.setEnabled(bo.getEnabled());
        orderHistoryEntityExt.setId(bo.getId());
        orderHistoryEntityExt.setIdSet(bo.getIdSet());
        orderHistoryEntityExt.setNormal(bo.getNormal());
        orderHistoryEntityExt.setNormalSet(bo.getNormalSet());
        orderHistoryEntityExt.setOptName(bo.getOptName());
        orderHistoryEntityExt.setOptNameSet(bo.getOptNameSet());
        orderHistoryEntityExt.setOrderId(bo.getOrderId());
        orderHistoryEntityExt.setOrderIdSet(bo.getOrderIdSet());
        orderHistoryEntityExt.setPostStatus(bo.getPostStatus());
        orderHistoryEntityExt.setPostStatusSet(bo.getPostStatusSet());
        orderHistoryEntityExt.setPreStatus(bo.getPreStatus());
        orderHistoryEntityExt.setPreStatusSet(bo.getPreStatusSet());
        orderHistoryEntityExt.setRemark(bo.getRemark());
        orderHistoryEntityExt.setUserId(bo.getUserId());
        orderHistoryEntityExt.setUserIdSet(bo.getUserIdSet());
        return orderHistoryEntityExt;
    }
}
