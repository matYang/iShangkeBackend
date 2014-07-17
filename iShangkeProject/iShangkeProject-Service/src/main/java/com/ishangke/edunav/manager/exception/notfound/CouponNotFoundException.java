package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class CouponNotFoundException extends ManagerException {

    private static final long serialVersionUID = -6300000719666285238L;

    public CouponNotFoundException() {
        super("对不起，您要找的优惠券不存在");
    }

    public CouponNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public CouponNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public CouponNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
