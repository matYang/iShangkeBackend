package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CourseCommentEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CourseCommentManager;
import com.ishangke.edunav.manager.converter.CourseCommentConverter;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;

@Component
public class CourseCommentManagerImpl implements CourseCommentManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseCommentManagerImpl.class);

    @Autowired
    private CourseCommentEntityExtMapper courseCommentMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public CourseCommentBo createCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo) {
        // Check Null
        if (courseCommentBo == null || courseTemplateBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // Convert
        CourseCommentEntityExt courseCommentEntity = CourseCommentConverter.fromBo(courseCommentBo);
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        
        
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CourseCommentManagerImpl]system admin || admin [%s] call createCourseComment at " + new Date(), userBo.getName()));
        }
        else {
            if (courseCommentEntity == null || courseCommentEntity.getUserId() == null || !courseCommentEntity.getUserId().equals(userEntity.getId())) {
                throw new AuthenticationException("User creating someone else's courseComment");
            }
        }
        if (courseCommentEntity.getCourseTemplateId() != courseTemplateEntity.getId()) {
            throw new ManagerException("Course Comment not match Course Template Id");
        }
        
        courseCommentEntity.setCreateTime(DateUtility.getCurTimeInstance());
        courseCommentEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseCommentEntity.setEnabled(0);
        courseCommentEntity.setDeleted(0);
        int result = 0;
        try {
            result = courseCommentMapper.add(courseCommentEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseComment creation failed for user: " + userEntity.getId(), t);
        }
        
        if (result > 0) {
            return CourseCommentConverter.toBo(courseCommentEntity);
        } else {
            throw new ManagerException("CourseComment creation failed for user: " + userEntity.getId());
        }
    }

    @Override
    public CourseCommentBo deleteCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo) {
        // Check Null
        if (courseCommentBo == null || courseTemplateBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // Convert
        CourseCommentEntityExt courseCommentEntity = CourseCommentConverter.fromBo(courseCommentBo);
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CourseCommentManagerImpl]system admin || admin [%s] call deleteCourseComment at " + new Date(), userBo.getName()));
        }
        else {
            if (courseCommentEntity == null || courseCommentEntity.getUserId() == null || !courseCommentEntity.getUserId().equals(userEntity.getId())) {
                throw new AuthenticationException("User deleting someone else's courseComment");
            }
        }
        
        // Check whether the courseComment belongs to the courseTemplate
        if (courseCommentEntity.getCourseTemplateId() != courseTemplateEntity.getId()) {
            throw new ManagerException("CourseComment Delete Failed: 此评论不属于此课程模版");
        }
        // Check Ids
        if (courseTemplateEntity.getId() == null || courseTemplateEntity.getId() == 0) {
            throw new ManagerException("CourseComment Delete Failed: 此课程模版id为null或0");
        }

        courseCommentEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        try {
            courseCommentEntity.setDeleted(1);
            courseCommentMapper.deleteById(courseCommentEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("CourseComment deletion failed for user: " + userEntity.getId(), t);
        }

        return CourseCommentConverter.toBo(courseCommentEntity);
    }

    @Override
    public List<CourseCommentBo> query(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // Convert
        CourseCommentEntityExt courseCommentEntity = courseCommentBo == null ? null : CourseCommentConverter.fromBo(courseCommentBo);
        //TODO donno what courseTemplateBo is here for
        //CourseTemplateEntityExt courseTemplateEntity = courseCommentBo == null ? null : CourseTemplateConverter.fromBo(courseTemplateBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CourseCommentManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        }
        else {
            if (courseCommentEntity == null || courseCommentEntity.getUserId() == null || !courseCommentEntity.getUserId().equals(userEntity.getId())) {
                throw new AuthenticationException("User querying someone else's courseComment");
            }
        }

        
        List<CourseCommentEntityExt> results = null;
        try {
            results = courseCommentMapper.list(courseCommentEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("CourseComment query failed for user: " + userEntity.getId(), t);
        }
        
        List<CourseCommentBo> convertedResults = new ArrayList<CourseCommentBo>();
        for (CourseCommentEntityExt courseCommentPo : results) {
            convertedResults.add(CourseCommentConverter.toBo(courseCommentPo));
        }
        return convertedResults;
    }

}
