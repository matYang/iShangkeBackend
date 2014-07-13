package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class BookingHistoryEntityExtTest {
    @Autowired
    private BookingHistoryEntityExtMapper bookingHistoryEntityExtMapper;

    @Test
    public void testAdd() {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        bookingHistoryEntityExt.setBookingId(1);
        bookingHistoryEntityExt.setUserId(1);
        bookingHistoryEntityExt.setPostStatus(1);
        bookingHistoryEntityExt.setPreStatus(1);
        bookingHistoryEntityExt.setNormal(1);
        bookingHistoryEntityExt.setCreateTime(new Date());
        bookingHistoryEntityExt.setEnabled(1);
        bookingHistoryEntityExt.setDeleted(0);
        bookingHistoryEntityExtMapper.add(bookingHistoryEntityExt);
        int oldcount = bookingHistoryEntityExtMapper.getCount();
        bookingHistoryEntityExtMapper.add(bookingHistoryEntityExt);
        Assert.assertSame(bookingHistoryEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        bookingHistoryEntityExt.setBookingId(1);
        bookingHistoryEntityExt.setUserId(1);
        bookingHistoryEntityExt.setPostStatus(1);
        bookingHistoryEntityExt.setPreStatus(1);
        bookingHistoryEntityExt.setNormal(1);
        bookingHistoryEntityExt.setCreateTime(new Date());
        bookingHistoryEntityExt.setEnabled(1);
        bookingHistoryEntityExt.setDeleted(0);
        bookingHistoryEntityExtMapper.add(bookingHistoryEntityExt);
        int oldcount = bookingHistoryEntityExtMapper.getCount();
        bookingHistoryEntityExtMapper.deleteById(bookingHistoryEntityExt.getId());
        Assert.assertSame(bookingHistoryEntityExtMapper.getCount(), oldcount - 1);
    }
}
