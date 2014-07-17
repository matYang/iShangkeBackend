package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CouponService;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CouponServiceImpl implements CouponService.Iface{
	private static final Logger LOGGER = LoggerFactory.getLogger(CouponServiceImpl.class);
	
	@Autowired
	private CouponManager couponManager;

	@Override
	public CouponBo createCoupon(CouponBo couponBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return couponManager.createCoupon(couponBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COUPON_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_CREATE_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public List<CouponBo> query(CouponBo couponBo, UserBo userBo,
			PaginationBo paginationBo) throws BusinessExceptionBo, TException {
		try{
			return couponManager.query(couponBo, userBo, paginationBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COUPON_QUERY_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_QUERY_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public List<CouponBo> queryHistory(CouponHistoryBo couponHistoryBo,
			UserBo userBo, PaginationBo paginationBo)
			throws BusinessExceptionBo, TException {
		try{
			return couponManager.queryHistory(couponHistoryBo, userBo, paginationBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COUPON_QUERYHISTORY_ERROR);
            exception.setMessageKey(ManagerErrorCode.COUPON_QUERYHISTORY_ERROR_KEY);
            throw exception;
		}
	}

	
	
	
}
