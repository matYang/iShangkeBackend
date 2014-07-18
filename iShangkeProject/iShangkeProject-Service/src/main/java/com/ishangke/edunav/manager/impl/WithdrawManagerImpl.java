package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.WithdrawEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;
import com.ishangke.edunav.manager.WithdrawManager;
import com.ishangke.edunav.manager.converter.WithdrawConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class WithdrawManagerImpl implements WithdrawManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawManagerImpl.class);

    @Autowired
    private WithdrawEntityExtMapper withdrawMapper;

    @Override
    public WithdrawBo createWithdraw(WithdrawBo withdrawBo, final UserBo userBo) {
        // 参数验证
        if (withdrawBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 插入新的WITHDRAW记录
        WithdrawEntityExt withdrawEntity = WithdrawConverter.fromBo(withdrawBo);
        int result = 0;
        try {
            result = withdrawMapper.add(withdrawEntity);
        } catch (Throwable t) {
            LOGGER.debug(t.getMessage(), t);
            throw new ManagerException("Withdraw creation failed for user: " + userBo.getId(), t);
        }
        if (result > 0) {
            return WithdrawConverter.toBo(withdrawEntity);
        } else {
            throw new ManagerException("Withdraw creation failed for user: " + userBo.getId());
        }
    }

    @Override
    public WithdrawBo updateWithdraw(WithdrawBo withdrawBo, final UserBo userBo) {
        // 参数验证
        if (withdrawBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 更新WITHDRAW记录
        WithdrawEntityExt withdrawEntity = WithdrawConverter.fromBo(withdrawBo);
        try {
            withdrawMapper.update(withdrawEntity);
        } catch (Throwable t) {
            LOGGER.debug(t.getMessage(), t);
            throw new ManagerException("Withdraw creation failed for user: " + userBo.getId(), t);
        }

        return WithdrawConverter.toBo(withdrawEntity);
    }

    @Override
    public WithdrawBo deleteWithdraw(WithdrawBo withdrawBo, final UserBo userBo) {
        // 参数验证
        if (withdrawBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // 更新WITHDRAW记录
        WithdrawEntityExt withdrawEntity = WithdrawConverter.fromBo(withdrawBo);
        try {
            withdrawMapper.deleteById(withdrawEntity.getId());
            withdrawEntity.setDeleted(1);
        } catch (Throwable t) {
            LOGGER.debug(t.getMessage(), t);
            throw new ManagerException("Withdraw creation failed for user: " + userBo.getId(), t);
        }

        return WithdrawConverter.toBo(withdrawEntity);
    }

    @Override
    public List<WithdrawBo> query(final WithdrawBo withdrawBo, final UserBo userBo, final PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        WithdrawEntityExt withdrawEntity = WithdrawConverter.fromBo(withdrawBo);
        PaginationEntity page = null;
        // TODO
        // PaginationEntity page =
        // PaginationConverter.fromBo(paginationBo);
        List<WithdrawEntityExt> results = null;
        try {
            results = withdrawMapper.list(withdrawEntity, page);
        } catch (Throwable t) {
            LOGGER.debug(t.getMessage(), t);
            throw new ManagerException("Withdraw query failed", t);
        }

        if (results == null) {
            return new ArrayList<WithdrawBo>();
        }
        List<WithdrawBo> convertedResults = new ArrayList<WithdrawBo>();
        for (WithdrawEntityExt result : results) {
            convertedResults.add(WithdrawConverter.toBo(result));
        }
        return convertedResults;
    }
}
