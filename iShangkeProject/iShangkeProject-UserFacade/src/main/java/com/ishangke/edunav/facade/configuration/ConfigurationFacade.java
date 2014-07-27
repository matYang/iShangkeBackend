package com.ishangke.edunav.facade.configuration;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ConfigurationBo;
import com.ishangke.edunav.commoncontract.service.ConfigurationService;
import com.ishangke.edunav.commoncontract.service.ConfigurationService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;

@Component
@Scope(value = "singleton")
public class ConfigurationFacade {
    public ConfigurationBo getConfigurationByName(String name) {
        ConfigurationBo result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<ConfigurationService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.getConfigurationByName(name);
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public List<ConfigurationBo> listAllConfiguration() {
        List<ConfigurationBo> result = null;
        
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Course.getName());

        try (ThriftClientFactory<ConfigurationService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.listAllConfiguration();
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
