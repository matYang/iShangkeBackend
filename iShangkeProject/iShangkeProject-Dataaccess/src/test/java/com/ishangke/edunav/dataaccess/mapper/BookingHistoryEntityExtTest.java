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

import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;

//before/after方法注入，aop
//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, BookingHistoryEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
// 继承BaseTest
public class BookingHistoryEntityExtTest {
    @Autowired
    private BookingHistoryEntityExtMapper bookingHistoryEntityExtMapper;
    private Calendar time = Calendar.getInstance();
//    // resource里面
//    public BookingHistoryEntityExtTest() {
//        scriptAfterClass = "BookingHistoryEntityExtTestAfter.sql";
//        scriptBeforeClass = "BookingHistoryEntityExtTestBefore.sql";
//    }

    @Test
    public void testAdd() {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        bookingHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        bookingHistoryEntityExt.setDeleted(0);
        bookingHistoryEntityExt.setEnabled(1);
        bookingHistoryEntityExt.setBookingId(1);
        bookingHistoryEntityExt.setUserId(1);
        bookingHistoryEntityExt.setOptName(0);
        bookingHistoryEntityExt.setPreStatus(155);
        bookingHistoryEntityExt.setPostStatus(3);
        bookingHistoryEntityExt.setNormal(0);
        int oldcount = bookingHistoryEntityExtMapper.getCount();
        bookingHistoryEntityExtMapper.add(bookingHistoryEntityExt);
        Assert.assertSame(bookingHistoryEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        bookingHistoryEntityExt.setBookingId(1);
        bookingHistoryEntityExt.setUserId(1);
        bookingHistoryEntityExt.setOptName(0);
        bookingHistoryEntityExt.setPostStatus(1);
        bookingHistoryEntityExt.setPreStatus(3);
        bookingHistoryEntityExt.setNormal(0);
        bookingHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        bookingHistoryEntityExt.setEnabled(1);
        bookingHistoryEntityExt.setDeleted(0);
        bookingHistoryEntityExtMapper.add(bookingHistoryEntityExt);
        int oldcount = bookingHistoryEntityExtMapper.getCount();
        bookingHistoryEntityExtMapper.deleteById(bookingHistoryEntityExt.getId());
        Assert.assertSame(bookingHistoryEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        bookingHistoryEntityExt.setRemark("_test_");

        List<BookingHistoryEntityExt> result = bookingHistoryEntityExtMapper.list(bookingHistoryEntityExt, page);
        //3 here, 1 default, 3 added among which 1 is deleted
        Assert.assertEquals(4, result.size());
       Assert.assertEquals("_test_remark_2_爱上课", result.get(1).getRemark());
    }
    @Test
    public void testQuery2() {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        bookingHistoryEntityExt.setIdSet(idSet);
        List<BookingHistoryEntityExt> result = bookingHistoryEntityExtMapper.list(bookingHistoryEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        bookingHistoryEntityExt.setUserId(5);
        bookingHistoryEntityExt.setBookingId(2);
        List<BookingHistoryEntityExt> result = bookingHistoryEntityExtMapper.list(bookingHistoryEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_remark_1_爱上课", result.get(0).getRemark());
    }
    
    @Test
    public void testQuery4() {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        bookingHistoryEntityExt.setUserId(5);
        bookingHistoryEntityExt.setBookingId(3);
        List<BookingHistoryEntityExt> result = bookingHistoryEntityExtMapper.list(bookingHistoryEntityExt, page);
        Assert.assertEquals(0, result.size());
    }
    @Test
    public void testGet() {
        BookingHistoryEntityExt getbyid1 = bookingHistoryEntityExtMapper
                .getById(2);
        BookingHistoryEntityExt getbyid2 = bookingHistoryEntityExtMapper
                .getById(3);
        BookingHistoryEntityExt getbyid3 = bookingHistoryEntityExtMapper
                .getById(4);
        Assert.assertEquals("_test_remark_1_爱上课", getbyid1.getRemark());
        Assert.assertEquals("_test_remark_2_爱上课", getbyid2.getRemark());
        Assert.assertEquals("_test_remark_3_爱上课", getbyid3.getRemark());
    }
    @Test
    public void testUpdate() {
        BookingHistoryEntityExt upDate = bookingHistoryEntityExtMapper
                .getById(2);
        upDate.setRemark("test_爱上课");
        upDate.setOptName(7);
        upDate.setCreateTime(time);
        bookingHistoryEntityExtMapper.update(upDate);
        upDate = bookingHistoryEntityExtMapper.getById(2);
        Assert.assertEquals("test_爱上课",upDate.getRemark());
        Assert.assertSame(7, upDate.getOptName());  
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime())); 
    }
}
