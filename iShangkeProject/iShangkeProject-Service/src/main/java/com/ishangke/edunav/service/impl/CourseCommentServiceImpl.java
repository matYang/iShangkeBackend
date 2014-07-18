package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.CourseCommentService;
import com.ishangke.edunav.manager.CourseCommentManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CourseCommentServiceImpl implements CourseCommentService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Autowired
    private CourseCommentManager courseCommentManager;

    @Override
    public CourseCommentBo createCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo) throws BusinessExceptionBo, TException {
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
    public CourseCommentBo deleteCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo) throws BusinessExceptionBo, TException {
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
    public List<CourseCommentBo> query(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        try {
            return courseCommentManager.query(courseCommentBo, courseTemplateBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.COURSECOMMENT_QUERY_ERROR);
            exception.setMessageKey(ManagerErrorCode.COURSECOMMENT_QUERY_ERROR_KEY);
            throw exception;
        }
    }

}
