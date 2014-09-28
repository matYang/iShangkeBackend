package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class GroupBuyActivityMap {
    public static Map<String, String> GROUPBUYACTIVITY_MAP;
    static {
        GROUPBUYACTIVITY_MAP = new HashMap<>();
        GROUPBUYACTIVITY_MAP.put("desc", "DESC");
        GROUPBUYACTIVITY_MAP.put("asc", "ASC");
        GROUPBUYACTIVITY_MAP.put("createTime", "CREATE_TIME");
        GROUPBUYACTIVITY_MAP.put("endTime", "END_TIME");
        GROUPBUYACTIVITY_MAP.put("courseId", "COURSE_ID");
        GROUPBUYACTIVITY_MAP.put("title", "TITLE");
        GROUPBUYACTIVITY_MAP.put("groupBuyPrice", "GROUP_BUY_PRICE");
    }
}
