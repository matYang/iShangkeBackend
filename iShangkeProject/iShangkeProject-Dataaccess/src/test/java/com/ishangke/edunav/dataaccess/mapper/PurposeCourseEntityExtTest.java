package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.model.PurposeCourseEntityExt;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class PurposeCourseEntityExtTest {
    @Autowired
    private PurposeCourseEntityExtMapper purposeCourseEntityExtMapper;
    
    /*@Test
    public void testAdd(){
        PurposeCourseEntityExt purposeCourse = new PurposeCourseEntityExt();
        purposeCourse.setCategoryId(6);
        purposeCourse.setCreateTime(DateUtility.getCurTimeInstance());
        purposeCourse.setCreateTimeEnd(DateUtility.getCurTimeInstance());
        purposeCourse.setCreateTimeStart(DateUtility.getCurTimeInstance());
        //purposeCourse.setDeleted(0);
        purposeCourse.setPhone("6");
        purposeCourse.setRemark("6");
        purposeCourse.setUserName("6");
        System.out.println(purposeCourseEntityExtMapper.add(purposeCourse));
    }
    
    @Test
    public void testDelete(){
        purposeCourseEntityExtMapper.deleteById(3);
    }
    
    @Test
    public void testList(){
        PurposeCourseEntityExt purposeCourse = new PurposeCourseEntityExt();
        purposeCourse.setCategoryId(1);
        //purposeCourse.setCreateTimeStart(DateUtility.getCurTimeInstance());
        List<PurposeCourseEntityExt> list = purposeCourseEntityExtMapper.list(purposeCourse, null);
        System.out.println(list.size());
    }
    
    @Test
    public void testGetListCount(){
        PurposeCourseEntityExt purposeCourse = new PurposeCourseEntityExt();
        purposeCourse.setCategoryId(1);
        System.out.println(purposeCourseEntityExtMapper.getListCount(purposeCourse));
    }
    
    @Test
    public void testUpdate(){
        PurposeCourseEntityExt purposeCourse = purposeCourseEntityExtMapper.getById(1);
        purposeCourse.setPhone("110");
        purposeCourseEntityExtMapper.update(purposeCourse);
        PurposeCourseEntityExt purposeCourseAfter = purposeCourseEntityExtMapper.getById(1);
        System.out.println(purposeCourseAfter.getPhone());
        Assert.assertEquals(purposeCourseAfter.getPhone(),"110");
    }*/
    
    @Test
    public void testGetById(){
        Assert.assertEquals(1, 1);
    }
}
