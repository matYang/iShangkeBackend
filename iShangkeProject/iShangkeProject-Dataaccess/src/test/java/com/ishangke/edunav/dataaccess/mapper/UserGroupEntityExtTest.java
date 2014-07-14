package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional

public class UserGroupEntityExtTest extends BaseTest{

    @Autowired
    private UserGroupEntityExtMapper userGroupEntityExtMapper;
    
    @Test
    public void testAdd(){
        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
        userGroupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        userGroupEntityExt.setDeleted(0);
        userGroupEntityExt.setUserId(1);
        userGroupEntityExt.setGroupId(1);
        int oldCount = userGroupEntityExtMapper.getCount();
        userGroupEntityExtMapper.add(userGroupEntityExt);
        Assert.assertSame(userGroupEntityExtMapper.getCount(),oldCount + 1);
    }
    
    @Test
    public void testDelete(){
        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
        userGroupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        userGroupEntityExt.setDeleted(0);
        userGroupEntityExt.setUserId(1);
        userGroupEntityExt.setGroupId(1);      
        userGroupEntityExtMapper.add(userGroupEntityExt);
        int oldCount = userGroupEntityExtMapper.getCount();
        userGroupEntityExtMapper.deleteById(userGroupEntityExt.getId());
        Assert.assertSame(userGroupEntityExtMapper.getCount(),oldCount - 1);
    }
    
    @Test
    public void testList(){
        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
        userGroupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        userGroupEntityExt.setDeleted(0);
        userGroupEntityExt.setUserId(1);
        userGroupEntityExt.setGroupId(1);      
        userGroupEntityExtMapper.add(userGroupEntityExt);
        
        List<UserGroupEntityExt> list = userGroupEntityExtMapper.list(userGroupEntityExt, null);
        Assert.assertSame(list.size(),1);
        
        int listSize = userGroupEntityExtMapper.getListCount(userGroupEntityExt);
        Assert.assertSame(listSize,1);
        
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(1);
        
        list = userGroupEntityExtMapper.list(userGroupEntityExt, null);
        Assert.assertSame(list.size(),1);
        
        listSize = userGroupEntityExtMapper.getListCount(userGroupEntityExt);
        Assert.assertSame(listSize,1);
    }
    @Test
    public void testUpdate(){
// TODO   update foreign key
//        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
//        userGroupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
//        userGroupEntityExt.setDeleted(0);
//        userGroupEntityExt.setUserId(1);
//        userGroupEntityExt.setGroupId(1);      
//        userGroupEntityExtMapper.add(userGroupEntityExt);
//        userGroupEntityExt.setLastModifyTimeStart(new Calendar(System.currentTimeMillis() - 10000));
//        
//        List<UserGroupEntityExt> list = userGroupEntityExtMapper.list(userGroupEntityExt, null);
//        list.get(0).setGroupId(2);
//        userGroupEntityExtMapper.update(list.get(0));
//        list = userGroupEntityExtMapper.list(list.get(0), null);
//        
//        if(list.get(0).getGroupId() == 2){
//            //Passed;
//        }else fail();
    }
}
