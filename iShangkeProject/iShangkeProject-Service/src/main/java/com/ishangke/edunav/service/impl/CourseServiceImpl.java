package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CategoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentPageViewBo;
import com.ishangke.edunav.commoncontract.model.CoursePageViewBo;
import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.commoncontract.model.CoursePromotionPageViewBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplatePageViewBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CourseService;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CourseManager;
import com.ishangke.edunav.manager.CoursePromotionManager;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.NoPermissionException;
import com.ishangke.edunav.util.PageUtil;

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

    @Autowired
    private CoursePromotionManager coursePromotionManager;

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
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_CREATECOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_CREATECOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseCommentBo commentCourse(CourseCommentBo courseCommnet, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "commentCourse"));
                throw new NoPermissionException();
            }
            return courseManager.commentCourse(courseCommnet, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_COMMENTCOURSE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_COMMENTCOURSE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseCommentPageViewBo queryCommentByCourseId(CourseBo courseBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // 不需要权限
            paginationBo = PageUtil.getPage(paginationBo);
            List<CourseCommentBo> data = courseManager.queryCommentByCourseId(courseBo, paginationBo);
            int total = courseManager.queryCommentByCourseIdTotal(courseBo);
            CourseCommentPageViewBo pageView = new CourseCommentPageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_QUERYCOMMENTBYCOURSEID);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_QUERYCOMMENTBYCOURSEID_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseCommentBo deleteCommentByCommentId(CourseCommentBo courseCommentBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "deleteCommentByCommentId"));
                throw new NoPermissionException();
            }
            return courseManager.deleteCommentByCommentId(courseCommentBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_DELETECOMMENTBYCOURSEID);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_DELETECOMMENTBYCOURSEID_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CategoryPageViewBo queryCategoryByKeyword(String keyword, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // 不需要进行权限控制
            List<CategoryBo> data = courseManager.queryCategoryByKeyword(keyword);
            CategoryPageViewBo pageView = new CategoryPageViewBo();
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_QUERYCATEGORYKEYWORD);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_QUERYCATEGORYKEYWORD_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CoursePageViewBo queryCourse(CourseBo courseBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryCourse"));
                throw new NoPermissionException();
            }
            paginationBo = PageUtil.getPage(paginationBo);
            List<CourseBo> data = courseManager.queryCourse(courseBo, userBo, paginationBo);
            int total = courseManager.queryCourseTotal(courseBo, userBo);
            CoursePageViewBo pageView = new CoursePageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSEBYPARTNER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSEBYPARTNER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CoursePageViewBo queryCourseByFilter(CourseBo courseBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // 不需要进行权限控制
            paginationBo = PageUtil.getPage(paginationBo);
            List<CourseBo> data = courseManager.queryCourseByFilter(courseBo, paginationBo);
            int total = courseManager.queryCourseByFilterTotal(courseBo);
            CoursePageViewBo pageView = new CoursePageViewBo();
            pageView.setStart(paginationBo.getOffset());
            pageView.setCount(paginationBo.getSize());
            pageView.setData(data);
            pageView.setTotal(total);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSEBYFILTER);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSEBYFILTER_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo queryCourseById(CourseBo courseBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // 不需要进行权限控制
            return courseManager.queryById(courseBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSEBYID);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSEBYID_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseBo transformCourseStatus(CourseBo courseBo, int operation, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            // if
            // (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()),
            // permissionTag)) {
            // LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]",
            // userBo.getId(), permissionTag, "transformCourseStatus"));
            // throw new NoPermissionException();
            // }
            return courseManager.transformCourseStatus(courseBo, operation, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_TRANSFORMCOURSESTATUS);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_TRANSFORMCOURSESTATUS_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createCourseTemplate"));
                throw new NoPermissionException();
            }
            return courseTemplateManager.createCourseTemplate(courseTemplateBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_CREATECOURSETEMPLATE);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_CREATECOURSETEMPLATE_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo transformCourseTmeplateStatus(CourseTemplateBo courseTemplateBo, int operation, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "transformCourseTmeplateStatus"));
                throw new NoPermissionException();
            }
            return courseTemplateManager.transformCourseTmeplateStatus(courseTemplateBo, operation, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_TRANSFORMCOURSETMEPLATESTATUS);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_TRANSFORMCOURSETMEPLATESTATUS_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplatePageViewBo queryCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryCourseTemplate"));
                throw new NoPermissionException();
            }
            paginationBo = PageUtil.getPage(paginationBo);
            List<CourseTemplateBo> data = courseTemplateManager.queryCourseTemplate(courseTemplateBo, userBo, paginationBo);
            CourseTemplatePageViewBo pageView = new CourseTemplatePageViewBo();
            int total = courseTemplateManager.queryCourseTemplateTotal(courseTemplateBo, userBo);
            pageView.setCount(paginationBo.getSize());
            pageView.setStart(paginationBo.getOffset());
            pageView.setTotal(total);
            pageView.setData(data);
            return pageView;

        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSETEMPLATEBYPARTNERID);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSETEMPLATEBYPARTNERID_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CourseTemplateBo queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryCourseTemplateById"));
                throw new NoPermissionException();
            }
            return courseTemplateManager.queryCourseTemplateById(courseTemplateBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSETEMPLATEBYID);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_QUERYCOURSETEMPLATEBYID_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CoursePromotionPageViewBo queryPromotion(CoursePromotionBo coursePromotionBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "queryCoursePromotion"));
                throw new NoPermissionException();
            }

            paginationBo = PageUtil.getPage(paginationBo);
            List<CoursePromotionBo> data = coursePromotionManager.query(coursePromotionBo, userBo, paginationBo);
            CoursePromotionPageViewBo pageView = new CoursePromotionPageViewBo();
            int total = coursePromotionManager.queryTotal(coursePromotionBo, userBo);
            pageView.setCount(paginationBo.getSize());
            pageView.setStart(paginationBo.getOffset());
            pageView.setTotal(total);
            pageView.setData(data);

            return pageView;
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_QUERYPROMOTION);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_QUERYPROMOTION_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CoursePromotionBo createPromotion(CoursePromotionBo coursePromotionBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "createPromotion"));
                throw new NoPermissionException();
            }

            return coursePromotionManager.createPromotion(coursePromotionBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_CREATEPROMOTION);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_CREATEPROMOTION_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CoursePromotionBo updatePromotion(CoursePromotionBo coursePromotionBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "updatePromotion"));
                throw new NoPermissionException();
            }

            return coursePromotionManager.updatePromotion(coursePromotionBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_UPDATEPROMOTION);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_UPDATEPROMOTION_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public CoursePromotionBo deletePromotion(CoursePromotionBo coursePromotionBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            if (!permissionManager.hasPermissionByRole(authManager.getRoleId(userBo.getId()), permissionTag)) {
                LOGGER.info(String.format("[UserId: %s][Tag: %s][Method: %s]", userBo.getId(), permissionTag, "deletePromotion"));
                throw new NoPermissionException();
            }

            return coursePromotionManager.deletePromotion(coursePromotionBo, userBo);
        } catch (NoPermissionException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PERMISSION_COURSE_DELETEPROMOTION);
            exception.setMessageKey(ManagerErrorCode.PERMISSION_COURSE_DELETEPROMOTION_KEY);
            throw exception;
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setMessage(e.getMessage());
            exception.setErrorCode(ManagerErrorCode.COURSE_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSE_CREATE_ERROR_KEY);
            throw exception;
        }
    }

}
