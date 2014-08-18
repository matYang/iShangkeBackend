package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class LocationMap {
    public static Map<String, String> LOCATION_MAP;
    static {
        LOCATION_MAP = new HashMap<>();
        LOCATION_MAP.put("desc", "DESC");
        LOCATION_MAP.put("asc", "ASC");
    }
}
