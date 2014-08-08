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
        System.out.println("1@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String notifyId = null;
        String tradeStatus = null;
        String verified = null;
        String total_fee = null;
        System.out.println("2@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        notifyId = request.getParameter("notify_id");
        System.out.println("3@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        verified = alipayFacade.verify_notify_id(notifyId);
        System.out.println("4@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        total_fee = request.getParameter("total_fee");
        System.out.println("5@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // Check Sign
        if (verified.equals("true")) {
            System.out.println("6@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            tradeStatus = request.getParameter("trade_status");
            System.out.println("7@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if (tradeStatus.equals("TRADE_SUCCESS")) {
                System.out.println("8@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                int orderId = Integer.parseInt(request.getParameter("out_trade_no"));
                System.out.println("9@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                alipayFacade.changeBookingStatusToPayed(orderId);
                System.out.println("10@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                // Change the status of the order
                return "success";
            }
        }
        System.out.println("11@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "fail";

    }
}
