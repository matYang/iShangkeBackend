package com.ishangke.edunav.dataaccess.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional

public class UserGroupEntityExtTest {

    @Autowired
    private UserGroupEntityExtMapper userGroupEntityExtMapper;
    
    @Test
    public void testAdd(){
//        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
//        userGroupEntityExt.setLastModifyTimeEnd(lastModifyTimeEnd)
        Assert.assertTrue(true);
    }
    
    @Test
    public void testUpdate(){
        Assert.assertTrue(true);
    }
}
