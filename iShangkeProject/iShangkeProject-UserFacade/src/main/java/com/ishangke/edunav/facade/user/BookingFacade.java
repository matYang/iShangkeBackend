package com.ishangke.edunav.facade.user;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.BookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityPageViewBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PurposeCourseBo;
import com.ishangke.edunav.commoncontract.model.PurposeCoursePageViewBo;
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
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public BookingBo createBookingByAnonymousUser(BookingBo bookingBo) {
        BookingBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createBookingByAnonymousUser(bookingBo);
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
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
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
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
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
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
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
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

    public String verify(String notify_id) {
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

    public String buildFormForGet(String subject, String out_trade_no, String total_fee, String type) {
        String result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.buildFormForGet(subject, out_trade_no, total_fee, type);
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public OrderBo createOrderByUser(OrderBo orderBo, UserBo userBo, String permissionTag) {
        OrderBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createOrderByUser(orderBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public OrderBo queryOrderById(OrderBo orderBo, UserBo userBo, String permissionTag) {
        OrderBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryOrderById(orderBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public BookingBo queryBookingById(int id, UserBo userBo, String permissionTag) {
        BookingBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());

        try (ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryBookingById(id, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();    
            throw new ControllerException(e.getErrorCode(), e.getMessageKey(), e.getMessage());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public PurposeCoursePageViewBo queryPurpose(PurposeCourseBo purposeCourseBo,UserBo userBo,PaginationBo paginationBo,String permissionTag){
        PurposeCoursePageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryPurpose(purposeCourseBo, userBo, paginationBo, permissionTag);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public PurposeCourseBo createPurpose(PurposeCourseBo purposeCourseBo,UserBo userBo,String permissionTag){
        PurposeCourseBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createPurpose(purposeCourseBo, userBo, permissionTag);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public PurposeCourseBo updatePurpose(PurposeCourseBo purposeCourseBo,UserBo userBo,String permissionTag){
        PurposeCourseBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.updatePurpose(purposeCourseBo, userBo, permissionTag);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public PurposeCourseBo deletePurpose(PurposeCourseBo purposeCourseBo,UserBo userBo,String permissionTag){
        PurposeCourseBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deletePurpose(purposeCourseBo, userBo, permissionTag);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public GroupBuyBookingBo createGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo,UserBo userBo,String permissionTag){
        GroupBuyBookingBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createGroupBuyBooking(groupBuyBookingBo, userBo, permissionTag);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public GroupBuyBookingPageViewBo queryGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo,UserBo userBo,PaginationBo paginationBo,String permissionTag){
        GroupBuyBookingPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryGroupBuyBooking(groupBuyBookingBo, userBo, paginationBo, permissionTag);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public GroupBuyBookingBo queryGroupBuyBookingById(int id,UserBo userBo,String permissionTag){
        GroupBuyBookingBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryGroupBuyBookingById(id, userBo, permissionTag);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public GroupBuyActivityPageViewBo queryGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo,
    		PaginationBo paginationBo){
        GroupBuyActivityPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryGroupBuyActivity(groupBuyActivityBo, paginationBo);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public GroupBuyActivityBo queryGroupBuyActivityById(int id){
        GroupBuyActivityBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Booking.getName());
        
        try(ThriftClientFactory<BookingService.Client> factory = new ThriftClientFactory<>(clientSetting)){
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryGroupBuyActivityById(id);
        }catch(BusinessExceptionBo e){
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(),e.getMessageKey(),e.getMessage());
        }catch(TException e){
            e.printStackTrace();
        }
        return result;
    }
}
