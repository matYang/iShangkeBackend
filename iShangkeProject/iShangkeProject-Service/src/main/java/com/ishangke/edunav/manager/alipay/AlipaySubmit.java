package com.ishangke.edunav.manager.alipay;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ishangke.edunav.common.utilities.DateUtility;

public class AlipaySubmit {

    public static String buildFormForGet(String out_trade_no, String subject, String total_fee) {
        Map sPara = new HashMap();
        sPara.put("service", "create_direct_pay_by_user");
        sPara.put("partner", AlipayConfig.partner);
        sPara.put("sign_type", AlipayConfig.sign_type);
        sPara.put("notify_url", AlipayConfig.notify_url);
        sPara.put("return_url", AlipayConfig.return_url);
        sPara.put("out_trade_no", out_trade_no);
        sPara.put("subject", subject);
        sPara.put("payment_type", AlipayConfig.payment_type);
        sPara.put("total_fee", total_fee);
        sPara.put("seller_id", AlipayConfig.seller_id);
        sPara.put("_input_charset", AlipayConfig.input_charset);
        sPara.put("paymethod", "bankPay");
        sPara.put("defaultbank", "COMM-DEBIT");

        Map sParaNew = AlipayCore.ParaFilter(sPara); // 除去数组中的空值和签名参数
        String mysign = AlipayCore.BuildMysign(sParaNew);// 生成签名结果

        StringBuffer sbHtml = new StringBuffer();
        List keys = new ArrayList(sParaNew.keySet());
        Collections.sort(keys);
        String gateway = "https://mapi.alipay.com/gateway.do?";

        sbHtml.append("支付跳转中...<meta http-equiv='content-type' content='text/html; charset=utf-8'><form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + gateway + "_input_charset=" + AlipayConfig.input_charset
                + "\" method=\"get\" style=\"display:none\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sParaNew.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }
        sbHtml.append("<input type=\"hidden\" name=\"sign\" value=\"" + mysign + "\"/>");
        sbHtml.append("<input type=\"hidden\" name=\"sign_type\" value=\"" + AlipayConfig.sign_type + "\"/>");

        // submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"Submit\" value=\"submit\"/></form>");

        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

        return sbHtml.toString();
    }

    public static String buildFormForPost(String out_trade_no, String subject, String total_fee) {
        Map sPara = new HashMap();
        sPara.put("service", "create_direct_pay_by_user");
        sPara.put("partner", AlipayConfig.partner);
        sPara.put("sign_type", AlipayConfig.sign_type);
        sPara.put("notify_url", AlipayConfig.notify_url);
        sPara.put("return_url", AlipayConfig.return_url);
        sPara.put("out_trade_no", out_trade_no);
        sPara.put("subject", subject);
        sPara.put("payment_type", AlipayConfig.payment_type);
        sPara.put("total_fee", total_fee);
        sPara.put("seller_id", AlipayConfig.seller_id);

        Map sParaNew = AlipayCore.ParaFilter(sPara); // 除去数组中的空值和签名参数
        String mysign = AlipayCore.BuildMysign(sParaNew);// 生成签名结果

        StringBuffer sbHtml = new StringBuffer();
        List keys = new ArrayList(sParaNew.keySet());
        Collections.sort(keys);
        String gateway = "https://mapi.alipay.com/gateway.do?";

        sbHtml.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">支付跳转中...<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + gateway + "_input_charset=" + AlipayConfig.input_charset
                + "\" method=\"post\" style=\"display:none\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sParaNew.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }
        sbHtml.append("<input type=\"hidden\" name=\"sign\" value=\"" + mysign + "\"/>");
        sbHtml.append("<input type=\"hidden\" name=\"sign_type\" value=\"" + AlipayConfig.sign_type + "\"/>");

        // submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"Submit\" value=\"submit\"/></form>");

        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

        return sbHtml.toString();

    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(AlipaySubmit.buildFormForGet("1221", "好 啊", "2.0"));
    }
}
