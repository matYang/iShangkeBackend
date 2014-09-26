package com.ishangke.edunav.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.web.model.GroupBuyActivityVo;
import com.ishangke.edunav.web.model.GroupBuyPhotoVo;

public class GroupBuyActivityConverter {
    public static GroupBuyActivityBo fromModel(GroupBuyActivityVo vo) {
        if (vo == null) {
            return null;
        }
        GroupBuyActivityBo bo = new GroupBuyActivityBo();
        if (vo.getId() != null) {
            bo.setId(vo.getId());
        }
        if (vo.getCreateTime() != null) {
            bo.setCreateTime(vo.getCreateTime());
        } else {
            bo.setCreateTime(Constant.DEFAULTNULL);
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
        if (vo.getEndTime() != null) {
            bo.setEndTime(vo.getEndTime());
        } else {
            bo.setEndTime(Constant.DEFAULTNULL);
        }
        if (vo.getEndTimeStart() != null) {
            bo.setEndTimeStart(vo.getEndTimeStart());
        } else {
            bo.setEndTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getEndTimeEnd() != null) {
            bo.setEndTimeEnd(vo.getEndTimeEnd());
        } else {
            bo.setEndTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getStatus() != null) {
            bo.setStatus(vo.getStatus());
        } else {
            bo.setStatus(Constant.DEFAULTNULL);
        }
        if (vo.getCourseId() != null) {
            bo.setCourseId(vo.getCourseId());
        }
        if (vo.getIdSet() != null) {
            bo.setIdSet(vo.getIdSet());
        }
        if (vo.getStatusSet() != null) {
            bo.setStatusSet(vo.getStatusSet());
        }
        if (vo.getCourseIdSet() != null) {
            bo.setCourseIdSet(vo.getCourseIdSet());
        }
        if (vo.getGroupBuyPrice() != null) {
            bo.setGroupBuyPrice(vo.getGroupBuyPrice());
        } else {
            bo.setGroupBuyPrice(Constant.DEFAULTNULL);
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
        if (vo.getHot() != null) {
            bo.setHot(vo.getHot());
        } else {
            bo.setHot(Constant.DEFAULTNULL);
        }
        if (vo.getHotSet() != null) {
            bo.setHotSet(vo.getHotSet());
        }
        if (vo.getTitle() != null) {
            bo.setTitle(vo.getTitle());
        }
        if (vo.getPhotoList() != null) {
        	List<GroupBuyPhotoVo> groupBuyPhotoVoList = vo.getPhotoList();
        	List<GroupBuyPhotoBo> groupBuyPhotoBoList = new ArrayList<GroupBuyPhotoBo>();
        	for (GroupBuyPhotoVo groupBuyPhotoVo : groupBuyPhotoVoList) {
        		groupBuyPhotoBoList.add(GroupBuyPhotoConverter.fromModel(groupBuyPhotoVo));
        	}
        	bo.setPhotoList(groupBuyPhotoBoList);
        }
        return bo;
    }

    public static GroupBuyActivityVo toModel(GroupBuyActivityBo bo) {
        if (bo == null) {
            return null;
        }
        GroupBuyActivityVo vo = new GroupBuyActivityVo();
        vo.setCourseId(bo.getCourseId());
        vo.setCreateTime(bo.getCreateTime());
        vo.setEndTime(bo.getEndTime());
        vo.setCourseId(bo.getCourseId());
        vo.setCourse(CourseConverter.toModel(bo.getCourse()));
        if (Constant.DEFAULTNULL != bo.getStatus()) {
           vo.setStatus(bo.getStatus());
        }
        if (Constant.DEFAULTNULL != bo.getGroupBuyPrice()) {
           vo.setGroupBuyPrice(bo.getGroupBuyPrice());
        }
        if (bo.getPhotoList() != null) {
            List<GroupBuyPhotoVo> list = new ArrayList<>();
            for (GroupBuyPhotoBo b : bo.getPhotoList()) {
                list.add(GroupBuyPhotoConverter.toModel(b));
            }
            vo.setPhotoList(list);
        }
        if (Constant.DEFAULTNULL != bo.getHot()) {
            vo.setHot(bo.getHot());
        }
        vo.setTitle(bo.getTitle());
        vo.setBookingTotal(bo.getBookingTotal());
        return vo;
    }
}
