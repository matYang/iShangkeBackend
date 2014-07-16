package com.ishangke.edunav.manager.exception.authentication;

import com.ishangke.edunav.manager.exception.ManagerException;

public class AuthenticationException extends ManagerException{

    /**
     * 
     */
    private static final long serialVersionUID = -319275308553630650L;

    public AuthenticationException(){
        super("对不起，账户验证失败，请您重新登录");
    }

    public AuthenticationException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        return 17;
//    }
}
