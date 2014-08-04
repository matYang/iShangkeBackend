package com.ishangke.edunav.facade.user;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.BookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.BookingService;
import com.ishangke.edunav.commoncontract.service.BookingService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.PermissionCache;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;
import com.ishangke.edunav.web.exception.ControllerException;

@Component
@Scope(value = "singleton")
public class BookingFacade {
    public BookingBo createBookingByUser(BookingBo bookingBo, UserBo userBo, String permissionTag) {
        BookingBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createBookingByUser(bookingBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

   public BookingBo transformBookingStatus(BookingBo bookingBo, int operation, UserBo userBo, String permissionTag) {
        BookingBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.transformBookingStatus(bookingBo, operation, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

   public BookingPageViewBo queryBooking(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        BookingPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryBooking(bookingBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

   public BookingHistoryPageViewBo queryHistory(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        BookingHistoryPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryHistory(bookingHistoryBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

   public BookingHistoryPageViewBo queryHistoryByBookingId(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        BookingHistoryPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryHistoryByBookingId(bookingHistoryBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
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
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

   public String verify(String notify_id) {
        String result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.verify(notify_id);
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
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
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

}
