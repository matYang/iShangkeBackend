package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CreditEntityExtTest extends BaseTest{
    @Autowired
    private CreditEntityExtMapper creditEntityExtMapper;

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        //排序，先按照第一个排序，再按照第二个排序，依次排列
        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));
       
        CreditEntityExt creditEntityExt = new CreditEntityExt();
        creditEntityExt.setCredit(3.14);
        List<CreditEntityExt> result = creditEntityExtMapper.list(creditEntityExt, page);
        Assert.assertEquals(2, result.size());
    }
    @Test
    public void testGet() {
        CreditEntityExt getbyid1 = creditEntityExtMapper
                .getById(2);
        CreditEntityExt getbyid2 = creditEntityExtMapper
                .getById(3);
        CreditEntityExt getbyid3 = creditEntityExtMapper
                .getById(4);
        String time = "2014-07-15 14:34:45";
        Assert.assertEquals(time,
                DateUtility.toSQLDateTime(getbyid1.getCreateTime()));
        String time1 = "2014-07-15 14:35:16";
        Assert.assertEquals(time1,
                DateUtility.toSQLDateTime(getbyid2.getCreateTime()));
        String time2 = "2014-07-15 14:35:32";
        Assert.assertEquals(time2,
                DateUtility.toSQLDateTime(getbyid3.getCreateTime()));

    }
}
