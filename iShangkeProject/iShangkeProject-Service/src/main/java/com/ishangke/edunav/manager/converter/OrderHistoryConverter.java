package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.dataaccess.model.OrderHistoryEntityExt;

public class OrderHistoryConverter {
    public static OrderHistoryBo toBo(OrderHistoryEntityExt e) {
        if (e == null) {
            return null;
        }
        OrderHistoryBo orderHistoryBo = new OrderHistoryBo();
        if (e.getEnabled() != null) {
            orderHistoryBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            orderHistoryBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            orderHistoryBo.setIdSet(e.getIdSet());
        }
        if (e.getNormal() != null) {
            orderHistoryBo.setNormal(e.getNormal());
        } else {
            orderHistoryBo.setNormal(Constant.DEFAULTNULL);
        }
        if (e.getNormalSet() != null) {
            orderHistoryBo.setNormalSet(e.getNormalSet());
        }
        if (e.getOptName() != null) {
            orderHistoryBo.setOptName(e.getOptName());
        } else {
            orderHistoryBo.setOptName(Constant.DEFAULTNULL);
        }
        if (e.getOptNameSet() != null) {
            orderHistoryBo.setOptNameSet(e.getOptNameSet());
        }
        if (e.getOrderId() != null) {
            orderHistoryBo.setOrderId(e.getOrderId());
        }
        if (e.getOrderIdSet() != null) {
            orderHistoryBo.setOrderIdSet(e.getOrderIdSet());
        }
        if (e.getPostStatus() != null) {
            orderHistoryBo.setPostStatus(e.getPostStatus());
        } else {
            orderHistoryBo.setPostStatus(Constant.DEFAULTNULL);
        }
        if (e.getPostStatusSet() != null) {
            orderHistoryBo.setPostStatusSet(e.getPostStatusSet());
        }
        if (e.getPreStatus() != null) {
            orderHistoryBo.setPreStatus(e.getPreStatus());
        } else {
            orderHistoryBo.setPreStatus(Constant.DEFAULTNULL);
        }
        if (e.getPreStatusSet() != null) {
            orderHistoryBo.setPreStatusSet(e.getPreStatusSet());
        }
        if (e.getRemark() != null) {
            orderHistoryBo.setRemark(e.getRemark());
        }
        if (e.getUserId() != null) {
            orderHistoryBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            orderHistoryBo.setUserIdSet(e.getUserIdSet());
        }
        orderHistoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime()
                .getTimeInMillis());
        orderHistoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        orderHistoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e
                .getCreateTimeStart().getTimeInMillis());
        return orderHistoryBo;
    }

    public static OrderHistoryEntityExt fromBo(OrderHistoryBo bo) {
        if (bo == null) {
            return null;
        }
        OrderHistoryEntityExt orderHistoryEntityExt = new OrderHistoryEntityExt();
        orderHistoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        orderHistoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        orderHistoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        orderHistoryEntityExt.setEnabled(bo.getEnabled());
        orderHistoryEntityExt.setId(bo.getId());
        orderHistoryEntityExt.setIdSet(bo.getIdSet());
        if (bo.getNormal() != Constant.DEFAULTNULL) {
            orderHistoryEntityExt.setNormal(bo.getNormal());
        }
        orderHistoryEntityExt.setNormalSet(bo.getNormalSet());
        if (bo.getOptName() != Constant.DEFAULTNULL) {
            orderHistoryEntityExt.setOptName(bo.getOptName());
        }
        orderHistoryEntityExt.setOptNameSet(bo.getOptNameSet());
        orderHistoryEntityExt.setOrderId(bo.getOrderId());
        orderHistoryEntityExt.setOrderIdSet(bo.getOrderIdSet());
        if (bo.getPostStatus() != Constant.DEFAULTNULL) {
            orderHistoryEntityExt.setPostStatus(bo.getPostStatus());
        }
        orderHistoryEntityExt.setPostStatusSet(bo.getPostStatusSet());
        if (bo.getPreStatus() != Constant.DEFAULTNULL) {
            orderHistoryEntityExt.setPreStatus(bo.getPreStatus());
        }
        orderHistoryEntityExt.setPreStatusSet(bo.getPreStatusSet());
        orderHistoryEntityExt.setRemark(bo.getRemark());
        orderHistoryEntityExt.setUserId(bo.getUserId());
        orderHistoryEntityExt.setUserIdSet(bo.getUserIdSet());
        return orderHistoryEntityExt;
    }
}
