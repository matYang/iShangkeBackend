package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

public class UserGroupConverter {
    public static UserGroupBo toBo(UserGroupEntityExt e) {
        return new UserGroupBo();
    }

    public static UserGroupEntityExt fromBo(UserGroupBo bo) {
        return new UserGroupEntityExt();
    }
}
