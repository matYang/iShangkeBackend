include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/booking.thrift"
include "model/order.thrift"
include "model/orderHistory.thrift"
include "model/withdraw.thrift"

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
     *  @return 预定单实体 OrderBo
     *
     */ 
    order.OrderBo createOrderByUser(1: order.OrderBo orderBo, 2: booking.BookingBo bookingBo, 3: user.UserBo userBo, 4: withdraw.WithdrawBo withdrawBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    order.OrderBo acceptOrderByAdmin(1: order.OrderBo orderBo, 2: order.CommentOrderAcceptBo commentBookingAcceptBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询Order功能。<br>
     *  用户可以查询自己拥有的Order信息，系统可以查看所有Order信息
     *
     *  @param  orderBo         Order信息
     *  @param  bookingBo       与Order相关的预定信息
     *  @param  userBo          调用方法的用户的信息
     *  @param  paginationBo    分页信息
     *
     *  @return OrderBo 列表
     *
     */ 
     list<order.OrderBo> query(1: order.OrderBo orderBo, 2: booking.BookingBo bookingBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询Order历史功能。<br>
     *  用户可以查询自己拥有的Order历史信息，系统可以查看所有Order的历史信息
     *
     *  @param  orderHistoryBo  Order历史信息
     *  @param  bookingBo       与Order相关的预定信息
     *  @param  userBo          调用方法的用户的信息
     *  @param  paginationBo    分页信息
     *
     *  @return OrderHistoryBo 列表
     *
     */ 
     list<orderHistory.OrderHistoryBo> queryHistory(1: orderHistory.OrderHistoryBo orderHistory, 2: booking.BookingBo bookingBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)


}