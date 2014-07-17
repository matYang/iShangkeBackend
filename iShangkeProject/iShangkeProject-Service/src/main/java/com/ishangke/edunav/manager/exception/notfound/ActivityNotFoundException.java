package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class ActivityNotFoundException extends ManagerException {

    private static final long serialVersionUID = -2151849652768270798L;

    public ActivityNotFoundException() {
        super("对不起，您要找的活动不存在");
    }

    public ActivityNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public ActivityNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public ActivityNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
