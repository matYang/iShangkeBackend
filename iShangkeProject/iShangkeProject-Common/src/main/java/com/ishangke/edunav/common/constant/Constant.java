package com.ishangke.edunav.common.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final String STATUSTRANSFORM = "statusTransform";
    public static final int STATUSTRANSFORMEXPIRETIME = 29 * 24 * 60 * 60;
    public static final String STATUSTRANSFORMBOOKING = "booking";
    public static final String STATUSTRANSFORMCOURSE = "course";
    public static final String STATUSTRANSFORMCOURSETEMPLATE = "courseTemplate";
    
    //默认Group分组
    //如果不是partner admin，默认的情况下，group中的partner id 都是1
    //也就是说，对于partner来说，partner的id从2开始
    public static final int GROUPSYSTEMADMIN = 1;
    public static final int GROUPADMIN = 2;
    public static final int GROUPUSER = 3;
    
    public static final String GROUPPADMINSUFIX = "pAdmin";
    
    //用于状态转移
    public static final String ROLEPREFIX = "role";
    //用于权限控制
    public static final String ROLEIDPREFIX = "roleid";
    public static final String TRANSFORMACTION = "transformaction";
    public static final String TRANSFORMOPERATION = "transformoperation";
    public static final String ROLESYSTEMADMIN = "systemadmin";
    public static final String ROLEPARTNERADMIN = "partneradmin";
    public static final String ROLEADMIN = "admin";
    public static final String ROLEUSER = "user";
    public static final String ROLEPARTNERWENYUAN = "partnerwenyuan";
    public static final int ROLESYSTEMADMINID = 1;
    public static final int ROLEADMINID = 2;
    public static final int ROLEPARTNERADMINID = 3;
    public static final int ROLEUSERID = 4;
    public static final int ROLEPARTNERWENYUANID = 5;
    

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
    
    public static Map<String, Integer> COURSEOPERATEMAP;
    static {
        COURSEOPERATEMAP = new HashMap<String, Integer>();
        COURSEOPERATEMAP.put("submitNew", 0);
        COURSEOPERATEMAP.put("reject", 1);
        COURSEOPERATEMAP.put("approve", 2);
        COURSEOPERATEMAP.put("submitUpdated", 3);
        COURSEOPERATEMAP.put("delete", 4);
        COURSEOPERATEMAP.put("takeOffline", 5);
    }

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
    public static final int BOOKINGTYPESPECIALSELLING = 2;
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
    //根本就没有这个状态
//    public static final int BOOKINGSTATUSONLINEPAYMENTSUCCEEDED = 22;
    public static final int BOOKINGSTATUSOFFLINENOPAYED = 23;
    public static final int BOOKINGSTATUSOFFLINECASHBACKED = 24;
    public static final int  SPECIALPENDINGPAYMENT = 25;
    public static final int  SPECIALCANCELLED = 26;
    public static final int  SPECIALPAYED = 27;
    public static final int  SPECIALCONFIRMED = 28;
    public static final int  SPECIALENROLLED = 29;
    

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
    public static final int BOOKINGOPERATEONLINEPAYSUCCESS = 24;
    public static final int SPECIALSUBMITBOOKING = 25;
    public static final int SPECIALCONFIRM = 26;
    public static final int SPECIALENROLL = 27;
    public static final int BOOKINGOPERATIONCASHREWARD = 28;

    public static Map<String, Integer> BOOKINGOPERATEMAP;
    static {
        BOOKINGOPERATEMAP = new HashMap<String, Integer>();
        BOOKINGOPERATEMAP.put("onlineSubmitBooking", 0);
        BOOKINGOPERATEMAP.put("onlineCancel", 1);
        BOOKINGOPERATEMAP.put("offlineSubmitBooking", 2);
        BOOKINGOPERATEMAP.put("offlineCancel", 3);
        BOOKINGOPERATEMAP.put("offlineUserDelay", 4);
        BOOKINGOPERATEMAP.put("onlineConfirm", 5);
        BOOKINGOPERATEMAP.put("onlineReject", 6);
        BOOKINGOPERATEMAP.put("onlineNoShow", 7);
        BOOKINGOPERATEMAP.put("onlineQuit", 8);
        BOOKINGOPERATEMAP.put("onlineStartSchool", 9);
        BOOKINGOPERATEMAP.put("onlineEnroll", 10);
        BOOKINGOPERATEMAP.put("offlineConfirm", 11);
        BOOKINGOPERATEMAP.put("offlineReject", 12);
        BOOKINGOPERATEMAP.put("offlinePartnerDelay", 13);
        BOOKINGOPERATEMAP.put("offlineNoShow", 14);
        BOOKINGOPERATEMAP.put("offlineRegister", 15);
        BOOKINGOPERATEMAP.put("offlinePay", 16);
        BOOKINGOPERATEMAP.put("offlineNoPay", 17);
        BOOKINGOPERATEMAP.put("offlineQuit", 18);
        BOOKINGOPERATEMAP.put("offlineStartSchool", 19);
        BOOKINGOPERATEMAP.put("offlineEnroll", 20);
        BOOKINGOPERATEMAP.put("onlineRefund", 21);
        BOOKINGOPERATEMAP.put("onlineCashback", 22);
        BOOKINGOPERATEMAP.put("offlineCashback", 23);
        BOOKINGOPERATEMAP.put("onlinePaySuccess", 24);
        BOOKINGOPERATEMAP.put("specialSubmitBooking", 25);
        BOOKINGOPERATEMAP.put("specialConfirm", 26);
        BOOKINGOPERATEMAP.put("specialEnroll", 27);
        BOOKINGOPERATEMAP.put("cashReward", 28);
    }
    
    public static int DEFAULTANONYMOUSUSER = 1;
    
    //班级类型
    public static int COURSETYPEONEBYONE = 0;
    public static int COURSETYPESMALL = 1;
    public static int COURSETYPEMID = 2;
    public static int COURSETYPEBIG = 3;
    
    //标记成功
    public static final String SUCCESS = "success";
    
    //category
    public static final String CATEGORYCACHE = "CATEGORYCACHE";
    public static final int CATEGORYCACHETIME = 29 * 24 * 60 * 60;
    public static final int CATEGORYCACHEMAXLENGTH = 6;
    
    //order相关
    public static final int ORDERUNPAYED = 0;
    public static final int ORDERPAYEDSUCCESS = 1;
    public static final int ORDERPAYEDFAILED = 2;
    public static final int ORDEROPTPAY = 0;
    
    //course booking type
    public static final int COURSETYPEONLINEONLIY = 0;
    public static final int COURSETYPEOFFLINEONLY = 1;
    public static final int COURSETYPEBOTHONLINEOFFLINE = 2;
    //course 上课时间 上午/下午 平日/周末
    public static final int COURSESCHOOLTIMEMORNING = 1;
    public static final int COURSESCHOOLTIMEAFTERNOON = 2;
    public static final int COURSESCHOOLTIMEEVENING = 4;
    public static final int COURSESCHOOLWEEKDAY = 1;
    public static final int COURSESCHOOLWEEKEND = 2;
    
    //order
    public static final String ORDERPREFIX = "ISK-";
    public static final String ORDERSUBJECTPREFIX = "购买课程: ";
    public static final int ORDERSTATUSNOSUCCESS = 0;
    public static final int ORDERSTATUSSUCCESS = 1;
    //order操作
    public static final int ORDEROPTIONCREATE = 0;
    public static final int ORDEROPTIONPAY = 1;
    public static final int ORDEROPTIONPAYSUCCESS = 2;
    
    //credit
    public static final Double CREDITDEFAULTADD = 500.0;
    public static final int CREDITOPERATEBOOKINGSUCCESS = 0;
    
    //团购GroupBuyActivity
    public static final int GROUPBUYACTIVITYPENDINGONLINE = 0;
    public static final int GROUPBUYACTIVITYONLINE = 1;
    public static final int GROUPBUYACTIVITYOFFLINE = 2;
    public static final String GROUPBUYACTIVITYVIEWTOTAL = "groupbuyactivityviewtotal";
    
    //GroupBuyBooking
    public static final int GROUPBUYBOOKINGPENDINGPAYMENT = 0;
    public static final int GROUPBUYBOOKINGPAYED = 1;
    public static final int GROUPBUYBOOKINGQUITED = 2;
    public static final String GROUPBUYBOOKINGPREFIX = "ISK-GROUPBUY-";
    public static final String GROUPBUYTOTAL = "groupbuytotal";
    public static final String COURSEVIEWTOTAL = "courseviewtotal";
    
}
