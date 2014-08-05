package com.ishangke.edunav.facade.admin;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.LoginBo;
import com.ishangke.edunav.commoncontract.model.MessageBo;
import com.ishangke.edunav.commoncontract.model.MessagePageViewBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PasswordBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.SpreadPageViewBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.UserPageViewBo;
import com.ishangke.edunav.commoncontract.service.UserService;
import com.ishangke.edunav.commoncontract.service.UserService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.PermissionCache;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;
import com.ishangke.edunav.web.exception.ControllerException;

@Component
@Scope(value = "singleton")
public class UserFacade {
    public UserBo registerUser(UserBo userBo, SessionBo sessionBo, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.registerUser(userBo, sessionBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SessionBo loginByPhone(LoginBo loginBo, String permissionTag) {
        SessionBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.loginByPhone(loginBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SessionBo loginByReference(LoginBo loginBo, String permissionTag) {
        SessionBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.loginByReference(loginBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserBo createUser(UserBo targetUser, UserBo currentUser, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createUser(targetUser, currentUser, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserBo createPartnerUser(UserBo targetUser, PartnerBo partner, UserBo currentUser, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createPartnerUser(targetUser, partner, currentUser, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserBo deleteUser(UserBo targetUser, UserBo currentUser, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteUser(targetUser, currentUser, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserBo updateUser(UserBo targetUser, UserBo currentUser, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.updateUser(targetUser, currentUser, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserBo queryUserInfo(UserBo queryUser, UserBo currentUser, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryUserInfo(queryUser, currentUser, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserPageViewBo queryUser(UserBo queryUser, UserBo currentUser, PaginationBo pagnationBo, String permissionTag) {
        UserPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryUser(queryUser, currentUser, pagnationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserBo authenticate(SessionBo sessionBo, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.authenticate(sessionBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void disposeSession(SessionBo sessionBo, String permissionTag) {
        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            serviceClient.disposeSession(sessionBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public SessionBo openCellSession(UserBo userBo, String permissionTag) {
        SessionBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.openCellSession(userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SessionBo openForgetPasswordSession(UserBo userBo, String permissionTag) {
        SessionBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.openForgetPasswordSession(userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserBo recoverPassword(PasswordBo passwordBo, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.recoverPassword(passwordBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public UserBo changePassword(PasswordBo passwordBo, String permissionTag) {
        UserBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.changePassword(passwordBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public MessageBo sendMessage(MessageBo messageBo, UserBo userBo, String permissionTag) {
        MessageBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.sendMessage(messageBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public MessageBo receiveMessage(MessageBo messageBo, UserBo userBo, String permissionTag) {
        MessageBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.receiveMessage(messageBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public MessageBo deleteMessage(MessageBo messageBo, UserBo userBo, String permissionTag) {
        MessageBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteMessage(messageBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public MessagePageViewBo queryMessage(MessageBo messageBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        MessagePageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryMessage(messageBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SpreadBo generateCode(UserBo userBo, PartnerBo partnerBo, CourseBo courseBo, String permissionTag) {
        SpreadBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.generateCode(userBo, partnerBo, courseBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SpreadPageViewBo querySpread(SpreadBo spreadBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        SpreadPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.querySpread(spreadBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SpreadBo createSpread(SpreadBo spreadBo, PartnerBo partnerBo, CourseBo courseBo, UserBo userBo, String permissionTag) {
        SpreadBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createSpread(spreadBo, partnerBo, courseBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SpreadBo approveSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) {
        SpreadBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.approveSpread(spreadBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SpreadBo rejectSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) {
        SpreadBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.rejectSpread(spreadBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SpreadBo cancelSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) {
        SpreadBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.cancelSpread(spreadBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

    public SpreadBo deleteSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) {
        SpreadBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.User.getName());

        try (ThriftClientFactory<UserService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteSpread(spreadBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }

        return result;
    }

}
