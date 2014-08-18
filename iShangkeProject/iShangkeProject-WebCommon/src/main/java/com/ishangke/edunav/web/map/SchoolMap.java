package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class SchoolMap {
    public static Map<String, String> SCHOOL_MAP;
    static {
        SCHOOL_MAP = new HashMap<>();
        SCHOOL_MAP.put("desc", "DESC");
        SCHOOL_MAP.put("asc", "ASC");
    }
}
