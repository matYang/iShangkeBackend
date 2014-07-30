package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface BookingManager {
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
    BookingBo createBookingByUser(BookingBo bookingBo, CommentBookingBo commentBookingBo, UserBo userBo);
    
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
    BookingBo transformBookingStatus(BookingBo bookingBo, CommentBookingBo commentBookingBo, int operation, UserBo userBo);

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
    List<BookingBo> queryBooking(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo);

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
    List<BookingHistoryBo> queryHistory(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo);
    
    /**
     * admin可以通过此方法查看所有订单的详细信息
     * partner管理员可以通过此方法，查看本机构的booking详情
     * @param bookingHistoryBo
     * @param BookingBo
     * @param userBo
     * @param paginationBo
     * @return
     */
    List<BookingHistoryBo> queryHistoryByBookingId(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo);
    
    String changeBookingStatusToPayed(int orderId);
    String verify(String notify_id);
    String buildFormForGet(String subject,String out_trade_no, String total_fee);
}
