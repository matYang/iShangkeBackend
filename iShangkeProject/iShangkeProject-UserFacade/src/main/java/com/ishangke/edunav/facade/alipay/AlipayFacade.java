package com.ishangke.edunav.facade.alipay;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.service.BookingService;
import com.ishangke.edunav.commoncontract.service.BookingService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;

@Component
@Scope(value = "singleton")
public class AlipayFacade {

    public String verify_notify_id(String notify_id) {
        String result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.verify(notify_id);
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public String buildFormForGet(String subject, String out_trade_no, String total_fee) {
        String result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.buildFormForGet(subject, out_trade_no, total_fee);
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public String changeBookingStatusToPayed(int orderId) {
        String result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.changeBookingStatusToPayed(orderId);
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
