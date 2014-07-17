package com.ishangke.edunav.manager.exception.encryptionException;

import com.ishangke.edunav.manager.exception.ManagerException;

public class PasswordHashingException extends ManagerException{

    private static final long serialVersionUID = 5634773205142466300L;

    public PasswordHashingException(){
        super("密码加密格错误");
    }

    public PasswordHashingException(String exceptionText){
        super(exceptionText);
    }

    public PasswordHashingException(String message, int errorCode){
    	super(message,errorCode);
    } 
    
    public PasswordHashingException(String message, int errorCode, Throwable cause){
    	super(message,errorCode,cause);
    }
}
