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
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.manager.AddressManager;
import com.ishangke.edunav.manager.converter.AddressConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class AddressManagerImpl implements AddressManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressManagerImpl.class);

    @Autowired
    private AddressEntityExtMapper addressMapper;

    @Override
    public AddressBo createAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo) {
        // Check Null
        if (partnerBo == null) {
            throw new ManagerException("Address Create Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Address Create Failed: UserBo is null");
        }
        if (addressBo == null) {
            throw new ManagerException("Address Create Failed: Address is null");
        }

        // Convert
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);

        // Check Ids
        if (partnerEntity.getId() == null || partnerEntity.getId() == 0) {
            throw new ManagerException("Address Create Failed: 合作商id为null或0");
        }

        try {
            addressEntity.setPartnerId(partnerEntity.getId());
            int result = 0;
            result = addressMapper.add(addressEntity);
            if (result > 0) {
                return AddressConverter.toBo(addressEntity);
            } else
                throw new ManagerException("Address Create Failed");
        } catch (Throwable t) {
            throw new ManagerException("Address Create Failed", t);
        }

    }

    @Override
    public AddressBo updateAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo) {
        // Check Null
        if (partnerBo == null) {
            throw new ManagerException("Address Update Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Address Update Failed: UserBo is null");
        }
        if (addressBo == null) {
            throw new ManagerException("Address Update Failed: Address is null");
        }

        // Convert
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);

        // Check Ids
        if (partnerEntity.getId() == null || partnerEntity.getId() == 0) {
            throw new ManagerException("Address Update Failed: 合作商id为null或0");
        }
        if (addressEntity.getPartnerId() == null || addressEntity.getPartnerId() == 0) {
            throw new ManagerException("Address Update Failed: 地址的partnerId为null或0");
        }

        // Check whether the address belongs to the partner
        if (addressEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Address Update Failed: 此地址不属于该合作商");
        }

        try {
            addressMapper.update(addressEntity);
            return AddressConverter.toBo(addressEntity);
        } catch (Throwable t) {
            throw new ManagerException("Address Update Failed", t);
        }
    }

    @Override
    public AddressBo deleteAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo) {
        // Check Null
        if (partnerBo == null) {
            throw new ManagerException("Address Delete Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Address Delete Failed: UserBo is null");
        }
        if (addressBo == null) {
            throw new ManagerException("Address Delete Failed: Address is null");
        }

        // Convert
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);

        // Check Ids
        if (partnerEntity.getId() == null || partnerEntity.getId() == 0) {
            throw new ManagerException("Address Delete Failed: 合作商id为null或0");
        }
        if (addressEntity.getPartnerId() == null || addressEntity.getPartnerId() == 0) {
            throw new ManagerException("Address Delete Failed: 地址的partnerId为null或0");
        }

        // Check whether the address belongs to the partner
        if (addressEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("Address Delete Failed: 此地址不属于该合作商");
        }

        try {
            addressMapper.deleteById(addressEntity.getId());
            return AddressConverter.toBo(addressEntity);
        } catch (Throwable t) {
            throw new ManagerException("Address Delete Failed", t);
        }
    }

    @Override
    public List<AddressBo> query(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        if (userBo == null) {
            throw new ManagerException("Address Query Failed: UserBo is null");
        }
        if (addressBo == null) {
            throw new ManagerException("Address Query Failed: Address is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        AddressEntityExt addressEntity = AddressConverter.fromBo(addressBo);
        List<AddressEntityExt> addressList = null;
        List<AddressBo> resultList = null;

        try {
            addressList = addressMapper.list(addressEntity, pageEntity);
            for (AddressEntityExt addressPo : addressList) {
                resultList.add(AddressConverter.toBo(addressPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Address Query Failed", t);
        }
    }

}
