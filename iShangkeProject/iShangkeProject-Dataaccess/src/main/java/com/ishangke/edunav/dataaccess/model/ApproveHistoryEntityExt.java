package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.ApproveHistoryEntity;

public class ApproveHistoryEntityExt extends ApproveHistoryEntity {

    private int idStart;
    private int idEnd;
    private int typeStart;
    private int typeEnd;
    private int attachedIdStart;
    private int attachedIdEnd;
    private int submitUserIdStart;
    private int submitUserIdEnd;
    private int approveUserIdStart;
    private int approveUserIdEnd;
    private int preStatusStart;
    private int preStatusEnd;
    private int postStatusStart;
    private int postStatusEnd;
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
    public int getTypeStart() {
        return typeStart;
    }
    public void setTypeStart(int typeStart) {
        this.typeStart = typeStart;
    }
    public int getTypeEnd() {
        return typeEnd;
    }
    public void setTypeEnd(int typeEnd) {
        this.typeEnd = typeEnd;
    }
    public int getAttachedIdStart() {
        return attachedIdStart;
    }
    public void setAttachedIdStart(int attachedIdStart) {
        this.attachedIdStart = attachedIdStart;
    }
    public int getAttachedIdEnd() {
        return attachedIdEnd;
    }
    public void setAttachedIdEnd(int attachedIdEnd) {
        this.attachedIdEnd = attachedIdEnd;
    }
    public int getSubmitUserIdStart() {
        return submitUserIdStart;
    }
    public void setSubmitUserIdStart(int submitUserIdStart) {
        this.submitUserIdStart = submitUserIdStart;
    }
    public int getSubmitUserIdEnd() {
        return submitUserIdEnd;
    }
    public void setSubmitUserIdEnd(int submitUserIdEnd) {
        this.submitUserIdEnd = submitUserIdEnd;
    }
    public int getApproveUserIdStart() {
        return approveUserIdStart;
    }
    public void setApproveUserIdStart(int approveUserIdStart) {
        this.approveUserIdStart = approveUserIdStart;
    }
    public int getApproveUserIdEnd() {
        return approveUserIdEnd;
    }
    public void setApproveUserIdEnd(int approveUserIdEnd) {
        this.approveUserIdEnd = approveUserIdEnd;
    }
    public int getPreStatusStart() {
        return preStatusStart;
    }
    public void setPreStatusStart(int preStatusStart) {
        this.preStatusStart = preStatusStart;
    }
    public int getPreStatusEnd() {
        return preStatusEnd;
    }
    public void setPreStatusEnd(int preStatusEnd) {
        this.preStatusEnd = preStatusEnd;
    }
    public int getPostStatusStart() {
        return postStatusStart;
    }
    public void setPostStatusStart(int postStatusStart) {
        this.postStatusStart = postStatusStart;
    }
    public int getPostStatusEnd() {
        return postStatusEnd;
    }
    public void setPostStatusEnd(int postStatusEnd) {
        this.postStatusEnd = postStatusEnd;
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
