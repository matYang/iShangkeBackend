package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.constant.DefaultValue;
import com.ishangke.edunav.common.enums.BookingEnums;
import com.ishangke.edunav.common.enums.CouponEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.BookingHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.ContactEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.OrderEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.OrderHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.alipay.AlipayNotify;
import com.ishangke.edunav.manager.alipay.AlipaySubmit;
import com.ishangke.edunav.manager.async.dispatcher.BookingNotificationDispatcher;
import com.ishangke.edunav.manager.converter.BookingConverter;
import com.ishangke.edunav.manager.converter.BookingHistoryConverter;
import com.ishangke.edunav.manager.converter.CouponConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.notfound.CourseNotFoundException;
import com.ishangke.edunav.manager.transform.Operation;

@Component
public class BookingManagerImpl implements BookingManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingManagerImpl.class);

    @Autowired
    private AuthManager authManager;

    @Autowired
    private TransformManager transformManager;

    @Autowired
    private BookingEntityExtMapper bookingMapper;

    @Autowired
    private ContactEntityExtMapper contactMapper;

    @Autowired
    private CouponManager couponManager;

    @Autowired
    private BookingHistoryEntityExtMapper bookingHistoryMapper;

    @Autowired
    private CourseEntityExtMapper courseMapper;

    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private CouponEntityExtMapper couponMapper;

    @Autowired
    private OrderEntityExtMapper orderMapper;

    @Autowired
    private OrderHistoryEntityExtMapper orderHistoryMapper;

    private double consumeCoupons(final BookingBo bookingBo, UserBo userBo) {
        if (bookingBo == null || bookingBo.getCashbackAmount() < DefaultValue.DOUBLEPRCISIONOFFSET || IdChecker.isNull(bookingBo.getUserId())) {
            return 0.0;
        }

        CouponEntityExt couponSearch = new CouponEntityExt();
        couponSearch.setUserId(bookingBo.getUserId());
        couponSearch.setStatus(CouponEnums.Status.USABLE.code);
        couponSearch.setEnabled(0);
        couponSearch.setDeleted(0);

        List<CouponEntityExt> couponResults = null;
        try {
            couponResults = couponMapper.list(couponSearch, null);
        } catch (Throwable t) {
            throw new ManagerException("对不起，可用消费券搜索失败，请稍后再试");
        }
        if (couponResults == null || couponResults.size() == 0) {
            return 0.0;
        }

        // remove used coupons and expired coupons
        for (int i = couponResults.size() - 1; i >= 0; i--) {
            if (couponResults.get(i).getBalance() < DefaultValue.DOUBLEPRCISIONOFFSET || couponResults.get(i).getExpiryTime().before(DateUtility.getCurTime())) {
                couponResults.remove(i);
            }
        }
        if (couponResults.size() == 0) {
            return 0.0;
        }

        // first to expire are used first
        Collections.sort(couponResults, new Comparator<CouponEntityExt>() {
            @Override
            public int compare(CouponEntityExt o1, CouponEntityExt o2) {
                return o1.getExpiryTime().compareTo(o2.getExpiryTime());
            }
        });

        double currentTotal = 0.0;
        double targetTotal = bookingBo.getCashbackAmount();
        int tailIndex = 0;
        for (int i = 0; i < couponResults.size() && currentTotal < (targetTotal - 0.001d); i++) {
            CouponEntityExt coupon = couponResults.get(i);
            if (currentTotal + coupon.getBalance() < (targetTotal - 0.001d)) {
                // not yet reached desired cashback total yet, using up entire
                // coupon
                currentTotal += coupon.getBalance();
                coupon.setBalance(0.0);
            } else {
                // total value has reach target total ,so simple use the target
                // tatal, consume differential coupon
                coupon.setBalance(coupon.getBalance() - (targetTotal - currentTotal));
                currentTotal = targetTotal;
            }
            tailIndex++;
        }
        // remove all untouched coupons
        for (int i = couponResults.size() - 1; i >= tailIndex; i--) {
            couponResults.remove(i);
        }

        // updated all consumed or partially consumed coupons
        for (CouponEntityExt coupon : couponResults) {
            couponManager.updateCoupon(CouponConverter.toBo(coupon), userBo);
        }

        return currentTotal;
    }

    @Override
    public BookingBo createBookingByUser(BookingBo bookingBo, UserBo userBo) {
        String roleName = authManager.getRole(userBo.getId());
        BookingEntityExt bookingEntity = BookingConverter.fromBo(bookingBo);
        CourseEntityExt course = courseMapper.getInfoById(bookingEntity.getCourseId());
        if (!Constant.ROLEUSER.equals(roleName)) {
            throw new ManagerException("对不起，只有普通用户有权创建预订");
        }
        if (IdChecker.notEqual(bookingEntity.getUserId(), userBo.getId())) {
            throw new ManagerException("对不起，用户无权为他人创建预订");
        }
        if (bookingEntity.getName() == null || "".equals(bookingEntity.getName())) {
            throw new ManagerException("请填写姓名");
        }
        if (bookingEntity.getPhone() == null || "".equals(bookingEntity.getPhone())) {
            throw new ManagerException("请填写电话");
        }
        // 查询此课程是否属于上架状态
        if (course == null || Constant.COURSESTATUSONLINED != course.getStatus()) {
            throw new ManagerException("课程已经被删除或者下架，目前无法接受预订");
        }
        // booking不同的type（支付方式）决定了booking的初始化状态
        int bookingOpt;
        if (bookingEntity.getType() == Constant.BOOKINGTYPEONLINE) {
            // 在线支付预订
            // 如果是在线支付课程， 会有额外的优惠
            // 线上支付的话 会有额外的折扣 在创建课程的时候 我们会写明 “立即省” 即：在线支付的时候可以抵扣的优惠
            // 使用commission字段存储在线支付的折扣
            Double cost = course.getCommission();
            cost = cost == null ? 0 : cost;
            // 查询课程现价与发过来的价格是否一致，如果不一致则不能创建booking
            // 不支持面议
            if (!course.getPrice().equals(bookingEntity.getPrice() + cost)) {
                throw new ManagerException("预订价格与课程价格不一致，请刷新页面");
            }
            LOGGER.warn(String.format("[create order]user [%d] create order with online cost [%f], origin price is [%f]", userBo.getId(), cost, bookingEntity.getPrice()));
            bookingEntity.setStatus(Constant.BOOKINGSTATUSONLINEPENDINGPAYMENT);
            bookingOpt = Constant.BOOKINGOPERATIONONLINESUBMITBOOKING;

        } else if (bookingEntity.getType() == Constant.BOOKINGTYPEOFFLINE) {
            // 线下支付预订
            // 查询课程现价与发过来的价格是否一致，如果不一致则不能创建booking
            // 现在课程支持没有价格 支持面议
            if (course.getPrice() != null && !course.getPrice().equals(bookingEntity.getPrice())) {
                throw new ManagerException("预订价格与课程价格不一致，请刷新页面");
            }
            // 传递过来的cashback必须小于等于course中定义的cashback
            // 现在课程支持没有价格 支持面议
            if (course.getCashback() != null && bookingBo.getCashbackAmount() > course.getCashback()) {
                throw new ManagerException("返利金额不能超过课程返利金额，请刷新页面");
            }
            bookingEntity.setStatus(Constant.BOOKINGSTATUSOFFLINEBOOKED);
            bookingOpt = Constant.BOOKINGOPERATIONOFFLINESUBMITBOOKING;
            // Use coupons
            // 只有线下支付支持使用coupon
            double calculatedCachbask = consumeCoupons(bookingBo, userBo);
            if (calculatedCachbask > DefaultValue.DOUBLEPRCISIONOFFSET) {
                bookingBo.setCashbackAmount(calculatedCachbask);
            }
        } else {
            throw new ManagerException("对不起，预订类型识别错误，请刷新页面或稍后再试");
        }
        // 设置booking的partner id
        bookingEntity.setPartnerId(course.getPartnerId());
        // bookingBo.setPartnerId(course.getPartnerId());
        // 设置bookingBo中的course template id
        // 因为我们设计的时候，将course template id也放入了booking中，这里需要注意一下，不然可能会出错
        bookingEntity.setCourseTemplateId(course.getCourseTemplateId());
        bookingEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        bookingEntity.setCreateTime((DateUtility.getCurTimeInstance()));
        // 插入booking
        int result = 0;
        try {
            result = bookingMapper.add(bookingEntity);
        } catch (Exception e) {
            throw new ManagerException("对不起，创建预订失败，请稍后再试");
        }
        // 将booking的订单号插入
        // booking订单号 ISK + booking create time + booking id
        bookingEntity.setReference(Constant.ORDERPREFIX + (DateUtility.getCurTime() / 10000000) + "-" + bookingEntity.getId());
        bookingMapper.update(bookingEntity);
        
        if (result > 0) {
            bookingBo.setId(bookingEntity.getId());
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingEntity.getId());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistory.setNormal(Constant.BOOKINGNORMAL);
            bookingHistory.setOptName(bookingOpt);
            bookingHistory.setPostStatus(Constant.BOOKINGSTATUSONLINEPENDINGPAYMENT);
            bookingHistory.setPreStatus(Constant.DEFAULTNULL);
            bookingHistory.setRemark(bookingBo.getNote());
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setRemark(bookingEntity.getNote());
            bookingHistoryMapper.add(bookingHistory);
            // 课程预订数量统计
            CourseTemplateEntityExt courseTemplate = courseTemplateMapper.getById(course.getCourseTemplateId());
            if (courseTemplate != null) {
                int total = courseTemplate.getBookingTotal() == null ? 0 : courseTemplate.getBookingTotal();
                total = total + 1;
                courseTemplate.setBookingTotal(total++);
                courseTemplateMapper.update(courseTemplate);
            } else {
                LOGGER.warn(String.format("[create booking]course template for course [%d] is no longer exits", course.getId()));
            }
        } else {
            throw new ManagerException("对不起，创建预订失败，请稍后再试");
        }
        // 如果没有此可联系人信息，则保存此联系人信息
        ContactEntityExt contact = new ContactEntityExt();
        contact.setUserId(userBo.getId());
        List<ContactEntityExt> contacts = contactMapper.list(contact, null);
        if (contacts == null || contacts.size() == 0) {
            contact.setCreateTime(DateUtility.getCurTimeInstance());
            contact.setLastModifyTime(DateUtility.getCurTimeInstance());
            contact.setName(bookingEntity.getName());
            contact.setPhone(bookingEntity.getPhone());
            contact.setEmail(bookingEntity.getEmail());
            contactMapper.add(contact);
        } else {
            boolean hasContact = false;
            for (ContactEntityExt c : contacts) {
                if (c.getName().equals(bookingEntity.getName()) && c.getPhone().equals(bookingEntity.getPhone())) {
                    hasContact = true;
                    break;
                }
            }
            if (!hasContact) {
                contact.setCreateTime(DateUtility.getCurTimeInstance());
                contact.setLastModifyTime(DateUtility.getCurTimeInstance());
                contact.setName(bookingEntity.getName());
                contact.setPhone(bookingEntity.getPhone());
                contact.setEmail(bookingEntity.getEmail());
                contactMapper.add(contact);
            }
        }

        List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, bookingEntity.getStatus());

        BookingEntityExt resultBooking = bookingMapper.getById(bookingEntity.getId());
        BookingBo booking = BookingConverter.toBo(resultBooking);
        booking.setActionList(actions);

        BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(resultBooking.getStatus()), resultBooking, course);
        return booking;
    }

    @Override
    public List<BookingBo> queryBooking(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEUSER.equals(roleName)) {
            if (IdChecker.notEqual(bookingBo.getUserId(), userBo.getId())) {
                throw new ManagerException("对不起，您无权查询他人预订");
            }
            List<BookingEntityExt> bookings = null;
            try {
                bookings = bookingMapper.list(BookingConverter.fromBo(bookingBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预订查询失败，请稍后再试");
            }
            if (bookings == null) {
                return new ArrayList<BookingBo>();
            }
            ArrayList<BookingBo> convertedList = new ArrayList<>();
            for (BookingEntityExt result : bookings) {
                List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, result.getStatus());
                BookingBo booking = BookingConverter.toBo(result);
                booking.setActionList(actions);
                convertedList.add(booking);
            }
            return convertedList;
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                // 因为我们有特殊情况 api中需要提供/booking/{id} 在这种情况下booking bo id明确为一个id值
                if (IdChecker.isEqual(g.getPartnerId(), bookingBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (!isSameGroup) {
                throw new ManagerException("对不起，您无权执行该请求");
            }
            List<BookingEntityExt> bookings = null;
            try {
                bookings = bookingMapper.list(BookingConverter.fromBo(bookingBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预订查询失败，请稍后再试");
            }
            if (bookings == null) {
                return new ArrayList<BookingBo>();
            }
            ArrayList<BookingBo> convertedList = new ArrayList<>();
            for (BookingEntityExt result : bookings) {
                List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, result.getStatus());
                BookingBo booking = BookingConverter.toBo(result);
                booking.setActionList(actions);
                convertedList.add(booking);
            }
            return convertedList;
        } else if (Constant.ROLESYSTEMADMIN.equals(roleName) || Constant.ROLEADMIN.equals(roleName)) {
            List<BookingEntityExt> bookings = null;
            try {
                bookings = bookingMapper.list(BookingConverter.fromBo(bookingBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预订查询失败，请稍后再试");
            }
            if (bookings == null) {
                return new ArrayList<BookingBo>();
            }
            ArrayList<BookingBo> convertedList = new ArrayList<>();
            for (BookingEntityExt result : bookings) {
                List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, result.getStatus());
                BookingBo booking = BookingConverter.toBo(result);
                booking.setActionList(actions);
                convertedList.add(booking);
            }
            return convertedList;
        } else {
            throw new ManagerException("对不起，您无权查询预订");
        }
    }

    @Override
    public List<BookingHistoryBo> queryHistory(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEUSER.equals(roleName)) {
            if (IdChecker.notEqual(bookingHistoryBo.getUserId(), userBo.getId())) {
                throw new ManagerException("对不起，您无权查询他人的预订历史");
            }
            List<BookingHistoryEntityExt> bookingHistorys = null;
            try {
                bookingHistorys = bookingHistoryMapper.list(BookingHistoryConverter.fromBo(bookingHistoryBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预定历史查询失败，请稍后再试");
            }
            if (bookingHistorys == null) {
                return new ArrayList<BookingHistoryBo>();
            }
            ArrayList<BookingHistoryBo> convertedList = new ArrayList<>();
            for (BookingHistoryEntityExt result : bookingHistorys) {
                BookingHistoryBo bookingHistory = BookingHistoryConverter.toBo(result);
                convertedList.add(bookingHistory);
            }
            return convertedList;
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), bookingHistoryBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (!isSameGroup) {
                throw new ManagerException("对不起，您无权执行该请求");
            }
            List<BookingHistoryEntityExt> bookingHistorys = null;
            try {
                bookingHistorys = bookingHistoryMapper.list(BookingHistoryConverter.fromBo(bookingHistoryBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预订历史查询失败，请稍后再试");
            }
            if (bookingHistorys == null) {
                return new ArrayList<BookingHistoryBo>();
            }
            ArrayList<BookingHistoryBo> convertedList = new ArrayList<>();
            for (BookingHistoryEntityExt result : bookingHistorys) {
                BookingHistoryBo bookingHistory = BookingHistoryConverter.toBo(result);
                convertedList.add(bookingHistory);
            }
            return convertedList;
        } else if (Constant.ROLESYSTEMADMIN.equals(roleName) || Constant.ROLEADMIN.equals(roleName)) {
            List<BookingHistoryEntityExt> bookingHistorys = null;
            try {
                bookingHistorys = bookingHistoryMapper.list(BookingHistoryConverter.fromBo(bookingHistoryBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预订历史查询失败，请稍后再试", e);
            }
            if (bookingHistorys == null) {
                return new ArrayList<BookingHistoryBo>();
            }
            ArrayList<BookingHistoryBo> convertedList = new ArrayList<>();
            for (BookingHistoryEntityExt result : bookingHistorys) {
                BookingHistoryBo bookingHistory = BookingHistoryConverter.toBo(result);
                convertedList.add(bookingHistory);
            }
            return convertedList;
        }
        return null;
    }

    /**
     * 所有的关于booking的状态的转移都是通过此入口实现的 不再提供除创建、删除之外的特定方法
     */
    @Override
    public BookingBo transformBookingStatus(BookingBo bookingBo, int operation, UserBo userBo) {
        BookingEntityExt bookingEntityExt = bookingMapper.getById(bookingBo.getId());
        if (bookingEntityExt == null) {
            throw new ManagerException("无效请求参数");
        }
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        String roleName = authManager.getRole(userBo.getId());
        List<Operation> operationList = transformManager.getOperationByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, bookingEntityExt.getStatus());
        Operation op = null;
        if (operationList != null) {
            for (Operation o : operationList) {
                if (o.getOperateCode() == operation) {
                    op = o;
                }
            }
        }
        if (Constant.ROLEUSER.equals(roleName)) {
            // 如果是普通用户
            // 用户修改自己的booking
            if (IdChecker.notEqual(bookingEntityExt.getUserId(), userBo.getId())) {
                throw new ManagerException("对不起，您无权更新他人预订");
            }
            // 按照业务流程修改预订
            if (op == null) {
                throw new ManagerException("对不起，您无法更改当前预订状态");
            }
            // 修改lastmodifytime
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);

            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setOptName(operation);
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setNormal(Constant.BOOKINGNORMAL);
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistory.setPartnerId(bookingEntityExt.getPartnerId());
            // 使用载体bo传递过来的note作为remark
            bookingHistory.setRemark(bookingBo.getNote());
            bookingHistoryMapper.add(bookingHistory);

            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, op.getNextStatus());
            BookingEntityExt resultBooking = bookingMapper.getById(bookingBo.getId());
            BookingBo booking = BookingConverter.toBo(resultBooking);
            booking.setActionList(actions);

            CourseEntityExt course = courseMapper.getInfoById(resultBooking.getCourseId());
            if (course == null) {
                throw new CourseNotFoundException("对不起，无法找到与该预定相关的课程搜索");
            }
            BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(op.getNextStatus()), resultBooking, course);
            return booking;
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            // 如果是合作机构管理员
            // 合作机构只能修改自己本机构的booking
            CourseEntityExt course = courseMapper.getInfoById(bookingBo.getCourseId());
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), course.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (!isSameGroup) {
                throw new ManagerException("对不起，您无权执行该请求");
            }
            // 按照业务流程修改booking
            if (op == null) {
                throw new ManagerException("对不起，您无法更改当前预订状态");
            }
            // 修改lastmodifytoime
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setNormal(Constant.BOOKINGNORMAL);
            bookingHistory.setOptName(operation);
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistory.setPartnerId(bookingEntityExt.getPartnerId());
            // 使用载体bo传递过来的note作为remark
            bookingHistory.setRemark(bookingBo.getNote());
            bookingHistoryMapper.add(bookingHistory);

            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, op.getNextStatus());

            BookingEntityExt resultBooking = bookingMapper.getById(bookingBo.getId());
            // 因为note不会被保存，是临时放入bo中的，所以需要设置一下
            resultBooking.setNote(bookingBo.getNote());
            BookingBo booking = BookingConverter.toBo(resultBooking);
            booking.setActionList(actions);

            BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(op.getNextStatus()), resultBooking, course);
            return booking;

        } else if (Constant.ROLEADMIN.equals(roleName)) {
            // 如果是管理员
            // 按照业务流程修改booking
            if (op == null) {
                throw new ManagerException("对不起，您无法更改当前预订状态");
            }
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setNormal(Constant.BOOKINGNORMAL);
            bookingHistory.setOptName(operation);
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistory.setPartnerId(bookingEntityExt.getPartnerId());
            // 使用载体bo传递过来的note作为remark
            bookingHistory.setRemark(bookingBo.getNote());
            bookingHistoryMapper.add(bookingHistory);

            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, op.getNextStatus());

            BookingEntityExt resultBooking = bookingMapper.getById(bookingBo.getId());
            BookingBo booking = BookingConverter.toBo(resultBooking);
            booking.setActionList(actions);

            // 因为note不会被保存，是临时放入bo中的，所以需要设置一下
            resultBooking.setNote(bookingBo.getNote());

            CourseEntityExt course = courseMapper.getInfoById(resultBooking.getCourseId());
            if (course == null) {
                throw new CourseNotFoundException("对不起，无法找到与该预定相关的课程搜索");
            }
            BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(op.getNextStatus()), resultBooking, course);
            return booking;
        } else if (Constant.ROLESYSTEMADMIN.equals(roleName)) {
            // 超级管理员可以进行任何操作
            // 系统会将本次操作标记为异常
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            List<Operation> allOperation = transformManager.listAll(Constant.STATUSTRANSFORMBOOKING);
            if (allOperation != null) {
                for (Operation o : allOperation) {
                    if (o.getOperateCode() == operation) {
                        op = o;
                        break;
                    }
                }
            }
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setNormal(Constant.BOOKINGUNNORMAL);
            bookingHistory.setOptName(operation);
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistory.setPartnerId(bookingEntityExt.getPartnerId());
            // just for test
            bookingHistory.setEnabled(0);
            bookingHistoryMapper.add(bookingHistory);
            LOGGER.warn(String.format("[Booking]system admin [%d] [%s] booking status from [%d] to [%d] at" + new Date(), userBo.getId(), op.getName(), preStatus, op.getNextStatus()));

            // 添加systemadmin能够进行的后续操作
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, op.getNextStatus());

            BookingEntityExt resultBooking = bookingMapper.getById(bookingBo.getId());
            BookingBo responseBo = BookingConverter.toBo(resultBooking);
            responseBo.setActionList(actions);

            // 因为note不会被保存，是临时放入bo中的，所以需要设置一下
            resultBooking.setNote(bookingBo.getNote());

            CourseEntityExt course = courseMapper.getInfoById(resultBooking.getCourseId());
            if (course == null) {
                throw new CourseNotFoundException("对不起，无法找到与该预定相关的课程搜索");
            }
            BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(op.getNextStatus()), resultBooking, course);
            return responseBo;
        }
        return null;
    }

    // @Override
    public List<BookingBo> queryBookingByUser(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        List<BookingEntityExt> bookings = null;
        bookingBo.setUserId(userBo.getId());
        try {
            bookings = bookingMapper.list(BookingConverter.fromBo(bookingBo), PaginationConverter.fromBo(paginationBo));
        } catch (Exception e) {
            throw new ManagerException("对不起，预订查询失败，请稍后再试");
        }
        if (bookings == null) {
            return new ArrayList<BookingBo>();
        }
        ArrayList<BookingBo> convertedList = new ArrayList<>();
        for (BookingEntityExt result : bookings) {
            List<ActionBo> actions = transformManager.getActionByRoleName(Constant.ROLEUSER, Constant.STATUSTRANSFORMBOOKING, result.getStatus());
            BookingBo booking = BookingConverter.toBo(result);
            booking.setActionList(actions);
            convertedList.add(booking);
        }
        return convertedList;
    }

    // @Override
    public List<BookingBo> queryBookingByPartner(BookingBo bookingBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin || admin[%s] call createTeacher at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), partnerBo.getId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }
        List<BookingEntityExt> bookings = null;
        try {
            bookings = bookingMapper.listByPartnerId(BookingConverter.fromBo(bookingBo), partnerBo.getId(), PaginationConverter.fromBo(paginationBo));
        } catch (Exception e) {
            throw new ManagerException("对不起，按合作机构查询预订失败，请稍后再试");
        }
        if (bookings == null) {
            return new ArrayList<BookingBo>();
        }
        ArrayList<BookingBo> convertedList = new ArrayList<>();
        for (BookingEntityExt result : bookings) {
            List<ActionBo> actions = transformManager.getActionByRoleName(Constant.ROLEUSER, Constant.STATUSTRANSFORMBOOKING, result.getStatus());
            BookingBo booking = BookingConverter.toBo(result);
            booking.setActionList(actions);
            convertedList.add(booking);
        }
        return convertedList;
    }

    @Override
    public List<BookingHistoryBo> queryHistoryByBookingId(BookingHistoryBo bookingHistoryBo, UserBo userBo, PaginationBo paginationBo) {
        BookingEntityExt bookingEntityExt = bookingMapper.getById(bookingHistoryBo.getBookingId());
        List<BookingHistoryEntityExt> bookingHistorys = null;
        if (bookingEntityExt == null) {
            throw new ManagerException("对不起，无法找到对应预订");
        }
        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEUSER.equals(roleName)) {
            if (IdChecker.notEqual(bookingEntityExt.getUserId(), userBo.getId())) {
                throw new ManagerException("对不起，您无权查询他人预订历史");
            }
            try {
                bookingHistorys = bookingHistoryMapper.list(BookingHistoryConverter.fromBo(bookingHistoryBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预订历史查询失败，请稍后再试");
            }
            if (bookingHistorys == null) {
                return new ArrayList<BookingHistoryBo>();
            }
            ArrayList<BookingHistoryBo> convertedList = new ArrayList<>();
            for (BookingHistoryEntityExt result : bookingHistorys) {
                convertedList.add(BookingHistoryConverter.toBo(result));
            }
            return convertedList;
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            CourseEntityExt course = courseMapper.getById(bookingEntityExt.getCourseId());
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), course.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (isSameGroup == false) {
                throw new ManagerException("对不起，您无权执行该请求");
            }
            try {
                bookingHistorys = bookingHistoryMapper.list(BookingHistoryConverter.fromBo(bookingHistoryBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预订历史查询失败，请稍后再试");
            }
            if (bookingHistorys == null) {
                return new ArrayList<BookingHistoryBo>();
            }
            ArrayList<BookingHistoryBo> convertedList = new ArrayList<>();
            for (BookingHistoryEntityExt result : bookingHistorys) {
                convertedList.add(BookingHistoryConverter.toBo(result));
            }
            return convertedList;
        } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            try {
                bookingHistorys = bookingHistoryMapper.list(BookingHistoryConverter.fromBo(bookingHistoryBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("对不起，预订历史查询失败，请稍后再试");
            }
            if (bookingHistorys == null) {
                return new ArrayList<BookingHistoryBo>();
            }
            ArrayList<BookingHistoryBo> convertedList = new ArrayList<>();
            for (BookingHistoryEntityExt result : bookingHistorys) {
                convertedList.add(BookingHistoryConverter.toBo(result));
            }
            return convertedList;
        }
        return null;
    }

    @Override
    public String changeBookingStatusToPayed(int bookingId, String trade_no) {
        BookingEntityExt booking = bookingMapper.getById(bookingId);
        BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
        int preStatus = booking.getStatus();
        if (BookingEnums.Status.ONLINEPENDINGPAYMENT.code != preStatus) {
            bookingHistory.setNormal(Constant.BOOKINGUNNORMAL);
            LOGGER.error(String.format("[pay booking]booking [%d] is no need to pay, but pay it", booking.getId()));
        } else {
            bookingHistory.setNormal(Constant.BOOKINGNORMAL);
        }
        booking.setStatus(BookingEnums.Status.ONLINEPAYED.code);
        booking.setLastModifyTime(DateUtility.getCurTimeInstance());
        try {
            bookingMapper.update(booking);
        } catch (Exception e) {
            LOGGER.error(String.format("[pay booking] try to log booking history booking [%d] status to payed but failed", booking.getId()));
            throw new ManagerException("对不起，预订状态更改失败，请稍后再试");
        } finally {
            LOGGER.info(String.format("[pay booking] try to change booking [%d] status to payed", booking.getId()));
        }
        // 记录下本次booking状态改变
        bookingHistory.setBookingId(booking.getId());
        bookingHistory.setUserId(booking.getUserId());
        bookingHistory.setPreStatus(preStatus);
        // 记录下支付宝流水号
        bookingHistory.setRemark(trade_no);
        bookingHistory.setPostStatus(BookingEnums.Status.ONLINEPAYED.code);
        bookingHistory.setOptName(Constant.BOOKINGOPERATEONLINEPAYSUCCESS);
        bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
        bookingHistory.setPartnerId(booking.getPartnerId());
        try {
            bookingHistoryMapper.add(bookingHistory);
        } catch (Exception e) {
            LOGGER.error(String.format("[pay booking] try to log booking history booking [%d] status to payed but failed", booking.getId()));
            throw new ManagerException("对不起，预订历史记录创建失败，请稍后再试");
        } finally {
            LOGGER.info(String.format("[pay booking] try to change booking [%d] status to payed", booking.getId()));
        }
        return Constant.SUCCESS;
    }

    @Override
    public String verify(String notify_id) {
        return AlipayNotify.Verify(notify_id);
    }

    @Override
    public String buildFormForGet(String out_trade_no, String subject, String total_fee, String type) {
        return AlipaySubmit.buildFormForGet(out_trade_no, subject, total_fee, type);
    }

    @Override
    public String buildFormForPost(String out_trade_no, String subject, String total_fee) {
        return AlipaySubmit.buildFormForPost(out_trade_no, subject, total_fee);
    }

    @Override
    public int queryBookingTotal(BookingBo bookingBo, UserBo userBo) {
        return bookingMapper.getListCount(BookingConverter.fromBo(bookingBo));
    }

    @Override
    public int queryHistoryTotal(BookingHistoryBo bookingHistoryBo, UserBo userBo) {
        return bookingHistoryMapper.getListCount(BookingHistoryConverter.fromBo(bookingHistoryBo));
    }

    @Override
    public int queryHistoryByBookingIdTotal(BookingHistoryBo bookingHistoryBo, UserBo userBo) {
        return bookingHistoryMapper.getListCount(BookingHistoryConverter.fromBo(bookingHistoryBo));
    }

    @Override
    public BookingBo queryBookingById(int id, UserBo userBo) {
        String roleName = authManager.getRole(userBo.getId());
        BookingEntityExt booking = null;
        try {
            booking = bookingMapper.getById(id);
        } catch (Exception e) {
            throw new ManagerException("对不起，预订查询失败，请稍后再试");
        }
        if (booking == null) {
            throw new ManagerException("对不起，无法找到ID为" + id + "的预订");
        }
        if (Constant.ROLEUSER.equals(roleName)) {
            if (IdChecker.notEqual(booking.getUserId(), userBo.getId())) {
                throw new ManagerException("对不起，您无权查询他人的预订");
            }

            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, booking.getStatus());
            BookingBo bookingBo = BookingConverter.toBo(booking);
            bookingBo.setActionList(actions);
            return bookingBo;
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                // 因为我们有特殊情况 api中需要提供/booking/{id} 在这种情况下booking bo id明确为一个id值
                if (IdChecker.isEqual(g.getPartnerId(), booking.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (!isSameGroup) {
                throw new ManagerException("对不起，您无权执行该请求");
            }
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, booking.getStatus());
            BookingBo bookingBo = BookingConverter.toBo(booking);
            bookingBo.setActionList(actions);
            return bookingBo;
        } else if (Constant.ROLESYSTEMADMIN.equals(roleName) || Constant.ROLEADMIN.equals(roleName)) {
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, booking.getStatus());
            BookingBo bookingBo = BookingConverter.toBo(booking);
            bookingBo.setActionList(actions);
            return bookingBo;
        } else {
            throw new ManagerException("对不起，当前用户无权查询预订");
        }
    }

}
