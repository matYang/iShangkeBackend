package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class PermissionEntityExtTest extends BaseTest {
    @Autowired
    private PermissionEntityExtMapper permissionEntityExtMapper;
    @Autowired
    private RolePermissionEntityExtMapper rolePermissionEntityExtMapper;
    @Autowired
    private RoleEntityExtMapper roleEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    @Test
    public void testAdd() {
        PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
        permissionEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        permissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        permissionEntityExt.setDeleted(0);
        permissionEntityExt.setEnabled(1);
        permissionEntityExt.setName("ishangke李清");
        permissionEntityExt.setPath("ishangke");
        int oldcount = permissionEntityExtMapper.getCount();
        permissionEntityExtMapper.add(permissionEntityExt);
      Assert.assertEquals(permissionEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
        permissionEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        permissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        permissionEntityExt.setDeleted(0);
        permissionEntityExt.setEnabled(1);
        permissionEntityExt.setName("ishangke");
        permissionEntityExt.setPath("ishangke李清");
        permissionEntityExtMapper.add(permissionEntityExt);
        int oldcount = permissionEntityExtMapper.getCount();
        permissionEntityExtMapper.deleteById(permissionEntityExt.getId());
        Assert.assertEquals(permissionEntityExtMapper.getCount(), oldcount - 1);
    }

    // @Test
    // public void testList(){
    // PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
    // permissionEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // permissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // permissionEntityExt.setDeleted(0);
    // permissionEntityExt.setEnabled(1);
    // permissionEntityExt.setName("ishangke");
    // permissionEntityExt.setPath("ishangke李清");
    // permissionEntityExtMapper.add(permissionEntityExt);

    // permissionEntityExt.setCreateTimeStart(new
    // Calendar(System.currentTimeMillis() - 100000000));
    // permissionEntityExt.setLastModifyTimeStart(new
    // Calendar(System.currentTimeMillis() - 100000000));

    // List<PermissionEntityExt> list =
    // permissionEntityExtMapper.list(permissionEntityExt, null);
    // Assert.assertSame(list.size(),1);

    // int listSize =
    // permissionEntityExtMapper.getListCount(permissionEntityExt);
    // Assert.assertSame(listSize,1);
    //
    // PaginationEntity page = new PaginationEntity();
    // page.setOffset(0);
    // page.setSize(1);
    //
    // list = permissionEntityExtMapper.list(permissionEntityExt, page);
    // Assert.assertSame(list.size(),1);
    //
    //
    // RoleEntityExt roleEntityExt = new RoleEntityExt();
    // roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // roleEntityExt.setDeleted(0);
    // roleEntityExt.setEnabled(1);
    // roleEntityExtMapper.add(roleEntityExt);
    //
    // RolePermissionEntityExt rolePermissionEntityExt = new
    // RolePermissionEntityExt();
    // rolePermissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // rolePermissionEntityExt.setDeleted(0);
    // rolePermissionEntityExt.setRoleId(roleEntityExt.getId());
    // rolePermissionEntityExt.setPermissionId(permissionEntityExt.getId());
    // rolePermissionEntityExtMapper.add(rolePermissionEntityExt);
    //
    // list =
    // permissionEntityExtMapper.listPermissionByRoleId(roleEntityExt.getId());
    // Assert.assertSame(list.size(),1);
    // Assert.assertSame(list.get(0).getId(),permissionEntityExt.getId());
    // }

    // @Test
    // public void testUpdate(){
    // PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
    // permissionEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // permissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // permissionEntityExt.setDeleted(0);
    // permissionEntityExt.setEnabled(1);
    // permissionEntityExt.setName("ishangke");
    // permissionEntityExt.setPath("ishangke李清");
    // permissionEntityExtMapper.add(permissionEntityExt);

    // permissionEntityExt.setCreateTimeStart(new
    // Calendar(System.currentTimeMillis() - 100000000));
    // permissionEntityExt.setLastModifyTimeStart(new
    // Calendar(System.currentTimeMillis() - 100000000));

    // List<PermissionEntityExt> list =
    // permissionEntityExtMapper.list(permissionEntityExt, null);
    // String name = "李国庆";
    // list.get(0).setName(name);
    // permissionEntityExtMapper.update(list.get(0));
    // list = permissionEntityExtMapper.list(list.get(0), null);
    // if(list.get(0).getName().equals(name)){
    // //Passed;
    // }else fail();
    // }
//    @Test
//    public void testQuery() {
//        PaginationEntity page = new PaginationEntity();
//        page.setOffset(0);
//        page.setSize(10);
//        // 排序，先按照第一个排序，再按照第二个排序，依次排列
//        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
//                DataaccessConstants.ORDER_DESC));
//
//        PermissionEntityExt permissionEntityExt = new PermissionEntityExt();
//        permissionEntityExt.setName("Login");
//        List<PermissionEntityExt> result = permissionEntityExtMapper.list(
//                permissionEntityExt, page);
//        Assert.assertEquals(3, result.size());
//        Assert.assertEquals("Login_N", result.get(0).getName());
//    }

//    @Test
//    public void testQuery2() {
//        PermissionEntityExt PermissionEntityExt = new PermissionEntityExt();
//        PaginationEntity page = new PaginationEntity();
//        page.setOffset(0);
//        page.setSize(10);
//        Set<Integer> idSet = new HashSet();
//        idSet.add(1);
//        idSet.add(2);
//        idSet.add(3);
//        PermissionEntityExt.setIdSet(idSet);
//        List<PermissionEntityExt> result = permissionEntityExtMapper.list(
//                PermissionEntityExt, page);
//        Assert.assertEquals(3, result.size());
//    }

//    @Test
//    public void testQuery3() {
//        int teacherCount = permissionEntityExtMapper.getCountByRoleId(3);
//        Assert.assertSame(38, teacherCount);
//
//        List<PermissionEntityExt> result = permissionEntityExtMapper
//                .listPermissionByRoleId(2);
//        Assert.assertEquals(140, result.size());
//        Assert.assertEquals("POST/api/v2/user/login/phone", result.get(0).getPath());
//        Assert.assertEquals("POST/api/v2/user/login/phone", result.get(1).getPath());
//    }

//    @Test
//    public void testQuery4() {
//        int teacherCount = permissionEntityExtMapper.getCountByUserId(2);
//        Assert.assertEquals(140, teacherCount);
//
//        List<PermissionEntityExt> result = permissionEntityExtMapper
//                .listPermissionsByUserId(2);
//        Assert.assertEquals(140, result.size());
//        Assert.assertEquals("_test_name_1_爱上课", result.get(0).getName());
//        Assert.assertEquals("_test_name_1_爱上课", result.get(1).getName());
     
//    }

//    @Test
//    public void testQuery5() {
//        int teacherCount = permissionEntityExtMapper.getCountByGroupId(2);
//        Assert.assertEquals(140, teacherCount);
//
//        List<PermissionEntityExt> result = permissionEntityExtMapper
//                .listPermissionsByGroupId(2);
//        Assert.assertEquals(140, result.size());
//        Assert.assertEquals("Login_N", result.get(0).getName());
//    }
//
//    @Test
//    public void testQuery6() {
//        PermissionEntityExt PermissionCount = permissionEntityExtMapper
//                .getById(2);
//
//        Assert.assertEquals("Login_P", PermissionCount.getName());
//
//    }

//    @Test
//    public void testGet() {
//        PermissionEntityExt getbyid1 = permissionEntityExtMapper.getById(2);
//        PermissionEntityExt getbyid2 = permissionEntityExtMapper.getById(3);
//        PermissionEntityExt getbyid3 = permissionEntityExtMapper.getById(4);
//        Assert.assertEquals("Login_P", getbyid1.getName());
//        Assert.assertEquals("Login_A", getbyid2.getName());
//        Assert.assertEquals("Logout_N", getbyid3.getName());
//    }
//
//    @Test
//    public void testUpdate() {
//        PermissionEntityExt upDate = permissionEntityExtMapper.getById(2);
//        upDate.setName("_test_name_爱上课");
//        upDate.setCreateTime(time);
//        permissionEntityExtMapper.update(upDate);
//        upDate = permissionEntityExtMapper.getById(2);
//        Assert.assertEquals("_test_name_爱上课", upDate.getName());
//        Assert.assertEquals(DateUtility.toSQLDateTime(time),
//                DateUtility.toSQLDateTime(upDate.getCreateTime()));
//    }
}
