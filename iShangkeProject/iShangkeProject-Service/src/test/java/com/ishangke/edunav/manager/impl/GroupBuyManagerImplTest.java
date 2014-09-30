package com.ishangke.edunav.manager.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.GroupBuyManager;
import com.ishangke.edunav.util.PageUtil;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, GroupBuyManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-serviceUT.xml" })
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

        List<AddressBo> addressList = new ArrayList<AddressBo>();
        AddressBo addressBo = new AddressBo();
        addressBo.setId(1);
        addressBo.setCreateTime(DateUtility.getCurTime());
        addressBo.setLastModifyTime(DateUtility.getCurTime());
        addressBo.setEnabled(1);
        addressBo.setPartnerId(1);
        addressBo.setDetail("ishangkedd01");
        addressList.add(addressBo);
        groupBuyActivityBo.setAddressList(addressList);
        UserBo userBo = new UserBo();
        userBo.setId(1);
        GroupBuyActivityBo groupBuyActivityBoNew = groupBuyManager.createGroupBuyActivity(groupBuyActivityBo, userBo);
        int id = groupBuyActivityBoNew.getCourseId();
        Assert.assertEquals(id, 1);
    }

    @Test
    public void testUpdateGroupBuyActivity() {
        GroupBuyActivityBo groupBuyActivityBo = new GroupBuyActivityBo();
        groupBuyActivityBo.setCreateTime(DateUtility.getCurTime());
        groupBuyActivityBo.setEndTime(3011546027111l);
        groupBuyActivityBo.setStatus(0);
        groupBuyActivityBo.setCourseId(1);
        List<GroupBuyPhotoBo> photoList = new ArrayList<GroupBuyPhotoBo>();
        GroupBuyPhotoBo groupBuyPhotoBo = new GroupBuyPhotoBo();
        groupBuyPhotoBo.setUrl(UUID.randomUUID().toString());
        photoList.add(groupBuyPhotoBo);
        groupBuyActivityBo.setPhotoList(photoList);
        List<AddressBo> addressList = new ArrayList<AddressBo>();
        AddressBo addressBo = new AddressBo();
        addressBo.setId(1);
        addressBo.setCreateTime(DateUtility.getCurTime());
        addressBo.setLastModifyTime(DateUtility.getCurTime());
        addressBo.setEnabled(1);
        addressBo.setPartnerId(1);
        addressBo.setDetail("ishangkedd01");
        addressList.add(addressBo);
        groupBuyActivityBo.setAddressList(addressList);
        UserBo userBo = new UserBo();
        userBo.setId(1);
        GroupBuyActivityBo groupBuyActivityBoNew = groupBuyManager.createGroupBuyActivity(groupBuyActivityBo, userBo);
        int id = groupBuyActivityBoNew.getCourseId();
        Assert.assertEquals(id, 1);
        List<GroupBuyPhotoBo> groupBuyPhotoListNew = groupBuyActivityBoNew.getPhotoList();
        assertEquals(groupBuyPhotoListNew.size(), 1);
        GroupBuyPhotoBo groupBuyPhotoBoNew = new GroupBuyPhotoBo();
        groupBuyPhotoBoNew.setUrl(UUID.randomUUID().toString());
        groupBuyPhotoListNew.add(groupBuyPhotoBoNew);
        groupBuyActivityBo.setPhotoList(groupBuyPhotoListNew);
        GroupBuyActivityBo groupBuyActivityBoNew1 = groupBuyManager.createGroupBuyActivity(groupBuyActivityBo, userBo);
        List<GroupBuyPhotoBo> groupBuyPhotoListNew1 = groupBuyActivityBoNew.getPhotoList();
        assertEquals(groupBuyPhotoListNew1.size(), 2);
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
        int total = groupBuyManager.queryGroupBuyBookingTotal(groupBuyBookingBo, userBo);
        Assert.assertEquals(count, total);
    }

    @Test
    public void testQueryGroupBuyActivity() {
        GroupBuyActivityBo groupBuyActivityBo = new GroupBuyActivityBo();
        Set<Integer> statusSet = new HashSet<>();
        statusSet.add(0);
        statusSet.add(1);
        groupBuyActivityBo.setStatusSet(statusSet);
        groupBuyActivityBo.setStatus(-1);
        groupBuyActivityBo.setCourseId(1);
        groupBuyActivityBo.setCreateTime(-1);
        groupBuyActivityBo.setCreateTimeStart(-1);
        groupBuyActivityBo.setCreateTimeEnd(-1);
        groupBuyActivityBo.setEndTime(-1);
        groupBuyActivityBo.setEndTimeStart(-1);
        groupBuyActivityBo.setEndTimeEnd(1411716901000l);
        groupBuyActivityBo.setGroupBuyPrice(-1);
        groupBuyActivityBo.setGroupBuyPriceStart(-1);
        groupBuyActivityBo.setGroupBuyPriceEnd(-1);
        groupBuyActivityBo.setHot(-1);
        PaginationBo paginationBo = null;
        paginationBo = PageUtil.getPage(paginationBo);
        List<GroupBuyActivityBo> list = groupBuyManager.queryGroupBuyActivity(groupBuyActivityBo, paginationBo);
        int count = list.size();
        int total = groupBuyManager.queryGroupBuyActivityTotal(groupBuyActivityBo);
        Assert.assertEquals(1, count);
        Assert.assertEquals(total, count);
    }

    @Test
    public void testOnline() {
        GroupBuyActivityBo groupBuyActivityBo = new GroupBuyActivityBo();
        groupBuyActivityBo.setId(2);
        groupBuyActivityBo.setStatus(0);
        UserBo userBo = new UserBo();
        userBo.setId(1);
        GroupBuyActivityBo groupBuyBookingBoNew = groupBuyManager.online(groupBuyActivityBo, userBo);
        Assert.assertEquals(groupBuyBookingBoNew.getStatus(), 1);
    }

    @Test
    public void testQueryGroupBuyActivityById() {
        GroupBuyActivityBo activity = groupBuyManager.queryGroupBuyActivityById(1);
        Assert.assertEquals(1, activity.getId());
    }

    @Test
    public void testQueryGroupBuyBookingById() {
        UserBo userBo = new UserBo();
        userBo.setId(1);
        GroupBuyBookingBo booking = groupBuyManager.queryGroupBuyBookingById(2, userBo);
        Assert.assertEquals(2, booking.getId());
    }

    @Test
    public void testChangeGroupBuyBookingStatusToPayed() {
        UserBo userBo = new UserBo();
        userBo.setId(8);
        GroupBuyBookingBo g = groupBuyManager.queryGroupBuyBookingById(7, userBo);
        System.out.println("status before:" + g.getStatus());
        String str = groupBuyManager.changeGroupBuyBookingStatusToPayed(7, "123");
        GroupBuyBookingBo gg = groupBuyManager.queryGroupBuyBookingById(7, userBo);
        System.out.println("status after:" + gg.getStatus());
        System.out.println("str:"+str);
        Assert.assertEquals("success", str);
    }
    
    @Test
    public void testGetBookingTotal() {
        int m = groupBuyManager.getGroupBuyBookingTotal(2);
        System.out.println("****");
        System.out.println(m);
    }
}
