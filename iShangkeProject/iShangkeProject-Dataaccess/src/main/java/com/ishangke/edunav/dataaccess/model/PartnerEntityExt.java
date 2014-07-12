package com.ishangke.edunav.dataaccess.model;

import java.util.Date;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.PartnerEntity;

public class PartnerEntityExt extends PartnerEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Date lastLoginTimeStart;
    private Date lastLoginTimeEnd;
    private Integer cutoffDayStart;
    private Integer cutoffDayEnd;
    private Integer cutoffTimeStart;
    private Integer cutoffTimeEnd;
    private Integer partnerQualificationStart;
    private Integer partnerQualificationEnd;
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
    public Integer getCutoffDayStart() {
        return cutoffDayStart;
    }
    public void setCutoffDayStart(Integer cutoffDayStart) {
        this.cutoffDayStart = cutoffDayStart;
    }
    public Integer getCutoffDayEnd() {
        return cutoffDayEnd;
    }
    public void setCutoffDayEnd(Integer cutoffDayEnd) {
        this.cutoffDayEnd = cutoffDayEnd;
    }
    public Integer getCutoffTimeStart() {
        return cutoffTimeStart;
    }
    public void setCutoffTimeStart(Integer cutoffTimeStart) {
        this.cutoffTimeStart = cutoffTimeStart;
    }
    public Integer getCutoffTimeEnd() {
        return cutoffTimeEnd;
    }
    public void setCutoffTimeEnd(Integer cutoffTimeEnd) {
        this.cutoffTimeEnd = cutoffTimeEnd;
    }
    public Integer getPartnerQualificationStart() {
        return partnerQualificationStart;
    }
    public void setPartnerQualificationStart(Integer partnerQualificationStart) {
        this.partnerQualificationStart = partnerQualificationStart;
    }
    public Integer getPartnerQualificationEnd() {
        return partnerQualificationEnd;
    }
    public void setPartnerQualificationEnd(Integer partnerQualificationEnd) {
        this.partnerQualificationEnd = partnerQualificationEnd;
    }
}
