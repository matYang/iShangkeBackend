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
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class CircleEntityExtTest {
    @Autowired
    private CircleEntityExtMapper circleEntityExtMapper;

    @Test
    public void testAdd() {
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(new Date());
        circleEntityExt.setLastModifyTime(new Date());
        circleEntityExt.setEnabled(1);
        circleEntityExt.setDeleted(0);
        
        circleEntityExtMapper.add(circleEntityExt);
        int oldcount = circleEntityExtMapper.getCount();
        circleEntityExtMapper.add(circleEntityExt);
        Assert.assertSame(circleEntityExtMapper.getCount(), oldcount + 1);
    }

    @Test
    public void testDelete() {
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(new Date());
        circleEntityExt.setLastModifyTime(new Date());
        circleEntityExt.setEnabled(1);
        circleEntityExt.setDeleted(0);
     
        circleEntityExtMapper.add(circleEntityExt);
        int oldcount = circleEntityExtMapper.getCount();
        circleEntityExtMapper.deleteById(circleEntityExt.getId());
        Assert.assertSame(circleEntityExtMapper.getCount(), oldcount - 1);
    }
    
    @Test
    public void testList(){
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(new Date());
        circleEntityExt.setLastModifyTime(new Date());
        circleEntityExt.setEnabled(1);
        circleEntityExt.setDeleted(0);     
        circleEntityExtMapper.add(circleEntityExt);        
        
        circleEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 10000));
        circleEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 10000));
        
        List<CircleEntityExt> list = circleEntityExtMapper.list(circleEntityExt, null);
        Assert.assertSame(list.size(),1);
        
        int listSize = circleEntityExtMapper.getListCount(circleEntityExt, null);
        Assert.assertSame(listSize,1);
        
        PaginationEntity page = new PaginationEntity();
        page.setOffset(0);
        page.setSize(1);
        
        list = circleEntityExtMapper.list(circleEntityExt, page);
        Assert.assertSame(list.size(),1);
        
        listSize = circleEntityExtMapper.getListCount(circleEntityExt, page);
        Assert.assertSame(listSize,1);
    }
    
    @Test
    public void testUpdate(){
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(new Date());
        circleEntityExt.setLastModifyTime(new Date());
        circleEntityExt.setEnabled(1);
        circleEntityExt.setDeleted(0);     
        circleEntityExtMapper.add(circleEntityExt);        
        
        circleEntityExt.setCreateTimeStart(new Date(System.currentTimeMillis() - 10000));
        circleEntityExt.setLastModifyTimeStart(new Date(System.currentTimeMillis() - 10000));        
        List<CircleEntityExt> list = circleEntityExtMapper.list(circleEntityExt, null);
        String name = "李清";
        list.get(0).setName(name);
        circleEntityExtMapper.update(list.get(0));        
        list = circleEntityExtMapper.list(circleEntityExt, null);
        
        if(list.get(0).getName().equals(name)){
            //Passed;
        }else fail();
    }

}
