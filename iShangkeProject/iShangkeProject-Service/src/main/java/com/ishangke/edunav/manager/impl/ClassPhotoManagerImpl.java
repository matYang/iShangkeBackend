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
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
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

    @Override
    public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo, UserBo userBo) {
        // Check Null
        if (classPhotoBo == null) {
            throw new ManagerException("ClassPhoto Create Failed: classPhotoBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("ClassPhoto Create Failed: userBo is null");
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

        // Convert
        ClassPhotoEntityExt classPhotoEntity = ClassPhotoConverter.fromBo(classPhotoBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        List<ClassPhotoEntityExt> classPhotoList = null;
        List<ClassPhotoBo> resultList = null;

        // Check Ids
        if (partnerEntity.getId() == null || partnerEntity.getId() == 0) {
            throw new ManagerException("ClassPhoto Query Failed: 合作商id为null或0");
        }

        try {
            classPhotoList = classPhotoMapper.list(classPhotoEntity, pageEntity);
            for (ClassPhotoEntityExt classPhotoPo : classPhotoList) {
                if (classPhotoPo.getPartnerId() != partnerEntity.getId()) {
                    throw new ManagerException("ClassPhoto Query Failed: 此教室照片不属于该合作商");
                }
                resultList.add(ClassPhotoConverter.toBo(classPhotoPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("ClassPhoto Query Failed", t);
        }
    }

    @Override
    public List<ClassPhotoBo> listByPartnerId(int partnerId) {
        List<ClassPhotoEntityExt> classPhotoList = null;
        List<ClassPhotoBo> resultList = null;

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
