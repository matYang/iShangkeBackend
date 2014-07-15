package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.PartnerEntity;

public class PartnerEntityExt extends PartnerEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Calendar lastLoginTimeStart;
    private Calendar lastLoginTimeEnd;
    private Integer cutoffDayStart;
    private Integer cutoffDayEnd;
    private Integer cutoffTimeStart;
    private Integer cutoffTimeEnd;
    private Integer partnerQualificationStart;
    private Integer partnerQualificationEnd;
    
    //concrete information
    private List<TeacherEntityExt> teacherList;
    private List<ClassPhotoEntityExt> classPhotoList;
    private List<AddressEntityExt> addressList;
    
    
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
    public Calendar getLastLoginTimeStart() {
        return lastLoginTimeStart;
    }
    public void setLastLoginTimeStart(Calendar lastLoginTimeStart) {
        this.lastLoginTimeStart = lastLoginTimeStart;
    }
    public Calendar getLastLoginTimeEnd() {
        return lastLoginTimeEnd;
    }
    public void setLastLoginTimeEnd(Calendar lastLoginTimeEnd) {
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
    public List<TeacherEntityExt> getTeacherList() {
        return teacherList;
    }
    public void setTeacherList(List<TeacherEntityExt> teacherList) {
        this.teacherList = teacherList;
    }
    public List<ClassPhotoEntityExt> getClassPhotoList() {
        return classPhotoList;
    }
    public void setClassPhotoList(List<ClassPhotoEntityExt> classPhotoList) {
        this.classPhotoList = classPhotoList;
    }
    public List<AddressEntityExt> getAddressList() {
        return addressList;
    }
    public void setAddressList(List<AddressEntityExt> addressList) {
        this.addressList = addressList;
    }
    
}
