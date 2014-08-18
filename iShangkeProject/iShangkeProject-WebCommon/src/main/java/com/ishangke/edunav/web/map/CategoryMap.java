package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class CategoryMap {
    public static Map<String, String> CATEGORY_MAP;
    static {
        CATEGORY_MAP = new HashMap<>();
        CATEGORY_MAP.put("desc", "DESC");
        CATEGORY_MAP.put("asc", "ASC");
    }
}
