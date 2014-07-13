package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CircleEntityExtTest {
    @Autowired
    private CircleEntityExtMapper circleEntityExtMapper;

    @Test
    public void testAdd() {
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(new Date());
        circleEntityExt.setLastModifyTime(new Date());
        circleEntityExt.setEnabled(1);
        circleEntityExt.setDeleted(0);
        
        circleEntityExtMapper.add(circleEntityExt);
        int oldcount = circleEntityExtMapper.getCount();
        circleEntityExtMapper.add(circleEntityExt);
        Assert.assertSame(circleEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(new Date());
        circleEntityExt.setLastModifyTime(new Date());
        circleEntityExt.setEnabled(1);
        circleEntityExt.setDeleted(0);
     
        circleEntityExtMapper.add(circleEntityExt);
        int oldcount = circleEntityExtMapper.getCount();
        circleEntityExtMapper.deleteById(circleEntityExt.getId());
        Assert.assertSame(circleEntityExtMapper.getCount(), oldcount - 1);
    }

}
