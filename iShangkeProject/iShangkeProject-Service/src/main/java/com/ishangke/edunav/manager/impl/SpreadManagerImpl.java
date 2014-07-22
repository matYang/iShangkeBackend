package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.enums.SpreadEnums;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.SpreadEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.SpreadManager;
import com.ishangke.edunav.manager.converter.CourseConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.SpreadConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class SpreadManagerImpl implements SpreadManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpreadManagerImpl.class);

    @Autowired
    private SpreadEntityExtMapper spreadMapper;

    @Override
    public SpreadBo generateCode(UserBo userBo, PartnerBo partnerBo, CourseBo courseBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SpreadBo> query(SpreadBo spreadBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        SpreadEntityExt spreadEntity = spreadBo == null ? null : SpreadConverter.fromBo(spreadBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        List<SpreadEntityExt> results = null;
        try {
            results = spreadMapper.list(spreadEntity, page);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Spread query failed for user: " + userEntity.getId(), t);
        }

        if (results == null) {
            return new ArrayList<SpreadBo>();
        }
        List<SpreadBo> convertedResults = new ArrayList<SpreadBo>();
        for (SpreadEntityExt result : results) {
            convertedResults.add(SpreadConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public SpreadBo createSpread(SpreadBo spreadBo, PartnerBo partnerBo, CourseBo courseBo, UserBo userBo) {
        if (spreadBo == null || userBo == null || partnerBo == null || courseBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 插入新的spread记录
        SpreadEntityExt spreadEntity = SpreadConverter.fromBo(spreadBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        CourseEntityExt courseEntity = CourseConverter.fromBo(courseBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        spreadEntity.setUserId(userEntity.getId());
        spreadEntity.setPartnerId(partnerEntity.getId());
        spreadEntity.setCourseId(courseEntity.getId());

        int result = 0;
        try {
            spreadEntity.setStatus(SpreadEnums.Status.NAIVE.code);
            result = spreadMapper.add(spreadEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Spread creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            return SpreadConverter.toBo(spreadEntity);
        } else {
            throw new ManagerException("Spread creation failed for user: " + userEntity.getId());
        }
    }

    @Override
    public SpreadBo approveSpread(SpreadBo spreadBo, UserBo userBo) {
        if (spreadBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        SpreadEntityExt spreadEntity = SpreadConverter.fromBo(spreadBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        // only if a spread is in naive state can it be approved
        if (spreadEntity.getStatus() == SpreadEnums.Status.NAIVE.code) {
            spreadEntity.setStatus(SpreadEnums.Status.APPROVED.code);
        } else {
            throw new ManagerException("Spread approval failed for user: " + userEntity.getId());
        }

        try {
            spreadMapper.update(spreadEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Spread approval failed for user: " + userEntity.getId(), t);
        }

        return SpreadConverter.toBo(spreadEntity);
    }

    @Override
    public SpreadBo rejectSpread(SpreadBo spreadBo, UserBo userBo) {
        if (spreadBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        SpreadEntityExt spreadEntity = SpreadConverter.fromBo(spreadBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        // only if a spread is in naive state can it be rejected
        if (spreadEntity.getStatus() == SpreadEnums.Status.NAIVE.code) {
            spreadEntity.setStatus(SpreadEnums.Status.REJECTED.code);
        } else {
            throw new ManagerException("Spread approval failed for user: " + userEntity.getId());
        }

        try {
            spreadMapper.update(spreadEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Spread approval failed for user: " + userEntity.getId(), t);
        }

        return SpreadConverter.toBo(spreadEntity);
    }

    @Override
    public SpreadBo cancelSpread(SpreadBo spreadBo, UserBo userBo) {
        if (spreadBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        SpreadEntityExt spreadEntity = SpreadConverter.fromBo(spreadBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        // only if a spread is in naive state can it be rejected
        if (spreadEntity.getStatus() == SpreadEnums.Status.NAIVE.code) {
            spreadEntity.setStatus(SpreadEnums.Status.CANCELLED.code);
        } else {
            throw new ManagerException("Spread approval failed for user: " + userEntity.getId());
        }

        try {
            spreadMapper.update(spreadEntity);
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Spread approval failed for user: " + userEntity.getId(), t);
        }

        return SpreadConverter.toBo(spreadEntity);
    }

    @Override
    public SpreadBo deleteSpread(SpreadBo spreadBo, UserBo userBo) {
        if (spreadBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        SpreadEntityExt spreadEntity = SpreadConverter.fromBo(spreadBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            spreadEntity.setDeleted(1);
            spreadMapper.deleteById(spreadEntity.getId());
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Spread deletion failed for user: " + userEntity.getId(), t);
        }

        return SpreadConverter.toBo(spreadEntity);
    }

}
