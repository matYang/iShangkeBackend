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
import com.ishangke.edunav.dataaccess.model.CareerEntityExt;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CareerEntityExtTest {
    @Autowired
    private CareerEntityExtMapper careerEntityExtMapper;
    @Test
    public void testAdd() {
        CareerEntityExt CareerEntityExt = new CareerEntityExt();

        CareerEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        CareerEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        CareerEntityExt.setEnabled(1);
        CareerEntityExt.setDeleted(0);

        careerEntityExtMapper.add(CareerEntityExt);
        int oldcount = careerEntityExtMapper.getCount();
        careerEntityExtMapper.add(CareerEntityExt);
        Assert.assertSame(careerEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CareerEntityExt CareerEntityExt = new CareerEntityExt();
        CareerEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        CareerEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        CareerEntityExt.setEnabled(1);
        CareerEntityExt.setDeleted(0);

        careerEntityExtMapper.add(CareerEntityExt);
        int oldcount = careerEntityExtMapper.getCount();
        careerEntityExtMapper.deleteById(CareerEntityExt.getId());
        Assert.assertSame(careerEntityExtMapper.getCount(), oldcount - 1);
    }
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));

        CareerEntityExt careerEntityExt = new CareerEntityExt();
        careerEntityExt.setName("_test_");

        List<CareerEntityExt> result = careerEntityExtMapper.list(careerEntityExt, page);
        Assert.assertEquals(4, result.size());
       Assert.assertEquals("_test_name_3_爱上课", result.get(1).getName());
    }
  
}