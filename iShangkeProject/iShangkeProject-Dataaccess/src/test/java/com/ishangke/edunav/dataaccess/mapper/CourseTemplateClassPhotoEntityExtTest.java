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
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseTemplateClassPhotoEntityExtTest extends BaseTest{
    @Autowired
    private CourseTemplateClassPhotoEntityExtMapper courseTemplateClassPhotoEntityExtMapper;

    @Test
    public void testAdd() {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoEntityExt.setCreateTime(new Date());
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
        courseTemplateClassPhotoEntityExt.setCreateTime(new Date());
        courseTemplateClassPhotoEntityExt.setClassPhotoId(1);
        courseTemplateClassPhotoEntityExt.setDeleted(0);
        courseTemplateClassPhotoEntityExt.setCourseTemplateId(1);
        courseTemplateClassPhotoEntityExtMapper.add(courseTemplateClassPhotoEntityExt);
        int oldcount = courseTemplateClassPhotoEntityExtMapper.getCount();
        courseTemplateClassPhotoEntityExtMapper.deleteById(courseTemplateClassPhotoEntityExt.getId());
        Assert.assertSame(courseTemplateClassPhotoEntityExtMapper.getCount(), oldcount - 1);
    }
}
