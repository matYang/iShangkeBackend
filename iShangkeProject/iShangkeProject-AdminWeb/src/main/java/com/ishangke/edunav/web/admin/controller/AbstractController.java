package com.ishangke.edunav.web.admin.controller;

import org.springframework.stereotype.Controller;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.web.controller.PseudoController;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
public class AbstractController extends PseudoController{
    //general controller utilitiy functioanlities are implemented in PseudoController
    //module specific functionalities can be added here
    /**
     * Handles web exception and return json result.
     * 
     * @param exception
     *            web exception
     * @param logger
     *            controller logger
     * @return json result
     */
    public <T> JsonResponse<T> handleWebException(Exception exception) {

        if (exception instanceof BusinessExceptionBo) {
            BusinessExceptionBo faultException = (BusinessExceptionBo) exception;
            int errorCode = faultException.getErrorCode();
            String msgKey = faultException.getMessageKey();

            return new JsonResponse<T>();
        } else {
            return new JsonResponse<T>();
        }
    }
}
