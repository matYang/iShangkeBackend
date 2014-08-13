package com.ishangke.edunav.common.constant;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import com.ishangke.edunav.common.utilities.DateUtility;

public final class FileSetting {

    public static final String SEPERATOR = "-";

    public static final String IMGFILEFORMAT = "png";

    public static class Prefix {

        public static final String LOGO = "logo";

        public static final String TEACHER = "teacher";

        public static final String CLASSPHOTO = "classPhoto";

        public static final String CLASSPHOTO_SNAPSHOT = "classPhotoSnapShot";
    }

    public static final String getCheckSumString(byte[] b) {
        String result = "";

        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    public static final String assembleName(String prefix, int partnerId, int initiatorId, String checkSum) {
        return prefix + "p" + partnerId + "i" + initiatorId + "t" + DateUtility.getCurTime() + SEPERATOR + checkSum;
    }

    public static BufferedImage bufferDeepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

}
