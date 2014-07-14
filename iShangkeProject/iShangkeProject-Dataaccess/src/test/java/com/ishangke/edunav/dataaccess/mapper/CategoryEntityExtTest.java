package com.ishangke.edunav.dataaccess.mapper;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
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

        categoryEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 10000));
        categoryEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 10000));
        List<CategoryEntityExt> list = CategoryEntityExtMapper.list(categoryEntityExt, null);
        Assert.assertSame(list.size(),1);

        int listSize = CategoryEntityExtMapper.getListCount(categoryEntityExt);
        Assert.assertSame(listSize,1);
        
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(1);
        
        list = CategoryEntityExtMapper.list(categoryEntityExt, page);
        Assert.assertSame(list.size(),1);

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
        
        categoryEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 10000));
        categoryEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 10000));
        List<CategoryEntityExt> list = CategoryEntityExtMapper.list(categoryEntityExt, null);
        String name = "李清";
        list.get(0).setName(name);        
        CategoryEntityExtMapper.update(list.get(0));
        list = CategoryEntityExtMapper.list(categoryEntityExt, null);      
       
        if(list.get(0).getName().equals(name)){
            //Passed;
        }else fail();
    }
}
