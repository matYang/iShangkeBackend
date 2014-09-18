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
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PurposeCourseBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.PurposeCourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.PurposeCourseEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.PurposeCourseManager;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PurposeCourseConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;

@Component
public class PurposeCourseManagerImpl implements PurposeCourseManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PurposeCourseManagerImpl.class);
    
    @Autowired
    private PurposeCourseEntityExtMapper purposeCourseMapper;
    
    @Autowired
    private AuthManager authManager;
    @Override
    public List<PurposeCourseBo> query(PurposeCourseBo purposeCourseBo, UserBo userBo, PaginationBo paginationBo) {
        if(userBo == null){
            throw new ManagerException("无效请求参数");
        }
        if(authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())){
            LOGGER.warn(String.format("[PurposeCourseManagerImpl]system admin || admin [%s] call createCoursePromotion at "+new Date(), userBo.getName()));
        }else{
            throw new AuthenticationException("对不起，您无权查看意向课程信息");
        }
        
        PurposeCourseEntityExt purposeCourseEntity = purposeCourseBo == null ? null:PurposeCourseConverter.fromBo(purposeCourseBo);
        PaginationEntity page = paginationBo==null?null:PaginationConverter.fromBo(paginationBo); 
        
        List<PurposeCourseEntityExt> results = null;
        try{
            results = purposeCourseMapper.list(purposeCourseEntity,page);
        }catch(Throwable t){
            throw new ManagerException("对不起，意向课程信息查询失败，请稍候再试");
        }
        if(results==null){
            return new ArrayList<PurposeCourseBo>();
        }
        List<PurposeCourseBo> convertedResults = new ArrayList<PurposeCourseBo>();
        for(PurposeCourseEntityExt result : results){
            convertedResults.add(PurposeCourseConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public PurposeCourseBo createPurpose(PurposeCourseBo purposeCourseBo, UserBo userBo) {
        //check null
//        if(purposeCourseBo == null || userBo == null){
//            throw new ManagerException("无效请求参数");
//        }
        //every one can create
        /*if(authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())){
            LOGGER.warn(String.format("[PurposeCourseManagerImpl]system admin || admin [%s] call createPurposeCourse at "+new Date(), userBo.getName()));
        }else{
            throw new ManagerException("对不起，您无权执行该请求");
        }*/
        
        //Convert
        PurposeCourseEntityExt purposeCourseEntity = PurposeCourseConverter.fromBo(purposeCourseBo);
        
        purposeCourseEntity.setCreateTime(DateUtility.getCurTimeInstance());
        purposeCourseEntity.setDeleted(0);
        int result = 0;
        try{
            result = purposeCourseMapper.add(purposeCourseEntity);
        }catch(Throwable t){
            throw new ManagerException("对不起，意向课程创建失败，请稍候再试",t);
        }
        if(result > 0){
            return PurposeCourseConverter.toBo(purposeCourseMapper.getById(purposeCourseEntity.getId()));
        }else{
            throw new ManagerException("对不起，意向课程获取失败，请稍候再试");
        }
    }

    @Override
    public PurposeCourseBo updatePurpose(PurposeCourseBo purposeCourseBo, UserBo userBo) {
        if(purposeCourseBo == null || userBo == null){
            throw new ManagerException("无效请求参数");
        }
        
        //Convert
        PurposeCourseEntityExt purposeCourseEntity = PurposeCourseConverter.fromBo(purposeCourseBo);
        if(IdChecker.isNull(purposeCourseEntity.getId())){
            throw new ManagerException("更新意向课程时必须标注意向课程ID");
        }
        PurposeCourseEntityExt previousPurposeCourse = purposeCourseMapper.getById(purposeCourseEntity.getId());
        if(previousPurposeCourse == null){
            throw new ManagerException("对不起，无法找到Id为"+purposeCourseEntity.getId()+"的意向课程");
        }
        
        if(authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())){
            LOGGER.warn(String.format("[PurposeCourseManagerImpl]system admin || admin [%s] call updatePurposeCourse at "+new Date(), userBo.getName()));
        }else{
            throw new ManagerException("对不起，您无权更改意向课程信息");
        }
        
        purposeCourseEntity.setCreateTime(null);
        try{
            purposeCourseMapper.update(purposeCourseEntity);
        }catch(Throwable t){
            throw new ManagerException("对不起，意向课程更新失败，其稍后再试",t);
        }
        return PurposeCourseConverter.toBo(purposeCourseMapper.getById(purposeCourseEntity.getId()));
    }

    @Override
    public PurposeCourseBo deletePurpose(PurposeCourseBo purposeCourseBo, UserBo userBo) {
        if(purposeCourseBo == null || userBo == null){
            throw new ManagerException("无效请求参数");
        }
        
        //Convert
        PurposeCourseEntityExt purposeCourseEntity = PurposeCourseConverter.fromBo(purposeCourseBo);
        if(IdChecker.isNull(purposeCourseEntity.getId())){
            throw new ManagerException("删除意向课程时必须标注意向课程ID");
        }
        PurposeCourseEntityExt previousPurposeCourse = purposeCourseMapper.getById(purposeCourseEntity.getId());
        if(previousPurposeCourse == null){
            throw new ManagerException("对不起，无法找到Id为"+purposeCourseEntity.getId()+"的意向课程");
        }
        
        if(authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())){
            LOGGER.warn(String.format("[PurposeCourseManagerImpl]system admin || admin [%s] call updatePurposeCourse at "+new Date(), userBo.getName()));
        }else{
            throw new ManagerException("对不起，您无权删除意向课程信息");
        }
        
        try{
            previousPurposeCourse.setDeleted(1);
            purposeCourseMapper.deleteById(previousPurposeCourse.getId());
        }catch(Throwable t){
            throw new ManagerException("对不起，意向课程删除失败，请稍后再试");
        }
        return PurposeCourseConverter.toBo(previousPurposeCourse);
    }

    @Override
    public int queryTotal(PurposeCourseBo purposeCourseBo, UserBo userBo) {
        return purposeCourseMapper.getListCount(PurposeCourseConverter.fromBo(purposeCourseBo));
    }

}
