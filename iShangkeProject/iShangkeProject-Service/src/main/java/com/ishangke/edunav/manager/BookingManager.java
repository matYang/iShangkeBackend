package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingAcceptBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingAcceptFailedBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingAcceptSuccessBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingCancelBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingCreateBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingValidateBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface BookingManager {
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
    BookingBo createBookingByUser(CourseBo courseBo, BookingBo bookingBo, CommentBookingCreateBo commentBookingCreateBo, UserBo userBo);

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
    BookingBo acceptBookingByPartner(BookingBo bookingBo, CommentBookingAcceptBo commentBookingAcceptBo, UserBo userBo);

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
    BookingBo acceptBookingSucceedByPartner(BookingBo bookinbBo, CommentBookingAcceptSuccessBo commentBookingAcceptSuccessBo, UserBo userBo);

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
    BookingBo acceptBookingFailedByPartner(BookingBo bookingBo, CommentBookingAcceptFailedBo commentBookingAcceptFailedBo, UserBo userBo);


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
    BookingBo validateBookingByPartner(BookingBo bookingBo, CommentBookingValidateBo commentBookingValidateBo, UserBo userBo);

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
    BookingBo cancelBookingByUser(BookingBo bookingBo, CommentBookingCancelBo commentBookingCancelBo, UserBo userBo);

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
    BookingBo cancelBookingByPartner(BookingBo bookingBo, CommentBookingCancelBo commentBookingCancelBo, UserBo userBo);

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
    BookingBo cancelBookingByAdmin(BookingBo bookingBo, CommentBookingCancelBo commentBookingCancelBo, UserBo userBo);

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
    List<BookingBo> queryBooking(BookingBo bookingBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo);
}
