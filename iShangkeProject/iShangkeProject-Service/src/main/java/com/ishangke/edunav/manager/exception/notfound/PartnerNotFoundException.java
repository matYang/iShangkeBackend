package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class PartnerNotFoundException extends ManagerException {

    private static final long serialVersionUID = 5160624755152751640L;

    public PartnerNotFoundException() {
        super("对不起，您要找的机构不存在");
    }

    public PartnerNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public PartnerNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public PartnerNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
