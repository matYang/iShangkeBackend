package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class ContactNotFoundException extends ManagerException{

    private static final long serialVersionUID = 1356275365147457580L;

    public ContactNotFoundException(){
        super("对不起，您要找的联系信息不存在");
    }

    public ContactNotFoundException(String exceptionText){
        super(exceptionText);
    }

    @Override
    public int getCode() {
        //TODO
        return -1;
    }
}
