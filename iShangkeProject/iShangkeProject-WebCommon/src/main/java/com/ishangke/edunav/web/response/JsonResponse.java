package com.ishangke.edunav.web.response;

public class JsonResponse {
    private int msgKey;
    private String message;

    public int getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(int msgKey) {
        this.msgKey = msgKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}