package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.GroupEntity;

public class GroupEntityExt extends GroupEntity {

    private Integer idStart;
    private Integer idEnd;
    private Integer roleIdStart;
    private Integer roleIdEnd;
    private Integer partnerIdStart;
    private Integer partnerIdEnd;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    
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
    public Integer getPartnerIdStart() {
        return partnerIdStart;
    }
    public void setPartnerIdStart(Integer partnerIdStart) {
        this.partnerIdStart = partnerIdStart;
    }
    public Integer getPartnerIdEnd() {
        return partnerIdEnd;
    }
    public void setPartnerIdEnd(Integer partnerIdEnd) {
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
