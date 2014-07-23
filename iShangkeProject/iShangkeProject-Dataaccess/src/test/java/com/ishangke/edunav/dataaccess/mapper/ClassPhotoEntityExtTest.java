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

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ClassPhotoEntityExtTest extends BaseTest {
    @Autowired
    private ClassPhotoEntityExtMapper classPhotoEntityExtMapper;
    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateEntityExtMapper;
    @Autowired
    private CourseEntityExtMapper courseEntityExtMapper;
    @Autowired
    private CourseClassPhotoEntityExtMapper courseClassPhotoEntityExtMapper;
    @Autowired
    private CourseTemplateClassPhotoEntityExtMapper courseTemplateClassPhotoEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    @Test
    public void testAdd() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setEnabled(1);
        classPhotoEntityExt.setDeleted(0);
        classPhotoEntityExt.setPartnerId(1);
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        int oldcount = classPhotoEntityExtMapper.getCount();
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        Assert.assertSame(classPhotoEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        classPhotoEntityExt.setEnabled(1);
        classPhotoEntityExt.setDeleted(0);
        classPhotoEntityExt.setPartnerId(1);
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        int oldcount = classPhotoEntityExtMapper.getCount();
        classPhotoEntityExtMapper.deleteById(classPhotoEntityExt.getId());
        Assert.assertSame(classPhotoEntityExtMapper.getCount(), oldcount - 1);
    }

    // @Test
    // public void testList(){
    // ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
    // classPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // classPhotoEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // classPhotoEntityExt.setPartnerId(1);
    // classPhotoEntityExt.setEnabled(1);
    // classPhotoEntityExt.setDeleted(0);
    // classPhotoEntityExtMapper.add(classPhotoEntityExt);
    // int classPhotoId = classPhotoEntityExt.getId();
    //
    // List<ClassPhotoEntityExt> list =
    // classPhotoEntityExtMapper.list(classPhotoEntityExt, null);
    // Assert.assertSame(list.size(),1);
    //
    // int listSize =
    // classPhotoEntityExtMapper.getListCount(classPhotoEntityExt);
    // Assert.assertSame(listSize,1);
    //
    // PaginationEntity page = new PaginationEntity();
    // page.setOffset(0);
    // page.setSize(1);
    //
    // list = classPhotoEntityExtMapper.list(classPhotoEntityExt, page);
    // Assert.assertSame(list.size(),1);
    //
    //
    // /* Get By PartnerId */
    // list = classPhotoEntityExtMapper.listClassPhotoByPartnerId(1);
    // Assert.assertSame(list.size(),2);
    //
    // @SuppressWarnings("unused")
    // List<ClassPhotoEntityExt> clist = null;
    // /* Get By CourseId */
    // CourseTemplateEntityExt courseTemplateEntityExt = new
    // CourseTemplateEntityExt();
    // courseTemplateEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // courseTemplateEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // courseTemplateEntityExt.setCategoryId(1);
    // courseTemplateEntityExt.setLocationId(1);
    // courseTemplateEntityExt.setCircleId(1);
    // courseTemplateEntityExt.setPartnerId(1);
    // courseTemplateEntityExt.setAddressId(1);
    // courseTemplateEntityExt.setEnabled(1);
    // courseTemplateEntityExt.setDeleted(0);
    // courseTemplateEntityExtMapper.add(courseTemplateEntityExt);
    // int courseTemplateId = courseTemplateEntityExt.getId();
    //
    // CourseEntityExt courseEntityExt = new CourseEntityExt();
    // courseEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // courseEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // courseEntityExt.setCourseTemplateId(courseTemplateId);
    // courseEntityExt.setCategoryId(1);
    // courseEntityExt.setLocationId(1);
    // courseEntityExt.setCircleId(1);
    // courseEntityExt.setPartnerId(1);
    // courseEntityExt.setAddressId(1);
    // courseEntityExt.setEnabled(1);
    // courseEntityExt.setDeleted(0);
    // courseEntityExtMapper.add(courseEntityExt);
    // int courseId = courseEntityExt.getId();
    //
    // CourseClassPhotoEntityExt courseClassPhotoEntityExt = new
    // CourseClassPhotoEntityExt();
    // courseClassPhotoEntityExt.setCourseId(courseId);
    // courseClassPhotoEntityExt.setClassPhotoId(classPhotoId);
    // courseClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // courseClassPhotoEntityExt.setDeleted(0);
    // courseClassPhotoEntityExtMapper.add(courseClassPhotoEntityExt);
    //
    // list = classPhotoEntityExtMapper.listClassPhotoByCourseId(courseId);
    // Assert.assertSame(list.size(),1);
    //
    // /* Get By CourseTemplateId */
    // CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new
    // CourseTemplateClassPhotoEntityExt();
    // courseTemplateClassPhotoEntityExt.setCourseTemplateId(courseTemplateId);
    // courseTemplateClassPhotoEntityExt.setClassPhotoId(classPhotoId);
    // courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // courseTemplateClassPhotoEntityExt.setDeleted(0);
    // courseTemplateClassPhotoEntityExtMapper.add(courseTemplateClassPhotoEntityExt);
    //
    // list =
    // classPhotoEntityExtMapper.listClassPhotoByCourseTempleteId(courseTemplateId);
    // Assert.assertSame(list.size(),1);
    //
    // }
    //
    // @Test
    // public void testUpdate(){
    // ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
    // classPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // classPhotoEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // classPhotoEntityExt.setEnabled(1);
    // classPhotoEntityExt.setDeleted(0);
    // classPhotoEntityExt.setPartnerId(1);
    // classPhotoEntityExtMapper.add(classPhotoEntityExt);
    //
    //
    // List<ClassPhotoEntityExt> list =
    // classPhotoEntityExtMapper.list(classPhotoEntityExt, null);
    // String name = "李清";
    // list.get(0).setImgUrl(name);
    //
    // classPhotoEntityExtMapper.update(list.get(0));
    // list = classPhotoEntityExtMapper.list(list.get(0), null);
    // if(list.get(0).getImgUrl().equals(name)){
    // //Passed;
    // }else fail();
    // }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));

        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setTitle("_test_");

        List<ClassPhotoEntityExt> result = classPhotoEntityExtMapper.list(
                classPhotoEntityExt, page);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_title_2_爱上课", result.get(1).getTitle());
    }

    @Test
    public void testQuery2() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        classPhotoEntityExt.setIdSet(idSet);
        List<ClassPhotoEntityExt> result = classPhotoEntityExtMapper.list(
                classPhotoEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        classPhotoEntityExt.setPartnerId(4);

        List<ClassPhotoEntityExt> result = classPhotoEntityExtMapper.list(
                classPhotoEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_IU_2_爱上课", result.get(0).getImgUrl());
    }

    @Test
    public void testQuery4() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        classPhotoEntityExt.setPartnerId(4);
        classPhotoEntityExt.setId(2);
        List<ClassPhotoEntityExt> result = classPhotoEntityExtMapper.list(
                classPhotoEntityExt, page);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testQuery5() {

        int teacherCount = classPhotoEntityExtMapper.getCountByPartnerId(2);

        Assert.assertSame(1, teacherCount);

        List<ClassPhotoEntityExt> result = classPhotoEntityExtMapper
                .listClassPhotoByPartnerId(5);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_IU_1_爱上课", result.get(0).getImgUrl());
    }

    @Test
    public void testQuery6() {

        int teacherCount = classPhotoEntityExtMapper.getCountByCourseId(2);
        ;
        Assert.assertSame(1, teacherCount);

        List<ClassPhotoEntityExt> result = classPhotoEntityExtMapper
                .listClassPhotoByCourseId(2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_IU_1_爱上课", result.get(0).getImgUrl());
    }

    @Test
    public void testQuery7() {

        int teacherCount = classPhotoEntityExtMapper
                .getCountByCourseTemplateId(2);
        ;
        Assert.assertSame(1, teacherCount);

        List<ClassPhotoEntityExt> result = classPhotoEntityExtMapper
                .listClassPhotoByCourseTempleteId(3);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_IU_3_爱上课", result.get(0).getImgUrl());
    }

    @Test
    public void testGet() {
        ClassPhotoEntityExt getbyid1 = classPhotoEntityExtMapper.getById(2);
        ClassPhotoEntityExt getbyid2 = classPhotoEntityExtMapper.getById(3);
        ClassPhotoEntityExt getbyid3 = classPhotoEntityExtMapper.getById(4);
        Assert.assertEquals("_test_title_1_爱上课", getbyid1.getTitle());
        Assert.assertEquals("_test_title_2_爱上课", getbyid2.getTitle());
        Assert.assertEquals("_test_title_3_爱上课", getbyid3.getTitle());
    }

    @Test
    public void testUpdate() {
        ClassPhotoEntityExt upDate = classPhotoEntityExtMapper.getById(2);
        upDate.setSnapshotUrl("test_爱上课");
        upDate.setImgUrl("test_ishangke");
        upDate.setCreateTime(time);
        classPhotoEntityExtMapper.update(upDate);
        upDate = classPhotoEntityExtMapper.getById(2);
        Assert.assertEquals("test_爱上课", upDate.getSnapshotUrl());
        Assert.assertEquals("test_ishangke", upDate.getImgUrl());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
