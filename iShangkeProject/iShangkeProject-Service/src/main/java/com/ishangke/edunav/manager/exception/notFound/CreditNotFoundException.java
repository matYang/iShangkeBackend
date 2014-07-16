package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class CreditNotFoundException extends ManagerException{

    private static final long serialVersionUID = -6704096869155705876L;


    public CreditNotFoundException(){
        super("对不起，您要找的积分不存在");
    }

    public CreditNotFoundException(String exceptionText){
        super(exceptionText);
    }

    @Override
    public int getCode() {
        return 8;
    }
}
