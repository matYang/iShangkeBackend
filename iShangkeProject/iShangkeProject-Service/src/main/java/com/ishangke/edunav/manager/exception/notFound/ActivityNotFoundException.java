package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class ActivityNotFoundException extends ManagerException{

    private static final long serialVersionUID = 1356275365147457580L;

    public ActivityNotFoundException(){
        super("对不起，您要找的活动不存在");
    }

    public ActivityNotFoundException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        //TODO
//        return -1;
//    }
}
