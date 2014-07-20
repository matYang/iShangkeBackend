package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.TeacherEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.TeacherManager;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.TeacherConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class TeacherManagerImpl implements TeacherManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherManagerImpl.class);

    @Autowired
    private TeacherEntityExtMapper teacherMapper;

    @Override
    public TeacherBo createTeacher(TeacherBo teacherBo, UserBo userBo) {
        // 参数验证
        if (teacherBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 插入新的teacher记录
        TeacherEntityExt teacherEntity = TeacherConverter.fromBo(teacherBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        int result = 0;
        try {
            result = teacherMapper.add(teacherEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Teacher creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            return TeacherConverter.toBo(teacherEntity);
        } else {
            throw new ManagerException("Teacher creation failed for user: " + userEntity.getId());
        }
    }

    @Override
    public TeacherBo updateTeacher(TeacherBo teacherBo, UserBo userBo) {
        // 参数验证
        if (teacherBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 更新TEACHER记录
        TeacherEntityExt teacherEntity = TeacherConverter.fromBo(teacherBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            teacherMapper.update(teacherEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Teacher update failed for user: " + userEntity.getId(), t);
        }

        return TeacherConverter.toBo(teacherEntity);
    }

    @Override
    public TeacherBo deleteTeacher(TeacherBo teacherBo, UserBo userBo) {
        // 参数验证
        if (teacherBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 删除TEACHER记录
        TeacherEntityExt teacherEntity = TeacherConverter.fromBo(teacherBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            teacherEntity.setDeleted(1);
            teacherMapper.deleteById(teacherEntity.getId());
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Teacher deletion failed for user: " + userEntity.getId(), t);
        }

        return TeacherConverter.toBo(teacherEntity);
    }

    @Override
    public List<TeacherBo> query(TeacherBo teacherBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        TeacherEntityExt teacherEntity = teacherBo == null ? null : TeacherConverter.fromBo(teacherBo);
        PartnerEntityExt partnerEntity = partnerBo == null ? null : PartnerConverter.fromBo(partnerBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (teacherEntity != null && partnerEntity != null) {
            teacherEntity.setPartnerId(partnerEntity.getId());
        }

        List<TeacherEntityExt> results = null;
        try {
            results = teacherMapper.list(teacherEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Teacher query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<TeacherBo>();
        }
        List<TeacherBo> convertedResults = new ArrayList<TeacherBo>();
        for (TeacherEntityExt result : results) {
            convertedResults.add(TeacherConverter.toBo(result));
        }
        return convertedResults;
    }

}
