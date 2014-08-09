package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class MessageVo extends JsonResponse {
    private Integer id;

    private String messageText;

    private Integer userFromId;

    private Integer userToId;

    private Integer status;

    private Long readTime;

    private Long createTime;
    private Set<Integer> idSet;
    private Set<Integer> userFromIdSet;
    private Set<Integer> userToIdSet;
    private Set<Integer> statusSet;
    private Long readTimeStart;
    private Long readTimeEnd;
    private Long createTimeStart;
    private Long createTimeEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getUserFromId() {
        return userFromId;
    }

    public void setUserFromId(Integer userFromId) {
        this.userFromId = userFromId;
    }

    public Integer getUserToId() {
        return userToId;
    }

    public void setUserToId(Integer userToId) {
        this.userToId = userToId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getReadTime() {
        return readTime;
    }

    public void setReadTime(Long readTime) {
        this.readTime = readTime;
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

    public Set<Integer> getUserFromIdSet() {
        return userFromIdSet;
    }

    public void setUserFromIdSet(Set<Integer> userFromIdSet) {
        this.userFromIdSet = userFromIdSet;
    }

    public Set<Integer> getUserToIdSet() {
        return userToIdSet;
    }

    public void setUserToIdSet(Set<Integer> userToIdSet) {
        this.userToIdSet = userToIdSet;
    }

    public Set<Integer> getStatusSet() {
        return statusSet;
    }

    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }

    public Long getReadTimeStart() {
        return readTimeStart;
    }

    public void setReadTimeStart(Long readTimeStart) {
        this.readTimeStart = readTimeStart;
    }

    public Long getReadTimeEnd() {
        return readTimeEnd;
    }

    public void setReadTimeEnd(Long readTimeEnd) {
        this.readTimeEnd = readTimeEnd;
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
