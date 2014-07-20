package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.ClassPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.ClassPhotoManager;
import com.ishangke.edunav.manager.converter.ClassPhotoConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class ClassPhotoManagerImpl implements ClassPhotoManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassPhotoManagerImpl.class);

    @Autowired
    private ClassPhotoEntityExtMapper classPhotoEntityExtMapper;

    @Override
    public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // TODO权限
            int result = 0;
            result = classPhotoEntityExtMapper.add(classPhotoEntity);
            if (result > 0) {
                return ClassPhotoConverter.toBo(classPhotoEntity);
            } else {
                throw new ManagerException("ClassPhoto Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Create Failed");
        }
    }

    @Override
    public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // TODO权限
            classPhotoEntityExtMapper.update(classPhotoEntity);
            return ClassPhotoConverter.toBo(classPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Update Failed");
        }
    }

    @Override
    public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // TODO权限
            classPhotoEntityExtMapper.deleteById(classPhotoEntity.getId());
            return ClassPhotoConverter.toBo(classPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Delete Failed");
        }
    }

    @Override
    public List<ClassPhotoBo> query(ClassPhotoBo classPhotoBo, PartnerBo partnerBo, UserBo userBo,
            PaginationBo paginationBo) {
        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        PaginationEntity pageEntity = PaginationConverter.fromBo(paginationBo);
        List<ClassPhotoEntityExt> classPhotoList = null;
        List<ClassPhotoBo> resultList = null;

        try {
            // TODO权限
            classPhotoList = classPhotoEntityExtMapper.list(classPhotoEntity, pageEntity);
            for (ClassPhotoEntityExt classPhotoPo : classPhotoList) {
                resultList.add(ClassPhotoConverter.toBo(classPhotoPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Query Failed");
        }
    }

}
