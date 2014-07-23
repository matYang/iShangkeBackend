package com.ishangke.edunav.manager.transform;

import java.util.List;


public class Operation {
    private String name;
    private int operateCode;
    private int nextStatus;
    private List<String> toDos;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getOperateCode() {
        return operateCode;
    }
    public void setOperateCode(int operateCode) {
        this.operateCode = operateCode;
    }
    public int getNextStatus() {
        return nextStatus;
    }
    public void setNextStatus(int nextStatus) {
        this.nextStatus = nextStatus;
    }
    public List<String> getToDos() {
        return toDos;
    }
    public void setToDos(List<String> toDos) {
        this.toDos = toDos;
    }
}
