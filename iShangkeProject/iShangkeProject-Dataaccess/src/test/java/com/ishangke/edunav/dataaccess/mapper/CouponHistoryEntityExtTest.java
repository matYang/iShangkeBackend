package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

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
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CouponHistoryEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CouponHistoryEntityExtTest extends BaseTest{
    @Autowired
    private CouponHistoryEntityExtMapper couponHistoryEntityExtMapper;
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
}
