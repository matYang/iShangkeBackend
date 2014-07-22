package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.web.model.OrderHistoryVo;
import com.ishangke.edunav.web.common.DateUtility;

public class OrderHistoryConverter {
    public static OrderHistoryBo fromModel(OrderHistoryVo vo) {
        OrderHistoryBo orderHistoryBo = new OrderHistoryBo();
        orderHistoryBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        orderHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        orderHistoryBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        orderHistoryBo.setEnabled(vo.getEnabled());
        orderHistoryBo.setId(vo.getId());
        orderHistoryBo.setIdSet(vo.getIdSet());
        orderHistoryBo.setNormal(vo.getNormal());
        orderHistoryBo.setNormalSet(vo.getNormalSet());
        orderHistoryBo.setOptName(vo.getOptName());
        orderHistoryBo.setOptNameSet(vo.getOptNameSet());
        orderHistoryBo.setOrderId(vo.getOrderId());
        orderHistoryBo.setOrderIdSet(vo.getOrderIdSet());
        orderHistoryBo.setPostStatus(vo.getPostStatus());
        orderHistoryBo.setPostStatusSet(vo.getPostStatusSet());
        orderHistoryBo.setPreStatus(vo.getPreStatus());
        orderHistoryBo.setPreStatusSet(vo.getPreStatusSet());
        orderHistoryBo.setRemark(vo.getRemark());
        orderHistoryBo.setUserId(vo.getUserId());
        orderHistoryBo.setUserIdSet(vo.getUserIdSet());
        return orderHistoryBo;
    }

    public static OrderHistoryVo toModel(OrderHistoryBo bo) {
        OrderHistoryVo orderHistoryVo = new OrderHistoryVo();
        orderHistoryVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        orderHistoryVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        orderHistoryVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        orderHistoryVo.setEnabled(bo.getEnabled());
        orderHistoryVo.setId(bo.getId());
        orderHistoryVo.setIdSet(bo.getIdSet());
        orderHistoryVo.setNormal(bo.getNormal());
        orderHistoryVo.setNormalSet(bo.getNormalSet());
        orderHistoryVo.setOptName(bo.getOptName());
        orderHistoryVo.setOptNameSet(bo.getOptNameSet());
        orderHistoryVo.setOrderId(bo.getOrderId());
        orderHistoryVo.setOrderIdSet(bo.getOrderIdSet());
        orderHistoryVo.setPostStatus(bo.getPostStatus());
        orderHistoryVo.setPostStatusSet(bo.getPostStatusSet());
        orderHistoryVo.setPreStatus(bo.getPreStatus());
        orderHistoryVo.setPreStatusSet(bo.getPreStatusSet());
        orderHistoryVo.setRemark(bo.getRemark());
        orderHistoryVo.setUserId(bo.getUserId());
        orderHistoryVo.setUserIdSet(bo.getUserIdSet());
        return orderHistoryVo;
    }
}
