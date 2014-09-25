package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.GroupBuyBookingEntity;

public class GroupBuyBookingEntityExt extends GroupBuyBookingEntity {
    private Set<Integer> idSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Set<Integer> statusSet;
    private Double groupBuyPriceStart;
    private Double groupBuyPriceEnd;
    private Set<Integer> groupBuyActivityIdSet;
    private Set<Integer> userIdSet;
    private GroupBuyActivityEntityExt groupBuyActivity;
    private UserEntityExt user;
    private String reference;
    private String number;
    
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
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
    public Double getGroupBuyPriceStart() {
        return groupBuyPriceStart;
    }
    public void setGroupBuyPriceStart(Double groupBuyPriceStart) {
        this.groupBuyPriceStart = groupBuyPriceStart;
    }
    public Double getGroupBuyPriceEnd() {
        return groupBuyPriceEnd;
    }
    public void setGroupBuyPriceEnd(Double groupBuyPriceEnd) {
        this.groupBuyPriceEnd = groupBuyPriceEnd;
    }
    public Set<Integer> getGroupBuyActivityIdSet() {
        return groupBuyActivityIdSet;
    }
    public void setGroupBuyActivityIdSet(Set<Integer> groupBuyActivityIdSet) {
        this.groupBuyActivityIdSet = groupBuyActivityIdSet;
    }
    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }
    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }
    public GroupBuyActivityEntityExt getGroupBuyActivity() {
        return groupBuyActivity;
    }
    public void setGroupBuyActivity(GroupBuyActivityEntityExt groupBuyActivity) {
        this.groupBuyActivity = groupBuyActivity;
    }
    public UserEntityExt getUser() {
        return user;
    }
    public void setUser(UserEntityExt user) {
        this.user = user;
    }
}
