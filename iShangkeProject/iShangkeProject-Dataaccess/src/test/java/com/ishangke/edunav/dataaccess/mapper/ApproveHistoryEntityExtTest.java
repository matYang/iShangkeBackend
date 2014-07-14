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
import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ApproveHistoryEntityExtTest extends BaseTest{
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
}
