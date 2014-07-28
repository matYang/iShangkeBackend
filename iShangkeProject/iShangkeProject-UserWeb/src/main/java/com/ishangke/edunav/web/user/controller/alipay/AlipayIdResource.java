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

import com.ishangke.edunav.common.enums.BookingEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.encoding.UrlEncoding;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.facade.alipay.AlipayFacade;
import com.ishangke.edunav.facade.booking.BookingFacade;
import com.ishangke.edunav.web.common.WebConstants;
import com.ishangke.edunav.web.user.common.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;
import com.ishangke.edunav.web.user.vo.AlipayVo;

@Controller
@RequestMapping("/api/v2.0/alipay/alipay/return_Url")
public class AlipayIdResource extends AbstractController {
    
    @Autowired
    private AlipayFacade alipayFacade;
    @Autowired
    private BookingFacade bookingFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    JsonResponse<String> welcomeGet(@RequestBody AlipayVo alipayVo, HttpServletRequest request) {
        String success = null;
        String notify_id = null;
        String tradeStatus = null;
        String verified = null;
        String notify_time = null;
        Calendar now = DateUtility.getCurTimeInstance();
        now.add(Calendar.SECOND, 60);
        String max = DateUtility.toSQLDateTime(now);
        String url = String.valueOf(request.getAttribute(WebConstants.REQUEST_URL));
        
        success = alipayVo.getTrade_status();
        if (success.equals("T")) {
            notify_id = alipayVo.getNotify_id();
            try {
                notify_time = UrlEncoding.decodeURI(alipayVo.getNotify_time());
            } catch (UnsupportedEncodingException e) {
                // Redirect;
                e.printStackTrace();
            }
            if (max.compareTo(notify_time) <= 0) {
                // Redirect
            }
            
            verified = alipayFacade.verify(notify_id);
            if (verified.equals("true")){
                tradeStatus = alipayVo.getTrade_status();
                if (tradeStatus.equals("TRADE_SUCCESS")) {
                   
                    
                }
            }
            
        }

        
        JsonResponse<String> result = new JsonResponse<>();
        result.setMessage(url);
        result.setStatus(0);
        result.setResponse("Welcome");
        return result;
    }
}
