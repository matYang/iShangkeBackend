package com.ishangke.edunav.thrift;

public class ThriftServerSetting {
    private String name;
    private String host;
    private int port;
    private Class<?> clientClass;
    private String processorClass;

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

    public String getProcessorClass() {
        return processorClass;
    }

    public void setProcessorClass(String processorClass) {
        this.processorClass = processorClass;
    }

}
