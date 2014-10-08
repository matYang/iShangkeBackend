package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.dataaccess.model.GroupBuyPhotoEntityExt;

public class GroupBuyPhotoConverter {
    public static GroupBuyPhotoBo toBo(GroupBuyPhotoEntityExt e) {
        if (e == null) {
            return null;
        }
        GroupBuyPhotoBo bo = new GroupBuyPhotoBo();
        if( e.getId() != null) {
            bo.setId(e.getId());
        }
        if (e.getGroupBuyActivityId() != null) {
            bo.setGroupBuyActivityId(e.getGroupBuyActivityId());
        }
        if (e.getUrl() != null) {
            bo.setUrl(e.getUrl());
        }
        if (e.getType() != null) {
            bo.setType(e.getType());
        } else {
            bo.setType(Constant.DEFAULTNULL);
        }
        return bo;
    }
    
    public static GroupBuyPhotoEntityExt fromBo(GroupBuyPhotoBo bo) {
        if (bo == null) {
            return null;
        }
        GroupBuyPhotoEntityExt e = new GroupBuyPhotoEntityExt();
        e.setId(bo.getId());
        e.setGroupBuyActivityId(bo.getGroupBuyActivityId());
        e.setUrl(bo.getUrl());
        if (bo.getType() != Constant.DEFAULTNULL) {
            e.setType(bo.getType());
        }
        return e;
    }
}
