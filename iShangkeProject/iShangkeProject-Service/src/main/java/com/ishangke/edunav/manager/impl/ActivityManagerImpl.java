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
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.ActivityManager;
import com.ishangke.edunav.manager.AuthManager;
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
    private ActivityEntityExtMapper activityMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("Activity Create Failed: ActivityBo is null");
        }
        if (courseBo == null) {
            throw new ManagerException("Activity Create Failed: CourseBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Activity Create Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Activity Create Failed: UserBo is null");
        }

        // Convert
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        try {
            // Set properties
            activityEntity.setCourseId(courseEntity.getId());
            activityEntity.setPartnerId(partnerEntity.getId());

            // Create Activity
            int result = 0;
            result = activityMapper.add(activityEntity);
            if (result > 0) {
                return ActivityConverter.toBo(activityEntity);
            } else {
                throw new ManagerException("Activity Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("Activity Create Failed", t);
        }
    }

    @Override
    public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("Activity Submit Failed: ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Activity Submit Failed: UserBo is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);

        try {
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityMapper.update(activityEntity);
            return ActivityConverter.toBo(activityEntity);
        } catch (Throwable t) {
            throw new ManagerException("Activity Submit Failed", t);
        }

    }

    @Override
    public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("Activity Approve Failed: ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Activity Approve Failed UserBo is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);

        try {
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityMapper.update(activityEntity);
            return ActivityConverter.toBo(activityEntity);
        } catch (Throwable t) {
            throw new ManagerException("Activity Approve Failed", t);
        }
    }

    @Override
    public ActivityBo rejectActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (activityBo == null) {
            throw new ManagerException("ActivityBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Activity Reject Failed: UserBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("Activity Reject Failed: Partner is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        ActivityEntityExt activityEntity = ActivityConverter.fromBo(activityBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (partnerEntity.getId() == null || partnerEntity.getId() == 0) {
            throw new ManagerException("Activity Reject Failed: 合作商id为null或0");
        }
        if (activityEntity.getPartnerId() == null || activityEntity.getPartnerId() == 0) {
            throw new ManagerException("Activity Reject Failed: 活动的partnerId为null或0");
        }
        // Check whether the activity belongs to the partner
        if (activityEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Activity Reject Failed: 该活动不属于此合作商");
        }

        try {
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityMapper.update(activityEntity);
            return ActivityConverter.toBo(activityEntity);
        } catch (Throwable t) {
            throw new ManagerException("Activity Reject Failed", t);
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

        // Check Ids
        if (partnerEntity.getId() == null || partnerEntity.getId() == 0) {
            throw new ManagerException("Activity Cancel Failed: 合作商id为null或0");
        }
        if (activityEntity.getPartnerId() == null || activityEntity.getPartnerId() == 0) {
            throw new ManagerException("Activity Cancel Failed: 活动的partnerId为null或0");
        }
        // Check whether the activity belongs to the partner
        if (activityEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Activity Cancel Failed: 该活动不属于此合作商");
        }

        try {
            // TODO status
            int status = 0;
            activityEntity.setStatus(status);
            activityMapper.update(activityEntity);
            return ActivityConverter.toBo(activityEntity);
        } catch (Throwable t) {
            throw new ManagerException("Activity Cancel Failed", t);
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

        // Check Ids
        if (partnerEntity.getId() == null || partnerEntity.getId() == 0) {
            throw new ManagerException("Activity Delete Failed: 合作商id为null或0");
        }
        if (activityEntity.getPartnerId() == null || activityEntity.getPartnerId() == 0) {
            throw new ManagerException("Activity Delete Failed: 活动的partnerId为null或0");
        }
        // Check whether the activity belongs to the partner
        if (activityEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Activity Delete Failed: 该活动不属于此合作商");
        }

        try {
            activityMapper.deleteById(activityEntity.getId());
            return ActivityConverter.toBo(activityEntity);
        } catch (Throwable t) {
            throw new ManagerException("Activity Delete Failed", t);
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

        // Check Ids
        if (partnerEntity.getId() == null || partnerEntity.getId() == 0) {
            throw new ManagerException("Activity Query Failed: 合作商id为null或0");
        }

        try {
            activityList = activityMapper.list(activityEntity, pageEntity);
            for (ActivityEntityExt activityPo : activityList) {
                if (activityPo.getPartnerId() != partnerEntity.getId()) {
                    throw new ManagerException("Activity Query Failed: 该活动不属于此合作商");
                }
                resultList.add(ActivityConverter.toBo(activityPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Activity Query Failed", t);
        }
    }

}
