package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class ClassPhotoNotFoundException extends ManagerException {

    private static final long serialVersionUID = -1440285399109903136L;

    public ClassPhotoNotFoundException() {
        super("对不起，您要找的课程图片不存在");
    }

    public ClassPhotoNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public ClassPhotoNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public ClassPhotoNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
