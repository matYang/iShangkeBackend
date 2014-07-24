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

    // career
    public static final int CAREER_NOTFOUND_ERROR = 0x00190404;
    public static final String CAREER_NOTFOUND_ERROR_KEY = "career_notfound_error";

    // school
    public static final int SCHOOL_NOTFOUND_ERROR = 0x001A0404;
    public static final String SCHOOL_NOTFOUND_ERROR_KEY = "school_notfound_error";

    // school
    public static final int CONFIGURATION_GETBYNAME_ERROR = 0x001B0001;
    public static final String CONFIGURATION_GETBYNAME_ERROR_KEY = "configuration_getByName_error";
    public static final int CONFIGURATION_LISTALL_ERROR = 0x001B0002;
    public static final String CONFIGURATION_LISTALL_ERROR_KEY = "configuration_listAll_error";
    public static final int CONFIGURATION_NOTFOUND_ERROR = 0x001B0404;
    public static final String CONFIGURATION_NOTFOUND_ERROR_KEY = "configuration_notfound_error";

    // permission
    public static final int PERMISSION_USER_CREATE = 0x010000001;
    public static final String PERMISSION_USER_CREATE_KEY = "permission_user_create";
    public static final int PERMISSION_PARTNER_QUERYPARTNER = 0x010000002;
    public static final String PERMISSION_PARTNER_QUERYPARTNER_KEY = "permission_partner_queryPartner";
    public static final int PERMISSION_PARTNER_QUERYPARTNERBYID = 0x010000003;
    public static final String PERMISSION_PARTNER_QUERYPARTNERBYID_KEY = "permission_partner_queryPartnerById";
    public static final int PERMISSION_PARTNER_UPDATEPARTNER = 0x010000004;
    public static final String PERMISSION_PARTNER_UPDATEPARTNER_KEY = "permission_partner_updatePartner";
    public static final int PERMISSION_PARTNER_CREATEPARTNER = 0x01000005;
    public static final String PERMISSION_PARTNER_CREATEPARTNER_KEY = "permission_partner_createPartner";
    public static final int PERMISSION_PARTNER_CREATEADDRESS = 0x01000006;
    public static final String PERMISSION_PARTNER_CREATEADDRESS_KEY = "permission_partner_createAddress";
    public static final int PERMISSION_PARTNER_UPDATEADDRESS = 0x01000007;
    public static final String PERMISSION_PARTNER_UPDATEADDRESS_KEY = "permission_partner_updateAddress";
    public static final int PERMISSION_PARTNER_DELETEADDRESS = 0x01000008;
    public static final String PERMISSION_PARTNER_DELETEADDRESS_KEY = "permission_partner_deleteAddress";
    public static final int PERMISSION_PARTNER_QUERYADDRESS = 0x01000009;
    public static final String PERMISSION_PARTNER_QUERYADDRESS_KEY = "permission_partner_queryAddress";
    public static final int PERMISSION_PARTNER_CREATECLASSPHOTO = 0x0100000A;
    public static final String PERMISSION_PARTNER_CREATECLASSPHOTO_KEY = "permission_partner_createClassPhoto";
    public static final int PERMISSION_PARTNER_UPDATECLASSPHOTO = 0x0100000B;
    public static final String PERMISSION_PARTNER_UPDATECLASSPHOTO_KEY = "permission_partner_updateClassPhoto";
    public static final int PERMISSION_PARTNER_DELETECLASSPHOTO = 0x0100000C;
    public static final String PERMISSION_PARTNER_DELETECLASSPHOTO_KEY = "permission_partner_deleteClassPhoto";
    public static final int PERMISSION_PARTNER_QUERYCLASSPHOTO = 0x0100000D;
    public static final String PERMISSION_PARTNER_QUERYCLASSPHOTO_KEY = "permission_partner_queryClassPhoto";
    public static final int PERMISSION_PARTNER_CREATETEACHER = 0x0100000E;
    public static final String PERMISSION_PARTNER_CREATETEACHER_KEY = "permission_partner_createTeacher";
    public static final int PERMISSION_PARTNER_UPDATETEACHER = 0x0100000F;
    public static final String PERMISSION_PARTNER_UPDATETEACHER_KEY = "permission_partner_updateTeacher";
    public static final int PERMISSION_PARTNER_DELETETEACHER = 0x01000010;
    public static final String PERMISSION_PARTNER_DELETETEACHER_KEY = "permission_partner_deleteTeacher";
    public static final int PERMISSION_PARTNER_QUERYTEACHER = 0x01000011;
    public static final String PERMISSION_PARTNER_QUERYTEACHER_KEY = "permission_partner_queryTeacher";
    public static final int PERMISSION_PARTNER_CREATEACTIVITY = 0x01000012;
    public static final String PERMISSION_PARTNER_CREATEACTIVITY_KEY = "permission_partner_createActivity";
    public static final int PERMISSION_PARTNER_SUBMITACTIVITY = 0x01000013;
    public static final String PERMISSION_PARTNER_SUBMITACTIVITY_KEY = "permission_partner_submitActivity";
    public static final int PERMISSION_PARTNER_APPROVEACTIVITY = 0x01000014;
    public static final String PERMISSION_PARTNER_APPROVEACTIVITY_KEY = "permission_partner_approveActivity";
    public static final int PERMISSION_PARTNER_REJECTACTIVITY = 0x01000015;
    public static final String PERMISSION_PARTNER_REJECTACTIVITY_KEY = "permission_partner_rejectActivity";
    public static final int PERMISSION_PARTNER_CANCELACTIVITY = 0x01000016;
    public static final String PERMISSION_PARTNER_CANCELACTIVITY_KEY = "permission_partner_cancelActivity";
    public static final int PERMISSION_PARTNER_DELETEACTIVITY = 0x01000017;
    public static final String PERMISSION_PARTNER_DELETEACTIVITY_KEY = "permission_partner_deleteActivity";
    public static final int PERMISSION_PARTNER_QUERYACTIVITY = 0x01000018;
    public static final String PERMISSION_PARTNER_QUERYACTIVITY_KEY = "permission_partner_queryActivity";
    public static final int PERMISSION_ACCOUNT_EXCHANGECASH = 0x01000019;
    public static final String PERMISSION_ACCOUNT_EXCHANGECASH_KEY = "permission_account_exchangeCash";
    public static final int PERMISSION_ACCOUNT_QUERYACCOUNT = 0x0100001A;
    public static final String PERMISSION_ACCOUNT_QUERYACCOUNT_KEY = "permission_account_queryAccount";
    public static final int PERMISSION_ACCOUNT_QUERYACCOUNTHISTORY = 0x0100001B;
    public static final String PERMISSION_ACCOUNT_QUERYACCOUNTHISTORY_KEY = "permission_account_queryAccountHistory";
    public static final int PERMISSION_ACCOUNT_CREATECOUPON = 0x0100001C;
    public static final String PERMISSION_ACCOUNT_CREATECOUPON_KEY = "permission_account_createCoupon";
    public static final int PERMISSION_ACCOUNT_QUERYCOUPON = 0x0100001D;
    public static final String PERMISSION_ACCOUNT_QUERYCOUPON_KEY = "permission_account_queryCoupon";
    public static final int PERMISSION_ACCOUNT_QUERYCOUPONHISTORY = 0x0100001E;
    public static final String PERMISSION_ACCOUNT_QUERYCOUPONHISTORY_KEY = "permission_account_queryCouponhistory";
    public static final int PERMISSION_ACCOUNT_EXCHANGECOUPON = 0x0100001F;
    public static final String PERMISSION_ACCOUNT_EXCHANGECOUPON_KEY = "permission_account_exchangeCoupon";
    public static final int PERMISSION_ACCOUNT_EXCHANGEACCOUNT = 0x01000020;
    public static final String PERMISSION_ACCOUNT_EXCHANGEACCOUNT_KEY = "permission_account_exchangeAccount";
    public static final int PERMISSION_ACCOUNT_QUERYCREDIT = 0x01000021;
    public static final String PERMISSION_ACCOUNT_QUERYCREDIT_KEY = "permission_account_queryCredit";
    public static final int PERMISSION_ACCOUNT_QUERYCREDITHISTORY = 0x01000022;
    public static final String PERMISSION_ACCOUNT_QUERYCREDITHISTORY_KEY = "permission_account_queryCredithistory";
    public static final int PERMISSION_ACCOUNT_CREATEWITHDRAW = 0x01000023;
    public static final String PERMISSION_ACCOUNT_CREATEWITHDRAW_KEY = "permission_account_createWithdraw";
    public static final int PERMISSION_ACCOUNT_UPDATEWITHDRAW = 0x01000024;
    public static final String PERMISSION_ACCOUNT_UPDATEWITHDRAW_KEY = "permission_account_updateWithdraw";
    public static final int PERMISSION_ACCOUNT_DELETEWITHDRAW = 0x01000025;
    public static final String PERMISSION_ACCOUNT_DELETEWITHDRAW_KEY = "permission_account_deleteWithdraw";
    public static final int PERMISSION_ACCOUNT_QUERYWITHDRAW = 0x01000026;
    public static final String PERMISSION_ACCOUNT_QUERYWITHDRAW_KEY = "permission_account_queryWithdraw";
    public static final int PERMISSION_ACCOUNT_CREATECONTACT = 0x01000027;
    public static final String PERMISSION_ACCOUNT_CREATECONTACT_KEY = "permission_account_createContact";
    public static final int PERMISSION_ACCOUNT_UPDATECONTACT = 0x01000028;
    public static final String PERMISSION_ACCOUNT_UPDATECONTACT_KEY = "permission_account_updateContact";
    public static final int PERMISSION_ACCOUNT_DELETECONTACT = 0x01000029;
    public static final String PERMISSION_ACCOUNT_DELETECONTACT_KEY = "permission_account_deleteContact";
    public static final int PERMISSION_ACCOUNT_QUERYCONTACT = 0x0100002A;
    public static final String PERMISSION_ACCOUNT_QUERYCONTACT_KEY = "permission_account_queryContact";
    public static final int PERMISSION_BOOKING_CREATEBOOKINGBYUSER = 0x0100002B;
    public static final String PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY = "permission_booking_createBookingByUser";
    public static final int PERMISSION_BOOKING_QUERYBOOKING = 0x0100002C;
    public static final String PERMISSION_BOOKING_QUERYBOOKING_KEY = "permission_booking_queryBooking";
    public static final int PERMISSION_BOOKING_QUERYBOOKINGHISTORY = 0x0100002D;
    public static final String PERMISSION_BOOKING_QUERYBOOKINGHISTORY_KEY = "permission_booking_queryBookinghistory";
    public static final int PERMISSION_BOOKING_CREATEORDERBYUSER = 0x0100002E;
    public static final String PERMISSION_BOOKING_CREATEORDERBYUSER_KEY = "permission_booking_createOrderByUser";
    public static final int PERMISSION_BOOKING_ACCEPTORDERBYADMIN = 0x0100002F;
    public static final String PERMISSION_BOOKING_ACCEPTORDERBYADMIN_KEY = "permission_booking_acceptOrderByAdmin";
    public static final int PERMISSION_BOOKING_QUERYORDER = 0x01000030;
    public static final String PERMISSION_BOOKING_QUERYORDER_KEY = "permission_booking_queryOrder";
    public static final int PERMISSION_BOOKING_QUERYORDERHISTORY = 0x01000031;
    public static final String PERMISSION_BOOKING_QUERYORDERHISTORY_KEY = "permission_booking_queryOrderHistory";
    public static final int PERMISSION_BOOKING_CREATECOURSE = 0x01000032;
    public static final String PERMISSION_BOOKING_CREATECOURSE_KEY = "permission_booking_createCourse";
    public static final int PERMISSION_BOOKING_SUBMITCOURSE = 0x01000033;
    public static final String PERMISSION_BOOKING_SUBMITCOURSE_KEY = "permission_booking_submitCourse";
    public static final int PERMISSION_BOOKING_APPROVECOURSE = 0x01000034;
    public static final String PERMISSION_BOOKING_APPROVECOURSE_KEY = "permission_booking_approveCourse";
    public static final int PERMISSION_BOOKING_REJECTCOURSE = 0x01000035;
    public static final String PERMISSION_BOOKING_REJECTCOURSE_KEY = "permission_booking_rejectCourse";
    public static final int PERMISSION_BOOKING_CANCELCOURSE = 0x01000036;
    public static final String PERMISSION_BOOKING_CANCELCOURSE_KEY = "permission_booking_cancelCourse";
    public static final int PERMISSION_BOOKING_REAUBMITCOURSE = 0x01000037;
    public static final String PERMISSION_BOOKING_RESUBMITCOURSE_KEY = "permission_booking_resubmitCourse";
    public static final int PERMISSION_BOOKING_DELETECOURSE = 0x01000038;
    public static final String PERMISSION_BOOKING_DELETECOURSE_KEY = "permission_booking_deleteCourse";
    public static final int PERMISSION_BOOKING_UPDATECOURSE = 0x01000039;
    public static final String PERMISSION_BOOKING_UPDATECOURSE_KEY = "permission_booking_updateCourse";
    public static final int PERMISSION_BOOKING_COMMENTCOURSE = 0x0100003A;
    public static final String PERMISSION_BOOKING_COMMENTCOURSE_KEY = "permission_booking_commentCourse";
    public static final int PERMISSION_BOOKING_QUERYCOURSEBYPARTNER = 0x0100003B;
    public static final String PERMISSION_BOOKING_QUERYCOURSEBYPARTNER_KEY = "permission_booking_queryCourseByPartner";
    public static final int PERMISSION_BOOKING_QUERYCOURSEBYID = 0x0100003C;
    public static final String PERMISSION_BOOKING_QUERYCOURSEBYID_KEY = "permission_booking_queryCourseById";
    public static final int PERMISSION_COURSETEMPLATE_CREATECOURSETEMPLATE = 0x0100003D;
    public static final String PERMISSION_COURSETEMPLATE_CREATECOURSETEMPLATE_KEY = "permission_courseTemplate_createCourseTemplate";
    public static final int PERMISSION_COURSETEMPLATE_SUBMITCOURSETEMPLATE = 0x0100003E;
    public static final String PERMISSION_COURSETEMPLATE_SUBMITCOURSETEMPLATE_KEY = "permission_courseTemplate_submitCourseTemplate";
    public static final int PERMISSION_COURSETEMPLATE_APPROVECOURSETEMPLATE = 0x0100003F;
    public static final String PERMISSION_COURSETEMPLATE_APPROVECOURSETEMPLATE_KEY = "permission_courseTemplate_approveCourseTemplate";
    public static final int PERMISSION_COURSETEMPLATE_REJECTCOURSETEMPLATE = 0x01000040;
    public static final String PERMISSION_COURSETEMPLATE_REJECTCOURSETEMPLATE_KEY = "permission_courseTemplate_rejectCourseTemplate";
    public static final int PERMISSION_COURSETEMPLATE_CANCELCOURSETEMPLATE = 0x01000041;
    public static final String PERMISSION_COURSETEMPLATE_CANCELCOURSETEMPLATE_KEY = "permission_courseTemplate_cancelCourseTemplate";
    public static final int PERMISSION_COURSETEMPLATE_RESUBMITCOURSETEMPLATE = 0x01000042;
    public static final String PERMISSION_COURSETEMPLATE_RESUBMITCOURSETEMPLATE_KEY = "permission_courseTemplate_resubmitCourserTemplate";
    public static final int PERMISSION_COURSETEMPLATE_DELETECOURSETEMPLATE = 0x01000043;
    public static final String PERMISSION_COURSETEMPLATE_DELETECOURSETEMPLATE_KEY = "permission_courseTemplate_deleteCourseTemplate";
    public static final int PERMISSION_COURSETEMPLATE_UPDATECOURSETEMPLATE = 0x01000044;
    public static final String PERMISSION_COURSETEMPLATE_UPDATECOURSETEMPLATE_KEY = "permission_courseTemplate_updateCourseTemplate";
    public static final int PERMISSION_COURSETEMPLATE_QUERYCOURSETEMPLATE = 0x01000045;
    public static final String PERMISSION_COURSETEMPLATE_QUERYCOURSETEMPLATE_KEY = "permission_courseTemplate_queryCourseTemplate";
    public static final int PERMISSION_COURSETEMPLATE_QUERYCOURSETEMPLATEBYID = 0x01000046;
    public static final String PERMISSION_COURSETEMPLATE_QUERYCOURSETEMPLATEBYID_KEY = "permission_courseTemplate_queryCourseTemplateById";
    public static final int PERMISSION_COURSETEMPLATE_CREATECOURSECOMMENT = 0x01000047;
    public static final String PERMISSION_COURSETEMPLATE_CREATECOURSECOMMENT_KEY = "permission_courseTemplate_createCourseComment";
    public static final int PERMISSION_COURSETEMPLATE_DELETECOURSECOMMENT = 0x01000048;
    public static final String PERMISSION_COURSETEMPLATE_DELETECOURSECOMMENT_KEY = "permission_courseTemplate_deleteCourseComment";
    public static final int PERMISSION_COURSETEMPLATE_QUERYCOURSECOMMENT = 0x01000049;
    public static final String PERMISSION_COURSETEMPLATE_QUERYCOURSECOMMENT_KEY = "permission_courseTemplate_queryCourseComment";
    public static final int PERMISSION_USER_REISTERUSER = 0x0100004A;
    public static final String PERMISSION_USER_REISTERUSER_KEY = "permission_user_registerUser";
    public static final int PERMISSION_USER_DELETEUSER = 0x0100004B;
    public static final String PERMISSION_USER_DELETEUSER_KEY = "permission_user_deleteUser";
    public static final int PERMISSION_USER_UPDATEUSER = 0x0100004C;
    public static final String PERMISSION_USER_UPDATEUSER_KEY = "permission_user_updateUser";
    public static final int PERMISSION_USER_QUERYUSERINFO = 0x0100004D;
    public static final String PERMISSION_USER_QUERYUSERINFO_KEY = "permission_user_queryUserInfo";
    public static final int PERMISSION_USER_QUERYUSER = 0x0100004E;
    public static final String PERMISSION_USER_QUERYUSER_KEY = "permission_user_queryUser";
    public static final int PERMISSION_USER_QUERYSESSION = 0x0100004F;
    public static final String PERMISSION_USER_QUERYSESSION_KEY = "permission_user_querySession";
    public static final int PERMISSION_USER_DISPOSESESSION = 0x01000050;
    public static final String PERMISSION_USER_DISPOSESESSION_KEY = "permission_user_disposeSession";
    public static final int PERMISSION_USER_SENDMESSAGE = 0x01000051;
    public static final String PERMISSION_USER_SENDMESSAGE_KEY = "permission_user_sendMessage";
    public static final int PERMISSION_USER_RECEIVEMESSAGE = 0x01000052;
    public static final String PERMISSION_USER_RECEIVEMESSAGE_KEY = "permission_user_receiveMessage";
    public static final int PERMISSION_USER_DELETEMESSAGE = 0x01000053;
    public static final String PERMISSION_USER_DELETEMESSAGE_KEY = "permission_user_deleteMessage";
    public static final int PERMISSION_USER_QUERYMESSAGE = 0x01000054;
    public static final String PERMISSION_USER_QUERYMESSAGE_KEY = "permission_user_queryMessage";
    public static final int PERMISSION_USER_GENERATECODE = 0x01000055;
    public static final String PERMISSION_USER_GENERATECODE_KEY = "permission_user_generateCode";
    public static final int PERMISSION_USER_QUERYSPREAD = 0x01000056;
    public static final String PERMISSION_USER_QUERYSPREAD_KEY = "permission_user_querySpread";
    public static final int PERMISSION_USER_CREATESPREAD = 0x01000057;
    public static final String PERMISSION_USER_CREATESPREAD_KEY = "permission_user_createSpread";
    public static final int PERMISSION_USER_APPROVESPREAD = 0x01000058;
    public static final String PERMISSION_USER_APPROVESPREAD_KEY = "permission_user_approveSpread";
    public static final int PERMISSION_USER_REJECTSPREAD = 0x01000059;
    public static final String PERMISSION_USER_REJECTSPREAD_KEY = "permission_user_rejectSpread";
    public static final int PERMISSION_USER_CANCELSPREAD = 0x0100005A;
    public static final String PERMISSION_USER_CANCELSPREAD_KEY = "permission_user_cancelSpread";
    public static final int PERMISSION_USER_DELETESPREAD = 0x0100005B;
    public static final String PERMISSION_USER_DELETESPREAD_KEY = "permission_user_deleteSpread";
    

}
