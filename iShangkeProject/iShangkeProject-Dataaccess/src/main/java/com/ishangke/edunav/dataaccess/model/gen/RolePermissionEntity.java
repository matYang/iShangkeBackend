package com.ishangke.edunav.dataaccess.model.gen;

import java.util.Calendar;

public class RolePermissionEntity {
    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    private Calendar lastModifyTime;

    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Calendar getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Calendar lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}