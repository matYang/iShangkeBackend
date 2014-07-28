package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CourseService;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CourseManager;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;

@Component
public class CourseServiceImpl implements CourseService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private PermissionManager permissionManager;

    @Autowired
    private CourseManager courseManager;
    
    @Autowired
    private CourseTemplateManager courseTemplateManager;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public CourseBo createCourse(CourseBo courseBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseManager.createCourse(courseBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseCommentBo commentCourse(CourseCommentBo courseCommnet, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseManager.commentCourse(courseCommnet, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseCommentBo> queryCommentBuCourseId(CourseBo courseBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            //不需要权限
            return courseManager.queryCommentBuCourseId(courseBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseCommentBo deleteCommentByCommentId(CourseCommentBo courseCommentBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseManager.deleteCommentByCommentId(courseCommentBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CategoryBo> queryCategoryByKeyword(String keyword, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            //不需要进行权限控制
            return courseManager.queryByKeyword(keyword);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseBo> queryCourseByPartner(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseManager.queryByPartner(courseBo, partnerBo, userBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseBo> queryCourseByFilter(CourseBo courseBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            //不需要进行权限控制
            return courseManager.queryByFilter(courseBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo queryCourseById(CourseBo courseBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseManager.queryById(courseBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo transformCourseStatus(CourseBo courseBo, int operation, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseManager.transformCourseStatus(courseBo, operation, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseTemplateManager.createCourseTemplate(courseTemplateBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo transformCourseTmeplateStatus(CourseTemplateBo courseTemplateBo, int operation, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseTemplateManager.transformCourseTmeplateStatus(courseTemplateBo, operation, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplateByPartnerId(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseTemplateManager.queryCourseTemplateByPartnerId(courseTemplateBo, partnerBo, userBo, paginationBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourse"));
                throw new NoPermissionException();
            }
            return courseTemplateManager.queryCourseTemplateById(courseTemplateBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }
    /**********************************************************
     * 
     * 关于课程的 Course
     * 
     **********************************************************/
    // @Override
    // public CourseBo createCourse(CourseTemplateBo courseTemplateBo,
    // CourseBo courseBo, PartnerBo partnerBo, UserBo userBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "createCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.createCourse(courseTemplateBo, courseBo,
    // partnerBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CREATECOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo submitCourse(CourseBo courseBo, PartnerBo partnerBo,
    // UserBo userBo, String permissionTag) throws BusinessExceptionBo,
    // TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "submitCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.submitCourse(courseBo, partnerBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_SUBMITCOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_SUBMITCOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_SUBMIT_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_SUBMIT_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo approveCourse(CourseBo courseBo, PartnerBo partnerBo,
    // CommentCourseApproveBo commentCourseApproveBo, UserBo userBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "approveCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.approveCourse(courseBo, partnerBo,
    // commentCourseApproveBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_APPROVECOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_APPROVECOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_APPROVE_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_APPROVE_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo rejectCourse(CourseBo courseBo, PartnerBo partnerBo,
    // CommentCourseRejectBo commentCourseRejectBo, UserBo userBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "rejectCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.rejectCourse(courseBo, partnerBo,
    // commentCourseRejectBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_REJECTCOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_REJECTCOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_REJECT_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_REJECT_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo cancelCourse(CourseBo courseBo, PartnerBo partnerBo,
    // UserBo userBo, String permissionTag) throws BusinessExceptionBo,
    // TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "cancelCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.cancelCourse(courseBo, partnerBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_CANCELCOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_CANCELCOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_CANCEL_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_CANCEL_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo resubmitCourse(CourseBo courseBo, PartnerBo partnerBo,
    // UserBo userBo, String permissionTag) throws BusinessExceptionBo,
    // TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "resubmitCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.resubmitCourse(courseBo, partnerBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_REAUBMITCOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_RESUBMITCOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_RESUBMIT_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_RESUBMIT_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo deleteCourse(CourseBo courseBo, PartnerBo partnerBo,
    // UserBo userBo, String permissionTag) throws BusinessExceptionBo,
    // TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "deleteCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.deleteCourse(courseBo, partnerBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_DELETECOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_DELETECOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_DELETE_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_DELETE_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo updateCourse(CourseBo courseBo, PartnerBo partnerBo,
    // UserBo userBo, String permissionTag) throws BusinessExceptionBo,
    // TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "updateCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.updateCourse(courseBo, partnerBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_UPDATECOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_UPDATECOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_UPDATE_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_UPDATE_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo commentCourse(CourseBo courseBo,
    // CommentCourseBo commentCourseBo, PartnerBo partnerBo,
    // UserBo userBo, String permissionTag) throws BusinessExceptionBo,
    // TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "commentCourse"));
    // throw new NoPermissionException();
    // }
    // return courseManager.commentCourse(courseBo, commentCourseBo,
    // partnerBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_COMMENTCOURSE);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_COMMENTCOURSE_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_COMMENT_ERROR);
    // exception.setMessageKey(ManagerErrorCode.COURSE_COMMENT_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public List<CourseBo> queryCourseByKeyword(String keyword,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    //
    // return courseManager.queryByKeyword(keyword);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.COURSE_QUERYBYKEYWORD_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.COURSE_QUERYBYKEYWORD_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public List<CourseBo> queryCourseByPartner(CourseBo courseBo,
    // PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "queryCourseByPartner"));
    // throw new NoPermissionException();
    // }
    // return courseManager.queryByPartner(courseBo, partnerBo, userBo,
    // paginationBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYCOURSEBYPARTNER);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYCOURSEBYPARTNER_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.COURSE_QUERYBYPARTNER_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.COURSE_QUERYBYPARTNER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public List<CourseBo> queryCourseByFilter(CourseBo courseBo,
    // CategoryBo categoryBo, LocationBo locationBo, CircleBo circleBo,
    // PaginationBo paginationBo, String permissionTag)
    // throws BusinessExceptionBo, TException {
    // try {
    // return courseManager.queryByFilter(courseBo, categoryBo,
    // locationBo, circleBo, paginationBo);
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_QUERYBYFILTER_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.COURSE_QUERYBYFILTER_ERROR_KEY);
    // throw exception;
    // }
    // }
    //
    // @Override
    // public CourseBo queryCourseById(CourseBo courseBo, UserBo userBo,
    // String permissionTag) throws BusinessExceptionBo, TException {
    // try {
    // if (!permissionManager.hasPermissionByUser(userBo.getId(),
    // permissionTag)) {
    // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
    // userBo.getId(), permissionTag, "queryCourseById"));
    // throw new NoPermissionException();
    // }
    // return courseManager.queryById(courseBo, userBo);
    // } catch (NoPermissionException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception
    // .setErrorCode(ManagerErrorCode.PERMISSION_BOOKING_QUERYCOURSEBYID);
    // exception
    // .setMessageKey(ManagerErrorCode.PERMISSION_BOOKING_QUERYCOURSEBYID_KEY);
    // throw exception;
    // } catch (ManagerException e) {
    // LOGGER.info(e.getMessage(), e);
    // BusinessExceptionBo exception = new BusinessExceptionBo();
    // exception.setErrorCode(ManagerErrorCode.COURSE_QUERYBYID_ERROR);
    // exception
    // .setMessageKey(ManagerErrorCode.COURSE_QUERYBYID_ERROR_KEY);
    // throw exception;
    // }
    // }

}
