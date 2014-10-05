package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyAddressBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyPhotoBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupBuyActivityEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupBuyAddressEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupBuyBookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupBuyPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupBuyActivityEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupBuyBookingEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupBuyPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.GroupBuyManager;
import com.ishangke.edunav.manager.async.dispatcher.SMSDispatcher;
import com.ishangke.edunav.manager.converter.GroupBuyActivityConverter;
import com.ishangke.edunav.manager.converter.GroupBuyAddressConverter;
import com.ishangke.edunav.manager.converter.GroupBuyBookingConverter;
import com.ishangke.edunav.manager.converter.GroupBuyPhotoConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.util.PageUtil;

@Component
public class GroupBuyManagerImpl implements GroupBuyManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PurposeCourseManagerImpl.class);

    @Autowired
    private GroupBuyActivityEntityExtMapper groupBuyActivityMapper;

    @Autowired
    private GroupBuyBookingEntityExtMapper groupBuyBookingMapper;

    @Autowired
    private AuthManager authManager;
    
    @Autowired
    private CourseEntityExtMapper courseMapper;
    
    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateMapper;
    
    @Autowired
    private GroupBuyPhotoEntityExtMapper groupBuyPhotoMapper;
    
    @Autowired
    private GroupBuyAddressEntityExtMapper groupBuyAddressMapper;

    @Autowired
    private UserEntityExtMapper userMapper;
    
    @Autowired
    private CacheManager cacheManager;

    @Override
    public GroupBuyActivityBo createGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo, UserBo userBo) {
        // check null
        if (groupBuyActivityBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[GroupBuyManagerImpl]system admin || admin [%s] call createGroupBuyActivity at " + new Date(), userBo.getName()));
        } else {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        CourseTemplateEntityExt course = courseTemplateMapper.getById(groupBuyActivityBo.courseId);
        if (course == null) {
            throw new ManagerException("课程不存在或者课程已下线！");
        }
        
        // Convert
        GroupBuyActivityEntityExt groupBuyActivityEntity = GroupBuyActivityConverter.fromBo(groupBuyActivityBo);
        
        if (groupBuyActivityEntity.getGroupBuyPrice() == null || groupBuyActivityEntity.getGroupBuyPrice() >= course.getPrice() || groupBuyActivityEntity.getGroupBuyPrice() < 0.0) {
            throw new ManagerException("团购价不能为空或大于课程价");
        }
        
        if (groupBuyActivityEntity.getEndTime() == null || groupBuyActivityEntity.getEndTime().getTimeInMillis() <= DateUtility.getCurTime()) {
            throw new ManagerException("团购结束时间不能为空或小于开始时间");
        }
        groupBuyActivityEntity.setCreateTime(DateUtility.getCurTimeInstance());
        groupBuyActivityEntity.setStatus(Constant.GROUPBUYACTIVITYOFFLINE);
        int result = 0;
        try {
            result = groupBuyActivityMapper.add(groupBuyActivityEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，团购活动创建失败，请稍候再试", t);
        }
        if (result > 0) {
            // 插入团购图片信息
            List<GroupBuyPhotoBo> photoList = groupBuyActivityBo.getPhotoList();
            for (GroupBuyPhotoBo groupBuyPhotoBo : photoList) {
                groupBuyPhotoBo.setGroupBuyActivityId(groupBuyActivityEntity.getId());
                groupBuyPhotoMapper.add(GroupBuyPhotoConverter.fromBo(groupBuyPhotoBo));
            }
            // 插入团购地址信息
            List<AddressBo> addressList = groupBuyActivityBo.getAddressList();
            for (AddressBo AddressBo : addressList) {
                GroupBuyAddressBo groupBuyAddressBo = new GroupBuyAddressBo();
                groupBuyAddressBo.setGroupBuyActivityId(groupBuyActivityEntity.getId());
                groupBuyAddressBo.setAddressId(AddressBo.getId());
                groupBuyAddressMapper.add(GroupBuyAddressConverter.fromBo(groupBuyAddressBo));
            }
            return GroupBuyActivityConverter.toBo(groupBuyActivityMapper.getById(groupBuyActivityEntity.getId()));
        } else {
            throw new ManagerException("对不起，团购活动获取失败，请稍候再试");
        }
        
    }

    @Override
    public GroupBuyActivityBo updateGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo, UserBo userBo) {
        // check null
        if (groupBuyActivityBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[GroupBuyManagerImpl]system admin || admin [%s] call updateGroupBuyActivity at " + new Date(), userBo.getName()));
        } else {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        CourseTemplateEntityExt course = courseTemplateMapper.getById(groupBuyActivityBo.courseId);
        if (course == null) {
            throw new ManagerException("课程不存在或者课程已下线！");
        }

        // Convert
        GroupBuyActivityEntityExt groupBuyActivityEntity = GroupBuyActivityConverter.fromBo(groupBuyActivityBo);

        if (groupBuyActivityEntity.getGroupBuyPrice() == null || groupBuyActivityEntity.getGroupBuyPrice() >= course.getPrice() || groupBuyActivityEntity.getGroupBuyPrice() < 0.0) {
            throw new ManagerException("团购价不能为空或大于课程价");
        }

        if (groupBuyActivityEntity.getEndTime() == null || groupBuyActivityEntity.getEndTime().getTimeInMillis() <= groupBuyActivityEntity.getCreateTime().getTimeInMillis()) {
            throw new ManagerException("团购结束时间不能为空或小于开始时间");
        }
        groupBuyActivityEntity.setCreateTime(DateUtility.getCurTimeInstance());
        try {
            groupBuyActivityMapper.update(groupBuyActivityEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，团购活动更新失败，请稍候再试", t);
        }

        groupBuyActivityEntity.setCreateTime(null);
        GroupBuyActivityEntityExt groupBuyActivityEntityOld = groupBuyActivityMapper.getById(groupBuyActivityEntity.getId());

        // 暂时没想到效率高的更新一对多的团购图片信息的方法,所以先删除已存的再添加新的
        List<GroupBuyPhotoEntityExt> photoListOld = groupBuyActivityEntityOld.getPhotoList();
//        GroupBuyActivityBo groupBuyActivityBoOld = GroupBuyActivityConverter.toBo(groupBuyActivityEntityOld);
//        List<GroupBuyPhotoBo> photoListOld = groupBuyActivityBoOld.getPhotoList();
        List<GroupBuyPhotoBo> photoListNew = groupBuyActivityBo.getPhotoList();
        // TODO 需要改成根据团购活动id删除团购图片信息，而不是根据图片id逐个删除
        // 删除现存的团购图片信息
        for (GroupBuyPhotoEntityExt groupBuyPhotoEntity : photoListOld) {
            groupBuyPhotoMapper.deleteById(groupBuyPhotoEntity.getId());
        }
        // 插入新的团购图片信息
        for (GroupBuyPhotoBo groupBuyPhotoBo : photoListNew) {
            groupBuyPhotoBo.setGroupBuyActivityId(groupBuyActivityEntity.getId());
            groupBuyPhotoMapper.add(GroupBuyPhotoConverter.fromBo(groupBuyPhotoBo));
        }

        // 删除现存的团购地址信息
        List<AddressBo> addressListNew = groupBuyActivityBo.getAddressList();
        groupBuyAddressMapper.deleteByGroupBuyActivityId(groupBuyActivityEntity.getId());
        // 插入新的团购地址信息
        for (AddressBo addressBo : addressListNew) {
            GroupBuyAddressBo groupBuyAddressBo = new GroupBuyAddressBo();
            groupBuyAddressBo.setGroupBuyActivityId(groupBuyActivityEntity.getId());
            groupBuyAddressBo.setAddressId(addressBo.getId());
            groupBuyAddressMapper.add(GroupBuyAddressConverter.fromBo(groupBuyAddressBo));
        }
        return GroupBuyActivityConverter.toBo(groupBuyActivityMapper.getById(groupBuyActivityEntity.getId()));
    }

    @Override
    public GroupBuyBookingBo createGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo, UserBo userBo) {
        // check null
        if (groupBuyBookingBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        
        // Convert
        String roleName = authManager.getRole(userBo.getId());
        GroupBuyBookingEntityExt groupBuyBookingEntity = GroupBuyBookingConverter.fromBo(groupBuyBookingBo);
        GroupBuyActivityEntityExt groupBuyActivity = groupBuyActivityMapper.getById(groupBuyBookingEntity.getGroupBuyActivityId());
        if (!Constant.ROLEUSER.equals(roleName)) {
            throw new ManagerException("对不起，只有普通用户有权参加团购");
        }
        if (IdChecker.notEqual(groupBuyBookingEntity.getUserId(), userBo.getId())) {
            throw new ManagerException("对不起，用户无权为他人进行团购");
        }
        if (groupBuyActivity == null || Constant.GROUPBUYACTIVITYONLINE != groupBuyActivity.getStatus()) {
            throw new ManagerException("团购活动不存在或已经下线");
        }
        if (groupBuyBookingBo.getGroupBuyPrice() != groupBuyActivity.getGroupBuyPrice()) {
            throw new ManagerException("对不起，价格不一致，请刷新页面重新提交！");
        }
        
        groupBuyBookingEntity.setUserId(userBo.getId());
        groupBuyBookingEntity.setCreateTime(DateUtility.getCurTimeInstance());
        groupBuyBookingEntity.setStatus(Constant.GROUPBUYBOOKINGPENDINGPAYMENT);
        int result = 0;
        try {
            result = groupBuyBookingMapper.add(groupBuyBookingEntity);
            //团购订单号 ISK-GROUPBUY-time-id
            groupBuyBookingEntity.setReference(Constant.GROUPBUYBOOKINGPREFIX + (DateUtility.getCurTime() / 10000000) + "-" + groupBuyBookingEntity.getId());
            groupBuyBookingMapper.update(groupBuyBookingEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，选购团购课程失败，请稍候再试", t);
        }
        if (result > 0) {
            //设置缓存，booking的订阅次数
            Integer total = getGroupBuyBookingTotal(groupBuyActivity.getCourseId()); 
            total++;
            cacheManager.set(Constant.GROUPBUYTOTAL + groupBuyActivity.getCourseId(), Constant.STATUSTRANSFORMEXPIRETIME, total);
            return GroupBuyBookingConverter.toBo(groupBuyBookingMapper.getById(groupBuyBookingEntity.getId()));
        } else {
            throw new ManagerException("对不起，选购团购课程获取失败，请稍候再试");
        }
    }

    @Override
    public List<GroupBuyBookingBo> queryGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo, UserBo userBo, PaginationBo paginationBo) {
        if (userBo == null || groupBuyBookingBo == null) {
            throw new ManagerException("无效请求参数");
        }
        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            LOGGER.warn(String.format("[GroupBuyManagerImpl]system admin || admin [%s] call createGroupBuyBooking at " + new Date(), userBo.getName()));
            GroupBuyBookingEntityExt groupBuyBookingEntity = GroupBuyBookingConverter.fromBo(groupBuyBookingBo);
            PaginationEntity page = PaginationConverter.fromBo(paginationBo);
            List<GroupBuyBookingEntityExt> results = null;
            try {
                results = groupBuyBookingMapper.list(groupBuyBookingEntity, page);
            } catch (Throwable t) {
                throw new ManagerException("对不起，团购课程信息查询失败，请稍候再试");
            }
            if (results == null) {
                return new ArrayList<GroupBuyBookingBo>();
            }
            List<GroupBuyBookingBo> convertedResults = new ArrayList<GroupBuyBookingBo>();
            for (GroupBuyBookingEntityExt result : results) {
                convertedResults.add(GroupBuyBookingConverter.toBo(result));
            }
            return convertedResults;
        } else if (Constant.ROLEUSER.equals(roleName)){
            System.out.println("用户userId："+groupBuyBookingBo.getUserId()+";Id:"+userBo.getId());
            if (IdChecker.notEqual(groupBuyBookingBo.getUserId(), userBo.getId())) {
                throw new ManagerException("对不起，您无权查询别人团购");
            }
            GroupBuyBookingEntityExt groupBuyBookingEntity = groupBuyBookingBo == null ? null : GroupBuyBookingConverter.fromBo(groupBuyBookingBo);
            PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
            if (groupBuyBookingEntity != null) {
                groupBuyBookingEntity.setUserId(userBo.getId());
            }
            List<GroupBuyBookingEntityExt> results = null;
            try {
                results = groupBuyBookingMapper.list(groupBuyBookingEntity, page);
            } catch (Throwable t) {
                throw new ManagerException("对不起，团购课程信息查询失败，请稍候再试");
            }
            if (results == null) {
                return new ArrayList<GroupBuyBookingBo>();
            }
            List<GroupBuyBookingBo> convertedResults = new ArrayList<GroupBuyBookingBo>();
            for (GroupBuyBookingEntityExt result : results) {
                convertedResults.add(GroupBuyBookingConverter.toBo(result));
            }
            return convertedResults;
        } else {
            throw new ManagerException("对不起，您无权查阅团购信息");
        }
    }

    @Override
    public void payGroupBuyBooking(GroupBuyBookingBo groupBuyBookingBo) {
       //use changeGroupBuyBookingStatusToPayed because of history
       //but we will use this method next version
    }

    @Override
    public int queryGroupBuyBookingTotal(GroupBuyBookingBo groupBuyBookingBo, UserBo userBo) {
        return groupBuyBookingMapper.getListCount(GroupBuyBookingConverter.fromBo(groupBuyBookingBo));
    }

    @Override
    public GroupBuyActivityBo online(GroupBuyActivityBo groupBuyActivityBo, UserBo userBo) {
        if (groupBuyActivityBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        
        if (IdChecker.isNull(groupBuyActivityBo.getId())) {
            throw new ManagerException("上线团购时必须标注团购活动ID");
        }
        
        GroupBuyActivityEntityExt groupBuyActivityEntity = groupBuyActivityMapper.getById(groupBuyActivityBo.getId());
        if (groupBuyActivityEntity == null) {
            throw new ManagerException("对不起，无法找到ID为" + groupBuyActivityBo.getId() + "的团购");
        }
        
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[GroupBuyManagerImpl]system admin || admin [%s] call updateGroupBuyBooking at " + new Date(), userBo.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权上线团购");
        }
        
        try {
            groupBuyActivityEntity.setStatus(Constant.GROUPBUYACTIVITYONLINE);
            groupBuyActivityMapper.update(groupBuyActivityEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，团购上线失败，请稍后再试", t);
        }
        return GroupBuyActivityConverter.toBo(groupBuyActivityMapper.getById(groupBuyActivityEntity.getId()));
    }

    @Override
    public GroupBuyActivityBo queryGroupBuyActivityById(int id) {
        GroupBuyActivityEntityExt groupBuyActivity = null;
        try {
            groupBuyActivity = groupBuyActivityMapper.getById(id);
        } catch (Exception e) {
            throw new ManagerException("对不起，团购查询失败，请稍后再试");
        }
        if (groupBuyActivity == null) {
            throw new ManagerException("对不起，无法找到ID为" + id + "的预订");
        }
        GroupBuyActivityBo groupBuyActivityBo = GroupBuyActivityConverter.toBo(groupBuyActivity);
        int bookingTotal = getGroupBuyBookingTotal(groupBuyActivity.getCourseId());
        groupBuyActivityBo.setBookingTotal(bookingTotal);
        return groupBuyActivityBo;
    }

    @Override
    public GroupBuyBookingBo queryGroupBuyBookingById(int id, UserBo userBo) {
        String roleName = authManager.getRole(userBo.getId());
        GroupBuyBookingEntityExt groupBuyBooking = null;
        try {
            groupBuyBooking = groupBuyBookingMapper.getById(id);
        } catch (Exception e) {
            throw new ManagerException("对不起，团购查询失败，请稍后再试");
        }
        if (groupBuyBooking == null) {
            throw new ManagerException("对不起，无法找到ID为" + id + "的团购");
        }
        if (Constant.ROLEUSER.equals(roleName)) {
            if (IdChecker.notEqual(groupBuyBooking.getUserId(), userBo.getId())) {
                throw new ManagerException("对不起，您无权查询他人的团购");
            }
            GroupBuyBookingBo groupBuyBookingBo = GroupBuyBookingConverter.toBo(groupBuyBooking);
            return groupBuyBookingBo;
        } else if (Constant.ROLESYSTEMADMIN.equals(roleName) || Constant.ROLEADMIN.equals(roleName)) {
            GroupBuyBookingBo groupBuyBookingBo = GroupBuyBookingConverter.toBo(groupBuyBooking);
            return groupBuyBookingBo;
        } else {
            throw new ManagerException("对不起，当前用户无权查询团购");
        }
    }
    

    public String changeGroupBuyBookingStatusToPayed(int bookingId, String trade_no) {
        GroupBuyBookingEntityExt groupBuyBookingEntityExt = groupBuyBookingMapper.getById(bookingId);
        if (groupBuyBookingEntityExt.getStatus() != Constant.GROUPBUYBOOKINGPENDINGPAYMENT) {
            LOGGER.warn("[changeGroupBuyBookingStatusToPayed] try to pay booking " + bookingId + " with status " + groupBuyBookingEntityExt.getStatus());
        }
        groupBuyBookingEntityExt.setStatus(Constant.GROUPBUYBOOKINGPAYED);
        groupBuyBookingEntityExt.setNumber(trade_no);
        try {
            groupBuyBookingMapper.update(groupBuyBookingEntityExt);
        } catch (Exception e) {
            LOGGER.error(String.format("[pay group buy booking] try to log booking history booking [%d] status to payed but failed", bookingId));
            throw new ManagerException("对不起，预订历史记录创建失败，请稍后再试");
        } finally {
            LOGGER.info(String.format("[pay group buy booking] try to change booking [%d] status to payed", bookingId));
        }
        try {
            UserEntityExt user = userMapper.getSimpleById(groupBuyBookingEntityExt.getUserId());
            GroupBuyActivityEntityExt activity = groupBuyActivityMapper.getById(groupBuyBookingEntityExt.getGroupBuyActivityId());
            SMSDispatcher.sendGroupBuyPaySuccess(user.getPhone(), activity.getTitle(), groupBuyBookingEntityExt.getReference());
        } catch (Exception e) {
            LOGGER.error("send message failed" + e);
        }
        
        return Constant.SUCCESS;
    }

    @Override
    public List<GroupBuyActivityBo> queryGroupBuyActivity(GroupBuyActivityBo groupBuyActivityBo, PaginationBo paginationBo) {
    	if (groupBuyActivityBo == null || paginationBo == null) {
            throw new ManagerException("无效请求参数");
        }
    	
    	GroupBuyActivityEntityExt groupBuyActivityEntity = GroupBuyActivityConverter.fromBo(groupBuyActivityBo); 
        PaginationEntity page = PaginationConverter.fromBo(PageUtil.getPage(paginationBo));
        List<GroupBuyActivityEntityExt> results = null;
        
        try {
            results = groupBuyActivityMapper.list(groupBuyActivityEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，团购活动信息查询失败，请稍候再试");
        }
        
        if (results == null) {
            return new ArrayList<GroupBuyActivityBo>();
        }
        List<GroupBuyActivityBo> convertedResults = new ArrayList<GroupBuyActivityBo>();
        for (GroupBuyActivityEntityExt result : results) {
            GroupBuyActivityBo bo = GroupBuyActivityConverter.toBo(result); 
            int bookingTotal = getGroupBuyBookingTotal(bo.getCourseId());
            bo.setBookingTotal(bookingTotal);
            convertedResults.add(bo);
        }
        return convertedResults;
    }

    @Override
    public int queryGroupBuyActivityTotal(GroupBuyActivityBo groupBuyActivityBo) {
    	return groupBuyActivityMapper.getListCount(GroupBuyActivityConverter.fromBo(groupBuyActivityBo));
    }

    @Override
    public int getGroupBuyBookingTotal(int courseId) {
        Integer total = (Integer) cacheManager.get(Constant.GROUPBUYTOTAL + courseId);
        if (total != null) {
            return total;
        } else {
            total = 0;
        }
        GroupBuyActivityEntityExt activity = new GroupBuyActivityEntityExt();
        GroupBuyBookingEntityExt booking = new GroupBuyBookingEntityExt();
        activity.setCourseId(courseId);
        List<GroupBuyActivityEntityExt> listActivity = groupBuyActivityMapper.list(activity, PaginationConverter.fromBo(PageUtil.getPage(null)));
        for (GroupBuyActivityEntityExt a : listActivity) {
            booking.setGroupBuyActivityId(a.getId());
            total += groupBuyBookingMapper.getListCount(booking);
        }
        cacheManager.set(Constant.GROUPBUYTOTAL + courseId, Constant.STATUSTRANSFORMEXPIRETIME, total);
        return total;
    }
}
