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
import com.ishangke.edunav.manager.exception.notfound.ClassPhotoNotFoundException;

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
            throw new ManagerException("无效请求参数");
        }

        // 机构管理员只能给本机构上传图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin  || admin [%s] call createClassPhoto at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), classPhotoBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }

        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(classPhotoEntity.getPartnerId())) {
            throw new ManagerException("创建机构图片时必须标注合作机构");
        }
        classPhotoEntity.setCreateTime(DateUtility.getCurTimeInstance());
        classPhotoEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        classPhotoEntity.setEnabled(0);
        classPhotoEntity.setDeleted(0);
        int result = 0;
        try {
            result = classPhotoMapper.add(classPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，机构图片创建失败，请稍后再试", t);
        }
        if (result > 0) {
            return ClassPhotoConverter.toBo(classPhotoMapper.getById(classPhotoEntity.getId()));
        } else {
            throw new ManagerException("对不起，机构图片获取失败，请稍后再试");
        }
    }

    @Override
    public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        
        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(classPhotoEntity.getId())) {
            throw new ManagerException("更新机构图片时必须标注机构图片ID");
        }
        ClassPhotoEntityExt previousClassPhoto = classPhotoMapper.getById(classPhotoEntity.getId());
        if (previousClassPhoto == null) {
            throw new ClassPhotoNotFoundException("对不起，没有找到ID为" +  classPhotoEntity.getId() + "的机构图片");
        }

        // 机构管理员只能给本机构上传图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin || admin [%s] call updateClassPhoto at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), previousClassPhoto.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        classPhotoEntity.setPartnerId(null);
        classPhotoEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        classPhotoEntity.setCreateTime(null);
        classPhotoEntity.setEnabled(null);
        try {
            classPhotoMapper.update(classPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，机构图片更新失败，请稍后再试", t);
        }
        return ClassPhotoConverter.toBo(classPhotoMapper.getById(classPhotoEntity.getId()));
    }

    @Override
    public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);
        if (IdChecker.isNull(classPhotoEntity.getId())) {
            throw new ManagerException("删除机构图片时必须标注机构图片ID");
        }
        ClassPhotoEntityExt previousClassPhoto = classPhotoMapper.getById(classPhotoEntity.getId());
        if (previousClassPhoto == null) {
            throw new ClassPhotoNotFoundException("对不起，无法找到ID为" + classPhotoEntity.getId() + "的机构图片");
        }

        // 机构管理员只能删除本机构图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin || admin [%s] call deleteClassPhoto at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), previousClassPhoto.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }

        }
        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        try {
            previousClassPhoto.setDeleted(1);
            classPhotoMapper.deleteById(previousClassPhoto.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，机构图片删除失败，请稍后再试", t);
        }
        return ClassPhotoConverter.toBo(previousClassPhoto);
    }

    @Override
    public List<ClassPhotoBo> query(ClassPhotoBo classPhotoBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 机构管理员只能查询本机构的图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            if (classPhotoBo == null) {
                throw new ManagerException("非管理员用户无权查询全部课程图片");
            }
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), classPhotoBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }

        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        List<ClassPhotoEntityExt> results = null;
        try {
            results = classPhotoMapper.list(classPhotoEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，课程图片查询失败，请稍后再试", t);
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
            throw new ManagerException("对不起，按照课程查询机构图片失败，请稍后再试", t);
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
            throw new ManagerException("对不起，按照课程模板查询机构图片失败，请稍后再试", t);
        }
    }

    @Override
    public List<ClassPhotoBo> listByPartnerId(int partnerId, UserBo userBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 机构管理员只能查询本机构的图片
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[ClassPhotoManagerImpl]system admin || admin [%s] call listByPartnerId at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), partnerId)) {
                    isSameGroup = true;
                    break;
                }
            }
        }

        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
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
            throw new ManagerException("对不起，按照合作机构查询机构图片失败，请稍后再试", t);
        }
    }

    @Override
    public int queryTotal(ClassPhotoBo classPhotoBo, UserBo userBo) {
        return classPhotoMapper.getListCount(ClassPhotoConverter.fromBo(classPhotoBo));
    }

}
