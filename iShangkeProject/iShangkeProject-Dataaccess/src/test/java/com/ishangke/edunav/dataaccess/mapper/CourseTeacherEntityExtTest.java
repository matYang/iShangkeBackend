package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTeacherEntityExtTest {
    @Autowired
    private CourseTeacherEntityExtMapper courseTeacherEntityExtMapper;

    @Test
    public void testAdd() {
        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
        courseTeacherEntityExt.setCreateTime(new Date());
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
        courseTeacherEntityExt.setCreateTime(new Date());
        courseTeacherEntityExt.setCourseId(1);
        courseTeacherEntityExt.setTeacherId(1);
        courseTeacherEntityExt.setDeleted(0);
        courseTeacherEntityExt.setCourseId(1);
        courseTeacherEntityExtMapper.add(courseTeacherEntityExt);
        int oldcount = courseTeacherEntityExtMapper.getCount();
        courseTeacherEntityExtMapper.deleteById(courseTeacherEntityExt.getId());
        Assert.assertSame(courseTeacherEntityExtMapper.getCount(), oldcount - 1);
    }

}
