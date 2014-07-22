package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.LocationEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.CourseEntity;
import com.ishangke.edunav.manager.CourseManager;
import com.ishangke.edunav.manager.converter.CategoryConverter;
import com.ishangke.edunav.manager.converter.CircleConverter;
import com.ishangke.edunav.manager.converter.CourseCommentConverter;
import com.ishangke.edunav.manager.converter.CourseConverter;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.LocationConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class CourseManagerImpl implements CourseManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseManagerImpl.class);

    @Autowired
    private CourseEntityExtMapper courseEntityExtMapper;

    @Override
    public CourseBo createCourse(CourseTemplateBo courseTemplateBo, CourseBo courseBo, PartnerBo partnerBo,
            UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("courseTemplateBo is null");
        }
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO权限

        try {
            // Set Properties
            courseEntity.setCourseTemplateId(courseTemplateEntity.getId());
            courseEntity.setPartnerId(partnerEntity.getId());

            int result = 0;
            result = courseEntityExtMapper.add(courseEntity);
            if (result > 0) {
                return CourseConverter.toBo(courseEntity);
            } else {
                throw new ManagerException("Course Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("Course Create Failed");
        }
    }

    @Override
    public CourseBo submitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseEntityExtMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Submit Failed");
        }
    }

    @Override
    public CourseBo approveCourse(CourseBo courseBo, PartnerBo partnerBo,
            CommentCourseApproveBo commentCourseApproveBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseEntityExtMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Approved Failed");
        }
    }

    @Override
    public CourseBo rejectCourse(CourseBo courseBo, PartnerBo partnerBo, CommentCourseRejectBo commentCourseRejectBo,
            UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseEntityExtMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Reject Failed");
        }
    }

    @Override
    public CourseBo cancelCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseEntityExtMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Cancel Failed");
        }
    }

    @Override
    public CourseBo resubmitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseEntityExtMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Resubmit Failed");
        }
    }

    @Override
    public CourseBo deleteCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限

        try {
            courseEntityExtMapper.deleteById(courseEntity.getId());
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Delete Failed");
        }
    }

    @Override
    public CourseBo updateCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseEntityExtMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Update Failed");
        }
    }

    @Override
    public CourseBo commentCourse(CourseBo courseBo, CommentCourseBo commentCourseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // TODO 权限

        try {
            // TODO use CommentCourseBo
            // Set Properties By Using Info in CommentCourseBo
            courseEntityExtMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Comment Failed");
        }
    }

    @Override
    public List<CourseBo> queryByKeyword(String keyword) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourseBo> queryByPartner(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo,
            PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        List<CourseEntityExt> courseList = null;
        List<CourseBo> resultList = null;

        // TODO 权限

        try {
            // Should Set PartnerId ?
            courseEntity.setPartnerId(partnerEntity.getId());
            courseList = courseEntityExtMapper.list(courseEntity, pageEntity);
            for (CourseEntityExt coursePo : courseList) {
                resultList.add(CourseConverter.toBo(coursePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Course QueryByPartner Failed");
        }
    }

    @Override
    public List<CourseBo> queryByFilter(CourseBo courseBo, CategoryBo categoryBo, LocationBo locationBo,
            CircleBo circleBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }
        
        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        List<CourseEntityExt> courseList = null;
        List<CourseBo> resultList = null;

        try {
            // Set Properties
            // Category
            if (categoryBo != null) {
                CategoryEntityExt categoryEntity = CategoryConverter.fromBo(categoryBo);
                if ((categoryEntity.getId() == null || categoryEntity.getId() == 0)
                        && (categoryEntity.getIdSet() != null && categoryEntity.getIdSet().size() > 0)) {
                    // Set idSet
                    courseEntity.setCategoryIdSet(categoryEntity.getIdSet());
                } else if (categoryEntity.getId() != null && categoryEntity.getId() != 0) {
                    // Set id
                    courseEntity.setCategoryId(categoryEntity.getId());
                }
            }

            // Location
            if (locationBo != null) {
                LocationEntityExt locationEntity = LocationConverter.fromBo(locationBo);
                if ((locationEntity.getId() == null || locationEntity.getId() == 0)
                        && (locationEntity.getIdSet() != null && locationEntity.getIdSet().size() > 0)) {
                    // Set idSet
                    courseEntity.setLocationIdSet(locationEntity.getIdSet());
                } else if (locationEntity.getId() != null && locationEntity.getId() != 0) {
                    // Set id
                    courseEntity.setLocationId(locationEntity.getId());
                }
            }

            // Circle
            if (circleBo != null) {
                CircleEntityExt circleEntity = CircleConverter.fromBo(circleBo);
                if ((circleEntity.getId() == null || circleEntity.getId() == 0)
                        && (circleEntity.getIdSet() != null && circleEntity.getIdSet().size() > 0)) {
                    // Set idSet
                    courseEntity.setCircleIdSet(circleEntity.getIdSet());
                } else if (circleEntity.getId() != null && circleEntity.getId() != 0) {
                    // Set id
                    courseEntity.setCircleId(circleEntity.getId());
                }
            }

            courseList = courseEntityExtMapper.list(courseEntity, pageEntity);
            for (CourseEntityExt coursePo : courseList) {
                resultList.add(CourseConverter.toBo(coursePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Course QueryByFilter Failed");
        }
    }

    @Override
    public CourseBo queryById(CourseBo courseBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("courseBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // TODO 权限
            return CourseConverter.toBo(courseEntityExtMapper.getInfoById(courseEntity.getId()));
        } catch (Throwable t) {
            throw new ManagerException("Course GetById Failed");
        }
    }

}
