package com.ishangke.edunav.dataaccess.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DateUtility;
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

//    @Test
//    public void testQuery() {
//        PaginationEntity page = new PaginationEntity();
//        page.setOffset(0);
//        page.setSize(10);
//        //排序，先按照第一个排序，再按照第二个排序，依次排列
//        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
//        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));
//        ContactEntityExt contactEntityExt = new ContactEntityExt();
//        contactEntityExt.setName("_test_");
//
//        List<ContactEntityExt> result = contactEntityExtMapper.list(contactEntityExt,  page);
//       
//        Assert.assertEquals(4, result.size());
//        Assert.assertEquals("_test_name_2_爱上课", result.get(1).getName());
//    }
}
