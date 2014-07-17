package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.web.user.model.UserVo;

public class UserConverter {
    public static UserBo fromModel(UserVo e) {
        UserBo userBo = new UserBo();
        return userBo;
    }

    public static UserVo toModel(UserBo bo) {
        UserVo userVo = new UserVo();
        return userVo;
    }
}
