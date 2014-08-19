package com.ishangke.edunav.facade.user;

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
import com.ishangke.edunav.web.exception.ControllerException;

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
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
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
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public String buildFormForPost(String subject, String out_trade_no, String total_fee) {
        String result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.buildFormForPost(subject, out_trade_no, total_fee);
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String changeBookingStatusToPayed(int bookingId, String trade_no) {
        String result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.changeBookingStatusToPayed(bookingId, trade_no);
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }
}
