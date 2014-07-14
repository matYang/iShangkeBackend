package com.ishangke.edunav.dataaccess.mapper;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CreditHistoryEntityExtTest extends BaseTest{
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
    
    @Test
    public void testList(){
        CreditHistoryEntityExt CreditHistoryEntityExt = new CreditHistoryEntityExt();
        CreditHistoryEntityExt.setCreateTime(new Date());
        CreditHistoryEntityExt.setLastModifyTime(new Date());      
        CreditHistoryEntityExt.setDeleted(0);
        CreditHistoryEntityExt.setUserId(1);     
        CreditHistoryEntityExtMapper.add(CreditHistoryEntityExt);
        CreditHistoryEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 10000));
        CreditHistoryEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 10000));
        
        List<CreditHistoryEntityExt> list = CreditHistoryEntityExtMapper.list(CreditHistoryEntityExt, null);
        Assert.assertSame(list.size(),1);
        
        int listSize = CreditHistoryEntityExtMapper.getListCount(CreditHistoryEntityExt);
        Assert.assertSame(listSize,1);
        
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(1);
        
        list = CreditHistoryEntityExtMapper.list(CreditHistoryEntityExt, null);
        Assert.assertSame(list.size(),1);
        
        listSize = CreditHistoryEntityExtMapper.getListCount(CreditHistoryEntityExt);
        Assert.assertSame(listSize,1);
    }

    @Test
    public void testUpdate(){
        CreditHistoryEntityExt CreditHistoryEntityExt = new CreditHistoryEntityExt();
        CreditHistoryEntityExt.setCreateTime(new Date());
        CreditHistoryEntityExt.setLastModifyTime(new Date());      
        CreditHistoryEntityExt.setDeleted(0);
        CreditHistoryEntityExt.setUserId(1);     
        CreditHistoryEntityExtMapper.add(CreditHistoryEntityExt);
        CreditHistoryEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 10000));
        CreditHistoryEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 10000));
        
        List<CreditHistoryEntityExt> list = CreditHistoryEntityExtMapper.list(CreditHistoryEntityExt, null);
        Double charge = 1.2;
        list.get(0).setCharge(charge);
        CreditHistoryEntityExtMapper.update(list.get(0));
        
        list = CreditHistoryEntityExtMapper.list(CreditHistoryEntityExt, null);
        
        if(list.get(0).getCharge().equals(charge)){
            //Passed;
        }else fail();
        
    }
}
