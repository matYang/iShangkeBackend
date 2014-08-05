package com.ishangke.edunav.web.exception;

public class ControllerException extends RuntimeException {
    private static final long serialVersionUID = -7704479922870911157L;

    private String message;
    // controller excetions by default all have 400 responses
    private int errorCode;

    private String msgKey;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }
    
    public ControllerException(String message) {
        this.message = message;
    }

    public ControllerException(int errorCode, String msgKey) {
        this.errorCode = errorCode;
        this.msgKey = msgKey;
    }

    public ControllerException(int errorCode, String msgKey, Throwable t) {
        super(t);
        this.errorCode = errorCode;
        this.msgKey = msgKey;
    }

    public ControllerException(int errorCode, String msgKey, String message) {
        this.errorCode = errorCode;
        this.msgKey = msgKey;
        this.message = message;
    }

    public ControllerException(int errorCode, String msgKey, String message, Throwable t) {
        super(t);
        this.errorCode = errorCode;
        this.msgKey = msgKey;
        this.message = message;
    }

}
