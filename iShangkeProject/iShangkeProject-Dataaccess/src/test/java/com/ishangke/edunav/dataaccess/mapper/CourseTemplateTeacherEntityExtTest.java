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
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTemplateTeacherEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTemplateTeacherEntityExtTest extends BaseTest{
    @Autowired
    private CourseTemplateTeacherEntityExtMapper courseTemplateTeacherEntityExtMapper;
    private Calendar time = Calendar.getInstance();
//    public CourseTemplateTeacherEntityExtTest() {
//        scriptAfterClass = "CourseTemplateTeacherEntityExtTestAfter.sql";
//        scriptBeforeClass = "CourseTemplateTeacherEntityExtTestBefore.sql";
//    }
    @Test
    public void testAdd() {
        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
        courseTemplateTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTemplateTeacherEntityExt.setCourseTemplateId(1);
        courseTemplateTeacherEntityExt.setTeacherId(1);
        courseTemplateTeacherEntityExt.setDeleted(0);
        courseTemplateTeacherEntityExtMapper
                .add(courseTemplateTeacherEntityExt);
        int oldcount = courseTemplateTeacherEntityExtMapper.getCount();
        courseTemplateTeacherEntityExtMapper
                .add(courseTemplateTeacherEntityExt);
        Assert.assertSame(courseTemplateTeacherEntityExtMapper.getCount(),
                oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
        courseTemplateTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTemplateTeacherEntityExt.setCourseTemplateId(1);
        courseTemplateTeacherEntityExt.setTeacherId(1);
        courseTemplateTeacherEntityExt.setDeleted(0);
        courseTemplateTeacherEntityExtMapper
                .add(courseTemplateTeacherEntityExt);
        int oldcount = courseTemplateTeacherEntityExtMapper.getCount();
        courseTemplateTeacherEntityExtMapper
                .deleteById(courseTemplateTeacherEntityExt.getId());
        Assert.assertSame(courseTemplateTeacherEntityExtMapper.getCount(),
                oldcount - 1);
    }
    
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
       
        CourseTemplateTeacherEntityExt courseTemplateTeacherQueryEntity = new CourseTemplateTeacherEntityExt();
        courseTemplateTeacherQueryEntity.setCourseTemplateId(1);
        List<CourseTemplateTeacherEntityExt> result = courseTemplateTeacherEntityExtMapper.list(courseTemplateTeacherQueryEntity, page);
        Assert.assertEquals(1, result.size());
        //Assert.assertEquals("_test_CourseTemplateTeachers_2_", result.get(0).getCreateTime());
    }
    @Test
    public void testQuery2() {
        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        courseTemplateTeacherEntityExt.setIdSet(idSet);
        List<CourseTemplateTeacherEntityExt> result = courseTemplateTeacherEntityExtMapper.list(courseTemplateTeacherEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        courseTemplateTeacherEntityExt.setCourseTemplateId(3);
       
        List<CourseTemplateTeacherEntityExt> result = courseTemplateTeacherEntityExtMapper.list(courseTemplateTeacherEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertSame(4, result.get(0).getTeacherId());
    }
    
    @Test
    public void testGet() {
        CourseTemplateTeacherEntityExt getbyid1 = courseTemplateTeacherEntityExtMapper
                .getById(2);
        CourseTemplateTeacherEntityExt getbyid2 = courseTemplateTeacherEntityExtMapper
                .getById(3);
        CourseTemplateTeacherEntityExt getbyid3 = courseTemplateTeacherEntityExtMapper
                .getById(4);
        String time = "2014-07-02 02:00:00";
        Assert.assertEquals(time,
                DateUtility.toSQLDateTime(getbyid1.getCreateTime()));
        String time1 = "2014-07-02 01:00:00";
        Assert.assertEquals(time1,
                DateUtility.toSQLDateTime(getbyid2.getCreateTime()));
        String time2 = "2014-07-15 15:03:13";
        Assert.assertEquals(time2,
                DateUtility.toSQLDateTime(getbyid3.getCreateTime()));

    }
    @Test
    public void testUpdate() {
        CourseTemplateTeacherEntityExt upDate = courseTemplateTeacherEntityExtMapper
                .getById(2);

        upDate.setCreateTime(time);
        courseTemplateTeacherEntityExtMapper.update(upDate);
        upDate = courseTemplateTeacherEntityExtMapper.getById(2);
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
