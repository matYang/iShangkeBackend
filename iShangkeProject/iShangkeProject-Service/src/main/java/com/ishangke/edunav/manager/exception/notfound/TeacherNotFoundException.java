package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class TeacherNotFoundException extends ManagerException{

    /**
     * 
     */
    private static final long serialVersionUID = -2710665349712730743L;

    public TeacherNotFoundException(){
        super("对不起，您要找的教师不存在");
    }

    public TeacherNotFoundException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        return 10;
//    }
}
