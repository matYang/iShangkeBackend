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
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTemplateClassPhotoEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTemplateClassPhotoEntityExtTest extends BaseTest {
    @Autowired
    private CourseTemplateClassPhotoEntityExtMapper courseTemplateClassPhotoEntityExtMapper;
    private Calendar time = Calendar.getInstance();
    // public CourseTemplateClassPhotoEntityExtTest() {
    // scriptAfterClass = "CourseTemplateClassPhotoEntityExtTestAfter.sql";
    // scriptBeforeClass = "CourseTemplateClassPhotoEntityExtTestBefore.sql";
    // }
    @Test
    public void testAdd() {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility
                .getCurTimeInstance());
        courseTemplateClassPhotoEntityExt.setClassPhotoId(1);
        courseTemplateClassPhotoEntityExt.setDeleted(0);
        courseTemplateClassPhotoEntityExt.setCourseTemplateId(1);
        courseTemplateClassPhotoEntityExtMapper
                .add(courseTemplateClassPhotoEntityExt);
        int oldcount = courseTemplateClassPhotoEntityExtMapper.getCount();
        courseTemplateClassPhotoEntityExtMapper
                .add(courseTemplateClassPhotoEntityExt);
        Assert.assertSame(courseTemplateClassPhotoEntityExtMapper.getCount(),
                oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility
                .getCurTimeInstance());
        courseTemplateClassPhotoEntityExt.setClassPhotoId(1);
        courseTemplateClassPhotoEntityExt.setDeleted(0);
        courseTemplateClassPhotoEntityExt.setCourseTemplateId(1);
        courseTemplateClassPhotoEntityExtMapper
                .add(courseTemplateClassPhotoEntityExt);
        int oldcount = courseTemplateClassPhotoEntityExtMapper.getCount();
        courseTemplateClassPhotoEntityExtMapper
                .deleteById(courseTemplateClassPhotoEntityExt.getId());
        Assert.assertSame(courseTemplateClassPhotoEntityExtMapper.getCount(),
                oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));

        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoQueryEntity = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoQueryEntity.setClassPhotoId(1);
        List<CourseTemplateClassPhotoEntityExt> result = courseTemplateClassPhotoEntityExtMapper
                .list(courseTemplateClassPhotoQueryEntity, page);
        Assert.assertEquals(1, result.size());
        // Assert.assertEquals("_test_CourseTemplateClassPhotos_2_",
        // result.get(0).getCreateTime());
    }

    @Test
    public void testQuery2() {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        courseTemplateClassPhotoEntityExt.setIdSet(idSet);
        List<CourseTemplateClassPhotoEntityExt> result = courseTemplateClassPhotoEntityExtMapper
                .list(courseTemplateClassPhotoEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        courseTemplateClassPhotoEntityExt.setClassPhotoId(2);

        List<CourseTemplateClassPhotoEntityExt> result = courseTemplateClassPhotoEntityExtMapper
                .list(courseTemplateClassPhotoEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertSame(5, result.get(0).getCourseTemplateId());
    }

    @Test
    public void testGet() {
        CourseTemplateClassPhotoEntityExt getbyid1 = courseTemplateClassPhotoEntityExtMapper
                .getById(2);
        CourseTemplateClassPhotoEntityExt getbyid2 = courseTemplateClassPhotoEntityExtMapper
                .getById(3);
        CourseTemplateClassPhotoEntityExt getbyid3 = courseTemplateClassPhotoEntityExtMapper
                .getById(4);
        String time = "2014-07-15 15:08:14";
        Assert.assertEquals(time,
                DateUtility.toSQLDateTime(getbyid1.getCreateTime()));
        String time1 = "2014-07-15 15:08:38";
        Assert.assertEquals(time1,
                DateUtility.toSQLDateTime(getbyid2.getCreateTime()));
        String time2 = "2014-07-15 15:08:49";
        Assert.assertEquals(time2,
                DateUtility.toSQLDateTime(getbyid3.getCreateTime()));

    }
    @Test
    public void testUpdate() {
        CourseTemplateClassPhotoEntityExt  upDate = courseTemplateClassPhotoEntityExtMapper
                .getById(2);

        upDate.setCreateTime(time);
        courseTemplateClassPhotoEntityExtMapper.update(upDate);
        upDate = courseTemplateClassPhotoEntityExtMapper.getById(2);
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
