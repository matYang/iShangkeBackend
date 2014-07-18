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
    public static final int USER_LOGINBYPHONE_ERROR = 0x00010003;
    public static final String USER_LOGINBYPHONE_ERROR_KEY = "user_loginByPhone_error";
    public static final int USER_LOGINBYREFERENCE_ERROR = 0x00010004;
    public static final String USER_LOGINBYREFERENCE_ERROR_KEY = "user_loginByReference_error";
    public static final int USER_DELETE_ERROR = 0x00010005;
    public static final String USER_DELETE_ERROR_KEY = "user_delete_error";
    public static final int USER_UPDATE_ERROR = 0x00010006;
    public static final String USER_UPDATE_ERROR_KEY = "user_update_error";
    public static final int USER_QUERYINFO_ERROR = 0X00010007;
    public static final String USER_QUERYINFO_ERROR_KEY = "user_queryinfo_error";
    public static final int USER_QUERYSESSION_ERROR = 0x00010008;
    public static final String USER_QUERYSESSION_ERROR_KEY = "user_querysession_error";
    public static final int USER_DISPOSESESSION_ERROR = 0X00010009;
    public static final String USER_DISPOSESESSION_ERROR_KEY = "user_disposesession_error";
    public static final int USER_OPENCELLSESSION_ERROR = 0X0001000A;
    public static final String USER_OPENCELLSESSION_ERROR_KEY = "user_opencellsession_error";
    public static final int USER_VERIFYCELLSESSION_ERROR = 0X0001000B;
    public static final String USER_VERIFYCELLSESSION_ERROR_KEY = "user_verifycellsession_error";
    public static final int USER_OPENCHANGEPASSWORDSESSION_ERROR = 0X0001000C;
    public static final String USER_OPENCHANGEPASSWORDSESSION_ERROR_KEY = "user_openchangepasswordsession_error";
    public static final int USER_VERIFYCHANGEPASSWORDSESSION_ERROR = 0X0001000D;
    public static final String USER_VERIFYCHANGEPASSWORDSESSION_ERROR_KEY = "user_verifychangepasswordsession_error";
    public static final int USER_OPENFORGETPASSWORDSESSION_ERROR = 0X0001000E;
    public static final String USER_OPENFORGETPASSWORDSESSION_ERROR_KEY = "user_openforgetpasswordsession_error";
    public static final int USER_VERIFYFORGETPASSWORDSESSION_ERROR = 0X0001000F;
    public static final String USER_VERIFYFORGETPASSWORDSESSION_ERROR_KEY = "user_verifyforgetpasswordsession_error";
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
    public static final int COURSE_QUERYBYID_ERROR = 0x0002000D;
    public static final String COURSE_QUERYBYID_ERROR_KEY = "course_querybyid_error";

    // courseTemplate
    public static final int COURSETEMPLATE_CREATE_ERROR = 0x00030001;
    public static final String COURSETEMPLATE_CREATE_ERROR_KEY = "coursetemplatebo_create_error";
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
    public static final int COURSETEMPLATE_QUERYBYID_ERROR = 0x0003000A;
    public static final String COURSETEMPLATE_QUERYBYID_ERROR_KEY = "coursetemplate_querybyid_error";

    // booking
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
    public static final int BOOKING_QUERYHISTORY_ERROR = 0x00040009;
    public static final String BOOKING_QUERYHISTORY_ERROR_KEY = "booking_queryhistory_error";
    public static final int BOOKING_NOTFOUND_ERROR = 0x00040404;
    public static final String BOOKING_NOTFOUND_ERROR_KEy = "booking_notfound_error";

    // order
    public static final int ORDER_CREATEBYUSER_ERROR = 0x00050001;
    public static final String ORDER_CREATEBYUSER_ERROR_KEY = "order_createbyuser_error";
    public static final int ORDER_ACCEPTBYADMIN_ERROR = 0x00050002;
    public static final String ORDER_ACCEPTBYADMIN_ERROR_KEY = "order_acceptbyadmin_error";
    public static final int ORDER_QUERYHISTORY_ERROR = 0x00050003;
    public static final String ORDER_QUERYHISTORY_ERROR_KEY = "order_queryhistory_error";
    public static final int ORDER_NOTFOUND_ERROR = 0x00050404;
    public static final String ORDER_NOTFOUND_ERROR_KEY = "order_notfound_error";

    // category
    public static final int CATEGORY_NOTFOUND_ERROR = 0x00060404;
    public static final String CATEGORY_NOTFOUND_ERROR_KEY = "category_notfound_error";

    // circle
    public static final int CIRCLE_NOTFOUND_ERROR = 0x00070404;
    public static final String CIRCLE_NOTFOUND_ERROR_KEY = "circle_notfound_error";

    // location
    public static final int LOCATION_NOTFOUND_ERROR = 0x00080404;
    public static final String LOCATION_NOTFOUND_ERROR_KEY = "location_notfound_error";

    // account
    public static final int ACCOUNT_EXCHANGECASH_ERROR = 0x00090001;
    public static final String ACCOUNT_EXCHANGECASH_ERROR_KEY = "account_exchangecash_error";
    public static final int ACCOUNT_QUERYHISTORY_ERROR = 0x00090002;
    public static final String ACCOUNT_QUERYHISTORY_ERROR_KEY = "account_queryhistory_error";
    public static final int ACCOUONT_NOTFOUND_ERROR = 0x00090404;
    public static final String ACCOUONT_NOTFOUND_ERROR_KEY = "account_notfound_error";

    // activity
    public static final int ACTIVITY_CREATE_ERROR = 0x000A0001;
    public static final String ACTIVITY_CREATE_ERROR_KEY = "activity_create_error";
    public static final int ACTIVITY_SUBMIT_ERROR = 0x000A0002;
    public static final String ACTIVITY_SUBMIT_ERROR_KEY = "activity_submit_error";
    public static final int ACTIVITY_APPROVE_ERROR = 0x000A0003;
    public static final String ACTIVITY_APPROVE_ERROR_KEY = "activity_approve_error";
    public static final int ACTIVITY_REJECT_ERROR = 0x000A0004;
    public static final String ACTIVITY_REJECT_ERROR_KEY = "activity_reject_error";
    public static final int ACTIVITY_CANCEL_ERROR = 0x000A0005;
    public static final String ACTIVITY_CANCEL_ERROR_KEY = "activity_cancel_error";
    public static final int ACTIVITY_DELETE_ERROR = 0x000A0006;
    public static final String ACTIVITY_DELETE_ERROR_KEY = "activity_delete_error";
    public static final int ACTIVITY_NOTFOUND_ERROR = 0x000A0404;
    public static final String ACTIVITY_NOTFOUND_ERROR_KEY = "activity_notfound_error";

    // address
    public static final int ADDRESS_CREATE_ERROR = 0x000B0001;
    public static final String ADDRESS_CREATE_ERROR_KEY = "address_create_error";
    public static final int ADDRESS_UPDATE_ERROR = 0x000B0002;
    public static final String ADDRESS_UPDATE_ERROR_KEY = "address_update_error";
    public static final int ADDRESS_DELETE_ERROR = 0x000B0003;
    public static final String ADDRESS_DELETE_ERROR_KEY = "address_delete_error";
    public static final int ADDRESS_NOTFOUND_ERROR = 0x000B0404;
    public static final String ADDRESS_NOTFOUND_ERROR_KEY = "address_notfound_error";

    // classphoto
    public static final int CLASSPHOTO_CREATE_ERROR = 0x000C0001;
    public static final String CLASSPHOTO_CREATE_ERROR_KEY = "classphoto_create_error";
    public static final int CLASSPHOTO_UPDATE_ERROR = 0x000C0002;
    public static final String CLASSPHOTO_UPDATE_ERROR_KEY = "classphoto_update_error";
    public static final int CLASSPHOTO_DELETE_ERROR = 0x000C0003;
    public static final String CLASSPHOTO_DELETE_ERROR_KEY = "classphoto_delete_error";
    public static final int CLASSPHOTO_NOTFOUND_ERROR = 0x000C0404;
    public static final String CLASSPHOTO_NOTFOUND_ERROR_KEY = "classphoto_notfound_error";

    // contact
    public static final int CONTACT_CREATE_ERROR = 0x000D0001;
    public static final String CONTACT_CREATE_ERROR_KEY = "contact_create_error";
    public static final int CONTACT_UPDATE_ERROR = 0x000D0002;
    public static final String CONTACT_UPDATE_ERROR_KEY = "contact_update_error";
    public static final int CONTACT_DELETE_ERROR = 0x000D0003;
    public static final String CONTACT_DELETE_ERROR_KEY = "contact_delete_error";
    public static final int CONTACT_NOTFOUND_ERROR = 0x000D0404;
    public static final String CONTACT_NOTFOUND_ERROR_KEY = "contact_notfound_error";

    // coupon
    public static final int COUPON_CREATE_ERROR = 0x000E0001;
    public static final String COUPON_CREATE_ERROR_KEY = "coupon_generate_error";
    public static final int COUPON_QUERYHISTORY_ERROR = 0x000E0002;
    public static final String COUPON_QUERYHISTORY_ERROR_KEY = "coupon_queryhistory_error";
    public static final int COUPON_EXCHANGE_ERROR = 0x000E003;
    public static final String COUPON_EXCHANGE_ERROR_KEY = "coupon_exchange_error";
    public static final int COUPON_EXCHANGEACCOUNT_ERROR = 0x000E0004;
    public static final String COUPON_EXCHANGEACCOUNT_ERROR_KEY = "coupon_exchangeaccount_error";
    public static final int COUPON_NOTFOUND_ERROR = 0x000E0404;
    public static final String COUPON_NOTFOUND_ERROR_KEY = "coupon_notfound_error";

    // credit
    public static final int CREDIT_CREATE_ERROR = 0x000E0001;
    public static final String CREDIT_CREATE_ERROR_KEY = "coupon_generate_error";
    public static final int CREDIT_QUERYHISTORY_ERROR = 0x000E0002;
    public static final String CREDIT_QUERYHISTORY_ERROR_KEY = "coupon_queryhistory_error";
    public static final int CREDIT_EXCHANGE_ERROR = 0x000E003;
    public static final String CREDIT_EXCHANGE_ERROR_KEY = "coupon_exchange_error";
    public static final int CREDIT_EXCHANGEACCOUNT_ERROR = 0x000E0004;
    public static final String CREDIT_EXCHANGEACCOUNT_ERROR_KEY = "coupon_exchangeaccount_error";
    public static final int CREDIT_NOTFOUND_ERROR = 0x000E0404;
    public static final String CREDIT_NOTFOUND_ERROR_KEY = "coupon_notfound_error";

    // partner
    public static final int PARTNER_CREATE_ERROR = 0x00100001;
    public static final String PARTNER_CREATE_ERROR_KEY = "partner_create_error";
    public static final int PARTNER_UPDATE_ERROR = 0x00100002;
    public static final String PARTNER_UPDATE_ERROR_KEY = "partner_update_error";
    public static final int PARTNER_NOTFOUND_ERROR = 0x00100404;
    public static final String PARTNER_NOTFOUND_ERROR_KEY = "partner_notfound_error";

    // spread
    public static final int SPREAD_CREATE_ERROR = 0x00110001;
    public static final String SPREAD_CREATE_ERROR_KEY = "spread_create_error";
    public static final int SPREAD_GENERATECODE_ERROR = 0x00110002;
    public static final String SPREAD_GENERATECODE_ERROR_KEY = "spread_generatecode_error";
    public static final int SPREAD_APPROVE_ERROR = 0x00110003;
    public static final String SPREAD_APPROVE_ERROR_KEY = "spread_approve_error";
    public static final int SPREAD_REJECT_ERROR = 0x00110004;
    public static final String SPREAD_REJECT_ERROR_KEY = "spread_reject_error";
    public static final int SPREAD_CANCEL_ERROR = 0x00110005;
    public static final String SPREAD_CANCEL_ERROR_KEY = "spread_cancel_error";
    public static final int SPREAD_DELETE_ERROR = 0x00110006;
    public static final String SPREAD_DELETE_ERROR_KEY = "spread_delete_error";
    public static final int SPREAD_NOTFOUND_ERROR = 0x00110404;
    public static final String SPREAD_NOTFOUND_ERROR_KEY = "spread_notfound_error";

    // teacher
    public static final int TEACHER_CREATE_ERROR = 0x00120001;
    public static final String TEACHER_CREATE_ERROR_KEY = "teacher_create_error";
    public static final int TEACHER_UPDATE_ERROR = 0x00120002;
    public static final String TEACHER_UPDATE_ERROR_KEY = "teacher_update_error";
    public static final int TEACHER_DELETE_ERROR = 0x00120003;
    public static final String TEACHER_DELETE_ERROR_KEY = "teacher_delete_error";
    public static final int TEACHER_NOTFOUND_ERROR = 0x00120404;
    public static final String TEACHER_NOTFOUND_ERROR_KEY = "teacher_notfound_error";

    // validation
    public static final int VALIDATION_ERROR = 0x00130001;
    public static final String VALIDATION_ERROR_KEY = "validation_error";

    // encryption
    public static final int PASSWORD_HASHING_ERROR = 0x00140001;
    public static final String PASSWORD_HASHING_ERROR_KEY = "password_hashing_error";

    // authentication
    public static final int AUTHENTICATION_ERROR = 0x00150001;
    public static final String AUTHENTICATION_ERROR_KEY = "authentication_error_key";

    // courseComment
    public static final int COURSECOMMENT_CREATE_ERROR = 0x00160001;
    public static final String COURSECOMMENT_CREATE_ERROR_KEY = "coursecomment_create_error";
    public static final int COURSECOMMENT_DELETE_ERROR = 0x00160002;
    public static final String COURSECOMMENT_DELETE_ERROR_KEY = "coursecomment_delete_error";
    public static final int COURSECOMMENT_NOTFOUND_ERROR = 0x00160404;
    public static final String COURSECOMMENT_NOTFOUND_ERROR_KEY = "coursecomment_notfound_error";

    // message
    public static final int MESSAGE_SEND_ERROR = 0x00170001;
    public static final String MESSAGE_SEND_ERROR_KEY = "message_send_error";
    public static final int MESSAGE_RECEIVE_ERROR = 0x00170002;
    public static final String MESSAGE_RECEIVE_ERROR_KEY = "message_receive_error";
    public static final int MESSAGE_DELETE_ERROR = 0x00170003;
    public static final String MESSAGE_DELETE_ERROR_KEY = "message_delete_error";
    public static final int MESSAGE_NOTFOUND_ERROR = 0x00170404;
    public static final String MESSAGE_NOTFOUND_ERROR_KEY = "message_notfound_error";

    // withdraw
    public static final int WITHDRAW_CREATE_ERROR = 0x00180001;
    public static final String WITHDRAW_CREATE_ERROR_KEY = "withdraw_create_error";
    public static final int WITHDRAW_UPDATE_ERROR = 0x00180002;
    public static final String WITHDRAW_UPDATE_ERROR_KEY = "withdraw_update_error";
    public static final int WITHDRAW_DELETE_ERROR = 0x00180003;
    public static final String WITHDRAW_DELETE_ERROR_KEY = "withdraw_delete_error";
    public static final int WITHDRAW_NOTFOUND_ERROR = 0x00180404;
    public static final String WITHDRAW_NOTFOUND_ERROR_KEY = "withdraw_notfound_error";
}
