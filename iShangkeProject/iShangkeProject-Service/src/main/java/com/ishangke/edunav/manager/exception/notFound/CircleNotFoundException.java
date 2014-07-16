package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class CircleNotFoundException extends ManagerException{

    private static final long serialVersionUID = 1356275365147457580L;

    public CircleNotFoundException(){
        super("对不起，您要找的商圈不存在");
    }

    public CircleNotFoundException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        //TODO
//        return -1;
//    }
}
