package com.ishangke.edunav.dataaccess.mapper;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        groupBuyActivity.setCreateTime(DateUtility.getCurTimeInstance());
        groupBuyActivity.setEndTime(DateUtility.getCurTimeInstance());
        groupBuyActivity.setStatus(0);
        groupBuyActivity.setGroupBuyPrice(10.0);
        groupBuyActivity.setCourseId(4);
        groupBuyActivity.setHot(8);
        groupBuyActivity.setTitle("四级团购");
        int count = groupBuyActivityEntityExtMapper.add(groupBuyActivity);
        Assert.assertEquals(count, 1);
    }
    
    @Test
    public void testUpdate() throws IllegalArgumentException, IllegalAccessException{
        GroupBuyActivityEntityExt groupBuyActivityOld = groupBuyActivityEntityExtMapper.getById(1);
        System.out.println("===========================begin==================================");
        for (Field f : groupBuyActivityOld.getCourse().getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.get(groupBuyActivityOld.getCourse()) != null) {
                System.out.println(f.getName() + "===>" + f.get(groupBuyActivityOld.getCourse()));
            }
            if (f.getName().contains("List")) {
                List<Object> o = (List<Object>) f.get(groupBuyActivityOld.getCourse());
                System.out.println(f.getName() + " size:" + o.size());
                if (o.size() > 0) {
                    System.out.println("ooxx!!!xi ge hao bang !!!");
                }
            }
        }
        System.out.println("===========================end=====================================");
        int statusOld = groupBuyActivityOld.getStatus();
        Assert.assertEquals(statusOld,0);
        groupBuyActivityOld.setHot(5);
        groupBuyActivityEntityExtMapper.update(groupBuyActivityOld);
        GroupBuyActivityEntityExt groupBuyActivityNew = groupBuyActivityEntityExtMapper.getById(1);
        int hotNew = groupBuyActivityNew.getHot();
        Assert.assertEquals(hotNew, 5);
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
        Set<Integer> statusSet = new HashSet<>();
        statusSet.add(0);
        statusSet.add(1);
        groupBuyActivity.setStatusSet(statusSet);
        groupBuyActivity.setCreateTimeStart(DateUtility.getCurTimeInstance());
        List<GroupBuyActivityEntityExt> list = groupBuyActivityEntityExtMapper.list(groupBuyActivity, null);
        int countFirst = list.size();
        int countSecond = groupBuyActivityEntityExtMapper.getListCount(groupBuyActivity);
        Assert.assertEquals(countFirst, countSecond);
    }
}
