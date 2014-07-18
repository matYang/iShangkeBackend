package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional

public class TeacherEntityExtTest {

    @Autowired
    private TeacherEntityExtMapper teacherEntityExtMapper;
    
    @Test
    public void testAdd(){
        Calendar time = Calendar.getInstance();
        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
        teacherEntityExt.setCreateTime(time);
        teacherEntityExt.setLastModifyTime(time);
        teacherEntityExt.setDeleted(0);
        teacherEntityExt.setEnabled(1);
        teacherEntityExt.setPartnerId(1);
        teacherEntityExt.setPopularity(1);
        int oldCount = teacherEntityExtMapper.getCount();
        teacherEntityExtMapper.add(teacherEntityExt);
        Assert.assertSame(teacherEntityExtMapper.getCount(), oldCount + 1);
        
    }
    
    @Test
    public void testDelete(){
        Calendar time = Calendar.getInstance();
        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
        teacherEntityExt.setCreateTime(time);
        teacherEntityExt.setLastModifyTime(time);
        teacherEntityExt.setDeleted(0);
        teacherEntityExt.setEnabled(1);
        teacherEntityExt.setPartnerId(1);
        teacherEntityExt.setPopularity(1);       
        teacherEntityExtMapper.add(teacherEntityExt);
        int oldCount = teacherEntityExtMapper.getCount();
        teacherEntityExtMapper.deleteById(teacherEntityExt.getId());
        Assert.assertSame(teacherEntityExtMapper.getCount(), oldCount - 1);
    }
    
//    @Test
//    public void testList(){
//        Calendar time = Calendar.getInstance();
//        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
//        teacherEntityExt.setCreateTime(time);
//        teacherEntityExt.setLastModifyTime(time);
//        teacherEntityExt.setDeleted(0);
//        teacherEntityExt.setEnabled(1);
//        teacherEntityExt.setPartnerId(1);
//        teacherEntityExt.setPopularity(1);       
//        teacherEntityExtMapper.add(teacherEntityExt);
////        teacherEntityExt.setCreateTimeStart(new Calendar(System.currentTimeMillis() - 10000));
////        teacherEntityExt.setLastModifyTimeStart(new Calendar(System.currentTimeMillis() - 10000));
//        
//        List<TeacherEntityExt> list = teacherEntityExtMapper.list(teacherEntityExt, null);
//        Assert.assertSame(list.size(),1);
//        
//        int listSize = teacherEntityExtMapper.getListCount(teacherEntityExt);
//        Assert.assertSame(listSize,1);
//        
//        PaginationEntity page = new PaginationEntity();
//        page.setOffset(0);
//        page.setSize(1);
//        
//        list = teacherEntityExtMapper.list(teacherEntityExt, null);
//        Assert.assertSame(list.size(),1);
//        
//        listSize = teacherEntityExtMapper.getListCount(teacherEntityExt);
//        Assert.assertSame(listSize,1);
//        
//    }
//    
//    @Test
//    public void testUpdate(){
//        Calendar time = Calendar.getInstance();
//        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
//        teacherEntityExt.setCreateTime(time);
//        teacherEntityExt.setLastModifyTime(time);
//        teacherEntityExt.setDeleted(0);
//        teacherEntityExt.setEnabled(1);
//        teacherEntityExt.setPartnerId(1);
//        teacherEntityExt.setPopularity(1);       
//        teacherEntityExtMapper.add(teacherEntityExt);
////        teacherEntityExt.setCreateTimeStart(new Calendar(System.currentTimeMillis() - 10000));
////        teacherEntityExt.setLastModifyTimeStart(new Calendar(System.currentTimeMillis() - 10000));
//        
//        List<TeacherEntityExt> list = teacherEntityExtMapper.list(teacherEntityExt, null);
//        String imgUrl = "李清";
//        list.get(0).setImgUrl(imgUrl);
//        teacherEntityExtMapper.update(list.get(0));
//        list = teacherEntityExtMapper.list(list.get(0), null);
//        
//        if(list.get(0).getImgUrl().equals(imgUrl)){
//            //Passed;
//        }else fail();
//    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
        teacherEntityExt.setName("_test_");
        List<TeacherEntityExt> result = teacherEntityExtMapper.list(teacherEntityExt, page);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_name_1_爱上课", result.get(0).getName());
    }
}
