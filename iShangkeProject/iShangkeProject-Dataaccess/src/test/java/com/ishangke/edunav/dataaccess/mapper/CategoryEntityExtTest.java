package com.ishangke.edunav.dataaccess.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CategoryEntityExtTest {
    @Autowired
    private CategoryEntityExtMapper CategoryEntityExtMapper;

    @Test
    public void testAdd() {
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();

        categoryEntityExt.setCreateTime(new Date());
        categoryEntityExt.setLastModifyTime(new Date());
        categoryEntityExt.setEnabled(1);
        categoryEntityExt.setDeleted(0);

        CategoryEntityExtMapper.add(categoryEntityExt);
        int oldcount = CategoryEntityExtMapper.getCount();
        CategoryEntityExtMapper.add(categoryEntityExt);
        Assert.assertSame(CategoryEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        categoryEntityExt.setCreateTime(new Date());
        categoryEntityExt.setLastModifyTime(new Date());
        categoryEntityExt.setEnabled(1);
        categoryEntityExt.setDeleted(0);

        CategoryEntityExtMapper.add(categoryEntityExt);
        int oldcount = CategoryEntityExtMapper.getCount();
        CategoryEntityExtMapper.deleteById(categoryEntityExt.getId());
        Assert.assertSame(CategoryEntityExtMapper.getCount(), oldcount - 1);
    }

    @Test
    public void testList(){        
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        categoryEntityExt.setCreateTime(new Date());
        categoryEntityExt.setLastModifyTime(new Date());
        categoryEntityExt.setEnabled(1);
        categoryEntityExt.setDeleted(0);
        categoryEntityExt.setRank(1);        
        CategoryEntityExtMapper.add(categoryEntityExt);     

        categoryEntityExt.setCreateTimeStart(categoryEntityExt.getCreateTime());
        categoryEntityExt.setLastModifyTimeStart(categoryEntityExt.getLastModifyTime());
        List<CategoryEntityExt> list = CategoryEntityExtMapper.list(categoryEntityExt, null);
        Assert.assertSame(list.size(),1);

        int listSize = CategoryEntityExtMapper.getListCount(categoryEntityExt, null);
        Assert.assertSame(listSize,1);

    }

    @Test
    public void testUpdate(){
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        categoryEntityExt.setCreateTime(new Date());
        categoryEntityExt.setLastModifyTime(new Date());
        categoryEntityExt.setEnabled(1);
        categoryEntityExt.setDeleted(0);
        categoryEntityExt.setRank(1);        
        CategoryEntityExtMapper.add(categoryEntityExt);     
        
        categoryEntityExt.setCreateTimeStart(categoryEntityExt.getCreateTime());
        categoryEntityExt.setLastModifyTimeStart(categoryEntityExt.getLastModifyTime());
        List<CategoryEntityExt> list = CategoryEntityExtMapper.list(categoryEntityExt, null);
        list.get(0).setName("李清");
        CategoryEntityExtMapper.update(categoryEntityExt);

        list = CategoryEntityExtMapper.list(categoryEntityExt, null);
        Assert.assertSame(list.size(),1);

        int listSize = CategoryEntityExtMapper.getListCount(categoryEntityExt, null);
        Assert.assertSame(listSize,1);
    }
}
