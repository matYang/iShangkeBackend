package com.ishangke.edunav.web.map;

import java.util.HashMap;
import java.util.Map;

public class GroupBuyBookingMap {
    public static Map<String, String> GROUPBUYBOOKING_MAP;
    static {
        GROUPBUYBOOKING_MAP = new HashMap<>();
        GROUPBUYBOOKING_MAP.put("desc", "DESC");
        GROUPBUYBOOKING_MAP.put("asc", "ASC");
        GROUPBUYBOOKING_MAP.put("createTime", "CREATE_TIME");
        GROUPBUYBOOKING_MAP.put("status","STATUS");
        GROUPBUYBOOKING_MAP.put("groupBuyPrice","GROUP_BUY_PRICE");
        GROUPBUYBOOKING_MAP.put("groupBuyActivityId","GROUP_BUY_ACTIVITY_ID");
        GROUPBUYBOOKING_MAP.put("userId","USER_ID");
        GROUPBUYBOOKING_MAP.put("reference","REFERENCE");
        GROUPBUYBOOKING_MAP.put("number","NUMBER");

    }
}
