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
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, PermissionEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class PermissionEntityExtTest extends BaseTest{
    @Autowired
    private PermissionEntityExtMapper permissionEntityExtMapper;
    //resource里面
    public PermissionEntityExtTest() {
        scriptAfterClass = "PermissionEntityExtTestAfter.sql";
        scriptBeforeClass = "PermissionEntityExtTestBefore.sql";
    }

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
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
        PermissionEntityExt permissionQueryEntity = new PermissionEntityExt();
        permissionQueryEntity.setName("_test_");
        List<PermissionEntityExt> result = permissionEntityExtMapper.list(permissionQueryEntity, page);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals("_test_permissions_2_", result.get(0).getName());
    }

}
