package com.ishangke.edunav.manager.exception.authentication;

import com.ishangke.edunav.manager.exception.ManagerException;

public class NoPermissionException extends ManagerException {
    private static final long serialVersionUID = -5209738700453682723L;

    public NoPermissionException() {
        super("权限校验失败");
    }

    public NoPermissionException(String exceptionText) {
        super(exceptionText);
    }

    public NoPermissionException(String message, int errorCode) {
        super(message, errorCode);
    }

    public NoPermissionException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
