package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.GroupBuyAddressBo;
import com.ishangke.edunav.web.model.GroupBuyAddressVo;

public class GroupBuyAddressConverter {
    public static GroupBuyAddressBo fromModel(GroupBuyAddressVo vo) {
        if (vo == null) {
            return null;
        }
        GroupBuyAddressBo bo = new GroupBuyAddressBo();
        if (vo.getId() != null) {
            bo.setId(vo.getId());
        }
        if (vo.getGroupBuyActivityId() != null) {
            bo.setGroupBuyActivityId(vo.getGroupBuyActivityId());
        }
        if (vo.getAddressId() != null) {
            bo.setAddressId(vo.getAddressId());
        }
        return bo;
    }
    
    public static GroupBuyAddressVo toModel(GroupBuyAddressBo bo) {
        if (bo == null) {
            return null;
        }
        GroupBuyAddressVo vo = new GroupBuyAddressVo();
        vo.setId(bo.getId());
        vo.setGroupBuyActivityId(bo.getGroupBuyActivityId());
        vo.setAddressId(bo.getAddressId());
        return vo;
    }
}
