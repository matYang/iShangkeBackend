package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class UserNotFoundException extends ManagerException{

    private static final long serialVersionUID = -7250491721825908242L;

    public UserNotFoundException(){
        super("对不起，您要找的用户不存在");
    }

    public UserNotFoundException(String exceptionText){
        super(exceptionText);
    }

    @Override
    public int getCode() {
        return 1;
    }
}
