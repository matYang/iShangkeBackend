package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.web.model.OrderHistoryVo;

public class OrderHistoryConverter {
    public static OrderHistoryBo fromModel(OrderHistoryVo vo) {
        OrderHistoryBo orderHistoryBo = new OrderHistoryBo();
        if (vo.getEnabled() != null) {
            orderHistoryBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            orderHistoryBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            orderHistoryBo.setIdSet(vo.getIdSet());
        }
        if (vo.getNormal() != null) {
            orderHistoryBo.setNormal(vo.getNormal());
        }
        if (vo.getNormalSet() != null) {
            orderHistoryBo.setNormalSet(vo.getNormalSet());
        }
        if (vo.getOptName() != null) {
            orderHistoryBo.setOptName(vo.getOptName());
        }
        if (vo.getOptNameSet() != null) {
            orderHistoryBo.setOptNameSet(vo.getOptNameSet());
        }
        if (vo.getOrderId() != null) {
            orderHistoryBo.setOrderId(vo.getOrderId());
        }
        if (vo.getOrderIdSet() != null) {
            orderHistoryBo.setOrderIdSet(vo.getOrderIdSet());
        }
        if (vo.getPostStatus() != null) {
            orderHistoryBo.setPostStatus(vo.getPostStatus());
        }
        if (vo.getPostStatusSet() != null) {
            orderHistoryBo.setPostStatusSet(vo.getPostStatusSet());
        }
        if (vo.getPreStatus() != null) {
            orderHistoryBo.setPreStatus(vo.getPreStatus());
        }
        if (vo.getPreStatusSet() != null) {
            orderHistoryBo.setPreStatusSet(vo.getPreStatusSet());
        }
        if (vo.getRemark() != null) {
            orderHistoryBo.setRemark(vo.getRemark());
        }
        if (vo.getUserId() != null) {
            orderHistoryBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            orderHistoryBo.setUserIdSet(vo.getUserIdSet());
        }
        orderHistoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        orderHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        orderHistoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
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
