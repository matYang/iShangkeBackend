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

import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, ActivityEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ActivityEntityExtTest {
    @Autowired
    private ActivityEntityExtMapper activityEntityExtMapper;

    // public ActivityEntityExtTest() {
    // scriptAfterClass = "AddressEntityExtTestAfter.sql";
    // scriptBeforeClass = "AddressEntityExtTestBefore.sql";
    // }
    @Test
    public void testAdd() {
        ActivityEntityExt activityEntityExt = new ActivityEntityExt();
        activityEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        activityEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        activityEntityExt.setEnabled(1);
        activityEntityExt.setDeleted(0);
        activityEntityExtMapper.add(activityEntityExt);
        int oldcount = activityEntityExtMapper.getCount();
        activityEntityExtMapper.add(activityEntityExt);
        Assert.assertSame(activityEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        ActivityEntityExt activityEntityExt = new ActivityEntityExt();
        activityEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        activityEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        activityEntityExt.setEnabled(1);
        activityEntityExt.setDeleted(0);
        activityEntityExtMapper.add(activityEntityExt);
        int oldcount = activityEntityExtMapper.getCount();
        activityEntityExtMapper.deleteById(activityEntityExt.getId());
        Assert.assertSame(activityEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME",
                DataaccessConstants.ORDER_DESC));
        page.addOrderByEntity(new OrderByEntity("LAST_MODIFY_TIME",
                DataaccessConstants.ORDER_DESC));

        ActivityEntityExt activityEntityExt = new ActivityEntityExt();
        activityEntityExt.setName("_test_name_");

        List<ActivityEntityExt> result = activityEntityExtMapper.list(
                activityEntityExt, page);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals("_test_name_3_爱上课_", result.get(1).getName());
    }

    @Test
    public void testQuery2() {
        ActivityEntityExt activityEntityExt = new ActivityEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        activityEntityExt.setIdSet(idSet);
        List<ActivityEntityExt> result = activityEntityExtMapper.list(
                activityEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        ActivityEntityExt activityEntityExt = new ActivityEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        activityEntityExt.setCourseId(2);
        activityEntityExt.setPartnerId(5);
        List<ActivityEntityExt> result = activityEntityExtMapper.list(
                activityEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_remark_1_爱上课_", result.get(0).getRemark());
    }

    @Test
    public void testQuery4() {
        ActivityEntityExt activityEntityExt = new ActivityEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        activityEntityExt.setCourseId(3);
        activityEntityExt.setPartnerId(5);
        List<ActivityEntityExt> result = activityEntityExtMapper.list(
                activityEntityExt, page);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testGet() {
        ActivityEntityExt activityEntityExt1 = activityEntityExtMapper
                .getById(2);
        ActivityEntityExt activityEntityExt2 = activityEntityExtMapper
                .getById(3);
        ActivityEntityExt activityEntityExt3 = activityEntityExtMapper
                .getById(4);
        Assert.assertEquals("_test_name_1_爱上课_", activityEntityExt1.getName());
        Assert.assertEquals("_test_name_2_爱上课_", activityEntityExt2.getName());
        Assert.assertEquals("_test_name_3_爱上课_", activityEntityExt3.getName());
    }

}
