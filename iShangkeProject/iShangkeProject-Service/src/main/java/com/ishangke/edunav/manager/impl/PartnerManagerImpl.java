package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.PartnerEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.PartnerManager;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.notfound.PartnerNotFoundException;

@Component
public class PartnerManagerImpl implements PartnerManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerManagerImpl.class);

    @Autowired
    private PartnerEntityExtMapper partnerMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public List<PartnerBo> query(PartnerBo partnerBo, PaginationBo paginationBo, UserBo userBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        PartnerEntityExt partnerEntity = partnerBo == null ? null : PartnerConverter.fromBo(partnerBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        List<PartnerEntityExt> results = null;
        try {
            results = partnerMapper.list(partnerEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Partner query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<PartnerBo>();
        }
        List<PartnerBo> convertedResults = new ArrayList<PartnerBo>();
        for (PartnerEntityExt result : results) {
            convertedResults.add(PartnerConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public PartnerBo queryById(PartnerBo partnerBo, UserBo userBo) {
        if (partnerBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        PartnerEntityExt result = null;
        try {
            result = partnerMapper.getById(partnerEntity.getId());
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Partner queryById failed for user: " + userEntity.getId(), t);
        }

        if (result == null) {
            throw new PartnerNotFoundException();
        }
        return PartnerConverter.toBo(result);
    }

    @Override
    public PartnerBo updatePartner(PartnerBo partnerBo, UserBo userBo) {
        if (partnerBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 更新partner记录
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            partnerMapper.update(partnerEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Partner update failed for user: " + userEntity.getId(), t);
        }

        return PartnerConverter.toBo(partnerEntity);
    }

    @Override
    public PartnerBo createPartner(PartnerBo partnerBo, UserBo userBo) {
        if (partnerBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 插入新的partner记录
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        int result = 0;
        try {
            result = partnerMapper.add(partnerEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Partner creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            return PartnerConverter.toBo(partnerEntity);
        } else {
            throw new ManagerException("Partner creation failed for user: " + userEntity.getId());
        }
    }

}
