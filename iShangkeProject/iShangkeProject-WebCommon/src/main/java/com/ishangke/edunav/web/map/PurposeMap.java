package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class PurposeMap {
    public static Map<String, String> PURPOSE_MAP;
    static {
        PURPOSE_MAP = new HashMap<>();
        PURPOSE_MAP.put("desc", "DESC");
        PURPOSE_MAP.put("asc", "ASC");
        PURPOSE_MAP.put("createTime", "CREATE_TIME");
    }
}
