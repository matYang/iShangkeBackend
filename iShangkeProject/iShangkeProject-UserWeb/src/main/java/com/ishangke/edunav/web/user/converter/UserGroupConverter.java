package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.web.user.model.UserGroupVo;

public class UserGroupConverter {
    public static UserGroupBo fromModel(UserGroupVo e) {
        UserGroupBo userGroupBo = new UserGroupBo();
        return userGroupBo;
    }

    public static UserGroupVo toModel(UserGroupBo bo) {
        UserGroupVo userGroupVo = new UserGroupVo();
        return userGroupVo;
    }
}
