package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface GroupBuyManager {
    /**
     * 管理员创建一次团购活动
     * @param groupBuyActivityBo  创建团购活动信息
     * @param userBo  创建团购活动的用户信息
     * @return
     */
    public GroupBuyActivityBo createGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo, UserBo userBo);

    /**
     * 管理员更新一次团购活动
     * 
     * @param groupBuyActivityBo
     *            更新团购活动信息
     * @param userBo
     *            更新团购活动的用户信息
     * @return
     */
    public GroupBuyActivityBo updateGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo, UserBo userBo);


    /**
     * 用户选购团购课程
     * @param groupBuyBookingBo  用户团购订单信息
     * @param groupBuyActivityBo 团购活动信息
     * @param userBo  选购团购课程用户信息
     * @return
     */
    public GroupBuyBookingBo createGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo,UserBo userBo);

    /**
     * 用户查询自己的团购情况 管理员查询所有的团购情况
     * @param groupBuyBookingBo
     * @param userBo
     * @param paginationBo
     * @return
     */
    public List<GroupBuyBookingBo> queryGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo, UserBo userBo, PaginationBo paginationBo);

    /**
     * 支付宝回调 告诉我们已经付款成功 不是人为的调用
     */
    public void payGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo);
    
    public int queryGroupBuyBookingTotal(GroupBuyBookingBo groupBuyBookingBo,UserBo userBo);
    
    public List<GroupBuyActivityBo> queryGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo, PaginationBo paginationBo);
    
    public int queryGroupBuyActivityTotal(GroupBuyActivityBo groupBuyActivityBo);
    
    public GroupBuyActivityBo online(GroupBuyActivityBo groupBuyActivityBo, UserBo userBo);
    
    public GroupBuyActivityBo queryGroupBuyActivityById(int id);
    
    public GroupBuyBookingBo queryGroupBuyBookingById(int id,UserBo userBo);

    public String changeGroupBuyBookingStatusToPayed(int bookingId, String trade_no);
    
    public int getGroupBuyBookingTotal(int courseId);

    public int getGroupBuyActivityViewTotal(int groupBuyActivityId);
}
