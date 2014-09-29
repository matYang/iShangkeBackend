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
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.AuthManager;
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
    
    @Autowired
    private AuthManager authManager;

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
        bookingManager.transformBookingStatus(BookingConverter.toBo(booking), 12, UserConverter.toBo(userMapper.getById(5)));
        
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
    @Test
    public void testCashBack1() throws IllegalAccessException{
        cacheManager.del(Constant.ROLEPREFIX + 10);
//        BookingEntityExt booking = bookingMapper.getById(6);
//        UserEntityExt applier = userMapper.getById(8);
//        UserEntityExt user = userMapper.getById(9);
//        System.out.println("user before:" + user.getAccount().getBalance());
//        System.out.println("applier before:" + applier.getAccount().getBalance());
//        System.out.println("user credit before:" + user.getCredit().getCredit());
//        Double userB = user.getAccount().getBalance();
//        Double appb = applier.getAccount().getBalance();
//        UserEntityExt admin = userMapper.getById(10);
//        BookingBo  bookingBo = BookingConverter.toBo(booking);
//        UserBo applierBo = UserConverter.toBo(applier);
//        UserBo userBo = UserConverter.toBo(user);
//        UserBo adminBo = UserConverter.toBo(admin);
//        System.out.println("admin role:"+authManager.getRole(adminBo.getId()));
//        bookingManager.transformBookingStatus(null,20,adminBo);
//        UserEntityExt applierAfter = userMapper.getById(8);
//        UserEntityExt userAfter = userMapper.getById(9);
//        System.out.println("user after:" + userAfter.getAccount().getBalance());
//        System.out.println("applier after:" + applierAfter.getAccount().getBalance());
//        System.out.println("user credit after:" + userAfter.getCredit().getCredit());
//        Double appa = applierAfter.getAccount().getBalance();
//        //Assert.assertSame("20.0", "20.0");
    }
}
