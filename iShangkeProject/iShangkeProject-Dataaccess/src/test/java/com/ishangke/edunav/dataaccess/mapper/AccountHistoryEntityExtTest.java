package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class AccountHistoryEntityExtTest {
    @Autowired
    private AccountHistoryEntityExtMapper accountHistoryEntityExtMapper;

    @Test
    public void testAdd() {
        AccountHistoryEntityExt accountHistoryEntityExt = new AccountHistoryEntityExt();
        accountHistoryEntityExt.setUserId(1);
        accountHistoryEntityExt.setWithdrawId(1);
        accountHistoryEntityExt.setCreateTime(new Date());
        accountHistoryEntityExt.setRemark("ishangke李清01");
        accountHistoryEntityExt.setDeleted(0);
        accountHistoryEntityExtMapper.add(accountHistoryEntityExt);
        int oldcount = accountHistoryEntityExtMapper.getCount();
        accountHistoryEntityExtMapper.add(accountHistoryEntityExt);
        Assert.assertSame(accountHistoryEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        AccountHistoryEntityExt accountHistoryEntityExt = new AccountHistoryEntityExt();
        accountHistoryEntityExt.setUserId(1);
        accountHistoryEntityExt.setWithdrawId(1);
        accountHistoryEntityExt.setCreateTime(new Date());
        accountHistoryEntityExt.setRemark("ishangke李清01");
        accountHistoryEntityExt.setDeleted(0);
        accountHistoryEntityExtMapper.add(accountHistoryEntityExt);
        int oldcount = accountHistoryEntityExtMapper.getCount();
        accountHistoryEntityExtMapper.deleteById(accountHistoryEntityExt.getId());
        Assert.assertSame(accountHistoryEntityExtMapper.getCount(), oldcount - 1);
    }
   
}
