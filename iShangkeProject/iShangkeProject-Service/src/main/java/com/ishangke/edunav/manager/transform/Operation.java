package com.ishangke.edunav.manager.transform;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "name","operateCode","url" })
public class Operation {
    private String name;
    private int operateCode;
    private String url;
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
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
