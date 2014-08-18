package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class AddressMap {
    public static Map<String, String> ADDRESS_MAP;
    static {
        ADDRESS_MAP = new HashMap<>();
        ADDRESS_MAP.put("desc", "DESC");
        ADDRESS_MAP.put("asc", "ASC");
    }
}
