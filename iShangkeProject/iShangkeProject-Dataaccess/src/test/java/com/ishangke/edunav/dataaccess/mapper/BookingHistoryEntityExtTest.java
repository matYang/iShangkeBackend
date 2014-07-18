package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

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
}
