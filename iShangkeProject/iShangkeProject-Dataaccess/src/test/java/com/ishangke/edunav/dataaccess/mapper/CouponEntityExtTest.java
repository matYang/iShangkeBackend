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

}
