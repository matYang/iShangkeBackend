package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTeacherEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTeacherEntityExtTest extends BaseTest{
    @Autowired
    private CourseTeacherEntityExtMapper courseTeacherEntityExtMapper;
    public  CourseTeacherEntityExtTest() {
        scriptAfterClass = "CourseTeacherEntityExtTestAfter.sql";
        scriptBeforeClass = "CourseTeacherEntityExtTestBefore.sql";
    }
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
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
       
        CourseTeacherEntityExt courseTeacherQueryEntity = new CourseTeacherEntityExt();
        courseTeacherQueryEntity.setCourseId(1);
        List<CourseTeacherEntityExt> result = courseTeacherEntityExtMapper.list(courseTeacherQueryEntity, page);
        Assert.assertEquals(4, result.size());
        //Assert.assertEquals("_test_CourseTemplateClassPhotos_2_", result.get(0).getCreateTime());
    }
}
