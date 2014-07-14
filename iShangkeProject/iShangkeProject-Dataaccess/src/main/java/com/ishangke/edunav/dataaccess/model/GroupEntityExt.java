package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;

import com.ishangke.edunav.dataaccess.model.gen.GroupEntity;

public class GroupEntityExt extends GroupEntity {

    private Integer idStart;
    private Integer idEnd;
    private Integer roleIdStart;
    private Integer roleIdEnd;
    private Integer partnerIdStart;
    private Integer partnerIdEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    
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
    public Calendar getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(Calendar createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public Calendar getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(Calendar createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
