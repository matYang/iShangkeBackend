package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.ApproveHistoryEntity;

public class ApproveHistoryEntityExt extends ApproveHistoryEntity {

    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Integer typeStart;
    private Integer typeEnd;
    private Integer attachedIdStart;
    private Integer attachedIdEnd;
    private Set<Integer> attachedIdSet;
    private Integer submitUserIdStart;
    private Integer submitUserIdEnd;
    private Set<Integer> submitUserIdSet;
    private Integer approveUserIdStart;
    private Integer approveUserIdEnd;
    private Set<Integer> approveUserIdSet;
    private Integer preStatusStart;
    private Integer preStatusEnd;
    private Integer postStatusStart;
    private Integer postStatusEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
   
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Set<Integer> getAttachedIdSet() {
        return attachedIdSet;
    }
    public void setAttachedIdSet(Set<Integer> attachedIdSet) {
        this.attachedIdSet = attachedIdSet;
    }
    public Set<Integer> getSubmitUserIdSet() {
        return submitUserIdSet;
    }
    public void setSubmitUserIdSet(Set<Integer> submitUserIdSet) {
        this.submitUserIdSet = submitUserIdSet;
    }
    public Set<Integer> getApproveUserIdSet() {
        return approveUserIdSet;
    }
    public void setApproveUserIdSet(Set<Integer> approveUserIdSet) {
        this.approveUserIdSet = approveUserIdSet;
    }
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
    public Integer getTypeStart() {
        return typeStart;
    }
    public void setTypeStart(Integer typeStart) {
        this.typeStart = typeStart;
    }
    public Integer getTypeEnd() {
        return typeEnd;
    }
    public void setTypeEnd(Integer typeEnd) {
        this.typeEnd = typeEnd;
    }
    public Integer getAttachedIdStart() {
        return attachedIdStart;
    }
    public void setAttachedIdStart(Integer attachedIdStart) {
        this.attachedIdStart = attachedIdStart;
    }
    public Integer getAttachedIdEnd() {
        return attachedIdEnd;
    }
    public void setAttachedIdEnd(Integer attachedIdEnd) {
        this.attachedIdEnd = attachedIdEnd;
    }
    public Integer getSubmitUserIdStart() {
        return submitUserIdStart;
    }
    public void setSubmitUserIdStart(Integer submitUserIdStart) {
        this.submitUserIdStart = submitUserIdStart;
    }
    public Integer getSubmitUserIdEnd() {
        return submitUserIdEnd;
    }
    public void setSubmitUserIdEnd(Integer submitUserIdEnd) {
        this.submitUserIdEnd = submitUserIdEnd;
    }
    public Integer getApproveUserIdStart() {
        return approveUserIdStart;
    }
    public void setApproveUserIdStart(Integer approveUserIdStart) {
        this.approveUserIdStart = approveUserIdStart;
    }
    public Integer getApproveUserIdEnd() {
        return approveUserIdEnd;
    }
    public void setApproveUserIdEnd(Integer approveUserIdEnd) {
        this.approveUserIdEnd = approveUserIdEnd;
    }
    public Integer getPreStatusStart() {
        return preStatusStart;
    }
    public void setPreStatusStart(Integer preStatusStart) {
        this.preStatusStart = preStatusStart;
    }
    public Integer getPreStatusEnd() {
        return preStatusEnd;
    }
    public void setPreStatusEnd(Integer preStatusEnd) {
        this.preStatusEnd = preStatusEnd;
    }
    public Integer getPostStatusStart() {
        return postStatusStart;
    }
    public void setPostStatusStart(Integer postStatusStart) {
        this.postStatusStart = postStatusStart;
    }
    public Integer getPostStatusEnd() {
        return postStatusEnd;
    }
    public void setPostStatusEnd(Integer postStatusEnd) {
        this.postStatusEnd = postStatusEnd;
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
