package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class AccountNotFoundException extends ManagerException {

    private static final long serialVersionUID = -7756249070182014274L;

    public AccountNotFoundException() {
        super("对不起，您要找的账户不存在");
    }

    public AccountNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public AccountNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public AccountNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
