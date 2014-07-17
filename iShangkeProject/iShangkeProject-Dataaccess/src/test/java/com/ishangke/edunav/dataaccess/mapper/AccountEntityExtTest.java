package com.ishangke.edunav.dataaccess.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class AccountEntityExtTest{
    @Autowired
    private AccountEntityExtMapper accountEntityExtMapper;
    
    @Autowired
    private UserEntityExtMapper userEntityExtMapper;
    
    @Test
    public void testAdd() {
        UserEntityExt userEntityExt = new UserEntityExt();
        userEntityExt.setLastLoginTime(DateUtility.getCurTimeInstance());
        userEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        userEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        userEntityExt.setEnabled(0);
        userEntityExt.setDeleted(0);
        userEntityExtMapper.add(userEntityExt);
        AccountEntityExt accountEntityExt = new AccountEntityExt();
        accountEntityExt.setId(userEntityExt.getId());   
        accountEntityExt.setRealName("中文测试");
        accountEntityExt.setBalance(12.12);
        accountEntityExt.setBalanceEnd(22.2);
        accountEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        accountEntityExt.setCreateTimeAfter(DateUtility.getCurTimeInstance());
        accountEntityExt.setCreateTimeBefore(DateUtility.getCurTimeInstance());
        accountEntityExt.setDeleted(0);
        accountEntityExt.setEnabled(0);
        accountEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        int oldcount = accountEntityExtMapper.getCount();
        accountEntityExtMapper.add(accountEntityExt);
        Assert.assertSame(accountEntityExtMapper.getCount(), oldcount + 1);
    }
}
