include "fault.thrift"
include "common.thrift"
include "user.thrift"
include "booking.thrift"
include "order.thrift"
include "withdraw.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service OrderService { 
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
    common.ResponseBo createOrderByUser(1: order.OrderBo orderBo, 2: booking.BookingBo bookingBo, 3: user.UserBo userBo, 4: withdraw.WithdrawBo withdrawBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    common.ResponseBo acceptOrderByAdmin(1: order.OrderBo orderBo, 2: order.CommentOrderAcceptBo commentBookingAcceptBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}