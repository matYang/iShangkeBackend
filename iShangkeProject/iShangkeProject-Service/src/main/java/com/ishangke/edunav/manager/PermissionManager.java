package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface PermissionManager {
    List<PermissionBo> listPermissionsByUser(UserBo user);
}
