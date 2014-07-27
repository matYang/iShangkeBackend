package com.ishangke.edunav.facade.user;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.UserService;
import com.ishangke.edunav.commoncontract.service.UserService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.PermissionCache;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;

@Component
@Scope(value = "singleton")
public class UserFacade {
    public UserBo loginByPhone(LoginBo loginBo, String url) {
        UserBo userBo = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            userBo = serviceClient.loginByPhone(loginBo, PermissionCache.getTag(url));
        } catch (BusinessExceptionBo e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userBo;
    }
}
