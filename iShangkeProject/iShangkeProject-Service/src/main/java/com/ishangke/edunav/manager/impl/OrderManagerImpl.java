package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.CommentOrderAcceptBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
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

    @Override
    public List<OrderBo> query(OrderBo orderBo, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<OrderBo> queryHistory(OrderHistoryBo orderHistory, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
