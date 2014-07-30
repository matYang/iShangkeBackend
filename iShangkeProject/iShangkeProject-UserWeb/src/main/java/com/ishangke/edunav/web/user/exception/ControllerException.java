package com.ishangke.edunav.web.user.exception;

public class ControllerException extends RuntimeException {
    private static final long serialVersionUID = -7704479922870911157L;
    
    private String errorMessage;
    //controller excetions by default all have 400 responses
    private int errorCode = 400;


    public ControllerException(String message) {
        super(message);
        this.errorMessage = message;
    }


    public ControllerException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }

    public ControllerException() {
        super();
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
