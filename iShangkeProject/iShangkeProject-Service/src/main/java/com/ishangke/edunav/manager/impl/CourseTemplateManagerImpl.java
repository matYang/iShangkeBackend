package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class CourseTemplateManagerImpl implements CourseTemplateManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseTemplateManagerImpl.class);

    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateEntityExtMapper;

    @Override
    public CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        try {
            courseTemplateEntity.setPartnerId(partnerEntity.getId());
            int result = 0;
            result = courseTemplateEntityExtMapper.add(courseTemplateEntity);
            if (result > 0) {
                return CourseTemplateConverter.toBo(courseTemplateEntity);
            } else {
                throw new ManagerException("CourseTemplate Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Create Failed");
        }
    }

    @Override
    public CourseTemplateBo submitCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateEntityExtMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Submit Failed");
        }
    }

    @Override
    public CourseTemplateBo approveCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo,
            CommentCourseTemplateApproveBo commentCourseTemplateApproveBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateEntityExtMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Approve Failed");
        }
    }

    @Override
    public CourseTemplateBo rejectCourseTemplate(CourseTemplateBo courseTemplateBo,
            CommentCourseTemplateRejectBo commentCourseTemplateRejectBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateEntityExtMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Reject Failed");
        }
    }

    @Override
    public CourseTemplateBo cancelCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateEntityExtMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Cancel Failed");
        }
    }

    @Override
    public CourseTemplateBo resubmitCourserTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo,
            UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateEntityExtMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Resubmit Failed");
        }
    }

    @Override
    public CourseTemplateBo deleteCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        try {
            courseTemplateEntity.setDeleted(1);
            courseTemplateEntityExtMapper.deleteById(courseTemplateEntity.getId());
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Delete Failed");
        }
    }

    @Override
    public CourseTemplateBo updateCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限
        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateEntityExtMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Update Failed");
        }
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo,
            PartnerBo partnerBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        List<CourseTemplateEntityExt> courseTemplateList = null;
        List<CourseTemplateBo> resultList = null;

        // TODO 权限
        try {
            courseTemplateList = courseTemplateEntityExtMapper.list(courseTemplateEntity, pageEntity);
            for (CourseTemplateEntityExt courseTemplatePo : courseTemplateList) {
                resultList.add(CourseTemplateConverter.toBo(courseTemplatePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Query Failed");
        }
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplateBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        List<CourseTemplateEntityExt> courseTemplateList = null;
        List<CourseTemplateBo> resultList = null;

        // TODO 权限
        try {
            courseTemplateList = courseTemplateEntityExtMapper.list(courseTemplateEntity, null);
            for (CourseTemplateEntityExt courseTemplatePo : courseTemplateList) {
                resultList.add(CourseTemplateConverter.toBo(courseTemplatePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate QueryById Failed");
        }
    }

}
