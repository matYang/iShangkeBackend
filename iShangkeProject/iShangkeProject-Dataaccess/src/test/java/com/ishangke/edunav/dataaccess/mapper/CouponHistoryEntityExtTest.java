package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
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
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CouponHistoryEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CouponHistoryEntityExtTest extends BaseTest{
    @Autowired
    private CouponHistoryEntityExtMapper couponHistoryEntityExtMapper;
    private Calendar time = Calendar.getInstance();
//    public  CouponHistoryEntityExtTest() {
//        scriptAfterClass = "CouponHistoryEntityExtTestAfter.sql";
//        scriptBeforeClass = "CouponHistoryEntityExtTestBefore.sql";
//    }
    @Test
    public void testAdd() {
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        couponHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        couponHistoryEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        couponHistoryEntityExt.setCouponId(1);
        couponHistoryEntityExt.setDeleted(0);
       couponHistoryEntityExtMapper.add(couponHistoryEntityExt);
        int oldcount = couponHistoryEntityExtMapper.getCount();
        couponHistoryEntityExtMapper.add(couponHistoryEntityExt);
        Assert.assertSame(couponHistoryEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        couponHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        couponHistoryEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        couponHistoryEntityExt.setCouponId(1);
        couponHistoryEntityExt.setDeleted(0);
        couponHistoryEntityExtMapper.add(couponHistoryEntityExt);
        int oldcount = couponHistoryEntityExtMapper.getCount();
        couponHistoryEntityExtMapper.deleteById(couponHistoryEntityExt.getId());
        Assert.assertSame(couponHistoryEntityExtMapper.getCount(), oldcount - 1);
    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
       
        CouponHistoryEntityExt couponHistoryQueryEntity = new CouponHistoryEntityExt();
        
        couponHistoryQueryEntity.setCharge(5.8);
        List<CouponHistoryEntityExt> result = couponHistoryEntityExtMapper.list(couponHistoryQueryEntity, page);
        Assert.assertEquals(2, result.size());
        //Assert.assertEquals("_test_CourseTemplateClassPhotos_2_", result.get(0).getCreateTime());
    }
    @Test
    public void testQuery2() {
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        couponHistoryEntityExt.setIdSet(idSet);
        List<CouponHistoryEntityExt> result = couponHistoryEntityExtMapper.list(couponHistoryEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        couponHistoryEntityExt.setCouponId(4);
      
        List<CouponHistoryEntityExt> result = couponHistoryEntityExtMapper.list(couponHistoryEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("5.8", result.get(0).getCharge().toString());
    }
    
    @Test
    public void testQuery4() {
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        couponHistoryEntityExt.setCharge(5.8);
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        List<CouponHistoryEntityExt> result = couponHistoryEntityExtMapper.list(couponHistoryEntityExt, page);
        Assert.assertEquals(2, result.size());
        Assert.assertSame(5, result.get(0).getId());
        Assert.assertSame(2, result.get(1).getId());
       
    }
    @Test
    public void testGet() {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();   
        nf.setGroupingUsed(false);  
        CouponHistoryEntityExt getbyid1 = couponHistoryEntityExtMapper
                .getById(2);
        CouponHistoryEntityExt getbyid2 = couponHistoryEntityExtMapper
                .getById(3);
        CouponHistoryEntityExt getbyid3 = couponHistoryEntityExtMapper
                .getById(4);
        Assert.assertEquals("5.8", getbyid1.getCharge().toString());
//        Assert.assertEquals("33.9086755", nf.format(getbyid2.getCharge()).toString());
        Assert.assertEquals("44235245.9", nf.format(getbyid3.getCharge()).toString());
//        System.out.println(getbyid2.getCharge());
//        System.out.println(getbyid3.getCharge());
    }
    @Test
    public void testUpdate() {
        CouponHistoryEntityExt upDate = couponHistoryEntityExtMapper
                .getById(2);
        upDate.setCharge(4.6);
       
        upDate.setCreateTime(time);
        couponHistoryEntityExtMapper.update(upDate);
        upDate = couponHistoryEntityExtMapper.getById(2);
      
        Assert.assertEquals("4.6", upDate.getCharge().toString());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
