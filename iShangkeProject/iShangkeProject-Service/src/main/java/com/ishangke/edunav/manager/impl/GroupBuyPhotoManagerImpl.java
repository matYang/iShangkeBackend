package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.GroupBuyPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.GroupBuyPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupBuyPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.GroupBuyPhotoManager;
import com.ishangke.edunav.manager.converter.GroupBuyPhotoConverter;
import com.ishangke.edunav.manager.converter.GroupBuyPhotoConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class GroupBuyPhotoManagerImpl implements GroupBuyPhotoManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupBuyPhotoManagerImpl.class);
    
    @Autowired
    private AuthManager authManager;
    
    @Autowired
    private GroupBuyPhotoEntityExtMapper groupBuyPhotoMapper;
    
    @Override
    public List<GroupBuyPhotoBo> query(GroupBuyPhotoBo groupBuyPhotoBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[GroupBuyPhotoManagerImpl]system admin  || admin [%s] call createGroupBuyPhoto at " + new Date(), userBo.getName()));
        } else {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        // Convert
        GroupBuyPhotoEntityExt groupBuyPhotoEntity = GroupBuyPhotoConverter.fromBo(groupBuyPhotoBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        List<GroupBuyPhotoEntityExt> results = null;
        try {
            results = groupBuyPhotoMapper.list(groupBuyPhotoEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，团购图片查询失败，请稍后再试", t);
        }
        if (results == null) {
            return new ArrayList<GroupBuyPhotoBo>();
        }
        List<GroupBuyPhotoBo> convertedResults = new ArrayList<GroupBuyPhotoBo>();
        for (GroupBuyPhotoEntityExt result : results) {
            convertedResults.add(GroupBuyPhotoConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    public GroupBuyPhotoBo createGroupBuyPhoto(GroupBuyPhotoBo groupBuyPhotoBo, UserBo userBo) {
        // Check Null
        if (groupBuyPhotoBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[GroupBuyPhotoManagerImpl]system admin  || admin [%s] call createGroupBuyPhoto at " + new Date(), userBo.getName()));
        } else {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        // Convert
        GroupBuyPhotoEntityExt groupBuyPhotoEntity = GroupBuyPhotoConverter.fromBo(groupBuyPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(groupBuyPhotoEntity.getGroupBuyActivityId())) {
            throw new ManagerException("创建团购图片时必须标注活动ID");
        }
        int result = 0;
        try {
            result = groupBuyPhotoMapper.add(groupBuyPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，团购图片创建失败，请稍后再试", t);
        }
        if (result > 0) {
            return GroupBuyPhotoConverter.toBo(groupBuyPhotoMapper.getById(groupBuyPhotoEntity.getId()));
        } else {
            throw new ManagerException("对不起，团购图片获取失败，请稍后再试");
        }
    }

    @Override
    public GroupBuyPhotoBo updateGroupBuyPhoto(GroupBuyPhotoBo groupBuyPhotoBo, UserBo userBo) {
     // Check Null
        if (groupBuyPhotoBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        
        // Convert
        GroupBuyPhotoEntityExt groupBuyPhotoEntity = GroupBuyPhotoConverter.fromBo(groupBuyPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(groupBuyPhotoEntity.getId())) {
            throw new ManagerException("更新团购图片时必须标注团购图片ID");
        }
        GroupBuyPhotoEntityExt previousGroupBuyPhoto = groupBuyPhotoMapper.getById(groupBuyPhotoEntity.getId());
        if (previousGroupBuyPhoto == null) {
            throw new ManagerException("对不起，没有找到ID为" +  groupBuyPhotoEntity.getId() + "的团购图片");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[GroupBuyPhotoManagerImpl]system admin  || admin [%s] call createGroupBuyPhoto at " + new Date(), userBo.getName()));
        } else {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        try {
            groupBuyPhotoMapper.update(groupBuyPhotoEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，团购图片更新失败，请稍后再试", t);
        }
        return GroupBuyPhotoConverter.toBo(groupBuyPhotoMapper.getById(groupBuyPhotoEntity.getId()));
    }

    @Override
    public GroupBuyPhotoBo deleteGroupBuyPhoto(GroupBuyPhotoBo groupBuyPhotoBo, UserBo userBo) {
     // Check Null
        if (groupBuyPhotoBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // Convert
        GroupBuyPhotoEntityExt groupBuyPhotoEntity = GroupBuyPhotoConverter.fromBo(groupBuyPhotoBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);
        if (IdChecker.isNull(groupBuyPhotoEntity.getId())) {
            throw new ManagerException("删除团购图片时必须标注团购图片ID");
        }
        GroupBuyPhotoEntityExt previousGroupBuyPhoto = groupBuyPhotoMapper.getById(groupBuyPhotoEntity.getId());
        if (previousGroupBuyPhoto == null) {
            throw new ManagerException("对不起，无法找到ID为" + groupBuyPhotoEntity.getId() + "的团购图片");
        }

        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[GroupBuyPhotoManagerImpl]system admin  || admin [%s] call createGroupBuyPhoto at " + new Date(), userBo.getName()));
        } else {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        try {
            previousGroupBuyPhoto.setDeleted(1);
            groupBuyPhotoMapper.deleteById(previousGroupBuyPhoto.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，团购图片删除失败，请稍后再试", t);
        }
        return GroupBuyPhotoConverter.toBo(previousGroupBuyPhoto);
    }

    @Override
    public int queryTotal(GroupBuyPhotoBo groupBuyPhotoBo, UserBo userBo) {
        return groupBuyPhotoMapper.getListCount(GroupBuyPhotoConverter.fromBo(groupBuyPhotoBo));
    }

}
