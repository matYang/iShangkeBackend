package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.model.GroupBuyPhotoEntityExt;
import com.ishangke.edunav.manager.GroupBuyManager;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, GroupBuyManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class GroupBuyManagerImplTest extends BaseTest {
    @Autowired
    private GroupBuyManager groupBuyManager;

    @Test
    public void testCreateGroupBuyActivity() {
        GroupBuyActivityBo groupBuyActivityBo = new GroupBuyActivityBo();
        groupBuyActivityBo.setCreateTime(DateUtility.getCurTime());
        groupBuyActivityBo.setEndTime(3011546027000l);
        groupBuyActivityBo.setStatus(0);
        groupBuyActivityBo.setCourseId(1);
        List<GroupBuyPhotoBo> photoList = new ArrayList<GroupBuyPhotoBo>();
        GroupBuyPhotoBo groupBuyPhotoBo = new GroupBuyPhotoBo();
        groupBuyPhotoBo.setUrl(UUID.randomUUID().toString());
        photoList.add(groupBuyPhotoBo);
        groupBuyActivityBo.setPhotoList(photoList);
        UserBo userBo = new UserBo();
        userBo.setId(1);
        GroupBuyActivityBo groupBuyActivityBoNew = groupBuyManager.createGroupBuyActivity(groupBuyActivityBo, userBo);
        int id = groupBuyActivityBoNew.getCourseId();
        Assert.assertEquals(id, 1);
    }

    @Test
    public void testCreateGroupBuyBooking() {
        GroupBuyBookingBo groupBuyBookingBo = new GroupBuyBookingBo();
        groupBuyBookingBo.setCreateTime(DateUtility.getCurTime());
        groupBuyBookingBo.setStatus(0);
        groupBuyBookingBo.setGroupBuyPrice(10.0);
        groupBuyBookingBo.setGroupBuyActivityId(3);
        groupBuyBookingBo.setUserId(3);
        UserBo userBo = new UserBo();
        userBo.setId(3);
        GroupBuyBookingBo groupBuyBookingBoNew = groupBuyManager.createGroupBuyBooking(groupBuyBookingBo, userBo);
        double price = groupBuyBookingBoNew.getGroupBuyPrice();
        Assert.assertEquals(price, 10.0);
    }

    @Test
    public void testQueryGroupBuyBooking() {
        GroupBuyBookingBo groupBuyBookingBo = new GroupBuyBookingBo();
        groupBuyBookingBo.setGroupBuyActivityId(1);
        groupBuyBookingBo.setCreateTime(-1);
        groupBuyBookingBo.setCreateTimeEnd(-1);
        groupBuyBookingBo.setCreateTimeStart(DateUtility.getCurTime());
        groupBuyBookingBo.setStatus(0);
        groupBuyBookingBo.setGroupBuyPrice(-1);
        groupBuyBookingBo.setGroupBuyPriceStart(-1);
        groupBuyBookingBo.setGroupBuyPriceEnd(50.0);
        groupBuyBookingBo.setUserId(2);
        
        UserBo userBo = new UserBo();
        userBo.setId(2);
        List<GroupBuyBookingBo> list = groupBuyManager.queryGroupBuyBooking(groupBuyBookingBo, userBo, null);
        int count = list.size();
        System.out.println("count :" + count);
        //Assert.assertEquals(count, 3);
    }
    
    @Test
    public void testOnline(){
        GroupBuyActivityBo groupBuyActivityBo = new GroupBuyActivityBo();
        groupBuyActivityBo.setId(2);
        groupBuyActivityBo.setStatus(0);
        UserBo userBo = new UserBo();
        userBo.setId(1);
        GroupBuyActivityBo groupBuyBookingBoNew = groupBuyManager.online(groupBuyActivityBo, userBo);
        Assert.assertEquals(groupBuyBookingBoNew.getStatus(), 1);
    }
    
    @Test
    public void testGetBookingTotal() {
        int m = groupBuyManager.getGroupBuyBookingTotal(2);
        System.out.println("****");
        System.out.println(m);
    }
}
