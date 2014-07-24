package com.ishangke.edunav.manager.transform;

import java.io.Serializable;
import java.util.List;


public class Operation implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 6287315414692638993L;
    private String name;
    private Integer operateCode;
    private Integer nextStatus;
    private List<String> toDos;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getOperateCode() {
        return operateCode;
    }
    public void setOperateCode(Integer operateCode) {
        this.operateCode = operateCode;
    }
    public Integer getNextStatus() {
        return nextStatus;
    }
    public void setNextStatus(Integer nextStatus) {
        this.nextStatus = nextStatus;
    }
    public List<String> getToDos() {
        return toDos;
    }
    public void setToDos(List<String> toDos) {
        this.toDos = toDos;
    }
}
