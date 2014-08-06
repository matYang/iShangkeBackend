package com.ishangke.edunav.web.partner.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.ishangke.edunav.web.controller.PseudoController;
import com.ishangke.edunav.web.exception.ControllerException;
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
    public JsonResponse handleWebException(Exception exception, HttpServletResponse resp) {

        if (exception instanceof ControllerException) {
            ControllerException faultException = (ControllerException) exception;
            int errorCode = faultException.getErrorCode();
            String msgKey = faultException.getMsgKey();
            String message = faultException.getMessage();
            resp.setStatus(400);
            return new JsonResponse(errorCode, msgKey, message);
        } else {
            return new JsonResponse();
        }
    }
}
