package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CourseCommentEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.CourseCommentManager;
import com.ishangke.edunav.manager.converter.CourseCommentConverter;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CourseCommentManagerImpl implements CourseCommentManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseCommentManagerImpl.class);

    @Autowired
    private CourseCommentEntityExtMapper courseCommentEntityExtMapper;

    @Override
    public CourseCommentBo createCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo,
            UserBo userBo) {
        // Check Null
        if (courseCommentBo == null) {
            throw new ManagerException("CourseCommentBo is null");
        }
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplageBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseCommentEntityExt courseCommentEntity = CourseCommentConverter.fromBo(courseCommentBo);
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // Set Properties
            courseCommentEntity.setUserId(userEntity.getId());
            courseCommentEntity.setCourseTemplateId(courseTemplateEntity.getId());

            int result = 0;
            result = courseCommentEntityExtMapper.add(courseCommentEntity);

            if (result > 0) {
                return CourseCommentConverter.toBo(courseCommentEntity);
            } else {
                throw new ManagerException("CourseComment Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("CourseComment Create Failed");
        }
    }

    @Override
    public CourseCommentBo deleteCourseComment(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo,
            UserBo userBo) {
        // Check Null
        if (courseCommentBo == null) {
            throw new ManagerException("CourseCommentBo is null");
        }
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplageBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseCommentEntityExt courseCommentEntity = CourseCommentConverter.fromBo(courseCommentBo);
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        // 先做个示范: AS FOLLOWING:
        if (courseCommentEntity.getCourseTemplateId() != courseTemplateEntity.getId()) {
            throw new ManagerException("此评论不属于此课程模版");
        }
        if (courseCommentEntity.getUserId() != userEntity.getId()) {
            throw new ManagerException("此用户无权删除此评论");
        }

        try {
            courseCommentEntityExtMapper.deleteById(courseCommentEntity.getId());
            return CourseCommentConverter.toBo(courseCommentEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseComment Delete Failed");
        }

    }

    @Override
    public List<CourseCommentBo> query(CourseCommentBo courseCommentBo, CourseTemplateBo courseTemplateBo,
            UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (courseCommentBo == null) {
            throw new ManagerException("CourseCommentBo is null");
        }
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplageBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CourseCommentEntityExt courseCommentEntity = CourseCommentConverter.fromBo(courseCommentBo);
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        List<CourseCommentEntityExt> courseCommentList = null;
        List<CourseCommentBo> resultList = null;

        try {
            // TODO权限
            courseCommentList = courseCommentEntityExtMapper.list(courseCommentEntity, pageEntity);
            for (CourseCommentEntityExt courseCommentPo : courseCommentList) {
                resultList.add(CourseCommentConverter.toBo(courseCommentPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("CourseComment Query Failed");
        }
    }

}
