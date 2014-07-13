package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

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
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;


@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CourseTemplateEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTemplateEntityExtTest extends BaseTest{
    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateEntityExtMapper;
    
    public CourseTemplateEntityExtTest() {
        scriptAfterClass = "CourseTemplateEntityExtTestAfter.sql";
        scriptBeforeClass = "CourseTemplateEntityExtTestBefore.sql";
    }

    @Test
    public void testAdd() {
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
        courseTemplateEntityExt.setCreateTime(new Date());
        courseTemplateEntityExt.setLastModifyTime(new Date());
        courseTemplateEntityExt.setEnabled(1);
        courseTemplateEntityExt.setDeleted(0);
        courseTemplateEntityExt.setAddressId(1);
        courseTemplateEntityExt.setCategoryId(1);
        courseTemplateEntityExt.setCircleId(1);
        courseTemplateEntityExt.setLocationId(1);
        courseTemplateEntityExt.setPartnerId(1);
        courseTemplateEntityExtMapper.add(courseTemplateEntityExt);
        int oldcount = courseTemplateEntityExtMapper.getCount();
        courseTemplateEntityExtMapper.add(courseTemplateEntityExt);
        Assert.assertSame(courseTemplateEntityExtMapper.getCount(),
                oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseTemplateEntityExt courseTemplateEntityExt = new CourseTemplateEntityExt();
        courseTemplateEntityExt.setCreateTime(new Date());
        courseTemplateEntityExt.setLastModifyTime(new Date());
        courseTemplateEntityExt.setEnabled(1);
        courseTemplateEntityExt.setDeleted(0);
        courseTemplateEntityExt.setAddressId(1);
        courseTemplateEntityExt.setCategoryId(1);
        courseTemplateEntityExt.setCircleId(1);
        courseTemplateEntityExt.setLocationId(1);
        courseTemplateEntityExt.setPartnerId(1);
        courseTemplateEntityExtMapper.add(courseTemplateEntityExt);
        int oldcount = courseTemplateEntityExtMapper.getCount();
        courseTemplateEntityExtMapper.deleteById(courseTemplateEntityExt
                .getId());
        Assert.assertSame(courseTemplateEntityExtMapper.getCount(),
                oldcount - 1);
    }

}
