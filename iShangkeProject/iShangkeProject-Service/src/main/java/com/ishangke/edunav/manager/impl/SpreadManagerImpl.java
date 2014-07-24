package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.SpreadEntityExtMapper;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.SpreadManager;

@Component
public class SpreadManagerImpl implements SpreadManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpreadManagerImpl.class);

    @Autowired
    private SpreadEntityExtMapper spreadMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public SpreadBo generateCode(UserBo userBo, PartnerBo partnerBo, CourseBo courseBo) {
        return null;
    }

    @Override
    public List<SpreadBo> query(SpreadBo spreadBo, UserBo userBo, PaginationBo paginationBo) {
        return null;
    }

    @Override
    public SpreadBo createSpread(SpreadBo spreadBo, PartnerBo partnerBo, CourseBo courseBo, UserBo userBo) {
        return null;
    }

    @Override
    public SpreadBo approveSpread(SpreadBo spreadBo, UserBo userBo) {
        return null;
    }

    @Override
    public SpreadBo rejectSpread(SpreadBo spreadBo, UserBo userBo) {
        return null;
    }

    @Override
    public SpreadBo cancelSpread(SpreadBo spreadBo, UserBo userBo) {
        return null;
    }

    @Override
    public SpreadBo deleteSpread(SpreadBo spreadBo, UserBo userBo) {
        return null;
    }

    
}
