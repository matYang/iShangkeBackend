package com.ishangke.edunav.web.model;

import java.util.Calendar;
import java.util.Set;

public class MessageVo {
    private Integer id;

    private String messageText;

    private Integer userFromId;

    private Integer userToId;

    private Integer status;

    private Calendar readTime;

    private Calendar createTime;
    private Set<Integer> idSet;
    private Set<Integer> userFromIdSet;
    private Set<Integer> userToIdSet;
    private Set<Integer> statusSet;
    private Calendar readTimeStart;
    private Calendar readTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
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
    public Calendar getReadTime() {
        return readTime;
    }
    public void setReadTime(Calendar readTime) {
        this.readTime = readTime;
    }
    public Calendar getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Calendar createTime) {
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
    public Calendar getReadTimeStart() {
        return readTimeStart;
    }
    public void setReadTimeStart(Calendar readTimeStart) {
        this.readTimeStart = readTimeStart;
    }
    public Calendar getReadTimeEnd() {
        return readTimeEnd;
    }
    public void setReadTimeEnd(Calendar readTimeEnd) {
        this.readTimeEnd = readTimeEnd;
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
