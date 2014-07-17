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
import com.ishangke.edunav.dataaccess.model.OrderEntityExt;

//@TestExecutionListeners(listeners = {
//        DependencyInjectionTestExecutionListener.class,
//        OrderEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class OrderEntityExtTest extends BaseTest {
    @Autowired
    private OrderEntityExtMapper orderEntityExtMapper;

    // resource里面
//    public OrderEntityExtTest() {
//        scriptAfterClass = "OrderEntityExtTestAfter.sql";
//        scriptBeforeClass = "OrderEntityExtTestBefore.sql";
//    }

    @Test
    public void testAdd() {
        OrderEntityExt orderEntityExt = new OrderEntityExt();
        orderEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        orderEntityExt.setDeleted(0);
        orderEntityExt.setEnabled(1);

        int oldcount = orderEntityExtMapper.getCount();
        orderEntityExtMapper.add(orderEntityExt);
        Assert.assertSame(orderEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        OrderEntityExt orderEntityExt = new OrderEntityExt();
        orderEntityExt.setCreateTime(DateUtility.getCurTimeInstance());

         orderEntityExt.setDeleted(0);
        orderEntityExt.setEnabled(1);
     
        orderEntityExtMapper.add(orderEntityExt);
        int oldcount = orderEntityExtMapper.getCount();
        orderEntityExtMapper.deleteById(orderEntityExt.getId());
        Assert.assertSame(orderEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));
       
        OrderEntityExt orderQueryEntity = new OrderEntityExt();
        orderQueryEntity.setType("_test_");
        List<OrderEntityExt> result = orderEntityExtMapper.list(
                orderQueryEntity, page);
        Assert.assertEquals(3, result.size());
         Assert.assertEquals("_test_type_3_", result.get(0).getType());
    }
}
