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
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, UserEntityExtTest.class })
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class UserEntityExtTest extends BaseTest {
    @Autowired
    private UserEntityExtMapper userEntityExtMapper;
    private Calendar time = Calendar.getInstance();
    //resource里面
//    public UserEntityExtTest() {
//        scriptAfterClass = "UserEntityExtTestAfter.sql";
//        scriptBeforeClass = "UserEntityExtTestBefore.sql";
//    }

    @Test
    public void testAdd() {
        UserEntityExt userEntityExt = new UserEntityExt();
        userEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        userEntityExt.setLastLoginTime(DateUtility.getCurTimeInstance());
        userEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        userEntityExt.setDeleted(0);
        userEntityExt.setEnabled(1);
        userEntityExt.setName("ishangke李清");
        int oldcount = userEntityExtMapper.getCount();
        userEntityExtMapper.add(userEntityExt);
        Assert.assertSame(userEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        UserEntityExt userEntityExt = new UserEntityExt();
        userEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        userEntityExt.setLastLoginTime(DateUtility.getCurTimeInstance());
        userEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        userEntityExt.setDeleted(0);
        userEntityExt.setEnabled(1);
        userEntityExt.setName("ishangke");
        userEntityExtMapper.add(userEntityExt);
        int oldcount = userEntityExtMapper.getCount();
        userEntityExtMapper.deleteById(userEntityExt.getId());
        Assert.assertSame(userEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
        UserEntityExt userQueryEntity = new UserEntityExt();
        userQueryEntity.setName("_test_");
        List<UserEntityExt> result = userEntityExtMapper.list(userQueryEntity, page);
        Assert.assertEquals(0, result.size());
        //Assert.assertEquals("_test_name_2_爱上课", result.get(0).getName());
    }
    @Test
    public void testQuery2() {
        UserEntityExt UserEntityExt = new UserEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        UserEntityExt.setIdSet(idSet);
        List<UserEntityExt> result = userEntityExtMapper.list(UserEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
//    @Test
//    public void testGet() {
//        UserEntityExt getbyid0 = userEntityExtMapper
//                .getById(1);
//        UserEntityExt getbyid1 = userEntityExtMapper
//                .getById(2);
//        UserEntityExt getbyid2 = userEntityExtMapper
//                .getById(3);
//        UserEntityExt getbyid3 = userEntityExtMapper
//                .getById(4);
//        Assert.assertEquals("李清", getbyid0.getName());
//        Assert.assertEquals("陈睿", getbyid1.getName());
//        Assert.assertEquals("mat", getbyid2.getName());
//        Assert.assertEquals("harry", getbyid3.getName());
//    }
    @Test
    public void testUpdate() {
        UserEntityExt upDate = userEntityExtMapper
                .getById(2);
        upDate.setName("_test_name_爱上课");;
        upDate.setLastModifyTime(time);
        userEntityExtMapper.update(upDate);
        upDate = userEntityExtMapper.getById(2);
        Assert.assertEquals("_test_name_爱上课",
               upDate.getName());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getLastModifyTime()));
    }
    
    @Test
    public void testGetById() {
        UserEntityExt user = userEntityExtMapper.getById(1);
        System.out.println(user.getCouponTotal());
    }
    
    @Test 
    public void testGetByPartnerIdAndRoleId() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        List<UserEntityExt> r = userEntityExtMapper.listByPartnerIdAndRoleId(5, 3, page);
        System.out.println(r.size());
        System.out.println("ooxx");
    }
}
