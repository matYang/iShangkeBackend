package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.enums.BookingEnums;
import com.ishangke.edunav.common.enums.OrderEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.CommentOrderBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.OrderHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.OrderEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.OrderHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.OrderEntityExt;
import com.ishangke.edunav.dataaccess.model.OrderHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.BookingEntity;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.OrderManager;
import com.ishangke.edunav.manager.converter.BookingConverter;
import com.ishangke.edunav.manager.converter.OrderConverter;
import com.ishangke.edunav.manager.converter.OrderHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.manager.exception.notfound.BookingNotFoundException;
import com.ishangke.edunav.manager.exception.notfound.OrderNotFoundException;

@Component
public class OrderManagerImpl implements OrderManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderManagerImpl.class);

    @Autowired
    private OrderEntityExtMapper orderMapper;
    @Autowired
    private OrderHistoryEntityExtMapper orderHistoryMapper;
    @Autowired
    private AuthManager authManager;
    @Autowired
    private BookingEntityExtMapper bookingMapper;

    @Override
    public OrderBo createOrderByUser(OrderBo orderBo, UserBo userBo) {
        if (orderBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 插入新的order记录
        OrderEntityExt orderEntity = OrderConverter.fromBo(orderBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        BookingEntityExt bookingEntity = bookingMapper.getById(orderEntity.getBookingId());
        if (bookingEntity == null || bookingEntity.getStatus() != BookingEnums.Status.ONLINEPENDINGPAYMENT.code) {
            LOGGER.error(String.format("[create order] cannot create order for booking current status [%d]", bookingEntity == null ? null : bookingEntity.getStatus()));
            throw new ManagerException("cannot create order for booking current status [%d]", bookingEntity == null ? null : bookingEntity.getStatus());
        }

        // only normal user can call this method
        if (IdChecker.notEqual(bookingEntity.getUserId(), userEntity.getId())) {
            throw new AuthenticationException("User creating someone else's booking's order");
        }

        int result = 0;
        try {
            result = orderMapper.add(orderEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Order creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            // a little bug 没有定义orderhistory 的其他属性 所以只有order id, user id, create
            // time是必须的
            OrderHistoryEntityExt orderHistory = new OrderHistoryEntityExt();
            orderHistory.setOrderId(orderEntity.getId());
            orderHistory.setUserId(userEntity.getId());
            orderHistory.setCreateTime(DateUtility.getCurTimeInstance());
            try {
                orderHistoryMapper.add(orderHistory);
            } catch (Exception e) {
                throw new ManagerException("cannot create order history");
            }
            return OrderConverter.toBo(orderEntity);
        } else {
            throw new ManagerException("Order creation failed for user: " + userEntity.getId());
        }
    }

    @Override
    public OrderBo acceptOrderByAdmin(OrderBo orderBo, CommentOrderBo commentOrderBo, UserBo userBo) {
        if (orderBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        OrderEntityExt orderEntity = OrderConverter.fromBo(orderBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[OrderManagerImpl]system admin || admin[%s] call acceptOrderByAdmin at " + new Date(), userBo.getName()));
        } else {
            throw new AuthenticationException("Only Admin can accept orders");
        }

        if (orderEntity.getStatus() == OrderEnums.Status.NAIVE.code) {
            orderEntity.setStatus(OrderEnums.Status.ACCEPTED.code);
        } else {
            throw new ManagerException("Order approval failed for user: " + userEntity.getId());
        }

        try {
            orderMapper.update(orderEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Order approval failed for user: " + userEntity.getId(), t);
        }

        return OrderConverter.toBo(orderEntity);
    }

    @Override
    public List<OrderBo> query(OrderBo orderBo, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        OrderEntityExt orderEntity = orderBo == null ? null : OrderConverter.fromBo(orderBo);
        BookingEntityExt bookingEntity = bookingBo == null ? null : BookingConverter.fromBo(bookingBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (orderEntity != null && bookingEntity != null) {
            orderEntity.setBookingId(bookingEntity.getId());
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[OrderManagerImpl]system admin || admin[%s] call createOrder at " + new Date(), userBo.getName()));
        } else {
            if (bookingEntity != null && IdChecker.notNull(userEntity.getId()) && IdChecker.notEqual(bookingEntity.getUserId(), userEntity.getId())) {
                throw new ManagerException("此预定不属于该用户");
            }
        }

        List<OrderEntityExt> results = null;
        try {
            results = orderMapper.list(orderEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Order query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<OrderBo>();
        }
        List<OrderBo> convertedResults = new ArrayList<OrderBo>();
        for (OrderEntityExt result : results) {
            convertedResults.add(OrderConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public List<OrderHistoryBo> queryHistory(OrderHistoryBo orderHistoryBo, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        OrderHistoryEntityExt orderHistoryEntity = orderHistoryBo == null ? null : OrderHistoryConverter.fromBo(orderHistoryBo);
        BookingEntityExt bookingEntity = bookingBo == null ? null : BookingConverter.fromBo(bookingBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[OrderManagerImpl]system admin || admin[%s] call createOrder at " + new Date(), userBo.getName()));
        } else {
            if (bookingEntity != null && IdChecker.notNull(userEntity.getId()) && IdChecker.notEqual(bookingEntity.getUserId(), userEntity.getId())) {
                throw new ManagerException("此预定不属于该用户");
            }
        }

        List<OrderHistoryEntityExt> results = null;
        try {
            results = orderHistoryMapper.list(orderHistoryEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("OrderHistory query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<OrderHistoryBo>();
        }
        List<OrderHistoryBo> convertedResults = new ArrayList<OrderHistoryBo>();
        for (OrderHistoryEntityExt result : results) {
            if (IdChecker.notEqual(result.getUserId(), userEntity.getId())) {
                throw new ManagerException("此订单历史不属于这个用户");
            }
            convertedResults.add(OrderHistoryConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public OrderBo queryById(OrderBo orderBo, UserBo userBo) {
        if (orderBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        OrderEntityExt order = null;
        try {
            order = orderMapper.getById(orderBo.getId());
            if (order == null || IdChecker.isNull(order.getId())) {
                throw new OrderNotFoundException("Order is not found");
            }

            if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
                LOGGER.warn(String.format("[OrderManagerImpl]system admin || admin[%s] call queryOrderById at " + new Date(), userBo.getName()));
            } else {
                if (IdChecker.isNull(order.getBookingId())) {
                    throw new ManagerException("Order with id: " + order.getId() + " has invalid booking id: " + order.getBookingId());
                }
                BookingEntity booking = bookingMapper.getById(order.getBookingId());
                if (booking == null || IdChecker.isNull(booking.getId())) {
                    throw new BookingNotFoundException("Order with id: " + order.getId() + " can not find corresponding booking with id: " + order.getBookingId());
                }
                if (IdChecker.notEqual(booking.getUserId(), userBo.getId())) {
                    throw new AuthenticationException("User querying someone else's booking's order by id");
                }
            }

        } catch (Exception e) {
            throw new ManagerException("query order failed");
        }
        return OrderConverter.toBo(order);
    }

}
