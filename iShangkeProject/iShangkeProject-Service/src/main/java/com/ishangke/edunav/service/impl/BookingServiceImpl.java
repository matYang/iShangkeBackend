package com.ishangke.edunav.service.impl;
import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
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
import com.ishangke.edunav.commoncontract.service.BookingService;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class BookingServiceImpl implements BookingService.Iface{
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private BookingManager bookingManager;
	
	@Override
	public BookingBo createBookingByUser(CourseBo courseBo,
			BookingBo bookingBo, CommentBookingCreateBo commentBookingCreateBo,
			UserBo userBo) throws BusinessExceptionBo, TException {
		try{
			return bookingManager.createBookingByUser(courseBo, bookingBo, commentBookingCreateBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CREATEBYUSER_ERROR_KEY);
            throw exception;
		}
		
	}

	@Override
	public BookingBo acceptBookingByPartner(BookingBo bookingBo,
			CommentBookingAcceptBo commentBookingAcceptBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return bookingManager.acceptBookingByPartner(bookingBo, commentBookingAcceptBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_ACCEPTBYPARTNER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_ACCEPTBYPARTNER_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public BookingBo acceptBookingSucceedByPartner(BookingBo bookinbBo,
			CommentBookingAcceptSuccessBo commentBookingAcceptSuccessBo,
			UserBo userBo) throws BusinessExceptionBo, TException {
		try{
			return bookingManager.acceptBookingSucceedByPartner(bookinbBo, commentBookingAcceptSuccessBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_ACCEPTSUCCEEDBYPARTNER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_ACCEPTSUCCEEDBYPARTNER_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public BookingBo acceptBookingFailedByPartner(BookingBo bookingBo,
			CommentBookingAcceptFailedBo commentBookingAcceptFailedBo,
			UserBo userBo) throws BusinessExceptionBo, TException {
		try{
			return bookingManager.acceptBookingFailedByPartner(bookingBo, commentBookingAcceptFailedBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_ACCEPTFAILEDBYPARTNER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_ACCEPTFAILEDBYPARTNER_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public BookingBo validateBookingByPartner(BookingBo bookingBo,
			CommentBookingValidateBo commentBookingValidateBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return bookingManager.validateBookingByPartner(bookingBo, commentBookingValidateBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_VALIDATEBYPARTNER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_VALIDATEBYPARTNER_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public BookingBo cancelBookingByUser(BookingBo bookingBo,
			CommentBookingCancelBo commentBookingCancelBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return bookingManager.cancelBookingByUser(bookingBo, commentBookingCancelBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CANCELBYUSER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CANCELBYUSER_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public BookingBo cancelBookingByPartner(BookingBo bookingBo,
			CommentBookingCancelBo commentBookingCancelBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return bookingManager.cancelBookingByPartner(bookingBo, commentBookingCancelBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CANCELBYPARTNER_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CANCELBYPARTNER_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public BookingBo cancelBookingByAdmin(BookingBo bookingBo,
			CommentBookingCancelBo commentBookingCancelBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return bookingManager.cancelBookingByAdmin(bookingBo, commentBookingCancelBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_CANCELBYADMIN_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_CANCELBYADMIN_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public List<BookingBo> query(BookingBo bookingBo, PartnerBo partnerBo,
			UserBo userBo, PaginationBo paginationBo)
			throws BusinessExceptionBo, TException {
		try{
			return bookingManager.queryBooking(bookingBo, partnerBo, userBo, paginationBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_QUERY_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_QUERY_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public BookingBo queryHistory(BookingHistoryBo bookingHistoryBo,
			PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo)
			throws BusinessExceptionBo, TException {
		try{
			return bookingManager.queryHistory(bookingHistoryBo, partnerBo, userBo, paginationBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.BOOKING_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.BOOKING_QUERYHISTORY_ERROR_KEY);
            throw exception;
		}
	}

}
