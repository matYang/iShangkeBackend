package com.ishangke.edunav.web.exception;

public class ControllerException extends RuntimeException {
    private static final long serialVersionUID = -7704479922870911157L;
    
    private String errorMessage;
    //controller excetions by default all have 400 responses
    private int errorCode = 400;
    
    private int msgKey;

    public ControllerException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public int getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(int msgKey) {
        this.msgKey = msgKey;
    }

    public ControllerException(int msgKey) {
        this.msgKey = msgKey;
    }
    
    public ControllerException(int msgKey, Throwable cause) {
        super(cause);
        this.msgKey = msgKey;
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
