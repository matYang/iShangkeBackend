package com.ishangke.edunav.web.user.controller.user.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;
import com.ishangke.edunav.web.user.vo.QueryVo;

@Controller
@RequestMapping("/api/v2/user/forgetPassword")

public class UserForgetPasswordController extends AbstractController{

//TODO Forget Password GET
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json" , produces = "application/json")
	public @ResponseBody JsonResponse<String> recoverPassword(@RequestBody QueryVo queryVo) {
		JsonResponse<String> result = new JsonResponse<>();
		result.setMessage("success");
		result.setStatus(0);
		result.setResponse("Recover User Password name is: " + queryVo.getName());
		return result;
	}
}
