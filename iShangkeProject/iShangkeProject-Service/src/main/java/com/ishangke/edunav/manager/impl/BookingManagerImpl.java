package com.ishangke.edunav.manager.impl;

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
import com.ishangke.edunav.manager.BookingManager;

public class BookingManagerImpl implements BookingManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingManagerImpl.class);

    @Override
    public BookingBo createBookingByUser(CourseBo courseBo, BookingBo bookingBo, CommentBookingCreateBo commentBookingCreateBo, UserBo userBo, CouponBo couponBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingBo acceptBookingByPartner(BookingBo bookingBo, CommentBookingAcceptBo commentBookingAcceptBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingBo acceptBookingSucceedByPartner(BookingBo bookinbBo, CommentBookingAcceptSuccessBo commentBookingAcceptSuccessBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingBo acceptBookingFailedByPartner(BookingBo bookingBo, CommentBookingAcceptFailedBo commentBookingAcceptFailedBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingBo validateBookingByPartner(BookingBo bookingBo, CommentBookingValidateBo commentBookingValidateBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingBo cancelBookingByUser(BookingBo bookingBo, CommentBookingCancelBo commentBookingCancelBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingBo cancelBookingByPartner(BookingBo bookingBo, CommentBookingCancelBo commentBookingCancelBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BookingBo cancelBookingByAdmin(BookingBo bookingBo, CommentBookingCancelBo commentBookingCancelBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookingBo> queryBooking(BookingBo bookingBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
