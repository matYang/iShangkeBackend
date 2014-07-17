package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

public class UserGroupConverter {
    public static UserGroupBo toBo(UserGroupEntityExt e) {
        UserGroupBo userGroupBo = new UserGroupBo();
        return userGroupBo;
    }

    public static UserGroupEntityExt fromBo(UserGroupBo bo) {
        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
        return userGroupEntityExt;
    }
}
