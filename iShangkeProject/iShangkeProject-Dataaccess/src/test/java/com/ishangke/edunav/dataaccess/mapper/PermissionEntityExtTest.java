package com.ishangke.edunav.dataaccess.mapper;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class PermissionEntityExtTest extends BaseTest{
    @Autowired
    private PermissionEntityExtMapper permissionEntityExtMapper;
    @Autowired
    private RolePermissionEntityExtMapper rolePermissionEntityExtMapper;
    @Autowired
    private RoleEntityExtMapper roleEntityExtMapper;
    
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

    @Test
    public void testList(){
        PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
        permissionEntityExt.setCreateTime(new Date());
        permissionEntityExt.setLastModifyTime(new Date());
        permissionEntityExt.setDeleted(0);
        permissionEntityExt.setEnabled(1);
        permissionEntityExt.setName("ishangke");
        permissionEntityExt.setPath("ishangke李清");
        permissionEntityExtMapper.add(permissionEntityExt);

//        permissionEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 100000000));
//        permissionEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 100000000));

        List<PermissionEntityExt> list = permissionEntityExtMapper.list(permissionEntityExt, null);
        Assert.assertSame(list.size(),1);

        int listSize = permissionEntityExtMapper.getListCount(permissionEntityExt);
        Assert.assertSame(listSize,1);

        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(1);
        
        list = permissionEntityExtMapper.list(permissionEntityExt, page);
        Assert.assertSame(list.size(),1);

        
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        roleEntityExt.setCreateTime(new Date());
        roleEntityExt.setLastModifyTime(new Date());
        roleEntityExt.setDeleted(0);
        roleEntityExt.setEnabled(1);
        roleEntityExtMapper.add(roleEntityExt);
        
        RolePermissionEntityExt rolePermissionEntityExt = new RolePermissionEntityExt();
        rolePermissionEntityExt.setLastModifyTime(new Date());
        rolePermissionEntityExt.setDeleted(0);
        rolePermissionEntityExt.setRoleId(roleEntityExt.getId());
        rolePermissionEntityExt.setPermissionId(permissionEntityExt.getId());
        rolePermissionEntityExtMapper.add(rolePermissionEntityExt);
        
        list = permissionEntityExtMapper.listPermissionByRoleId(roleEntityExt.getId());
        Assert.assertSame(list.size(),1);
        Assert.assertSame(list.get(0).getId(),permissionEntityExt.getId());
    }
    
    @Test
    public void testUpdate(){
        PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
        permissionEntityExt.setCreateTime(new Date());
        permissionEntityExt.setLastModifyTime(new Date());
        permissionEntityExt.setDeleted(0);
        permissionEntityExt.setEnabled(1);
        permissionEntityExt.setName("ishangke");
        permissionEntityExt.setPath("ishangke李清");
        permissionEntityExtMapper.add(permissionEntityExt);

//        permissionEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 100000000));
//        permissionEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 100000000));

        List<PermissionEntityExt> list = permissionEntityExtMapper.list(permissionEntityExt, null);
        String name = "李国庆";
        list.get(0).setName(name);
        permissionEntityExtMapper.update(list.get(0));
        list = permissionEntityExtMapper.list(list.get(0), null);
        if(list.get(0).getName().equals(name)){
            //Passed;
        }else fail();
    }

}
