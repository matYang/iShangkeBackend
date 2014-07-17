package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.web.user.model.GroupVo;

public class GroupConverter {
    public static GroupBo fromModel(GroupVo e) {
        GroupBo groupBo = new GroupBo();
        return groupBo;
    }

    public static GroupVo toModel(GroupBo bo) {
        GroupVo groupVo = new GroupVo();
        return groupVo;
    }
}
