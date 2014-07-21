package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.ContactEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.ContactManager;
import com.ishangke.edunav.manager.converter.ContactConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class ContactManagerImpl implements ContactManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactManagerImpl.class);

    @Autowired
    private ContactEntityExtMapper contactEntityExtMapper;

    @Override
    public ContactBo createContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null) {
            throw new ManagerException("contactBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        ContactEntityExt convertEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // TODO 权限
            int result = 0;
            result = contactEntityExtMapper.add(convertEntity);
            if (result > 0) {
                return ContactConverter.toBo(convertEntity);
            } else {
                throw new ManagerException("Contact Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("Contact Create Failed");
        }
    }

    @Override
    public ContactBo updateContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null) {
            throw new ManagerException("contactBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        ContactEntityExt convertEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // TODO 权限
            contactEntityExtMapper.update(convertEntity);
            return ContactConverter.toBo(convertEntity);
        } catch (Throwable t) {
            throw new ManagerException("Contact Update Failed");
        }
    }

    @Override
    public ContactBo deleteContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null) {
            throw new ManagerException("contactBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }

        // Convert
        ContactEntityExt convertEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            // TODO 权限
            contactEntityExtMapper.deleteById(convertEntity.getId());
            return ContactConverter.toBo(convertEntity);
        } catch (Throwable t) {
            throw new ManagerException("Contact Delete Failed");
        }
    }

    @Override
    public List<ContactBo> query(ContactBo contactBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (contactBo == null) {
            throw new ManagerException("contactBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("userBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        ContactEntityExt convertEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        List<ContactEntityExt> contactList = null;
        List<ContactBo> resultList = null;

        try {
            // TODO 权限
            contactList = contactEntityExtMapper.list(convertEntity, pageEntity);
            for (ContactEntityExt contactPo : contactList) {
                resultList.add(ContactConverter.toBo(contactPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Contact Query Failed");
        }
    }

}
