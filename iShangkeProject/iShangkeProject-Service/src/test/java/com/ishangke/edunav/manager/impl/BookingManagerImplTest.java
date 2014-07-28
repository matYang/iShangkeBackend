package com.ishangke.edunav.manager.impl;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.transform.Operation;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, BookingManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class BookingManagerImplTest {
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

    @Test(expected = ManagerException.class)
    public void testTransform() throws IllegalArgumentException, IllegalAccessException {
        cacheManager.del(Constant.TRANSFORMOPERATION + Constant.ROLESYSTEMADMIN + Constant.STATUSTRANSFORMBOOKING);
        BookingEntityExt booking = new BookingEntityExt();
        booking.setUserId(3);
        booking.setCourseId(1);
        booking.setCourseTemplateId(1);
        booking.setLastModifyTime(DateUtility.getCurTimeInstance());
        booking.setCreateTime(DateUtility.getCurTimeInstance());
        booking.setEnabled(0);
        booking.setStatus(0);
        bookingMapper.add(booking);
        System.out.println(booking.getId());
        bookingManager.transformBookingStatus(BookingConverter.toBo(booking), null, 12, UserConverter.toBo(userMapper.getById(5)));
        
        List<Operation> list = transformManager.listAll("booking");
        for (Operation o : list) {
            for(Field f : Operation.class.getDeclaredFields()) {
                f.setAccessible(true);
                System.out.println(f.getName() + "===>" + f.get(o).toString());
            }
            System.out.println("@@@@@@@@@@@@@@@@@");
        }
        System.out.println(list.size());
        Collections.sort(list, new Comparator<Operation>(){
            @Override
            public int compare(Operation o1, Operation o2) {
                return o1.getOperateCode() - o2.getOperateCode();
            }
            
        });
        for (Operation o : list) {
            System.out.println(o.getOperateCode());
        }
        BookingEntityExt e = bookingMapper.getById(booking.getId());
        System.out.println(e.getStatus());
    }
}
