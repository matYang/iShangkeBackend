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
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional

public class TeacherEntityExtTest extends BaseTest{

    @Autowired
    private TeacherEntityExtMapper teacherEntityExtMapper;
    
    @Test
    public void testAdd(){
        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
        teacherEntityExt.setCreateTime(new Date());
        teacherEntityExt.setLastModifyTime(new Date());
        teacherEntityExt.setDeleted(0);
        teacherEntityExt.setEnabled(1);
        teacherEntityExt.setPartnerId(1);
        teacherEntityExt.setPopularity(1);
        int oldCount = teacherEntityExtMapper.getCount();
        teacherEntityExtMapper.add(teacherEntityExt);
        Assert.assertSame(teacherEntityExtMapper.getCount(), oldCount + 1);
        
    }
}
