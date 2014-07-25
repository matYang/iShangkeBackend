package com.ishangke.edunav.common;

import com.ishangke.edunav.commoncontract.service.ConfigurationService;

public class ConfigurationClientSetting {
    private static ConfigurationClientSetting setting = null;

    private String host;
    private int port;
    private Class<?> clientClass;

    public static ConfigurationClientSetting getSetting() {
        return setting;
    }

    public static void setSetting(ConfigurationClientSetting setting) {
        ConfigurationClientSetting.setting = setting;
    }

    public ConfigurationClientSetting() {
        super();
    }

    public ConfigurationClientSetting(String host, int port) {
        super();
        this.host = host;
        this.port = port;
    }

    public ConfigurationClientSetting(String host, int port, String clientClass) {
        super();
        this.host = host;
        this.port = port;
        this.clientClass = ConfigurationService.Client.class;
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
}
