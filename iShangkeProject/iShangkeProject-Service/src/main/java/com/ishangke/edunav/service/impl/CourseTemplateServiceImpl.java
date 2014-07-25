package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CourseTemplateService;
import com.ishangke.edunav.manager.CourseCommentManager;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;

@Component
public class CourseTemplateServiceImpl implements CourseTemplateService.Iface {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CourseTemplateServiceImpl.class);

    @Autowired
    private CourseTemplateManager courseTemplateManager;
    @Autowired
    private CourseCommentManager courseCommentManager;
    @Autowired
    private PermissionManager permissionManager;

    /**********************************************************
     * 
     * 关于课程模板的 CourseTemplate
     * 
     **********************************************************/
    @Override
    public CourseTemplateBo createCourseTemplate(
            CourseTemplateBo courseTemplateBo, PartnerBo partnerBo,
            UserBo userBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        userBo.getId(), permissionTag, "createCourseTemplate"));
                throw new NoPermissionException();
            }
            return courseTemplateManager.createCourseTemplate(courseTemplateBo,
                    partnerBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.PERMISSION_COURSETEMPLATE_CREATECOURSETEMPLATE);
            exception
                    .setMessageKey(ManagerErrorCode.PERMISSION_COURSETEMPLATE_CREATECOURSETEMPLATE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.COURSETEMPLATE_CREATE_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.COURSETEMPLATE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    /**********************************************************
     * 
     * 关于课程评论的 CourseComment
     * 
     **********************************************************/
    @Override
    public CourseCommentBo createCourseComment(CourseCommentBo courseCommentBo,
            CourseTemplateBo courseTemplateBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        userBo.getId(), permissionTag, "createCourseComment"));
                throw new NoPermissionException();
            }
            return courseCommentManager.createCourseComment(courseCommentBo,
                    courseTemplateBo, userBo);
        }catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.PERMISSION_COURSETEMPLATE_CREATECOURSECOMMENT);
            exception
                    .setMessageKey(ManagerErrorCode.PERMISSION_COURSETEMPLATE_CREATECOURSECOMMENT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSECOMMENT_CREATE_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.COURSECOMMENT_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseCommentBo deleteCourseComment(CourseCommentBo courseCommentBo,
            CourseTemplateBo courseTemplateBo, UserBo userBo,
            String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        userBo.getId(), permissionTag, "deleteCourseComment"));
                throw new NoPermissionException();
            }
            return courseCommentManager.deleteCourseComment(courseCommentBo,
                    courseTemplateBo, userBo);
        }catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.PERMISSION_COURSETEMPLATE_DELETECOURSECOMMENT);
            exception
                    .setMessageKey(ManagerErrorCode.PERMISSION_COURSETEMPLATE_DELETECOURSECOMMENT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSECOMMENT_DELETE_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.COURSECOMMENT_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<CourseCommentBo> queryCourseComment(
            CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo,
            UserBo userBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByUser(userBo.getId(),
                    permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
                        userBo.getId(), permissionTag, "queryCourseComment"));
                throw new NoPermissionException();
            }
            return courseCommentManager.query(courseCommentBo,
                    courseTemplateBo, userBo, paginationBo);
        }catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.PERMISSION_COURSETEMPLATE_QUERYCOURSECOMMENT);
            exception
                    .setMessageKey(ManagerErrorCode.PERMISSION_COURSETEMPLATE_QUERYCOURSECOMMENT_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception
                    .setErrorCode(ManagerErrorCode.COURSECOMMENT_NOTFOUND_ERROR);
            exception
                    .setMessageKey(ManagerErrorCode.COURSECOMMENT_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo deleteCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseTemplateBo updateCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, PartnerBo partnerBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

}
