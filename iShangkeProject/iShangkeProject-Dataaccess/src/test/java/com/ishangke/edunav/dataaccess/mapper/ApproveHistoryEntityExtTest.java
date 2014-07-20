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
import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ApproveHistoryEntityExtTest {
    @Autowired
    private ApproveHistoryEntityExtMapper approveHistoryEntityExtMapper;

    @Test
    public void testAdd() {
        ApproveHistoryEntityExt approveHistoryEntityExt = new ApproveHistoryEntityExt();
        approveHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        approveHistoryEntityExt.setType(1);
        approveHistoryEntityExt.setAttachedId(1);
        approveHistoryEntityExt.setDeleted(0);
        approveHistoryEntityExtMapper.add(approveHistoryEntityExt);
        int oldcount = approveHistoryEntityExtMapper.getCount();
        approveHistoryEntityExtMapper.add(approveHistoryEntityExt);
        Assert.assertSame(approveHistoryEntityExtMapper.getCount(),
                oldcount + 1);
    }

    @Test
    public void testDelete() {
        ApproveHistoryEntityExt approveHistoryEntityExt = new ApproveHistoryEntityExt();
        approveHistoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        approveHistoryEntityExt.setType(1);
        approveHistoryEntityExt.setAttachedId(1);
        approveHistoryEntityExt.setDeleted(0);
        approveHistoryEntityExtMapper.add(approveHistoryEntityExt);
        int oldcount = approveHistoryEntityExtMapper.getCount();
        approveHistoryEntityExtMapper.deleteById(approveHistoryEntityExt
                .getId());
        Assert.assertSame(approveHistoryEntityExtMapper.getCount(),
                oldcount - 1);

    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));

        ApproveHistoryEntityExt approveHistoryEntityExt = new ApproveHistoryEntityExt();
        approveHistoryEntityExt.setComment("_test_");

        List<ApproveHistoryEntityExt> result = approveHistoryEntityExtMapper.list(approveHistoryEntityExt, page);
        Assert.assertEquals(4, result.size());
       Assert.assertEquals("_test_comment_3_爱上课", result.get(1).getComment());
    }

    @Test
    public void testQuery2() {
        ApproveHistoryEntityExt approveHistoryEntityExt = new ApproveHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        approveHistoryEntityExt.setIdSet(idSet);
        List<ApproveHistoryEntityExt> result = approveHistoryEntityExtMapper.list(
                approveHistoryEntityExt, page);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testQuery3() {
        ApproveHistoryEntityExt approveHistoryEntityExt = new ApproveHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        approveHistoryEntityExt.setAttachedId(2);
        approveHistoryEntityExt.setSubmitUserId(2);
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
        List<ApproveHistoryEntityExt> result = approveHistoryEntityExtMapper.list(
                approveHistoryEntityExt, page);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("_test_comment_1_爱上课", result.get(0).getComment());
        Assert.assertEquals("_test_comment_2_爱上课", result.get(1).getComment());
    }

    @Test
    public void testQuery4() {
        ApproveHistoryEntityExt approveHistoryEntityExt = new ApproveHistoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        approveHistoryEntityExt.setAttachedId(2);
        approveHistoryEntityExt.setSubmitUserId(2);
        approveHistoryEntityExt.setApproveUserId(3);
        List<ApproveHistoryEntityExt> result = approveHistoryEntityExtMapper.list(
                approveHistoryEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("_test_comment_2_爱上课", result.get(0).getComment());
    }
}
