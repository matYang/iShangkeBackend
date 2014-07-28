package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.commoncontract.model.ActivityPageViewBo;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.AddressPageViewBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoPageViewBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PartnerPageViewBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.TeacherPageViewBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.PartnerService;
import com.ishangke.edunav.manager.ActivityManager;
import com.ishangke.edunav.manager.AddressManager;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.ClassPhotoManager;
import com.ishangke.edunav.manager.PartnerManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.TeacherManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;

@Component
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
    @Autowired
    private AuthManager authManager;

    /**********************************************************
     * 
     * 关于合作商的 PartnerService
     * 
     **********************************************************/
    @Override
    public PartnerPageViewBo queryPartner(PartnerBo partnerBo, PaginationBo paginationBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {

        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "queryPartner"));
                throw new NoPermissionException();
            }
            List<PartnerBo> data = partnerManager.query(partnerBo, paginationBo, userBo);
            PartnerPageViewBo pageView = new PartnerPageViewBo();
            pageView.setData(data);
            return pageView;

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
    public PartnerBo queryPartnerById(PartnerBo partnerBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "queryPartnerById"));
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
    public PartnerBo updatePartner(PartnerBo partnerBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "updatePartner"));
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
    public PartnerBo createPartner(PartnerBo partnerBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "createPartner"));
                throw new NoPermissionException();
            }

            return partnerManager.createPartner(partnerBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_CREATEPARTNER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_CREATEPARTNER_KEY);
            throw exception;
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
     * 关于地址的 Address
     * 
     **********************************************************/
    @Override
    public AddressBo createAddress(AddressBo addressBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "createAddress"));
                throw new NoPermissionException();
            }
            return addressManager.createAddress(addressBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_CREATEADDRESS);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_CREATEADDRESS_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AddressBo updateAddress(AddressBo addressBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "updateAddress"));
                throw new NoPermissionException();
            }
            return addressManager.updateAddress(addressBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_UPDATEADDRESS);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_UPDATEADDRESS_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AddressBo deleteAddress(AddressBo addressBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "deleteAddress"));
                throw new NoPermissionException();
            }
            return addressManager.deleteAddress(addressBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_DELETEADDRESS);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_DELETEADDRESS_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AddressPageViewBo queryAddress(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "queryAddress"));
                throw new NoPermissionException();
            }
            List<AddressBo> data = addressManager.query(addressBo, userBo, paginationBo);
            AddressPageViewBo pageView = new AddressPageViewBo();
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_QUERYADDRESS);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_QUERYADDRESS_KEY);
            throw exception;
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
     * 关于机构照片的 ClassPhoto
     * 
     **********************************************************/
    @Override
    public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "createClassPhoto"));
                throw new NoPermissionException();
            }
            return classPhotoManager.createClassPhoto(classPhotoBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_CREATECLASSPHOTO);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_CREATECLASSPHOTO_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "updateClassPhoto"));
                throw new NoPermissionException();
            }
            return classPhotoManager.updateClassPhoto(classPhotoBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_UPDATECLASSPHOTO);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_UPDATECLASSPHOTO_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "deleteClassPhoto"));
                throw new NoPermissionException();
            }
            return classPhotoManager.deleteClassPhoto(classPhotoBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_DELETECLASSPHOTO);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_DELETECLASSPHOTO_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ClassPhotoPageViewBo queryClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "queryClassPhoto"));
                throw new NoPermissionException();
            }
            List<ClassPhotoBo> data = classPhotoManager.query(classPhotoBo, userBo, paginationBo);
            ClassPhotoPageViewBo pageView = new ClassPhotoPageViewBo();
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_QUERYCLASSPHOTO);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_QUERYCLASSPHOTO_KEY);
            throw exception;
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
     * 关于教师照片的 TeacherPhoto
     * 
     **********************************************************/
    @Override
    public TeacherBo createTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "createTeacher"));
                throw new NoPermissionException();
            }
            return teacherManager.createTeacher(teacherBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_CREATETEACHER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_CREATETEACHER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public TeacherBo updateTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "updateTeacher"));
                throw new NoPermissionException();
            }
            return teacherManager.updateTeacher(teacherBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_UPDATETEACHER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_UPDATETEACHER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public TeacherBo deleteTeacher(TeacherBo teacherBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "deleteTeacher"));
                throw new NoPermissionException();
            }
            return teacherManager.deleteTeacher(teacherBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_DELETETEACHER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_DELETETEACHER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public TeacherPageViewBo queryTeacher(TeacherBo teacherBo, UserBo userBo, PaginationBo paginationBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "queryTeacher"));
                throw new NoPermissionException();
            }
            List<TeacherBo> data = teacherManager.query(teacherBo, userBo, paginationBo);
            TeacherPageViewBo pageView = new TeacherPageViewBo();
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_QUERYTEACHER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_QUERYTEACHER_KEY);
            throw exception;
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
     * 关于活动的 Activity
     * 
     **********************************************************/
    @Override
    public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "createActivity"));
                throw new NoPermissionException();
            }
            return activityManager.cancelActivity(activityBo, partnerBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_CREATEACTIVITY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_CREATEACTIVITY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "submitActivity"));
                throw new NoPermissionException();
            }
            return activityManager.submitActivity(activityBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_SUBMITACTIVITY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_SUBMITACTIVITY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_SUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_SUBMIT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {

        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "approveActivity"));
                throw new NoPermissionException();
            }
            return activityManager.approveActivity(activityBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_APPROVEACTIVITY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_APPROVEACTIVITY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_APPROVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_APPROVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo rejectActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "rejectActivity"));
                throw new NoPermissionException();
            }
            return activityManager.rejectActivity(activityBo, partnerBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_REJECTACTIVITY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_REJECTACTIVITY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_REJECT_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_REJECT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo cancelActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "cancelActivity"));
                throw new NoPermissionException();
            }
            return activityManager.cancelActivity(activityBo, partnerBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_CANCELACTIVITY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_CANCELACTIVITY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_CANCEL_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_CANCEL_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityBo deleteActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "deleteActivity"));
                throw new NoPermissionException();
            }
            return activityManager.deleteActivity(activityBo, partnerBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_DELETEACTIVITY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_DELETEACTIVITY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public ActivityPageViewBo queryActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo,
            PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag,
                        "queryActivity"));
                throw new NoPermissionException();
            }
            List<ActivityBo> data = activityManager.query(activityBo, partnerBo, userBo, paginationBo);
            ActivityPageViewBo pageView = new ActivityPageViewBo();
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_PARTNER_QUERYACTIVITY);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_PARTNER_QUERYACTIVITY_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ACTIVITY_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.ACTIVITY_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
