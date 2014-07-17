package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.RolePermissionEntity;

public class RolePermissionEntityExt extends RolePermissionEntity {

    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Integer roleIdStart;
    private Integer roleIdEnd;
    private Set<Integer> roleIdSet;
    private Integer permissionIdStart;
    private Integer permissionIdEnd;
    private Set<Integer> permissionIdSet;
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
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Set<Integer> getRoleIdSet() {
        return roleIdSet;
    }
    public void setRoleIdSet(Set<Integer> roleIdSet) {
        this.roleIdSet = roleIdSet;
    }
    public Set<Integer> getPermissionIdSet() {
        return permissionIdSet;
    }
    public void setPermissionIdSet(Set<Integer> permissionIdSet) {
        this.permissionIdSet = permissionIdSet;
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
