package com.ishangke.edunav.manager.impl;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.CommentOrderAcceptBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.manager.OrderManager;

public class OrderManagerImpl implements OrderManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderManagerImpl.class);
    
    @Override
    public OrderBo createOrderByUser(OrderBo orderBo, BookingBo bookingBo, UserBo userBo, WithdrawBo withdrawBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OrderBo acceptOrderByAdmin(OrderBo orderBo, CommentOrderAcceptBo commentBookingAcceptBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
