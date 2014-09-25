package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.web.model.GroupBuyPhotoVo;

public class GroupBuyPhotoConverter {
    public static GroupBuyPhotoBo fromModel(GroupBuyPhotoVo vo) {
        if (vo == null) {
            return null;
        }
        GroupBuyPhotoBo bo = new GroupBuyPhotoBo();
        if (vo.getId() != null) {
            bo.setId(vo.getId());
        }
        if (vo.getGroupBuyActivityId() != null) {
            bo.setGroupBuyActivityId(vo.getGroupBuyActivityId());
        }
        if (vo.getUrl() != null) {
            bo.setUrl(vo.getUrl());
        }
        return bo;
    }
    
    public static GroupBuyPhotoVo toModel(GroupBuyPhotoBo bo) {
        if (bo == null) {
            return null;
        }
        GroupBuyPhotoVo vo = new GroupBuyPhotoVo();
        vo.setId(bo.getId());
        vo.setGroupBuyActivityId(bo.getGroupBuyActivityId());
        vo.setUrl(bo.getUrl());
        return vo;
    }
}
