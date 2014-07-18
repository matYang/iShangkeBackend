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
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class GroupEntityExtTest extends BaseTest {

    @Autowired
    public GroupEntityExtMapper groupEntityExtMapper;

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
        groupEntityExt.setName("_test_");
        List<GroupEntityExt> result = groupEntityExtMapper.list(groupEntityExt,
                page);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_name_4_爱上课", result.get(0).getName());
    }
}
