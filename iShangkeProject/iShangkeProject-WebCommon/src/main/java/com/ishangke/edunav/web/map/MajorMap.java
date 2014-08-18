package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class MajorMap {
    public static Map<String, String> MAJOR_MAP;
    static {
        MAJOR_MAP = new HashMap<>();
        MAJOR_MAP.put("desc", "DESC");
        MAJOR_MAP.put("asc", "ASC");
    }
}
