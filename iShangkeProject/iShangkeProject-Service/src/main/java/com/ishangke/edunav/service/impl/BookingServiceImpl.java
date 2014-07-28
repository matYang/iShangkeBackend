package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.BookingService;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.OrderManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;

@Component
public class BookingServiceImpl implements BookingService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    private BookingManager bookingManager;

    @Autowired
    private OrderManager orderManager;

    @Autowired
    private PermissionManager permissionManager;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public BookingBo createBookingByUser(BookingBo bookingBo, CommentBookingBo commentBookingBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
                throw new NoPermissionException();
            }
            return bookingManager.createBookingByUser(bookingBo, commentBookingBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public BookingBo transformBookingStatus(BookingBo bookingBo, int operation, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
                throw new NoPermissionException();
            }
            return bookingManager.transformBookingStatus(bookingBo, operation, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<BookingBo> queryBooking(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
                throw new NoPermissionException();
            }
            return bookingManager.queryBooking(bookingBo, userBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<BookingHistoryBo> queryHistory(BookingHistoryBo bookingHistoryBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
                throw new NoPermissionException();
            }
            return bookingManager.queryHistory(bookingHistoryBo, partnerBo, userBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<BookingHistoryBo> queryHistoryByBookingId(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
                throw new NoPermissionException();
            }
            return bookingManager.queryHistoryByBookingId(bookingHistoryBo, userBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<BookingBo> queryBookingByPartner(BookingBo bookingBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
                throw new NoPermissionException();
            }
            return bookingManager.queryBookingByPartner(bookingBo, partnerBo, userBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<BookingBo> queryBookingByUser(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
                throw new NoPermissionException();
            }
            return bookingManager.queryBookingByUser(bookingBo, userBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public String changeBookingStatusToPayed(int id) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    /**********************************************************
     * 
     * 关于预约的 Booking
     * 
     **********************************************************/
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "createBookingByUser"));
    // throw new NoPermissionException();
    // }
    // return bookingManager.createBookingByUser(courseBo, bookingBo,
    // commentBookingBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
    // throw exception;
    // }
    // return null;
    // }

    // @Override
    // public BookingBo acceptBookingByPartner(BookingBo bookingBo,
    // CommentBookingAcceptBo commentBookingAcceptBo, UserBo userBo, String
    // permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // return bookingManager.acceptBookingByPartner(bookingBo,
    // commentBookingAcceptBo, userBo);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_ACCEPTBYPARTNER_ERROR);
    // exception.setMessageKey(ManagerErrorCode.BOOKING_ACCEPTBYPARTNER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public BookingBo acceptBookingSucceedByPartner(BookingBo bookinbBo,
    // CommentBookingAcceptSuccessBo commentBookingAcceptSuccessBo, UserBo
    // userBo, String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // return bookingManager.acceptBookingSucceedByPartner(bookinbBo,
    // commentBookingAcceptSuccessBo, userBo);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_ACCEPTSUCCEEDBYPARTNER_ERROR);
    // exception.setMessageKey(ManagerErrorCode.BOOKING_ACCEPTSUCCEEDBYPARTNER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public BookingBo acceptBookingFailedByPartner(BookingBo bookingBo,
    // CommentBookingAcceptFailedBo commentBookingAcceptFailedBo, UserBo userBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // return bookingManager.acceptBookingFailedByPartner(bookingBo,
    // commentBookingAcceptFailedBo, userBo);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_ACCEPTFAILEDBYPARTNER_ERROR);
    // exception.setMessageKey(ManagerErrorCode.BOOKING_ACCEPTFAILEDBYPARTNER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public BookingBo validateBookingByPartner(BookingBo bookingBo,
    // CommentBookingValidateBo commentBookingValidateBo, UserBo userBo, String
    // permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // return bookingManager.validateBookingByPartner(bookingBo,
    // commentBookingValidateBo, userBo);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_VALIDATEBYPARTNER_ERROR);
    // exception.setMessageKey(ManagerErrorCode.BOOKING_VALIDATEBYPARTNER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public BookingBo cancelBookingByUser(BookingBo bookingBo,
    // CommentBookingCancelBo commentBookingCancelBo, UserBo userBo, String
    // permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // return bookingManager.cancelBookingByUser(bookingBo,
    // commentBookingCancelBo, userBo);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_CANCELBYUSER_ERROR);
    // exception.setMessageKey(ManagerErrorCode.BOOKING_CANCELBYUSER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public BookingBo cancelBookingByPartner(BookingBo bookingBo,
    // CommentBookingCancelBo commentBookingCancelBo, UserBo userBo, String
    // permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // return bookingManager.cancelBookingByPartner(bookingBo,
    // commentBookingCancelBo, userBo);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_CANCELBYPARTNER_ERROR);
    // exception.setMessageKey(ManagerErrorCode.BOOKING_CANCELBYPARTNER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public BookingBo cancelBookingByAdmin(BookingBo bookingBo,
    // CommentBookingCancelBo commentBookingCancelBo, UserBo userBo, String
    // permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // return bookingManager.cancelBookingByAdmin(bookingBo,
    // commentBookingCancelBo, userBo);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_CANCELBYADMIN_ERROR);
    // exception.setMessageKey(ManagerErrorCode.BOOKING_CANCELBYADMIN_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public List<BookingBo> queryBooking(BookingBo bookingBo,
    // PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "queryBooking"));
    // throw new NoPermissionException();
    // }
    // return bookingManager.queryBooking(bookingBo, partnerBo, userBo,
    // paginationBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYBOOKING);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYBOOKING_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_NOTFOUND_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.BOOKING_NOTFOUND_ERROR_KEy);
    // throw exception;
    // }
    // return null;
    // }
    //
    // @Override
    // public List<BookingHistoryBo> queryBookingHistory(
    // BookingHistoryBo bookingHistoryBo, PartnerBo partnerBo,
    // UserBo userBo, PaginationBo paginationBo, String permissionTag)
    // throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "queryBookingHistory"));
    // throw new NoPermissionException();
    // }
    // return bookingManager.queryHistory(bookingHistoryBo, partnerBo,
    // userBo, paginationBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYBOOKINGHISTORY);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYBOOKINGHISTORY_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.BOOKING_QUERYHISTORY_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.BOOKING_QUERYHISTORY_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // /**********************************************************
    // *
    // * 关于预订单的 Order
    // *
    // **********************************************************/
    // @Override
    // public OrderBo createOrderByUser(OrderBo orderBo, BookingBo bookingBo,
    // UserBo userBo, WithdrawBo withdrawBo, String permissionTag)
    // throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "createOrderByUser"));
    // throw new NoPermissionException();
    // }
    // return orderManager.createOrderByUser(orderBo, bookingBo, userBo,
    // withdrawBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEORDERBYUSER);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEORDERBYUSER_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.ORDER_CREATEBYUSER_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.ORDER_CREATEBYUSER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public OrderBo acceptOrderByAdmin(OrderBo orderBo,
    // CommentOrderBo commentOrderBo, UserBo userBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "acceptOrderByAdmin"));
    // throw new NoPermissionException();
    // }
    // return orderManager.acceptOrderByAdmin(orderBo,
    // commentOrderBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_ACCEPTORDERBYADMIN);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_ACCEPTORDERBYADMIN_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.ORDER_ACCEPTBYADMIN_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.ORDER_ACCEPTBYADMIN_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public List<OrderBo> queryOrder(OrderBo orderBo, BookingBo bookingBo,
    // UserBo userBo, PaginationBo paginationBo, String permissionTag)
    // throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "queryOrder"));
    // throw new NoPermissionException();
    // }
    // return orderManager.query(orderBo, bookingBo, userBo, paginationBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYORDER);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYORDER_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.ORDER_NOTFOUND_ERROR);
    // exception.setMessageKey(ManagerErrorCode.ORDER_NOTFOUND_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public List<OrderHistoryBo> queryOrderHistory(OrderHistoryBo
    // orderHistory,
    // BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "queryOrderHistory"));
    // throw new NoPermissionException();
    // }
    // return orderManager.queryHistory(orderHistory, bookingBo, userBo,
    // paginationBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYORDERHISTORY);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYORDERHISTORY_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.ORDER_QUERYHISTORY_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.ORDER_QUERYHISTORY_ERROR_KEY);
    // throw exception;
    // }
    // }

}
