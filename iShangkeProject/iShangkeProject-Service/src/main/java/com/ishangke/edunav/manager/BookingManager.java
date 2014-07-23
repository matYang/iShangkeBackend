package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingCreateBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface BookingManager {
    /**
     * 本方法为用户预定课程的功能。<br>
     * 用户可以预定一个课程
     *
     * @param courseBo
     *            被预定的课程信息
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
    BookingBo createBookingByUser(CourseBo courseBo, BookingBo bookingBo, CommentBookingCreateBo commentBookingCreateBo, UserBo userBo);

    /**
     * 本方法为查询预定单预定单功能。<br>
     * 合作商可以按条件查询自己的所有预定单，ishangke管理员可以按条件查找所有合作商的预定单
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
    List<BookingBo> queryBooking(BookingBo bookingBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo);

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
    List<BookingHistoryBo> queryHistory(BookingHistoryBo bookingHistoryBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo);
}
