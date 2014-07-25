package com.ishangke.edunav.thrift;

public class ThriftException extends RuntimeException {
    private static final long serialVersionUID = 4930647553907021818L;

    private String errorMessage;
    private int errorCode;

    /**
     * Initializes the ThriftException.
     * 
     * @param message
     *            Exception message
     * @param errorCode
     *            Error code
     */
    public ThriftException(String message, int errorCode) {
        super(message);
        this.errorMessage = message;
        this.errorCode = errorCode;
    }

    /**
     * Initializes the ThriftException.
     * 
     * @param message
     *            Exception message
     * @param errorCode
     *            Error code
     * @param cause
     *            Inner exception
     */
    public ThriftException(String message, int errorCode, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
        this.errorCode = errorCode;
    }

    public ThriftException() {
        super();
    }

    public ThriftException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMessage = message;
    }

    public ThriftException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }

    public ThriftException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public ThriftException(Throwable cause) {
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

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
