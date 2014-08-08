package com.ishangke.edunav.web.user.controller.alipay;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(AlipayController.class);

    @Autowired
    private AlipayFacade alipayFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    String processAlipayFeedback(HttpServletRequest request) {
        LOGGER.error("1@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String notifyId = null;
        String tradeStatus = null;
        String verified = null;
        String total_fee = null;
        LOGGER.error("2@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        notifyId = request.getParameter("notify_id");
        LOGGER.error("3@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        verified = alipayFacade.verify_notify_id(notifyId);
        LOGGER.error("4@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        total_fee = request.getParameter("total_fee");
        LOGGER.error("5@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // Check Sign
        if (verified.equals("true")) {
            LOGGER.error("6@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            tradeStatus = request.getParameter("trade_status");
            LOGGER.error("7@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if (tradeStatus.equals("TRADE_SUCCESS")) {
                LOGGER.error("8@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                int orderId = Integer.parseInt(request.getParameter("out_trade_no"));
                LOGGER.error("9@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                alipayFacade.changeBookingStatusToPayed(orderId);
                LOGGER.error("10@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                // Change the status of the order
                return "success";
            }
        }
        LOGGER.error("11@!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "fail";

    }
}
