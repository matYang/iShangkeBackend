package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.PermissionEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.RoleEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;
import com.ishangke.edunav.manager.PermissionManager;

@Component
public class PermissionManagerImpl implements PermissionManager {

    @Autowired
    private PermissionEntityExtMapper permissionMapper;

    @Autowired
    private RoleEntityExtMapper roleMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Override
    public List<PermissionBo> listPermissionsByUser(UserBo user) {
        int userId = user.getId();
        List<RoleEntityExt> result1 = roleMapper.listRolesByGroupId(userId);
        List<GroupEntityExt> result2 = groupMapper.listGroupsByUserId(userId);
        return null;
    }
}
