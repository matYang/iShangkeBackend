package com.ishangke.edunav.manager.common;

public class Flag {
    
    private static volatile boolean SMS = false;
    private static volatile boolean hasSetSMS = false;
    
    public static boolean shouldSMS() {
        return SMS;
    }
    
    public static synchronized void setSMS(boolean sms) {
        if (!hasSetSMS) {
            SMS = sms;
            hasSetSMS = true;
        }
        else {
            throw new RuntimeException("SMS already set"); 
        }
    }

}
