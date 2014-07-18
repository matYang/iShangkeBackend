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

public class ActivityServiceImpl implements ActivityService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Autowired
    private ActivityManager activityManager;

    @Override
    public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return activityManager.cancelActivity(activityBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return activityManager.submitActivity(activityBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_SUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_SUBMIT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return activityManager.approveActivity(activityBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_APPROVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_APPROVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo rejectActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return activityManager.rejectActivity(activityBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_REJECT_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_REJECT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo cancelActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return activityManager.cancelActivity(activityBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_CANCEL_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_CANCEL_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo deleteActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return activityManager.deleteActivity(activityBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<ActivityBo> query(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        try {
            return activityManager.query(activityBo, partnerBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
