package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;
import java.util.List;

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
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

//before/after方法注入，aop
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, UserEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
//继承BaseTest
public class UserEntityExtTest extends BaseTest {
    @Autowired
    private UserEntityExtMapper userEntityExtMapper;

    //resource里面
    public UserEntityExtTest() {
        scriptAfterClass = "UserEntityExtTestAfter.sql";
        scriptBeforeClass = "UserEntityExtTestBefore.sql";
    }

    @Test
    public void testAdd() {
        UserEntityExt userEntityExt = new UserEntityExt();
        userEntityExt.setCreateTime(new Date());
        userEntityExt.setLastLoginTime(new Date());
        userEntityExt.setLastModifyTime(new Date());
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
        userEntityExt.setCreateTime(new Date());
        userEntityExt.setLastLoginTime(new Date());
        userEntityExt.setLastModifyTime(new Date());
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
        Assert.assertEquals(3, result.size());
        Assert.assertEquals("_test_user_2_", result.get(0).getName());
    }
}
