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
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CourseCommentEntityExtTest extends BaseTest{
    @Autowired
    private CourseCommentEntityExtMapper courseCommentEntityExtMapper;

    @Test
    public void testAdd() {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        courseCommentEntityExt.setCreateTime(new Date());
        courseCommentEntityExt.setLastModifyTime(new Date());
        courseCommentEntityExt.setEnabled(1);
        courseCommentEntityExt.setDeleted(0);
        courseCommentEntityExt.setUserId(1);
        courseCommentEntityExt.setCourseTemplateId(1);
     
        courseCommentEntityExtMapper.add(courseCommentEntityExt);
        int oldcount = courseCommentEntityExtMapper.getCount();
        courseCommentEntityExtMapper.add(courseCommentEntityExt);
        Assert.assertSame(courseCommentEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        courseCommentEntityExt.setCreateTime(new Date());
        courseCommentEntityExt.setLastModifyTime(new Date());
        courseCommentEntityExt.setEnabled(1);
        courseCommentEntityExt.setDeleted(0);
        courseCommentEntityExt.setUserId(1);
        courseCommentEntityExt.setCourseTemplateId(1);
        courseCommentEntityExtMapper.add(courseCommentEntityExt);
        int oldcount = courseCommentEntityExtMapper.getCount();
        courseCommentEntityExtMapper.deleteById(courseCommentEntityExt.getId());
        Assert.assertSame(courseCommentEntityExtMapper.getCount(), oldcount - 1);
    }


}
