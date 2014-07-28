package com.ishangke.edunav.web.user.controller.alipay;

import java.awt.PageAttributes.MediaType;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.encoding.UrlEncoding;
import com.ishangke.edunav.facade.user.AlipayFacade;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/alipay/alipay/return_Url")
public class AlipayIdResource extends AbstractController {

    @Autowired
    private AlipayFacade alipayFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public String processUserAlipayFeedBack(HttpServletRequest request) {
        String success = null;
        String notify_id = null;
        String tradeStatus = null;
        String verified = null;
        String notify_time = null;
        Calendar now = DateUtility.getCurTimeInstance();
        now.add(Calendar.SECOND, 60);
        String max = DateUtility.toSQLDateTime(now);

        success = request.getParameter("is_success");
        if (success.equals("T")) {
            notify_id = request.getParameter("notify_id");
            try {
                notify_time = UrlEncoding.decodeURI(request.getParameter("notify_time"));
            } catch (UnsupportedEncodingException e) {
                return "redirect:http://usertest.ishangke.cn/alipay/alipay/fail.html";

            }
            if (notify_time == null) {
                return "redirect:http://usertest.ishangke.cn/alipay/alipay/fail.html";
            }
            if (max.compareTo(notify_time) <= 0) {
                return "redirect:http://usertest.ishangke.cn/alipay/alipay/fail.html";
            }

            verified = alipayFacade.verify_notify_id(notify_id);
            if (verified.equals("true")) {
                tradeStatus = request.getParameter("trade_status");
                if (tradeStatus.equals("TRADE_SUCCESS")) {
                    alipayFacade.changeBookingStatusToPayed(Integer.parseInt(request.getParameter("out_trade_no")));
                    return "redirect:http://usertest.ishangke.cn/alipay/alipay/success.html";
                } else {
                    return "redirect:http://usertest.ishangke.cn/alipay/alipay/fail.html";
                }
            } else {
                return "redirect:http://usertest.ishangke.cn/alipay/alipay/fail.html";
            }

        } else {
            return "redirect:http://usertest.ishangke.cn/alipay/alipay/fail.html";
        }

    }
}
