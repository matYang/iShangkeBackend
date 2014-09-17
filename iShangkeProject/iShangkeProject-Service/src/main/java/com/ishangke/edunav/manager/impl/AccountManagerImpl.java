package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.AccountHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.WithdrawEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AccountManager;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.converter.AccountConverter;
import com.ishangke.edunav.manager.converter.AccountHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;

@Component
public class AccountManagerImpl implements AccountManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountManagerImpl.class);

    @Autowired
    private AccountEntityExtMapper accountMapper;
    @Autowired
    private AccountHistoryEntityExtMapper accountHistoryMapper;
    @Autowired
    private WithdrawEntityExtMapper withdrawMapper;
    @Autowired
    private AuthManager authManager;

    @Override
    // TODO left for harry
    public AccountBo exchangeCash(AccountBo accountBo, UserBo userBo, Double amount, WithdrawBo withdrawBo) {
        if(userBo == null){
            throw new ManagerException("用户不能为空");
        }
        if(accountBo == null){
            throw new ManagerException("账户不能为空");
        }
        if(amount == null){
            throw new ManagerException("金额不能为空");
        }
        if(withdrawBo == null || withdrawBo.getPayeeId() == null || withdrawBo.getPayeeName() == null || withdrawBo.getType() == -1){
            throw new ManagerException("转账信息不能为空");
        }
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        AccountEntityExt accountEntity = AccountConverter.fromBo(accountBo);
        if(accountEntity.getId() == null || accountEntity.getId() == 0){
            throw new ManagerException("该账户不存在");
        }
        if(userEntity.getId() == null || userEntity.getId() == 0){
            throw new ManagerException("该用户不存在");
        }
        if(accountEntity.getId() != userEntity.getId() ){
            throw new ManagerException("该账户不属于此用户");
        }
        AccountEntityExt oldAccount = accountMapper.getById(accountBo.getId());
        if(oldAccount.getBalance() != null && oldAccount.getBalance() >= amount){
            try{
                oldAccount.setBalance(accountBo.getBalance() - amount);
                oldAccount.setLastModifyTime(DateUtility.getCurTimeInstance());
                accountMapper.update(oldAccount);
                AccountHistoryEntityExt accountHistory = new AccountHistoryEntityExt();
                accountHistory.setCharge(amount);
                accountHistory.setCreateTime(DateUtility.getCurTimeInstance());
                accountHistory.setType(withdrawBo.getType());
                accountHistory.setUserId(userBo.getId());
                accountHistory.setWithdrawId(withdrawBo.getId());
                accountHistoryMapper.add(accountHistory);
                return AccountConverter.toBo(oldAccount);
            }catch(Throwable t){
                throw new ManagerException("转账失败",t);
            }
        }else{
            throw new ManagerException("账户余额不足");
        }
    }

    @Override
    public List<AccountBo> query(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        AccountEntityExt accountEntity = accountBo == null ? null : AccountConverter.fromBo(accountBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        // admin and system admins can query user's accounts
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[AccountManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only query their own, thus making an UserId
            // necessary
            if (accountEntity == null || IdChecker.notEqual(accountEntity.getId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权查询他人的账户");
            }
        }

        List<AccountEntityExt> results = null;
        try {
            results = accountMapper.list(accountEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，账户查询失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<AccountBo>();
        }
        List<AccountBo> convertedResults = new ArrayList<AccountBo>();
        for (AccountEntityExt result : results) {
            convertedResults.add(AccountConverter.toBo(result));
        }
        return convertedResults;

    }

    @Override
    public List<AccountHistoryBo> queryHistory(AccountHistoryBo accountHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        AccountHistoryEntityExt accountHistoryEntity = accountHistoryBo == null ? null : AccountHistoryConverter.fromBo(accountHistoryBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        // admin and system admins can query user's accountHistorys
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[AccountHistoryManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only query their own, thus making an UserId
            // necessary
            if (accountHistoryEntity == null || IdChecker.notEqual(accountHistoryEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权查询他人的账户历史记录");
            }
        }

        List<AccountHistoryEntityExt> results = null;
        try {
            results = accountHistoryMapper.list(accountHistoryEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，账户历史记录查询失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<AccountHistoryBo>();
        }
        List<AccountHistoryBo> convertedResults = new ArrayList<AccountHistoryBo>();
        for (AccountHistoryEntityExt result : results) {
            convertedResults.add(AccountHistoryConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public int queryTotal(AccountBo accountBo, UserBo userBo) {
        return accountMapper.getListCount(AccountConverter.fromBo(accountBo));
    }

    @Override
    public int queryHistoryTotal(AccountHistoryBo accountHistoryBo, UserBo userBo) {
        return accountHistoryMapper.getListCount(AccountHistoryConverter.fromBo(accountHistoryBo));
    }

}
