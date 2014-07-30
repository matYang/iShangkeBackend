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
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;
import com.ishangke.edunav.dataaccess.model.SchoolEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class RolePermissionEntityExtTest extends BaseTest {

    @Autowired
    private RolePermissionEntityExtMapper rolePermissionEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    @Test
    public void testAdd() {
        RolePermissionEntityExt rolePermissionEntityExt = new RolePermissionEntityExt();
        rolePermissionEntityExt.setLastModifyTime(DateUtility
                .getCurTimeInstance());
        rolePermissionEntityExt.setDeleted(0);
        rolePermissionEntityExt.setRoleId(1);
        rolePermissionEntityExt.setPermissionId(1);
        int oldCount = rolePermissionEntityExtMapper.getCount();
        rolePermissionEntityExtMapper.add(rolePermissionEntityExt);
        Assert.assertEquals(rolePermissionEntityExtMapper.getCount(),
                oldCount + 1);
    }

    @Test
    public void testDelete() {
        RolePermissionEntityExt rolePermissionEntityExt = new RolePermissionEntityExt();
        rolePermissionEntityExt.setLastModifyTime(DateUtility
                .getCurTimeInstance());
        rolePermissionEntityExt.setDeleted(0);
        rolePermissionEntityExt.setRoleId(1);
        rolePermissionEntityExt.setPermissionId(1);
        rolePermissionEntityExtMapper.add(rolePermissionEntityExt);
        int oldCount = rolePermissionEntityExtMapper.getCount();
        rolePermissionEntityExtMapper.deleteById(rolePermissionEntityExt
                .getId());
        Assert.assertEquals(rolePermissionEntityExtMapper.getCount(),
                oldCount - 1);
    }

    // @Test
    // public void testList(){
    // RolePermissionEntityExt rolePermissionEntityExt = new
    // RolePermissionEntityExt();
    // rolePermissionEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // rolePermissionEntityExt.setDeleted(0);
    // rolePermissionEntityExt.setRoleId(1);
    // rolePermissionEntityExt.setPermissionId(1);
    // rolePermissionEntityExtMapper.add(rolePermissionEntityExt);
    //
    //
    // List<RolePermissionEntityExt> list =
    // rolePermissionEntityExtMapper.list(rolePermissionEntityExt, null);
    // Assert.assertSame(list.size(),1);
    //
    // int listSize =
    // rolePermissionEntityExtMapper.getListCount(rolePermissionEntityExt);
    // Assert.assertSame(listSize,1);
    //
    // PaginationEntity page = new PaginationEntity();
    // page.setOffset(0);
    // page.setSize(1);
    //
    // list = rolePermissionEntityExtMapper.list(rolePermissionEntityExt, page);
    // Assert.assertSame(list.size(),1);
    //
    //
    // }
    //
    // @Test
    // public void testUpdate(){
    // //TODO update foreign key
    // }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));

        RolePermissionEntityExt RolePermissionEntityExt = new RolePermissionEntityExt();
        RolePermissionEntityExt.setPermissionId(2);
        List<RolePermissionEntityExt> result = rolePermissionEntityExtMapper
                .list(RolePermissionEntityExt, page);
        Assert.assertEquals(3, result.size());
        // Assert.assertEquals("_test_name_1_爱上课", result.get(0).getName());
    }

    @Test
    public void testQuery2() {
        RolePermissionEntityExt RolePermissionEntityExt = new RolePermissionEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        RolePermissionEntityExt.setIdSet(idSet);
        List<RolePermissionEntityExt> result = rolePermissionEntityExtMapper
                .list(RolePermissionEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        RolePermissionEntityExt RolePermissionEntityExt = new RolePermissionEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        RolePermissionEntityExt.setRoleId(3);
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));
        List<RolePermissionEntityExt> result = rolePermissionEntityExtMapper
                .list(RolePermissionEntityExt, page);
        Assert.assertEquals(10, result.size());
//        Assert.assertSame(3, result.get(0).getPermissionId());
//        Assert.assertSame(5, result.get(1).getPermissionId());
    }

    @Test
    public void testQuery4() {
        RolePermissionEntityExt RolePermissionEntityExt = new RolePermissionEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        RolePermissionEntityExt.setRoleId(3);
        RolePermissionEntityExt.setPermissionId(5);
        List<RolePermissionEntityExt> result = rolePermissionEntityExtMapper
                .list(RolePermissionEntityExt, page);
        Assert.assertEquals(1, result.size());
//      Assert.assertEquals(282, result.get(0).getId());
    }

    
//    @Test
//    public void testUpdate() {
//        RolePermissionEntityExt upDate = rolePermissionEntityExtMapper
//                .getById(2);
//
//        upDate.setLastModifyTime(time);
//        rolePermissionEntityExtMapper.update(upDate);
//        upDate = rolePermissionEntityExtMapper.getById(2);
//
//        Assert.assertEquals(DateUtility.toSQLDateTime(time),
//                DateUtility.toSQLDateTime(upDate.getLastModifyTime()));
//    }
}
