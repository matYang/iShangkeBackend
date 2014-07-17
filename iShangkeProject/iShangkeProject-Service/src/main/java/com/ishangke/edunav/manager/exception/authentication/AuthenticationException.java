package com.ishangke.edunav.manager.exception.authentication;

import com.ishangke.edunav.manager.exception.ManagerException;

public class AuthenticationException extends ManagerException {
    private static final long serialVersionUID = -7756249070182014274L;

    public AuthenticationException() {
        super("对不起，账户验证失败，请您重新登录");
    }

    public AuthenticationException(String exceptionText) {
        super(exceptionText);
    }

    public AuthenticationException(String message, int errorCode) {
        super(message, errorCode);
    }

    public AuthenticationException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
