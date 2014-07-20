package com.ishangke.edunav.dataaccess.model.gen;

import java.util.Calendar;

public class MessageEntity {
    private Integer id;

    private String messageText;

    private Integer userFromId;

    private Integer userToId;

    private Integer status;

    private Calendar readTime;

    private Calendar createTime;

    private Integer deleted;

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
        this.messageText = messageText == null ? null : messageText.trim();
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}