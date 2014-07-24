package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            throw new ManagerException("Invalid parameter");
        }
        
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == addressBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[AddressManagerImpl]system admin || admin[%s] call createAddress at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        int result = 0;
        try {
            result = addressMapper.add(addressEntity);
            
        } catch (Throwable t) {
            throw new ManagerException("Address creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            return AddressConverter.toBo(addressEntity);
        } else
            throw new ManagerException("Address creation failed for user: " + userEntity.getId());

    }

    @Override
    public AddressBo updateAddress(AddressBo addressBo, UserBo userBo) {
        // Check Null
        if (userBo == null || addressBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == addressBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[AddressManagerImpl]system admin || admin[%s] call updateAddress at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            addressMapper.update(addressEntity);
        } catch (Throwable t) {
            throw new ManagerException("Address update failed for user: " + userEntity.getId(), t);
        }
        
        return AddressConverter.toBo(addressEntity);
    }

    @Override
    public AddressBo deleteAddress(AddressBo addressBo, UserBo userBo) {
        // Check Null
        if (userBo == null || addressBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == addressBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[AddressManagerImpl]system admin || admin[%s] call deleteAddress at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        try {
            addressEntity.setDeleted(1);
            addressMapper.deleteById(addressEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("Address deletion failed for user: " + userEntity.getId(), t);
        }
        
        return AddressConverter.toBo(addressEntity);
    }

    @Override
    public List<AddressBo> query(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        
     // 验证用户是否属于此partner
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == addressBo.getPartnerId()) {
                isSameGroup = true;
                break;
            }
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[AddressManagerImpl]system admin || admin[%s] call query at " + new Date(), userBo.getName()));
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        AddressEntityExt addressEntity = addressBo == null ? null : AddressConverter.fromBo(addressBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);
        
        
        List<AddressEntityExt> results = null;
        try {
            results = addressMapper.list(addressEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("Address query failed for user: " + userEntity.getId(), t);
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

}
