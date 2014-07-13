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
import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseClassPhotoEntityExtTest extends BaseTest{
    @Autowired
    private CourseClassPhotoEntityExtMapper CourseClassPhotoEntityExtMapper;

    @Test
    public void testAdd() {
        CourseClassPhotoEntityExt CourseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        CourseClassPhotoEntityExt.setCreateTime(new Date());
        CourseClassPhotoEntityExt.setDeleted(0);
        CourseClassPhotoEntityExt.setClassPhotoId(1);
        CourseClassPhotoEntityExt.setCourseId(1);
        CourseClassPhotoEntityExtMapper.add(CourseClassPhotoEntityExt);
        int oldcount = CourseClassPhotoEntityExtMapper.getCount();
        CourseClassPhotoEntityExtMapper.add(CourseClassPhotoEntityExt);
        Assert.assertSame(CourseClassPhotoEntityExtMapper.getCount(),
                oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseClassPhotoEntityExt CourseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        CourseClassPhotoEntityExt.setCreateTime(new Date());
        CourseClassPhotoEntityExt.setDeleted(0);
        CourseClassPhotoEntityExt.setClassPhotoId(1);
        CourseClassPhotoEntityExt.setCourseId(1);
        CourseClassPhotoEntityExtMapper.add(CourseClassPhotoEntityExt);
        int oldcount = CourseClassPhotoEntityExtMapper.getCount();
        CourseClassPhotoEntityExtMapper.deleteById(CourseClassPhotoEntityExt
                .getId());
        Assert.assertSame(CourseClassPhotoEntityExtMapper.getCount(),
                oldcount - 1);
    }

}
