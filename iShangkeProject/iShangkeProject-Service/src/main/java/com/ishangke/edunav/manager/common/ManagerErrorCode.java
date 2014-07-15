package com.ishangke.edunav.manager.common;

public class ManagerErrorCode {
    public static final int DEFAULT_SUCCESS = 0x00000000;
    public static final String DEFAULT_SUCCESS_KEY = "success";
    public static final int DEFAULT_ERROR = 0x00000001;
    public static final String DEFAULT_ERROR_KEY = "error";

    // user
    public static final int USER_REGISTER_ERROR = 0x00010001;
    public static final String USER_REGISTER_ERROR_KEY = "user_register_error";

    // course
    public static final int COURSE_XXX_ERROR = 0x00020001;
    public static final String COURSE_XXX_ERROR_KEY = "course_xxx_error";
    public static final int COURSE_YYY_ERROR = 0x00020002;
    public static final String COURSE_YYY_ERROR_KEY = "course_yyy_error";

    // ...

}
