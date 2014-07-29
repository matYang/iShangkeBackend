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
import com.ishangke.edunav.common.enums.BookingEnums;
import com.ishangke.edunav.common.enums.CouponEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.BookingHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.ContactEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.OrderEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.UserEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.OrderEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.async.dispatcher.BookingNotificationDispatcher;
import com.ishangke.edunav.manager.caiwu.alipay.AlipayNotify;
import com.ishangke.edunav.manager.caiwu.alipay.AlipaySubmit;
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
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private UserEntityExtMapper userMapper;

    @Autowired
    private CouponEntityExtMapper couponMapper;

    @Autowired
    private OrderEntityExtMapper orderMapper;

    private double consumeCoupons(final BookingBo bookingBo, UserBo userBo) {
        if (bookingBo == null || bookingBo.getCashbackAmount() < 0.1d || bookingBo.getUserId() <= 0) {
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
            throw new ManagerException("consumeCoupons failed when searching for coupons");
        }
        if (couponResults == null || couponResults.size() == 0) {
            return 0.0;
        }

        // remove used coupons and expired coupons
        for (int i = couponResults.size() - 1; i >= 0; i--) {
            if (couponResults.get(i).getBalance() < 0.01d || couponResults.get(i).getExpiryTime().before(DateUtility.getCurTime())) {
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
        for (int i = 0; i < couponResults.size() && currentTotal < (targetTotal - 0.01d); i++) {
            CouponEntityExt coupon = couponResults.get(i);
            if (currentTotal + coupon.getBalance() < (targetTotal - 0.01d)) {
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
    public BookingBo createBookingByUser(BookingBo bookingBo, CommentBookingBo commentBookingBo, UserBo userBo) {
        String roleName = authManager.getRole(userBo.getId());
        BookingEntityExt bookingEntity = BookingConverter.fromBo(bookingBo);
        CourseEntityExt course = courseMapper.getById(bookingEntity.getCourseId());
        if (!Constant.ROLEUSER.equals(roleName)) {
            throw new ManagerException("only user can create booking");
        }
        if (bookingEntity.getUserId() != userBo.getId()) {
            throw new ManagerException("cannot create booking for others");
        }
        if (bookingEntity.getName() == null || "".equals(bookingEntity.getName()) || bookingEntity.getPhone() == null || "".equals(bookingEntity.getPhone())) {
            throw new ManagerException("information is bad");
        }
        // 查看此课程是否属于上架状态
        if (course == null || Constant.COURSESTATUSONLINED != course.getStatus()) {
            throw new ManagerException("course cannot be booed now");
        }
        // 查看课程现价与发过来的价格是否一致，如果不一致则不能创建booking
        if (course.getPrice() != bookingEntity.getPrice()) {
            throw new ManagerException("the price is no longer equal");
        }
        // 传递过来的cashback必须小于等于course中定义的cashback
        if (bookingEntity.getCashbackAmount() > course.getCashback()) {
            throw new ManagerException("cashback cannot more than cashback defined in course");
        }
        // booking不同的type（支付方式）决定了booking的初始化状态
        int bookingOpt = 0;
        if (bookingEntity.getType() == Constant.BOOKINGTYPEOFFLINE) {
            // 在线支付订单
            bookingEntity.setStatus(Constant.BOOKINGSTATUSONLINEPENDINGPAYMENT);
            bookingOpt = Constant.BOOKINGOPERATIONONLINESUBMITBOOKING;

        } else if (bookingEntity.getType() == Constant.BOOKINGTYPEONLINE) {
            // 线下支付订单
            bookingEntity.setStatus(Constant.BOOKINGSTATUSOFFLINEBOOKED);
            bookingOpt = Constant.BOOKINGOPERATIONOFFLINESUBMITBOOKING;
        } else if (false) {
            // todo 其他类型订单
        } else {
            throw new ManagerException("unknown booking type");
        }
        // 设置booking的partner id
        // bookingBo.setPartnerId(course.getPartnerId());
        // 设置bookingBo中的course template id
        // 因为我们设计的时候，将course template id也放入了booking中，这里需要注意一下，不然可能会出错
        bookingBo.setCourseTemplateId(course.getCourseTemplateId());

        // Use coupons
        double calculatedCachbask = consumeCoupons(bookingBo, userBo);
        if (calculatedCachbask >= 0.1) {
            bookingBo.setCashbackAmount(calculatedCachbask);
        }

        // 插入booking
        int result = 0;
        try {
            bookingEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            bookingEntity.setCreateTime((DateUtility.getCurTimeInstance()));
            result = bookingMapper.add(bookingEntity);
        } catch (Exception e) {
            throw new ManagerException("add booking failed");
        }
        if (result > 0) {
            bookingBo.setId(bookingEntity.getId());
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingEntity.getId());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistory.setNormal(Constant.BOOKINGNORMAL);
            bookingHistory.setOptName(bookingOpt);
            bookingHistory.setPostStatus(Constant.BOOKINGSTATUSONLINEPENDINGPAYMENT);
            bookingHistory.setPreStatus(null);
            bookingHistory.setRemark(commentBookingBo.getComment());
            bookingHistory.setUserId(userBo.getId());
            bookingHistoryMapper.add(bookingHistory);
        } else {
            throw new ManagerException("add booking failed");
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
                if (c.getName().equals(userBo.getName()) && c.getPhone().equals(userBo.getPhone())) {
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
        BookingBo booking = BookingConverter.toBo(bookingMapper.getById(bookingEntity.getId()));
        booking.setActionList(actions);

        return booking;
    }

    @Override
    public List<BookingBo> queryBooking(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        if (!authManager.isAdmin(userBo.getId()) && !authManager.isSystemAdmin(userBo.getId())) {
            throw new ManagerException("current cannot do this !");
        }
        String roleName = authManager.getRole(userBo.getId());
        List<BookingEntityExt> bookings = null;
        try {
            bookings = bookingMapper.list(BookingConverter.fromBo(bookingBo), PaginationConverter.fromBo(paginationBo));
        } catch (Exception e) {
            throw new ManagerException("query booking failed for user " + userBo.getId());
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
    }

    @Override
    public List<BookingHistoryBo> queryHistory(BookingHistoryBo bookingHistoryBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 所有的关于booking的状态的转移都是通过此入口实现的 不再提供除创建、删除之外的特定方法
     */
    @Override
    public BookingBo transformBookingStatus(BookingBo bookingBo, CommentBookingBo commentBookingBo, int operation, UserBo userBo) {
        BookingEntityExt bookingEntityExt = bookingMapper.getById(bookingBo.getId());
        if (bookingEntityExt == null) {
            throw new ManagerException("booking is nolonger exits");
        }
        if (userBo == null) {
            throw new ManagerException("User not specified");
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
            if (bookingEntityExt.getUserId() != userBo.getId()) {
                throw new ManagerException("cannot modify other's booking");
            }
            // 按照业务流程修改订单
            if (op == null) {
                throw new ManagerException("cannot modify current booking status");
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
            bookingHistoryMapper.add(bookingHistory);

            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, op.getNextStatus());
            BookingEntityExt resultBooking = bookingMapper.getById(bookingBo.getId());
            BookingBo booking = BookingConverter.toBo(resultBooking);
            booking.setActionList(actions);

            CourseEntityExt course = courseMapper.getById(resultBooking.getCourseId());
            if (course == null) {
                throw new CourseNotFoundException("Course not found for booking");
            }
            BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(op.getNextStatus()), resultBooking, commentBookingBo, course);
            return booking;
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            // 如果是合作商管理员
            // 合作商只能修改自己本机构的booking
            CourseEntityExt course = courseMapper.getById(bookingBo.getCourseId());
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("unlogin user");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (g.getPartnerId().equals(course.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (!isSameGroup) {
                throw new ManagerException("cannot modify other's booking");
            }
            // 按照业务流程修改booking
            if (op == null) {
                throw new ManagerException("cannot modify current booking status");
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
            bookingHistoryMapper.add(bookingHistory);

            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, op.getNextStatus());

            BookingEntityExt resultBooking = bookingMapper.getById(bookingBo.getId());
            BookingBo booking = BookingConverter.toBo(resultBooking);
            booking.setActionList(actions);

            BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(op.getNextStatus()), resultBooking, commentBookingBo, course);
            return booking;

        } else if (Constant.ROLEADMIN.equals(roleName)) {
            // 如果是管理员
            // 按照业务流程修改booking
            if (op == null) {
                throw new ManagerException("cannot modify current booking status");
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
            bookingHistoryMapper.add(bookingHistory);

            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, op.getNextStatus());

            BookingEntityExt resultBooking = bookingMapper.getById(bookingBo.getId());
            BookingBo booking = BookingConverter.toBo(resultBooking);
            booking.setActionList(actions);

            CourseEntityExt course = courseMapper.getById(resultBooking.getCourseId());
            if (course == null) {
                throw new CourseNotFoundException("Course not found for booking");
            }
            BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(op.getNextStatus()), resultBooking, commentBookingBo, course);
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
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            // just for test
            bookingHistory.setEnabled(0);
            bookingHistoryMapper.add(bookingHistory);
            LOGGER.warn(String.format("[Booking]system admin [%d] [%s] booking status from [%d] to [%d] at" + new Date(), userBo.getId(), op.getName(), preStatus, op.getNextStatus()));

            BookingEntityExt resultBooking = bookingMapper.getById(bookingBo.getId());
            BookingBo responseBo = BookingConverter.toBo(resultBooking);

            CourseEntityExt course = courseMapper.getById(resultBooking.getCourseId());
            if (course == null) {
                throw new CourseNotFoundException("Course not found for booking");
            }
            BookingNotificationDispatcher.sendNotification(BookingEnums.Status.fromInt(op.getNextStatus()), resultBooking, commentBookingBo, course);
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
            throw new ManagerException("query booking failed for user " + userBo.getId());
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
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[TeacherManagerImpl]system admin || admin[%s] call createTeacher at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (g.getPartnerId().equals(partnerBo.getId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }
        List<BookingEntityExt> bookings = null;
        try {
            bookings = bookingMapper.listByPartnerId(BookingConverter.fromBo(bookingBo), partnerBo.getId(), PaginationConverter.fromBo(paginationBo));
        } catch (Exception e) {
            throw new ManagerException("query booking by partnerid failed for user " + userBo.getId());
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
            throw new ManagerException("booking is nolonger exits");
        }
        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEUSER.equals(roleName)) {
            if (!bookingEntityExt.getUserId().equals(userBo.getId())) {
                throw new ManagerException("cannot query other's booking history");
            }
            try {
                bookingHistorys = bookingHistoryMapper.list(BookingHistoryConverter.fromBo(bookingHistoryBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("query booking history failed");
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
                if (g.getPartnerId().equals(course.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (isSameGroup == false) {
                throw new ManagerException("cannot query other partner's booking history");
            }
            try {
                bookingHistorys = bookingHistoryMapper.list(BookingHistoryConverter.fromBo(bookingHistoryBo), PaginationConverter.fromBo(paginationBo));
            } catch (Exception e) {
                throw new ManagerException("query booking history failed");
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
                throw new ManagerException("query booking history failed");
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

    public static void main(String[] args) {
        Double a = 0.1234560023;
        double b = 0.123456002300000000000;
        System.out.println(a.equals(b));
    }

    @Override
    public String changeBookingStatusToPayed(int orderId) {
        OrderEntityExt order = orderMapper.getById(orderId);
        BookingEntityExt booking = bookingMapper.getById(order.getBookingId());
        BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
        int preStatus = booking.getStatus();
        if (BookingEnums.Status.ONLINEPENDINGPAYMENT.code != preStatus) {
            bookingHistory.setNormal(Constant.BOOKINGUNNORMAL);
            LOGGER.warn(String.format("[pay booking]booking [%d] is no need to pay, but order [%d] pay it", booking.getId(), order.getId()));
        } else {
            bookingHistory.setNormal(Constant.BOOKINGNORMAL);
        }
        booking.setStatus(BookingEnums.Status.ONLINEPAYED.code);
        try {
            booking.setLastModifyTime(DateUtility.getCurTimeInstance());
            bookingMapper.update(booking);
        } catch (Exception e) {
            throw new ManagerException("change booking status failed");
        } finally {
            LOGGER.error(String.format("[pay booking]order [%d] try to pay booking [%d] but failed", order.getId(), booking.getId()));
        }
        bookingHistory.setBookingId(booking.getId());
        bookingHistory.setUserId(booking.getUserId());
        bookingHistory.setPreStatus(preStatus);
        bookingHistory.setPostStatus(BookingEnums.Status.ONLINEPAYED.code);
        bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
        try {
            bookingHistoryMapper.add(bookingHistory);
        } catch (Exception e) {
            throw new ManagerException("create booking history failed");
        }
        return Constant.SUCCESS;
    }

    @Override
    public String verify(String notify_id) {
        return AlipayNotify.Verify(notify_id);
    }

    @Override
    public String buildFormForGet(String subject, String out_trade_no, String total_fee) {
        return AlipaySubmit.buildFormForGet(out_trade_no, subject, total_fee);
    }

}
