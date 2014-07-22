package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.commoncontract.service.AccountService;
import com.ishangke.edunav.manager.AccountManager;
import com.ishangke.edunav.manager.ContactManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.CreditManager;
import com.ishangke.edunav.manager.WithdrawManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class AccountServiceImpl implements AccountService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountManager accountManager;
    @Autowired
    private CouponManager couponManager;
    @Autowired
    private CreditManager creditManager;
    @Autowired
    private WithdrawManager withdrawManager;
    @Autowired
    private ContactManager contactManager;

    

    /**********************************************************
    *
    *   关于账户相关的 Account
    *
    **********************************************************/

    @Override
    public AccountBo exchangeCash(AccountBo accountBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return null;
            // return accountManager.exchangeCash(accountBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACCOUNT_EXCHANGECASH_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUNT_EXCHANGECASH_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<AccountBo> queryAccount(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return accountManager.query(accountBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACCOUONT_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUONT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<AccountHistoryBo> queryAccountHistory(AccountHistoryBo accountHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return accountManager.queryHistory(accountHistoryBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACCOUNT_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUNT_QUERYHISTORY_ERROR_KEY);
            throw exception;
        }
    }
    
    
    

    /**********************************************************
    *
    *   关于消费券 Coupon
    *
    **********************************************************/
    @Override
    public CouponBo createCoupon(CouponBo couponBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return couponManager.createCoupon(couponBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COUPON_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CouponBo> queryCoupon(CouponBo couponBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return couponManager.query(couponBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COUPON_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CouponHistoryBo> queryCouponHistory(CouponHistoryBo couponHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return couponManager.queryHistory(couponHistoryBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COUPON_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_QUERYHISTORY_ERROR_KEY);
            throw exception;
        }
    }
    
    
    
    /**********************************************************
    *
    *   关于积分 Credit
    *
    **********************************************************/
    
    @Override
    public CreditBo exchangeCoupon(CreditBo creditBo, CouponBo couponBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return creditManager.exchangeCoupon(creditBo, couponBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CREDIT_EXCHANGE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CREDIT_EXCHANGE_ERROR_KEY);
            throw exception;
        }

    }

    @Override
    public CreditBo exchangeAccount(CreditBo creditBo, AccountBo accountBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return creditManager.exchangeAccount(creditBo, accountBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CREDIT_EXCHANGEACCOUNT_ERROR);
            exception.setMessageKey(ManagerErrorCode.CREDIT_EXCHANGEACCOUNT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CreditBo> queryCredit(CreditBo creditBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return creditManager.query(creditBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CREDIT_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CREDIT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CreditHistoryBo> queryCreditHistory(CreditHistoryBo creditHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return creditManager.queryHistory(creditHistoryBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CREDIT_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.CREDIT_QUERYHISTORY_ERROR_KEY);
            throw exception;
        }
    }
    
    
    
    
    
    /**********************************************************
    *
    *   关于提现账号 WithdrawService
    *
    **********************************************************/

    @Override
    public WithdrawBo createWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return withdrawManager.createWithdraw(withdrawBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public WithdrawBo updateWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return withdrawManager.updateWithdraw(withdrawBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public WithdrawBo deleteWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return withdrawManager.deleteWithdraw(withdrawBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<WithdrawBo> queryWithdraw(WithdrawBo withdrawBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return withdrawManager.query(withdrawBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    
    
    
    /**********************************************************
    *
    *   关于常用上课人 Contact
    *
    **********************************************************/
    @Override
    public ContactBo createContact(ContactBo contactBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return contactManager.createContact(contactBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CONTACT_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ContactBo updateContact(ContactBo contactBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return contactManager.updateContact(contactBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CONTACT_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ContactBo deleteContact(ContactBo contactBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return contactManager.deleteContact(contactBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CONTACT_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<ContactBo> queryContact(ContactBo contactBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return contactManager.query(contactBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CONTACT_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
