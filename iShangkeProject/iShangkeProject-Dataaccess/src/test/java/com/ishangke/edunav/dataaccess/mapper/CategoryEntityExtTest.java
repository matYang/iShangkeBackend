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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CategoryEntityExtTest {
    @Autowired
    private CategoryEntityExtMapper categoryEntityExtMapper;
    private Calendar time = Calendar.getInstance();
    @Test
    public void testAdd() {
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();

        categoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        categoryEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        categoryEntityExt.setEnabled(1);
        categoryEntityExt.setDeleted(0);

        categoryEntityExtMapper.add(categoryEntityExt);
        int oldcount = categoryEntityExtMapper.getCount();
        categoryEntityExtMapper.add(categoryEntityExt);
        Assert.assertSame(categoryEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        categoryEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
        categoryEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
        categoryEntityExt.setEnabled(1);
        categoryEntityExt.setDeleted(0);

        categoryEntityExtMapper.add(categoryEntityExt);
        int oldcount = categoryEntityExtMapper.getCount();
        categoryEntityExtMapper.deleteById(categoryEntityExt.getId());
        Assert.assertSame(categoryEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testQuery() {
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);

        page.addOrderByEntity(new OrderByEntity("CREATE_TIME", DataaccessConstants.ORDER_DESC));

        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        categoryEntityExt.setValue("0000_");

        List<CategoryEntityExt> result = categoryEntityExtMapper.list(categoryEntityExt, page);
        Assert.assertEquals(10, result.size());
       Assert.assertEquals("口译笔译", result.get(1).getName());
    }
    @Test
    public void testQuery2() {
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(10);
        Set<Integer> idSet = new HashSet();
        idSet.add(1);
        idSet.add(2);
        idSet.add(3);
        categoryEntityExt.setIdSet(idSet);
        List<CategoryEntityExt> result = categoryEntityExtMapper.list(categoryEntityExt, page);
        Assert.assertEquals(3, result.size());
    }
    
    @Test
    public void testGet() {
        CategoryEntityExt getbyid1 = categoryEntityExtMapper
                .getById(2);
        CategoryEntityExt getbyid2 = categoryEntityExtMapper
                .getById(3);
        CategoryEntityExt getbyid3 = categoryEntityExtMapper
                .getById(4);
        Assert.assertEquals("英语", getbyid1.getName());
        Assert.assertEquals("雅思", getbyid2.getName());
        Assert.assertEquals("四六级", getbyid3.getName());
    }
    @Test
    public void testUpdate() {
        CategoryEntityExt upDate = categoryEntityExtMapper
                .getById(2);
        upDate.setName("test_爱上课");
        upDate.setValue("test_ishangke");
        upDate.setRank(8);
        upDate.setCreateTime(time);
        categoryEntityExtMapper.update(upDate);
        upDate = categoryEntityExtMapper.getById(2);
        Assert.assertEquals("test_爱上课",upDate.getName());
        Assert.assertEquals("test_ishangke",upDate.getValue());
        Assert.assertSame(8,upDate.getRank());
      Assert.assertEquals(DateUtility.toSQLDateTime(time),
                DateUtility.toSQLDateTime(upDate.getCreateTime())); 
    }
}
