package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.OrderHistoryEntity;

public class OrderHistoryEntityExt extends OrderHistoryEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Set<Integer> orderIdSet;
    private Set<Integer> userIdSet;
    private Set<Integer> optNameSet;
    private Set<Integer> preStatusSet;
    private Set<Integer> postStatusSet;
    private Set<Integer> normalSet;
   
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    public Integer getIdStart() {
        return idStart;
    }
    public void setIdStart(Integer idStart) {
        this.idStart = idStart;
    }
    public Integer getIdEnd() {
        return idEnd;
    }
    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
    }
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Set<Integer> getOrderIdSet() {
        return orderIdSet;
    }
    public void setOrderIdSet(Set<Integer> orderIdSet) {
        this.orderIdSet = orderIdSet;
    }
    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }
    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }
    public Set<Integer> getOptNameSet() {
        return optNameSet;
    }
    public void setOptNameSet(Set<Integer> optNameSet) {
        this.optNameSet = optNameSet;
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
    public Set<Integer> getNormalSet() {
        return normalSet;
    }
    public void setNormalSet(Set<Integer> normalSet) {
        this.normalSet = normalSet;
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
