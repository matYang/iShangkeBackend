package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class AccountNotFoundException extends ManagerException{

    private static final long serialVersionUID = 1356275365147457580L;


    public AccountNotFoundException(){
        super("对不起，您要找的账户不存在");
    }

    public AccountNotFoundException(String exceptionText){
        super(exceptionText);
    }

    @Override
    public int getCode() {
        //TODO
        return -1;
    }
}
