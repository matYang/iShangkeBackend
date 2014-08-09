package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class ApproveHistoryVo extends JsonResponse {
    private Integer id;
    private Integer type;
    private Integer attachedId;
    private Integer submitUserId;
    private Integer approveUserId;
    private Integer preStatus;
    private Integer postStatus;
    private String comment;
    private Long createTime;
    private Set<Integer> idSet;
    private Set<Integer> typeSet;
    private Set<Integer> attachedIdSet;
    private Set<Integer> submitUserIdSet;
    private Set<Integer> approveUserIdSet;
    private Set<Integer> preStatusSet;
    private Set<Integer> postStatusSet;
    private Long createTimeStart;
    private Long createTimeEnd;

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
        this.comment = comment;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Set<Integer> getTypeSet() {
        return typeSet;
    }

    public void setTypeSet(Set<Integer> typeSet) {
        this.typeSet = typeSet;
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

    public Long getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Long createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Long getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Long createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

}
