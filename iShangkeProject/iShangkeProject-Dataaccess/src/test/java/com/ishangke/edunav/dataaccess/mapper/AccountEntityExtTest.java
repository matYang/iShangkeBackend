package com.ishangke.edunav.dataaccess.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;
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
        accountEntityExt.setCreateTimeEnd(DateUtility.getCurTimeInstance());
        accountEntityExt.setCreateTimeStart(DateUtility.getCurTimeInstance());
        accountEntityExt.setDeleted(0);
        accountEntityExt.setEnabled(0);
        accountEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        int oldcount = accountEntityExtMapper.getCount();
        accountEntityExtMapper.add(accountEntityExt);
        Assert.assertSame(accountEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testGet() {
        AccountEntityExt accountEntityExt1 = accountEntityExtMapper.getById(2);
        AccountEntityExt accountEntityExt2 = accountEntityExtMapper.getById(3);
        AccountEntityExt accountEntityExt3 = accountEntityExtMapper.getById(4);
        Assert.assertEquals("_test_RN_1_爱上课", accountEntityExt1.getRealName());
        Assert.assertEquals("_test_RN_2_爱上课", accountEntityExt2.getRealName());
        Assert.assertEquals("_test_RN_3_爱上课", accountEntityExt3.getRealName());
    }
    
    @Test
    public void testUpdate() {
        AccountEntityExt accountEntityExt = accountEntityExtMapper.getById(2);
        accountEntityExt.setBalance(2.2);
        accountEntityExt.setRealName("ooxx");
        accountEntityExtMapper.update(accountEntityExt);
        accountEntityExt = accountEntityExtMapper.getById(2);
        Assert.assertEquals("ooxx",accountEntityExt.getRealName());
           
    }
}
