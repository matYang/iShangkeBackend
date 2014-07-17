package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.ApproveHistoryEntity;

public class ApproveHistoryEntityExt extends ApproveHistoryEntity {
    private Set<Integer> idSet;
    private Set<Integer> typeSet;
    private Set<Integer> attachedIdSet;
    private Set<Integer> submitUserIdSet;
    private Set<Integer> approveUserIdSet;
    private Set<Integer> preStatusSet;
    private Set<Integer> postStatusSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;

    public Set<Integer> getTypeSet() {
        return typeSet;
    }

    public void setTypeSet(Set<Integer> typeSet) {
        this.typeSet = typeSet;
    }

    public Set<Integer> getPreStatusSet() {
        return preStatusSet;
    }

    public void setPreStatusSet(Set<Integer> preStatusSet) {
        this.preStatusSet = preStatusSet;
    }

    public Set<Integer> getPostStatusSet() {
        return postStatusSet;
    }

    public void setPostStatusSet(Set<Integer> postStatusSet) {
        this.postStatusSet = postStatusSet;
    }

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
