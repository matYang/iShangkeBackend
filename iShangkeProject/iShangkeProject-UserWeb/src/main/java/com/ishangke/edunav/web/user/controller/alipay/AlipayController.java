package com.ishangke.edunav.web.user.controller.alipay;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ishangke.edunav.facade.user.AlipayFacade;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/alipay/alipay/notify_Url")
public class AlipayController extends AbstractController {

    @Autowired
    private AlipayFacade alipayFacade;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/*")
    public @ResponseBody
    String processAlipayFeedback(HttpServletRequest request) {
        String notifyId = null;
        String tradeStatus = null;
        String verified = null;
        String total_fee = null;
        
        notifyId = request.getParameter("notify_id");
        verified = alipayFacade.verify_notify_id(notifyId);
        total_fee = request.getParameter("total_fee");
        // Check Sign
        if (verified.equals("true")) {
            tradeStatus = request.getParameter("trade_status");
            if (tradeStatus.equals("TRADE_SUCCESS")) {
                
                int orderId = Integer.parseInt(request.getParameter("out_trade_no"));
                alipayFacade.changeBookingStatusToPayed(orderId);
                // Change the status of the order
                return "success";
            }
        }

        return "fail";

    }
}
