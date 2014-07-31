package com.ishangke.edunav.web.user.common;

import com.ishangke.edunav.common.constant.Constant;

//This represents the empty reponse used in successful calls to some of the APIs eg deletions
public class EmptyResponse {
    private String result = Constant.SUCCESS;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
