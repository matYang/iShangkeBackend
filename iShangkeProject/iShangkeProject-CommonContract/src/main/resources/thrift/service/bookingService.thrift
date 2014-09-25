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
include "model/purposeCourse.thrift"
include "model/groupBuyActivity.thrift"
include "model/groupBuyBooking.thrift"

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
    booking.BookingBo createBookingByUser(1: booking.BookingBo bookingBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    //匿名用户
    booking.BookingBo createBookingByAnonymousUser(1: booking.BookingBo bookingBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
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
    booking.BookingPageViewBo queryBooking(1: booking.BookingBo bookingBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    booking.BookingBo queryBookingById(1: i32 id, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    bookingHistory.BookingHistoryPageViewBo queryHistory(1: bookingHistory.BookingHistoryBo bookingHistoryBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     * admin可以通过此方法查看所有订单的详细信息
     * partner管理员可以通过此方法，查看本机构的booking详情
     * @param bookingHistoryBo
     * @param BookingBo
     * @param userBo
     * @param paginationBo
     * @return
     */
    bookingHistory.BookingHistoryPageViewBo queryHistoryByBookingId(1: bookingHistory.BookingHistoryBo bookingHistoryBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    

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
    // booking.BookingPageViewBo queryBooking(1: booking.BookingBo bookingBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    // bookingHistory.BookingHistoryPageViewBo queryBookingHistory(1: bookingHistory.BookingHistoryBo bookingHistoryBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)









    // *********************************************************
    // *
    // *   关于预订单的 Order
    // *
    // *********************************************************

     /**
      *  本方法为用户支付课程的功能。<br>
      *  用户可以对booking进行支付
      *
      *  @param  orderBo         被预定的课程信息
      *  @param  userBo          调用方法的用户的信息
      *
      *  @return 预定单实体 OrderBo
      *
      */ 
     order.OrderBo createOrderByUser(1: order.OrderBo orderBo, 2: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
      order.OrderBo queryOrderById(1: order.OrderBo orderBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    //  orderHistory.OrderHistoryPageViewBo queryOrderHistory(1: orderHistory.OrderHistoryBo orderHistory, 2: booking.BookingBo bookingBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	string changeBookingStatusToPayed(1: i32 id, 2: string trade_no) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	string verify(1: string notify) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	string buildFormForGet(1:string subject, 2: string out_trade_no, 3: string total_fee, 4: string type) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	string buildFormForPost(1:string subject, 2: string out_trade_no, 3: string total_fee) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
	// *********************************************************
    // *
    // *   关于意向课程 purposeCourse
    // *
    // *********************************************************
	
	 /**
     * 本方法返回意向课程信息
     * 管理员可以通过此方法调取意向课程信息
     * 
     * @param purposeCourseBo 意向课程查询条件
     * @param userBo          调用方法的用户信息
     * @param paginationBo
     * @return
     */
    purposeCourse.PurposeCoursePageViewBo queryPurpose(1:purposeCourse.PurposeCourseBo purposeCourseBo,2:user.UserBo userBo,3:common.PaginationBo paginationBo,4:string permissionTag) throws (1:fault.BusinessExceptionBo businessExceptionBo);
    
    /**
     *  本方法创建意向课程信息
     * 管理员可以通过此方法创建意向课程信息 
     * 
     * @param purposeCourseBo  创建意向课程的信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    purposeCourse.PurposeCourseBo createPurpose(1:purposeCourse.PurposeCourseBo purposeCourseBo,2:user.UserBo userBo,3:string permissionTag) throws (1:fault.BusinessExceptionBo businessExceptionBo);
    
    /**
     *  本方法更新意向课程信息
     * 管理员可以通过此方法更新意向课程信息 
     * 
     * @param purposeCourseBo  更新意向课程的信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    purposeCourse.PurposeCourseBo updatePurpose(1:purposeCourse.PurposeCourseBo purposeCourseBo,2:user.UserBo userBo,3:string permissionTag) throws (1:fault.BusinessExceptionBo businessExceptionBo);
    
    /**
     *  本方法删除意向课程信息
     * 管理员可以通过此方法删除意向课程信息 
     * 
     * @param purposeCourseBo  删除意向课程的ID信息
     * @param userBo            调用方法的用户信息
     * @return
     */
    purposeCourse.PurposeCourseBo deletePurpose(1:purposeCourse.PurposeCourseBo purposeCourseBo,2:user.UserBo userBo,3:string permissionTag) throws (1:fault.BusinessExceptionBo businessExceptionBo);
    
    
    // *********************************************************
    // *
    // *   关于团购课程  GroupBuy
    // *
    // *********************************************************
        /**
     * 管理员创建一次团购活动
     * @param groupBuyActivityBo  创建团购活动信息
     * @param userBo  创建团购活动的用户信息
     * @return
     */
    groupBuyActivity.GroupBuyActivityBo createGroupBuyActivity(1:groupBuyActivity.GroupBuyActivityBo groupBuyActivityBo, 2:user.UserBo userBo,3:string permissionTag) throws (1:fault.BusinessExceptionBo businessExceptionBo);


    /**
     * 用户选购团购课程
     * @param groupBuyBookingBo  用户团购订单信息
     * @param groupBuyActivityBo 团购活动信息
     * @param userBo  选购团购课程用户信息
     * @return
     */
    groupBuyBooking.GroupBuyBookingBo createGroupBuyBooking(1:groupBuyBooking.GroupBuyBookingBo groupBuyBookingBo, 2:user.UserBo userBo,3:string permissionTag) throws (1:fault.BusinessExceptionBo businessException);

    /**
     * 用户查询自己的团购情况 管理员查询所有的团购情况
     * @param groupBuyBookingBo
     * @param userBo
     * @param paginationBo
     * @return
     */
    groupBuyBooking.GroupBuyBookingPageViewBo queryGroupBuyBooking(1:groupBuyBooking.GroupBuyBookingBo groupBuyBookingBo, 2:user.UserBo userBo, 3:common.PaginationBo paginationBo,4:string permissionTag) throws (1:fault.BusinessExceptionBo businessException);
    
    /**
     * 管理员对团购活动进行上线操作
     * @param groupBuyBookingBo
     * @param userBo
     * @param paginationBo
     * @return
     */
    groupBuyActivity.GroupBuyActivityBo online(1:groupBuyActivity.GroupBuyActivityBo groupBuyActivityBo, 2:user.UserBo userBo,3:string permissionTag) throws (1:fault.BusinessExceptionBo businessExceptionBo);

} 