package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;

public class GroupConverter {
    public static GroupBo toBo(GroupEntityExt e) {
        return new GroupBo();
    }

    public static GroupEntityExt fromBo(GroupBo bo) {
        return new GroupEntityExt();
    }
}
