package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class CourseNotFoundException extends ManagerException{

    private static final long serialVersionUID = -1622119956667147758L;

    public CourseNotFoundException(){
        super("对不起，您要找的课程不存在");
    }

    public CourseNotFoundException(String exceptionText){
        super(exceptionText);
    }

     public CourseNotFoundException(String message, int errorCode){
    	super(message,errorCode);
    } 
    
    public CourseNotFoundException(String message, int errorCode, Throwable cause){
    	super(message,errorCode,cause);
    }
}
