package com.ishangke.edunav.facade.partner;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.commoncontract.model.CareerPageViewBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CategoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.CirclePageViewBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.LocationPageViewBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.commoncontract.model.SchoolPageViewBo;
import com.ishangke.edunav.commoncontract.service.GeneralService;
import com.ishangke.edunav.commoncontract.service.GeneralService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.PermissionCache;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;
import com.ishangke.edunav.web.exception.ControllerException;

@Component
@Scope(value = "singleton")
public class GeneralFacade {

    public CategoryPageViewBo queryCategory(CategoryBo categoryBo, PaginationBo paginationBo, String permissionTag) {
        CategoryPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.General.getName());

        try (ThriftClientFactory<GeneralService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCategory(categoryBo, paginationBo, PermissionCache.getTag(permissionTag));  
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public LocationPageViewBo queryLocation(LocationBo locationBo, PaginationBo paginationBo, String permissionTag) {
        LocationPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.General.getName());

        try (ThriftClientFactory<GeneralService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryLocation(locationBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CirclePageViewBo queryCircle(CircleBo circleBo, PaginationBo paginationBo, String permissionTag) {
        CirclePageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.General.getName());

        try (ThriftClientFactory<GeneralService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCircle(circleBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public SchoolPageViewBo querySchool(SchoolBo schoolBo, PaginationBo paginationBo, String permissionTag) {
        SchoolPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.General.getName());

        try (ThriftClientFactory<GeneralService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.querySchool(schoolBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CareerPageViewBo queryCareer(CareerBo careerBo, PaginationBo paginationBo, String permissionTag) {
        CareerPageViewBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.General.getName());

        try (ThriftClientFactory<GeneralService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCareer(careerBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }
}
