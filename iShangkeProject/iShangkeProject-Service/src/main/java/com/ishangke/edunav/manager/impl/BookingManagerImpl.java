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
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.CommentBookingBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.BookingHistoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.ContactEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.BookingManager;
import com.ishangke.edunav.manager.CouponManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.converter.BookingConverter;
import com.ishangke.edunav.manager.converter.BookingHistoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
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

    @Override
    public BookingBo createBookingByUser(BookingBo bookingBo, CommentBookingBo commentBookingBo, UserBo userBo) {
        String roleName = authManager.getRole(userBo.getId());
        if (!Constant.ROLEUSER.equals(roleName)) {
            throw new ManagerException("only user can create booking");
        }
        if (bookingBo.getUserId() != userBo.getId()) {
            throw new ManagerException("cannot create booking for others");
        }
        if (bookingBo.getName() == null || "".equals(bookingBo.getName()) || bookingBo.getPhone() == null || "".equals(bookingBo.getPhone())) {
            throw new ManagerException("information is bad");
        }
        // 查看此课程是否属于上架状态
        CourseEntityExt course = courseMapper.getById(bookingBo.getCourseId());
        if (course == null || Constant.COURSESTATUSONLINED != course.getStatus()) {
            throw new ManagerException("course cannot be booed now");
        }
        // 查看课程现价与发过来的价格是否一致，如果不一致则不能创建booking
//        if (course.getPrice() != bookingBo.get) {
//
//        }
        // 传递过来的cashback必须小于等于course中定义的cashback
        if (bookingBo.getCashbackAmount() > course.getCashback()) {
            throw new ManagerException("cashback cannot more than cashback defined in course");
        }
        // booking不同的type（支付方式）决定了booking的初始化状态
        int bookingOpt = 0;
        if (bookingBo.getType() == Constant.BOOKINGTYPEOFFLINE) {
            // 在线支付订单
            bookingBo.setStatus(Constant.BOOKINGSTATUSONLINEPENDINGPAYMENT);
            bookingOpt = Constant.BOOKINGOPERATIONONLINESUBMITBOOKING;
            
        } else if (bookingBo.getType() == Constant.BOOKINGTYPEONLINE) {
            // 线下支付订单
            bookingBo.setStatus(Constant.BOOKINGSTATUSOFFLINEBOOKED);
            bookingOpt = Constant.BOOKINGOPERATIONOFFLINESUBMITBOOKING;
        } else if (true) {
            // todo 其他类型订单
        } else {
            throw new ManagerException("unknown booking type");
        }
        // 插入booking
        int result = 0;
        try {
            result = bookingMapper.add(BookingConverter.fromBo(bookingBo));
        } catch (Exception e) {
            throw new ManagerException("add booking failed");
        }
        if (result > 0) {
            bookingBo.setId(result);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(result);
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
            contact.setName(bookingBo.getName());
            contact.setPhone(bookingBo.getPhone());
            contact.setEmail(bookingBo.getEmail());
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
                contact.setName(bookingBo.getName());
                contact.setPhone(bookingBo.getPhone());
                contact.setEmail(bookingBo.getEmail());
                contactMapper.add(contact);
            }
        }
        return bookingBo;
    }

    @Override
    public List<BookingBo> queryBooking(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        if (!authManager.isAdmin(userBo.getId()) && !authManager.isSystemAdmin(userBo.getId())) {
            throw new ManagerException("current cannot do this !");
        }
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
            convertedList.add(BookingConverter.toBo(result));
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
    public BookingBo transformBookingStatus(BookingBo bookingBo, int operation, UserBo userBo) {
        BookingEntityExt bookingEntityExt = bookingMapper.getById(bookingBo.getId());
        if (bookingEntityExt == null) {
            throw new ManagerException("booking is nolonger exits");
        }
        String roleName = authManager.getRole(userBo.getId());
        List<Operation> operationList = transformManager.getOperationByRoleName(roleName, Constant.STATUSTRANSFORMBOOKING, bookingEntityExt.getStatus());
        Operation op = null;
        for (Operation o : operationList) {
            if (o.getOperateCode() == operation) {
                op = o;
            }
        }
        if (Constant.ROLEUSER.equals(roleName)) {
            // 如果是普通用户
            // 用户修改自己的booking
            if (bookingEntityExt.getUserId() != userBo.getId()) {
                throw new ManagerException("cannot modift other's booking");
            }
            // 按照业务流程修改订单
            if (op == null) {
                throw new ManagerException("cannot modift current booking status");
            }
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
            return (BookingConverter.toBo(bookingMapper.getById(bookingBo.getId())));
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            // 如果是合作商管理员
            // 合作商只能修改自己本机构的booking
            CourseEntityExt course = courseMapper.getInfoById(bookingBo.getCourseId());
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
                throw new ManagerException("cannot modift other's booking");
            }
            // 按照业务流程修改booking
            if (op == null) {
                throw new ManagerException("cannot modift current booking status");
            }
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            bookingEntityExt.setStatus(op.getNextStatus());
            bookingMapper.update(bookingEntityExt);
            BookingHistoryEntityExt bookingHistory = new BookingHistoryEntityExt();
            bookingHistory.setBookingId(bookingBo.getId());
            bookingHistory.setNormal(Constant.BOOKINGNORMAL);
            bookingHistory.setOptName(operation);
            // just for test
            bookingHistory.setEnabled(0);
            bookingHistory.setUserId(userBo.getId());
            bookingHistory.setPreStatus(preStatus);
            bookingHistory.setPostStatus(op.getNextStatus());
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistoryMapper.add(bookingHistory);
            return (BookingConverter.toBo(bookingMapper.getById(bookingBo.getId())));
        } else if (Constant.ROLEADMIN.equals(roleName)) {
            // 如果是管理员
            // 按照业务流程修改booking
            if (op == null) {
                throw new ManagerException("cannot modift current booking status");
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
            // just for test
            bookingHistory.setEnabled(0);
            bookingHistory.setCreateTime(DateUtility.getCurTimeInstance());
            bookingHistoryMapper.add(bookingHistory);
            return (BookingConverter.toBo(bookingMapper.getById(bookingBo.getId())));
        } else if (Constant.ROLESYSTEMADMIN.equals(roleName)) {
            // 超级管理员可以进行任何操作
            // 系统会将本次操作标记为异常
            bookingEntityExt.setLastModifyTime(DateUtility.getCurTimeInstance());
            int preStatus = bookingEntityExt.getStatus();
            List<Operation> allOperation = transformManager.listAll(Constant.STATUSTRANSFORMBOOKING);
            for (Operation o : allOperation) {
                if (o.getOperateCode() == operation) {
                    op = o;
                    break;
                }
            }
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
            return (BookingConverter.toBo(bookingMapper.getById(bookingBo.getId())));
        }
        return null;
    }

    @Override
    public List<BookingBo> queryBookingByUser(BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        List<BookingEntityExt> bookings = null;
        try {
            bookings = bookingMapper.listByUserId(BookingConverter.fromBo(bookingBo), UserConverter.fromBo(userBo), PaginationConverter.fromBo(paginationBo));
        } catch (Exception e) {
            throw new ManagerException("query booking failed for user " + userBo.getId());
        }
        if (bookings == null) {
            return new ArrayList<BookingBo>();
        }
        ArrayList<BookingBo> convertedList = new ArrayList<>();
        for (BookingEntityExt result : bookings) {
            convertedList.add(BookingConverter.toBo(result));
        }
        return convertedList;
    }

    @Override
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
            bookings = bookingMapper.listByPartnerId(BookingConverter.fromBo(bookingBo), PartnerConverter.fromBo(partnerBo), PaginationConverter.fromBo(paginationBo));
        } catch (Exception e) {
            throw new ManagerException("query booking by partnerid failed for user " + userBo.getId());
        }
        if (bookings == null) {
            return new ArrayList<BookingBo>();
        }
        ArrayList<BookingBo> convertedList = new ArrayList<>();
        for (BookingEntityExt result : bookings) {
            convertedList.add(BookingConverter.toBo(result));
        }
        return convertedList;
    }

    @Override
    public List<BookingHistoryBo> queryHistoryByBookingId(BookingHistoryBo bookingHistoryBo, BookingBo bookingBo, UserBo userBo, PaginationBo paginationBo) {
        BookingEntityExt bookingEntityExt = bookingMapper.getById(bookingBo.getId());
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
                bookingHistorys = bookingHistoryMapper.listByBookingId(BookingHistoryConverter.fromBo(bookingHistoryBo), BookingConverter.fromBo(bookingBo), PaginationConverter.fromBo(paginationBo));
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
            CourseEntityExt course = courseMapper.getById(bookingBo.getCourseId());
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
                bookingHistorys = bookingHistoryMapper.listByBookingId(BookingHistoryConverter.fromBo(bookingHistoryBo), BookingConverter.fromBo(bookingBo), PaginationConverter.fromBo(paginationBo));
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
                bookingHistorys = bookingHistoryMapper.listByBookingId(BookingHistoryConverter.fromBo(bookingHistoryBo), BookingConverter.fromBo(bookingBo), PaginationConverter.fromBo(paginationBo));
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
}
