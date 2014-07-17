package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.RolePermissionEntity;

public class RolePermissionEntityExt extends RolePermissionEntity {
    private Set<Integer> idSet;
    private Set<Integer> roleIdSet;
    private Set<Integer> permissionIdSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;

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
