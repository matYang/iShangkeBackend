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
import com.ishangke.edunav.dataaccess.model.GroupBuyBookingEntityExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml" })
@Transactional
public class GroupBuyBookingEntityExtTest {
    @Autowired
    private GroupBuyBookingEntityExtMapper groupBuyBookingEntityExtMapper;
    
    @Test
    public void testAdd(){
        GroupBuyBookingEntityExt groupBuyBooking = new GroupBuyBookingEntityExt();
        groupBuyBooking.setCreateTime(DateUtility.getCurTimeInstance());
        groupBuyBooking.setStatus(1);
        groupBuyBooking.setGroupBuyPrice(2.3);
        groupBuyBooking.setGroupBuyActivityId(1);
        groupBuyBooking.setUserId(1);
        int count = groupBuyBookingEntityExtMapper.add(groupBuyBooking);
        Assert.assertEquals(count, 1);
    }
    
    @Test
    public void testUpdate(){
        GroupBuyBookingEntityExt groupBuyBookingOld = groupBuyBookingEntityExtMapper.getById(1);
        int statusOld = groupBuyBookingOld.getStatus();
        Assert.assertEquals(statusOld,0);
        groupBuyBookingOld.setStatus(1);
        groupBuyBookingEntityExtMapper.update(groupBuyBookingOld);
        GroupBuyBookingEntityExt groupBuyBookingNew = groupBuyBookingEntityExtMapper.getById(1);
        int statusNew = groupBuyBookingNew.getStatus();
        Assert.assertEquals(statusNew, 1);
    }
    
    @Test
    public void testDelete(){
        groupBuyBookingEntityExtMapper.deleteById(4);
        GroupBuyBookingEntityExt object = groupBuyBookingEntityExtMapper.getById(4);
        Assert.assertSame(object, null);
    }
    
    @Test
    public void testList(){
        GroupBuyBookingEntityExt groupBuyBooking = new GroupBuyBookingEntityExt();
        groupBuyBooking.setStatus(0);
        groupBuyBooking.setCreateTimeStart(DateUtility.getCurTimeInstance());
        List<GroupBuyBookingEntityExt> list = groupBuyBookingEntityExtMapper.list(groupBuyBooking, null);
        int countFirst = list.size();
        int countSecond = groupBuyBookingEntityExtMapper.getListCount(groupBuyBooking);
        System.out.println("countFirst:" + countFirst);
        Assert.assertEquals(countFirst, countSecond);
    }
}
