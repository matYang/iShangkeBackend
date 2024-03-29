package com.ishangke.edunav.manager.common;

import java.io.Serializable;

public final class SessionConfig {
    
    //cannot expire auth sessions, because auth sessions are chained in an arrayList, and while some can be expired, some cannot, too hard to determine
    public static int NON_AUTH_MEMCACHED_SESSION_EXPIRE = 60 * 60 * 24;  //let a non-auth session-related memcached entry expire 1 day after its creation, eg cell, forget password

    /*
     * config data for session control
     */
    public static class ACConfig {
        public static final String PREFIX = "acSession-";
        public static final int LOCKCOUNT = 5;
        public static final long LOCKTHRESHOLD = 90000l; // 1min 30s;
    }

    public static class AuthConfig {
        public static final String PREFIX = "authSession-";
        public static final int AUTHCODELENGTH = 15;
        public static final long UPDATETHRESHOLD = 259200000l; // 3 days
        public static final long EXPIRETHRESHOLD = 604800000l; // 7 days

        public static final int MAXRECORDS = 10;
        public static final int AUTOCLEARRECORDS = 20;

        public static final int CLIENT_WEB = 0;
        public static final int CLIENT_MOBILE = 1;
        public static final int CLIENT_WECHAT = 2;

    }

    public static class CellVerificationConfig {
        public static final String PREFIX = "cellVerification-";
        public static final int AUTHCODELENGTH = 6;
        public static final long RESENDTHRESHOLD = 60000l; // 1min
        public static final long EXPIRETHRESHOLD = 300000l; // 5min
    }

    public static class ForgetPasswordConfig {
        public static final String PREFIX = "forgetPassword-";
        public static final int AUTHCODELENGTH = 6;
        public static final long RESENDTHRESHOLD = 60000l; // 1min
        public static final long EXPIRETHRESHOLD = 600000l; // 10min
    }
    
    public static class QloginVerificationConfig {
        public static final String PREFIX = "qloginVerification-";
        public static final int AUTHCODELENGTH = 6;
        public static final long RESENDTHRESHOLD = 60000l; // 1min
        public static final long EXPIRETHRESHOLD = 300000l; // 5min
    }

    /**
     * serializable data ligh-weighted classes used to be stored in memcached
     * server
     */
    public static class ACConfigObj implements Serializable {
        private static final long serialVersionUID = -3439356315077775927L;

        public int count;
        public long timeStamp;
    }

    public static class AuthConfigObj implements Serializable {
        private static final long serialVersionUID = 2796480960178953158L;

        public String authCode;
        public long timeStamp;
        public int client;
    }

    public static class CellVerificationConfigObj implements Serializable {
        private static final long serialVersionUID = 8022096811231164619L;

        public String authCode;
        public long timeStamp;
    }

    public static class ForgetPasswordConfigObj implements Serializable {
        private static final long serialVersionUID = -9146948343673617643L;

        public String authCode;
        public long timeStamp;
    }
    
    public static class QloginVerificationConfigObj implements Serializable {
        private static final long serialVersionUID = -9146948343673617643L;

        public String authCode;
        public long timeStamp;
    }

}
