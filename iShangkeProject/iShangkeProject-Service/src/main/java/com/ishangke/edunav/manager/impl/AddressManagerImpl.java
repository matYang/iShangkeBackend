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
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AddressEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AddressManager;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.converter.AddressConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.notfound.AddressNotFoundException;

@Component
public class AddressManagerImpl implements AddressManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressManagerImpl.class);

    @Autowired
    private AddressEntityExtMapper addressMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private AuthManager authManager;

    @Override
    public AddressBo createAddress(AddressBo addressBo, UserBo userBo) {
        // Check Null
        if (userBo == null || addressBo == null) {
            throw new ManagerException("无效请求参数");
        }

        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[AddressManagerImpl]system admin || admin[%s] call createAddress at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), addressBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        // Convert
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(addressEntity.getPartnerId())) {
            throw new ManagerException("创建校区地址时必须标注合作商ID");
        }
        addressEntity.setCreateTime(DateUtility.getCurTimeInstance());
        addressEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        addressEntity.setEnabled(0);
        ;
        addressEntity.setDeleted(0);
        int result = 0;
        try {
            result = addressMapper.add(addressEntity);
        } catch (Throwable t) {
            LOGGER.warn("[AddressManagerImpl] error for user " + userEntity.getId() + "at" + new Date());
            throw new ManagerException("对不起，创建校区地址失败，请稍后再试", t);
        }
        if (result > 0) {
            return AddressConverter.toBo(addressMapper.getById(addressEntity.getId()));
        } else
            LOGGER.warn("[AddressManagerImpl] error for user " + userEntity.getId() + "at" + new Date());
            throw new ManagerException("对不起，创建校区地址失败，请稍后再试");

    }

    @Override
    public AddressBo updateAddress(AddressBo addressBo, UserBo userBo) {
        // Check Null
        if (userBo == null || addressBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(addressEntity.getId())) {
            throw new ManagerException("更新校区地址时必须标注校区地址ID");
        }
        AddressEntityExt previousAddress = addressMapper.getById(addressEntity.getId());
        if (previousAddress == null) {
            throw new AddressNotFoundException("对不起，没有找到ID为" + addressEntity.getId() + "的校区地址");
        }

        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[AddressManagerImpl]system admin || admin[%s] call updateAddress at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), previousAddress.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        addressEntity.setPartnerId(null);
        addressEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        addressEntity.setCreateTime(null);
        addressEntity.setEnabled(null);
        try {
            addressMapper.update(addressEntity);
        } catch (Throwable t) {
            LOGGER.warn("[AddressManagerImpl] error for user " + userEntity.getId() + "at" + new Date());
            throw new ManagerException("对不起，更新校区地址失败，请稍后再试", t);
        }

        return AddressConverter.toBo(addressMapper.getById(addressEntity.getId()));
    }

    @Override
    public AddressBo deleteAddress(AddressBo addressBo, UserBo userBo) {
        // Check Null
        if (userBo == null || addressBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);
        if (IdChecker.isNull(addressEntity.getId())) {
            throw new ManagerException("删除校区地址时必须标注校区地址ID");
        }
        AddressEntityExt previousAddress = addressMapper.getById(addressEntity.getId());
        if (previousAddress == null) {
            throw new AddressNotFoundException("对不起，没有找到ID为" + addressEntity.getId() + "的校区地址");
        }

        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[AddressManagerImpl]system admin || admin[%s] call deleteAddress at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), previousAddress.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        try {
            previousAddress.setDeleted(1);
            addressMapper.deleteById(previousAddress.getId());
        } catch (Throwable t) {
            LOGGER.warn("[AddressManagerImpl] error for user " + userEntity.getId() + "at" + new Date());
            throw new ManagerException("对不起，删除校区地址失败，请稍后再试", t);
        }

        return AddressConverter.toBo(previousAddress);
    }

    @Override
    public List<AddressBo> query(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 验证用户是否属于此partner
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[AddressManagerImpl]system admin || admin[%s] call query at " + new Date(), userBo.getName()));
        } else {
            if (addressBo == null) {
                throw new ManagerException("非管理员用户无权查询全部校区地址");
            }
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), addressBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }

        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        // Convert
        AddressEntityExt addressEntity = addressBo == null ? null : AddressConverter.fromBo(addressBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        List<AddressEntityExt> results = null;
        try {
            results = addressMapper.list(addressEntity, page);
        } catch (Throwable t) {
            LOGGER.warn("[AddressManagerImpl] error for user " + userEntity.getId() + "at" + new Date());
            throw new ManagerException("对不起，校区地址查询失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<AddressBo>();
        }
        List<AddressBo> convertedResults = new ArrayList<AddressBo>();
        for (AddressEntityExt result : results) {
            convertedResults.add(AddressConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public int queryTotal(AddressBo addressBo, UserBo userBo) {
        return addressMapper.getListCount(AddressConverter.fromBo(addressBo));
    }

}
