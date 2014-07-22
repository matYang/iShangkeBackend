package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CourseService;
import com.ishangke.edunav.manager.CourseManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CourseServiceImpl implements CourseService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseManager courseManager;
    
    
    
    /**********************************************************
    *
    *   关于课程的 Course
    *
    **********************************************************/

    @Override
    public CourseBo createCourse(CourseTemplateBo courseTemplateBo, CourseBo courseBo, PartnerBo partnerBo,
            UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseManager.createCourse(courseTemplateBo, courseBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo submitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return courseManager.submitCourse(courseBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_SUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_SUBMIT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo approveCourse(CourseBo courseBo, PartnerBo partnerBo,
            CommentCourseApproveBo commentCourseApproveBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseManager.approveCourse(courseBo, partnerBo, commentCourseApproveBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_APPROVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_APPROVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo rejectCourse(CourseBo courseBo, PartnerBo partnerBo, CommentCourseRejectBo commentCourseRejectBo,
            UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseManager.rejectCourse(courseBo, partnerBo, commentCourseRejectBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_REJECT_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_REJECT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo cancelCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return courseManager.cancelCourse(courseBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_CANCEL_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CANCEL_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo resubmitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return courseManager.resubmitCourse(courseBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_RESUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_RESUBMIT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo deleteCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return courseManager.deleteCourse(courseBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo updateCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return courseManager.updateCourse(courseBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo commentCourse(CourseBo courseBo, CommentCourseBo commentCourseBo, PartnerBo partnerBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return courseManager.commentCourse(courseBo, commentCourseBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_COMMENT_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_COMMENT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseBo> queryCourseByKeyword(String keyword, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseManager.queryByKeyword(keyword);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_QUERYBYKEYWORD_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_QUERYBYKEYWORD_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseBo> queryCourseByPartner(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo,
            PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseManager.queryByPartner(courseBo, partnerBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_QUERYBYPARTNER_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_QUERYBYPARTNER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseBo> queryCourseByFilter(CourseBo courseBo, CategoryBo categoryBo, LocationBo locationBo,
            CircleBo circleBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseManager.queryByFilter(courseBo, categoryBo, locationBo, circleBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_QUERYBYFILTER_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_QUERYBYFILTER_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo queryCourseById(CourseBo courseBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseManager.queryById(courseBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSE_QUERYBYID_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_QUERYBYID_ERROR_KEY);
            throw exception;
        }
    }

}
