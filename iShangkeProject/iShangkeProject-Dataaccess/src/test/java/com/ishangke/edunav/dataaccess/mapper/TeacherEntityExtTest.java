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
import com.ishangke.edunav.dataaccess.model.SchoolEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class TeacherEntityExtTest {

    @Autowired
    private TeacherEntityExtMapper teacherEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    @Test
    public void testAdd() {
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
    public void testDelete() {
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

    // @Test
    // public void testList(){
    // Calendar time = Calendar.getInstance();
    // TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
    // teacherEntityExt.setCreateTime(time);
    // teacherEntityExt.setLastModifyTime(time);
    // teacherEntityExt.setDeleted(0);
    // teacherEntityExt.setEnabled(1);
    // teacherEntityExt.setPartnerId(1);
    // teacherEntityExt.setPopularity(1);
    // teacherEntityExtMapper.add(teacherEntityExt);
    // // teacherEntityExt.setCreateTimeStart(new
    // Calendar(System.currentTimeMillis() - 10000));
    // // teacherEntityExt.setLastModifyTimeStart(new
    // Calendar(System.currentTimeMillis() - 10000));
    //
    // List<TeacherEntityExt> list =
    // teacherEntityExtMapper.list(teacherEntityExt, null);
    // Assert.assertSame(list.size(),1);
    //
    // int listSize = teacherEntityExtMapper.getListCount(teacherEntityExt);
    // Assert.assertSame(listSize,1);
    //
    // PaginationEntity page = new PaginationEntity();
    // page.setOffset(0);
    // page.setSize(1);
    //
    // list = teacherEntityExtMapper.list(teacherEntityExt, null);
    // Assert.assertSame(list.size(),1);
    //
    // listSize = teacherEntityExtMapper.getListCount(teacherEntityExt);
    // Assert.assertSame(listSize,1);
    //
    // }
    //
    // @Test
    // public void testUpdate(){
    // Calendar time = Calendar.getInstance();
    // TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
    // teacherEntityExt.setCreateTime(time);
    // teacherEntityExt.setLastModifyTime(time);
    // teacherEntityExt.setDeleted(0);
    // teacherEntityExt.setEnabled(1);
    // teacherEntityExt.setPartnerId(1);
    // teacherEntityExt.setPopularity(1);
    // teacherEntityExtMapper.add(teacherEntityExt);
    // // teacherEntityExt.setCreateTimeStart(new
    // Calendar(System.currentTimeMillis() - 10000));
    // // teacherEntityExt.setLastModifyTimeStart(new
    // Calendar(System.currentTimeMillis() - 10000));
    //
    // List<TeacherEntityExt> list =
    // teacherEntityExtMapper.list(teacherEntityExt, null);
    // String imgUrl = "李清";
    // list.get(0).setImgUrl(imgUrl);
    // teacherEntityExtMapper.update(list.get(0));
    // list = teacherEntityExtMapper.list(list.get(0), null);
    //
    // if(list.get(0).getImgUrl().equals(imgUrl)){
    // //Passed;
    // }else fail();
    // }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));
        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
        teacherEntityExt.setName("_test_");
        List<TeacherEntityExt> result = teacherEntityExtMapper.list(
                teacherEntityExt, page);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_name_1_爱上课", result.get(0).getName());
    }

    @Test
    public void testQuery2() {
        TeacherEntityExt TeacherEntityExt = new TeacherEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        TeacherEntityExt.setIdSet(idSet);
        List<TeacherEntityExt> result = teacherEntityExtMapper.list(
                TeacherEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        TeacherEntityExt TeacherEntityExt = new TeacherEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        TeacherEntityExt.setEnabled(2);
        page.addOrderByEntity(new OrderByEntity("POPULARITY",
                DataaccessConstants.ORDER_DESC));
        List<TeacherEntityExt> result = teacherEntityExtMapper.list(
                TeacherEntityExt, page);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("_test_name_2_爱上课", result.get(0).getName());
        Assert.assertEquals("_test_name_2_爱上课", result.get(0).getName());
    }

    @Test
    public void testQuery4() {
        TeacherEntityExt TeacherEntityExt = new TeacherEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        TeacherEntityExt.setEnabled(2);
        TeacherEntityExt.setPartnerId(2);
        List<TeacherEntityExt> result = teacherEntityExtMapper.list(
                TeacherEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_name_2_爱上课", result.get(0).getName());
    }

    @Test
    public void testQuery5() {

        int teacherCount = teacherEntityExtMapper.getCountByPartnerId(3);
        Assert.assertSame(1, teacherCount);

        List<TeacherEntityExt> result = teacherEntityExtMapper
                .listTeacherByPartnerId(4);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_name_2_爱上课", result.get(0).getName());
    }

    @Test
    public void testQuery6() {
        int teacherCount = teacherEntityExtMapper.getCountByCourseId(3);
        Assert.assertSame(1, teacherCount);

        List<TeacherEntityExt> result = teacherEntityExtMapper
                .listTeacherByCourseId(4);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_name_2_爱上课", result.get(0).getName());
    }

    @Test
    public void testQuery7() {

        int teacherCount = teacherEntityExtMapper.getCountByCourseTemplateId(2);
        ;
        Assert.assertSame(1, teacherCount);

        List<TeacherEntityExt> result = teacherEntityExtMapper
                .listTeacherByCourseTempleteId(5);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_name_1_爱上课", result.get(0).getName());
    }

    @Test
    public void testGet() {
        TeacherEntityExt getbyid1 = teacherEntityExtMapper.getById(2);
        TeacherEntityExt getbyid2 = teacherEntityExtMapper.getById(3);
        TeacherEntityExt getbyid3 = teacherEntityExtMapper.getById(4);
        Assert.assertEquals("_test_name_1_爱上课", getbyid1.getName());
        Assert.assertEquals("_test_name_2_爱上课", getbyid2.getName());
        Assert.assertEquals("_test_name_3_爱上课", getbyid3.getName());
    }

    @Test
    public void testUpdate() {
        TeacherEntityExt upDate = teacherEntityExtMapper.getById(2);
        upDate.setName("_test_name_爱上课");
        ;
        upDate.setLastModifyTime(time);
        upDate.setPopularity(100);
        teacherEntityExtMapper.update(upDate);
        upDate = teacherEntityExtMapper.getById(2);
        Assert.assertEquals("_test_name_爱上课", upDate.getName());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getLastModifyTime()));
        Assert.assertSame(100, upDate.getPopularity());
    }
}
