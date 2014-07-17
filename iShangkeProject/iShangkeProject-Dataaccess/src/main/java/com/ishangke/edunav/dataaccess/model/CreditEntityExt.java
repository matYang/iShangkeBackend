package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;

import com.ishangke.edunav.dataaccess.model.gen.CreditEntity;

public class CreditEntityExt extends CreditEntity {
    private Integer idStart;
    private Integer idEnd;
    private Integer idSet;
    private Double creditStart;
    private Double creditEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
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
    public Integer getIdSet() {
        return idSet;
    }
    public void setIdSet(Integer idSet) {
        this.idSet = idSet;
    }
    public Double getCreditStart() {
        return creditStart;
    }
    public void setCreditStart(Double creditStart) {
        this.creditStart = creditStart;
    }
    public Double getCreditEnd() {
        return creditEnd;
    }
    public void setCreditEnd(Double creditEnd) {
        this.creditEnd = creditEnd;
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
