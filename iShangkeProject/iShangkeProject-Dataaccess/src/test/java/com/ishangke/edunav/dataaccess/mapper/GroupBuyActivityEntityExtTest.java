package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.model.GroupBuyActivityEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class GroupBuyActivityEntityExtTest {
    @Autowired
    private GroupBuyActivityEntityExtMapper groupBuyActivityEntityExtMapper;
    
    @Test
    public void testAdd(){
        GroupBuyActivityEntityExt groupBuyActivity = new GroupBuyActivityEntityExt();
        groupBuyActivity.setCreateTime(DateUtility.getCurTimeInstance());
        groupBuyActivity.setStatus(1);
        groupBuyActivity.setCourseId(1);
        int count = groupBuyActivityEntityExtMapper.add(groupBuyActivity);
        Assert.assertEquals(count, 1);
    }
    
    @Test
    public void testUpdate(){
        GroupBuyActivityEntityExt groupBuyActivityOld = groupBuyActivityEntityExtMapper.getById(1);
        int statusOld = groupBuyActivityOld.getStatus();
        Assert.assertEquals(statusOld,0);
        groupBuyActivityOld.setStatus(1);
        groupBuyActivityEntityExtMapper.update(groupBuyActivityOld);
        GroupBuyActivityEntityExt groupBuyActivityNew = groupBuyActivityEntityExtMapper.getById(1);
        int statusNew = groupBuyActivityNew.getStatus();
        Assert.assertEquals(statusNew, 1);
    }
    
    @Test
    public void testDelete(){
        groupBuyActivityEntityExtMapper.deleteById(4);
        GroupBuyActivityEntityExt object = groupBuyActivityEntityExtMapper.getById(4);
        Assert.assertSame(object, null);
    }
    
    @Test
    public void testList(){
        GroupBuyActivityEntityExt groupBuyActivity = new GroupBuyActivityEntityExt();
        groupBuyActivity.setCourseId(1);
        groupBuyActivity.setCreateTimeStart(DateUtility.getCurTimeInstance());
        List<GroupBuyActivityEntityExt> list = groupBuyActivityEntityExtMapper.list(groupBuyActivity, null);
        int countFirst = list.size();
        int countSecond = groupBuyActivityEntityExtMapper.getListCount(groupBuyActivity);
        Assert.assertEquals(countFirst, countSecond);
    }
}
