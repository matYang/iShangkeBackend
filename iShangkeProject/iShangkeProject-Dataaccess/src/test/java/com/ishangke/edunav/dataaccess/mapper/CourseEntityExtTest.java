package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseEntityExtTest {
    @Autowired
    private CourseEntityExtMapper courseEntityExtMapper;

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


}
