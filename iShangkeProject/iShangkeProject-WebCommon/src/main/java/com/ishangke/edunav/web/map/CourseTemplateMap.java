package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class CourseTemplateMap {
    public static Map<String, String> COURSE_TEMPLATE_MAP;
    static {
        COURSE_TEMPLATE_MAP = new HashMap<>();
        COURSE_TEMPLATE_MAP.put("desc", "DESC");
        COURSE_TEMPLATE_MAP.put("ASC", "ASC");
        COURSE_TEMPLATE_MAP.put("lastModifyTime", "LAST_MODIFY_TIME");
    }
}
