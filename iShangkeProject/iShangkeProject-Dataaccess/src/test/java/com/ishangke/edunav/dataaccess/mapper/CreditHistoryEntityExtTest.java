package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CreditHistoryEntityExtTest {
    @Autowired
    private CreditHistoryEntityExtMapper CreditHistoryEntityExtMapper;

    @Test
    public void testAdd() {
        CreditHistoryEntityExt CreditHistoryEntityExt = new CreditHistoryEntityExt();
        CreditHistoryEntityExt.setCreateTime(new Date());
        CreditHistoryEntityExt.setLastModifyTime(new Date());
       
        CreditHistoryEntityExt.setDeleted(0);
        CreditHistoryEntityExt.setUserId(1);
  
        CreditHistoryEntityExtMapper.add(CreditHistoryEntityExt);
        int oldcount = CreditHistoryEntityExtMapper.getCount();
        CreditHistoryEntityExtMapper.add(CreditHistoryEntityExt);
        Assert.assertSame(CreditHistoryEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CreditHistoryEntityExt CreditHistoryEntityExt = new CreditHistoryEntityExt();
        CreditHistoryEntityExt.setCreateTime(new Date());
        CreditHistoryEntityExt.setLastModifyTime(new Date());
      
        CreditHistoryEntityExt.setDeleted(0);
        CreditHistoryEntityExt.setUserId(1);
     
        CreditHistoryEntityExtMapper.add(CreditHistoryEntityExt);
        int oldcount = CreditHistoryEntityExtMapper.getCount();
        CreditHistoryEntityExtMapper.deleteById(CreditHistoryEntityExt.getId());
        Assert.assertSame(CreditHistoryEntityExtMapper.getCount(), oldcount - 1);
    }

}
