package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.ContactManager;
import com.ishangke.edunav.manager.converter.ContactConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;

@Component
public class ContactManagerImpl implements ContactManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactManagerImpl.class);

    @Autowired
    private ContactEntityExtMapper contactMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public ContactBo createContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[ContactManagerImpl]system admin || admin [%s] call createContact at " + new Date(), userBo.getName()));
        }
        else {
            if (contactEntity == null || contactEntity.getUserId() == null || !contactEntity.getUserId().equals(userEntity.getId())) {
                throw new AuthenticationException("User creating someone else's contact");
            }
        }

        int result = 0;
        try {
            result = contactMapper.add(contactEntity);
        } catch (Throwable t) {
            throw new ManagerException("Contact creation failed for user: " + userEntity.getId(), t);
        }
        if (result > 0) {
            return ContactConverter.toBo(contactEntity);
        } else {
            throw new ManagerException("Contact creation failed for user: " + userEntity.getId());
        }
    }

    @Override
    public ContactBo updateContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[ContactManagerImpl]system admin || admin [%s] call updateContact at " + new Date(), userBo.getName()));
        }
        else {
            if (contactEntity == null || contactEntity.getUserId() == null || !contactEntity.getUserId().equals(userEntity.getId())) {
                throw new AuthenticationException("User updating someone else's contact");
            }
        }

        try {
            contactMapper.update(contactEntity);
        } catch (Throwable t) {
            throw new ManagerException("Contact update failed for user: " + userEntity.getId(), t);
        }
        
        return ContactConverter.toBo(contactEntity);
    }

    @Override
    public ContactBo deleteContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null || userBo == null) {
            throw new ManagerException("Invalid parameter");
        }
        
        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[ContactManagerImpl]system admin || admin [%s] call deleteContact at " + new Date(), userBo.getName()));
        }
        else {
            if (contactEntity == null || contactEntity.getUserId() == null || !contactEntity.getUserId().equals(userEntity.getId())) {
                throw new AuthenticationException("User deleting someone else's contact");
            }
        }

        try {
            contactEntity.setDeleted(1);
            contactMapper.deleteById(contactEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("Contact deletion failed for user: " + userEntity.getId(), t);
        }
        
        return ContactConverter.toBo(contactEntity);
    }

    @Override
    public List<ContactBo> query(ContactBo contactBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("Invalid parameter");
        }

        ContactEntityExt contactEntity = contactBo == null ? null : ContactConverter.fromBo(contactBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[ContactManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        }
        else {
            //otherwise user can only query their own, thus making an UserId necessary
            if (contactEntity == null || contactEntity.getUserId() == null || !contactEntity.getUserId().equals(userEntity.getId())) {
                throw new AuthenticationException("User querying someone else's contact");
            }
        }
        
        List<ContactEntityExt> results = null;
        try {
            results = contactMapper.list(contactEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("Contact query failed for user: " + userEntity.getId(), t);
        }
        
        if (results == null) {
            return new ArrayList<ContactBo>();
        }
        List<ContactBo> convertedResults = new ArrayList<ContactBo>();
        for (ContactEntityExt contactPo : results) {
            convertedResults.add(ContactConverter.toBo(contactPo));
        }
        return convertedResults;
    }
}
