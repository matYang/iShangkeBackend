package com.ishangke.edunav.manager.exception;

public class ManagerException extends RuntimeException {
    private static final long serialVersionUID = 1730598997442096241L;

    private String errorMessage;
    private int errorCode;

    /**
     * Initializes the ManagerException.
     * 
     * @param message
     *            Exception message
     * @param errorCode
     *            Error code
     */
    public ManagerException(String message, int errorCode) {
        super(message);
        this.errorMessage = message;
        this.errorCode = errorCode;
    }

    /**
     * Initializes the ManagerException.
     * 
     * @param message
     *            Exception message
     * @param errorCode
     *            Error code
     * @param cause
     *            Inner exception
     */
    public ManagerException(String message, int errorCode, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
        this.errorCode = errorCode;
    }

    public ManagerException() {
        super();
    }

    public ManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerException(String message) {
        super(message);
    }

    public ManagerException(Throwable cause) {
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
