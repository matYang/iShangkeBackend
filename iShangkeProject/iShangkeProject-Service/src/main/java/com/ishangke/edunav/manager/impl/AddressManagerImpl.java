package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.AddressEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.PartnerEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.AddressManager;
import com.ishangke.edunav.manager.converter.AddressConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class AddressManagerImpl implements AddressManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressManagerImpl.class);

    @Autowired
    private UserEntityExtMapper userEntityExtMapper;
    @Autowired
    private PartnerEntityExtMapper partnerEntityExtMapper;
    @Autowired
    private AddressEntityExtMapper addressEntityExtMapper;

    @Override
    public AddressBo createAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo) {
        // Check Null
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (addressBo == null) {
            throw new ManagerException("Address is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);

        try {
            addressEntity.setPartnerId(partnerEntity.getId());
            // TODO 权限
            int result = 0;
            result = addressEntityExtMapper.add(addressEntity);
            if (result > 0) {
                return AddressConverter.toBo(addressEntity);
            } else
                throw new ManagerException("Address Create Failed");
        } catch (Throwable t) {
            throw new ManagerException("Address Create Failed");
        }

    }

    @Override
    public AddressBo updateAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo) {
        // Check Null
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (addressBo == null) {
            throw new ManagerException("Address is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        AddressBo result = null;

        try {
            // TODO 权限
            addressEntityExtMapper.update(addressEntity);
            result = AddressConverter.toBo(addressEntity);
            return result;
        } catch (Throwable t) {
            throw new ManagerException("Address Update Failed");
        }
    }

    @Override
    public AddressBo deleteAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo) {
        // Check Null
        if (partnerBo == null) {
            throw new ManagerException("PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (addressBo == null) {
            throw new ManagerException("Address is null");
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        AddressBo result = null;

        try {
            // TODO 权限
            addressEntityExtMapper.deleteById(addressEntity.getId());
            result = AddressConverter.toBo(addressEntity);
            return result;
        } catch (Throwable t) {
            throw new ManagerException("Address Delete Failed");
        }
    }

    @Override
    public List<AddressBo> query(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        if (userBo == null) {
            throw new ManagerException("UserBo is null");
        }
        if (addressBo == null) {
            throw new ManagerException("Address is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        List<AddressEntityExt> addressList = null;
        List<AddressBo> resultList = null;
        try {
            // TODO 权限
            addressList = addressEntityExtMapper.list(addressEntity, pageEntity);
            for (AddressEntityExt addressPo : addressList) {
                resultList.add(AddressConverter.toBo(addressPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Address Query Failed");
        }
    }

}
