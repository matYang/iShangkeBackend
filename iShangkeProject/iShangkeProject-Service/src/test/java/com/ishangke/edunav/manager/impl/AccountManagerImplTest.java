package com.ishangke.edunav.manager.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.AccountHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.WithdrawEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;
import com.ishangke.edunav.manager.AccountManager;
import com.ishangke.edunav.manager.converter.AccountConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.converter.WithdrawConverter;

@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, AccountManagerImplTest.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-dataaccessUT.xml","classpath*:applicationContext-serviceUT.xml"})
@Transactional
public class AccountManagerImplTest extends BaseTest{
    @Autowired
    private AccountEntityExtMapper accountMapper;
    
    @Autowired
    private UserEntityExtMapper userMapper;
    
    @Autowired
    private WithdrawEntityExtMapper withdrawMapper;
    
    @Autowired
    private AccountManager accountManager;
    
    @Autowired
    private AccountHistoryEntityExtMapper accountHistoryMapper;
    
    /*@Test
    public void testExchangeCash(){
        AccountEntityExt account = accountMapper.getById(9);
        UserEntityExt user = userMapper.getById(9);
        WithdrawEntityExt withdraw = withdrawMapper.getById(6);
        AccountBo accountBo = AccountConverter.toBo(account);
        UserBo userBo = UserConverter.toBo(user);
        WithdrawBo withdrawBo = WithdrawConverter.toBo(withdraw);
        AccountHistoryEntityExt accountCondition = new AccountHistoryEntityExt();
        accountCondition.setUserId(accountBo.getId());
        int historyCount = accountHistoryMapper.getListCount(accountCondition);
        System.out.println("historyCount before:"+historyCount);
        System.out.println("accountBo before:"+account.getBalance());
        accountManager.exchangeCash(accountBo, userBo, 25.0, withdrawBo);
        AccountEntityExt accountAfter = accountMapper.getById(9);
        int historyCountAfter = accountHistoryMapper.getListCount(accountCondition);
        System.out.println("historyCount After:"+historyCountAfter);
        System.out.println("accountBo after:"+accountAfter.getBalance());
        
    }*/
    @Test
    public void test(){
        
    }
}
