package com.ishangke.edunav.manager.common;

public class ManagerErrorCode {
    public static final int DEFAULT_SUCCESS = 0x00000000;
    public static final String DEFAULT_SUCCESS_KEY = "success";
    public static final int DEFAULT_ERROR = 0x00000001;
    public static final String DEFAULT_ERROR_KEY = "error";

    // user
    public static final int USER_REGISTER_ERROR = 0x00010001;
    public static final String USER_REGISTER_ERROR_KEY = "user_register_error";
    public static final int USER_CREATE_ERROR = 0x00010002;
    public static final String USER_CREATE_ERROR_KEY = "user_create_error";
    public static final int USER_LOGIN_ERROR = 0x00010003;
    public static final String USER_LOGIN_ERROR_KEY = "user_login_error";
    public static final int USER_DELETE_ERROR = 0x00010004;
    public static final String USER_DELETE_ERROR_KEY = "user_delete_error";
    public static final int USER_UPDATE_ERROR = 0x00010005;
    public static final String USER_UPDATE_ERROR_KEY = "user_update_error";
    public static final int USER_QUERY_ERROR = 0x00010006;
    public static final String USER_QUERY_ERROR_KEY = "user_query_error";
    public static final int USER_QUERYINFO_ERROR = 0X00010007;
    public static final String USER_QUERYINFO_ERROR_KEY = "user_queryinfo_error";
    public static final int USER_QUERYSESSION_ERROR = 0x00010008;
    public static final String USER_QUERYSESSION_ERROR_KEY = "user_querysession_error";
    public static final int USER_DISPOSESESSION_ERROR = 0X00010009;
    public static final String USER_DISPOSESESSION_ERROR_KEY = "user_disposesession_error";
    public static final int USER_NOTFOUND_ERROR = 0x00010404;
    public static final String USER_NOTFOUND_ERROR_KEY = "user_notfound_error";

    // course
    public static final int COURSE_CREATE_ERROR = 0x00020001;
    public static final String COURSE_CREATE_ERROR_KEY = "course_create_error";
    public static final int COURSE_SUBMIT_ERROR = 0x00020002;
    public static final String COURSE_SUBMIT_ERROR_KEY = "course_submit_error";
    public static final int COURSE_APPROVE_ERROR = 0x00020003;
    public static final String COURSE_APPROVE_ERROR_KEY = "course_approve_error";
    public static final int COURSE_REJECT_ERROR = 0x00020004;
    public static final String COURSE_REJECT_ERROR_KEY = "course_reject_error";
    public static final int COURSE_CANCEL_ERROR = 0x00020005;
    public static final String COURSE_CANCEL_ERROR_KEY = "course_cancel_error";
    public static final int COURSE_RESUBMIT_ERROR = 0x00020006;
    public static final String COURSE_RESUBMIT_ERROR_KEY = "course_resubmit_error";
    public static final int COURSE_DELETE_ERROR = 0x00020007;
    public static final String COURSE_DELETE_ERROR_KEY = "course_delete_error";
    public static final int COURSE_UPDATE_ERROR = 0x00020008;
    public static final String COURSE_UPDATE_ERROR_KEY = "course_update_error";
    public static final int COURSE_COMMENT_ERROR = 0x00020009;
    public static final String COURSE_COMMENT_ERROR_KEY = "course_comment_error";
    public static final int COURSE_QUERYBYKEYWORD_ERROR = 0x0002000A;
    public static final String COURSE_QUERYBYKEYWORD_ERROR_KEY = "course_querybykeyword_error";
    public static final int COURSE_QUERYBYPARTNER_ERROR = 0x0002000B;
    public static final String COURSE_QUERYBYPARTNER_ERROR_KEY = "course_querybypartner_error";
    public static final int COURSE_QUERYBYFILTER_ERROR = 0x0002000C;
    public static final String COURSE_QUERYBYFILTER_ERROR_KEY = "course_querybyfilter_error";
    public static final int COURSE_NOTFOUND_ERROR = 0x00020404;
    public static final String COURSE_NOTFOUND_ERROR_KEY = "course_notfound_error";
    
    //courseTemplate
    public static final int COURSETEMPLATEBO_CREATE_ERROR = 0x00030001;
    public static final String COURSETEMPLATEBO_CREATE_ERROR_KEY = "coursetemplatebo_create_error";
    public static final int COURSETEMPLATE_SUBMIT_ERROR = 0x00030002;
    public static final String COURSETEMPLATE_SUBMIT_ERROR_KEY = "coursetemplate_submit_error";
    public static final int COURSETEMPLATE_APPROVE_ERROR = 0x00030003;
    public static final String COURSETEMPLATE_APPROVE_ERROR_KEY = "coursetemplate_approve_error";
    public static final int COURSETEMPLATE_REJECT_ERROR = 0x00030004;
    public static final String COURSETEMPLATE_REJECT_ERROR_KEY = "coursetemplate_reject_error";
    public static final int COURSETEMPLATE_CANCEL_ERROR = 0x00030005;
    public static final String COURSETEMPLATE_CANCEL_ERROR_KEY = "coursetemplate_cancel_error";
    public static final int COURSETEMPLATE_RESUBMIT_ERROR = 0x00030006;
    public static final String COURSETEMPLATE_RESUBMIT_ERROR_KEY = "coursetemplate_resubmit_error";
    public static final int COURSETEMPLATE_DELETE_ERROR = 0x00030007;
    public static final String COURSETEMPLATE_DELETE_ERROR_KEY = "coursetemplate_delete_error";
    public static final int COURSETEMPLATE_UPDATE_ERROR = 0x00030008;
    public static final String COURSETEMPLATE_UPDATE_ERROR_KEY = "coursetemplate_update_error";
    public static final int COURSETEMPLATE_QUERY_ERROR = 0x00030009;
    public static final String COURSETEMPLATE_QUERY_ERROR_KEY = "coursetemplate_query_error";
    
    //booking
    public static final int BOOKING_CREATEBYUSER_ERROR = 0x00040001;
    public static final String BOOKING_CREATEBYUSER_ERROR_KEY = "booking_createbyuser_error";
    public static final int BOOKING_ACCEPTBYPARTNER_ERROR = 0x00040002;
    public static final String BOOKING_ACCEPTBYPARTNER_ERROR_KEY = "booking_acceptbypartner_error";
    public static final int BOOKING_ACCEPTSUCCEEDBYPARTNER_ERROR = 0x00040003;
    public static final String BOOKING_ACCEPTSUCCEEDBYPARTNER_ERROR_KEY = "booking_acceptsucceedbypartner_error";
    public static final int BOOKING_ACCEPTFAILEDBYPARTNER_ERROR = 0x00040004;
    public static final String BOOKING_ACCEPTFAILEDBYPARTNER_ERROR_KEY = "booking_acceptfailedbypartner_error";
    public static final int BOOKING_VALIDATEBYPARTNER_ERROR = 0x00040005;
    public static final String BOOKING_VALIDATEBYPARTNER_ERROR_KEY = "booking_validatebypartner_error";
    public static final int BOOKING_CANCELBYUSER_ERROR = 0x00040006;
    public static final String BOOKING_CANCELBYUSER_ERROR_KEY = "booking_cancelbyuser_error";
    public static final int BOOKING_CANCELBYPARTNER_ERROR = 0x00040007;
    public static final String BOOKING_CANCELBYPARTNER_ERROR_KEY = "booking_cancelbypartner_error";
    public static final int BOOKING_CANCELBYADMIN_ERROR = 0x00040008;
    public static final String BOOKING_CANCELBYADMIN_ERROR_KEY = "booking_cancelbyadmin_error";
    public static final int BOOKING_QUERY_ERROR = 0x00040009;
    public static final String BOOKING_QUERY_ERROR_KEY = "booking_query_error";
    public static final int BOOKING_QUERYHISTORY_ERROR = 0x0004000A;
    public static final String BOOKING_QUERYHISTORY_ERROR_KEY = "booking_queryhistory_error";
    public static final int BOOKING_NOTFOUND_ERROR = 0x00040404;
    public static final String BOOKING_NOTFOUND_ERROR_KEY = "booking_notfound_error";
    
    //order
    public static final int ORDER_CREATEBYUSER_ERROR = 0x00050001;
    public static final String ORDER_CREATEBYUSER_ERROR_KEY = "order_createbyuser_error";
    public static final int ORDER_ACCEPTBYADMIN_ERROR = 0x00050002;
    public static final String ORDER_ACCEPTBYADMIN_ERROR_KEY = "order_acceptbyadmin_error";
    public static final int ORDER_NOTFOUND_ERROR = 0x00050404;
    public static final String ORDER_NOTFOUND_ERROR_KEY = "order_notfound_error";
    
    //category
    public static final int CATEGORY_QUERY_ERROR = 0x00060001;
    public static final String CATEGORY_QUERY_ERROR_KEY = "category_query_error";
    
    //circle
    public static final int CIRCLE_QUERY_ERROR = 0x00070001;
    public static final String CIRCLE_QUERY_ERROR_KEY = "circle_query_error";
    public static final int CIRCLE_NOTFOUND_ERROR = 0x00070404;
    public static final String CIRCLE_NOTFOUND_ERROR_KEY = "circle_notfound_error";
    
    //location
    public static final int LOCATION_QUERY_ERROR = 0x00080001;
    public static final String LOCATION_QUERY_ERROR_KEY = "location_query_error";
    public static final int LOCATION_NOTFOUND_ERROR = 0x00080404;
    public static final String LOCATION_NOTFOUND_ERROR_KEY = "location_notfound_error";
    
    //account
    public static final int ACCOUNT_EXCHANGECASH_ERROR = 0x00090001;
    public static final String ACCOUNT_EXCHANGECASH_ERROR_KEY = "account_exchangecash_error";
    public static final int ACCOUNT_QUERY_ERROR = 0x00090002;
    public static final String ACCOUNT_QUERY_ERROR_KEY = "account_query_error";
    public static final int ACCOUNT_QUERYHISTORY_ERROR = 0x00090003;
    public static final String ACCOUNT_QUERYHISTORY_ERROR_KEY ="account_queryhistory_error";
    public static final int ACCOUONT_NOTFOUND_ERROR = 0x00090404;
    public static final String ACCOUONT_NOTFOUND_ERROR_KEY = "account_notfound_error";
    
    //activity
    public static final int ACTIVITY_NOTFOUND_ERROR = 0x000A0404;
    public static final String ACTIVITY_NOTFOUND_ERROR_KEY = "activity_notfound_error";
    
    //address
    public static final int ADDRESS_NOTFOUND_ERROR = 0x000B0404;
    public static final String ADDRESS_NOTFOUND_ERROR_KEY = "address_notfound_error";
    
    //classphoto
    public static final int CLASSPHOTO_NOTFOUND_ERROR = 0x000C0404;
    public static final String CLASSPHOTO_NOTFOUND_ERROR_KEY = "classphoto_notfound_error";
    
    //contact
    public static final int CONTACT_NOTFOUND_ERROR = 0x000D0404;
    public static final String CONTACT_NOTFOUND_ERROR_KEY = "contact_notfound_error";
    
    //coupon
    public static final int COUPON_NOTFOUND_ERROR = 0x000E0404;
    public static final String COUPON_NOTFOUND_ERROR_KEY = "coupon_notfound_error";
    
    //credit
    public static final int CREDIT_NOTFOUND_ERROR = 0x000F0404;
    public static final String CREDIT_NOTFOUND_ERROR_KEY = "credit_notfound_error";
    
    //partner
    public static final int PARTNER_NOTFOUND_ERROR = 0x00100404;
    public static final String PARTNER_NOTFOUND_ERROR_KEY = "partner_notfound_error";
    
    //spread
    public static final int SPREAD_NOTFOUND_ERROR = 0x00110404;
    public static final String SPREAD_NOTFOUND_ERROR_KEY = "spread_notfound_error";
    
    //teacher
    public static final int TEACHER_NOTFOUND_ERROR = 0x00120404;
    public static final String TEACHER_NOTFOUND_ERROR_KEY = "teacher_notfound_error";
    
    //validation
    public static final int VALIDATION_ERROR = 0x00130001;
    public static final String VALIDATION_ERROR_KEY = "validation_error";
    
    //encryption
    public static final int PASSWORD_HASHING_ERROR = 0x00140001;
    public static final String PASSWORD_HASHING_ERROR_KEY = "password_hashing_error";
    
    //authentication
    public static final int AUTHENTICATION_ERROR = 0x00150001;
    public static final String AUTHENTICATION_ERROR_KEY = "authentication_error_key";
    
}
