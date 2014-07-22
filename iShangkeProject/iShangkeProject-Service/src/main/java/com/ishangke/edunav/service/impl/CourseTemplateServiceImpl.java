package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CourseTemplateService;
import com.ishangke.edunav.manager.CourseCommentManager;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CourseTemplateServiceImpl implements CourseTemplateService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseTemplateServiceImpl.class);

    @Autowired
    private CourseTemplateManager courseTemplateManager;
    @Autowired
    private CourseCommentManager courseCommentManager;

    
    

    /**********************************************************
    *
    *   关于课程模板的 CourseTemplate
    *
    **********************************************************/

    @Override
    public CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.createCourseTemplate(courseTemplateBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo submitCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.submitCourseTemplate(courseTemplateBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_SUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_SUBMIT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo approveCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, CommentCourseTemplateApproveBo commentCourseTemplateApproveBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.approveCourseTemplate(courseTemplateBo, partnerBo, commentCourseTemplateApproveBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_APPROVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_APPROVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo rejectCourseTemplate(CourseTemplateBo courseTemplateBo, CommentCourseTemplateRejectBo commentCourseTemplateRejectBo, PartnerBo partnerBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.rejectCourseTemplate(courseTemplateBo, commentCourseTemplateRejectBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_REJECT_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_REJECT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo cancelCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.cancelCourseTemplate(courseTemplateBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_CANCEL_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_CANCEL_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo resubmitCourserTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.resubmitCourserTemplate(courseTemplateBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_RESUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_RESUBMIT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo deleteCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.deleteCourseTemplate(courseTemplateBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo updateCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.updateCourseTemplate(courseTemplateBo, partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, PartnerBo partnerBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.queryCourseTemplate(courseTemplateBo, userBo, partnerBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_QUERY_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_QUERY_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseTemplateManager.queryCourseTemplateById(courseTemplateBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSETEMPLATE_QUERY_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSETEMPLATE_QUERY_ERROR_KEY);
            throw exception;
        }
    }
    
    
    
    
    
    /**********************************************************
    *
    *   关于课程评论的 CourseComment
    *
    **********************************************************/
    
    @Override
    public CourseCommentBo createCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseCommentManager.createCourseComment(courseCommentBo, courseTemplateBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSECOMMENT_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSECOMMENT_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseCommentBo deleteCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseCommentManager.deleteCourseComment(courseCommentBo, courseTemplateBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSECOMMENT_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSECOMMENT_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseCommentBo> queryCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return courseCommentManager.query(courseCommentBo, courseTemplateBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSECOMMENT_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSECOMMENT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
