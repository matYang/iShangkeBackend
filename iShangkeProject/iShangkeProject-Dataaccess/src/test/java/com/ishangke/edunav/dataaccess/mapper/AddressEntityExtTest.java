package com.ishangke.edunav.dataaccess.mapper;

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
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;


//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, AddressEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class AddressEntityExtTest extends BaseTest{
    @Autowired
    private AddressEntityExtMapper addressEntityExtMapper;
//    
//    public AddressEntityExtTest() {
//        scriptAfterClass = "AddressEntityExtTestAfter.sql";
//        scriptBeforeClass = "AddressEntityExtTestBefore.sql";
//    }

    @Test
    public void testAdd() {
        AddressEntityExt addressEntityExt = new AddressEntityExt();
        addressEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        addressEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        addressEntityExt.setEnabled(1);
        addressEntityExt.setDeleted(0);
        addressEntityExt.setPartnerId(1);
        addressEntityExt.setDetail("ishangke李清01");
        addressEntityExtMapper.add(addressEntityExt);
        int oldcount = addressEntityExtMapper.getCount();
        addressEntityExtMapper.add(addressEntityExt);
        Assert.assertSame(addressEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        AddressEntityExt addressEntityExt = new AddressEntityExt();
        addressEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        addressEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        addressEntityExt.setEnabled(1);
        addressEntityExt.setDeleted(0);
        addressEntityExt.setPartnerId(1);
        addressEntityExt.setDetail("ishangke李清01");
        addressEntityExtMapper.add(addressEntityExt);
        int oldcount = addressEntityExtMapper.getCount();
        addressEntityExtMapper.deleteById(addressEntityExt.getId());
        Assert.assertSame(addressEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME", DataaccessConstants.ORDER_DESC));

        AddressEntityExt addressEntityExt = new AddressEntityExt();
        addressEntityExt.setDetail("_test_detail_");

        List<AddressEntityExt> result = addressEntityExtMapper.list(addressEntityExt, page);
        Assert.assertEquals(4, result.size());
       Assert.assertEquals("_test_detail_3_爱上课", result.get(1).getDetail());
    }

}
