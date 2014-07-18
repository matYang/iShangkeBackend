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

import com.ishangke.edunav.dataaccess.common.DataaccessConstants;
import com.ishangke.edunav.dataaccess.common.OrderByEntity;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
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
        circleEntityExt.setName("_test_");

        List<CircleEntityExt> result = circleEntityExtMapper.list(circleEntityExt, page);
        Assert.assertEquals(4, result.size());
       Assert.assertEquals("_test_name_3_爱上课", result.get(1).getName());
    }

}
