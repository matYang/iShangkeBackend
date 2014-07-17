package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.SpreadManager;

public class SpreadManagerImpl implements SpreadManager{
    private static final Logger LOGGER = LoggerFactory.getLogger(SpreadManagerImpl.class);

    @Override
    public SpreadBo generateCode(UserBo userBo, PartnerBo partnerBo, CourseBo courseBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SpreadBo> query(SpreadBo spreadBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SpreadBo createSpread(SpreadBo spreadBo, PartnerBo partnerBo, CourseBo courseBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SpreadBo approveSpread(SpreadBo spreadBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SpreadBo rejectSpread(SpreadBo spreadBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SpreadBo cancelSpread(SpreadBo spreadBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SpreadBo deleteSpread(SpreadBo spreadBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }
    
    

}
