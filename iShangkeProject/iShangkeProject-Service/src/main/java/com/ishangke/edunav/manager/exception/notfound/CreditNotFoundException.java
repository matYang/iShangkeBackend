package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class CreditNotFoundException extends ManagerException{

    /**
     * 
     */
    private static final long serialVersionUID = 8650546703515169447L;

    public CreditNotFoundException(){
        super("对不起，您要找的积分不存在");
    }

    public CreditNotFoundException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        return 8;
//    }
}
