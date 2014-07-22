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
    private ContactEntityExtMapper contactMapper;

    @Override
    public ContactBo createContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null) {
            throw new ManagerException("Contact Create Failed: contactBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Contact Create Failed: userBo is null");
        }

        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        try {
            int result = 0;
            contactEntity.setUserId(userEntity.getId());
            result = contactMapper.add(contactEntity);
            if (result > 0) {
                return ContactConverter.toBo(contactEntity);
            } else {
                throw new ManagerException("Contact Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("Contact Create Failed", t);
        }
    }

    @Override
    public ContactBo updateContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null) {
            throw new ManagerException("Contact Update Failed: contactBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Contact Update Failed: userBo is null");
        }

        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // Check Ids
        if (contactEntity.getUserId() == 0) {
            throw new ManagerException("Contact Update Failed: 联系人的userId为0");
        }
        if (contactEntity.getUserId() != userEntity.getId()) {
            throw new ManagerException("Contact Update Failed: 用户id与联系人的userId不匹配");
        }

        try {
            contactMapper.update(contactEntity);
            return ContactConverter.toBo(contactEntity);
        } catch (Throwable t) {
            throw new ManagerException("Contact Update Failed", t);
        }
    }

    @Override
    public ContactBo deleteContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null) {
            throw new ManagerException("Contact Delete Failed: contactBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Contact Delete Failed: userBo is null");
        }

        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        // Check Ids
        if (contactEntity.getUserId() == 0) {
            throw new ManagerException("Contact Delete Failed: 联系人的userId为0");
        }
        if (contactEntity.getUserId() != userEntity.getId()) {
            throw new ManagerException("Contact Delete Failed: 用户id与联系人的userId不匹配");
        }

        try {
            contactMapper.deleteById(contactEntity.getId());
            return ContactConverter.toBo(contactEntity);
        } catch (Throwable t) {
            throw new ManagerException("Contact Delete Failed", t);
        }
    }

    @Override
    public List<ContactBo> query(ContactBo contactBo, UserBo userBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (contactBo == null) {
            throw new ManagerException("Contact Query Failed: contactBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Contact Query Failed: userBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        List<ContactEntityExt> contactList = null;
        List<ContactBo> resultList = null;

        try {
            contactList = contactMapper.list(contactEntity, pageEntity);
            for (ContactEntityExt contactPo : contactList) {
                if (contactPo.getUserId() != userEntity.getId()) {
                    throw new ManagerException("Contact Query Failed: 用户id与联系人的userId不匹配");
                }
                resultList.add(ContactConverter.toBo(contactPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Contact Query Failed", t);
        }
    }

}
