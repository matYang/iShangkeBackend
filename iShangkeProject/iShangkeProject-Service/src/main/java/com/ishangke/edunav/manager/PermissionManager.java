package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.PermissionBo;

public interface PermissionManager {

    List<PermissionBo> listPermissionsByUserId(int userId);

    List<PermissionBo> listPermissionsByGroupId(int groupId);

    List<PermissionBo> listPermissionsByRoleId(int roleId);

    List<PermissionBo> listAll();

    boolean hasPermissionByRole(int roleId, String permissionTag);

    boolean hasPermissionByUser(int userId, String permissionTag);
}
