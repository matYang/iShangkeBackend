package com.ishangke.edunav.manager.exception.notFound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class ClassPhotoNotFoundException extends ManagerException{

    private static final long serialVersionUID = 1356275365147457580L;


    public ClassPhotoNotFoundException(){
        super("对不起，您要找的课程图片不存在");
    }

    public ClassPhotoNotFoundException(String exceptionText){
        super(exceptionText);
    }

//    @Override
//    public int getCode() {
//        return 9;
//    }
}
