package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
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

import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

//@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, ActivityEntityExtTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ActivityEntityExtTest {
    @Autowired
    private ActivityEntityExtMapper activityEntityExtMapper;
    private CircleEntityExtMapper circleEntityExtMapper;
    private Calendar time = Calendar.getInstance();

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
        Assert.assertEquals("_test_name_1_爱上课", result.get(1).getName());
    }

}
