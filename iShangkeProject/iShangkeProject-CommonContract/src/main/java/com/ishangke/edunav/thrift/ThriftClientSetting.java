package com.ishangke.edunav.thrift;

public class ThriftClientSetting {
    private String name;
    private int port;

    public ThriftClientSetting(String name, int port) {
        super();
        this.name = name;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
