package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.GroupEntity;

public class GroupEntityExt extends GroupEntity {

    private int idStart;
    private int idEnd;
    private int roleIdStart;
    private int roleIdEnd;
    private int partnerIdStart;
    private int partnerIdEnd;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    
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
    public int getPartnerIdStart() {
        return partnerIdStart;
    }
    public void setPartnerIdStart(int partnerIdStart) {
        this.partnerIdStart = partnerIdStart;
    }
    public int getPartnerIdEnd() {
        return partnerIdEnd;
    }
    public void setPartnerIdEnd(int partnerIdEnd) {
        this.partnerIdEnd = partnerIdEnd;
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
    public Date getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
