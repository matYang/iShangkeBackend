package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CreditEntityExtTest {
    @Autowired
    private CreditEntityExtMapper creditEntityExtMapper;

    @Test
    public void testAdd() {
        CreditEntityExt creditEntityExt = new CreditEntityExt();
        creditEntityExt.setId(1);
        creditEntityExt.setCreateTime(new Date());
        creditEntityExt.setLastModifyTime(new Date());
        creditEntityExt.setEnabled(1);
        creditEntityExt.setDeleted(0);
        creditEntityExtMapper.add(creditEntityExt);
        int oldcount = creditEntityExtMapper.getCount();
        creditEntityExtMapper.add(creditEntityExt);
        Assert.assertSame(creditEntityExtMapper.getCount(), oldcount + 1);
    }

}
