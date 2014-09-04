package com.ishangke.edunav.web.mobile.controller.alipay;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.facade.user.AlipayFacade;
import com.ishangke.edunav.web.mobile.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/alipay/notify_Url")
public class AlipayController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlipayController.class);

    @Autowired
    private AlipayFacade alipayFacade;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    String processAlipayFeedback(HttpServletRequest request) {
        String notifyId = null;
        String tradeStatus = null;
        String verified = null;
        String total_fee = null;
        String trade_no = null;
        notifyId = request.getParameter("notify_id");
        verified = alipayFacade.verify_notify_id(notifyId);
        total_fee = request.getParameter("total_fee");
        // 支付宝交易流水号
        trade_no = request.getParameter("trade_no");
        // Check Sign
        if (verified.equals("true")) {
            tradeStatus = request.getParameter("trade_status");
            if (tradeStatus.equals("TRADE_SUCCESS")) {
                String out_trade_no = request.getParameter("out_trade_no");
                String[] nos = out_trade_no.split("-");
                int bookingId = Integer.parseInt(nos[nos.length - 1]);
                alipayFacade.changeBookingStatusToPayed(bookingId, trade_no);
                // Change the status of the order
                return "success";
            }
        }
        return "fail";

    }
}
