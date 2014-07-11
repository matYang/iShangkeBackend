package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class PermissionEntityExtTest {
    @Autowired
    private PermissionEntityExtMapper permissionEntityExtMapper;

    @Test
    public void testAdd() {
        PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
        permissionEntityExt.setCreateTime(new Date());
        permissionEntityExt.setLastModifyTime(new Date());
        permissionEntityExt.setDeleted(0);
        permissionEntityExt.setEnabled(1);
        permissionEntityExt.setName("ishangke李清");
        permissionEntityExt.setPath("ishangke");
        int oldcount = permissionEntityExtMapper.getCount();
        permissionEntityExtMapper.add(permissionEntityExt);
        Assert.assertSame(permissionEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
        permissionEntityExt.setCreateTime(new Date());
        permissionEntityExt.setLastModifyTime(new Date());
        permissionEntityExt.setDeleted(0);
        permissionEntityExt.setEnabled(1);
        permissionEntityExt.setName("ishangke");
        permissionEntityExt.setPath("ishangke李清");
        permissionEntityExtMapper.add(permissionEntityExt);
        int oldcount = permissionEntityExtMapper.getCount();
        permissionEntityExtMapper.deleteById(permissionEntityExt.getId());
        Assert.assertSame(permissionEntityExtMapper.getCount(), oldcount - 1);
    }
   
    

}
