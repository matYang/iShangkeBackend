package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.DefaultValue;
import com.ishangke.edunav.common.enums.CreditHistoryEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AccountEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CreditEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CreditHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CreditManager;
import com.ishangke.edunav.manager.converter.CreditConverter;
import com.ishangke.edunav.manager.converter.CreditHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.manager.exception.notfound.CreditNotFoundException;

@Component
public class CreditManagerImpl implements CreditManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditManagerImpl.class);

    @Autowired
    private CreditEntityExtMapper creditMapper;
    @Autowired
    private CouponEntityExtMapper couponMapper;
    @Autowired
    private UserEntityExtMapper userMapper;
    @Autowired
    private AccountEntityExtMapper accountMapper;
    @Autowired
    private CreditHistoryEntityExtMapper creditHistoryMapper;
    @Autowired
    private AuthManager authManager;

    @Override
    public CreditBo modifyCredit(CreditBo creditBo, UserBo userBo) {
        if (creditBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        CreditEntityExt creditEntity = CreditConverter.fromBo(creditBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(creditEntity.getId())) {
            throw new ManagerException("更改积分时必须标注对应用户");
        }
        CreditEntityExt previousCredit = creditMapper.getById(creditEntity.getId());
        if (previousCredit == null) {
            throw new CreditNotFoundException("对不起，未找到对应ID为" + creditEntity.getId() + "的积分记录");
        }

        // admin and system admins can query user's credits
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CreditManagerImpl]system admin || admin [%s] call modifyCredit at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only modify their own, thus making an UserId
            // necessary
            if (IdChecker.notEqual(previousCredit.getId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权更改他人的积分");
            }
        }

        // TODO we probably need a way to tell how much credit is used instead
        // reading previous credit out
        double balanceDiff = previousCredit.getCredit() - creditEntity.getCredit();
        int operation = CreditHistoryEnums.Operation.DEC.code;
        if (balanceDiff < -DefaultValue.DOUBLEPRCISIONOFFSET) {
            balanceDiff = -balanceDiff;
            operation = CreditHistoryEnums.Operation.INC.code;
        }
        CreditHistoryEntityExt creditHistory = new CreditHistoryEntityExt();
        creditHistory.setUserId(creditEntity.getId());
        creditHistory.setCharge(balanceDiff);
        creditHistory.setOperation(operation);
        creditHistory.setLastModifyTime(DateUtility.getCurTimeInstance());
        creditHistory.setCreateTime(DateUtility.getCurTimeInstance());
        creditHistory.setDeleted(0);

        creditEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        creditEntity.setCreateTime(null);
        creditEntity.setDeleted(null);
        
        int historyResult = 0;
        try {
            creditMapper.update(creditEntity);
            historyResult = creditHistoryMapper.add(creditHistory);
        } catch (Throwable t) {
            throw new ManagerException("对不起，积分更改失败，请稍后再试", t);
        }
        if (historyResult <= 0) {
            throw new ManagerException("对不起，积分历史记录创建失败，请稍后再试");
        }

        return CreditConverter.toBo(creditMapper.getById(creditEntity.getId()));
    }

    @Override
    public CreditBo exchangeCoupon(CreditBo creditBo, CouponBo couponBo, UserBo userBo) {
        return null;
        // TODO
        // if (creditBo == null || couponBo != null || userBo == null) {
        // throw new ManagerException("无效请求参数");
        // }
        //
        // CreditEntityExt creditEntity = CreditConverter.fromBo(creditBo);
        // UserEntityExt userEntity = UserConverter.fromBo(userBo);
        // CouponEntityExt couponEntity = CouponConverter.fromBo(couponBo);
        //
        // // Check Ids
        // if (creditEntity.getId() == null || creditEntity.getId() == 0) {
        // throw new ManagerException("积分id为null或0");
        // }
        // if (couponEntity.getId() == null || couponEntity.getId() == 0) {
        // throw new ManagerException("优惠劵id为null或0");
        // }
        //
        // // Check whether this credit or coupon belongs to the user
        // if (creditEntity.getId() != userEntity.getId()) {
        // throw new ManagerException("此积分不是该用户的");
        // }
        // if (couponEntity.getUserId() != userEntity.getId()) {
        // throw new ManagerException("此优惠劵不是该用户的");
        // }
        //
        // try {
        // creditMapper.update(creditEntity);
        // } catch (Throwable t) {
        // LOGGER.warn(t.getMessage(), t);
        // throw new ManagerException("Credit ExchangeCoupon Failed for user: "
        // + userEntity.getId(), t);
        // }
        //
        // return CreditConverter.toBo(creditEntity);
    }

    @Override
    public CreditBo exchangeAccount(CreditBo creditBo, AccountBo accountBo, UserBo userBo) {
        return null;
        // TODO
        // if (creditBo == null || accountBo != null || userBo == null) {
        // throw new ManagerException("无效请求参数");
        // }
        //
        // CreditEntityExt creditEntity = CreditConverter.fromBo(creditBo);
        // UserEntityExt userEntity = UserConverter.fromBo(userBo);
        //
        // try {
        // creditMapper.update(creditEntity);
        // } catch (Throwable t) {
        // LOGGER.warn(t.getMessage(), t);
        // throw new ManagerException("Credit update failed for user: " +
        // userEntity.getId(), t);
        // }
        //
        // return CreditConverter.toBo(creditEntity);
    }

    @Override
    public List<CreditBo> query(CreditBo creditBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        CreditEntityExt creditEntity = creditBo == null ? null : CreditConverter.fromBo(creditBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        // admin and system admins can query user's credits
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CreditManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only query their own, thus making an UserId
            // necessary
            if (creditEntity == null || IdChecker.notEqual(creditEntity.getId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权查询他人的积分");
            }
        }

        List<CreditEntityExt> results = null;
        try {
            results = creditMapper.list(creditEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，积分查询失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<CreditBo>();
        }
        List<CreditBo> convertedResults = new ArrayList<CreditBo>();
        for (CreditEntityExt result : results) {
            convertedResults.add(CreditConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public List<CreditHistoryBo> queryHistory(CreditHistoryBo creditHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        CreditHistoryEntityExt creditHistoryEntity = creditHistoryBo == null ? null : CreditHistoryConverter.fromBo(creditHistoryBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        // admin and system admins can query user's credits
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[CreditManagerImpl]system admin || admin [%s] call queryHistory at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only query their own, thus making an UserId
            // necessary
            if (creditHistoryEntity == null || IdChecker.notEqual(creditHistoryEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权查询他人的积分历史记录");
            }
        }

        List<CreditHistoryEntityExt> results = null;
        try {
            results = creditHistoryMapper.list(creditHistoryEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，积分历史记录查询失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<CreditHistoryBo>();
        }
        List<CreditHistoryBo> convertedResults = new ArrayList<CreditHistoryBo>();
        for (CreditHistoryEntityExt result : results) {
            convertedResults.add(CreditHistoryConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public int queryTotal(CreditBo creditBo, UserBo userBo) {
        return creditMapper.getListCount(CreditConverter.fromBo(creditBo));
    }

    @Override
    public int queryHistoryTotal(CreditHistoryBo creditHistoryBo, UserBo userBo) {
        return creditHistoryMapper.getListCount(CreditHistoryConverter.fromBo(creditHistoryBo));
    }

}
