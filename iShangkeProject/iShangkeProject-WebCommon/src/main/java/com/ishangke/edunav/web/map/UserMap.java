package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class UserMap {
    public static Map<String, String> USER_MAP;
    static {
        USER_MAP = new HashMap<>();
        USER_MAP.put("desc", "DESC");
        USER_MAP.put("asc", "ASC");
    }
}
