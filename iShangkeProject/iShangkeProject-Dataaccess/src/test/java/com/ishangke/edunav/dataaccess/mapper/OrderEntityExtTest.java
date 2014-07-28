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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
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
    private Calendar time = Calendar.getInstance();
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
        Assert.assertEquals(4, result.size());
         Assert.assertEquals("_test_type_1_爱上课", result.get(0).getType());
    }
    @Test
    public void testQuery2() {
        OrderEntityExt OrderEntityExt = new OrderEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        OrderEntityExt.setIdSet(idSet);
        List<OrderEntityExt> result = orderEntityExtMapper.list(OrderEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testQuery3() {
        OrderEntityExt OrderEntityExt = new OrderEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        OrderEntityExt.setBookingId(5);
        OrderEntityExt.setId(2);
        List<OrderEntityExt> result = orderEntityExtMapper.list(OrderEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_type_1_爱上课", result.get(0).getType());
    }
    
    @Test
    public void testQuery4() {
        OrderEntityExt OrderEntityExt = new OrderEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        OrderEntityExt.setBookingId(5);
        OrderEntityExt.setId(3);
        List<OrderEntityExt> result = orderEntityExtMapper.list(OrderEntityExt, page);
        Assert.assertEquals(0, result.size());
    }
    @Test
    public void testGet() {
        OrderEntityExt getbyid1 = orderEntityExtMapper
                .getById(2);
        OrderEntityExt getbyid2 = orderEntityExtMapper
                .getById(3);
        OrderEntityExt getbyid3 = orderEntityExtMapper
                .getById(4);
        Assert.assertEquals("_test_type_1_爱上课", getbyid1.getType());
        Assert.assertEquals("_test_type_2_爱上课", getbyid2.getType());
        Assert.assertEquals("_test_type_3_爱上课", getbyid3.getType());
      
    }
    @Test
    public void testUpdate() {
        OrderEntityExt upDate = orderEntityExtMapper
                .getById(2);
        upDate.setType("_test_name_爱上课");
        upDate.setCreateTime(time);
        orderEntityExtMapper.update(upDate);
        upDate = orderEntityExtMapper.getById(2);
        Assert.assertEquals("_test_name_爱上课",
               upDate.getType());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
}
