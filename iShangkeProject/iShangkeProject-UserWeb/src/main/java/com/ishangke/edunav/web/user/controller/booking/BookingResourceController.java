package com.ishangke.edunav.web.user.controller.booking;

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
@RequestMapping("/api/v2/booking/booking")

public class BookingResourceController extends AbstractController{
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse<String> createBooking(@RequestBody QueryVo queryVo) {
        String name = queryVo.getName();
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage("success");
        result.setStatus(0);
        result.setResponse("Create Booking name is: , " + name);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse<String> getBookingById(@PathVariable("id") String id) {
    	int b_Id = Integer.parseInt(id);
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage("success");
        result.setStatus(0);
        result.setResponse("Get Booking id: , " + b_Id);
        return result;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse<String> getBookings() {    	
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage("success");
        result.setStatus(0);       
        return result;
    }

}
