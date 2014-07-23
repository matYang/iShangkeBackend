package com.ishangke.edunav.manager.transform;

import java.util.List;

public class TransformRole {
    private String name;
    private int roleCode;
    private List<StatusEntity> entitys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public List<StatusEntity> getEntitys() {
        return entitys;
    }

    public void setEntitys(List<StatusEntity> entitys) {
        this.entitys = entitys;
    }

}
