package com.ishangke.edunav.web.user.controller.alipay;

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
import com.ishangke.edunav.web.user.vo.AlipayVo;

@Controller
@RequestMapping("/api/v2.0/alipay/alipay/return_Url")
public class AlipayIdResource extends AbstractController {

    @Autowired
    private AlipayFacade alipayFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ModelAndView processUserAlipayFeedBack(@RequestBody AlipayVo alipayVo, HttpServletRequest request) {
        String success = null;
        String notify_id = null;
        String tradeStatus = null;
        String verified = null;
        String notify_time = null;
        Calendar now = DateUtility.getCurTimeInstance();
        now.add(Calendar.SECOND, 60);
        String max = DateUtility.toSQLDateTime(now);

        success = alipayVo.getTrade_status();
        if (success.equals("T")) {
            notify_id = alipayVo.getNotify_id();
            try {
                notify_time = UrlEncoding.decodeURI(alipayVo.getNotify_time());
            } catch (UnsupportedEncodingException e) {
                return new ModelAndView("redirect:http://usertest.ishangke.cn/alipay/fail.html");
            }
            if (max.compareTo(notify_time) <= 0) {
                return new ModelAndView("redirect:http://usertest.ishangke.cn/alipay/fail.html");
            }

            verified = alipayFacade.verify_notify_id(notify_id);
            if (verified.equals("true")) {
                tradeStatus = alipayVo.getTrade_status();
                if (tradeStatus.equals("TRADE_SUCCESS")) {
                    alipayFacade.changeBookingStatusToPayed(Integer.parseInt(alipayVo.getOut_trade_no()));
                    return new ModelAndView("redirect:http://usertest.ishangke.cn/alipay/success.html");
                } else {
                    return new ModelAndView("redirect:http://usertest.ishangke.cn/alipay/fail.html");
                }
            } else {
                return new ModelAndView("redirect:http://usertest.ishangke.cn/alipay/fail.html");
            }

        } else {
            return new ModelAndView("redirect:http://usertest.ishangke.cn/alipay/fail.html");
        }

    }
}
