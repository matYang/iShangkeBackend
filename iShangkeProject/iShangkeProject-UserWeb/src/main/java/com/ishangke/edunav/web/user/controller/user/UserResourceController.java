package com.ishangke.edunav.web.user.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;
import com.ishangke.edunav.web.user.vo.QueryVo;

@Controller
@RequestMapping("/api/v2/user/user")

public class UserResourceController extends AbstractController{
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody JsonResponse<String> registUser(@RequestBody QueryVo queryVo) {
		JsonResponse<String> result = new JsonResponse<>();
		result.setMessage("success");
		result.setStatus(0);
		result.setResponse("Regist User name is: " + queryVo.getName() + "! [GET]");
		return result;
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
