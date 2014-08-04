package com.ishangke.edunav.web.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class UserGroupVo extends JsonResponse {
    private Integer id;

    private Integer userId;

    private Integer groupId;

    private Calendar lastModifyTime;
    private Set<Integer> idSet;
    private Set<Integer> userIdSet;
    private Set<Integer> groupIdSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Calendar getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Calendar lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }

    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }

    public Set<Integer> getGroupIdSet() {
        return groupIdSet;
    }

    public void setGroupIdSet(Set<Integer> groupIdSet) {
        this.groupIdSet = groupIdSet;
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

}
