package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class UserNotFoundException extends ManagerException {

    private static final long serialVersionUID = 2476249717398715525L;

    public UserNotFoundException() {
        super("对不起，您要找的用户不存在");
    }

    public UserNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public UserNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public UserNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
