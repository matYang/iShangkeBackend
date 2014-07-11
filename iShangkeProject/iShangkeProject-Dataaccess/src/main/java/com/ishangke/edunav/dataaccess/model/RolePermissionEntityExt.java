package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.RolePermissionEntity;

public class RolePermissionEntityExt extends RolePermissionEntity {

    private int idStart;
    private int idEnd;
    private int roleIdStart;
    private int roleIdEnd;
    private int permissionIdStart;
    private int permissionIdEnd;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    
    public int getIdStart() {
        return idStart;
    }
    public void setIdStart(int idStart) {
        this.idStart = idStart;
    }
    public int getIdEnd() {
        return idEnd;
    }
    public void setIdEnd(int idEnd) {
        this.idEnd = idEnd;
    }
    public int getRoleIdStart() {
        return roleIdStart;
    }
    public void setRoleIdStart(int roleIdStart) {
        this.roleIdStart = roleIdStart;
    }
    public int getRoleIdEnd() {
        return roleIdEnd;
    }
    public void setRoleIdEnd(int roleIdEnd) {
        this.roleIdEnd = roleIdEnd;
    }
    public int getPermissionIdStart() {
        return permissionIdStart;
    }
    public void setPermissionIdStart(int permissionIdStart) {
        this.permissionIdStart = permissionIdStart;
    }
    public int getPermissionIdEnd() {
        return permissionIdEnd;
    }
    public void setPermissionIdEnd(int permissionIdEnd) {
        this.permissionIdEnd = permissionIdEnd;
    }
    public Date getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }
    public void setLastModifyTimeStart(Date lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }
    public Date getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }
    public void setLastModifyTimeEnd(Date lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }
    
    
}
