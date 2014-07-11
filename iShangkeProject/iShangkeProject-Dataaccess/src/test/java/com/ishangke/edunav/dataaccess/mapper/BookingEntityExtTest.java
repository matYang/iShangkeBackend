package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class BookingEntityExtTest {
    @Autowired
    private BookingEntityExtMapper bookingEntityExtMapper;

    @Test
    public void testAdd() {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        bookingEntityExt.setCreateTime(new Date());
        bookingEntityExt.setLastModifyTime(new Date());
        bookingEntityExt.setEnabled(1);
        bookingEntityExt.setDeleted(0);
        bookingEntityExt.setUserId(1);
        bookingEntityExt.setCourseId(1);
        bookingEntityExtMapper.add(bookingEntityExt);
        int oldcount = bookingEntityExtMapper.getCount();
        bookingEntityExtMapper.add(bookingEntityExt);
        Assert.assertSame(bookingEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        bookingEntityExt.setCreateTime(new Date());
        bookingEntityExt.setLastModifyTime(new Date());
        bookingEntityExt.setEnabled(1);
        bookingEntityExt.setDeleted(0);
        bookingEntityExtMapper.add(bookingEntityExt);
        int oldcount = bookingEntityExtMapper.getCount();
        bookingEntityExtMapper.deleteById(bookingEntityExt.getId());
        Assert.assertSame(bookingEntityExtMapper.getCount(), oldcount - 1);
    }


}
