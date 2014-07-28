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
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTeacherEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTeacherEntityExtTest extends BaseTest {
    @Autowired
    private CourseTeacherEntityExtMapper courseTeacherEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    // public CourseTeacherEntityExtTest() {
    // scriptAfterClass = "CourseTeacherEntityExtTestAfter.sql";
    // scriptBeforeClass = "CourseTeacherEntityExtTestBefore.sql";
    // }
    @Test
    public void testAdd() {
        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
        courseTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTeacherEntityExt.setCourseId(1);
        courseTeacherEntityExt.setTeacherId(1);
        courseTeacherEntityExt.setDeleted(0);
        courseTeacherEntityExt.setCourseId(1);
        courseTeacherEntityExtMapper.add(courseTeacherEntityExt);
        int oldcount = courseTeacherEntityExtMapper.getCount();
        courseTeacherEntityExtMapper.add(courseTeacherEntityExt);
        Assert.assertSame(courseTeacherEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
        courseTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTeacherEntityExt.setCourseId(1);
        courseTeacherEntityExt.setTeacherId(1);
        courseTeacherEntityExt.setDeleted(0);
        courseTeacherEntityExt.setCourseId(1);
        courseTeacherEntityExtMapper.add(courseTeacherEntityExt);
        int oldcount = courseTeacherEntityExtMapper.getCount();
        courseTeacherEntityExtMapper.deleteById(courseTeacherEntityExt.getId());
        Assert.assertSame(courseTeacherEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));

        CourseTeacherEntityExt courseTeacherQueryEntity = new CourseTeacherEntityExt();
        courseTeacherQueryEntity.setCourseId(1);
        List<CourseTeacherEntityExt> result = courseTeacherEntityExtMapper
                .list(courseTeacherQueryEntity, page);
        Assert.assertEquals(1, result.size());
        // Assert.assertEquals("_test_CourseTemplateClassPhotos_2_",
        // result.get(0).getCreateTime());
    }

    @Test
    public void testQuery2() {
        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        courseTeacherEntityExt.setIdSet(idSet);
        List<CourseTeacherEntityExt> result = courseTeacherEntityExtMapper
                .list(courseTeacherEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        courseTeacherEntityExt.setCourseId(5);

        List<CourseTeacherEntityExt> result = courseTeacherEntityExtMapper
                .list(courseTeacherEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertSame(2, result.get(0).getTeacherId());

    }

    @Test
    public void testGet() {
        CourseTeacherEntityExt getbyid1 = courseTeacherEntityExtMapper
                .getById(2);
        CourseTeacherEntityExt getbyid2 = courseTeacherEntityExtMapper
                .getById(3);
        CourseTeacherEntityExt getbyid3 = courseTeacherEntityExtMapper
                .getById(4);
        String time = "2014-07-15 14:55:32";
        Assert.assertEquals(time,
                DateUtility.toSQLDateTime(getbyid1.getCreateTime()));
        String time1 = "2014-07-15 14:55:47";
        Assert.assertEquals(time1,
                DateUtility.toSQLDateTime(getbyid2.getCreateTime()));
        String time2 = "2014-07-15 14:55:59";
        Assert.assertEquals(time2,
                DateUtility.toSQLDateTime(getbyid3.getCreateTime()));

    }

    @Test
    public void testUpdate() {
        CourseTeacherEntityExt upDate = courseTeacherEntityExtMapper.getById(2);

        upDate.setCreateTime(time);
        courseTeacherEntityExtMapper.update(upDate);

        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
