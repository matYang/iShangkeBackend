package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.web.model.OrderHistoryVo;

public class OrderHistoryConverter {
    public static OrderHistoryBo fromModel(OrderHistoryVo vo) {
        if (vo == null) {
            return null;
        }
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
        } else {
            orderHistoryBo.setNormal(Constant.DEFAULTNULL);
        }
        if (vo.getNormalSet() != null) {
            orderHistoryBo.setNormalSet(vo.getNormalSet());
        }
        if (vo.getOptName() != null) {
            orderHistoryBo.setOptName(vo.getOptName());
        } else {
            orderHistoryBo.setOptName(Constant.DEFAULTNULL);
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
        } else {
            orderHistoryBo.setPostStatus(Constant.DEFAULTNULL);
        }
        if (vo.getPostStatusSet() != null) {
            orderHistoryBo.setPostStatusSet(vo.getPostStatusSet());
        }
        if (vo.getPreStatus() != null) {
            orderHistoryBo.setPreStatus(vo.getPreStatus());
        } else {
            orderHistoryBo.setPreStatus(Constant.DEFAULTNULL);
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
        if (vo.getCreateTime() != null) {
            orderHistoryBo.setCreateTime(vo.getCreateTime());
        } else {
            orderHistoryBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            orderHistoryBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            orderHistoryBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            orderHistoryBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            orderHistoryBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        return orderHistoryBo;
    }

    public static OrderHistoryVo toModel(OrderHistoryBo bo) {

        if (bo == null) {
            return null;
        }
        OrderHistoryVo orderHistoryVo = new OrderHistoryVo();
        orderHistoryVo.setCreateTime(bo.getCreateTime());
//        orderHistoryVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        orderHistoryVo.setCreateTimeStart(bo.getCreateTimeStart());
        orderHistoryVo.setEnabled(bo.getEnabled());
        orderHistoryVo.setId(bo.getId());
//        orderHistoryVo.setIdSet(bo.getIdSet());
        if (Constant.DEFAULTNULL != bo.getNormal()) {
            orderHistoryVo.setNormal(bo.getNormal());
        }
//        orderHistoryVo.setNormalSet(bo.getNormalSet());
        if (Constant.DEFAULTNULL != bo.getOptName()) {
            orderHistoryVo.setOptName(bo.getOptName());
        }
//        orderHistoryVo.setOptNameSet(bo.getOptNameSet());
        orderHistoryVo.setOrderId(bo.getOrderId());
//        orderHistoryVo.setOrderIdSet(bo.getOrderIdSet());
        if (Constant.DEFAULTNULL != bo.getPostStatus()) {
            orderHistoryVo.setPostStatus(bo.getPostStatus());
        }
//        orderHistoryVo.setPostStatusSet(bo.getPostStatusSet());
        if (Constant.DEFAULTNULL != bo.getPreStatus()) {
            orderHistoryVo.setPreStatus(bo.getPreStatus());
        }
//        orderHistoryVo.setPreStatusSet(bo.getPreStatusSet());
        orderHistoryVo.setRemark(bo.getRemark());
        orderHistoryVo.setUserId(bo.getUserId());
//        orderHistoryVo.setUserIdSet(bo.getUserIdSet());
        return orderHistoryVo;
    }
}
