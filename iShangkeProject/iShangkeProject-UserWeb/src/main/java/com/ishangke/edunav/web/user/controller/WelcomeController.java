package com.ishangke.edunav.web.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.WebConstants;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.user.common.JsonResponse;

@Controller
@RequestMapping("/api/v2/welcome")
public class WelcomeController extends AbstractController {
    @Autowired
    private UserFacade userFacade;    

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse<String> welcomeGet(UserVo user, HttpServletRequest request) {
        String url = String.valueOf(request.getAttribute(WebConstants.REQUEST_URL));
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage(url);
        result.setStatus(0);
        String responseStr = "";
        String name = "";
        if (user != null) {
            if (user.getIdSet() != null) {
                for (Integer id : user.getIdSet()) {
                    responseStr += " id: " + id;
                }
            }
            name = user.getName();
        }
        
        result.setResponse("Welcome, " + name + "! " + responseStr + "  [GET]");
        return result;
    }
}
