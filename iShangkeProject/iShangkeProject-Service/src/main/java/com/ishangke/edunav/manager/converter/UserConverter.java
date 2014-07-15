package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

public class UserConverter {
    public static UserBo toBo(UserEntityExt e) {
        return new UserBo();
    }

    public static UserEntityExt fromBo(UserBo bo) {
        return new UserEntityExt();
    }
}
