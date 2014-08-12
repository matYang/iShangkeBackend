package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.BookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.BookingService;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.OrderManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;
import com.ishangke.edunav.util.PageUtil;

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
    public BookingBo createBookingByUser(BookingBo bookingBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
//            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
//                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
//                throw new NoPermissionException();
//            }
            return bookingManager.createBookingByUser(bookingBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public BookingBo transformBookingStatus(BookingBo bookingBo, int operation, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
//            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
//                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "transformBookingStatus"));
//                throw new NoPermissionException();
//            }
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
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public BookingPageViewBo queryBooking(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
//            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
//                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryBooking"));
//                throw new NoPermissionException();
//            }
            paginationBo = PageUtil.getPage(paginationBo);
            List<BookingBo> data = bookingManager.queryBooking(bookingBo, userBo, paginationBo);
            int total = bookingManager.queryBookingTotal(bookingBo, userBo);
            BookingPageViewBo pageView = new BookingPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setTotal(total);
            pageView.setData(data);
            return pageView;
           
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public BookingHistoryPageViewBo queryHistory(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
//            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
//                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryHistory"));
//                throw new NoPermissionException();
//            }
            paginationBo = PageUtil.getPage(paginationBo);
            List<BookingHistoryBo> data = bookingManager.queryHistory(bookingHistoryBo, userBo, paginationBo);
            int total = bookingManager.queryHistoryTotal(bookingHistoryBo, userBo);
            BookingHistoryPageViewBo pageView = new BookingHistoryPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setTotal(total);
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public BookingHistoryPageViewBo queryHistoryByBookingId(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryHistoryByBookingId"));
                throw new NoPermissionException();
            }
            paginationBo = PageUtil.getPage(paginationBo);
            List<BookingHistoryBo> data = bookingManager.queryHistoryByBookingId(bookingHistoryBo, userBo, paginationBo);
            int total = bookingManager.queryHistoryByBookingIdTotal(bookingHistoryBo, userBo);
            BookingHistoryPageViewBo pageView = new BookingHistoryPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setTotal(total);
            pageView.setData(data);
            return pageView;
           
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

//    @Override
//    public BookingPageViewBo queryBookingByPartner(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo,
//            String permissionTag) throws BusinessExceptionBo, TException {
//        try {
//            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
//                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
//                throw new NoPermissionException();
//            }
//            List<BookingBo> data = bookingManager.queryBookingByPartner(bookingBo, userBo, paginationBo);
//            BookingPageViewBo pageView = new BookingPageViewBo();
//            pageView.setData(data);
//            return pageView;
//            
//        } catch (NoPermissionException e) {
//            LOGGER.info(e.getMessage(), e);
//            BusinessExceptionBo exception = new BusinessExceptionBo();
//            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
//            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
//            throw exception;
//        } catch (ManagerException e) {
//            LOGGER.info(e.getMessage(), e);
//            BusinessExceptionBo exception = new BusinessExceptionBo();
//            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
//            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
//            throw exception;
//        }
//    }
//
//    @Override
//    public BookingPageViewBo queryBookingByUser(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo, String permissionTag)
//            throws BusinessExceptionBo, TException {
//        try {
//            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
//                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
//                throw new NoPermissionException();
//            }
//            List<BookingBo> data = bookingManager.queryBookingByUser(bookingBo, userBo, paginationBo);
//            BookingPageViewBo pageView = new BookingPageViewBo();
//            pageView.setData(data);
//            return pageView;
//           
//        } catch (NoPermissionException e) {
//            LOGGER.info(e.getMessage(), e);
//            BusinessExceptionBo exception = new BusinessExceptionBo();
//            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
//            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
//            throw exception;
//        } catch (ManagerException e) {
//            LOGGER.info(e.getMessage(), e);
//            BusinessExceptionBo exception = new BusinessExceptionBo();
//            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
//            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
//            throw exception;
//        }
//    }

    @Override
    public String changeBookingStatusToPayed(int orderId) throws BusinessExceptionBo, TException {
        try {
            return bookingManager.changeBookingStatusToPayed(orderId);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.BOOKING_CHANGE_STATUS_TO_PAYED_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CHANGE_STATUS_TO_PAYED_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public String verify(String notify_id) throws BusinessExceptionBo, TException {
        try {
            return bookingManager.verify(notify_id);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.ALIPAY_VERIFY_ERROR);
            exception.setMessageKey(ManagerErrorCode.ALIPAY_VERIFY_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public String buildFormForGet(String subject, String out_trade_no, String total_fee) throws BusinessExceptionBo, TException {
        try {
            return bookingManager.buildFormForGet(subject, out_trade_no, total_fee);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.ALIPAY_GET_SUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.ALIPAY_GET_SUBMIT_ERROR_KEY);
            throw exception;
        }
    }
    
    /**
     * 根本永不到了其实。。。
     */
    @Override
    public String buildFormForPost(String subject, String out_trade_no, String total_fee) throws BusinessExceptionBo, TException {
        try {
            return bookingManager.buildFormForPost(subject, out_trade_no, total_fee);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.ALIPAY_GET_SUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.ALIPAY_GET_SUBMIT_ERROR_KEY);
            throw exception;
        }
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
    /**********************************************************
     * 
     * 关于预订单的 Order
     * 
     **********************************************************/
    @Override
    public OrderBo createOrderByUser(OrderBo orderBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            //只有普通用户可以创建支付order
//            if (!permissionManager.hasPermissionByUser(userBo.getId(), permissionTag)) {
//                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createOrderByUser"));
//                throw new NoPermissionException();
//            }
            return orderManager.createOrderByUser(orderBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEORDERBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEORDERBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.ORDER_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.ORDER_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }
    
    @Override
    public OrderBo queryOrderById(OrderBo orderBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createOrderByUser"));
                throw new NoPermissionException();
            }
            return orderManager.queryById(orderBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEORDERBYUSER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEORDERBYUSER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.ORDER_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.ORDER_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }
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

    @Override
    public BookingBo queryBookingById(int id, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
//          if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
//              LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryBooking"));
//              throw new NoPermissionException();
//          }
          BookingBo data = bookingManager.queryBookingById(id, userBo);
          return data;
      } catch (NoPermissionException e) {
          LOGGER.info(e.getMessage(), e);
          BusinessExceptionBo exception = new BusinessExceptionBo();
          exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER);
          exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEBOOKINGBYUSER_KEY);
          throw exception;
      } catch (ManagerException e) {
          LOGGER.info(e.getMessage(), e);
          BusinessExceptionBo exception = new BusinessExceptionBo();
          exception.setMessage(e.getMessage());
          exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
          exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
          throw exception;
      }
    }

}
