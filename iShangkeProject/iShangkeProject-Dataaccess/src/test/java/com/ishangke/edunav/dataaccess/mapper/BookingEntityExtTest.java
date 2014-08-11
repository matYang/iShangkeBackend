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

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class BookingEntityExtTest {
    @Autowired
    private BookingEntityExtMapper bookingEntityExtMapper;
    private Calendar time = Calendar.getInstance();
    @Test
    public void testAdd() {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        bookingEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        bookingEntityExt.setEnabled(1);
        bookingEntityExt.setDeleted(0);
        bookingEntityExt.setUserId(1);
        bookingEntityExt.setCourseId(1);
        bookingEntityExt.setCourseTemplateId(1);
        bookingEntityExtMapper.add(bookingEntityExt);
        int oldcount = bookingEntityExtMapper.getCount();
        bookingEntityExtMapper.add(bookingEntityExt);
        Assert.assertSame(bookingEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        bookingEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        bookingEntityExt.setEnabled(1);
        bookingEntityExt.setDeleted(0);
        bookingEntityExt.setUserId(1);
        bookingEntityExt.setCourseId(1);
        bookingEntityExt.setCourseTemplateId(1);
        bookingEntityExtMapper.add(bookingEntityExt);
        int oldcount = bookingEntityExtMapper.getCount();
        bookingEntityExtMapper.deleteById(bookingEntityExt.getId());
        Assert.assertSame(bookingEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));

        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        bookingEntityExt.setName("_test_");

        List<BookingEntityExt> result = bookingEntityExtMapper.list(
                bookingEntityExt, page);
        Assert.assertEquals(4, result.size());
//        Assert.assertEquals("_test_name_2_爱上课", result.get(1).getName());
    }

    @Test
    public void testQuery2() {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        bookingEntityExt.setIdSet(idSet);
        List<BookingEntityExt> result = bookingEntityExtMapper.list(
                bookingEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        bookingEntityExt.setUserId(2);
       
        page.addOrderByEntity(new OrderByEntity("STATUS",
                DataaccessConstants.ORDER_DESC));
        List<BookingEntityExt> result = bookingEntityExtMapper.list(
                bookingEntityExt, page);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("_test_name_3_爱上课", result.get(0).getName());
        Assert.assertEquals("_test_reference_1_爱上课", result.get(1).getReference());
    }

    @Test
    public void testQuery4() {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        bookingEntityExt.setUserId(2);
        bookingEntityExt.setCourseId(4);
        List<BookingEntityExt> result = bookingEntityExtMapper.list(
                bookingEntityExt, page);
        Assert.assertEquals(1, result.size());
       Assert.assertEquals("_test_reference_1_爱上课", result.get(0).getReference());
    }
    @Test
    public void testGet() {
        BookingEntityExt getbyid1 = bookingEntityExtMapper
                .getById(2);
        BookingEntityExt getbyid2 = bookingEntityExtMapper
                .getById(3);
        BookingEntityExt getbyid3 = bookingEntityExtMapper
                .getById(4);
        Assert.assertEquals("_test_name_1_爱上课", getbyid1.getName());
        Assert.assertEquals("_test_name_2_爱上课", getbyid2.getName());
        Assert.assertEquals("_test_name_3_爱上课", getbyid3.getName());
    }
    @Test
    public void testUpdate() {
        BookingEntityExt upDate= bookingEntityExtMapper
                .getById(2);
        upDate.setReference("test_爱上课");
        upDate.setType(9);
        upDate.setCreateTime(time);
        bookingEntityExtMapper.update(upDate);
        upDate = bookingEntityExtMapper.getById(2);
        Assert.assertEquals("test_爱上课",upDate.getReference());
        Assert.assertSame(9, upDate.getType());  
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime())); 
    }
    
    @Test
    public void testListByPartnerId() {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        List<BookingEntityExt> result = bookingEntityExtMapper.listByPartnerId(bookingEntityExt, 2, null);
        System.out.println("xxxx" + result.size());
        System.out.println("oooo" + bookingEntityExtMapper.getCountByPartnerId(bookingEntityExt, 2));
    }
    
    @Test 
    public void testGetById() {
        BookingEntityExt booking = bookingEntityExtMapper.getById(1);
        System.out.println(booking.getCourse().getId());
    }
}
