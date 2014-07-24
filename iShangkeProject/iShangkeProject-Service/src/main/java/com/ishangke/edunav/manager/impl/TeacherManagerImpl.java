package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.TeacherEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.TeacherManager;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.TeacherConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class TeacherManagerImpl implements TeacherManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherManagerImpl.class);

    @Autowired
    private TeacherEntityExtMapper teacherMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private AuthManager authManager;

    @Override
    public TeacherBo createTeacher(TeacherBo teacherBo, UserBo userBo) {
        // 参数验证
        if (teacherBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == teacherBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin [%s] call createTeacher at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // 插入新的teacher记录
        TeacherEntityExt teacherEntity = TeacherConverter.fromBo(teacherBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        int result = 0;
        try {
            result = teacherMapper.add(teacherEntity);
        } catch (Throwable t) {
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

        // 验证用户是否属于此partner
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == teacherBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin [%s] call updateTeacher at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // 更新TEACHER记录
        TeacherEntityExt teacherEntity = TeacherConverter.fromBo(teacherBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            teacherMapper.update(teacherEntity);
        } catch (Throwable t) {
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

        // 验证用户是否属于此partner
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == teacherBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin [%s] call deleteTeacher at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // 删除TEACHER记录
        TeacherEntityExt teacherEntity = TeacherConverter.fromBo(teacherBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            teacherEntity.setDeleted(1);
            teacherMapper.deleteById(teacherEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("Teacher deletion failed for user: " + userEntity.getId(), t);
        }

        return TeacherConverter.toBo(teacherEntity);
    }

    @Override
    public List<TeacherBo> query(TeacherBo teacherBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 验证用户是否属于此partner
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == teacherBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin [%s] call query at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        TeacherEntityExt teacherEntity = teacherBo == null ? null : TeacherConverter.fromBo(teacherBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);


        List<TeacherEntityExt> results = null;
        try {
            results = teacherMapper.list(teacherEntity, page);
        } catch (Throwable t) {
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

    /**
     * 所有人都可以调用此方法
     */
    @Override
    public List<TeacherBo> listByCourseId(int courseId) {
        try {
            List<TeacherBo> resultList = new ArrayList<TeacherBo>();
            List<TeacherEntityExt> teacherList = teacherMapper.listTeacherByCourseId(courseId);
            if (teacherList == null) {
                return resultList;
            }
            for (TeacherEntityExt teacherPo : teacherList) {
                resultList.add(TeacherConverter.toBo(teacherPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Teacher listByCourseId Failed", t);
        }
    }

    /**
     * 所有人都可以调用此方法
     */
    @Override
    public List<TeacherBo> listByCourseTemplateId(int courseTemplateId) {
        try {
            List<TeacherBo> resultList = new ArrayList<TeacherBo>();
            List<TeacherEntityExt> teacherList = teacherMapper.listTeacherByCourseTempleteId(courseTemplateId);
            if (teacherList == null) {
                return resultList;
            }
            for (TeacherEntityExt teacherPo : teacherList) {
                resultList.add(TeacherConverter.toBo(teacherPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Teacher listByCourseTemplateId Failed", t);
        }
    }

    @Override
    public List<TeacherBo> listByPartnerId(int partnerId, UserBo userBo) {
        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerId) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }
        
        try {
            List<TeacherBo> resultList = new ArrayList<TeacherBo>();
            List<TeacherEntityExt> teacherList = teacherMapper.listTeacherByPartnerId(partnerId);
            if (teacherList == null) {
                return resultList;
            }
            for (TeacherEntityExt teacherPo : teacherList) {
                resultList.add(TeacherConverter.toBo(teacherPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Teacher listByPartnerId Failed", t);
        }
    }

}
