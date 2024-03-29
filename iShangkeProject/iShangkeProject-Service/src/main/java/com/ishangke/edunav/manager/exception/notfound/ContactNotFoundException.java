package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class ContactNotFoundException extends ManagerException {

    private static final long serialVersionUID = 2613481156973314857L;

    public ContactNotFoundException() {
        super("对不起，您要找的联系信息不存在");
    }

    public ContactNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public ContactNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public ContactNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
