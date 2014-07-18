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
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class RoleEntityExtTest extends BaseTest{

    @Autowired
    private RoleEntityExtMapper roleEntityExtMapper;

    @Test
    public void testAdd(){
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setDeleted(0);
        roleEntityExt.setEnabled(1);
        int oldCount = roleEntityExtMapper.getCount();
        roleEntityExtMapper.add(roleEntityExt);
        Assert.assertSame(roleEntityExtMapper.getCount(),oldCount + 1);
    }

    @Test
    public void testDelete(){
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setDeleted(0);
        roleEntityExt.setEnabled(1);       
        roleEntityExtMapper.add(roleEntityExt);
        int oldCount = roleEntityExtMapper.getCount();
        roleEntityExtMapper.deleteById(roleEntityExt.getId());
        Assert.assertSame(roleEntityExtMapper.getCount(),oldCount - 1);
    }

   /* @Test
    public void testList(){
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setDeleted(0);
        roleEntityExt.setEnabled(1);       
        roleEntityExtMapper.add(roleEntityExt);

        List<RoleEntityExt> list = roleEntityExtMapper.list(roleEntityExt, null);
        Assert.assertSame(list.size(),1);

        int listSize = roleEntityExtMapper.getListCount(roleEntityExt);
        Assert.assertSame(listSize,1);

        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(1);
        
        list = roleEntityExtMapper.list(roleEntityExt, page);
        Assert.assertSame(list.size(),1);

    }
    
    @Test
    public void testUpdate(){
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        roleEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        roleEntityExt.setDeleted(0);
        roleEntityExt.setEnabled(1);       
        roleEntityExtMapper.add(roleEntityExt);

        List<RoleEntityExt> list = roleEntityExtMapper.list(roleEntityExt, null);
        String name = "李清";
        list.get(0).setName(name);
        roleEntityExtMapper.update(list.get(0));
        
        list = roleEntityExtMapper.list(list.get(0), null);
        if(list.get(0).getName().equals(name)){
            //Passed;
        }else fail();
    }*/
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));
       
        RoleEntityExt RoleEntityExt = new RoleEntityExt();
        RoleEntityExt.setName("_test_");
        List<RoleEntityExt> result = roleEntityExtMapper.list(
                RoleEntityExt, page);
        Assert.assertEquals(4, result.size());
         Assert.assertEquals("_test_name_1_爱上课", result.get(0).getName());
    }

}
