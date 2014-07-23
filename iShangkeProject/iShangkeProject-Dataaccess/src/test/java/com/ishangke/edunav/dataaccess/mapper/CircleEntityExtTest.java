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

import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.DateUtility;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CareerEntityExt;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CircleEntityExtTest {
    @Autowired
    private CircleEntityExtMapper circleEntityExtMapper;
    private Calendar time = Calendar.getInstance();
    @Test
    public void testAdd() {        
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(time);
        circleEntityExt.setLastModifyTime(time);
        circleEntityExt.setEnabled(1);
        circleEntityExt.setDeleted(0);        
        int oldcount = circleEntityExtMapper.getCount();
        circleEntityExtMapper.add(circleEntityExt);
        Assert.assertSame(circleEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(time);
        circleEntityExt.setLastModifyTime(time);
        circleEntityExt.setEnabled(1);
        circleEntityExt.setDeleted(0);
     
        circleEntityExtMapper.add(circleEntityExt);
        int oldcount = circleEntityExtMapper.getCount();
        circleEntityExtMapper.deleteById(circleEntityExt.getId());
        Assert.assertSame(circleEntityExtMapper.getCount(), oldcount - 1);
    }
    
    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));

        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setValue("0_");

        List<CircleEntityExt> result = circleEntityExtMapper.list(circleEntityExt, page);
        Assert.assertEquals(5, result.size());
       Assert.assertEquals("新街口", result.get(0).getName());
    }
    @Test
    public void testQuery2() {
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        circleEntityExt.setIdSet(idSet);
        List<CircleEntityExt> result = circleEntityExtMapper.list(circleEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    @Test
    public void testGet() {
        CircleEntityExt getbyid1 = circleEntityExtMapper
                .getById(2);
        CircleEntityExt getbyid2 = circleEntityExtMapper
                .getById(3);
        CircleEntityExt getbyid3 = circleEntityExtMapper
                .getById(4);
        Assert.assertEquals("江宁大学城", getbyid1.getName());
        Assert.assertEquals("浦口大学城", getbyid2.getName());
        Assert.assertEquals("新街口", getbyid3.getName());
    }
    @Test
    public void testUpdate() {
        CircleEntityExt upDate = circleEntityExtMapper
                .getById(2);
        upDate.setName("test_爱上课");
        upDate.setValue("test_ishangke");
        upDate.setCreateTime(time);
        circleEntityExtMapper.update(upDate);
        upDate = circleEntityExtMapper.getById(2);
        Assert.assertEquals("test_爱上课",upDate.getName());
        Assert.assertEquals("test_ishangke",upDate.getValue());
        Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime())); 
    }
   

}
