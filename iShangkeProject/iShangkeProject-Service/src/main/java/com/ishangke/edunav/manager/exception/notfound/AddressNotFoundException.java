package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class AddressNotFoundException extends ManagerException{

    /**
     * 
     */
    private static final long serialVersionUID = 2109823935259825700L;

    public AddressNotFoundException(){
        super("对不起，您要找的地址不存在");
    }

    public AddressNotFoundException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        //TODO
//        return -1;
//    }
}
