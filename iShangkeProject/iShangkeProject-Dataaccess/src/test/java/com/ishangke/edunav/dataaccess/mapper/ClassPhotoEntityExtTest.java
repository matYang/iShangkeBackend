package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ClassPhotoEntityExtTest {
    @Autowired
    private ClassPhotoEntityExtMapper classPhotoEntityExtMapper;

    @Test
    public void testAdd() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(new Date());
        classPhotoEntityExt.setLastModifyTime(new Date());
        classPhotoEntityExt.setEnabled(1);
        classPhotoEntityExt.setDeleted(0);
        classPhotoEntityExt.setPartnerId(1);
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        int oldcount = classPhotoEntityExtMapper.getCount();
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        Assert.assertSame(classPhotoEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(new Date());
        classPhotoEntityExt.setLastModifyTime(new Date());
        classPhotoEntityExt.setEnabled(1);
        classPhotoEntityExt.setDeleted(0);
        classPhotoEntityExt.setPartnerId(1);
        classPhotoEntityExtMapper.add(classPhotoEntityExt);
        int oldcount = classPhotoEntityExtMapper.getCount();
        classPhotoEntityExtMapper.deleteById(classPhotoEntityExt.getId());
        Assert.assertSame(classPhotoEntityExtMapper.getCount(), oldcount - 1);
    }

}
