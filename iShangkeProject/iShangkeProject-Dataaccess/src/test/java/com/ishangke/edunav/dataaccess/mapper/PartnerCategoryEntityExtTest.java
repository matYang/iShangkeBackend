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
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerCategoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class PartnerCategoryEntityExtTest extends BaseTest{
    @Autowired
    private PartnerCategoryEntityExtMapper partnerCategoryEntityExtMapper;
    private Calendar time = Calendar.getInstance();

    @Test
    public void testAdd() {
        PartnerCategoryEntityExt partnerCategoryEntityExt = new PartnerCategoryEntityExt();
        partnerCategoryEntityExt.setPartnerId(1);
        partnerCategoryEntityExt.setCategoryId(1);
        partnerCategoryEntityExt.setDeleted(0);
        partnerCategoryEntityExt.setPartnerId(1);
        partnerCategoryEntityExtMapper.add(partnerCategoryEntityExt);
        int oldcount = partnerCategoryEntityExtMapper.getCount();
        partnerCategoryEntityExtMapper.add(partnerCategoryEntityExt);
        Assert.assertSame(partnerCategoryEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        PartnerCategoryEntityExt partnerCategoryEntityExt = new PartnerCategoryEntityExt();
        partnerCategoryEntityExt.setPartnerId(1);
        partnerCategoryEntityExt.setCategoryId(1);
        partnerCategoryEntityExt.setDeleted(0);
        partnerCategoryEntityExt.setPartnerId(1);
        partnerCategoryEntityExtMapper.add(partnerCategoryEntityExt);
        int oldcount = partnerCategoryEntityExtMapper.getCount();
        partnerCategoryEntityExtMapper.deleteById(partnerCategoryEntityExt.getId());
        Assert.assertSame(partnerCategoryEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        PartnerCategoryEntityExt partnerCategoryQueryEntity = new PartnerCategoryEntityExt();
        partnerCategoryQueryEntity.setPartnerId(1);
        List<PartnerCategoryEntityExt> result = partnerCategoryEntityExtMapper.list(partnerCategoryQueryEntity, page);
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testQuery2() {
        PartnerCategoryEntityExt partnerCategoryEntityExt = new PartnerCategoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        List<PartnerCategoryEntityExt> result = partnerCategoryEntityExtMapper
                .list(partnerCategoryEntityExt, page);
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void testQuery3() {
        PartnerCategoryEntityExt partnerCategoryEntityExt = new PartnerCategoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        partnerCategoryEntityExt.setPartnerId(3);

        List<PartnerCategoryEntityExt> result = partnerCategoryEntityExtMapper
                .list(partnerCategoryEntityExt, page);
        Assert.assertEquals(1, result.size());
        Assert.assertSame(5, result.get(0).getCategoryId());

    }

    @Test
    public void testUpdate() {
        PartnerCategoryEntityExt upDate = partnerCategoryEntityExtMapper.getById(2);
        upDate.setCategoryId(1);
        partnerCategoryEntityExtMapper.update(upDate);
        Assert.assertSame(1,partnerCategoryEntityExtMapper.getById(2).getCategoryId());
    }
}
