package com.ishangke.edunav.caiwu.alipay;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.manager.caiwu.alipay.AlipayConfig;
import com.ishangke.edunav.manager.caiwu.alipay.AlipayCore;
import com.ishangke.edunav.manager.caiwu.alipay.AlipayNotify;
import com.ishangke.edunav.manager.caiwu.alipay.AlipaySubmit;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, AlipayTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
public class AlipayTest extends BaseTest {

    private String out_trade_no = "ryV0Uvr5Na";
    private String subject = "南京爱上课信息技术支付宝测试";
    private String total_fee = "0.01";
    private String notify_id = "RqPnCoPT3K9%252Fvwbh3InR9wvgZEjW6l6heQkaa56V0KncfZBQ033J98aiJpv8uPNCfJ6s";
    private String sign = "";

    @Test
    public void testSubmit() {
        System.out.println();
        System.out.println(AlipaySubmit.buildFormForGet(out_trade_no, subject, total_fee));
    }

    // @Test
    public void testReturn() {
        // The following part should be built in API layer
        Map<String, String> sPara = new HashMap<String, String>();
        sPara.put("service", "create_direct_pay_by_user");
        sPara.put("partner", AlipayConfig.partner);
        sPara.put("sign_type", AlipayConfig.sign_type);
        // sPara.put("sign", sign);
        sPara.put("notify_url", AlipayConfig.notify_url);
        sPara.put("return_url", AlipayConfig.return_url);
        sPara.put("out_trade_no", out_trade_no);
        sPara.put("subject", subject);
        sPara.put("payment_type", AlipayConfig.payment_type);
        sPara.put("total_fee", total_fee);
        sPara.put("seller_id", AlipayConfig.seller_id);

        // if (!AlipayNotify.isSignValide(sPara)) {
        // fail();
        // }

        String result = AlipayNotify.Verify(notify_id);

        if (result.equals("false")) {
            fail();
            System.out.println();
            System.out.println("Is sent from 支付宝 ？ ：" + result);
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Is sent from 支付宝 ？ ：" + result);
            System.out.println();
        }
    }

//    @Test
//    public void testPost() {
//        System.out.println();
//        System.out.println(AlipaySubmit.buildFormForPost(out_trade_no, notify_id));
//    }
}
