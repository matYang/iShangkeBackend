package com.ishangke.edunav.web.map;

import java.util.Map;

public class CourseCommentMap {
    public static Map<String, String> COMMENT_MAP;
    static {
        COMMENT_MAP.put("desc", "DESC");
        COMMENT_MAP.put("asc", "ASC");
        COMMENT_MAP.put("courseTemplateId", "COURSE_TEMPLATE_ID");
        COMMENT_MAP.put("userId", "USER_ID");
        COMMENT_MAP.put("createTime", "CREATE_TIME");
        COMMENT_MAP.put("totalRating", "TOTAL_ATING");
        COMMENT_MAP.put("conditionRating", "CONDITION_RATING");
        COMMENT_MAP.put("attitudeRating", "ATTITUDE_RATING");
        COMMENT_MAP.put("satisfactionRating", "SATISFACTION_RATING");
    }
}
