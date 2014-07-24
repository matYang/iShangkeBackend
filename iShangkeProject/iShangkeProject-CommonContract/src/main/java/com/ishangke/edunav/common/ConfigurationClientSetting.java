package com.ishangke.edunav.common;

public class ConfigurationClientSetting {
    private static ConfigurationClientSetting setting = null;

    private String host;
    private int port;

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
}
