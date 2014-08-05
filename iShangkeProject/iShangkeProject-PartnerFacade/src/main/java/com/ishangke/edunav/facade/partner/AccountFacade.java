package com.ishangke.edunav.facade.partner;

import org.apache.thrift.TException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.commoncontract.model.AccountHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.AccountPageViewBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.commoncontract.model.ContactPageViewBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CouponPageViewBo;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CreditPageViewBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.commoncontract.model.WithdrawPageViewBo;
import com.ishangke.edunav.commoncontract.service.AccountService;
import com.ishangke.edunav.commoncontract.service.AccountService.Client;
import com.ishangke.edunav.thrift.ThriftClientFactory;
import com.ishangke.edunav.thrift.ThriftClientSetting;
import com.ishangke.edunav.web.common.ClientEnum;
import com.ishangke.edunav.web.common.PermissionCache;
import com.ishangke.edunav.web.common.ThriftClientSettingManager;
import com.ishangke.edunav.web.exception.ControllerException;

@Component
@Scope(value = "singleton")
public class AccountFacade {
    public AccountBo exchangeCash(AccountBo accountBo, UserBo userBo, String permissionTag) {
        AccountBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.exchangeCash(accountBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public AccountPageViewBo queryAccount(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        AccountPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryAccount(accountBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public AccountHistoryPageViewBo queryAccountHistory(AccountHistoryBo accountHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        AccountHistoryPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryAccountHistory(accountHistoryBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CouponBo createCoupon(CouponBo couponBo, UserBo userBo, String permissionTag) {
        CouponBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createCoupon(couponBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CouponPageViewBo queryCoupon(CouponBo couponBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        CouponPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCoupon(couponBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CouponHistoryPageViewBo queryCouponHistory(CouponHistoryBo couponHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        CouponHistoryPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCouponHistory(couponHistoryBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CreditBo exchangeCoupon(CreditBo creditBo, CouponBo couponBo, UserBo userBo, String permissionTag) {
        CreditBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.exchangeCoupon(creditBo, couponBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CreditBo exchangeAccount(CreditBo creditBo, AccountBo accountBo, UserBo userBo, String permissionTag) {
        CreditBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.exchangeAccount(creditBo, accountBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CreditPageViewBo queryCredit(CreditBo creditBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        CreditPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCredit(creditBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CreditHistoryPageViewBo queryCreditHistory(CreditHistoryBo creditHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        CreditHistoryPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCreditHistory(creditHistoryBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public WithdrawBo createWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) {
        WithdrawBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createWithdraw(withdrawBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public WithdrawBo updateWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) {
        WithdrawBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.updateWithdraw(withdrawBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public WithdrawBo deleteWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) {
        WithdrawBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteWithdraw(withdrawBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public WithdrawPageViewBo queryWithdraw(WithdrawBo withdrawBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        WithdrawPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryWithdraw(withdrawBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ContactBo createContact(ContactBo contactBo, UserBo userBo, String permissionTag) {
        ContactBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.createContact(contactBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ContactBo updateContact(ContactBo contactBo, UserBo userBo, String permissionTag) {
        ContactBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.updateContact(contactBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ContactBo deleteContact(ContactBo contactBo, UserBo userBo, String permissionTag) {
        ContactBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.deleteContact(contactBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ContactPageViewBo queryContact(ContactBo contactBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) {
        ContactPageViewBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryContact(contactBo, userBo, paginationBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CouponBo queryCouponById(int id, UserBo userBo, String permissionTag) {
        CouponBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.queryCouponById(id, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CouponBo activateCoupon(CouponBo couponBo, UserBo userBo, String permissionTag) {
        CouponBo result = null;

        ThriftClientSetting clientSetting = ThriftClientSettingManager.getSetting(ClientEnum.Account.getName());

        try (ThriftClientFactory<AccountService.Client> factory = new ThriftClientFactory<>(clientSetting)) {
            Client serviceClient = factory.getServiceClient();
            result = serviceClient.activateCoupon(couponBo, userBo, PermissionCache.getTag(permissionTag));
        } catch (BusinessExceptionBo e) {
            e.printStackTrace();
            throw new ControllerException(e.getErrorCode(), e.getMessageKey());
        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }
}
