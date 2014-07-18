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
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class BookingEntityExtTest{
    @Autowired
    private BookingEntityExtMapper bookingEntityExtMapper;

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

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));

        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        bookingEntityExt.setName("_test_");

        List<BookingEntityExt> result = bookingEntityExtMapper.list(bookingEntityExt, page);
        Assert.assertEquals(4, result.size());
       Assert.assertEquals("_test_name_2_爱上课", result.get(1).getName());
    }

}
