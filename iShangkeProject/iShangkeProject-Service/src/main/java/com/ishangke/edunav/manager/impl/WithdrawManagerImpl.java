package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.WithdrawEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.WithdrawManager;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.converter.WithdrawConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.manager.exception.notfound.WithdrawNotFoundException;

@Component
public class WithdrawManagerImpl implements WithdrawManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawManagerImpl.class);

    @Autowired
    private WithdrawEntityExtMapper withdrawMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private AuthManager authManager;

    @Override
    public WithdrawBo createWithdraw(WithdrawBo withdrawBo, final UserBo userBo) {
        // 参数验证
        if (withdrawBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 插入新的WITHDRAW记录
        WithdrawEntityExt withdrawEntity = WithdrawConverter.fromBo(withdrawBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[WithdrawManagerImpl]system admin || admin[%s] call createWithdraw at " + new Date(), userBo.getName()));
        } else {
            if (withdrawEntity == null || IdChecker.notEqual(withdrawEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权创建他人的取款账户");
            }
        }

        withdrawEntity.setCreateTime(DateUtility.getCurTimeInstance());
        withdrawEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        withdrawEntity.setDeleted(0);
        withdrawEntity.setEnabled(0);
        int result = 0;
        try {
            result = withdrawMapper.add(withdrawEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，取款账户创建失败，请稍后再试", t);
        }
        if (result > 0) {
            return WithdrawConverter.toBo(withdrawMapper.getById(withdrawEntity.getId()));
        } else {
            throw new ManagerException("对不起，取款账户获取失败，请稍后再试");
        }
    }

    @Override
    public WithdrawBo updateWithdraw(WithdrawBo withdrawBo, final UserBo userBo) {
        // 参数验证
        if (withdrawBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 更新WITHDRAW记录
        WithdrawEntityExt withdrawEntity = WithdrawConverter.fromBo(withdrawBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        if (IdChecker.isNull(withdrawEntity.getId())) {
            throw new ManagerException("更新取款账户时必须标注取款账户ID");
        }
        WithdrawEntityExt previousWithdraw = withdrawMapper.getById(withdrawEntity.getId());
        if (previousWithdraw == null) {
            throw new WithdrawNotFoundException("对不起，无法找到ID为" + withdrawEntity.getId() + "的取款账户");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[WithdrawManagerImpl]system admin || admin [%s] call updateWithdraw at " + new Date(), userBo.getName()));
        } else {
            if (IdChecker.notEqual(previousWithdraw.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权更改他人的取款账户");
            }
        }

        withdrawEntity.setUserId(null);
        withdrawEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        withdrawEntity.setCreateTime(null);
        withdrawEntity.setDeleted(null);
        try {
            withdrawMapper.update(withdrawEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，取款账户更新失败，请稍后再试", t);
        }

        return WithdrawConverter.toBo(withdrawMapper.getById(withdrawEntity.getId()));
    }

    @Override
    public WithdrawBo deleteWithdraw(WithdrawBo withdrawBo, final UserBo userBo) {
        // 参数验证
        if (withdrawBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 删除WITHDRAW记录
        WithdrawEntityExt withdrawEntity = WithdrawConverter.fromBo(withdrawBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        if (IdChecker.isNull(withdrawEntity.getId())) {
            throw new ManagerException("删除取款账户时必须标注取款账户ID");
        }
        WithdrawEntityExt previousWithdraw = withdrawMapper.getById(withdrawEntity.getId());
        if (previousWithdraw == null) {
            throw new WithdrawNotFoundException("对不起，无法找到ID为" + withdrawEntity.getId() + "的取款账户");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[WithdrawManagerImpl]system admin || admin [%s] call deleteWithdraw at " + new Date(), userBo.getName()));
        } else {
            if (IdChecker.notEqual(previousWithdraw.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权删除他人的取款账户");
            }
        }

        try {
            previousWithdraw.setDeleted(1);
            withdrawMapper.deleteById(previousWithdraw.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，取款账户删除失败，请稍后再试", t);
        }

        return WithdrawConverter.toBo(previousWithdraw);
    }

    @Override
    public List<WithdrawBo> query(final WithdrawBo withdrawBo, final UserBo userBo, final PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        WithdrawEntityExt withdrawEntity = withdrawBo == null ? null : WithdrawConverter.fromBo(withdrawBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // admin and system admins can query user's withdraws
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[WithdrawManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only query their own, thus making an UserId
            // necessary
            if (withdrawEntity == null || IdChecker.notEqual(withdrawEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权查询他人的取款账户");
            }
        }

        List<WithdrawEntityExt> results = null;
        try {
            results = withdrawMapper.list(withdrawEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，取款账户查询失败，请稍后再试", t);
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

    @Override
    public int queryTotal(WithdrawBo withdrawBo, UserBo userBo) {
        return withdrawMapper.getListCount(WithdrawConverter.fromBo(withdrawBo));
    }
}
