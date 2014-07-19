package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.MessageEntity;

public class MessageEntityExt extends MessageEntity {
    private Set<Integer> idSet;
    private Set<Integer> userFromIdSet;
    private Set<Integer> userToIdSet;
    private Set<Integer> statusSet;
    private Calendar readTimeStart;
    private Calendar readTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
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

}
