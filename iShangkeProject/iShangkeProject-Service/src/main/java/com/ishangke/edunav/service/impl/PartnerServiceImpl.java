package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.PartnerService;
import com.ishangke.edunav.manager.ActivityManager;
import com.ishangke.edunav.manager.AddressManager;
import com.ishangke.edunav.manager.ClassPhotoManager;
import com.ishangke.edunav.manager.PartnerManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.TeacherManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;

public class PartnerServiceImpl implements PartnerService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerServiceImpl.class);

    @Autowired
    private PartnerManager partnerManager;
    @Autowired
    private AddressManager addressManager;
    @Autowired
    private ClassPhotoManager classPhotoManager;
    @Autowired
    private TeacherManager teacherManager;
    @Autowired
    private ActivityManager activityManager;
    @Autowired
    private PermissionManager permissionManager;

    
    
    
    /**********************************************************
    *
    *   关于合作商的 PartnerService
    *
    **********************************************************/
    @Override
    public List<PartnerBo> queryPartner(PartnerBo partnerBo, PaginationBo paginationBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryPartner"));
                throw new NoPermissionException();
            }
            
            return partnerManager.query(partnerBo, paginationBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_QUERYPARTNER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_QUERYPARTNER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PARTNER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.PARTNER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PartnerBo queryPartnerById(PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryPartnerById"));
                throw new NoPermissionException();
            }
            
            return partnerManager.queryById(partnerBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_QUERYPARTNERBYID);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_QUERYPARTNERBYID_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PARTNER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.PARTNER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PartnerBo updatePartner(PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "updatePartner"));
                throw new NoPermissionException();
            }
            
            return partnerManager.updatePartner(partnerBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_UPDATEPARTNER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_UPDATEPARTNER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PARTNER_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.PARTNER_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PartnerBo createPartner(PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return partnerManager.createPartner(partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PARTNER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.PARTNER_CREATE_ERROR_KEY);
            throw exception;
        }
    }
    
    
    
    
    /**********************************************************
    *
    *   关于地址的 Address
    *
    **********************************************************/
    @Override
    public AddressBo createAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return addressManager.createAddress(addressBo, userBo, partnerBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AddressBo updateAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return addressManager.updateAddress(addressBo, userBo, partnerBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AddressBo deleteAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return addressManager.deleteAddress(addressBo, userBo, partnerBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<AddressBo> queryAddress(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return addressManager.query(addressBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }
    
    
    
    
    /**********************************************************
    *
    *   关于机构照片的 ClassPhoto
    *
    **********************************************************/
    @Override
    public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return classPhotoManager.createClassPhoto(classPhotoBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return classPhotoManager.updateClassPhoto(classPhotoBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return classPhotoManager.deleteClassPhoto(classPhotoBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<ClassPhotoBo> queryClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return classPhotoManager.query(classPhotoBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }
    
    
    
    
    
    /**********************************************************
    *
    *   关于教师照片的 TeacherPhoto
    *
    **********************************************************/
    @Override
    public TeacherBo createTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return teacherManager.createTeacher(teacherBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public TeacherBo updateTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return teacherManager.updateTeacher(teacherBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public TeacherBo deleteTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return teacherManager.deleteTeacher(teacherBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<TeacherBo> queryTeacher(TeacherBo teacherBo, UserBo userBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return teacherManager.query(teacherBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }
    
    
    
    

    /**********************************************************
    *
    *   关于活动的 Activity
    *
    **********************************************************/
    @Override
    public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
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
    public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
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
    public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException { 
        
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
    public ActivityBo rejectActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
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
    public ActivityBo cancelActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
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
    public ActivityBo deleteActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
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
    public List<ActivityBo> queryActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
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
