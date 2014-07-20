package com.ishangke.edunav.manager.common;

public final class SessionConfig {

    public static class ACConfig {
        public static final String PREFIX = "acSession-";
        public static final int lockCount = 5;
        public static final long lockThreshold = 90000l; // 1min 30s;
    }

    public static class AuthConfig {

        public static final String PREFIX = "authSession-";
        public static final int AUTHCODELENGTH = 15;
        public static final long UPDATETHRESHOLD = 259200000l; // 3 days
        public static final long EXPIRETHRESHOLD = 604800000l; // 7 days

        public static final String CLIENT_WEB = "web";
        public static final String CLIENT_MOBILE = "mobile";
        public static final String CLIENT_WECHAR = "wechat";

    }

    public static class CellVerificationConfig {
        public static final String PREFIX = "cellVerification-";
        public static final int AUTHCODELENGTH = 6;
        public static final long RESENDTHRESHOLD = 60000l; // 1min
        public static final long EXPIRETHRESHOLD = 300000l; // 5min
    }

    public static class ForgetPassword {
        public static final String PREFIX = "forgetPassword-";
        public static final int AUTHCODELENGTH = 6;
        public static final long RESENDTHRESHOLD = 60000l; // 1min
        public static final long EXPIRETHRESHOLD = 600000l; // 10min
    }

}
