package com.ishangke.edunav.thrift;

public class ThriftClientSetting {
    private String name;
    private String host;
    private int port;
    private Class<?> clientClass;
    private String classString;

    public ThriftClientSetting() {
        super();
    }

    public ThriftClientSetting(String name, String host, int port, Class<?> clientClass) {
        super();
        this.name = name;
        this.host = host;
        this.port = port;
        this.clientClass = clientClass;
    }

    public ThriftClientSetting(String name, String host, int port, String classString) {
        super();
        this.name = name;
        this.host = host;
        this.port = port;
        this.classString = classString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Class<?> getClientClass() {
        return clientClass;
    }

    public void setClientClass(Class<?> clientClass) {
        this.clientClass = clientClass;
    }

    public String getClassString() {
        return classString;
    }

    public void setClassString(String classString) {
        this.classString = classString;
    }
}
