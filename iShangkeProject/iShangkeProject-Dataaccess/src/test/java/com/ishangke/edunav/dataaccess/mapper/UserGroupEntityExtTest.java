package com.ishangke.edunav.dataaccess.mapper;

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
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class UserGroupEntityExtTest extends BaseTest {

    @Autowired
    private UserGroupEntityExtMapper userGroupEntityExtMapper;

    @Test
    public void testAdd() {
        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
        userGroupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        userGroupEntityExt.setDeleted(0);
        userGroupEntityExt.setUserId(1);
        userGroupEntityExt.setGroupId(1);
        int oldCount = userGroupEntityExtMapper.getCount();
        userGroupEntityExtMapper.add(userGroupEntityExt);
        Assert.assertSame(userGroupEntityExtMapper.getCount(), oldCount + 1);
    }

    @Test
    public void testDelete() {
        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
        userGroupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        userGroupEntityExt.setDeleted(0);
        userGroupEntityExt.setUserId(1);
        userGroupEntityExt.setGroupId(1);
        userGroupEntityExtMapper.add(userGroupEntityExt);
        int oldCount = userGroupEntityExtMapper.getCount();
        userGroupEntityExtMapper.deleteById(userGroupEntityExt.getId());
        Assert.assertSame(userGroupEntityExtMapper.getCount(), oldCount - 1);
    }

    // @Test
    // public void testList(){
    // UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
    // userGroupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // userGroupEntityExt.setDeleted(0);
    // userGroupEntityExt.setUserId(1);
    // userGroupEntityExt.setGroupId(1);
    // userGroupEntityExtMapper.add(userGroupEntityExt);
    //
    // List<UserGroupEntityExt> list =
    // userGroupEntityExtMapper.list(userGroupEntityExt, null);
    // Assert.assertSame(list.size(),1);
    //
    // int listSize = userGroupEntityExtMapper.getListCount(userGroupEntityExt);
    // Assert.assertSame(listSize,1);
    //
    // PaginationEntity page = new PaginationEntity();
    // page.setOffset(0);
    // page.setSize(1);
    //
    // list = userGroupEntityExtMapper.list(userGroupEntityExt, null);
    // Assert.assertSame(list.size(),1);
    //
    // listSize = userGroupEntityExtMapper.getListCount(userGroupEntityExt);
    // Assert.assertSame(listSize,1);
    // }
    // @Test
    // public void testUpdate(){
    // TODO update foreign key
    // UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
    // userGroupEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
    // userGroupEntityExt.setDeleted(0);
    // userGroupEntityExt.setUserId(1);
    // userGroupEntityExt.setGroupId(1);
    // userGroupEntityExtMapper.add(userGroupEntityExt);
    // userGroupEntityExt.setLastModifyTimeStart(new
    // Calendar(System.currentTimeMillis() - 10000));
    //
    // List<UserGroupEntityExt> list =
    // userGroupEntityExtMapper.list(userGroupEntityExt, null);
    // list.get(0).setGroupId(2);
    // userGroupEntityExtMapper.update(list.get(0));
    // list = userGroupEntityExtMapper.list(list.get(0), null);
    //
    // if(list.get(0).getGroupId() == 2){
    // //Passed;
    // }else fail();
    // }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
      
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));
        UserGroupEntityExt userGroupQueryEntity = new UserGroupEntityExt();
        userGroupQueryEntity.setUserId(3);
        List<UserGroupEntityExt> result = userGroupEntityExtMapper.list(
                userGroupQueryEntity, page);
        Assert.assertEquals(2, result.size());
        // Assert.assertEquals("_test_name_2_爱上课", result.get(0).getName());
    }
    @Test
    public void testQuery2() {
        UserGroupEntityExt UserGroupEntityExt = new UserGroupEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        UserGroupEntityExt.setIdSet(idSet);
        List<UserGroupEntityExt> result = userGroupEntityExtMapper.list(UserGroupEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        UserGroupEntityExt UserGroupEntityExt = new UserGroupEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        UserGroupEntityExt.setUserId(2);
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));
        List<UserGroupEntityExt> result = userGroupEntityExtMapper.list(UserGroupEntityExt, page);
        Assert.assertEquals(2, result.size());
        Assert.assertSame(4, result.get(0).getGroupId());
        Assert.assertSame(2, result.get(1).getGroupId());
    }
    
    @Test
    public void testQuery4() {
        UserGroupEntityExt UserGroupEntityExt = new UserGroupEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        UserGroupEntityExt.setUserId(2);
        UserGroupEntityExt.setGroupId(4);
        List<UserGroupEntityExt> result = userGroupEntityExtMapper.list(UserGroupEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertSame(4, result.get(0).getGroupId());
    }
}
