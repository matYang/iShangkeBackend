package com.ishangke.edunav.facade.user;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.UserService.Client;
import com.ishangke.edunav.thrift.ThriftServerFactory;
import com.ishangke.edunav.thrift.ThriftServerSetting;
import com.ishangke.edunav.web.common.PermissionCache;

@Component
@Scope(value = "singleton")
public class UserFacade {
    private ThriftServerSetting clientSetting;

    public UserBo loginByPhone(LoginBo loginBo, String url) {
        UserBo userBo = null;

        try (ThriftServerFactory<Client> factory = new ThriftServerFactory<>(clientSetting)) {
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
