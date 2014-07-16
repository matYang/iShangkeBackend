package com.ishangke.edunav.manager;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.CommentOrderAcceptBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;

public interface OrderManager {
    /**
     *  本方法为用户支付课程的功能。<br>
     *  用户可以对booking进行支付
     *
     *  @param  orderBo         被预定的课程信息
     *  @param  bookingBo       预定单信息
     *  @param  userBo          调用方法的用户的信息
     *  @param  withdrawBo      用户支付方式
     *
     *  @return 预定单实体 BookingBo
     *
     */ 
    OrderBo createOrderByUser(OrderBo orderBo, BookingBo bookingBo, UserBo userBo, WithdrawBo withdrawBo);

    /**
     *  本方法为合作商受理一个预定单功能。<br>
     *  合作商可以受理一个用户预定请求
     *
     *  @param  orderBo                      order信息
     *  @param  CommentOrderAcceptBo         受理order留言信息
     *  @param  userBo                       调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    OrderBo acceptOrderByAdmin(OrderBo orderBo, CommentOrderAcceptBo commentBookingAcceptBo, UserBo userBo);
}
