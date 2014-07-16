package com.ishangke.edunav.web.user.controller.user.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/user/findSession")

public class UserSessionRedirectController extends AbstractController{

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody JsonResponse<String> sessionRedirectGet() {
		JsonResponse<String> result = new JsonResponse<>();
		result.setMessage("success");
		result.setStatus(0);
		result.setResponse("User FindSession ! [GET]");
		return result;
	}

}
