package com.ishangke.edunav.manager.transform;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "name", "groupCode", "entitys" })
public class TransformGroup {
    private String name;
    private int groupCode;
    private List<StatusEntity> entitys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(int groupCode) {
        this.groupCode = groupCode;
    }

    public List<StatusEntity> getEntitys() {
        return entitys;
    }

    public void setEntitys(List<StatusEntity> entitys) {
        this.entitys = entitys;
    }

}
