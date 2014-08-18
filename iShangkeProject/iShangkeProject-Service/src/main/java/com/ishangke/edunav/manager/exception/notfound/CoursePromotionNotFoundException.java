package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class CoursePromotionNotFoundException extends ManagerException{

    private static final long serialVersionUID = 3530002695418521355L;

    public CoursePromotionNotFoundException() {
        super("对不起，您要找的积分不存在");
    }

    public CoursePromotionNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public CoursePromotionNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public CoursePromotionNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
