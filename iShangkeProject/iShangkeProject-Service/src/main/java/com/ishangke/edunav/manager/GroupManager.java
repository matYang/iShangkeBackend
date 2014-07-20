package com.ishangke.edunav.manager;

import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

public interface GroupManager {
    public RoleEntityExt getRoleByGroupId(int groupId);
}
