package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.TeacherEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;
import com.ishangke.edunav.manager.TeacherManager;
import com.ishangke.edunav.manager.converter.TeacherConverter;
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
        int result = 0;
        try {
            result = teacherMapper.add(teacherEntity);
        } catch (Throwable t) {
            LOGGER.debug(t.getMessage(), t);
            throw new ManagerException("teacher creation failed for user: " + userBo.getId(), t);
        }
        if (result > 0) {
            return TeacherConverter.toBo(teacherEntity);
        } else {
            throw new ManagerException("Teacher creation failed for user: " + userBo.getId());
        }
    }

    @Override
    public TeacherBo updateTeacher(TeacherBo teacherBo, UserBo userBo) {
        // 参数验证
        if (teacherBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 更新WITHDRAW记录
        TeacherEntityExt teacherEntity = TeacherConverter.fromBo(teacherBo);
        try {
            teacherMapper.update(teacherEntity);
        } catch (Throwable t) {
            LOGGER.debug(t.getMessage(), t);
            throw new ManagerException("Teacher creation failed for user: " + userBo.getId(), t);
        }

        return TeacherConverter.toBo(teacherEntity);
    }

    @Override
    public TeacherBo deleteTeacher(TeacherBo teacherBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TeacherBo> query(TeacherBo teacherBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
