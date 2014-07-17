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
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTemplateClassPhotoEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTemplateClassPhotoEntityExtTest extends BaseTest{
    @Autowired
    private CourseTemplateClassPhotoEntityExtMapper courseTemplateClassPhotoEntityExtMapper;
    
//    public CourseTemplateClassPhotoEntityExtTest() {
//        scriptAfterClass = "CourseTemplateClassPhotoEntityExtTestAfter.sql";
//        scriptBeforeClass = "CourseTemplateClassPhotoEntityExtTestBefore.sql";
//    }
    @Test
    public void testAdd() {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTemplateClassPhotoEntityExt.setClassPhotoId(1);
        courseTemplateClassPhotoEntityExt.setDeleted(0);
        courseTemplateClassPhotoEntityExt.setCourseTemplateId(1);
        courseTemplateClassPhotoEntityExtMapper.add(courseTemplateClassPhotoEntityExt);
        int oldcount = courseTemplateClassPhotoEntityExtMapper.getCount();
        courseTemplateClassPhotoEntityExtMapper.add(courseTemplateClassPhotoEntityExt);
        Assert.assertSame(courseTemplateClassPhotoEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        courseTemplateClassPhotoEntityExt.setClassPhotoId(1);
        courseTemplateClassPhotoEntityExt.setDeleted(0);
        courseTemplateClassPhotoEntityExt.setCourseTemplateId(1);
        courseTemplateClassPhotoEntityExtMapper.add(courseTemplateClassPhotoEntityExt);
        int oldcount = courseTemplateClassPhotoEntityExtMapper.getCount();
        courseTemplateClassPhotoEntityExtMapper.deleteById(courseTemplateClassPhotoEntityExt.getId());
        Assert.assertSame(courseTemplateClassPhotoEntityExtMapper.getCount(), oldcount - 1);
    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
       
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoQueryEntity = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoQueryEntity.setClassPhotoId(1);
        List<CourseTemplateClassPhotoEntityExt> result = courseTemplateClassPhotoEntityExtMapper.list(courseTemplateClassPhotoQueryEntity, page);
        Assert.assertEquals(4, result.size());
        //Assert.assertEquals("_test_CourseTemplateClassPhotos_2_", result.get(0).getCreateTime());
    }
}
