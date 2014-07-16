package com.ishangke.edunav.web.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.vo.QueryVo;

@Controller
@RequestMapping("/api/v2/welcome")
public class WelcomeController extends AbstractController {

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse<String> welcomePost(@RequestBody QueryVo queryVo) {
        String name = queryVo.getName();
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage("success");
        result.setStatus(0);
        result.setResponse("Welcome, " + name + "! [POST]");
        return result;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse<String> welcomeGet(@PathVariable("name") String name) {
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage("success");
        result.setStatus(0);
        result.setResponse("Welcome, " + name + "! [GET]");
        return result;
    }
}
