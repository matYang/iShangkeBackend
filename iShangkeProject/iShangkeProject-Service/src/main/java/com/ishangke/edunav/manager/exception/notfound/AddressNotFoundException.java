package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class AddressNotFoundException extends ManagerException{
    
    private static final long serialVersionUID = 2109823935259825700L;

    public AddressNotFoundException(){
        super("对不起，您要找的地址不存在");
    }

    public AddressNotFoundException(String exceptionText){
        super(exceptionText);
    }

    public AddressNotFoundException(String message, int errorCode){
    	super(message,errorCode);
    } 
    
    public AddressNotFoundException(String message, int errorCode, Throwable cause){
    	super(message,errorCode,cause);
    }
}
