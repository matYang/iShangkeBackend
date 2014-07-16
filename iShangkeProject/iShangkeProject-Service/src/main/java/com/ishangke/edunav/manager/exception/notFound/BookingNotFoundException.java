package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class BookingNotFoundException extends ManagerException{

    private static final long serialVersionUID = 1356275365147457580L;


    public BookingNotFoundException(){
        super("对不起，您要找的预订不存在");
    }

    public BookingNotFoundException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        return 5;
//    }
}
