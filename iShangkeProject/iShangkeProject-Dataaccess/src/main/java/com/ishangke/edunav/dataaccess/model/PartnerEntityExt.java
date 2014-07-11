package com.ishangke.edunav.dataaccess.model;

import java.util.Date;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.PartnerEntity;

public class PartnerEntityExt extends PartnerEntity {
    private int idStart;
    private int idEnd;
    private Set<Integer> idSet;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Date lastLoginTimeStart;
    private Date lastLoginTimeEnd;
    private int cutoffDayStart;
    private int cutoffDayEnd;
    private int cutoffTimeStart;
    private int cutoffTimeEnd;
    private int partnerQualificationStart;
    private int partnerQualificationEnd;
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
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
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
    public Date getLastLoginTimeStart() {
        return lastLoginTimeStart;
    }
    public void setLastLoginTimeStart(Date lastLoginTimeStart) {
        this.lastLoginTimeStart = lastLoginTimeStart;
    }
    public Date getLastLoginTimeEnd() {
        return lastLoginTimeEnd;
    }
    public void setLastLoginTimeEnd(Date lastLoginTimeEnd) {
        this.lastLoginTimeEnd = lastLoginTimeEnd;
    }
    public int getCutoffDayStart() {
        return cutoffDayStart;
    }
    public void setCutoffDayStart(int cutoffDayStart) {
        this.cutoffDayStart = cutoffDayStart;
    }
    public int getCutoffDayEnd() {
        return cutoffDayEnd;
    }
    public void setCutoffDayEnd(int cutoffDayEnd) {
        this.cutoffDayEnd = cutoffDayEnd;
    }
    public int getCutoffTimeStart() {
        return cutoffTimeStart;
    }
    public void setCutoffTimeStart(int cutoffTimeStart) {
        this.cutoffTimeStart = cutoffTimeStart;
    }
    public int getCutoffTimeEnd() {
        return cutoffTimeEnd;
    }
    public void setCutoffTimeEnd(int cutoffTimeEnd) {
        this.cutoffTimeEnd = cutoffTimeEnd;
    }
    public int getPartnerQualificationStart() {
        return partnerQualificationStart;
    }
    public void setPartnerQualificationStart(int partnerQualificationStart) {
        this.partnerQualificationStart = partnerQualificationStart;
    }
    public int getPartnerQualificationEnd() {
        return partnerQualificationEnd;
    }
    public void setPartnerQualificationEnd(int partnerQualificationEnd) {
        this.partnerQualificationEnd = partnerQualificationEnd;
    }
}
