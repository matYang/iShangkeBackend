package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.AccountHistoryEntity;

public class AccountHistoryEntityExt extends AccountHistoryEntity {

    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Integer userIdStart;
    private Integer userIdEnd;
    private Set<Integer> userIdSets;
    private Integer withdrawIdStart;
    private Integer withdrawIdEnd;
    private Double chargeStart;
    private Double chargeEnd;
    private Integer typeStart;
    private Integer typeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    
    
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Set<Integer> getUserIdSets() {
        return userIdSets;
    }
    public void setUserIdSets(Set<Integer> userIdSets) {
        this.userIdSets = userIdSets;
    }
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
    public Integer getUserIdStart() {
        return userIdStart;
    }
    public void setUserIdStart(Integer userIdStart) {
        this.userIdStart = userIdStart;
    }
    public Integer getUserIdEnd() {
        return userIdEnd;
    }
    public void setUserIdEnd(Integer userIdEnd) {
        this.userIdEnd = userIdEnd;
    }
    public Integer getWithdrawIdStart() {
        return withdrawIdStart;
    }
    public void setWithdrawIdStart(Integer withdrawIdStart) {
        this.withdrawIdStart = withdrawIdStart;
    }
    public Integer getWithdrawIdEnd() {
        return withdrawIdEnd;
    }
    public void setWithdrawIdEnd(Integer withdrawIdEnd) {
        this.withdrawIdEnd = withdrawIdEnd;
    }
    public Double getChargeStart() {
        return chargeStart;
    }
    public void setChargeStart(Double chargeStart) {
        this.chargeStart = chargeStart;
    }
    public Double getChargeEnd() {
        return chargeEnd;
    }
    public void setChargeEnd(Double chargeEnd) {
        this.chargeEnd = chargeEnd;
    }
    public Integer getTypeStart() {
        return typeStart;
    }
    public void setTypeStart(Integer typeStart) {
        this.typeStart = typeStart;
    }
    public Integer getTypeEnd() {
        return typeEnd;
    }
    public void setTypeEnd(Integer typeEnd) {
        this.typeEnd = typeEnd;
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
