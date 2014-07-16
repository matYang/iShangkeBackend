package com.ishangke.edunav.web.user.controller.user.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/user/smsVerification")

public class UserCellPhoneVerificationController extends AbstractController{

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody JsonResponse<String> cellPhoneVerificationGet(@RequestParam("cellNum") String cellNum) {
		JsonResponse<String> result = new JsonResponse<>();
		result.setMessage("success");
		result.setStatus(0);
		result.setResponse("cellNum is: " + cellNum);
		return result;
	}
}
