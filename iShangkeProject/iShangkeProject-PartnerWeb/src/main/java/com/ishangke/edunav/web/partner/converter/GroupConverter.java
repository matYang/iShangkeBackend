package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;

public class GroupConverter {
    public static GroupBo toBo(GroupEntityExt e) {
        GroupBo groupBo = new GroupBo();
        return groupBo;
    }

    public static GroupEntityExt fromBo(GroupBo bo) {
        GroupEntityExt groupEntityExt = new GroupEntityExt();
        return groupEntityExt;
    }
}
