package com.ishangke.edunav.common.utilities.encoding;

import java.io.UnsupportedEncodingException;

public class UrlEncoding {
    public static String encodeURI(String var) throws UnsupportedEncodingException {
        return var == null ? null : java.net.URLEncoder.encode(var, "utf-8").replaceAll("\\+", "%20");
    }

    // js encodes space as %20 and + as +
    public static String decodeURI(String var) throws UnsupportedEncodingException {
        return var == null ? null : java.net.URLDecoder.decode(var, "utf-8");
    }
}
