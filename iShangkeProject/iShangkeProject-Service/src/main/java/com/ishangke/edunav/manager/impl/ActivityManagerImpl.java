package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.ActivityEntityExtMapper;
import com.ishangke.edunav.manager.ActivityManager;
import com.ishangke.edunav.manager.AuthManager;

@Component
public class ActivityManagerImpl implements ActivityManager {
    //private static final Logger LOGGER = LoggerFactory.getLogger(ActivityManagerImpl.class);

    @Autowired
    private ActivityEntityExtMapper activityMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public ActivityBo createActivity(ActivityBo activityBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        return null;
    }

    @Override
    public ActivityBo submitActivity(ActivityBo activityBo, UserBo userBo) {
        return null;
    }

    @Override
    public ActivityBo approveActivity(ActivityBo activityBo, UserBo userBo) {
        return null;
    }

    @Override
    public ActivityBo rejectActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) {
        return null;
    }

    @Override
    public ActivityBo cancelActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) {
        return null;
    }

    @Override
    public ActivityBo deleteActivity(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) {
        return null;
    }

    @Override
    public List<ActivityBo> query(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        return null;
    }

    @Override
    public int queryTotal(ActivityBo activityBo, PartnerBo partnerBo, UserBo userBo) {
        return 0;
    }

}
