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
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class ActivityEntityExtTest extends BaseTest{
    @Autowired
    private ActivityEntityExtMapper activityEntityExtMapper;

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

}
