package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class BookingMap {
    public static Map<String, String> BOOKING_MAP;
    static {
        BOOKING_MAP = new HashMap<>();
        BOOKING_MAP.put("desc", "DESC");
        BOOKING_MAP.put("asc", "ASC");
        BOOKING_MAP.put("lastModifyTime", "LAST_MODIFY_TIME");
    }
}
