package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.UserEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class UserEntityExtTest {
    @Autowired
    private UserEntityExtMapper userEntityExtMapper;

    @Test
    public void testAdd() {
        UserEntityExt userEntityExt = new UserEntityExt();
        userEntityExt.setCreateTime(new Date());
        userEntityExt.setLastLoginTime(new Date());
        userEntityExt.setLastModifyTime(new Date());
        userEntityExt.setDeleted(0);
        userEntityExt.setEnabled(1);
        userEntityExt.setName("ishangke李清");
        int oldcount = userEntityExtMapper.getCount();
        userEntityExtMapper.add(userEntityExt);
        Assert.assertSame(userEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        UserEntityExt userEntityExt = new UserEntityExt();
        userEntityExt.setCreateTime(new Date());
        userEntityExt.setLastLoginTime(new Date());
        userEntityExt.setLastModifyTime(new Date());
        userEntityExt.setDeleted(0);
        userEntityExt.setEnabled(1);
        userEntityExt.setName("ishangke");
        userEntityExtMapper.add(userEntityExt);
        int oldcount = userEntityExtMapper.getCount();
        userEntityExtMapper.deleteById(userEntityExt.getId());
        Assert.assertSame(userEntityExtMapper.getCount(), oldcount - 1);
    }

}
