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
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class GroupEntityExtTest extends BaseTest {

    @Autowired
    public GroupEntityExtMapper groupEntityExtMapper;
    private Calendar time = Calendar.getInstance();
    @Test
    public void testAdd() {
        GroupEntityExt groupEntityExt = new GroupEntityExt();
        groupEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        groupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        groupEntityExt.setDeleted(0);
        groupEntityExt.setEnabled(1);
        groupEntityExt.setRoleId(1);
        groupEntityExt.setPartnerId(1);
        int oldCount = groupEntityExtMapper.getCount();
        groupEntityExtMapper.add(groupEntityExt);
        Assert.assertSame(groupEntityExtMapper.getCount(), oldCount + 1);
    }

    @Test
    public void testDeleted() {
        GroupEntityExt groupEntityExt = new GroupEntityExt();
        groupEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        groupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        groupEntityExt.setDeleted(0);
        groupEntityExt.setEnabled(1);
        groupEntityExt.setRoleId(1);
        groupEntityExt.setPartnerId(1);
        groupEntityExtMapper.add(groupEntityExt);
        int oldCount = groupEntityExtMapper.getCount();
        groupEntityExtMapper.deleteById(groupEntityExt.getId());
        Assert.assertSame(groupEntityExtMapper.getCount(), oldCount - 1);
    }

    // @Test
    // public void testList(){
    // GroupEntityExt groupEntityExt = new GroupEntityExt();
    // groupEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // groupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // groupEntityExt.setDeleted(0);
    // groupEntityExt.setEnabled(1);
    // groupEntityExt.setRoleId(1);
    // groupEntityExt.setPartnerId(1);
    // groupEntityExtMapper.add(groupEntityExt);
    //
    // List<GroupEntityExt> list = groupEntityExtMapper.list(groupEntityExt,
    // null);
    // Assert.assertSame(list.size(),1);
    //
    // int listSize = groupEntityExtMapper.getListCount(groupEntityExt);
    // Assert.assertSame(listSize,1);
    //
    // PaginationEntity page = new PaginationEntity();
    // page.setOffset(0);
    // page.setSize(1);
    //
    // list = groupEntityExtMapper.list(groupEntityExt, null);
    // Assert.assertSame(list.size(),1);
    //
    // listSize = groupEntityExtMapper.getListCount(groupEntityExt);
    // Assert.assertSame(listSize,1);
    // }
    //
    // @Test
    // public void testUpdate(){
    // GroupEntityExt groupEntityExt = new GroupEntityExt();
    // groupEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
    // groupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // groupEntityExt.setDeleted(0);
    // groupEntityExt.setEnabled(1);
    // groupEntityExt.setRoleId(1);
    // groupEntityExt.setPartnerId(1);
    // groupEntityExtMapper.add(groupEntityExt);
    //
    // List<GroupEntityExt> list = groupEntityExtMapper.list(groupEntityExt,
    // null);
    // String name = "李清";
    // list.get(0).setName(name);
    // groupEntityExtMapper.update(list.get(0));
    // list = groupEntityExtMapper.list(list.get(0), null);
    // if(list.get(0).getName().equals(name)){
    // //Passed;
    // }else fail();
    // }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));

        GroupEntityExt groupEntityExt = new GroupEntityExt();
        groupEntityExt.setName("管理员");
        List<GroupEntityExt> result = groupEntityExtMapper.list(groupEntityExt,
                page);
        Assert.assertEquals(8, result.size());
        Assert.assertEquals("东方管理员1", result.get(0).getName());
    }

    @Test
    public void testQuery2() {
        GroupEntityExt groupEntityExt = new GroupEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        groupEntityExt.setIdSet(idSet);
        List<GroupEntityExt> result = groupEntityExtMapper.list(groupEntityExt,
                page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        GroupEntityExt groupEntityExt = new GroupEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        groupEntityExt.setRoleId(2);
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));
        List<GroupEntityExt> result = groupEntityExtMapper.list(groupEntityExt,
                page);
        Assert.assertEquals(1, result.size());
        
        Assert.assertEquals("管理员", result.get(0).getName());
    }

    @Test
    public void testQuery4() {
        GroupEntityExt groupEntityExt = new GroupEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        groupEntityExt.setRoleId(2);
        groupEntityExt.setId(2);
        List<GroupEntityExt> result = groupEntityExtMapper.list(groupEntityExt,
                page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("管理员", result.get(0).getName());
    }

    public void testQuery5() {

        int teacherCount = groupEntityExtMapper.getCountByUserId(2);
        ;
        Assert.assertSame(1, teacherCount);

        List<GroupEntityExt> result = groupEntityExtMapper .listGroupsByUserId(5);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_name_1_爱上课", result.get(0).getName());
    }
    @Test
    public void testGet() {
        GroupEntityExt getbyid1 = groupEntityExtMapper
                .getById(2);
        GroupEntityExt getbyid2 = groupEntityExtMapper
                .getById(3);
        GroupEntityExt getbyid3 = groupEntityExtMapper
                .getById(4);
        Assert.assertEquals("管理员", getbyid1.getName());
        Assert.assertEquals("普通用户", getbyid2.getName());
        Assert.assertEquals("达内管理员1", getbyid3.getName());
    }
    @Test
    public void testUpdate() {
        GroupEntityExt upDate = groupEntityExtMapper
                .getById(2);
        upDate.setName("_test_name_爱上课");
        upDate.setCreateTime(time);
        groupEntityExtMapper.update(upDate);
        upDate = groupEntityExtMapper.getById(2);
        Assert.assertEquals("_test_name_爱上课",
               upDate.getName());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
