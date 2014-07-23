package com.ishangke.edunav.manager.transform;

import java.util.List;

public class CurrentStatus {
    private String name;
    private int statusCode;
    private List<Operation> operations;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public List<Operation> getOperations() {
        return operations;
    }
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
