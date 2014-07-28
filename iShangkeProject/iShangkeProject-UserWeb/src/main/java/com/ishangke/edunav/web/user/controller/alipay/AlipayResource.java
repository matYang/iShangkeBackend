package com.ishangke.edunav.web.user.controller.alipay;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ishangke.edunav.facade.alipay.AlipayFacade;
import com.ishangke.edunav.web.common.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/alipay/alipay/notify_Url")
public class AlipayResource extends AbstractController{

    @Autowired
    private AlipayFacade alipayFacade;
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public JsonResponse processAlipayFeedback(HttpServletRequest request){
        JsonResponse result = new JsonResponse();
        result.setMessage("fail");
        String notifyId = null;
        String tradeStatus = null;
        String verified = null;
        
        notifyId = request.getParameter("notify_id");
        verified = alipayFacade.verify_notify_id(notifyId);
        if (verified.equals("true")) {
            tradeStatus = request.getParameter("trade_status");
            if (tradeStatus.equals("TRADE_SUCCESS")) {
                int orderId = Integer.parseInt(request.getParameter("out_trade_no"));
                alipayFacade.changeBookingStatusToPayed(orderId);
                result.setMessage("success");                
            } 
        }
        
        return result;
        
    }
}
