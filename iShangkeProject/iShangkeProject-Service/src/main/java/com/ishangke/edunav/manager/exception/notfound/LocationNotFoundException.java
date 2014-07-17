package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class LocationNotFoundException extends ManagerException{

    private static final long serialVersionUID = -3144842668700928931L;

    public LocationNotFoundException(){
        super("对不起，您要找的地区不存在");
    }

    public LocationNotFoundException(String exceptionText){
        super(exceptionText);
    }

     public LocationNotFoundException(String message, int errorCode){
    	super(message,errorCode);
    } 
    
    public LocationNotFoundException(String message, int errorCode, Throwable cause){
    	super(message,errorCode,cause);
    }
}
