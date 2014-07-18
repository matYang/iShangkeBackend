package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CommentOrderAcceptBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.commoncontract.service.OrderService;
import com.ishangke.edunav.manager.OrderManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class OrderServiceImpl implements OrderService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderManager orderManager;

    @Override
    public OrderBo createOrderByUser(OrderBo orderBo, BookingBo bookingBo, UserBo userBo, WithdrawBo withdrawBo) throws BusinessExceptionBo, TException {
        try {
            return orderManager.createOrderByUser(orderBo, bookingBo, userBo, withdrawBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ORDER_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.ORDER_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public OrderBo acceptOrderByAdmin(OrderBo orderBo, CommentOrderAcceptBo commentBookingAcceptBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return orderManager.acceptOrderByAdmin(orderBo, commentBookingAcceptBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ORDER_ACCEPTBYADMIN_ERROR);
            exception.setMessageKey(ManagerErrorCode.ORDER_ACCEPTBYADMIN_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<OrderBo> query(OrderBo orderBo, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        try {
            return orderManager.query(orderBo, bookingBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ORDER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.ORDER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<OrderHistoryBo> queryHistory(OrderHistoryBo orderHistory, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        try {
            return orderManager.queryHistory(orderHistory, bookingBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ORDER_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.ORDER_QUERYHISTORY_ERROR_KEY);
            throw exception;
        }
    }

}
