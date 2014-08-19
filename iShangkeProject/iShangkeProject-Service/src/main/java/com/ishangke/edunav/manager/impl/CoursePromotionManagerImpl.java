package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CoursePromotionEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CoursePromotionEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CoursePromotionManager;
import com.ishangke.edunav.manager.converter.CoursePromotionConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.manager.exception.notfound.CoursePromotionNotFoundException;

@Component
public class CoursePromotionManagerImpl implements CoursePromotionManager{
    private static final Logger LOGGER = LoggerFactory.getLogger(CoursePromotionManagerImpl.class);

    @Autowired
    private UserEntityExtMapper userMapper;
    
    @Autowired
    private CoursePromotionEntityExtMapper coursePromotionMapper;
    
    @Autowired
    private GroupEntityExtMapper groupMapper;
    
    @Autowired
    private AuthManager authManager;


    @Override
    public CoursePromotionBo createPromotion(CoursePromotionBo coursePromotionBo, UserBo userBo) {
        // Check Null
        if (coursePromotionBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CoursePromotionManagerImpl]system admin  || admin [%s] call createCoursePromotion at " + new Date(), userBo.getName()));
        } else {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        // Convert
        CoursePromotionEntityExt coursePromotionEntity = CoursePromotionConverter.fromBo(coursePromotionBo);

        coursePromotionEntity.setCreateTime(DateUtility.getCurTimeInstance());
        coursePromotionEntity.setDeleted(0);
        int result = 0;
        try {
            result = coursePromotionMapper.add(coursePromotionEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，课程置顶创建失败，请稍后再试", t);
        }
        if (result > 0) {
            return CoursePromotionConverter.toBo(coursePromotionMapper.getById(coursePromotionEntity.getId()));
        } else {
            throw new ManagerException("对不起，课程置顶获取失败，请稍后再试");
        }
    }

    @Override
    public CoursePromotionBo updatePromotion(CoursePromotionBo coursePromotionBo, UserBo userBo) {
        if (coursePromotionBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        
        // Convert
        CoursePromotionEntityExt coursePromotionEntity = CoursePromotionConverter.fromBo(coursePromotionBo);
        if (IdChecker.isNull(coursePromotionEntity.getId())) {
            throw new ManagerException("更新课程置顶时必须标注课程置顶ID");
        }
        CoursePromotionEntityExt previousCoursePromotion = coursePromotionMapper.getById(coursePromotionEntity.getId());
        if (previousCoursePromotion == null) {
            throw new CoursePromotionNotFoundException("对不起，无法找到ID为" + coursePromotionEntity.getId() + "的课程置顶");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CoursePromotionManagerImpl]system admin || admin [%s] call updateCoursePromotion at " + new Date(), userBo.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权更改课程置顶信息");
        }

        coursePromotionEntity.setCreateTime(null);
        try {
            coursePromotionMapper.update(coursePromotionEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，课程置顶更新失败，请稍后再试", t);
        }
        return CoursePromotionConverter.toBo(coursePromotionMapper.getById(coursePromotionEntity.getId()));
    }

    @Override
    public CoursePromotionBo deletePromotion(CoursePromotionBo coursePromotionBo, UserBo userBo) {
        if (coursePromotionBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        CoursePromotionEntityExt coursePromotionEntity = CoursePromotionConverter.fromBo(coursePromotionBo);
        if (IdChecker.isNull(coursePromotionEntity.getId())) {
            throw new ManagerException("删除课程置顶时必须标注课程置顶ID");
        }
        CoursePromotionEntityExt previousCoursePromotion = coursePromotionMapper.getById(coursePromotionEntity.getId());
        if (previousCoursePromotion == null) {
            throw new CoursePromotionNotFoundException("对不起，无法找到ID为" + coursePromotionEntity.getId() + "的课程置顶");
        }
        
        //only admins can
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CoursePromotionManagerImpl]system admin || admin [%s] call deleteCoursePromotion at " + new Date(), userBo.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权删除课程置顶信息");
        }

        try {
            previousCoursePromotion.setDeleted(1);
            coursePromotionMapper.deleteById(previousCoursePromotion.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，课程置顶删除失败，请稍后再试", t);
        }
        return CoursePromotionConverter.toBo(previousCoursePromotion);
    }
    
    
    @Override
    public List<CoursePromotionBo> query(CoursePromotionBo coursePromotionBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CoursePromotionManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权查看课程置顶信息");
        }

        // Convert
        CoursePromotionEntityExt coursePromotionEntity = coursePromotionBo == null ? null : CoursePromotionConverter.fromBo(coursePromotionBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);

        List<CoursePromotionEntityExt> results = null;
        try {
            results = coursePromotionMapper.list(coursePromotionEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，课程置顶信息查询失败，请稍后再试", t);
        }
        if (results == null) {
            return new ArrayList<CoursePromotionBo>();
        }
        List<CoursePromotionBo> convertedResults = new ArrayList<CoursePromotionBo>();
        for (CoursePromotionEntityExt result : results) {
            convertedResults.add(CoursePromotionConverter.toBo(result));
        }
        return convertedResults;
    }
    
    @Override
    public int queryTotal(CoursePromotionBo coursePromotionBo, UserBo userBo) {
        return coursePromotionMapper.getListCount(CoursePromotionConverter.fromBo(coursePromotionBo));
    }

}
