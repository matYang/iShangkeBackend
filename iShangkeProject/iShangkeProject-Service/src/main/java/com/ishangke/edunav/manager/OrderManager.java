package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.CommentOrderAcceptBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;

public interface OrderManager {

    /**
     * 本方法为用户支付课程的功能。<br>
     * 用户可以对booking进行支付
     * 
     * @param orderBo
     *            被预定的课程信息
     * @param bookingBo
     *            预定单信息
     * @param userBo
     *            调用方法的用户的信息
     * @param withdrawBo
     *            用户支付方式
     * 
     * @return 预定单实体 OrderBo
     * 
     * 
     * @param orderBo
     * @param bookingBo
     * @param userBo
     * @param withdrawBo
     */
    OrderBo createOrderByUser(OrderBo orderBo, BookingBo bookingBo, UserBo userBo, WithdrawBo withdrawBo);

    /**
     * 本方法为合作商受理一个预定单功能。<br>
     * 合作商可以受理一个用户预定请求
     * 
     * @param orderBo
     *            order信息
     * @param CommentOrderAcceptBo
     *            受理order留言信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param orderBo
     * @param commentBookingAcceptBo
     * @param userBo
     */
    OrderBo acceptOrderByAdmin(OrderBo orderBo, CommentOrderAcceptBo commentBookingAcceptBo, UserBo userBo);

    /**
     * 本方法为查询Order功能。<br>
     * 用户可以查询自己拥有的Order信息，系统可以查看所有Order信息
     * 
     * @param orderBo
     *            Order信息
     * @param bookingBo
     *            与Order相关的预定信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return OrderBo 列表
     * 
     * 
     * @param orderBo
     * @param bookingBo
     * @param userBo
     * @param paginationBo
     */
    List<OrderBo> query(OrderBo orderBo, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo);

    /**
     * 本方法为查询Order历史功能。<br>
     * 用户可以查询自己拥有的Order历史信息，系统可以查看所有Order的历史信息
     * 
     * @param orderHistoryBo
     *            Order历史信息
     * @param bookingBo
     *            与Order相关的预定信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return OrderHistoryBo 列表
     * 
     * 
     * @param orderHistory
     * @param bookingBo
     * @param userBo
     * @param paginationBo
     */
    List<OrderHistoryBo> queryHistory(OrderHistoryBo orderHistory, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo);

}
