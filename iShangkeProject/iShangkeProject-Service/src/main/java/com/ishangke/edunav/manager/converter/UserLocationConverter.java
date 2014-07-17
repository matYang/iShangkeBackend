package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.UserLocationBo;
import com.ishangke.edunav.dataaccess.model.UserLocationEntityExt;

public class UserLocationConverter {
    public static UserLocationBo toBo(UserLocationEntityExt e) {
        UserLocationBo UserLocationBo = new UserLocationBo();
        return UserLocationBo;
    }

    public static UserLocationEntityExt fromBo(UserLocationBo bo) {
        UserLocationEntityExt UserLocationEntityExt = new UserLocationEntityExt();
        return UserLocationEntityExt;
    }
}
