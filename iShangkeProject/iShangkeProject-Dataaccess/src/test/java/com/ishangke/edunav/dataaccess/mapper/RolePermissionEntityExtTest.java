package com.ishangke.edunav.dataaccess.mapper;

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
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional

public class RolePermissionEntityExtTest extends BaseTest{

    @Autowired
    private RolePermissionEntityExtMapper rolePermissionEntityExtMapper;

    @Test
    public void testAdd(){
        RolePermissionEntityExt rolePermissionEntityExt = new RolePermissionEntityExt();
        rolePermissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        rolePermissionEntityExt.setDeleted(0);
        rolePermissionEntityExt.setRoleId(1);
        rolePermissionEntityExt.setPermissionId(1);
        int oldCount = rolePermissionEntityExtMapper.getCount();
        rolePermissionEntityExtMapper.add(rolePermissionEntityExt);
        Assert.assertSame(rolePermissionEntityExtMapper.getCount(),oldCount + 1);
    }

    @Test
    public void testDelete(){
        RolePermissionEntityExt rolePermissionEntityExt = new RolePermissionEntityExt();
        rolePermissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        rolePermissionEntityExt.setDeleted(0);
        rolePermissionEntityExt.setRoleId(1);
        rolePermissionEntityExt.setPermissionId(1);        
        rolePermissionEntityExtMapper.add(rolePermissionEntityExt);
        int oldCount = rolePermissionEntityExtMapper.getCount();
        rolePermissionEntityExtMapper.deleteById(rolePermissionEntityExt.getId());
        Assert.assertSame(rolePermissionEntityExtMapper.getCount(),oldCount - 1);
    }

    @Test
    public void testList(){
        RolePermissionEntityExt rolePermissionEntityExt = new RolePermissionEntityExt();
        rolePermissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        rolePermissionEntityExt.setDeleted(0);
        rolePermissionEntityExt.setRoleId(1);
        rolePermissionEntityExt.setPermissionId(1);        
        rolePermissionEntityExtMapper.add(rolePermissionEntityExt);


        List<RolePermissionEntityExt> list = rolePermissionEntityExtMapper.list(rolePermissionEntityExt, null);
        Assert.assertSame(list.size(),1);

        int listSize = rolePermissionEntityExtMapper.getListCount(rolePermissionEntityExt);
        Assert.assertSame(listSize,1);

        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(1);
        
        list = rolePermissionEntityExtMapper.list(rolePermissionEntityExt, page);
        Assert.assertSame(list.size(),1);


    }
    
    @Test
    public void testUpdate(){
        //TODO update foreign key
    }
}
