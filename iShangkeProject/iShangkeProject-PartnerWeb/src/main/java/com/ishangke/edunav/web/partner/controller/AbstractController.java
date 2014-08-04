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
    public JsonResponse handleWebException(Exception exception, HttpServletResponse resp) {

        if (exception instanceof ControllerException) {
            ControllerException faultException = (ControllerException) exception;
            String errorMessage = faultException.getErrorMessage();
            int msgKey = faultException.getMsgKey();
            resp.setStatus(400);
            return new JsonResponse();
        } else {
            return new JsonResponse();
        }
    }
}
