package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class AccountEntityExtTest {
    @Autowired
    private AccountEntityExtMapper accountEntityExtMapper;
    
    @Autowired
    private UserEntityExtMapper userEntityExtMapper;
    
    @Test
    public void test() {
        UserEntityExt userEntityExt = new UserEntityExt();
        userEntityExt.setLastLoginTime(new Date());
        userEntityExt.setLastModifyTime(new Date());
        userEntityExt.setCreateTime(new Date());
        userEntityExt.setEnabled(0);
        userEntityExt.setDeleted(0);
        userEntityExtMapper.add(userEntityExt);
        AccountEntityExt accountEntityExt = new AccountEntityExt();
        accountEntityExt.setId(userEntityExt.getId());
        accountEntityExt.setBalance(12.12);
        accountEntityExt.setBalanceEnd(22.2);
        accountEntityExt.setCreateTime(new Date());
        accountEntityExt.setCreateTimeAfter(new Date());
        accountEntityExt.setCreateTimeBefore(new Date());
        accountEntityExt.setDeleted(0);
        accountEntityExt.setEnabled(0);
        accountEntityExt.setLastModifyTime(new Date());
        int oldcount = accountEntityExtMapper.getCount();
        accountEntityExtMapper.add(accountEntityExt);
        Assert.assertSame(accountEntityExtMapper.getCount(), oldcount + 1);
    }
}
