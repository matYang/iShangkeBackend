package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

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
}
