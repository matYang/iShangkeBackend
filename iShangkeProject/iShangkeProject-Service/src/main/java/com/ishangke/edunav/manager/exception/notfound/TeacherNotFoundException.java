package com.ishangke.edunav.manager.exception.notfound;

import com.ishangke.edunav.manager.exception.ManagerException;

public class TeacherNotFoundException extends ManagerException {

    private static final long serialVersionUID = -2710665349712730743L;

    public TeacherNotFoundException() {
        super("对不起，您要找的教师不存在");
    }

    public TeacherNotFoundException(String exceptionText) {
        super(exceptionText);
    }

    public TeacherNotFoundException(String message, int errorCode) {
        super(message, errorCode);
    }

    public TeacherNotFoundException(String message, int errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
