package com.ishangke.edunav.dataaccess.model.gen;

import java.util.Calendar;

public class ApproveHistoryEntity {
    private Integer id;

    private Integer type;

    private Integer attachedId;

    private Integer submitUserId;

    private Integer approveUserId;

    private Integer preStatus;

    private Integer postStatus;

    private String comment;

    private Calendar createTime;

    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAttachedId() {
        return attachedId;
    }

    public void setAttachedId(Integer attachedId) {
        this.attachedId = attachedId;
    }

    public Integer getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(Integer submitUserId) {
        this.submitUserId = submitUserId;
    }

    public Integer getApproveUserId() {
        return approveUserId;
    }

    public void setApproveUserId(Integer approveUserId) {
        this.approveUserId = approveUserId;
    }

    public Integer getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Integer preStatus) {
        this.preStatus = preStatus;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}