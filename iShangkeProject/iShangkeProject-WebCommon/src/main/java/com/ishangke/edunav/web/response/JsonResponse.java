package com.ishangke.edunav.web.response;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class JsonResponse {
    private int errorCode;
    private String msgKey;
    private String message;
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
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public JsonResponse() {
        
    }
    
    public JsonResponse(int errorCode, String msgKey) {
        this.errorCode = errorCode;
        this.msgKey = msgKey;
    }
    
    public JsonResponse(int errorCode, String msgKey, String message) {
        this.errorCode = errorCode;
        this.msgKey = msgKey;
        this.message = message;
    }
}