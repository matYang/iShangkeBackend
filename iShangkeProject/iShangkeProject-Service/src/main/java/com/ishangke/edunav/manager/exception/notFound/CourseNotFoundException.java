package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class CourseNotFoundException extends ManagerException{

    private static final long serialVersionUID = 3282739612254901647L;


    public CourseNotFoundException(){
        super("对不起，您要找的课程不存在");
    }

    public CourseNotFoundException(String exceptionText){
        super(exceptionText);
    }

    @Override
    public int getCode() {
        return 3;
    }
}
