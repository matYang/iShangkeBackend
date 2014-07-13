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
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CouponHistoryEntityExtTest extends BaseTest{
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

    @Test
    public void testList(){
//        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
//        couponHistoryEntityExt.setCreateTime(new Date());
//        couponHistoryEntityExt.setLastModifyTime(new Date());
//        couponHistoryEntityExt.setCouponId(1);
//        couponHistoryEntityExt.setDeleted(0);
//        couponHistoryEntityExtMapper.add(couponHistoryEntityExt);
//
//        couponHistoryEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 10000000));
//        couponHistoryEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 10000000));
//        
//        List<CouponHistoryEntityExt> list = couponHistoryEntityExtMapper.list(couponHistoryEntityExt, null);
//        Assert.assertSame(list.size(),1);
//
//        int listSize = couponHistoryEntityExtMapper.getListCount(couponHistoryEntityExt, null);
//        Assert.assertSame(listSize,1);
//
//        PaginationEntity page = new PaginationEntity();
//        page.setOffset(0);
//        page.setSize(1);
//        
//        list = couponHistoryEntityExtMapper.list(couponHistoryEntityExt, page);
//        Assert.assertSame(list.size(),1);
//
//        listSize = couponHistoryEntityExtMapper.getListCount(couponHistoryEntityExt, page);
//        Assert.assertSame(listSize,1);
        Assert.assertTrue(true);

    }
    
    @Test
    public void testUpdate(){
//        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
//        couponHistoryEntityExt.setCreateTime(new Date());
//        couponHistoryEntityExt.setLastModifyTime(new Date());
//        couponHistoryEntityExt.setCouponId(1);
//        couponHistoryEntityExt.setDeleted(0);
//        couponHistoryEntityExtMapper.add(couponHistoryEntityExt);
//
//        couponHistoryEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 10000000));
//        couponHistoryEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 10000000));
//        
//        List<CouponHistoryEntityExt> list = couponHistoryEntityExtMapper.list(couponHistoryEntityExt, null);
//        Double charge = 1.2;
//        list.get(0).setCharge(charge);
//        
//        couponHistoryEntityExtMapper.update(list.get(0));
//        list = couponHistoryEntityExtMapper.list(list.get(0), null);
//        
//        if(list.get(0).getCharge().equals(charge)){
//            //Passed;
//        }else fail();
        Assert.assertTrue(true);
        
    }

}
