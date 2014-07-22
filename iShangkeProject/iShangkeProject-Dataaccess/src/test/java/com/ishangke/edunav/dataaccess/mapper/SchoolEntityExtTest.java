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
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;
import com.ishangke.edunav.dataaccess.model.SchoolEntityExt;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class SchoolEntityExtTest {
    @Autowired
    private SchoolEntityExtMapper schoolEntityExtMapper;
    @Test
    public void testAdd() {
        SchoolEntityExt schoolEntityExt = new SchoolEntityExt();

        schoolEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        schoolEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        schoolEntityExt.setEnabled(1);
        schoolEntityExt.setDeleted(0);

        schoolEntityExtMapper.add(schoolEntityExt);
        int oldcount = schoolEntityExtMapper.getCount();
        schoolEntityExtMapper.add(schoolEntityExt);
        Assert.assertSame(schoolEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        SchoolEntityExt schoolEntityExt = new SchoolEntityExt();
        schoolEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        schoolEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        schoolEntityExt.setEnabled(1);
        schoolEntityExt.setDeleted(0);

        schoolEntityExtMapper.add(schoolEntityExt);
        int oldcount = schoolEntityExtMapper.getCount();
        schoolEntityExtMapper.deleteById(schoolEntityExt.getId());
        Assert.assertSame(schoolEntityExtMapper.getCount(), oldcount - 1);
    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));

        SchoolEntityExt schoolEntityExt = new SchoolEntityExt();
        schoolEntityExt.setName("_test_");

        List<SchoolEntityExt> result = schoolEntityExtMapper.list(schoolEntityExt, page);
        Assert.assertEquals(4, result.size());
       Assert.assertEquals("_test_name_3_爱上课", result.get(1).getName());
    }
    @Test
    public void testGet() {
        SchoolEntityExt getbyid1 = schoolEntityExtMapper
                .getById(2);
        SchoolEntityExt getbyid2 = schoolEntityExtMapper
                .getById(3);
        SchoolEntityExt getbyid3 = schoolEntityExtMapper
                .getById(4);
        Assert.assertEquals("_test_name_1_爱上课", getbyid1.getName());
        Assert.assertEquals("_test_name_2_爱上课", getbyid2.getName());
        Assert.assertEquals("_test_name_3_爱上课", getbyid3.getName());
    }
}
