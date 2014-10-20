package com.ishangke.edunav.dataaccess.mapper;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class PartnerEntityExtTest {
    @Autowired
    private PartnerEntityExtMapper PartnerEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    @Test
    public void testAdd() {
        PartnerEntityExt PartnerEntityExt = new PartnerEntityExt();
        PartnerEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        PartnerEntityExt.setDeleted(0);
        PartnerEntityExt.setEnabled(0);
        PartnerEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        PartnerEntityExt.setPopularity(1);
        int oldcount = PartnerEntityExtMapper.getCount();
        PartnerEntityExtMapper.add(PartnerEntityExt);
        Assert.assertSame(PartnerEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        PartnerEntityExt PartnerEntityExt = new PartnerEntityExt();
        PartnerEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        PartnerEntityExt.setDeleted(0);
        PartnerEntityExt.setEnabled(0);
        PartnerEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());

        PartnerEntityExtMapper.add(PartnerEntityExt);
        int oldcount = PartnerEntityExtMapper.getCount();
        PartnerEntityExtMapper.deleteById(PartnerEntityExt.getId());
        Assert.assertSame(PartnerEntityExtMapper.getCount(), oldcount - 1);
    }
    @Test
    public void testUpdate() {
        PartnerEntityExt upDate = PartnerEntityExtMapper.getById(2);
        upDate.setWholeName("_test_name_爱上课");
        upDate.setCreateTime(time);
        PartnerEntityExtMapper.update(upDate);
        upDate = PartnerEntityExtMapper.getById(2);
        Assert.assertEquals("_test_name_爱上课", upDate.getWholeName());
        Assert.assertEquals(DateUtility.toSQLDateTime(time), DateUtility.toSQLDateTime(upDate.getCreateTime()));
    }
    
    
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        // 排序，先按照第一个排序，再按照第二个排序，依次排列
        PartnerEntityExt PartnerQueryEntity = new PartnerEntityExt();
        PartnerQueryEntity.setInstName("爱上课");
        List<PartnerEntityExt> result = PartnerEntityExtMapper.list(PartnerQueryEntity, page);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("爱上课", result.get(0).getInstName());
    }

    @Test
    public void testUpdate1() {
        PartnerEntityExt update = PartnerEntityExtMapper.getById(2);
        update.setPopularity(6);
        PartnerEntityExtMapper.update(update);
        PartnerEntityExt updateAfter = PartnerEntityExtMapper.getById(2);
        Assert.assertSame(6, updateAfter.getPopularity());
    }
    
    @Test
    public void testQuery1() {
        PartnerEntityExt PartnerQueryEntity = new PartnerEntityExt();
        PartnerQueryEntity.setRating(1.0);
        List<PartnerEntityExt> result = PartnerEntityExtMapper.list(PartnerQueryEntity, null);
        Assert.assertSame(1, result.get(0).getPopularity());
    }

}
