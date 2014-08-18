package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class PartnerMap {
    public static Map<String, String> PARTNER_MAP;
    static {
        PARTNER_MAP = new HashMap<>();
        PARTNER_MAP.put("desc", "DESC");
        PARTNER_MAP.put("asc", "ASC");
    }
}
