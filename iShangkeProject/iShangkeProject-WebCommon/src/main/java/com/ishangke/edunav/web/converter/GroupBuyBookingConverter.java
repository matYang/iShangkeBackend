package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.web.model.GroupBuyBookingVo;

public class GroupBuyBookingConverter {
    public static GroupBuyBookingBo fromModel(GroupBuyBookingVo vo){
        if (vo == null) {
            return null;
        }
        GroupBuyBookingBo bo = new GroupBuyBookingBo();
        if (vo.getId() != null) {
            bo.setId(vo.getId());
         } 
        
         if (vo.getCreateTime() != null) {
            bo.setCreateTime(vo.getCreateTime());
         } else {
             bo.setCreateTime(Constant.DEFAULTNULL);
         }
         
         if (vo.getStatus() != null) {
            bo.setStatus(vo.getStatus());
         } else {
            bo.setStatus(Constant.DEFAULTNULL);
         }
         
         if (vo.getGroupBuyPrice() != null) {
            bo.setGroupBuyPrice(vo.getGroupBuyPrice());
         } else {
            bo.setGroupBuyPrice(Constant.DEFAULTNULL);
         }
         
         if (vo.getGroupBuyActivityId() != null) {
            bo.setGroupBuyActivityId(vo.getGroupBuyActivityId());
         } 
         
         if (vo.getUserId() != null) {
            bo.setUserId(vo.getUserId());
         } 
         
         if (vo.getIdSet() != null) {
            bo.setIdSet(vo.getIdSet());
         } 
         
         if (vo.getCreateTimeStart() != null) {
            bo.setCreateTimeStart(vo.getCreateTimeStart());
         } else {
            bo.setCreateTimeStart(Constant.DEFAULTNULL);
         }
         
         if (vo.getCreateTimeEnd() != null) {
            bo.setCreateTimeEnd(vo.getCreateTimeEnd());
         } else {
            bo.setCreateTimeEnd(Constant.DEFAULTNULL);
         }
         
         if (vo.getStatusSet() != null) {
            bo.setStatusSet(vo.getStatusSet());
         } 
         
         if (vo.getGroupBuyPriceStart() != null) {
            bo.setGroupBuyPriceStart(vo.getGroupBuyPriceStart());
         } else {
            bo.setGroupBuyPriceStart(Constant.DEFAULTNULL);
         }
         
         if (vo.getGroupBuyPriceEnd() != null) {
            bo.setGroupBuyPriceEnd(vo.getGroupBuyPriceEnd());
         } else {
            bo.setGroupBuyPriceEnd(Constant.DEFAULTNULL);
         }
         
         if (vo.getGroupBuyActivityIdSet() != null) {
            bo.setGroupBuyActivityIdSet(vo.getGroupBuyActivityIdSet());
         } 
         if (vo.getNumber() != null) {
            bo.setNumber(vo.getNumber());
         }
         if (vo.getUserIdSet() != null) {
             bo.setUserIdSet(vo.getUserIdSet());
         }
         if (vo.getReference() != null) {
             bo.setReference(vo.getReference());
         }
         if (vo.getType() != null) {
        	 bo.setType(vo.getType());
         } else {
        	 bo.setType(Constant.DEFAULTNULL);
         }
         return bo;
    }
    public static GroupBuyBookingVo toModel(GroupBuyBookingBo bo){
        if(bo == null){
            return null;
        }
        GroupBuyBookingVo vo = new GroupBuyBookingVo();
        vo.setId(bo.getId());
        vo.setCreateTime(bo.getCreateTime());
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            vo.setStatus(bo.getStatus());
        }
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            vo.setGroupBuyPrice(bo.getGroupBuyPrice());
        } else {
            vo.setGroupBuyPrice(0.0);
        }
        vo.setGroupBuyActivityId(bo.getGroupBuyActivityId());
        vo.setUserId(bo.getUserId());
        vo.setGroupBuyActivity(GroupBuyActivityConverter.toModel(bo.getGroupBuyActivity()));
        vo.setUser(UserConverter.toModel(bo.getUser()));
        vo.setReference(bo.getReference());
        vo.setNumber(bo.getNumber());
        if (Constant.DEFAULTNULL != bo.getType()) {
        	vo.setType(bo.getType());
        }
        return vo;
    }
}
