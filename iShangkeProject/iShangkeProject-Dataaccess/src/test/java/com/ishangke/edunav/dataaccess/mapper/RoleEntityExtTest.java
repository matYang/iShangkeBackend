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
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class RoleEntityExtTest extends BaseTest {

    @Autowired
    private RoleEntityExtMapper roleEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    @Test
    public void testAdd() {
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setDeleted(0);
        roleEntityExt.setEnabled(1);
        int oldCount = roleEntityExtMapper.getCount();
        roleEntityExtMapper.add(roleEntityExt);
        Assert.assertSame(roleEntityExtMapper.getCount(), oldCount + 1);
    }

    @Test
    public void testDelete() {
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setDeleted(0);
        roleEntityExt.setEnabled(1);
        roleEntityExtMapper.add(roleEntityExt);
        int oldCount = roleEntityExtMapper.getCount();
        roleEntityExtMapper.deleteById(roleEntityExt.getId());
        Assert.assertSame(roleEntityExtMapper.getCount(), oldCount - 1);
    }

    /*
     * @Test public void testList(){ RoleEntityExt roleEntityExt = new
     * RoleEntityExt();
     * roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
     * roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
     * roleEntityExt.setDeleted(0); roleEntityExt.setEnabled(1);
     * roleEntityExtMapper.add(roleEntityExt);
     * 
     * List<RoleEntityExt> list = roleEntityExtMapper.list(roleEntityExt, null);
     * Assert.assertSame(list.size(),1);
     * 
     * int listSize = roleEntityExtMapper.getListCount(roleEntityExt);
     * Assert.assertSame(listSize,1);
     * 
     * PaginationEntity page = new PaginationEntity(); page.setOffset(0);
     * page.setSize(1);
     * 
     * list = roleEntityExtMapper.list(roleEntityExt, page);
     * Assert.assertSame(list.size(),1);
     * 
     * }
     * 
     * @Test public void testUpdate(){ RoleEntityExt roleEntityExt = new
     * RoleEntityExt();
     * roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
     * roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
     * roleEntityExt.setDeleted(0); roleEntityExt.setEnabled(1);
     * roleEntityExtMapper.add(roleEntityExt);
     * 
     * List<RoleEntityExt> list = roleEntityExtMapper.list(roleEntityExt, null);
     * String name = "李清"; list.get(0).setName(name);
     * roleEntityExtMapper.update(list.get(0));
     * 
     * list = roleEntityExtMapper.list(list.get(0), null);
     * if(list.get(0).getName().equals(name)){ //Passed; }else fail(); }
     */
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));

        RoleEntityExt RoleEntityExt = new RoleEntityExt();
        RoleEntityExt.setName("systemadmin");
        List<RoleEntityExt> result = roleEntityExtMapper.list(RoleEntityExt,
                page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("systemadmin", result.get(0).getName());
    }

    @Test
    public void testQuery2() {
        RoleEntityExt RoleEntityExt = new RoleEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        RoleEntityExt.setIdSet(idSet);
        List<RoleEntityExt> result = roleEntityExtMapper.list(RoleEntityExt,
                page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        int teacherCount = roleEntityExtMapper.getCountByUserId(2);
        Assert.assertSame(10, teacherCount);

        List<RoleEntityExt> result = roleEntityExtMapper.listRolesByUserId(2);
        Assert.assertEquals(10, result.size());
        Assert.assertEquals("admin", result.get(0).getName());
    }

    @Test
    public void testQuery4() {
        int teacherCount = roleEntityExtMapper.getCountByGroupId(2);
        Assert.assertSame(1, teacherCount);

        List<RoleEntityExt> result = roleEntityExtMapper.listRolesByGroupId(2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("admin", result.get(0).getName());
    }

    @Test
    public void testQuery5() {
        RoleEntityExt teacherCount = roleEntityExtMapper.getById(2);

        Assert.assertEquals("admin", teacherCount.getName());

    }

    @Test
    public void testGet() {
        RoleEntityExt getbyid1 = roleEntityExtMapper.getById(2);
        RoleEntityExt getbyid2 = roleEntityExtMapper.getById(3);
        RoleEntityExt getbyid3 = roleEntityExtMapper.getById(4);
        Assert.assertEquals("admin", getbyid1.getName());
        Assert.assertEquals("partneradmin", getbyid2.getName());
        Assert.assertEquals("user", getbyid3.getName());
    }

    @Test
    public void testUpdate() {
        RoleEntityExt upDate = roleEntityExtMapper.getById(2);
        upDate.setName("_test_name_爱上课");
        upDate.setLastModifyTime(time);
        roleEntityExtMapper.update(upDate);
        upDate = roleEntityExtMapper.getById(2);
        Assert.assertEquals("_test_name_爱上课", upDate.getName());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getLastModifyTime()));
    }
}
