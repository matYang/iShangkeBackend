package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.PartnerService;
import com.ishangke.edunav.manager.PartnerManager;

public class PartnerServiceImpl implements PartnerService.Iface{
    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerServiceImpl.class);
    
    @Autowired
    private PartnerManager partnerManager;
    

    @Override
    public List<PartnerBo> query(PartnerBo partnerBo, PaginationBo paginationBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PartnerBo queryById(PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PartnerBo updatePartner(PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PartnerBo createPartner(PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
}
