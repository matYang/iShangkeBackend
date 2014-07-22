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
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;

//before/after方法注入，aop
//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, ContactEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
//继承BaseTest
public class ContactEntityExtTest extends BaseTest{
    @Autowired
    private ContactEntityExtMapper contactEntityExtMapper;

    //resource里面
//    public ContactEntityExtTest() {
//        scriptAfterClass = "ContactEntityExtTestAfter.sql";
//        scriptBeforeClass = "ContactEntityExtTestBefore.sql";
//    }

    @Test
    public void testAdd() {
        ContactEntityExt contactEntityExt = new ContactEntityExt();
        contactEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        contactEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        contactEntityExt.setDeleted(0);
        contactEntityExt.setEnabled(1);
        contactEntityExt.setUserId(1);
        contactEntityExt.setName("清哥");
        contactEntityExt.setPhone("1568784428");
        contactEntityExt.setEmail("zuoqinglong@youbaihu.com");

        int oldcount = contactEntityExtMapper.getCount();
        contactEntityExtMapper.add(contactEntityExt);
        Assert.assertSame(contactEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        ContactEntityExt contactEntityExt = new ContactEntityExt();
        contactEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        contactEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        contactEntityExt.setDeleted(0);
        contactEntityExt.setEnabled(1);
        contactEntityExt.setUserId(1);
        contactEntityExt.setName("清哥");
        contactEntityExt.setPhone("1568784428");
        contactEntityExt.setEmail("zuoqinglong@youbaihu.com");
        
        contactEntityExtMapper.add(contactEntityExt);
        int oldcount = contactEntityExtMapper.getCount();
        contactEntityExtMapper.deleteById(contactEntityExt.getId());
        Assert.assertSame(contactEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
      
        ContactEntityExt contactEntityExt = new ContactEntityExt();
        contactEntityExt.setName("_test_");

        List<ContactEntityExt> result = contactEntityExtMapper.list(contactEntityExt,  page);
       
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_name_2_爱上课", result.get(1).getName());
    }
    @Test
    public void testQuery2() {
        ContactEntityExt contactEntityExt = new ContactEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        contactEntityExt.setIdSet(idSet);
        List<ContactEntityExt> result = contactEntityExtMapper.list(contactEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        ContactEntityExt contactEntityExt = new ContactEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        contactEntityExt.setUserId(4);
      
        List<ContactEntityExt> result = contactEntityExtMapper.list(contactEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_name_2_爱上课", result.get(0).getName());
    }
    
    @Test
    public void testQuery4() {
        ContactEntityExt contactEntityExt = new ContactEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        contactEntityExt.setUserId(4);
        contactEntityExt.setId(2);
        List<ContactEntityExt> result = contactEntityExtMapper.list(contactEntityExt, page);
        Assert.assertEquals(0, result.size());
    }
    @Test
    public void testGet() {
        ContactEntityExt getbyid1 = contactEntityExtMapper
                .getById(2);
        ContactEntityExt getbyid2 = contactEntityExtMapper
                .getById(3);
        ContactEntityExt getbyid3 = contactEntityExtMapper
                .getById(4);
        Assert.assertEquals("_test_name_1_爱上课", getbyid1.getName());
        Assert.assertEquals("_test_name_2_爱上课", getbyid2.getName());
        Assert.assertEquals("_test_name_3_爱上课", getbyid3.getName());
    }
}
