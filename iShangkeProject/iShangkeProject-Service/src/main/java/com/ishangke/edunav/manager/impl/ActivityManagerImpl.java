package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.ActivityManager;

public class ActivityManagerImpl implements ActivityManager{
	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityManagerImpl.class);
	
	@Override
	public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo,
			PartnerBo partnerBo, UserBo userBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo rejectActivity(ActivityBo activityBo,
			PartnerBo partnerBo, UserBo userBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo cancelActivity(ActivityBo activityBo,
			PartnerBo partnerBo, UserBo userBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivityBo deleteActivity(ActivityBo activityBo,
			PartnerBo partnerBo, UserBo userBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityBo> query(ActivityBo activityBo, PartnerBo partnerBo,
			UserBo userBo, PaginationBo paginationBo) {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
