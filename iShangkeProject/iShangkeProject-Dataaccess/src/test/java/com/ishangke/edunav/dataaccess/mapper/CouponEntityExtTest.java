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
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CouponEntityExtTest extends BaseTest{
    @Autowired
    private CouponEntityExtMapper couponEntityExtMapper;

    @Test
    public void testAdd() {
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        couponEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        couponEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        couponEntityExt.setEnabled(1);
        couponEntityExt.setDeleted(0);
        couponEntityExt.setUserId(1);
        couponEntityExt.setExpiryTime(DateUtility.getCurTimeInstance());
        couponEntityExtMapper.add(couponEntityExt);
        int oldcount = couponEntityExtMapper.getCount();
        couponEntityExtMapper.add(couponEntityExt);
        Assert.assertSame(couponEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        couponEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        couponEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        couponEntityExt.setEnabled(1);
        couponEntityExt.setDeleted(0);
        couponEntityExt.setUserId(1);
        couponEntityExt.setExpiryTime(DateUtility.getCurTimeInstance());
        couponEntityExtMapper.add(couponEntityExt);
        int oldcount = couponEntityExtMapper.getCount();
        couponEntityExtMapper.deleteById(couponEntityExt.getId());
        Assert.assertSame(couponEntityExtMapper.getCount(), oldcount - 1);
    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        couponEntityExt.setRemark("_test_");

        List<CouponEntityExt> result = couponEntityExtMapper.list(couponEntityExt,  page);
       
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_remark_3_爱上课", result.get(1).getRemark());
    }
    @Test
    public void testQuery2() {
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        couponEntityExt.setIdSet(idSet);
        List<CouponEntityExt> result = couponEntityExtMapper.list(couponEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        couponEntityExt.setTotal(3.0);
        couponEntityExt.setBalance(3.0);
        List<CouponEntityExt> result = couponEntityExtMapper.list(couponEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_remark_3_爱上课", result.get(0).getRemark());
    }
    
    @Test
    public void testQuery4() {
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        couponEntityExt.setUserId(3);
        couponEntityExt.setId(2);
        List<CouponEntityExt> result = couponEntityExtMapper.list(couponEntityExt, page);
        Assert.assertEquals(0, result.size());
    }
}
