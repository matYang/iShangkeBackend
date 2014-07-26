package com.ishangke.edunav.common.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final String STATUSTRANSFORM = "statusTransform";
    public static final int STATUSTRANSFORMEXPIRETIME = 29 * 24 * 60 * 60;
    public static final String STATUSTRANSFORMBOOKING = "booking";
    public static final String STATUSTRANSFORMCOURSE = "course";
    public static final String STATUSTRANSFORMCOURSETEMPLATE = "coursetemplate";
    
    //默认Group分组
    //如果不是partner admin，默认的情况下，group中的partner id 都是1
    //也就是说，对于partner来说，partner的id从2开始
    public static final int GROUPSYSTEMADMIN = 1;
    public static final int GROUPADMIN = 2;
    public static final int GROUPUSER = 3;
    
    public static final String GROUPPADMINSUFIX = "pAdmin";
    
    //用于状态转移
    public static final String ROLEPREFIX = "role";
    public static final String TRANSFORMACTION = "transformaction";
    public static final String TRANSFORMOPERATION = "transformoperation";
    public static final String ROLESYSTEMADMIN = "systemadmin";
    public static final String ROLEPARTNERADMIN = "partneradmin";
    public static final String ROLEADMIN = "admin";
    public static final String ROLEUSER = "user";
    public static final int ROLESYSTEMADMINID = 1;
    public static final int ROLEADMINID = 2;
    public static final int ROLEPARTNERADMINID = 3;
    public static final int ROLEUSERID = 4;
    

    // very important !! transform null by thrift
    public static final int DEFAULTNULL = -1;

    // booking 是否异常
    public static final int BOOKINGNORMAL = 0;
    public static final int BOOKINGUNNORMAL = 1;

    // course操作
    public static final int COURSEOPERATIONSUBMITNEW = 0;
    public static final int COURSEOPERATIONREJECT = 1;
    public static final int COURSEOPERATIONAPPROVE = 2;
    public static final int COURSEOPERATIONSUBMITUPDATED = 3;
    public static final int COURSEOPERATIONDELETE = 4;
    public static final int COURSEOPERATIONTAKEOFFLINE = 5;

    // course状态
    public static final int COURSESTATUSPENDINGREVIEW = 0;
    public static final int COURSESTATUSFAILED = 1;
    public static final int COURSESTATUSONLINED = 2;
    public static final int COURSESTATUSOFFLINED = 3;
    public static final int COURSESTATUSDELETED = 4;
    public static final int COURSESTATUSSUBMITNEW = 5;
    public static final int COURSESTATUSUPDATED = 6;

    // 订单类型
    public static final int BOOKINGTYPEONLINE = 0;
    public static final int BOOKINGTYPEOFFLINE = 1;
    // todo other type

    // 订单状态
    public static final int BOOKINGSTATUSOFFLINEBOOKED = 0;
    public static final int BOOKINGSTATUSOFFLINEREJECTED = 1;
    public static final int BOOKINGSTATUSOFFLINECANCELLED = 2;
    public static final int BOOKINGSTATUSOFFLINECONFIRMED = 3;
    public static final int BOOKINGSTATUSOFFLINEDELAYED = 4;
    public static final int BOOKINGSTATUSOFFLINENOSHOW = 5;
    public static final int BOOKINGSTATUSOFFLINEREGISTERED = 6;
    public static final int BOOKINGSTATUSOFFLINEPAYED = 7;
    public static final int BOOKINGSTATUSOFFLINESCHOOLSTARTED = 8;
    public static final int BOOKINGSTATUSOFFLINEQUITED = 9;
    public static final int BOOKINGSTATUSOFFLINEENROLLED = 10;
    public static final int BOOKINGSTATUSONLINEPENDINGPAYMENT = 11;
    public static final int BOOKINGSTATUSONLINECANCELLED = 12;
    public static final int BOOKINGSTATUSONLINEPAYED = 13;
    public static final int BOOKINGSTATUSONLINEPENDINGREFUND = 14;
    public static final int BOOKINGSTATUSONLINEREFUNDED = 15;
    public static final int BOOKINGSTATUSONLINEPARTNERCONFIRMED = 16;
    public static final int BOOKINGSTATUSONLINESCHOOLSTARTED = 17;
    public static final int BOOKINGSTATUSONLINEENROLLED = 18;
    public static final int BOOKINGSTATUSONLINECASHBACKED = 19;
    public static final int BOOKINGSTATUSONLINEPAYMENTEXPIRED = 20;
    public static final int BOOKINGSTATUSONLINEPAYMENFAILED = 21;
    public static final int BOOKINGSTATUSONLINEPAYMENTSUCCEEDED = 22;
    public static final int BOOKINGSTATUSOFFLINENOPAYED = 23;
    public static final int BOOKINGSTATUSOFFLINECASHBACKED = 24;

    // 订单操作
    public static final int BOOKINGOPERATIONONLINESUBMITBOOKING = 0;
    public static final int BOOKINGOPERATIONONLINECANCEL = 1;
    public static final int BOOKINGOPERATIONOFFLINESUBMITBOOKING = 2;
    public static final int BOOKINGOPERATIONOFFLINECANCEL = 3;
    public static final int BOOKINGOPERATIONOFFLINEUSERDELAY = 4;
    public static final int BOOKINGOPERATIONONLINECONFIRM = 5;
    public static final int BOOKINGOPERATIONONLINEREJECT = 6;
    public static final int BOOKINGOPERATIONONLINENOSHOW = 7;
    public static final int BOOKINGOPERATIONONLINEQUIT = 8;
    public static final int BOOKINGOPERATIONONLINESTARTSCHOOL = 9;
    public static final int BOOKINGOPERATIONONLINEENROLL = 10;
    public static final int BOOKINGOPERATIONOFFLINECONFIRM = 11;
    public static final int BOOKINGOPERATIONOFFLINEREJECT = 12;
    public static final int BOOKINGOPERATIONOFFLINEPARTNERDELAY = 13;
    public static final int BOOKINGOPERATIONOFFLINENOSHOW = 14;
    public static final int BOOKINGOPERATIONOFFLINEREGISTER = 15;
    public static final int BOOKINGOPERATIONOFFLINEPAY = 16;
    public static final int BOOKINGOPERATIONOFFLINENOPAY = 17;
    public static final int BOOKINGOPERATIONOFFLINEQUIT = 18;
    public static final int BOOKINGOPERATIONOFFLINESTARTSCHOOL = 19;
    public static final int BOOKINGOPERATIONOFFLINEENROLL = 20;
    public static final int BOOKINGOPERATIONONLINEREFUND = 21;
    public static final int BOOKINGOPERATIONONLINECASHBACK = 22;
    public static final int BOOKINGOPERATIONOFFLINECASHBACK = 23;

    public static Map<Integer, String> BOOKINGOPERATEMAP;
    static {
        BOOKINGOPERATEMAP = new HashMap<Integer, String>();
        BOOKINGOPERATEMAP.put(0, "onlineSubmitBooking");
        BOOKINGOPERATEMAP.put(1, "onlineCancel");
        BOOKINGOPERATEMAP.put(2, "offlineSubmitBooking");
        BOOKINGOPERATEMAP.put(3, "offlineCancel");
        BOOKINGOPERATEMAP.put(4, "offlineUserDelay");
        BOOKINGOPERATEMAP.put(5, "onlineConfirm");
        BOOKINGOPERATEMAP.put(6, "onlineReject");
        BOOKINGOPERATEMAP.put(7, "onlineNoShow");
        BOOKINGOPERATEMAP.put(8, "onlineQuit");
        BOOKINGOPERATEMAP.put(9, "onlineStartSchool");
        BOOKINGOPERATEMAP.put(10, "onlineEnroll");
        BOOKINGOPERATEMAP.put(11, "offlineConfirm");
        BOOKINGOPERATEMAP.put(12, "offlineReject");
        BOOKINGOPERATEMAP.put(13, "offlinePartnerDelay");
        BOOKINGOPERATEMAP.put(14, "offlineNoShow");
        BOOKINGOPERATEMAP.put(15, "offlineRegister");
        BOOKINGOPERATEMAP.put(16, "offlinePay");
        BOOKINGOPERATEMAP.put(17, "offlineNoPay");
        BOOKINGOPERATEMAP.put(18, "offlineQuit");
        BOOKINGOPERATEMAP.put(19, "offlineStartSchool");
        BOOKINGOPERATEMAP.put(20, "offlineEnroll");
        BOOKINGOPERATEMAP.put(21, "onlineRefund");
        BOOKINGOPERATEMAP.put(22, "onlineCashback");
        BOOKINGOPERATEMAP.put(23, "offlineCashback");
    }
    
    //班级类型
    public static int COURSETYPEONEBYONE = 0;
    public static int COURSETYPESMALL = 1;
    public static int COURSETYPEMID = 2;
    public static int COURSETYPEBIG = 3;
}
