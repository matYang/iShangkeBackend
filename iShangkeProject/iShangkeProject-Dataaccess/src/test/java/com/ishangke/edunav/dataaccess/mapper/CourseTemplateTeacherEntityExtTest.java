package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTemplateTeacherEntityExtTest extends BaseTest{
    @Autowired
    private CourseTemplateTeacherEntityExtMapper courseTemplateTeacherEntityExtMapper;

    @Test
    public void testAdd() {
        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
        courseTemplateTeacherEntityExt.setCreateTime(new Date());
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
        courseTemplateTeacherEntityExt.setCreateTime(new Date());
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
}
