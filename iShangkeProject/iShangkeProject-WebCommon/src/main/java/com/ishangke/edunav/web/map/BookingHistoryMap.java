package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class BookingHistoryMap {
    public static Map<String, String> BOOKINGHISTORY_MAP;
    static {
        BOOKINGHISTORY_MAP = new HashMap<>();
        BOOKINGHISTORY_MAP.put("desc", "DESC");
        BOOKINGHISTORY_MAP.put("asc", "ASC");
        BOOKINGHISTORY_MAP.put("lastModifyTime", "LAST_MODIFY_TIME");
        BOOKINGHISTORY_MAP.put("createTime", "CREATE_TIME");
    }
}
