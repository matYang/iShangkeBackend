package com.ishangke.edunav.web.response;

import com.ishangke.edunav.common.constant.Constant;

//This represents the empty reponse used in successful calls to some of the APIs eg deletions
public class EmptyResponse extends JsonResponse{
    private String result = Constant.SUCCESS;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
