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
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityPageViewBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PurposeCourseBo;
import com.ishangke.edunav.commoncontract.model.PurposeCoursePageViewBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.BookingService;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.GroupBuyManager;
import com.ishangke.edunav.manager.OrderManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.PurposeCourseManager;
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

    @Autowired
    private PurposeCourseManager purposeManager;
    
    @Autowired
    private GroupBuyManager groupBuyManager;

    @Override
    public BookingBo createBookingByUser(BookingBo bookingBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createBookingByUser"));
                throw new NoPermissionException();
            }
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
    public BookingBo createBookingByAnonymousUser(BookingBo bookingBo) throws BusinessExceptionBo, TException {
        try {
            return bookingManager.createBookingByAnonymousUser(bookingBo);
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
    public BookingBo transformBookingStatus(BookingBo bookingBo, int operation, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "transformBookingStatus"));
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
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public BookingPageViewBo queryBooking(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryBooking"));
                throw new NoPermissionException();
            }
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
    public BookingHistoryPageViewBo queryHistory(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryHistory"));
                throw new NoPermissionException();
            }
            paginationBo = PageUtil.getPage(paginationBo);
            List<BookingHistoryBo> data = null;
            if (bookingHistoryBo.getBookingId() > 0) {
                data = bookingManager.queryHistoryByBookingId(bookingHistoryBo, userBo, paginationBo);
            } else {
                data = bookingManager.queryHistory(bookingHistoryBo, userBo, paginationBo);
            }
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
    public BookingHistoryPageViewBo queryHistoryByBookingId(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
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

    @Override
    public String changeBookingStatusToPayed(int bookingId, String trade_no) throws BusinessExceptionBo, TException {
        try {
            return bookingManager.changeBookingStatusToPayed(bookingId, trade_no);
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
    public String buildFormForGet(String subject, String out_trade_no, String total_fee, String type) throws BusinessExceptionBo, TException {
        try {
            return bookingManager.buildFormForGet(subject, out_trade_no, total_fee, type);
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
     * 关于预订单的 Order
     * 
     **********************************************************/
    @Override
    public OrderBo createOrderByUser(OrderBo orderBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // 只有普通用户可以创建支付order
            if (!permissionManager.hasPermissionByUser(userBo.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createOrderByUser"));
                throw new NoPermissionException();
            }
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

    @Override
    public BookingBo queryBookingById(int id, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryBooking"));
                throw new NoPermissionException();
            }
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

    /**********************************************************
     * 
     * 关于意向课程 PurposeCourse
     * 
     **********************************************************/
    @Override
    public PurposeCoursePageViewBo queryPurpose(PurposeCourseBo purposeCourseBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryPurposeCourse"));
                throw new NoPermissionException();
            }

            paginationBo = PageUtil.getPage(paginationBo);
            List<PurposeCourseBo> list = purposeManager.query(purposeCourseBo, userBo, paginationBo);
            PurposeCoursePageViewBo pageView = new PurposeCoursePageViewBo();
            int total = purposeManager.queryTotal(purposeCourseBo, userBo);
            pageView.setCount(paginationBo.getSize());
            pageView.setStart(paginationBo.getOffset());
            pageView.setTotal(total);
            pageView.setData(list);

            return pageView;
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYPURPOSECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYPURPOSECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PurposeCourseBo createPurpose(PurposeCourseBo purposeCourseBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return purposeManager.createPurpose(purposeCourseBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEPURPOSECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEPURPOSECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PurposeCourseBo updatePurpose(PurposeCourseBo purposeCourseBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "updatePurposeCourse"));
                throw new NoPermissionException();
            }

            return purposeManager.updatePurpose(purposeCourseBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_UPDATEPURPOSECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_UPDATEPURPOSECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PurposeCourseBo deletePurpose(PurposeCourseBo purposeCourseBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "deletePurposeCourse"));
                throw new NoPermissionException();
            }

            return purposeManager.deletePurpose(purposeCourseBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_DELETEPURPOSECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_DELETEPURPOSECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }
    /*********************************************************
     *
     *   关于团购课程  GroupBuy
     *
     *********************************************************/
    @Override
    public GroupBuyActivityBo createGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try{
            /*if(!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)){
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(),permissionTag,"createGroupBuyActivity"));
                throw new NoPermissionException();
            }*/
            return groupBuyManager.createGroupBuyActivity(groupBuyActivityBo, userBo);
        }catch(NoPermissionException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEGROUPBUYACTIVITY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEGROUPBUYACTIVITY_KEY);
            throw exception;
        }catch(ManagerException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public GroupBuyBookingBo createGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try{
            /*if(!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)){
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(),permissionTag,"createGroupBuyBooking"));
                throw new NoPermissionException();
            }*/
            return groupBuyManager.createGroupBuyBooking(groupBuyBookingBo, userBo);
        }catch(NoPermissionException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATEGROUPBUYBOOKING);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATEGROUPBUYBOOKING_KEY);
            throw exception;
        }catch(ManagerException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public GroupBuyBookingPageViewBo queryGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try{
            /*if(!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)){
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(),permissionTag,"createGroupBuyBooking"));
                throw new NoPermissionException();
            }*/
            
            paginationBo = PageUtil.getPage(paginationBo);
            List<GroupBuyBookingBo> list = groupBuyManager.queryGroupBuyBooking(groupBuyBookingBo, userBo, paginationBo);
            GroupBuyBookingPageViewBo pageView = new GroupBuyBookingPageViewBo();
            int total = groupBuyManager.queryGroupBuyBookingTotal(groupBuyBookingBo, userBo);
            pageView.setCount(paginationBo.getSize());
            pageView.setStart(paginationBo.getOffset());
            pageView.setTotal(total);
            pageView.setData(list);
            return pageView;
        }catch(NoPermissionException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYGROUPBUYBOOKING);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYGROUPBUYBOOKING_KEY);
            throw exception;
        }catch(ManagerException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }
    
    @Override
    public GroupBuyActivityPageViewBo queryGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        try{
            /*if(!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)){
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(),permissionTag,"createGroupBuyBooking"));
                throw new NoPermissionException();
            }*/
            
            paginationBo = PageUtil.getPage(paginationBo);
            List<GroupBuyActivityBo> list = groupBuyManager.queryGroupBuyActivity(groupBuyActivityBo, paginationBo);
            GroupBuyActivityPageViewBo pageView = new GroupBuyActivityPageViewBo();
            int total = groupBuyManager.queryGroupBuyActivityTotal(groupBuyActivityBo);
            pageView.setCount(paginationBo.getSize());
            pageView.setStart(paginationBo.getOffset());
            pageView.setTotal(total);
            pageView.setData(list);
            return pageView;
        }catch(NoPermissionException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYGROUPBUYBOOKING);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYGROUPBUYBOOKING_KEY);
            throw exception;
        }catch(ManagerException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }
    
    @Override
    public GroupBuyActivityBo online(GroupBuyActivityBo groupBuyActivityBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try{
            /*if(!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)){
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(),permissionTag,"createGroupBuyActivity"));
                throw new NoPermissionException();
            }*/
            return groupBuyManager.online(groupBuyActivityBo, userBo);
        }catch(NoPermissionException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_GROUPBUYACTIVITYONLINE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_GROUPBUYACTIVITYONLINE_KEY);
            throw exception;
        }catch(ManagerException e){
            LOGGER.info(e.getMessage(),e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public GroupBuyActivityBo queryGroupBuyActivityById(int id) throws BusinessExceptionBo, TException {
        try {
            GroupBuyActivityBo data = groupBuyManager.queryGroupBuyActivityById(id);
            return data;
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYGROUPBUYACTIVITYBYID);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYGROUPBUYACTIVITYBYID_KEY);
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
    public GroupBuyBookingBo queryGroupBuyBookingById(int id, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryGroupBuyBooking"));
                throw new NoPermissionException();
            }
            GroupBuyBookingBo data = groupBuyManager.queryGroupBuyBookingById(id, userBo);
            return data;
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYGROUPBUYBOOKINGBYID);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYGROUPBUYBOOKINGBYID_KEY);
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

    public String changeGroupBuyBookingStatusToPayed(int bookingId, String trade_no) throws BusinessExceptionBo, TException {
        try {
            return groupBuyManager.changeGroupBuyBookingStatusToPayed(bookingId, trade_no);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.BOOKING_CHANGE_STATUS_TO_PAYED_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CHANGE_STATUS_TO_PAYED_ERROR_KEY);
            throw exception;
        }
    }
}
