package com.ishangke.edunav.dataaccess.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CreditEntityExtTest extends BaseTest{
    @Autowired
    private CreditEntityExtMapper creditEntityExtMapper;

    @Test
    public void testAdd() {
        CreditEntityExt creditEntityExt = new CreditEntityExt();
        creditEntityExt.setId(1);
        creditEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        creditEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        creditEntityExt.setEnabled(1);
        creditEntityExt.setDeleted(0);
        creditEntityExtMapper.add(creditEntityExt);
        int oldcount = creditEntityExtMapper.getCount();
        creditEntityExtMapper.add(creditEntityExt);
        Assert.assertSame(creditEntityExtMapper.getCount(), oldcount + 1);
    }

}
