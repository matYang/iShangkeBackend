package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;

import com.ishangke.edunav.dataaccess.model.gen.RolePermissionEntity;

public class RolePermissionEntityExt extends RolePermissionEntity {

    private Integer idStart;
    private Integer idEnd;
    private Integer roleIdStart;
    private Integer roleIdEnd;
    private Integer permissionIdStart;
    private Integer permissionIdEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    
    public Integer getIdStart() {
        return idStart;
    }
    public void setIdStart(Integer idStart) {
        this.idStart = idStart;
    }
    public Integer getIdEnd() {
        return idEnd;
    }
    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
    }
    public Integer getRoleIdStart() {
        return roleIdStart;
    }
    public void setRoleIdStart(Integer roleIdStart) {
        this.roleIdStart = roleIdStart;
    }
    public Integer getRoleIdEnd() {
        return roleIdEnd;
    }
    public void setRoleIdEnd(Integer roleIdEnd) {
        this.roleIdEnd = roleIdEnd;
    }
    public Integer getPermissionIdStart() {
        return permissionIdStart;
    }
    public void setPermissionIdStart(Integer permissionIdStart) {
        this.permissionIdStart = permissionIdStart;
    }
    public Integer getPermissionIdEnd() {
        return permissionIdEnd;
    }
    public void setPermissionIdEnd(Integer permissionIdEnd) {
        this.permissionIdEnd = permissionIdEnd;
    }
    public Calendar getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }
    public void setLastModifyTimeStart(Calendar lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }
    public Calendar getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }
    public void setLastModifyTimeEnd(Calendar lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }
    
    
}
