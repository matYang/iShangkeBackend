package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CategoryEntity;

public class CategoryEntityExt extends CategoryEntity {
    private Set<Integer> idSet;
    private Integer rankStart;
    private Integer rankEnd;
    private Set<Integer> rankSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;

    public Set<Integer> getRankSet() {
        return rankSet;
    }

    public void setRankSet(Set<Integer> rankSet) {
        this.rankSet = rankSet;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Integer getRankStart() {
        return rankStart;
    }

    public void setRankStart(Integer rankStart) {
        this.rankStart = rankStart;
    }

    public Integer getRankEnd() {
        return rankEnd;
    }

    public void setRankEnd(Integer rankEnd) {
        this.rankEnd = rankEnd;
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
