package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingAcceptBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingAcceptFailedBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingAcceptSuccessBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingCancelBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingCreateBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingValidateBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.gen.BookingEntityMapper;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.ContactManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.TransformManager;

@Component
public class BookingManagerImpl implements BookingManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingManagerImpl.class);
    
    @Autowired
    private AuthManager authManager;
    
    @Autowired
    private TransformManager transformManager;
    
    @Autowired
    private BookingEntityMapper bookingMapper;
    
    @Autowired 
    private ContactManager contactManager;
    
    @Autowired
    private CouponManager couponManager;

    @Override
    public BookingBo createBookingByUser(CourseBo courseBo, BookingBo bookingBo, CommentBookingCreateBo commentBookingCreateBo, UserBo userBo) {
        // TODO coupon的使用
        return null;
    }

    @Override
    public List<BookingBo> queryBooking(BookingBo bookingBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookingHistoryBo> queryHistory(BookingHistoryBo bookingHistoryBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
