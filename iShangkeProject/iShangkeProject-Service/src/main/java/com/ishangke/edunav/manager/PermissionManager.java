package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.PermissionBo;

public interface PermissionManager {

    public List<PermissionBo> listPermissionsByUserId(int userId);

    public List<PermissionBo> listPermissionsByGroupId(int groupId);

    public List<PermissionBo> listPermissionsByRoleId(int roleId);

    public List<PermissionBo> listAll();

    public boolean hasPermissionByRole(int roleId, String permissionTag);

    public boolean hasPermissionByUser(int userId, String permissionTag);
}
