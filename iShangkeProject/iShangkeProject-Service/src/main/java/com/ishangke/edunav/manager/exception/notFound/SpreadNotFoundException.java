package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class SpreadNotFoundException extends ManagerException{

    private static final long serialVersionUID = 1356275365147457580L;

    public SpreadNotFoundException(){
        super("对不起，您要找的推销信息不存在");
    }

    public SpreadNotFoundException(String exceptionText){
        super(exceptionText);
    }

    @Override
    public int getCode() {
        //TODO
        return -1;
    }
}
