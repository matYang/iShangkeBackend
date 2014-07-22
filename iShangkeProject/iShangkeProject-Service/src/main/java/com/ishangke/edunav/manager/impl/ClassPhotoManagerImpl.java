package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.ClassPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.manager.ClassPhotoManager;
import com.ishangke.edunav.manager.converter.ClassPhotoConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class ClassPhotoManagerImpl implements ClassPhotoManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassPhotoManagerImpl.class);

    @Autowired
    private ClassPhotoEntityExtMapper classPhotoMapper;

    @Autowired
    private GroupEntityExtMapper groupEntityExtMapper;

    @Override
    public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("ClassPhoto Create Failed: classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("ClassPhoto Create Failed: userBo is null");
        }

        // 机构管理员只能给本机构上传图片
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
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
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);

        try {
            int result = 0;
            result = classPhotoMapper.add(classPhotoEntity);
            if (result > 0) {
                return ClassPhotoConverter.toBo(classPhotoEntity);
            } else {
                throw new ManagerException("ClassPhoto Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Create Failed", t);
        }
    }

    @Override
    public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("ClassPhoto Update Failed: classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("ClassPhoto Update Failed: userBo is null");
        }

        // 机构管理员只能给本机构上传图片
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
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
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);

        try {
            classPhotoMapper.update(classPhotoEntity);
            return ClassPhotoConverter.toBo(classPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Update Failed", t);
        }
    }

    @Override
    public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("ClassPhoto Delete Failed: classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("ClassPhoto Delete Failed: userBo is null");
        }

        // 机构管理员只能删除本机构图片
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
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
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);

        try {
            classPhotoMapper.deleteById(classPhotoEntity.getId());
            return ClassPhotoConverter.toBo(classPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Delete Failed", t);
        }
    }

    @Override
    public List<ClassPhotoBo> query(ClassPhotoBo classPhotoBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("ClassPhoto Query Failed: classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("ClassPhoto Query Failed: userBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("ClassPhoto Query Failed: partnerBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // 机构管理员只能查询本机构的图片
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        List<ClassPhotoEntityExt> classPhotoList = null;
        List<ClassPhotoBo> resultList = null;

        classPhotoEntity.setPartnerId(partnerBo.getId());
        try {
            classPhotoList = classPhotoMapper.list(classPhotoEntity, pageEntity);
            for (ClassPhotoEntityExt classPhotoPo : classPhotoList) {
                resultList.add(ClassPhotoConverter.toBo(classPhotoPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Query Failed", t);
        }
    }

    @Override
    public List<ClassPhotoBo> listByPartnerId(int partnerId, UserBo userBo) {
        List<ClassPhotoEntityExt> classPhotoList = null;
        List<ClassPhotoBo> resultList = null;

        // 机构管理员只能查询本机构的图片
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
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
            classPhotoList = classPhotoMapper.listClassPhotoByPartnerId(partnerId);
            for (ClassPhotoEntityExt classPhotoPo : classPhotoList) {
                resultList.add(ClassPhotoConverter.toBo(classPhotoPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto listByPartnerId Failed", t);
        }
    }

    /**
     * 所有用户都可以调用此方法
     */
    @Override
    public List<ClassPhotoBo> listByCourseId(int courseId) {
        List<ClassPhotoEntityExt> classPhotoList = null;
        List<ClassPhotoBo> resultList = null;

        try {
            classPhotoList = classPhotoMapper.listClassPhotoByCourseId(courseId);
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
        List<ClassPhotoEntityExt> classPhotoList = null;
        List<ClassPhotoBo> resultList = null;

        try {
            classPhotoList = classPhotoMapper.listClassPhotoByCourseTempleteId(courseTemplateId);
            for (ClassPhotoEntityExt classPhotoPo : classPhotoList) {
                resultList.add(ClassPhotoConverter.toBo(classPhotoPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto listByCourseTemplateId Failed", t);
        }
    }

}
