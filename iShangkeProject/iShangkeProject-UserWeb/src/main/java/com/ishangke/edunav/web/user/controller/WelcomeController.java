package com.ishangke.edunav.web.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.WebConstants;
import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.vo.QueryVo;

@Controller
@RequestMapping("/api/v2/welcome")
public class WelcomeController extends AbstractController {
    @Autowired
    private UserFacade userFacade;    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse<String> welcomePost(@RequestBody QueryVo queryVo, HttpServletRequest request) {
        String url = String.valueOf(request.getAttribute(WebConstants.REQUEST_URL));
        String name = queryVo.getName();
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage(url);
        result.setStatus(0);
        result.setResponse("Welcome, " + name + "! [POST]");

        LoginBo loginBo = new LoginBo();
        loginBo.setPassword("123");
        loginBo.setAccountIdentifier("abc");
        //userFacade.loginByPhone(loginBo, url);

        return result;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse<String> welcomeGet(@PathVariable("name") String name, HttpServletRequest request) {
        String url = String.valueOf(request.getAttribute(WebConstants.REQUEST_URL));
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage(url);
        result.setStatus(0);
        result.setResponse("Welcome, " + name + "! [GET]");
        return result;
    }
}
