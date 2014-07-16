package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class CouponNotFoundException extends ManagerException{

    private static final long serialVersionUID = 6998293589672758968L;


    public CouponNotFoundException(){
        super("对不起，您要找的优惠券不存在");
    }

    public CouponNotFoundException(String exceptionText){
        super(exceptionText);
    }

    @Override
    public int getCode() {
        return 7;
    }
}
