package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CouponHistoryEntityExtTest {
    @Autowired
    private CouponHistoryEntityExtMapper couponHistoryEntityExtMapper;

    @Test
    public void testAdd() {
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        couponHistoryEntityExt.setCreateTime(new Date());
        couponHistoryEntityExt.setLastModifyTime(new Date());
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
        couponHistoryEntityExt.setCreateTime(new Date());
        couponHistoryEntityExt.setLastModifyTime(new Date());
        couponHistoryEntityExt.setCouponId(1);
        couponHistoryEntityExt.setDeleted(0);
        couponHistoryEntityExtMapper.add(couponHistoryEntityExt);
        int oldcount = couponHistoryEntityExtMapper.getCount();
        couponHistoryEntityExtMapper.deleteById(couponHistoryEntityExt.getId());
        Assert.assertSame(couponHistoryEntityExtMapper.getCount(), oldcount - 1);
    }

}
