package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

public class UserConverter {
    public static UserBo toBo(UserEntityExt e) {
        UserBo userBo = new UserBo();
        return userBo;
    }

    public static UserEntityExt fromBo(UserBo bo) {
        UserEntityExt userEntityExt = new UserEntityExt();
        return userEntityExt;
    }
}
