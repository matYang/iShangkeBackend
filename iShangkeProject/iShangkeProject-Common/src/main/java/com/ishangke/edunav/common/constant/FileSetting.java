package com.ishangke.edunav.common.constant;

import com.ishangke.edunav.common.utilities.DateUtility;

public final class FileSetting {

    public static final String SEPERATOR = "-";
    
    public static final String IMGFILEFORMAT = "jpg";

    public static class Prefix {

        public static final String LOGO = "logo";

        public static final String TEACHER = "teacher";

        public static final String CLASSPHOTO = "classPhoto";
    }

    public static final String getCheckSumString(byte[] b) {
        String result = "";

        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    public static final String assembleName(String prefix, int partnerId, int initiatorId, String checkSum) {
        return prefix + SEPERATOR + "p" + partnerId + SEPERATOR + "i" + initiatorId + SEPERATOR + checkSum + SEPERATOR + DateUtility.getCurTime();
    }
}