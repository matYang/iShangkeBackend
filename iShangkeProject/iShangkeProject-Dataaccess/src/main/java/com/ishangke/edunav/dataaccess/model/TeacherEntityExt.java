package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.TeacherEntity;

public class TeacherEntityExt extends TeacherEntity {

    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Integer partnerIdStart;
    private Integer partnerIdEnd;
    private Set<Integer> partnerIdSet;
    private Integer popularityStart;
    private Integer popularityEnd;
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
    public Integer getPopularityStart() {
        return popularityStart;
    }
    public void setPopularityStart(Integer popularityStart) {
        this.popularityStart = popularityStart;
    }
    public Integer getPopularityEnd() {
        return popularityEnd;
    }
    public void setPopularityEnd(Integer popularityEnd) {
        this.popularityEnd = popularityEnd;
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
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Set<Integer> getPartnerIdSet() {
        return partnerIdSet;
    }
    public void setPartnerIdSet(Set<Integer> partnerIdSet) {
        this.partnerIdSet = partnerIdSet;
    }
    
    
}
