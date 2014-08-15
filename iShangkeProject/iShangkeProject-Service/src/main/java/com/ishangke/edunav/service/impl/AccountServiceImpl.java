package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ishangke.edunav.manager.AccountManager;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.ContactManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.CreditManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.WithdrawManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;
import com.ishangke.edunav.util.PageUtil;

@Component
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
    @Autowired
    private PermissionManager permissionManager;
    @Autowired
    private AuthManager authManager;

    /**********************************************************
     * 
     * 关于账户相关的 Account
     * 
     **********************************************************/
    @Override
    public AccountBo exchangeCash(AccountBo accountBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "exchangeCash"));
            //     throw new NoPermissionException();
            // }
            return null;
            // return accountManager.exchangeCash(accountBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_EXCHANGECASH);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_EXCHANGECASH_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.ACCOUNT_EXCHANGECASH_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUNT_EXCHANGECASH_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AccountPageViewBo queryAccount(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryAccount"));
            //     throw new NoPermissionException();
            // }
            paginationBo = PageUtil.getPage(paginationBo);
            List<AccountBo> data = accountManager.query(accountBo, userBo, paginationBo);
            int total = accountManager.queryTotal(accountBo, userBo);
            
            AccountPageViewBo pageView = new AccountPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setTotal(total);
            pageView.setData(data);
            return pageView;
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYACCOUNT);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYACCOUNT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.ACCOUONT_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUONT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AccountHistoryPageViewBo queryAccountHistory(AccountHistoryBo accountHistoryBo, UserBo userBo,
            PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryAccountHistory"));
            //     throw new NoPermissionException();
            // }
            paginationBo = PageUtil.getPage(paginationBo);
            List<AccountHistoryBo> data = accountManager.queryHistory(accountHistoryBo, userBo, paginationBo);
            int total = accountManager.queryHistoryTotal(accountHistoryBo, userBo);
            
            AccountHistoryPageViewBo pageView = new AccountHistoryPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setTotal(total);
            pageView.setData(data);
            return pageView;
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYACCOUNTHISTORY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYACCOUNTHISTORY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.ACCOUNT_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACCOUNT_QUERYHISTORY_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于消费券 Coupon
     * 
     **********************************************************/
    @Override
    public CouponBo createCoupon(CouponBo couponBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "createCoupon"));
            //     throw new NoPermissionException();
            // }
            return couponManager.createCoupon(couponBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_CREATECOUPON);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_CREATECOUPON_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COUPON_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CouponBo activateCoupon(CouponBo couponBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "activateCoupon"));
            //     throw new NoPermissionException();
            // }
            return couponManager.activateCoupon(couponBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_ACTIVATECOUPON);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_ACTIVATECOUPON_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COUPON_ACTIVATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_ACTIVATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CouponPageViewBo queryCoupon(CouponBo couponBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryCoupon"));
            //     throw new NoPermissionException();
            // }
            paginationBo = PageUtil.getPage(paginationBo);
            List<CouponBo> data = couponManager.query(couponBo, userBo, paginationBo);
            int total = couponManager.queryTotal(couponBo, userBo);
            CouponPageViewBo pageView = new CouponPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCOUPON);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCOUPON_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COUPON_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CouponHistoryPageViewBo queryCouponHistory(CouponHistoryBo couponHistoryBo, UserBo userBo,
            PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryCouponHistory"));
            //     throw new NoPermissionException();
            // }
            paginationBo = PageUtil.getPage(paginationBo);
            List<CouponHistoryBo> data = couponManager.queryHistory(couponHistoryBo, userBo, paginationBo);
            int total = couponManager.queryHistoryTotal(couponHistoryBo, userBo);
            CouponHistoryPageViewBo pageView = new CouponHistoryPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;


        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCOUPONHISTORY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCOUPONHISTORY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COUPON_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_QUERYHISTORY_ERROR_KEY);
            throw exception;
        }
    }
    
    @Override
    public CouponBo queryCouponById(int id, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryContact"));
            //     throw new NoPermissionException();
            // }
            return couponManager.queryById(id, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCONTACT);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCONTACT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CONTACT_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于积分 Credit
     * 
     **********************************************************/
    @Override
    public CreditBo exchangeCoupon(CreditBo creditBo, CouponBo couponBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "exchangeCoupon"));
            //     throw new NoPermissionException();
            // }
            return creditManager.exchangeCoupon(creditBo, couponBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_EXCHANGECOUPON);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_EXCHANGECOUPON_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CREDIT_EXCHANGE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CREDIT_EXCHANGE_ERROR_KEY);
            throw exception;
        }

    }

    @Override
    public CreditBo exchangeAccount(CreditBo creditBo, AccountBo accountBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "exchangeAccount"));
            //     throw new NoPermissionException();
            // }
            return creditManager.exchangeAccount(creditBo, accountBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_EXCHANGEACCOUNT);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_EXCHANGEACCOUNT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CREDIT_EXCHANGEACCOUNT_ERROR);
            exception.setMessageKey(ManagerErrorCode.CREDIT_EXCHANGEACCOUNT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CreditPageViewBo queryCredit(CreditBo creditBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryCredit"));
            //     throw new NoPermissionException();
            // }
            paginationBo = PageUtil.getPage(paginationBo);
            List<CreditBo> data = creditManager.query(creditBo, userBo, paginationBo);
            int total = creditManager.queryTotal(creditBo, userBo);
            CreditPageViewBo pageView = new CreditPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCREDIT);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCREDIT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CREDIT_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CREDIT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CreditHistoryPageViewBo queryCreditHistory(CreditHistoryBo creditHistoryBo, UserBo userBo,
            PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryCreditHistory"));
            //     throw new NoPermissionException();
            // }
            paginationBo = PageUtil.getPage(paginationBo);
            List<CreditHistoryBo> data = creditManager.queryHistory(creditHistoryBo, userBo, paginationBo);
            int total = creditManager.queryHistoryTotal(creditHistoryBo, userBo);
            CreditHistoryPageViewBo pageView = new CreditHistoryPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;


        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCREDITHISTORY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCREDITHISTORY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CREDIT_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.CREDIT_QUERYHISTORY_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于提现账号 WithdrawService
     * 
     **********************************************************/
    @Override
    public WithdrawBo createWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "createWithdraw"));
            //     throw new NoPermissionException();
            // }
            return withdrawManager.createWithdraw(withdrawBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_CREATEWITHDRAW);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_CREATEWITHDRAW_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public WithdrawBo updateWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "updateWithdraw"));
            //     throw new NoPermissionException();
            // }
            return withdrawManager.updateWithdraw(withdrawBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_UPDATEWITHDRAW);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_UPDATEWITHDRAW_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public WithdrawBo deleteWithdraw(WithdrawBo withdrawBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "deleteWithdraw"));
            //     throw new NoPermissionException();
            // }
            return withdrawManager.deleteWithdraw(withdrawBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_DELETEWITHDRAW);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_DELETEWITHDRAW_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public WithdrawPageViewBo queryWithdraw(WithdrawBo withdrawBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryWithdraw"));
            //     throw new NoPermissionException();
            // }
            paginationBo = PageUtil.getPage(paginationBo);
            List<WithdrawBo> data = withdrawManager.query(withdrawBo, userBo, paginationBo);
            int total = withdrawManager.queryTotal(withdrawBo, userBo);
            WithdrawPageViewBo pageView = new WithdrawPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYWITHDRAW);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYWITHDRAW_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.WITHDRAW_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.WITHDRAW_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于常用上课人 Contact
     * 
     **********************************************************/
    @Override
    public ContactBo createContact(ContactBo contactBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "createContact"));
            //     throw new NoPermissionException();
            // }
            return contactManager.createContact(contactBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_CREATECONTACT);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_CREATECONTACT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CONTACT_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ContactBo updateContact(ContactBo contactBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "updateContact"));
            //     throw new NoPermissionException();
            // }
            return contactManager.updateContact(contactBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_UPDATECONTACT);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_UPDATECONTACT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CONTACT_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ContactBo deleteContact(ContactBo contactBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "deleteContact"));
            //     throw new NoPermissionException();
            // }
            return contactManager.deleteContact(contactBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_DELETECONTACT);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_DELETECONTACT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CONTACT_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ContactPageViewBo queryContact(ContactBo contactBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
            //     LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
            //             "queryContact"));
            //     throw new NoPermissionException();
            // }
            paginationBo = PageUtil.getPage(paginationBo);
            List<ContactBo> data = contactManager.query(contactBo, userBo, paginationBo);
            int total = contactManager.queryTotal(contactBo, userBo);
            
            ContactPageViewBo pageView = new ContactPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCONTACT);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_ACCOUNT_QUERYCONTACT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.CONTACT_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONTACT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
