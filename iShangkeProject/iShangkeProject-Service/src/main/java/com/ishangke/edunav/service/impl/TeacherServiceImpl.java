package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.TeacherService;
import com.ishangke.edunav.manager.TeacherManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class TeacherServiceImpl implements TeacherService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    private TeacherManager teacherManager;

    @Override
    public TeacherBo createTeacher(TeacherBo teacherBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return teacherManager.createTeacher(teacherBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public TeacherBo updateTeacher(TeacherBo teacherBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return teacherManager.updateTeacher(teacherBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public TeacherBo deleteTeacher(TeacherBo teacherBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return teacherManager.deleteTeacher(teacherBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<TeacherBo> query(TeacherBo teacherBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo)
            throws BusinessExceptionBo, TException {
        try {
            return teacherManager.query(teacherBo, partnerBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.TEACHER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.TEACHER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
