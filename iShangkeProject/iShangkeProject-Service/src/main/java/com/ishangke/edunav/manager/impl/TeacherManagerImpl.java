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
import com.ishangke.edunav.manager.exception.notfound.TeacherNotFoundException;

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
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin || admin[%s] call createTeacher at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), teacherBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }

        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // 插入新的teacher记录
        TeacherEntityExt teacherEntity = TeacherConverter.fromBo(teacherBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);
        if (IdChecker.isNull(teacherEntity.getPartnerId())) {
            throw new ManagerException("Teacher creation must specify partner");
        }
        teacherEntity.setCreateTime(DateUtility.getCurTimeInstance());
        teacherEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        teacherEntity.setEnabled(0);
        teacherEntity.setDeleted(0);
        int result = 0;
        try {
            result = teacherMapper.add(teacherEntity);
        } catch (Throwable t) {
            throw new ManagerException("Teacher creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            return TeacherConverter.toBo(teacherMapper.getById(teacherEntity.getId()));
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
        if (IdChecker.isNull(teacherEntity.getId())) {
            throw new ManagerException("Teacher update must specify id");
        }
        TeacherEntityExt previousTeacher = teacherMapper.getById(teacherEntity.getId());
        if (previousTeacher == null) {
            throw new TeacherNotFoundException("Teacher to update is not found with id:" + teacherEntity.getId());
        }

        // 验证用户是否属于此partner
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin || admin [%s] call updateTeacher at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), previousTeacher.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        teacherEntity.setPartnerId(null);
        teacherEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        teacherEntity.setCreateTime(null);
        teacherEntity.setDeleted(null);
        try {
            teacherMapper.update(teacherEntity);
        } catch (Throwable t) {
            throw new ManagerException("Teacher update failed for user: " + userEntity.getId(), t);
        }

        return TeacherConverter.toBo(teacherMapper.getById(teacherEntity.getId()));
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
        if (IdChecker.isNull(teacherEntity.getId())) {
            throw new ManagerException("Teacher deletion must specify id");
        }
        TeacherEntityExt previousTeacher = teacherMapper.getById(teacherEntity.getId());
        if (previousTeacher == null) {
            throw new TeacherNotFoundException("Teacher to delete is not found with id:" + teacherEntity.getId());
        }

        // 验证用户是否属于此partner
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin || admin [%s] call deleteTeacher at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), previousTeacher.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        try {
            previousTeacher.setDeleted(1);
            teacherMapper.deleteById(previousTeacher.getId());
        } catch (Throwable t) {
            throw new ManagerException("Teacher deletion failed for user: " + userEntity.getId(), t);
        }

        return TeacherConverter.toBo(previousTeacher);
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
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin || admin[%s] call query at " + new Date(), userBo.getName()));
        } else {
            if (teacherBo == null) {
                throw new ManagerException("TeacherBo null for non-admin user at query");
            }
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), teacherBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
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
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin || admin [%s] call listByPartnerId at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), partnerId)) {
                    isSameGroup = true;
                    break;
                }
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

    @Override
    public int queryTotal(TeacherBo teacherBo, UserBo userBo) {
        return teacherMapper.getListCount(TeacherConverter.fromBo(teacherBo));
    }

}
