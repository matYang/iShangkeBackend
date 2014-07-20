package com.ishangke.edunav.manager.common;

public class ForgetPassword {
    public static final String PREFIX = "forgetPassword-";
    public static final int AUTHCODELENGTH = 6;
    public static final long RESENDTHRESHOLD = 60000l; // 1min
    public static final long EXPIRETHRESHOLD = 300000l; // 5min
}
