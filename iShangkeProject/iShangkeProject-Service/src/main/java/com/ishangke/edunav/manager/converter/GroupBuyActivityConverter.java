package com.ishangke.edunav.manager.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.dataaccess.model.GroupBuyActivityEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.GroupBuyPhotoEntity;

public class GroupBuyActivityConverter {
    public static GroupBuyActivityBo toBo(GroupBuyActivityEntityExt e){
        if(e == null){
            return null;
        }
        GroupBuyActivityBo bo = new GroupBuyActivityBo();
        if(e.getId() != null){
            bo.setId(e.getId());
        }
        if(e.getStatus() != null){
            bo.setStatus(e.getStatus());
        }
        bo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL :e.getCreateTime().getTimeInMillis());
        bo.setEndTime(e.getEndTime() == null ? Constant.DEFAULTNULL :e.getEndTime().getTimeInMillis());
        bo.setCourseId(e.getCourseId() == null ? Constant.DEFAULTNULL :e.getCourseId());
        if (e.getCourse() != null){
            bo.setCourse(CourseConverter.toBo(e.getCourse()));
        }
        if (e.getGroupBuyPrice() != null) {
            bo.setGroupBuyPrice(e.getGroupBuyPrice());
        } else {
            bo.setGroupBuyPrice(Constant.DEFAULTNULL);
        }
        if (e.getPhotoList() != null) {
            List<GroupBuyPhotoBo> list = new ArrayList<>();
            for (GroupBuyPhotoEntity photo :e.getPhotoList()) {
                list.add(GroupBuyPhotoConverter.toBo(photo));
            }
            bo.setPhotoList(list);
        }
        return bo;
    }
    
    public static GroupBuyActivityEntityExt fromBo(GroupBuyActivityBo bo){
        if(bo == null){
            return null;
        }
        GroupBuyActivityEntityExt e = new GroupBuyActivityEntityExt();
        e.setCourseId(bo.getCourseId());
        e.setId(bo.getId());
        e.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        e.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        e.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        e.setEndTime(DateUtility.getTimeFromLong(bo.getEndTime()));
        e.setEndTimeStart(DateUtility.getTimeFromLong(bo.getEndTimeStart()));
        e.setEndTimeEnd(DateUtility.getTimeFromLong(bo.getEndTimeEnd()));
        e.setCourseIdSet(bo.getCourseIdSet());
        e.setIdSet(bo.getIdSet());
        e.setStatusSet(bo.getStatusSet());
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            e.setStatus(bo.getStatus());
        }
        if (Constant.DEFAULTNULL != bo.getGroupBuyPrice()) {
            e.setGroupBuyPrice(bo.getGroupBuyPrice());
        }
        if (Constant.DEFAULTNULL != bo.getGroupBuyPriceStart()) {
            e.setGroupBuyPriceStart(bo.getGroupBuyPriceStart());
        }
        if (Constant.DEFAULTNULL != bo.getGroupBuyPriceEnd()) {
            e.setGroupBuyPriceEnd(bo.getGroupBuyPriceEnd());
        }
        return e;
    }
}
