package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.LocationEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.manager.CourseManager;
import com.ishangke.edunav.manager.converter.CategoryConverter;
import com.ishangke.edunav.manager.converter.CircleConverter;
import com.ishangke.edunav.manager.converter.CourseConverter;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.LocationConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class CourseManagerImpl implements CourseManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseManagerImpl.class);

    @Autowired
    private CourseEntityExtMapper courseMapper;

    @Override
    public CourseBo createCourse(CourseTemplateBo courseTemplateBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("Course Create Failed: courseTemplateBo is null");
        }
        if (courseBo == null) {
            throw new ManagerException("Course Create Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Create Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Create Failed: userBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseTemplateEntity.getId() == null || courseTemplateEntity.getId() == 0) {
            throw new ManagerException("Course Create Failed: 课程template的id为null或0");
        }
        if (courseTemplateEntity.getPartnerId() == null || courseTemplateEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Create Failed: 课程template的partnerId为null或0");
        }

        // Check whether the courseTemplate belongs to the partner
        if (courseTemplateEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Create Failed: 该课程tempalte不属于此合作商");
        }

        try {
            // Set Properties
            courseEntity.setCourseTemplateId(courseTemplateEntity.getId());
            courseEntity.setPartnerId(partnerEntity.getId());

            int result = 0;
            result = courseMapper.add(courseEntity);
            if (result > 0) {
                return CourseConverter.toBo(courseEntity);
            } else {
                throw new ManagerException("Course Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("Course Create Failed", t);
        }
    }

    @Override
    public CourseBo submitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course Submit Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Submit Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Submit Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseEntity.getPartnerId() == null || courseEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Submit Failed: 此课程的partnerId为null或0");
        }

        // Check whether the course belongs to the partner
        if (courseEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Submit Failed: 该课程不属于此合作商");
        }

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Submit Failed", t);
        }
    }

    @Override
    public CourseBo approveCourse(CourseBo courseBo, PartnerBo partnerBo, CommentCourseApproveBo commentCourseApproveBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course Approved Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Approved Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Approved Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseEntity.getPartnerId() == null || courseEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Approved Failed: 此课程的partnerId为null或0");
        }

        // Check whether the course belongs to the partner
        if (courseEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Approved Failed: 该课程不属于此合作商");
        }

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Approved Failed", t);
        }
    }

    @Override
    public CourseBo rejectCourse(CourseBo courseBo, PartnerBo partnerBo, CommentCourseRejectBo commentCourseRejectBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course Reject Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Reject Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Reject Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseEntity.getPartnerId() == null || courseEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Reject Failed: 此课程的partnerId为null或0");
        }

        // Check whether the course belongs to the partner
        if (courseEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Reject Failed: 该课程不属于此合作商");
        }

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Reject Failed", t);
        }
    }

    @Override
    public CourseBo cancelCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course Cancel Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Cancel Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Cancel Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseEntity.getPartnerId() == null || courseEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Cancel Failed: 此课程的partnerId为null或0");
        }

        // Check whether the course belongs to the partner
        if (courseEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Cancel Failed: 该课程不属于此合作商");
        }

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Cancel Failed", t);
        }
    }

    @Override
    public CourseBo resubmitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course Resubmit Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Resubmit Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Resubmit Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseEntity.getPartnerId() == null || courseEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Resubmit Failed: 此课程的partnerId为null或0");
        }

        // Check whether the course belongs to the partner
        if (courseEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Resubmit Failed: 该课程不属于此合作商");
        }

        try {
            // Change Status
            int status = 0;
            courseEntity.setStatus(status);
            courseMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Resubmit Failed", t);
        }
    }

    @Override
    public CourseBo deleteCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course Delete Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Delete Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Delete Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseEntity.getPartnerId() == null || courseEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Delete Failed: 此课程的partnerId为null或0");
        }

        // Check whether the course belongs to the partner
        if (courseEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Delete Failed: 该课程不属于此合作商");
        }

        try {
            courseMapper.deleteById(courseEntity.getId());
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Delete Failed", t);
        }
    }

    @Override
    public CourseBo updateCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course Update Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Update Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Update Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseEntity.getPartnerId() == null || courseEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Update Failed: 此课程的partnerId为null或0");
        }

        // Check whether the course belongs to the partner
        if (courseEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Update Failed: 该课程不属于此合作商");
        }

        try {
            courseMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Update Failed", t);
        }
    }

    @Override
    public CourseBo commentCourse(CourseBo courseBo, CommentCourseBo commentCourseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course Comment Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course Comment Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Comment Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseEntity.getPartnerId() == null || courseEntity.getPartnerId() == 0) {
            throw new ManagerException("Course Update Failed: 此课程的partnerId为null或0");
        }

        // Check whether the course belongs to the partner
        if (courseEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Course Update Failed: 该课程不属于此合作商");
        }

        try {
            // TODO use CommentCourseBo
            // Set Properties By Using Info in CommentCourseBo
            courseMapper.update(courseEntity);
            return CourseConverter.toBo(courseEntity);
        } catch (Throwable t) {
            throw new ManagerException("Course Comment Failed", t);
        }
    }

    @Override
    public List<CourseBo> queryByKeyword(String keyword) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourseBo> queryByPartner(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course QueryByPartner Failed: courseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Course QueryByPartner Failed: partnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course QueryByPartner Failed: userBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        List<CourseEntityExt> courseList = null;
        List<CourseBo> resultList = null;

        try {
            // TODO Should Set PartnerId ?
            courseEntity.setPartnerId(partnerEntity.getId());
            courseList = courseMapper.list(courseEntity, pageEntity);
            for (CourseEntityExt coursePo : courseList) {
                if (coursePo.getPartnerId() != partnerEntity.getId()) {
                    throw new ManagerException("Course QueryByPartner Failed: 该课程不属于此合作商");
                }
                resultList.add(CourseConverter.toBo(coursePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Course QueryByPartner Failed", t);
        }
    }

    @Override
    public List<CourseBo> queryByFilter(CourseBo courseBo, CategoryBo categoryBo, LocationBo locationBo, CircleBo circleBo, PaginationBo paginationBo) {
        CategoryEntityExt categoryEntity = null;
        LocationEntityExt locationEntity = null;
        CircleEntityExt circleEntity = null;
        PaginationEntity pageEntity = null;

        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course QueryByFilter Failed: courseBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        if (categoryBo != null) {
            categoryEntity = CategoryConverter.fromBo(categoryBo);
        }
        if (locationBo != null) {
            locationEntity = LocationConverter.fromBo(locationBo);
        }
        if (circleBo != null) {
            circleEntity = CircleConverter.fromBo(circleBo);
        }
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        List<CourseEntityExt> courseList = null;
        List<CourseBo> resultList = null;

        try {
            // Set Properties
            // Category
            if ((categoryEntity.getId() == null || categoryEntity.getId() == 0)
                    && (categoryEntity.getIdSet() != null && categoryEntity.getIdSet().size() > 0)) {
                // Set idSet
                courseEntity.setCategoryIdSet(categoryEntity.getIdSet());
            } else if (categoryEntity.getId() != null && categoryEntity.getId() != 0) {
                // Set id
                courseEntity.setCategoryId(categoryEntity.getId());
            }

            // Location
            if ((locationEntity.getId() == null || locationEntity.getId() == 0)
                    && (locationEntity.getIdSet() != null && locationEntity.getIdSet().size() > 0)) {
                // Set idSet
                courseEntity.setLocationIdSet(locationEntity.getIdSet());
            } else if (locationEntity.getId() != null && locationEntity.getId() != 0) {
                // Set id
                courseEntity.setLocationId(locationEntity.getId());
            }

            // Circle
            if ((circleEntity.getId() == null || circleEntity.getId() == 0)
                    && (circleEntity.getIdSet() != null && circleEntity.getIdSet().size() > 0)) {
                // Set idSet
                courseEntity.setCircleIdSet(circleEntity.getIdSet());
            } else if (circleEntity.getId() != null && circleEntity.getId() != 0) {
                // Set id
                courseEntity.setCircleId(circleEntity.getId());
            }

            courseList = courseMapper.list(courseEntity, pageEntity);
            for (CourseEntityExt coursePo : courseList) {
                if (categoryEntity != null && categoryEntity.getId() != null && categoryEntity.getId() > 0
                        && coursePo.getCategoryId() != categoryEntity.getId()) {
                    throw new ManagerException("Course QueryByFilter Failed: 此类目不属于此课程");
                }
                if (locationEntity != null && locationEntity.getId() != null && locationEntity.getId() > 0
                        && coursePo.getLocationId() != locationEntity.getId()) {
                    throw new ManagerException("Course QueryByFilter Failed: 此地区不属于此课程");
                }
                if (circleEntity != null && circleEntity.getId() != null && circleEntity.getId() > 0
                        && coursePo.getCircleId() != circleEntity.getId()) {
                    throw new ManagerException("Course QueryByFilter Failed: 此商圈不属于此课程");
                }
                resultList.add(CourseConverter.toBo(coursePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Course QueryByFilter Failed", t);
        }
    }

    @Override
    public CourseBo queryById(CourseBo courseBo, UserBo userBo) {
        // Check Null
        if (courseBo == null) {
            throw new ManagerException("Course GetById Failed: courseBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course GetById Failed: userBo is null");
        }

        // Convert
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);

        try {
            return CourseConverter.toBo(courseMapper.getInfoById(courseEntity.getId()));
        } catch (Throwable t) {
            throw new ManagerException("Course GetById Failed", t);
        }
    }

}
