include "model/fault.thrift"
include "model/user.thrift"
include "model/partner.thrift"
include "model/course.thrift"
include "model/booking.thrift"
include "model/bookingHistory.thrift"
include "model/coupon.thrift"
include "model/common.thrift"
include "model/order.thrift"
include "model/orderHistory.thrift"
include "model/withdraw.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service BookingService {
    /**
     * 本方法为用户预定课程的功能。<br>
     * 用户可以预定一个课程
     *
     * @param bookingBo
     *            预定单信息
     * @param CommentBookingAcceptBo
     *            创建预定单留言信息
     * @param userBo
     *            调用方法的用户的信息
     *
     * @return 预定单实体 BookingBo
     *
     */
    booking.BookingBo createBookingByUser(1: booking.BookingBo bookingBo, 2: booking.CommentBookingBo commentBookingBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     * 
     * @param bookingBo
     *              需要被改变状态的booking
     * @param operation
     *              需要进行的操作
     * @param userBo
     *              调用方法的用户信息
     * @return
     */
    booking.BookingBo transformBookingStatus(1: booking.BookingBo bookingBo, 2: i32 operation, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 本方法为查询预定单预定单功能。<br>
     * ishangke管理员可以按条件查找所有合作商的预定单
     *
     * @param bookingBo
     *            需要检索和过滤的预定单信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     *
     * @return 预定单实体 BookingBo 列表
     *
     */
    list<booking.BookingBo> queryBooking(1: booking.BookingBo bookingBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 本方法为查询订单历史操作。<br>
     * 合作商可以按条件查询自己的所有预定单历史操作，ishangke管理员可以按条件查找所有合作商的预定单历史操作
     *
     * @param bookingHistoryBo
     *            需要检索和过滤的预定单历史信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     *
     * @return 预定单实体 BookingBo 列表
     *
     */
    list<bookingHistory.BookingHistoryBo> queryHistory(1: bookingHistory.BookingHistoryBo bookingHistoryBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     * admin可以通过此方法查看所有订单的详细信息
     * partner管理员可以通过此方法，查看本机构的booking详情
     * @param bookingHistoryBo
     * @param BookingBo
     * @param userBo
     * @param paginationBo
     * @return
     */
    list<bookingHistory.BookingHistoryBo> queryHistoryByBookingId(1: bookingHistory.BookingHistoryBo bookingHistoryBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     * 本方法为查询预定单预定单功能。<br>
     * 合作商管理员和ishangke管理员可以通过此方法进行booking的查询
     *
     * @param bookingBo
     *            需要检索和过滤的预定单信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     *
     * @return 预定单实体 BookingBo 列表
     *
     */
    list<booking.BookingBo> queryBookingByPartner(1: booking.BookingBo bookingBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     * 本方法为查询预定单预定单功能。<br>
     * ishangke管理员可以按条件查找所有合作商的预定单
     *
     * @param bookingBo
     *            需要检索和过滤的预定单信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     *
     * @return 预定单实体 BookingBo 列表
     *
     */
    list<booking.BookingBo> queryBookingByUser(1: booking.BookingBo bookingBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**********************************************************
    // *
    // *   关于预约的 Booking
    // *
    // **********************************************************/

    // /**
    //  *  本方法为用户预定课程的功能。<br>
    //  *  用户可以预定一个课程
    //  *
    //  *  @param  courseBo                     被预定的课程信息
    //  *  @param  bookingBo                    预定单信息
    //  *  @param  CommentBookingAcceptBo       创建预定单留言信息
    //  *  @param  userBo                       调用方法的用户的信息
    //  *
    //  *  @return 预定单实体 BookingBo
    //  *
    //  */ 
    // booking.BookingBo createBookingByUser(1: course.CourseBo courseBo, 2: booking.BookingBo bookingBo, 3: booking.CommentBookingBo commentBookingBo, 4: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为查询预定单预定单功能。<br>
    //  *  合作商可以按条件查询自己的所有预定单，ishangke管理员可以按条件查找所有合作商的预定单
    //  *
    //  *  @param  bookingBo       需要检索和过滤的预定单信息
    //  *  @param  partnerBo       合作商信息
    //  *  @param  userBo          调用方法的用户的信息
    //  *  @param  paginationBo    分页信息
    //  *
    //  *  @return 预定单实体 BookingBo 列表
    //  *
    //  */ 
    // list<booking.BookingBo> queryBooking(1: booking.BookingBo bookingBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为查询订单历史操作。<br>
    //  *  合作商可以按条件查询自己的所有预定单历史操作，ishangke管理员可以按条件查找所有合作商的预定单历史操作
    //  *
    //  *  @param  bookingHistoryBo        需要检索和过滤的预定单历史信息
    //  *  @param  partnerBo               合作商信息
    //  *  @param  userBo                  调用方法的用户的信息
    //  *  @param  paginationBo            分页信息
    //  *
    //  *  @return 预定单实体 bookingHistoryBo 列表
    //  *
    //  */ 
    // list<bookingHistory.BookingHistoryBo> queryBookingHistory(1: bookingHistory.BookingHistoryBo bookingHistoryBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)









    // *********************************************************
    // *
    // *   关于预订单的 Order
    // *
    // *********************************************************

    // /**
    //  *  本方法为用户支付课程的功能。<br>
    //  *  用户可以对booking进行支付
    //  *
    //  *  @param  orderBo         被预定的课程信息
    //  *  @param  bookingBo       预定单信息
    //  *  @param  userBo          调用方法的用户的信息
    //  *  @param  withdrawBo      用户支付方式
    //  *
    //  *  @return 预定单实体 OrderBo
    //  *
    //  */ 
    // order.OrderBo createOrderByUser(1: order.OrderBo orderBo, 2: booking.BookingBo bookingBo, 3: user.UserBo userBo, 4: withdraw.WithdrawBo withdrawBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为合作商受理一个预定单功能。<br>
    //  *  合作商可以受理一个用户预定请求
    //  *
    //  *  @param  orderBo                      order信息
    //  *  @param  CommentOrderAcceptBo         受理order留言信息
    //  *  @param  userBo                       调用方法的用户的信息
    //  *
    //  *  @return 
    //  *
    //  */ 
    // order.OrderBo acceptOrderByAdmin(1: order.OrderBo orderBo, 2: order.CommentOrderBo commentOrderBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为查询Order功能。<br>
    //  *  用户可以查询自己拥有的Order信息，系统可以查看所有Order信息
    //  *
    //  *  @param  orderBo         Order信息
    //  *  @param  bookingBo       与Order相关的预定信息
    //  *  @param  userBo          调用方法的用户的信息
    //  *  @param  paginationBo    分页信息
    //  *
    //  *  @return OrderBo 列表
    //  *
    //  */ 
    //  list<order.OrderBo> queryOrder(1: order.OrderBo orderBo, 2: booking.BookingBo bookingBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为查询Order历史功能。<br>
    //  *  用户可以查询自己拥有的Order历史信息，系统可以查看所有Order的历史信息
    //  *
    //  *  @param  orderHistoryBo  Order历史信息
    //  *  @param  bookingBo       与Order相关的预定信息
    //  *  @param  userBo          调用方法的用户的信息
    //  *  @param  paginationBo    分页信息
    //  *
    //  *  @return OrderHistoryBo 列表
    //  *
    //  */ 
    //  list<orderHistory.OrderHistoryBo> queryOrderHistory(1: orderHistory.OrderHistoryBo orderHistory, 2: booking.BookingBo bookingBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	string changeBookingStatusToPayed(1: i32 id)throws (1: fault.BusinessExceptionBo businessExceptionBo)

} 