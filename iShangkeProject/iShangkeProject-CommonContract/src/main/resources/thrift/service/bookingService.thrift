include "model/fault.thrift"
include "model/user.thrift"
include "model/partner.thrift"
include "model/course.thrift"
include "model/booking.thrift"
include "model/bookingHistory.thrift"
include "model/coupon.thrift"
include "model/common.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service BookingService {
    /**
     *  本方法为用户预定课程的功能。<br>
     *  用户可以预定一个课程
     *
     *  @param  courseBo                     被预定的课程信息
     *  @param  bookingBo                    预定单信息
     *  @param  CommentBookingAcceptBo       创建预定单留言信息
     *  @param  userBo                       调用方法的用户的信息
     *
     *  @return 预定单实体 BookingBo
     *
     */ 
    booking.BookingBo createBookingByUser(1: course.CourseBo courseBo, 2: booking.BookingBo bookingBo, 3: booking.CommentBookingCreateBo commentBookingCreateBo, 4: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为合作商受理一个预定单功能。<br>
     *  合作商可以受理一个用户预定请求
     *
     *  @param  bookingBo                    预定单信息
     *  @param  CommentBookingAcceptBo       受理预定单留言信息
     *  @param  userBo                       调用方法的用户的信息
     *
     *  @return 
     *
     */ 
   booking.BookingBo acceptBookingByPartner(1: booking.BookingBo bookingBo, 2: booking.CommentBookingAcceptBo commentBookingAcceptBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为合作商受理成功一个预定单功能。<br>
     *  合作商可以将正在受理的预定单标注为受理成功
     *
     *  @param  bookingBo                           预定单信息
     *  @param  CommentBookingAcceptSuccessBo       受理成功预定单留言信息
     *  @param  userBo                              调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    booking.BookingBo acceptBookingSucceedByPartner(1: booking.BookingBo bookinbBo, 2: booking.CommentBookingAcceptSuccessBo commentBookingAcceptSuccessBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为合作商受理失败一个预定单功能。<br>
     *  合作商可以将正在受理的预定单标注为受理失败
     *
     *  @param  bookingBo                          预定单信息
     *  @param  CommentBookingAcceptFailedBo       受理失败预定单留言信息
     *  @param  userBo                             调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    booking.BookingBo acceptBookingFailedByPartner(1: booking.BookingBo bookingBo, 2: booking.CommentBookingAcceptFailedBo commentBookingAcceptFailedBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)


    /**
     *  本方法为合作商确认一个订单已生效。<br>
     *  合作商将一个受理成功的预定单标注为已付款
     *
     *  @param  bookingBo                      预定单信息
     *  @param  CommentBookingValidateBo       接收已付款预定单留言信息
     *  @param  userBo                         调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    booking.BookingBo validateBookingByPartner(1: booking.BookingBo bookingBo, 2: booking.CommentBookingValidateBo commentBookingValidateBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为取消一个预定单功能。<br>
     *  用户可以取消一个相关预定单
     *
     *  @param  bookingBo                   预定单信息
     *  @param  commentBookingCancelBo      取消预定单留言信息
     *  @param  userBo                      调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    booking.BookingBo cancelBookingByUser(1: booking.BookingBo bookingBo, 2: booking.CommentBookingCancelBo commentBookingCancelBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为取消一个预定单功能。<br>
     *  合作商可以取消一个相关预定单
     *
     *  @param  bookingBo                   预定单信息
     *  @param  commentBookingCancelBo      取消预定单留言信息
     *  @param  userBo                      调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    booking.BookingBo cancelBookingByPartner(1: booking.BookingBo bookingBo, 2: booking.CommentBookingCancelBo commentBookingCancelBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为取消一个预定单功能。<br>
     *  管理员可以取消一个相关预定单
     *
     *  @param  bookingBo                    预定单信息
     *  @param  commentBookingCancelBo       取消预定单留言信息
     *  @param  userBo                       调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    booking.BookingBo cancelBookingByAdmin(1: booking.BookingBo bookingBo, 2: booking.CommentBookingCancelBo commentBookingCancelBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询预定单预定单功能。<br>
     *  合作商可以按条件查询自己的所有预定单，ishangke管理员可以按条件查找所有合作商的预定单
     *
     *  @param  bookingBo       需要检索和过滤的预定单信息
     *  @param  partnerBo       合作商信息
     *  @param  userBo          调用方法的用户的信息
     *  @param  paginationBo    分页信息
     *
     *  @return 预定单实体 BookingBo 列表
     *
     */ 
    list<booking.BookingBo> query(1: booking.BookingBo bookingBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询订单历史操作。<br>
     *  合作商可以按条件查询自己的所有预定单历史操作，ishangke管理员可以按条件查找所有合作商的预定单历史操作
     *
     *  @param  bookingHistoryBo        需要检索和过滤的预定单历史信息
     *  @param  partnerBo               合作商信息
     *  @param  userBo                  调用方法的用户的信息
     *  @param  paginationBo            分页信息
     *
     *  @return 预定单实体 bookingHistoryBo 列表
     *
     */ 
    list<bookingHistory.BookingHistoryBo> queryHistory(1: bookingHistory.BookingHistoryBo bookingHistoryBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
} 