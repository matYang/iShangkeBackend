package com.ishangke.edunav.manager.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.converter.BookingConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.transform.Operation;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, BookingManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class BookingManagerImplTest extends BaseTest{
    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private BookingManager bookingManager;
    
    @Autowired
    private BookingEntityExtMapper bookingMapper;
    
    @Autowired
    private UserEntityExtMapper userMapper; 
    
    @Autowired
    private TransformManager transformManager;

    @Test
    public void testTransform() throws IllegalArgumentException, IllegalAccessException {
        cacheManager.del(Constant.TRANSFORMOPERATION + Constant.ROLESYSTEMADMIN + Constant.STATUSTRANSFORMBOOKING);
        BookingEntityExt booking = new BookingEntityExt();
        booking.setUserId(3);
        //course id 为1的partner为1
        booking.setCourseId(1);
        booking.setCourseTemplateId(1);
        booking.setLastModifyTime(DateUtility.getCurTimeInstance());
        booking.setCreateTime(DateUtility.getCurTimeInstance());
        booking.setEnabled(0);
        booking.setStatus(0);
        bookingMapper.add(booking);
        System.out.println(booking.getId());
        bookingManager.transformBookingStatus(BookingConverter.toBo(booking), 1, UserConverter.toBo(userMapper.getById(1)));
        
        List<Operation> list = transformManager.listAll("booking");
        for (Operation o : list) {
            for(Field f : Operation.class.getDeclaredFields()) {
                f.setAccessible(true);
                System.out.println(f.getName() + "===>" + f.get(o).toString());
            }
            System.out.println("@@@@@@@@@@@@@@@@@");
        }
    }
}
