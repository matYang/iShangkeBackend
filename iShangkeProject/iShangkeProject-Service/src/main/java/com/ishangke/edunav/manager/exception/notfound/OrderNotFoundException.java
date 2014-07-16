package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class OrderNotFoundException extends ManagerException{

    /**
     * 
     */
    private static final long serialVersionUID = 3131891105982213334L;

    public OrderNotFoundException(){
        super("对不起，您要找的订单不存在");
    }

    public OrderNotFoundException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        //TODO
//        return -1;
//    }
}
