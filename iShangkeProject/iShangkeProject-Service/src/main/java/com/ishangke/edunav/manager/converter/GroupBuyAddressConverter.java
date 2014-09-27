package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.GroupBuyAddressBo;
import com.ishangke.edunav.dataaccess.model.GroupBuyAddressEntityExt;

public class GroupBuyAddressConverter {
    public static GroupBuyAddressBo toBo(GroupBuyAddressEntityExt e) {
        if (e == null) {
            return null;
        }
        GroupBuyAddressBo bo = new GroupBuyAddressBo();
        if( e.getId() != null) {
            bo.setId(e.getId());
        }
        if (e.getGroupBuyActivityId() != null) {
            bo.setGroupBuyActivityId(e.getGroupBuyActivityId());
        }
        if (e.getAddressId() != null) {
            bo.setAddressId(e.getAddressId());
        }
        return bo;
    }
    
    public static GroupBuyAddressEntityExt fromBo(GroupBuyAddressBo bo) {
        if (bo == null) {
            return null;
        }
        GroupBuyAddressEntityExt e = new GroupBuyAddressEntityExt();
        e.setId(bo.getId());
        e.setGroupBuyActivityId(bo.getGroupBuyActivityId());
        e.setAddressId(bo.getAddressId());
        return e;
    }
}
