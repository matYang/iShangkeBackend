package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class CareerMap {
    public static Map<String, String> CAREER_MAP;
    static {
        CAREER_MAP = new HashMap<>();
        CAREER_MAP.put("desc", "DESC");
        CAREER_MAP.put("asc", "ASC");
    }
}
