package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.ClassPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.ClassPhotoManager;
import com.ishangke.edunav.manager.converter.ClassPhotoConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class ClassPhotoManagerImpl implements ClassPhotoManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassPhotoManagerImpl.class);

    @Autowired
    private ClassPhotoEntityExtMapper classPhotoMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 机构管理员只能给本机构上传图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == classPhotoBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin  || admin [%s] call createClassPhoto at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);
        
        int result = 0;
        try {
            result = classPhotoMapper.add(classPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            return ClassPhotoConverter.toBo(classPhotoEntity);
        } else {
            throw new ManagerException("ClassPhoto creation failed for user: " + userEntity.getId());
        }
    }

    @Override
    public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 机构管理员只能给本机构上传图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == classPhotoBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin || admin [%s] call updateClassPhoto at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            classPhotoMapper.update(classPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto update failed for user: " + userEntity.getId(), t);
        }
        return ClassPhotoConverter.toBo(classPhotoEntity);
    }

    @Override
    public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 机构管理员只能删除本机构图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == classPhotoBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin || admin [%s] call deleteClassPhoto at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            classPhotoEntity.setDeleted(1);;
            classPhotoMapper.deleteById(classPhotoEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto deletion failed for user: " + userEntity.getId(), t);
        }
        return ClassPhotoConverter.toBo(classPhotoEntity);
    }

    @Override
    public List<ClassPhotoBo> query(ClassPhotoBo classPhotoBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 机构管理员只能查询本机构的图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == classPhotoBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        List<ClassPhotoEntityExt> results = null;
        try {
            results = classPhotoMapper.list(classPhotoEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto query failed for user: " + userEntity.getId(), t);
        }
        if (results == null) {
            return new ArrayList<ClassPhotoBo>();
        }
        List<ClassPhotoBo> convertedResults = new ArrayList<ClassPhotoBo>();
        for (ClassPhotoEntityExt result : results) {
            convertedResults.add(ClassPhotoConverter.toBo(result));
        }
        return convertedResults;
    }

    /**
     * 所有用户都可以调用此方法
     */
    @Override
    public List<ClassPhotoBo> listByCourseId(int courseId) {
        try {
            List<ClassPhotoBo> resultList = new ArrayList<ClassPhotoBo>();
            List<ClassPhotoEntityExt> classPhotoList = classPhotoMapper.listClassPhotoByCourseId(courseId);
            if (classPhotoList == null) {
                return resultList;
            }
            for (ClassPhotoEntityExt classPhotoPo : classPhotoList) {
                resultList.add(ClassPhotoConverter.toBo(classPhotoPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto listByCourseId Failed", t);
        }
    }

    /**
     * 所有用户都可以调用此方法
     */
    @Override
    public List<ClassPhotoBo> listByCourseTemplateId(int courseTemplateId) {
        try {
            List<ClassPhotoBo> resultList = new ArrayList<ClassPhotoBo>();
            List<ClassPhotoEntityExt> classPhotoList = classPhotoMapper.listClassPhotoByCourseTempleteId(courseTemplateId);
            if (classPhotoList == null) {
                return resultList;
            }
            for (ClassPhotoEntityExt classPhotoPo : classPhotoList) {
                resultList.add(ClassPhotoConverter.toBo(classPhotoPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto listByCourseTemplateId Failed", t);
        }
    }
    
    @Override
    public List<ClassPhotoBo> listByPartnerId(int partnerId, UserBo userBo) {
        // 机构管理员只能查询本机构的图片
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
            List<ClassPhotoBo> resultList = new ArrayList<ClassPhotoBo>();
            List<ClassPhotoEntityExt> classPhotoList = classPhotoMapper.listClassPhotoByPartnerId(partnerId);
            if (classPhotoList == null) {
                return resultList;
            }
            for (ClassPhotoEntityExt classPhotoPo : classPhotoList) {
                resultList.add(ClassPhotoConverter.toBo(classPhotoPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto listByPartnerId Failed", t);
        }
    }

}
