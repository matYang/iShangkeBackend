package com.ishangke.edunav.manager.exception.validation;

import com.ishangke.edunav.manager.exception.ManagerException;

public class ValidationException extends ManagerException{

    /**
     * 
     */
    private static final long serialVersionUID = -5931623981225280453L;

    public ValidationException(){
        super("验证失败，请核对内容");
    }

    public ValidationException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        return 18;
//    }
}
