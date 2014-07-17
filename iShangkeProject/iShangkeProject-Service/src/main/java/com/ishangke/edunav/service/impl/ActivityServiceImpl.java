package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.ActivityService;
import com.ishangke.edunav.manager.ActivityManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class ActivityServiceImpl implements ActivityService.Iface{
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	private ActivityManager activityManager;
	
	@Override
	public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo,
			PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo,
			TException {
		try{
			return activityManager.cancelActivity(activityBo, partnerBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_CREATE_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo rejectActivity(ActivityBo activityBo,
			PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo,
			TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo cancelActivity(ActivityBo activityBo,
			PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo,
			TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo deleteActivity(ActivityBo activityBo,
			PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo,
			TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityBo> query(ActivityBo activityBo, PartnerBo partnerBo,
			UserBo userBo, PaginationBo paginationBo)
			throws BusinessExceptionBo, TException {
		// TODO Auto-generated method stub
		return null;
	}

}
