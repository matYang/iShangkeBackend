package com.ishangke.edunav.dataaccess.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CreditHistoryEntityExtTest extends BaseTest {
    @Autowired
    private CreditHistoryEntityExtMapper CreditHistoryEntityExtMapper;

    @Test
    public void testAdd() {
        CreditHistoryEntityExt CreditHistoryEntityExt = new CreditHistoryEntityExt();
        CreditHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        CreditHistoryEntityExt.setLastModifyTime(DateUtility
                .getCurTimeInstance());

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
        CreditHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        CreditHistoryEntityExt.setLastModifyTime(DateUtility
                .getCurTimeInstance());

        CreditHistoryEntityExt.setDeleted(0);
        CreditHistoryEntityExt.setUserId(1);

        CreditHistoryEntityExtMapper.add(CreditHistoryEntityExt);
        int oldcount = CreditHistoryEntityExtMapper.getCount();
        CreditHistoryEntityExtMapper.deleteById(CreditHistoryEntityExt.getId());
        Assert.assertSame(CreditHistoryEntityExtMapper.getCount(), oldcount - 1);
    }

    /*
     * @Test public void testList(){ CreditHistoryEntityExt
     * CreditHistoryEntityExt = new CreditHistoryEntityExt();
     * CreditHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
     * CreditHistoryEntityExt
     * .setLastModifyTime(DateUtility.getCurTimeInstance());
     * CreditHistoryEntityExt.setDeleted(0);
     * CreditHistoryEntityExt.setUserId(1);
     * CreditHistoryEntityExtMapper.add(CreditHistoryEntityExt);
     * 
     * List<CreditHistoryEntityExt> list =
     * CreditHistoryEntityExtMapper.list(CreditHistoryEntityExt, null);
     * Assert.assertSame(list.size(),1);
     * 
     * int listSize =
     * CreditHistoryEntityExtMapper.getListCount(CreditHistoryEntityExt);
     * Assert.assertSame(listSize,1);
     * 
     * PaginationEntity page = new PaginationEntity(); page.setOffset(0);
     * page.setSize(1);
     * 
     * list = CreditHistoryEntityExtMapper.list(CreditHistoryEntityExt, null);
     * Assert.assertSame(list.size(),1);
     * 
     * listSize =
     * CreditHistoryEntityExtMapper.getListCount(CreditHistoryEntityExt);
     * Assert.assertSame(listSize,1); }
     * 
     * @Test public void testUpdate(){ CreditHistoryEntityExt
     * CreditHistoryEntityExt = new CreditHistoryEntityExt();
     * CreditHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
     * CreditHistoryEntityExt
     * .setLastModifyTime(DateUtility.getCurTimeInstance());
     * CreditHistoryEntityExt.setDeleted(0);
     * CreditHistoryEntityExt.setUserId(1);
     * CreditHistoryEntityExtMapper.add(CreditHistoryEntityExt);
     * 
     * List<CreditHistoryEntityExt> list =
     * CreditHistoryEntityExtMapper.list(CreditHistoryEntityExt, null); Double
     * charge = 1.2; list.get(0).setCharge(charge);
     * CreditHistoryEntityExtMapper.update(list.get(0));
     * 
     * list = CreditHistoryEntityExtMapper.list(CreditHistoryEntityExt, null);
     * 
     * 
     * }
     */
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));

        CreditHistoryEntityExt creditHistoryEntityExt = new CreditHistoryEntityExt();
        creditHistoryEntityExt.setCharge(2.0);
        List<CreditHistoryEntityExt> result = CreditHistoryEntityExtMapper
                .list(creditHistoryEntityExt, page);
        Assert.assertEquals(2, result.size());
      
    }
    @Test
    public void testQuery2() {
        CreditHistoryEntityExt creditHistoryEntityExt = new CreditHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        creditHistoryEntityExt.setIdSet(idSet);
        List<CreditHistoryEntityExt> result = CreditHistoryEntityExtMapper.list(creditHistoryEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
   
  
}
