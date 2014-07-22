package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.ActivityEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.PartnerEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.ActivityManager;
import com.ishangke.edunav.manager.converter.ActivityConverter;
import com.ishangke.edunav.manager.converter.CourseConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class ActivityManagerImpl implements ActivityManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityManagerImpl.class);

    @Autowired
    private CourseEntityExtMapper courseEntityExtMapper;
    @Autowired
    private PartnerEntityExtMapper partnerEntityExtMapper;
    @Autowired
    private UserEntityExtMapper userEntityExtMapper;
    @Autowired
    private ActivityEntityExtMapper activityEntityExtMapper;

    @Override
    public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("ActivityBo is null");
        }
        if (courseBo == null) {
            throw new ManagerException("CourseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // TODO 权限
            // Set properties
            activityEntity.setCourseId(courseEntity.getId());
            activityEntity.setPartnerId(partnerEntity.getId());

            // Create Activity
            int result = 0;
            result = activityEntityExtMapper.add(activityEntity);
            if (result > 0) {
                return ActivityConverter.toBo(activityEntity);
            } else {
                throw new ManagerException("Activity Create failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("Activity Create failed", t);
        }
    }

    @Override
    public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        ActivityBo result = null;

        try {
            // TODO 权限
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityEntityExtMapper.update(activityEntity);
            result = ActivityConverter.toBo(activityEntity);
            return result;
        } catch (Throwable t) {
            throw new ManagerException("Activity Submit failed", t);
        }

    }

    @Override
    public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        ActivityBo result = null;

        try {
            // TODO 权限
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityEntityExtMapper.update(activityEntity);
            result = ActivityConverter.toBo(activityEntity);
            return result;
        } catch (Throwable t) {
            throw new ManagerException("Activity Approve failed", t);
        }
    }

    @Override
    public ActivityBo rejectActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Partner is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        ActivityBo result = null;

        try {
            // TODO 权限
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityEntityExtMapper.update(activityEntity);
            result = ActivityConverter.toBo(activityEntity);
            return result;
        } catch (Throwable t) {
            throw new ManagerException("Activity Reject failed", t);
        }
    }

    @Override
    public ActivityBo cancelActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Partner is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        ActivityBo result = null;

        try {
            // TODO 权限
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityEntityExtMapper.update(activityEntity);
            result = ActivityConverter.toBo(activityEntity);
            return result;
        } catch (Throwable t) {
            throw new ManagerException("Activity Cancel failed", t);
        }
    }

    @Override
    public ActivityBo deleteActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Partner is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        ActivityBo result = null;

        try {
            // TODO 权限
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityEntityExtMapper.update(activityEntity);
            result = ActivityConverter.toBo(activityEntity);
            return result;
        } catch (Throwable t) {
            throw new ManagerException("Activity Delete failed", t);
        }
    }

    @Override
    public List<ActivityBo> query(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (activityBo == null) {
            throw new ManagerException("ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Partner is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        List<ActivityEntityExt> activityList = null;
        List<ActivityBo> resultList = null;

        try {
            // TODO 权限
            activityList = activityEntityExtMapper.list(activityEntity, pageEntity);
            for (ActivityEntityExt activityPo : activityList) {
                resultList.add(ActivityConverter.toBo(activityPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Activity Query failed", t);
        }
    }

}
