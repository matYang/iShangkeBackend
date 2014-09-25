package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.dataaccess.model.GroupBuyBookingEntityExt;

public class GroupBuyBookingConverter {
    public static GroupBuyBookingBo toBo(GroupBuyBookingEntityExt e){
        if(e == null){
            return null;
        }
        GroupBuyBookingBo bo = new GroupBuyBookingBo();
        if(e.getId() != null){
            bo.setId(e.getId());
        }
        if(e.getStatus() != null){
            bo.setStatus(e.getStatus());
        }
        if(e.getGroupBuyPrice() != null){
            bo.setGroupBuyPrice(e.getGroupBuyPrice());
        }
        bo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL :e.getCreateTime().getTimeInMillis());
        bo.setGroupBuyActivityId(e.getGroupBuyActivityId() == null ? Constant.DEFAULTNULL :e.getGroupBuyActivityId());
        bo.setUserId(e.getUserId() == null ? Constant.DEFAULTNULL : e.getUserId());
        if (e.getGroupBuyActivity() != null) {
            bo.setGroupBuyActivity(GroupBuyActivityConverter.toBo(e.getGroupBuyActivity()));
        }
        if (e.getUser() != null) {
            bo.setUser(UserConverter.toBo(e.getUser()));
        }
        return bo;
    }
    
    public static GroupBuyBookingEntityExt fromBo(GroupBuyBookingBo bo){
        if(bo == null){
            return null;
        }
        GroupBuyBookingEntityExt e = new GroupBuyBookingEntityExt();
        e.setGroupBuyActivityId(bo.getGroupBuyActivityId());
        e.setUserId(bo.getUserId());
        if(bo.getGroupBuyPrice() != Constant.DEFAULTNULL){
            e.setGroupBuyPrice(bo.getGroupBuyPrice());
        }
        if(bo.getGroupBuyPriceStart() != Constant.DEFAULTNULL){
            e.setGroupBuyPriceStart(bo.getGroupBuyPriceStart());
        }
        if(bo.getGroupBuyPriceEnd() != Constant.DEFAULTNULL){
            e.setGroupBuyPriceEnd(bo.getGroupBuyPriceEnd());
        }
        if (bo.getStatus() != Constant.DEFAULTNULL){
            e.setStatus(bo.getStatus());
        }
        e.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        e.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        e.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        e.setGroupBuyActivityIdSet(bo.getGroupBuyActivityIdSet());
        e.setId(bo.getId());
        e.setIdSet(bo.getIdSet());
        e.setStatusSet(bo.getStatusSet());
        e.setUserIdSet(bo.getUserIdSet());
        return e;
    }
}