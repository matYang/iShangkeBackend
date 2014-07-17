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
import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTemplateTeacherEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTemplateTeacherEntityExtTest extends BaseTest{
    @Autowired
    private CourseTemplateTeacherEntityExtMapper courseTemplateTeacherEntityExtMapper;
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
        Assert.assertEquals(4, result.size());
        //Assert.assertEquals("_test_CourseTemplateTeachers_2_", result.get(0).getCreateTime());
    }
}
