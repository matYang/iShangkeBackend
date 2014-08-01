package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class WithdrawNotFoundException extends ManagerException {

    private static final long serialVersionUID = -2862168217375669186L;

    public WithdrawNotFoundException() {
        super("对不起，您要找的用户不存在");
    }

    public WithdrawNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public WithdrawNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public WithdrawNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
