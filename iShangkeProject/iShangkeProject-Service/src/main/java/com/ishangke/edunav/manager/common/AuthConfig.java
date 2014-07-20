package com.ishangke.edunav.manager.common;

public class AuthConfig {

    public static final String PREFIX = "authSession-";
    public static final int AUTHCODELENGTH = 15;
    public static final long UPDATETHRESHOLD = 259200000l; // 3 days
    public static final long EXPIRETHRESHOLD = 604800000l; // 7 days

    public static final String CLIENT_WEB = "web";
    public static final String CLIENT_MOBILE = "mobile";
    public static final String CLIENT_WECHAR = "wechat";

}
