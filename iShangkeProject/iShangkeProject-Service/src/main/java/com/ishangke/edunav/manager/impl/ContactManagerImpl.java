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
import com.ishangke.edunav.manager.exception.notfound.ContactNotFoundException;

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
            throw new ManagerException("无效请求参数");
        }

        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[ContactManagerImpl]system admin || admin [%s] call createContact at " + new Date(), userBo.getName()));
        } else {
            if (contactEntity == null || IdChecker.notEqual(contactEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权创建他人的常用学员");
            }
        }

        contactEntity.setCreateTime(DateUtility.getCurTimeInstance());
        contactEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        contactEntity.setEnabled(0);
        contactEntity.setDeleted(0);
        int result = 0;
        try {
            result = contactMapper.add(contactEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，常用学员创建失败，请稍后再试", t);
        }
        if (result > 0) {
            return ContactConverter.toBo(contactMapper.getById(contactEntity.getId()));
        } else {
            throw new ManagerException("对不起，常用学员获取失败，请稍后再试");
        }
    }

    @Override
    public ContactBo updateContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        
        if (IdChecker.isNull(contactEntity.getId())) {
            throw new ManagerException("更新常用学员时必须标注常用学员ID");
        }
        ContactEntityExt previousContact = contactMapper.getById(contactEntity.getId());
        if (previousContact == null) {
            throw new ContactNotFoundException("对不起，无法找到ID为" + contactEntity.getId() + "的常用学员");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[ContactManagerImpl]system admin || admin [%s] call updateContact at " + new Date(), userBo.getName()));
        } else {
            if (IdChecker.notEqual(previousContact.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权更改他人的常用学员");
            }
        }

        
        contactEntity.setUserId(null);
        contactEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        contactEntity.setCreateTime(null);
        contactEntity.setEnabled(null);
        try {
            contactMapper.update(contactEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，常用学员更新失败，请稍后再试", t);
        }

        return ContactConverter.toBo(contactMapper.getById(contactEntity.getId()));
    }

    @Override
    public ContactBo deleteContact(ContactBo contactBo, UserBo userBo) {
        // Check Null
        if (contactBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        ContactEntityExt contactEntity = ContactConverter.fromBo(contactBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);
        
        if (IdChecker.isNull(contactEntity.getId())) {
            throw new ManagerException("删除常用学员时必须标注常用学员ID");
        }
        ContactEntityExt previousContact = contactMapper.getById(contactEntity.getId());
        if (previousContact == null) {
            throw new ContactNotFoundException("对不起，无法找到ID为" + contactEntity.getId() + "的常用学员");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[ContactManagerImpl]system admin || admin [%s] call deleteContact at " + new Date(), userBo.getName()));
        } else {
            if (IdChecker.notEqual(previousContact.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权删除他人的常用学员");
            }
        }

        try {
            previousContact.setDeleted(1);
            contactMapper.deleteById(previousContact.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，常用学员删除失败，请稍后再试", t);
        }

        return ContactConverter.toBo(previousContact);
    }

    @Override
    public List<ContactBo> query(ContactBo contactBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        ContactEntityExt contactEntity = contactBo == null ? null : ContactConverter.fromBo(contactBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[ContactManagerImpl]system admin || admin [%s] call query at " + new Date(), userBo.getName()));
        } else {
            // otherwise user can only query their own, thus making an UserId necessary
            if (contactEntity == null || IdChecker.notEqual(contactEntity.getUserId(), userEntity.getId())) {
                throw new AuthenticationException("对不起，您无权查询他人的常用学员");
            }
        }

        List<ContactEntityExt> results = null;
        try {
            results = contactMapper.list(contactEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，常用学员查询失败，请稍后再试", t);
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

    @Override
    public int queryTotal(ContactBo contactBo, UserBo userBo) {
        return contactMapper.getListCount(ContactConverter.fromBo(contactBo));
    }
}
