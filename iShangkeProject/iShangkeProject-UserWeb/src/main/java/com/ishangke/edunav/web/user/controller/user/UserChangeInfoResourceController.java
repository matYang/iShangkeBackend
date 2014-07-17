package com.ishangke.edunav.web.user.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/user/info")

public class UserChangeInfoResourceController extends AbstractController{

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json" , produces = "application/json")
	public @ResponseBody JsonResponse<String> changePassword(@PathVariable("id") int id) {
		JsonResponse<String> result = new JsonResponse<>();
		result.setMessage("success");
		result.setStatus(0);
		result.setResponse("Change User Info id is: " + id);
		return result;
	}
}
