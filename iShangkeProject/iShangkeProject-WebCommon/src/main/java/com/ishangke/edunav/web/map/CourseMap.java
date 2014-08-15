package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class CourseMap {
    public static Map<String, String> COURSE_MAP;
    static {
        COURSE_MAP = new HashMap<>();
        COURSE_MAP.put("desc", "DESC");
        COURSE_MAP.put("asc", "ASC");
        COURSE_MAP.put("price", "PRICE");
        COURSE_MAP.put("startDate", "START_DATE");
        COURSE_MAP.put("lastModifyTime", "LAST_MODIFY_TIME");
    }
}
