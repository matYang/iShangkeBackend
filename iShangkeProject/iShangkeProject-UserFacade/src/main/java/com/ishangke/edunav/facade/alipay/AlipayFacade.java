package com.ishangke.edunav.facade.alipay;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.service.AlipayService;
import com.ishangke.edunav.commoncontract.service.AlipayService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;

@Component
@Scope(value = "singleton")
public class AlipayFacade {

    public String verify(String notify_id) {
        String result = null;
//        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting("AlipayService");
//        try (ThriftClientFactory<AlipayService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
//            Client serviceClient = factory.getServiceClient();
//            result = serviceClient.verify(notify_id);
//        } catch (BusinessExceptionBo e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (TException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return result;
    }

    public String buildFormForGet(String subject, String out_trade_no, String total_fee) {
        String result = null;
//        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting("AlipayService");
//        try (ThriftClientFactory<AlipayService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
//            Client serviceClient = factory.getServiceClient();
//            result = serviceClient.buildFormForGet(subject, out_trade_no, total_fee);
//        } catch (BusinessExceptionBo e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (TException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return result;
    }

}
