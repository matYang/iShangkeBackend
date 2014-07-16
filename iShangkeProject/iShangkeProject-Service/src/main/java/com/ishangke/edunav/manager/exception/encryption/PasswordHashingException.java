package com.ishangke.edunav.manager.exception.encryption;

import com.ishangke.edunav.manager.exception.ManagerException;

public class PasswordHashingException extends ManagerException{

    /**
     * 
     */
    private static final long serialVersionUID = 7590671036885108082L;

    public PasswordHashingException(){
        super("密码加密格错误");
    }

    public PasswordHashingException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        return 16;
//    }
}
