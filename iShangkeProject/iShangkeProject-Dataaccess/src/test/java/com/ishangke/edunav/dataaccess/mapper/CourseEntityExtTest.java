package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;
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
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;


@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseEntityExtTest extends BaseTest{
    @Autowired
    private CourseEntityExtMapper courseEntityExtMapper;
    
    public CourseEntityExtTest() {
        scriptAfterClass = "CourseEntityExtTestAfter.sql";
        scriptBeforeClass = "CourseEntityExtTestBefore.sql";
    }

    @Test
    public void testAdd() {
        CourseEntityExt courseEntityExt = new CourseEntityExt();
        courseEntityExt.setCreateTime(new Date());
        courseEntityExt.setLastModifyTime(new Date());
        courseEntityExt.setEnabled(1);
        courseEntityExt.setDeleted(0);
        courseEntityExt.setAddressId(1);
        courseEntityExt.setCategoryId(1);
        courseEntityExt.setCircleId(1);
        courseEntityExt.setCourseTemplateId(1);
        courseEntityExt.setLocationId(1);
        courseEntityExt.setPartnerId(1);
        courseEntityExtMapper.add(courseEntityExt);
        int oldcount = courseEntityExtMapper.getCount();
        courseEntityExtMapper.add(courseEntityExt);
        Assert.assertSame(courseEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseEntityExt courseEntityExt = new CourseEntityExt();
        courseEntityExt.setCreateTime(new Date());
        courseEntityExt.setLastModifyTime(new Date());
        courseEntityExt.setEnabled(1);
        courseEntityExt.setDeleted(0);
        courseEntityExt.setAddressId(1);
        courseEntityExt.setCategoryId(1);
        courseEntityExt.setCircleId(1);
        courseEntityExt.setCourseTemplateId(1);
        courseEntityExt.setLocationId(1);
        courseEntityExt.setPartnerId(1);
        courseEntityExtMapper.add(courseEntityExt);
        int oldcount = courseEntityExtMapper.getCount();
        courseEntityExtMapper.deleteById(courseEntityExt.getId());
        Assert.assertSame(courseEntityExtMapper.getCount(), oldcount - 1);
    }
    

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("CUTOFF_DATE", DataaccessConstants.ORDER_ASC));
        
        CourseEntityExt courseEntityExt = new CourseEntityExt();
        courseEntityExt.setCourseName("_test_c_");

        List<CourseEntityExt> result = courseEntityExtMapper.list(courseEntityExt, page);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals("_test_c_爱上课英语课（上的都牛逼）", result.get(2).getCourseName());
    }


}
