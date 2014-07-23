package com.ishangke.edunav.manager.transform;

import java.util.List;

public class StatusEntity {
    private String name;
    private int entityCode;
    private List<CurrentStatus> currentStatuses;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEntityCode() {
        return entityCode;
    }
    public void setEntityCode(int entityCode) {
        this.entityCode = entityCode;
    }
    public List<CurrentStatus> getCurrentStatuses() {
        return currentStatuses;
    }
    public void setCurrentStatuses(List<CurrentStatus> currentStatuses) {
        this.currentStatuses = currentStatuses;
    }
}
