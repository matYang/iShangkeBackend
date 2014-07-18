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

public class TeacherServiceImpl implements TeacherService.Iface{
    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);
    
    @Autowired
    private TeacherManager teacherManager;

    @Override
    public TeacherBo createTeacher(TeacherBo teacherBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TeacherBo updateTeacher(TeacherBo teacherBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TeacherBo deleteTeacher(TeacherBo teacherBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TeacherBo> query(TeacherBo teacherBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

       
}
