package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

public interface GroupManager {
    public RoleEntityExt getRoleByGroupId(int groupId);

    public List<GroupBo> listGroupsByUserId(int userId);
}
