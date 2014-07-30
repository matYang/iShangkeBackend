package com.ishangke.edunav.web.user.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/user")

public class UserController extends AbstractController{
    
    @Autowired
    UserFacade userFacade;
    
    @RequestMapping(value = "registration", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody UserVo registUser(@RequestBody UserVo UserVo, HttpServletRequest req, HttpServletResponse resp) {
        UserVo responseVo = null;
        
        
        
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse<String> getUser(@PathVariable("id") int id) {
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage("success");
        result.setStatus(0);
        result.setResponse("Get User id is: " + id + "! [GET]");
        return result;
    }
}
